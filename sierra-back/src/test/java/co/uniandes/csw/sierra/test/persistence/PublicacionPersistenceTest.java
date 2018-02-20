/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;

import co.edu.uniandes.csw.sierra.entities.PublicacionEntity;
import co.edu.uniandes.csw.sierra.persistence.PublicacionPersistence;
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
 * @author Granja
 */
@RunWith(Arquillian.class)
public class PublicacionPersistenceTest 
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
                .addPackage(PublicacionEntity.class.getPackage())
                .addPackage(PublicacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyeccion de la dependencia a la clase de PublicacionPersistence cuyos metodos se van a probar.
     */
    @Inject
    private PublicacionPersistence publicacionPersistence;
    
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
    private List<PublicacionEntity> data = new ArrayList<PublicacionEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PublicacionEntity entity = factory.manufacturePojo(PublicacionEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Test del metodo Create de la clase PublicacionPersistence.
     */
    @Test
    public void testCreate() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        PublicacionEntity newEntity = factory.manufacturePojo(PublicacionEntity.class);
        PublicacionEntity result = publicacionPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        PublicacionEntity entity = em.find(PublicacionEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
        Assert.assertEquals(newEntity.getComentario(), entity.getComentario());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getFotoURL(), entity.getFotoURL());
    }
    
     /**
     * Test of findAll method, of class PublicacionPersistence.
     */
    @Test
    public void testFindAll()  
    {
        List<PublicacionEntity> list = publicacionPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for(PublicacionEntity ent : list)
        {
            boolean found = false;
            for(PublicacionEntity entity : data)
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
     * Test of find method, of class PublicacionPersistence.
     */
    @Test
    public void testFind() 
    {
        PublicacionEntity entity = data.get(0);
        PublicacionEntity newEntity = publicacionPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);//Se verifica que no haya retornado un entity nulo.
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
        Assert.assertEquals(newEntity.getComentario(), entity.getComentario());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getFotoURL(), entity.getFotoURL());
    }
    
     /**
     * Test of update method, of class PublicacionPersistence.
     */
    @Test
    public void testUpdate() 
    {
        
     PublicacionEntity entity = data.get(0);//Entidad que vamos a probar actualizar.
     PodamFactory factory = new PodamFactoryImpl();// Crea una nueva entidad con datos aleatorios.
     PublicacionEntity newEntity = factory.manufacturePojo(PublicacionEntity.class);//Crea una nueva entidad con datos aleatorios.
     
     newEntity.setId(entity.getId());// se igualan los id para que correspondan
     publicacionPersistence.update(newEntity);// se ejecuta el metodo.
     
     // se prueba que la informacion haya sido persistida correctamente.
     PublicacionEntity res = em.find(PublicacionEntity.class, entity.getId());
      Assert.assertEquals(newEntity.getTipo(), res.getTipo());
      Assert.assertEquals(newEntity.getComentario(), res.getComentario());
      Assert.assertEquals(newEntity.getFecha(), res.getFecha());
      Assert.assertEquals(newEntity.getFotoURL(), res.getFotoURL());
    }
    
    /**
     * Test of delete method, of class PublicacionPersistence.
     */
    @Test
    public void testDelete() 
    {
       PublicacionEntity entity = data.get(0);
       publicacionPersistence.delete(entity.getId());
       PublicacionEntity deleted = em.find(PublicacionEntity.class, entity.getId());
       Assert.assertNull(deleted);
    }
    
}

