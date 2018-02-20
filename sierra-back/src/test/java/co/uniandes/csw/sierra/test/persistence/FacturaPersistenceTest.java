/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;

import co.edu.uniandes.csw.sierra.entities.FacturaEntity;
import co.edu.uniandes.csw.sierra.persistence.FacturaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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
 * @author ja.amortegui10
 */
@RunWith( Arquillian.class)
public class FacturaPersistenceTest {
    /**
     * * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Company, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FacturaEntity.class.getPackage())
                .addPackage(FacturaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase FacturaPersistence cuyos métodos se van a probar.
     */
    private FacturaPersistence facturaPersistence;
    
    /**
     * Contexto de persistencia que se va a usar para acceder a la  base de datos por fuera de los métodos probados actualmente.
     * 
     */
    private EntityManager em;
    
    
    /**
     * Variable para martcar las transacciones del em anterior cuando se crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
    
    private List<FacturaEntity> data = new ArrayList<FacturaEntity>();
    
    /**
     * Configuarción inicial de la prueba.
     */
    @Before
    public void setUp()
    {
        try{
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
            try{
                utx.rollback();
            }
            catch(Exception e2)
            {
                e2.printStackTrace();
            }
        }
    }
    
    /**
     * Limpia las tablas implicadas en la prueba.
     */
    private void clearData()
    {
        em.createQuery("delete from FacturaEntity").executeUpdate();
        
    }
    
    /**
     * Inserta los correctos datos iniciales para el buen desarrollo de las pruebas.
     */
    private void insertData()
    {
        PodamFactory factory = new PodamFactoryImpl();
        FacturaEntity factura;
        for(int i = 0; i < 4; i++){
            factura = factory.manufacturePojo(FacturaEntity.class);
            
            em.persist(factura);
            data.add(factura);
        }
            
    }
    
    
    /**
     * Prueba para crear una factura.
     */
    @Test
    public void createFactura()
    {
        PodamFactory factory = new PodamFactoryImpl();
        FacturaEntity newEntity = factory.manufacturePojo(FacturaEntity.class);
        FacturaEntity result = facturaPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        FacturaEntity entity = em.find(FacturaEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getValorTotal(), entity.getValorTotal());
    }
    
    /**
     * Prueba para retornar una lista con todas las facturas.
     */
    @Test
    public void getFacturasTest()
    {
        List<FacturaEntity> facturas = facturaPersistence.findAll();
        Assert.assertEquals(facturas.size(), data.size());
        
        for(FacturaEntity ent: facturas)
        {
            boolean found = false;
            for(FacturaEntity entity: data)
            {
                if(ent.getId().equals(entity.getId()))
                    found = true;
            }
            
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba el método para retornar una factura con un id dado por parámetor.
     */
    @Test
    public void getFacturaTest()
    {
        FacturaEntity entity = data.get(0);
        FacturaEntity newEntity = facturaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getFecha(), newEntity.getFecha());
        Assert.assertEquals(entity.getValorTotal(), newEntity.getValorTotal());
    }
    
    /**
     * Prueba el método para eliminar una factura.
     */
    @Test
    public void deleteFacturaTest()
    {
        FacturaEntity entity = data.get(0);
        facturaPersistence.delete(entity.getId());
        FacturaEntity deleted = em.find(FacturaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba el método para actualizar la información concerniente a una factura.
     */
    @Test
    public void updateFacturaTest()
    {
        FacturaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        FacturaEntity newEntity = factory.manufacturePojo(FacturaEntity.class);
        
        newEntity.setId(entity.getId());
        
        facturaPersistence.update(newEntity);
        
        FacturaEntity resp = em.find(FacturaEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getFecha(), resp.getFecha());
        Assert.assertEquals(newEntity.getValorTotal(), resp.getValorTotal());
    }
}
