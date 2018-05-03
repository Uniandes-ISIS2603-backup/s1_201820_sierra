/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.test.logic;

import co.edu.uniandes.csw.sierra.ejb.PublicacionLogic;
import co.edu.uniandes.csw.sierra.entities.PublicacionEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.PublicacionPersistence;
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
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ja.penat
 */
@RunWith(Arquillian.class)
public class PublicacionLogicTest 
{
      
    /**
     * PodamFactory
     */
    private PodamFactory factory = new PodamFactoryImpl();
    
    /**
     * Injeccion de la clase que se va a probar
     */
    @Inject
    private PublicacionLogic calLogic; 
    
    /**
     * Injeccion  de la clase de persistencia
     */
    @Inject
    private PublicacionPersistence calPersistence; 
    
    /**
     * Manejador de persistencia
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Marcador de transacciones
     */
    @Inject
    private UserTransaction ussrTX;
    
    private List<PublicacionEntity> data = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment() 
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PublicacionLogic.class.getPackage())
                .addPackage(PublicacionEntity.class.getPackage())
                .addPackage(PublicacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    public PublicacionLogicTest()
    {
        //Constructor Vacio
    }
    
    @Before
    public void setUp() {
        try {
            ussrTX.begin();
            clearData();
            insertData();
            ussrTX.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                ussrTX.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
     private void clearData() {
        em.createQuery("delete from PublicacionEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PublicacionEntity entity = factory.manufacturePojo(PublicacionEntity.class);
            em.persist(entity);
            data.add(entity);

        }
    }
    
        /**
     * Prueba para crear una Publicacion
     */
    @Test
    public void createPublicacionTest(){
        PublicacionEntity newEntity = factory.manufacturePojo(PublicacionEntity.class);
        try{
            PublicacionEntity result = calLogic.create(newEntity);
            Assert.assertNotNull(result);
            PublicacionEntity entity = em.find(PublicacionEntity.class, result.getId());
            Assert.assertEquals(newEntity.getName(), entity.getName());
            
        }catch(BusinessLogicException e){
            fail("No deberia generar Exception: " + e.getMessage());
        }

        
        
    }
    
    /**
     * Prueba que se pueden recuperar los objetos de la base de datos
     */
    @Test
    public void getPublicacionesTest(){
        List<PublicacionEntity> list =  calLogic.getAll();
        //Revisa que ambas listas tengan el mismo tamano
        Assert.assertEquals(data.size(), list.size());
        for(PublicacionEntity ent: list){
            boolean fand= false;
            //Revisa que ambas publicaciones tengan el mismo ID
            for(PublicacionEntity ent2: data){
                if(ent.getId().equals(ent2.getId())){
                    fand = true;
                }
            }
            Assert.assertTrue(fand);
        }
    }
    /**
     * test para obtener una Publicacion en especifico
     */
    @Test
    public void getPublicacionTest(){
        PublicacionEntity ent = data.get(0);
        PublicacionEntity ent2 = calLogic.getById(ent.getId());
        Assert.assertNotNull(ent2);
        Assert.assertEquals(ent.getName(), ent2.getName());
    }

    /**
     * Prueba para borrar una Publicacion
     */
    @Test
    public void deletePublicacionTest(){
        PublicacionEntity ent = data.get(0);
        calLogic.delete(ent);
       PublicacionEntity notFound = em.find(PublicacionEntity.class, ent.getId());
        Assert.assertNull(notFound);
        
    }
    /**
     * Test para actualizar una Publicacion
     */
    @Test
    public void updatePublicacionTest(){
        PublicacionEntity ent = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PublicacionEntity newEnt = factory.manufacturePojo(PublicacionEntity.class);
        newEnt.setId(ent.getId());
        try {
            calLogic.update(newEnt);
            PublicacionEntity retrievedEnt = em.find(PublicacionEntity.class, ent.getId());
        Assert.assertEquals(newEnt.getName(), retrievedEnt.getName());
        } catch (BusinessLogicException ex) {
            fail("No deberia generar Exception: " + ex.getMessage());
        }
        
        
    }
        
}