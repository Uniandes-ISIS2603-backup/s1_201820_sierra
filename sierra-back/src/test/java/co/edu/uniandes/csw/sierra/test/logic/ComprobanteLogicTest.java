/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.test.logic;

import co.edu.uniandes.csw.sierra.ejb.ComprobanteLogic;
import co.edu.uniandes.csw.sierra.entities.ComprobanteEntity;
import co.edu.uniandes.csw.sierra.persistence.ComprobantePersistence;
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
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ja.amortegui10
 */
@RunWith(Arquillian.class)
public class ComprobanteLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private ComprobanteLogic logic;
    
    @Inject
    private ComprobantePersistence persistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject 
    private UserTransaction userTX;
    
    private List<ComprobanteEntity> data = new ArrayList<ComprobanteEntity>(); 
    
    @Deployment
    public static JavaArchive createDeploymet()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ComprobanteEntity.class.getPackage())
                .addPackage(ComprobanteLogic.class.getPackage())
                .addPackage(ComprobantePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public ComprobanteLogicTest()
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
        em.createQuery("delete from ComprobanteEntity").executeUpdate();
    }
    
    private void insertData()
    {
        for(int i = 0; i < 4; i++)
        {
            ComprobanteEntity newEntity = factory.manufacturePojo(ComprobanteEntity.class);
            em.persist(newEntity);
        }
    }
}
