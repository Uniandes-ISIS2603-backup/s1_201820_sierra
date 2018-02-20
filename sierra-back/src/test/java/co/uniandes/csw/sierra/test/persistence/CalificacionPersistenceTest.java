/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;

import co.edu.uniandes.csw.sierra.entities.CalificacionEntity;
import co.edu.uniandes.csw.sierra.persistence.CalificacionPersistence;
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
    
    
    @Before
    public void setUp(){
        try{
            utx.begin();
            em.joinTransaction();
            clearData();
            createData();
            utx.commit();
        } catch (Exception e){
            e.printStackTrace();
            try{
                utx.rollback();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }
    
    private List<CalificacionEntity> data = new ArrayList<>();
    
    
    public void clearData(){
        em.createQuery("DELETE FROM CalificacionEntity").executeUpdate();
    }
    
    public void createData(){
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i < 10; i++){
            CalificacionEntity ent = factory.manufacturePojo(CalificacionEntity.class);
            
            em.persist(ent);
            
            data.add(ent);
        }
    }
    
    
    /**
     * Prueba para crear una calificacion
     *
     *
     */
    @Test
    public void createCalificacionTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        CalificacionEntity result = calificacionPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CalificacionEntity entity = em.find(CalificacionEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    
    
    
}
