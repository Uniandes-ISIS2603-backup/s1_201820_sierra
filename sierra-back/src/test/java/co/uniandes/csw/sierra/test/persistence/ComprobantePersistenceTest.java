/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;

import co.edu.uniandes.csw.sierra.entities.ComprobanteEntity;
import co.edu.uniandes.csw.sierra.entities.FacturaEntity;
import co.edu.uniandes.csw.sierra.persistence.ComprobantePersistence;
import co.edu.uniandes.csw.sierra.persistence.FacturaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ja.amortegui10
 */
public class ComprobantePersistenceTest {
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
     * Inyección de la dependencia a la clase ComprobantePersistence cuyos métodos se van a probar.
     */
    private ComprobantePersistence comprobantePersistence;
    
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
    private List<ComprobanteEntity> data = new ArrayList<ComprobanteEntity>();
    
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
        em.createQuery("delete from ComprobanteEntity").executeUpdate();
        
    }
    
    /**
     * Inserta los correctos datos iniciales para el buen desarrollo de las pruebas.
     */
    private void insertData()
    {
        PodamFactory factory = new PodamFactoryImpl();
        ComprobanteEntity comprobante;
        for(int i = 0; i < 4; i++){
            comprobante = factory.manufacturePojo(ComprobanteEntity.class);
            
            em.persist(comprobante);
            data.add(comprobante);
        }
            
    }
    
    /**
     * Prueba para crear un comprobante.
     */
    @Test
    public void createFactura()
    {
        PodamFactory factory = new PodamFactoryImpl();
        ComprobanteEntity newEntity = factory.manufacturePojo(ComprobanteEntity.class);
        ComprobanteEntity result = comprobantePersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ComprobanteEntity entity = em.find(ComprobanteEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getValorTotal(), entity.getValorTotal());
    }
    
    /**
     * Prueba para retornar una lista con todos los comprobantes.
     */
    @Test
    public void getFacturasTest()
    {
        List<ComprobanteEntity> comprobantes = comprobantePersistence.findAll();
        Assert.assertEquals(comprobantes.size(), data.size());
        
        for(ComprobanteEntity ent: comprobantes)
        {
            boolean found = false;
            for(ComprobanteEntity entity: data)
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
        ComprobanteEntity entity = data.get(0);
        ComprobanteEntity newEntity = comprobantePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getFecha(), newEntity.getFecha());
        Assert.assertEquals(entity.getValorTotal(), newEntity.getValorTotal());
    }
    
    /**
     * Prueba el método para eliminar un comprobante.
     */
    @Test
    public void deleteFacturaTest()
    {
        ComprobanteEntity entity = data.get(0);
        comprobantePersistence.delete(entity.getId());
        ComprobanteEntity deleted = em.find(ComprobanteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba el método para actualizar la información concerniente a un Comprobante.
     */
    @Test
    public void updateFacturaTest()
    {
        ComprobanteEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ComprobanteEntity newEntity = factory.manufacturePojo(ComprobanteEntity.class);
        
        newEntity.setId(entity.getId());
        
        comprobantePersistence.update(newEntity);
        
        ComprobanteEntity resp = em.find(ComprobanteEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getFecha(), resp.getFecha());
        Assert.assertEquals(newEntity.getValorTotal(), resp.getValorTotal());
    }
}
