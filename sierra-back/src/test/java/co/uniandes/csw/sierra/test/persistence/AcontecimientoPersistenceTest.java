/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;
import co.edu.uniandes.csw.sierra.entities.AcontecimientoEntity;
import co.edu.uniandes.csw.sierra.persistence.AcontecimientoPersistence;
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
 * @author Granja
 */
@RunWith(Arquillian.class)
public class AcontecimientoPersistenceTest 
{
    
  /**
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de mensajero, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() 
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AcontecimientoEntity.class.getPackage())
                .addPackage(AcontecimientoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyeccion de la dependencia a la clase de AcontecimientoPersistence cuyos metodos se van a probar.
     */
    @Inject
    private AcontecimientoPersistence acontecimientoPersistence;
    
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
     * Configuración inicial de la prueba.
     */
    @Before
    public void setUp()
    {
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
    private void clearData() 
    {
        em.createQuery("delete from PublicacionEntity").executeUpdate();
    }
 
     /**
     * lista que tiene los datos de prueba
     */
    private List<AcontecimientoEntity> data = new ArrayList<AcontecimientoEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            AcontecimientoEntity entity = factory.manufacturePojo(AcontecimientoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Test del metodo Create de la clase AcontecimientoPersistence.
     */
    @Test
    public void testCreate() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        AcontecimientoEntity newEntity = factory.manufacturePojo(AcontecimientoEntity.class);
        AcontecimientoEntity result = acontecimientoPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        AcontecimientoEntity entity = em.find(AcontecimientoEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
        Assert.assertEquals(newEntity.getImportancia(), entity.getImportancia());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getFotoURL(), entity.getFotoURL());
    }
    
     /**
     * Test of findAll method, of class AcontecimientoPersistence.
     */
    @Test
    public void testFindAll()  
    {
        List<AcontecimientoEntity> list = acontecimientoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for(AcontecimientoEntity ent : list)
        {
            boolean found = false;
            for(AcontecimientoEntity entity : data)
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
     * Test of find method, of class AcontecimientoPersistence.
     */
    @Test
    public void testFind() 
    {
       AcontecimientoEntity entity = data.get(0);
        AcontecimientoEntity newEntity = acontecimientoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);//Se verifica que no haya retornado un entity nulo.
        
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
        Assert.assertEquals(newEntity.getImportancia(), entity.getImportancia());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getFotoURL(), entity.getFotoURL());
    }
    
     /**
     * Test of update method, of class AcontecimientoPersistence.
     */
    @Test
    public void testUpdate() 
    {
        
    AcontecimientoEntity entity = data.get(0);//Entidad que vamos a probar actualizar.
     PodamFactory factory = new PodamFactoryImpl();// Crea una nueva entidad con datos aleatorios.
    AcontecimientoEntity newEntity = factory.manufacturePojo(AcontecimientoEntity.class);//Crea una nueva entidad con datos aleatorios.
     
     newEntity.setId(entity.getId());// se igualan los id para que correspondan
     acontecimientoPersistence.update(newEntity);// se ejecuta el metodo.
     
     // se prueba que la informacion haya sido persistida correctamente.
    AcontecimientoEntity res = em.find(AcontecimientoEntity.class, entity.getId());
     Assert.assertEquals(newEntity.getNombre(), res.getNombre());
     Assert.assertEquals(newEntity.getTipo(), res.getTipo());
     Assert.assertEquals(newEntity.getDescripcion(), res.getDescripcion());
     Assert.assertEquals(newEntity.getImportancia(), res.getImportancia());
     Assert.assertEquals(newEntity.getFecha(), res.getFecha());
     Assert.assertEquals(newEntity.getFotoURL(), res.getFotoURL());
    }
    
    /**
     * Test of delete method, of class AcontecimeintoPersistence.
     */
    @Test
    public void testDelete() 
    {
       AcontecimientoEntity entity = data.get(0);
       acontecimientoPersistence.delete(entity.getId());
       AcontecimientoEntity deleted = em.find(AcontecimientoEntity.class, entity.getId());
       Assert.assertNull(deleted);// Se verifica que el valor se haya borrado.
    }
    
}
