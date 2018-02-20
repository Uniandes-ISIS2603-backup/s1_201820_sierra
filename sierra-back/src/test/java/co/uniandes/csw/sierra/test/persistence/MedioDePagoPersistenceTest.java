/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;
import co.edu.uniandes.csw.sierra.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.sierra.persistence.MedioDePagoPersistence;
import java.util.*;
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
 * @author de.gutierrez
 */
@RunWith(Arquillian.class)
public class MedioDePagoPersistenceTest 
{
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Company, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment()
    {
          return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MedioDePagoEntity.class.getPackage())
                .addPackage(MedioDePagoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyeccion de la dependencia a la clase de MedioDePagoPersistence cuyos metodos se van a probar.
     */
    @Inject
    private MedioDePagoPersistence medioDePagoPersistence;
    
    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */ 
    @PersistenceContext
    private EntityManager em;
    
     /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
    
    /**
     * lista que tiene los datos de prueba
     */
    private List<MedioDePagoEntity> data = new ArrayList<MedioDePagoEntity>();
    
    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from MedioDePagoEntity").executeUpdate();
    }

    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            MedioDePagoEntity entity = factory.manufacturePojo(MedioDePagoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Test of Create method, of class MedioDePagoPersistence.
     */
    @Test
    public void testCreate() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        MedioDePagoEntity newEntity = factory.manufacturePojo(MedioDePagoEntity.class);
        MedioDePagoEntity result = medioDePagoPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        MedioDePagoEntity entity = em.find(MedioDePagoEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getNumeroReferencia(), entity.getNumeroReferencia());
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
    }
    
    /**
     * Test of findAll method, of class MedioDePagoPersistence.
     */
    @Test
    public void testFindAll()  
    {
        List<MedioDePagoEntity> list = medioDePagoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for(MedioDePagoEntity ent : list)
        {
            boolean found = false;
            for(MedioDePagoEntity entity : data)
            {
                if(ent.getId().equals(entity.getId()))
                {
                    found =  true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Test of find method, of class MedioDePagoPersistence.
     */
    @Test
    public void testFind()  {
        MedioDePagoEntity entity = data.get(0);
        MedioDePagoEntity newEntity = medioDePagoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getNumeroReferencia(), entity.getNumeroReferencia());
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
    }
    
     /**
     * Test of update method, of class MedioDePagoPersistence.
     */
    @Test
    public void testUpdate() 
    {
     MedioDePagoEntity entity = data.get(0);
     PodamFactory factory = new PodamFactoryImpl();
     MedioDePagoEntity newEntity = factory.manufacturePojo(MedioDePagoEntity.class);
     
     newEntity.setId(entity.getId());
     medioDePagoPersistence.update(newEntity);
     
     MedioDePagoEntity res = em.find(MedioDePagoEntity.class, entity.getId());
     Assert.assertEquals(newEntity.getNumeroReferencia(), res.getNumeroReferencia());
     Assert.assertEquals(newEntity.getTipo(), res.getTipo());
    }
    
    /**
     * Test of delete method, of class MedioDePagoPersistence.
     */
    @Test
    public void testDelete() 
    {
       MedioDePagoEntity entity = data.get(0);
       medioDePagoPersistence.delete(entity.getId());
       MedioDePagoEntity deleted = em.find(MedioDePagoEntity.class, entity.getId());
       Assert.assertNull(deleted);
    }
}
