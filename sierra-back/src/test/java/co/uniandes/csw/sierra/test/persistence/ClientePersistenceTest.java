/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;

import co.edu.uniandes.csw.sierra.entities.*;
import co.edu.uniandes.csw.sierra.persistence.ClientePersistence;
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
public class ClientePersistenceTest
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
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyeccion de la dependencia a la clase de ClientePersistence cuyos metodos se van a probar.
     */
    @Inject
    private ClientePersistence clientePersistence;
    
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
    private List<ClienteEntity> data = new ArrayList<ClienteEntity>();
    
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
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }
 
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Test of Create method, of class ClientePersistence..
     */
    @Test
    public void testCreate()
    {
        PodamFactory factory = new PodamFactoryImpl();
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
        ClienteEntity result = clientePersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        ClienteEntity entity = em.find(ClienteEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getApellido(), entity.getApellido());
        Assert.assertEquals(newEntity.getCedula(), entity.getCedula());
        Assert.assertEquals(newEntity.getTelefono(), entity.getTelefono());
    }
    
    /**
     * Test of findAll method, of class ClientePersistence.
     */
    @Test
    public void testFindAll()  
    {
        List<ClienteEntity> list = clientePersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for(ClienteEntity ent : list)
        {
            boolean found = false;
            for(ClienteEntity entity : data)
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
     * Test of find method, of class ClientePersistence.
     */
    @Test
    public void testFind()
    {
        ClienteEntity entity = data.get(0);
        ClienteEntity newEntity = clientePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getApellido(), newEntity.getApellido());
        Assert.assertEquals(entity.getCedula(), newEntity.getCedula());
        Assert.assertEquals(entity.getTelefono(), newEntity.getTelefono());
    }
    
    /**
     * Test of update method, of class ClientePersistence.
     */
    @Test
    public void testUpdate() 
    {
     ClienteEntity entity = data.get(0);
     PodamFactory factory = new PodamFactoryImpl();
     ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
     
     newEntity.setId(entity.getId());
     clientePersistence.update(newEntity);
     
     ClienteEntity res = em.find(ClienteEntity.class, entity.getId());
     
     Assert.assertEquals(newEntity.getNombre(), res.getNombre());
     Assert.assertEquals(newEntity.getApellido(), res.getApellido());
     Assert.assertEquals(newEntity.getCedula(), res.getCedula());
     Assert.assertEquals(newEntity.getTelefono(), res.getTelefono());
    }
    
    /**
     * Test of delete method, of class ClientePersistence.
     */
    @Test
    public void testDelete() 
    {
       ClienteEntity entity = data.get(0);
       clientePersistence.delete(entity.getId());
       ClienteEntity deleted = em.find(ClienteEntity.class, entity.getId());
       Assert.assertNull(deleted);
    }
}
