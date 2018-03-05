/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.test.logic;

import co.edu.uniandes.csw.sierra.ejb.AcontecimientoLogic;
import co.edu.uniandes.csw.sierra.entities.AcontecimientoEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.AcontecimientoPersistence;
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
public class AcontecimientoLogicTest 
{
    
    /**
     * PodamFactory
     */
    private PodamFactory factory = new PodamFactoryImpl();
    
    /**
     * Injeccion de la clase que se va a probar
     */
    @Inject
    private AcontecimientoLogic calLogic; 
    
    /**
     * Injeccion  de la clase de persistencia
     */
    @Inject
    private AcontecimientoPersistence calPersistence; 
    
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
    
    private List<AcontecimientoEntity> data = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AcontecimientoLogic.class.getPackage())
                .addPackage(AcontecimientoEntity.class.getPackage())
                .addPackage(AcontecimientoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    public AcontecimientoLogicTest()
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
        em.createQuery("delete from AcontecimientoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            AcontecimientoEntity entity = factory.manufacturePojo(AcontecimientoEntity.class);
            em.persist(entity);
            data.add(entity);

        }
    }
    
        /**
     * Prueba para crear un Acontecimiento
     */
    @Test
    public void createAdquisicionTest(){
        AcontecimientoEntity newEntity = factory.manufacturePojo(AcontecimientoEntity.class);
        try{
            AcontecimientoEntity result = calLogic.create(newEntity);
            Assert.assertNotNull(result);
            AcontecimientoEntity entity = em.find(AcontecimientoEntity.class, result.getId());
            Assert.assertEquals(newEntity.getName(), entity.getName());
            
        }catch(BusinessLogicException e){
            fail("No deberia generar Exception: " + e.getMessage());
        }

        
        
    }
    
    /**
     * Prueba que se pueden recuperar los objetos de la base de datos
     */
    @Test
    public void getAdquisicionesTest(){
        List<AcontecimientoEntity> list =  calLogic.getAll();
        //Revisa que ambas listas tengan el mismo tamano
        Assert.assertEquals(data.size(), list.size());
        for(AcontecimientoEntity ent: list){
            boolean fand= false;
            //Revisa que ambas acontecimiento tengan el mismo ID
            for(AcontecimientoEntity ent2: data){
                if(ent.getId().equals(ent2.getId())){
                    fand = true;
                }
            }
            Assert.assertTrue(fand);
        }
    }
    /**
     * test para obtener una Acontecimiento en especifico
     */
    @Test
    public void getAdquisicionTest(){
        AcontecimientoEntity ent = data.get(0);
        AcontecimientoEntity ent2 = calLogic.getById(ent.getId());
        Assert.assertNotNull(ent2);
        Assert.assertEquals(ent.getName(), ent2.getName());
    }

    /**
     * Prueba para borrar un Acontecimiento
     */
    @Test
    public void deleteAdquisicionTest(){
        AcontecimientoEntity ent = data.get(0);
        calLogic.delete(ent);
        AcontecimientoEntity notFound = em.find(AcontecimientoEntity.class, ent.getId());
        Assert.assertNull(notFound);
        
    }
    /**
     * Test para actualizar un Acontecimiento
     */
    @Test
    public void updateAdquisicionTest(){
        AcontecimientoEntity ent = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AcontecimientoEntity newEnt = factory.manufacturePojo(AcontecimientoEntity.class);
        newEnt.setId(ent.getId());
        try {
            calLogic.update(newEnt);
            AcontecimientoEntity retrievedEnt = em.find(AcontecimientoEntity.class, ent.getId());
        Assert.assertEquals(newEnt.getName(), retrievedEnt.getName());
        } catch (BusinessLogicException ex) {
            fail("No deberia generar Exception: " + ex.getMessage());
        }
        
        
    }
        
}

