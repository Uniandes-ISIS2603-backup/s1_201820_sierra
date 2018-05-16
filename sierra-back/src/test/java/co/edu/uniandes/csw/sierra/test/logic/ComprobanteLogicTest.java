/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.test.logic;

import co.edu.uniandes.csw.sierra.ejb.ComprobanteLogic;
import co.edu.uniandes.csw.sierra.entities.ComprobanteEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
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
    public static JavaArchive createDeploymet() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ComprobanteEntity.class.getPackage())
                .addPackage(ComprobanteLogic.class.getPackage())
                .addPackage(ComprobantePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    public ComprobanteLogicTest() {

    }

    @Before
    public void setup() {
        try {
            userTX.begin();
            clearData();
            insertData();
            userTX.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                userTX.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private void clearData() {
        em.createQuery("delete from ComprobanteEntity").executeUpdate();
    }

    private void insertData() {
        for (int i = 0; i < 4; i++) {
            ComprobanteEntity newEntity = factory.manufacturePojo(ComprobanteEntity.class);
            em.persist(newEntity);
            data.add(newEntity);
        }
    }

    @Test
    public void createComprobanteTest() throws BusinessLogicException {
        ComprobanteEntity newEntity = factory.manufacturePojo(ComprobanteEntity.class);
        logic.create(newEntity);
        Assert.assertNotNull(newEntity);
        ComprobanteEntity entity = em.find(ComprobanteEntity.class, newEntity.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getClienteId(), entity.getClienteId());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
    }

    @Test
    public void getComprobantesTest() {
        List<ComprobanteEntity> list = logic.getAll();
        Assert.assertEquals(data.size(), list.size());
        for (ComprobanteEntity entity : list) {
            boolean found = false;
            for (ComprobanteEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getComprobanteTest() {
        ComprobanteEntity entity = data.get(0);
        ComprobanteEntity resultEntity = logic.getById(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }

    @Test
    public void deleteComprobanteTest() {
        ComprobanteEntity entity = data.get(0);
        try {
            logic.delete(entity.getId());
        } catch (Exception e) {
            Assert.fail("Error: " + e.getMessage());
        }

        ComprobanteEntity deleted = em.find(ComprobanteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateComprobanteTest() {
        ComprobanteEntity entity = data.get(0);
        ComprobanteEntity pojoEntity = factory.manufacturePojo(ComprobanteEntity.class);

        pojoEntity.setId(entity.getId());

        try {
            logic.update(pojoEntity);
        } catch (Exception e) {
            Assert.fail("Error: " + e.getMessage());
        }

        ComprobanteEntity respuesta = em.find(ComprobanteEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getClienteId(), respuesta.getClienteId());
        Assert.assertEquals(pojoEntity.getFecha(), respuesta.getFecha());
        Assert.assertEquals(pojoEntity.getValorTotal(), respuesta.getValorTotal());
    }
}
