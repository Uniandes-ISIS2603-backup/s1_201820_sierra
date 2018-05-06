/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;


import co.edu.uniandes.csw.sierra.entities.RazaEntity;
import co.edu.uniandes.csw.sierra.persistence.RazaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author rj.gonzalez10
 */
@RunWith(Arquillian.class)
public class RazaPersistenceTest {
      
    /**
     * @return Devuelve el jar que se va a desplegar en glassfish 
     */
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RazaEntity.class.getPackage())
                .addPackage(RazaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private RazaPersistence razaPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    
    private List<RazaEntity> data = new ArrayList<>();
    
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
        em.createQuery("delete from RazaEntity").executeUpdate();
    }
    
    /**
     * crea nuevos datos para la prueba
     */
    private void insertData(){
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i < 10; i++){
            RazaEntity ent = factory.manufacturePojo(RazaEntity.class);
            em.persist(ent);
            data.add(ent);
        }
    }
    
    
    /**
     * Prueba para crear una Raza
     */
    @Test
    public void createRazaTest(){
        PodamFactory factory = new PodamFactoryImpl();
        RazaEntity newEntity = factory.manufacturePojo(RazaEntity.class);
        RazaEntity result = razaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        RazaEntity entity = em.find(RazaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getCaracteristicas(), entity.getCaracteristicas());
        Assert.assertEquals(newEntity.getCuidados(), entity.getCuidados());
        
        
    }
    
    /**
     * Prueba que se pueden recuperar los objetos de la base de datos
     */
    @Test
    public void getRazasTest(){
        List<RazaEntity> list =  razaPersistence.findAll();
        //Revisa que ambas listas tengan el mismo tamano
        Assert.assertEquals(data.size(), list.size());
        for(RazaEntity ent: list){
            boolean fand= false;
            //Revisa que ambas RazaEntity tengan el mismo ID
            for(RazaEntity ent2: data){
                if(ent.getId().equals(ent2.getId())){
                    fand = true;
                }
            }
            Assert.assertTrue(fand);
        }
    }
    /**
     * test para obtener una Raza en especifico
     */
    @Test
    public void getRazaTest(){
        RazaEntity ent = data.get(0);
        RazaEntity ent2 = razaPersistence.find(ent.getId());
        Assert.assertNotNull(ent2);
        Assert.assertEquals(ent.getId(), ent2.getId());
        Assert.assertEquals(ent.getCuidados(), ent2.getCuidados());
    }

    /**
     * Prueba para borrar una Raza
     */
    @Test
    public void deleteRazaTest(){
        RazaEntity ent = data.get(0);
        razaPersistence.delete(ent.getId());
        RazaEntity notFound = em.find(RazaEntity.class, ent.getId());
        Assert.assertNull(notFound);
        
    }
    /**
     * Test para actualizar una Raza
     */
    @Test
    public void updateRazaTest(){
        RazaEntity ent = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        RazaEntity newEnt = factory.manufacturePojo(RazaEntity.class);
        newEnt.setId(ent.getId());
        razaPersistence.update(newEnt);
        RazaEntity retrievedEnt = em.find(RazaEntity.class, ent.getId());
        Assert.assertEquals(newEnt.getName(), retrievedEnt.getName());
        
    }
   
}
