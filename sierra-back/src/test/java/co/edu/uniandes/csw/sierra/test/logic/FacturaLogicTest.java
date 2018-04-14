/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.test.logic;

import co.edu.uniandes.csw.sierra.ejb.FacturaLogic;
import co.edu.uniandes.csw.sierra.ejb.MascotaAdoptadaLogic;
import co.edu.uniandes.csw.sierra.entities.FacturaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.FacturaPersistence;
import co.edu.uniandes.csw.sierra.persistence.MascotaAdoptadaPersistence;
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
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ja.amortegui10
 */
@RunWith(Arquillian.class)
public class FacturaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    /**
     * Inyección de la dependencia FacturaLogic, cuyos métodos se probarán.
     */
    @Inject
    private FacturaLogic logic;
    
    /**
     * Inyección de la dependencia FacturaPersistence, cuyos métodos probarán.
     */
    @Inject
    private FacturaPersistence persistence;
    
    /**
     * Contexto de persistencia que se va a utilizar para acceder a la base de datos por fuera de los métodos
     * que se están probando.
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Variable para marcar las transacciones del em anterior cuando se 
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction userTX;
    
    /**
     *Lista guias. 
     */
    private List<FacturaEntity> data = new ArrayList<FacturaEntity>();
    
    /**
     * 
     * @return el jar que Arquillian va a desplegar en el Glassfish embebido. 
     * El jar contiene las clases de guia, el descriptor de la base de datos 
     * y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FacturaEntity.class.getPackage())
                .addPackage(FacturaLogic.class.getPackage())
                .addPackage(FacturaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    /**
     * Constructor por defecto.
     */
    public FacturaLogicTest()
    {
        //Proceso Constructor.
    }
    

    @Before
    public void setup()
    {
        try{
            userTX.begin();
            clearData();
            insertData();
            userTX.commit();
        }catch(Exception e)
        {
            e.printStackTrace();
            try
            {
                userTX.rollback();
            }catch(Exception e1)
            {
                e1.printStackTrace();
            }
        }
    }
    
    private void clearData()
    {
        em.createQuery("delete from FacturaEntity").executeUpdate();
    }
    
    private void insertData()
    {
        for(int i = 0 ; i < 4; i++)
        {
            FacturaEntity newEntity = factory.manufacturePojo(FacturaEntity.class);
            em.persist(newEntity);
            data.add(newEntity);
        }
    }
    
    
    @Test
    public void createFacturaTest()throws BusinessLogicException
    {
        FacturaEntity newEntity = factory.manufacturePojo(FacturaEntity.class);
        FacturaEntity resultado = logic.create(newEntity);
        Assert.assertNotNull(resultado);
        FacturaEntity entity = em.find(FacturaEntity.class, resultado.getId());
        Assert.assertEquals(newEntity, entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    @Test
    public void getFacturasTest(){
        List<FacturaEntity> list = logic.getAll();
        Assert.assertEquals(data.size(), list.size());
        for (FacturaEntity entity : list) {
            boolean found = false;
            for (FacturaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getFacturaTest()
    {
        FacturaEntity entity = data.get(0);
        FacturaEntity resultado = logic.getById(entity.getId());
        Assert.assertNotNull(resultado);
        Assert.assertEquals(entity.getId(), resultado.getId());
        Assert.assertEquals(entity.getName(), resultado.getName());
        Assert.assertEquals(entity.getValor(), resultado.getValor());
        
    }
    
    @Test
    public void deleteFacturaTest()
    {
        FacturaEntity entity = data.get(0);
        try
        {
            logic.delete(entity.getId());
        }catch(Exception e )
        {
            Assert.fail("Error: " + e.getMessage());
        }
        
        FacturaEntity borrada = em.find(FacturaEntity.class, entity.getId());
        Assert.assertNull(borrada);
    }
    
    @Test 
    public void updateFacturaTest()
    {
        FacturaEntity entity = data.get(0);
        FacturaEntity pojoEntity = factory.manufacturePojo(FacturaEntity.class);

        pojoEntity.setId(entity.getId());
        
        try
        {
            logic.update(pojoEntity);
        }catch(Exception e)
        {
            Assert.fail("Error: " + e.getMessage());
        }
        

        FacturaEntity respuesta = em.find(FacturaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), respuesta.getId());
        Assert.assertEquals(pojoEntity.getName(), respuesta.getName());
        Assert.assertEquals(pojoEntity.getValor(), respuesta.getValor());
    }
    
    
}




/**
 * @OneToMany(mappedBy = "nombreClaseLocal", cascade = CascadeType.All, orphanRemoval...
 */