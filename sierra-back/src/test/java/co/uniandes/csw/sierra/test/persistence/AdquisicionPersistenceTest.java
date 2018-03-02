/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;

import co.edu.uniandes.csw.sierra.entities.AdquisicionEntity;
import co.edu.uniandes.csw.sierra.persistence.AdquisicionPersistence;
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
 * @author jd.zambrano
 */
@RunWith(Arquillian.class)
public class AdquisicionPersistenceTest {
    
    /**
     * @return Devuelve el jar que se va a desplegar en glassfish 
     */
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AdquisicionEntity.class.getPackage())
                .addPackage(AdquisicionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private AdquisicionPersistence adquisicionPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<AdquisicionEntity> data = new ArrayList<>();
    
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
            utx.begin();
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
        em.createQuery("delete from AdquisicionEntity").executeUpdate();
    }
    
    /**
     * crea nuevos datos para la prueba
     */
    private void insertData(){
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i < 10; i++){
            AdquisicionEntity ent = factory.manufacturePojo(AdquisicionEntity.class);
            em.persist(ent);
            data.add(ent);
        }
    }
    
    
    /**
     * Prueba para crear una Adquisicion
     */
    @Test
    public void createAdquisicionTest(){
        PodamFactory factory = new PodamFactoryImpl();
        AdquisicionEntity newEntity = factory.manufacturePojo(AdquisicionEntity.class);
        AdquisicionEntity result = adquisicionPersistence.create(newEntity);

        Assert.assertNotNull(result);

        AdquisicionEntity entity = em.find(AdquisicionEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        
    }
    
    /**
     * Prueba que se pueden recuperar los objetos de la base de datos
     */
    @Test
    public void getAdquisicionesTest(){
        List<AdquisicionEntity> list =  adquisicionPersistence.findAll();
        //Revisa que ambas listas tengan el mismo tamano
        Assert.assertEquals(data.size(), list.size());
        for(AdquisicionEntity ent: list){
            boolean fand= false;
            //Revisa que ambas adquisiciones tengan el mismo ID
            for(AdquisicionEntity ent2: data){
                if(ent.getId().equals(ent2.getId())){
                    fand = true;
                }
            }
            Assert.assertTrue(fand);
        }
    }
    /**
     * test para obtener una Adquisicion en especifico
     */
    @Test
    public void getAdquisicionTest(){
        AdquisicionEntity ent = data.get(0);
        AdquisicionEntity ent2 = adquisicionPersistence.find(ent.getId());
        Assert.assertNotNull(ent2);
        Assert.assertEquals(ent.getName(), ent2.getName());
        Assert.assertEquals(ent.getFecha(), ent2.getFecha());
    }

    /**
     * Prueba para borrar una Adquisicion
     */
    @Test
    public void deleteAdquisicionTest(){
        AdquisicionEntity ent = data.get(0);
        adquisicionPersistence.delete(ent.getId());
        AdquisicionEntity notFound = em.find(AdquisicionEntity.class, ent.getId());
        Assert.assertNull(notFound);
        
    }
    /**
     * Test para actualizar una Adquisicion
     */
    @Test
    public void updateAdquisicionTest(){
        AdquisicionEntity ent = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AdquisicionEntity newEnt = factory.manufacturePojo(AdquisicionEntity.class);
        newEnt.setId(ent.getId());
        adquisicionPersistence.update(newEnt);
        AdquisicionEntity retrievedEnt = em.find(AdquisicionEntity.class, ent.getId());
        Assert.assertEquals(newEnt.getName(), retrievedEnt.getName());
        
    }
    
    
}
