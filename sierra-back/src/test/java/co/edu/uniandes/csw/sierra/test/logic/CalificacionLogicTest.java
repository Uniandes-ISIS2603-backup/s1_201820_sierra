/*
MIT License

Copyright (c) 2017 ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.sierra.test.logic;

import co.edu.uniandes.csw.sierra.ejb.CalificacionLogic;
import co.edu.uniandes.csw.sierra.entities.CalificacionEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.CalificacionPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Juan David Zambrano
 */
@RunWith(Arquillian.class)
public class CalificacionLogicTest {
    
    /**
     * PodamFactory
     */
    private PodamFactory factory = new PodamFactoryImpl();
    
    /**
     * Injeccion de la clase que se va a probar
     */
    @Inject
    private CalificacionLogic calLogic; 
    
    /**
     * Injeccion  de la clase de persistencia
     */
    @Inject
    private CalificacionPersistence calPersistence; 
    
    /**
     * Manejador de persistencia
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Marcador de transacciones
     */
    @Inject
    private UserTransaction ussrTX;
    
    private List<CalificacionEntity> data = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionLogic.class.getPackage())
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(CalificacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    public CalificacionLogicTest(){
        //Constructor Vacio
    }
    
    @Before
    public void setUp() {
        try {
            ussrTX.begin();
            clearData();
            insertData();
            ussrTX.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                ussrTX.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
     private void clearData() {
        em.createQuery("delete from CalificacionEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CalificacionEntity entity = factory.manufacturePojo(CalificacionEntity.class);
            em.persist(entity);
            data.add(entity);

        }
    }
    
        /**
     * Prueba para crear una Calificacion
     */
    @Test
    public void createCalificacionTest(){
        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        try{
            CalificacionEntity result = calLogic.create(newEntity);
            Assert.assertNotNull(result);
            CalificacionEntity entity = em.find(CalificacionEntity.class, result.getId());
            Assert.assertEquals(newEntity.getName(), entity.getName());
            Assert.assertEquals(newEntity.getValor(), entity.getValor());
        }catch(BusinessLogicException e){
            fail("No deberia crear exception");
        }

        
        
    }
    
    /**
     * Prueba que se pueden recuperar los objetos de la base de datos
     */
    @Test
    public void getCalificacionesTest(){
        List<CalificacionEntity> list =  calLogic.getAll();
        //Revisa que ambas listas tengan el mismo tamano
        Assert.assertEquals(data.size(), list.size());
        for(CalificacionEntity ent: list){
            boolean fand= false;
            //Revisa que ambas calificaciones tengan el mismo ID
            for(CalificacionEntity ent2: data){
                if(ent.getId().equals(ent2.getId())){
                    fand = true;
                }
            }
            Assert.assertTrue(fand);
        }
    }
    /**
     * test para obtener una Calificacion en especifico
     */
    @Test
    public void getCalificacionTest(){
        CalificacionEntity ent = data.get(0);
        CalificacionEntity ent2 = calLogic.getById(ent.getId());
        Assert.assertNotNull(ent2);
        Assert.assertEquals(ent.getName(), ent2.getName());
        Assert.assertEquals(ent.getValor(), ent2.getValor());
    }

    /**
     * Prueba para borrar una Calificacion
     */
    @Test
    public void deleteCalificacionTest(){
        CalificacionEntity ent = data.get(0);
        try {
            calLogic.delete(ent.getId());
        } catch (Exception ex) {
            fail();
        }
        CalificacionEntity notFound = em.find(CalificacionEntity.class, ent.getId());
        Assert.assertNull(notFound);
        
    }
    /**
     * Test para actualizar una Calificacion
     */
    @Test
    public void updateCalificacionTest(){
        CalificacionEntity ent = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CalificacionEntity newEnt = factory.manufacturePojo(CalificacionEntity.class);
        newEnt.setId(ent.getId());
        
        try {
            calLogic.update(newEnt);
            CalificacionEntity retrievedEnt = em.find(CalificacionEntity.class, ent.getId());
        Assert.assertEquals(newEnt.getName(), retrievedEnt.getName());
        } catch (BusinessLogicException ex) {
            fail("No deberia generar Exception");
        }
        
        
    }
    
}
