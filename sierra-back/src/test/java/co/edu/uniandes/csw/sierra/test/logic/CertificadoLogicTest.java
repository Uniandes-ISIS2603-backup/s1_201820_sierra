/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.test.logic;

import co.edu.uniandes.csw.sierra.ejb.CertificadoLogic;
import co.edu.uniandes.csw.sierra.entities.CertificadoEntity;
import co.edu.uniandes.csw.sierra.entities.RazaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.CertificadoPersistence;
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
public class CertificadoLogicTest {
    
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private CertificadoLogic logic;
    
    @Inject
    private CertificadoPersistence persistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject 
    private UserTransaction userTX;
    
    private List<CertificadoEntity> data = new ArrayList<CertificadoEntity>(); 
    
    @Deployment
    public static JavaArchive createDeploymet()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CertificadoEntity.class.getPackage())
                .addPackage(CertificadoLogic.class.getPackage())
                .addPackage(CertificadoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public CertificadoLogicTest()
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
        em.createQuery("delete from CertificadoEntity").executeUpdate();
    }
    
    private void insertData()
    {
        for(int i = 0; i < 4; i++)
        {
            
            CertificadoEntity newEntity = factory.manufacturePojo(CertificadoEntity.class);
            em.persist(newEntity);
            data.add(newEntity);
        }
    }
    
    @Test
    public void createRazaTest()throws BusinessLogicException
    {
        CertificadoEntity newEntity= factory.manufacturePojo(CertificadoEntity.class);
        CertificadoEntity resultado= logic.create(newEntity);
        Assert.assertNotNull(resultado);
        CertificadoEntity entity= em.find(CertificadoEntity.class, resultado.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
    }
    
    @Test
    public void getRazasTest()
    {
        List<CertificadoEntity> list = logic.getAll();
        Assert.assertEquals(data.size(), list.size());
        for (CertificadoEntity entity : list) {
            boolean found = false;
            for (CertificadoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getComprobanteTest()
    {
        CertificadoEntity entity = data.get(0);
        CertificadoEntity resultEntity = logic.getById(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }
    
    @Test
    public void deleteComprobanteTest() throws BusinessLogicException
    {
        CertificadoEntity entity = data.get(0);
        try{
        logic.delete(entity.getId());
        }
        catch(Exception e){
            
        }
        RazaEntity deleted = em.find(RazaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateComprobanteTest()
    {
       CertificadoEntity entity = data.get(0);
       CertificadoEntity pojoEntity = factory.manufacturePojo(CertificadoEntity.class);

        pojoEntity.setId(entity.getId());
try
{
        logic.update(pojoEntity);
}catch(Exception e)
        {
            Assert.fail("Error: " + e.getMessage());
        }

        CertificadoEntity respuesta = em.find(CertificadoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getDescripcion(), respuesta.getDescripcion());
        Assert.assertEquals(pojoEntity.getImagen(), respuesta.getImagen());
        Assert.assertEquals(pojoEntity.getFecha(), respuesta.getFecha());
    }
}


