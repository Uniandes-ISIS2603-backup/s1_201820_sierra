/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;

import co.edu.uniandes.csw.sierra.entities.MascotaVentaEntity;
import co.edu.uniandes.csw.sierra.persistence.MascotaVentaPersistence;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
/**
 *
 * @author Juan David Zambrano
 */
@RunWith(Arquillian.class)
public class MascotaVentaPersistenceTest {
    
    /**
     * @return Devuelve el jar que se va a desplegar en glassfish 
     */
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MascotaVentaEntity.class.getPackage())
                .addPackage(MascotaVentaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private MascotaVentaPersistence mascotaVentaPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    
    private List<MascotaVentaEntity> data = new ArrayList<>();
    
    /**
     * prepara los datos para la prueba
     */
    @Before
    public void setUp(){
        try{
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        }catch (Exception e){
            e.printStackTrace();
            try{
                utx.rollback();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    /**
     * limpia las tablas pertientes
     */
    private void clearData(){
        em.createQuery("delete from MascotaVentaEntity").executeUpdate();
    }
    
    /**
     * crea nuevos datos para la prueba
     */
    private void insertData(){
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i < 10; i++){
            MascotaVentaEntity ent = factory.manufacturePojo(MascotaVentaEntity.class);
            em.persist(ent);
            data.add(ent);
        }
    }
    
    
    /**
     * Prueba para crear una MascotaVenta
     */
    @Test
    public void createMascotaVentaTest(){
        PodamFactory factory = new PodamFactoryImpl();
        MascotaVentaEntity newEntity = factory.manufacturePojo(MascotaVentaEntity.class);
        MascotaVentaEntity result = mascotaVentaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        MascotaVentaEntity entity = em.find(MascotaVentaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getImagen(), entity.getImagen());
        
    }
    
    /**
     * Prueba que se pueden recuperar los objetos de la base de datos
     */
    @Test
    public void getMascotaVentaesTest(){
        List<MascotaVentaEntity> list =  mascotaVentaPersistence.findAll();
        //Revisa que ambas listas tengan el mismo tamano
        Assert.assertEquals(data.size(), list.size());
        for(MascotaVentaEntity ent: list){
            boolean fand= false;
            //Revisa que ambas mascotaVentaes tengan el mismo ID
            for(MascotaVentaEntity ent2: data){
                if(ent.getId().equals(ent2.getId())){
                    fand = true;
                }
            }
            Assert.assertTrue(fand);
        }
    }
    /**
     * test para obtener una MascotaVenta en especifico
     */
    @Test
    public void getMascotaVentaTest(){
        MascotaVentaEntity ent = data.get(0);
        MascotaVentaEntity ent2 = mascotaVentaPersistence.find(ent.getId());
        Assert.assertNotNull(ent2);
        Assert.assertEquals(ent.getName(), ent2.getName());
        Assert.assertEquals(ent.getImagen(), ent2.getImagen());
    }

    /**
     * Prueba para borrar una MascotaVenta
     */
    @Test
    public void deleteMascotaVentaTest(){
        MascotaVentaEntity ent = data.get(0);
        mascotaVentaPersistence.delete(ent.getId());
        MascotaVentaEntity notFound = em.find(MascotaVentaEntity.class, ent.getId());
        Assert.assertNull(notFound);
        
    }
    /**
     * Test para actualizar una MascotaVenta
     */
    @Test
    public void updateMascotaVentaTest(){
        MascotaVentaEntity ent = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        MascotaVentaEntity newEnt = factory.manufacturePojo(MascotaVentaEntity.class);
        newEnt.setId(ent.getId());
        mascotaVentaPersistence.update(newEnt);
        MascotaVentaEntity retrievedEnt = em.find(MascotaVentaEntity.class, ent.getId());
        Assert.assertEquals(newEnt.getName(), retrievedEnt.getName());
        
    }
    
    
}

