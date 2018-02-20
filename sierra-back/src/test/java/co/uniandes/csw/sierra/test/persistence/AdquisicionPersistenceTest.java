/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;

import co.edu.uniandes.csw.sierra.entities.AdquisicionEntity;
import co.edu.uniandes.csw.sierra.persistence.AdquisicionPersistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
/**
 *
 * @author jd.zambrano
 */
@RunWith(Arquillian.class)
public class AdquisicionPersistenceTest {
    
    /**
     * @return Devuelve el jar que se va a desplegar en glassfish 
     */
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AdquisicionEntity.class.getPackage())
                .addPackage(AdquisicionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private AdquisicionPersistence adquisicionPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    
    /**
     * Prueba para crear un Editorial.
     *
     *
     */
    @Test
    public void createEditorialTest() {
        PodamFactory factory = new PodamFactoryImpl();
        AdquisicionEntity newEntity = factory.manufacturePojo(AdquisicionEntity.class);
        AdquisicionEntity result = adquisicionPersistence.create(newEntity);

        Assert.assertNotNull(result);

        AdquisicionEntity entity = em.find(AdquisicionEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    
    
    
}
