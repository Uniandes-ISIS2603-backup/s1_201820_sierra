/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.test.logic;

import co.edu.uniandes.csw.sierra.ejb.RazaLogic;
import co.edu.uniandes.csw.sierra.entities.RazaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.RazaPersistence;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author rj.gonzalez10
 */
@RunWith(Arquillian.class)
public class RazaLogicTest {
    
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private RazaLogic logic;
    
    @Inject
    private RazaPersistence persistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject 
    private UserTransaction userTX;
    
    private List<RazaEntity> data = new ArrayList<RazaEntity>(); 
    
    @Deployment
    public static JavaArchive createDeploymet()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RazaEntity.class.getPackage())
                .addPackage(RazaLogic.class.getPackage())
                .addPackage(RazaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public RazaLogicTest()
    {
        
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
        em.createQuery("delete from RazaEntity").executeUpdate();
    }
    
    private void insertData()
    {
        for(int i = 0; i < 4; i++)
        {
            
            RazaEntity newEntity = factory.manufacturePojo(RazaEntity.class);
            em.persist(newEntity);
            data.add(newEntity);
        }
    }
    
    @Test
    public void createRazaTest()throws BusinessLogicException
    {
        RazaEntity newEntity= factory.manufacturePojo(RazaEntity.class);
        RazaEntity resultado= logic.create(newEntity);
        Assert.assertNotNull(resultado);
        RazaEntity entity= em.find(RazaEntity.class, resultado.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getDestacable(), entity.getDestacable());
    }
    
    @Test
    public void getRazasTest()
    {
        List<RazaEntity> list = logic.getAll();
        Assert.assertEquals(data.size(), list.size());
        for (RazaEntity entity : list) {
            boolean found = false;
            for (RazaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getRazaTest()
    {
        RazaEntity entity = data.get(0);
        RazaEntity resultEntity = logic.getById(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }
    
    @Test
    public void deleteRazaTest()
    {
        RazaEntity entity = data.get(0);
        try{
        logic.delete(entity.getId());
        }
        catch(Exception e){
            
        }
        RazaEntity deleted = em.find(RazaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateRazaTest()
    {
        RazaEntity entity = data.get(0);
        RazaEntity pojoEntity = factory.manufacturePojo(RazaEntity.class);

        pojoEntity.setId(entity.getId());

        logic.update(pojoEntity);

        RazaEntity respuesta = em.find(RazaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getCuidados(), respuesta.getCuidados());
        Assert.assertEquals(pojoEntity.getDestacable(), respuesta.getDestacable());
        Assert.assertEquals(pojoEntity.getNombreRaza(), respuesta.getNombreRaza());
    }
}


