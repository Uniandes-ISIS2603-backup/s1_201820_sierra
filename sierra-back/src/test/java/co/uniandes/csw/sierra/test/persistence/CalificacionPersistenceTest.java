/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;

import co.edu.uniandes.csw.sierra.entities.CalificacionEntity;
import co.edu.uniandes.csw.sierra.persistence.CalificacionPersistence;
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
public class CalificacionPersistenceTest {
    
    /**
     * @return Devuelve el jar que se va a desplegar en glassfish 
     */
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(CalificacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private CalificacionPersistence calificacionPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    
    private List<CalificacionEntity> data;
    
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
        em.createQuery("delete from CalificacionEntity").executeUpdate();
    }
    
    /**
     * crea nuevos datos para la prueba
     */
    private void insertData(){
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i < 10; i++){
            CalificacionEntity ent = factory.manufacturePojo(CalificacionEntity.class);
            em.persist(ent);
            data.add(ent);
        }
    }
    
    
    /**
     * Prueba para crear una Calificacion
     */
    @Test
    public void createCalificacionTest(){
        PodamFactory factory = new PodamFactoryImpl();
        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        CalificacionEntity result = calificacionPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CalificacionEntity entity = em.find(CalificacionEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getValor(), entity.getValor());
        
    }
    
    /**
     * Prueba que se pueden recuperar los objetos de la base de datos
     */
    @Test
    public void getCalificacionesTest(){
        List<CalificacionEntity> list =  calificacionPersistence.findAll();
        //Revisa que ambas listas tengan el mismo tamano
        Assert.assertEquals(data.size(), list.size());
        for(CalificacionEntity ent: list){
            boolean fand= false;
            //Revisa que ambas calificaciones tengan el mismo ID
            for(CalificacionEntity ent2: data){
                if(ent.getId().equals(ent2.getId())){
                    fand = true;
                }
            }
            Assert.assertTrue(fand);
        }
    }
    /**
     * test para obtener una Calificacion en especifico
     */
    @Test
    public void getCalificacionTest(){
        CalificacionEntity ent = data.get(0);
        CalificacionEntity ent2 = calificacionPersistence.find(ent.getId());
        Assert.assertNotNull(ent2);
        Assert.assertEquals(ent.getName(), ent2.getName());
        Assert.assertEquals(ent.getValor(), ent2.getValor());
    }

    /**
     * Prueba para borrar una Calificacion
     */
    @Test
    public void deleteCalificacionTest(){
        CalificacionEntity ent = data.get(0);
        calificacionPersistence.delete(ent.getId());
        CalificacionEntity notFound = em.find(CalificacionEntity.class, ent.getId());
        Assert.assertNull(notFound);
        
    }
    /**
     * Test para actualizar una Calificacion
     */
    @Test
    public void updateCalificacionTest(){
        CalificacionEntity ent = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CalificacionEntity newEnt = factory.manufacturePojo(CalificacionEntity.class);
        newEnt.setId(ent.getId());
        calificacionPersistence.update(newEnt);
        CalificacionEntity retrievedEnt = em.find(CalificacionEntity.class, ent.getId());
        Assert.assertEquals(newEnt.getName(), retrievedEnt.getName());
        
    }
    
    
}
