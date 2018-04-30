/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.test.logic;

import co.edu.uniandes.csw.sierra.ejb.MedioDePagoLogic;
import co.edu.uniandes.csw.sierra.entities.ClienteEntity;
import co.edu.uniandes.csw.sierra.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.MedioDePagoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
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
 * @author de.gutierrez
 */
@RunWith(Arquillian.class)
public class MedioDePagoLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private MedioDePagoLogic medioDePago;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<MedioDePagoEntity> data = new ArrayList<MedioDePagoEntity>();
     /**
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Guia, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeploment(){
        return  ShrinkWrap.create(JavaArchive.class)
                .addPackage(MedioDePagoEntity.class.getPackage())
                .addPackage(MedioDePagoLogic.class.getPackage())
                .addPackage(MedioDePagoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");              
    }
    /**
     * Constructor por defecto.
     */
    public MedioDePagoLogicTest(){
        
    }
    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void setUp(){
        try {
            utx.begin();
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
    private void clearData(){
        em.createQuery("delete from MedioDePagoEntity").executeUpdate();
    }
      /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        
        for(int i=0;i<3;i++)
        {
            MedioDePagoEntity entity = factory.manufacturePojo(MedioDePagoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un MedioDePago.
     * @throws BusinessLogicException Si ya existe un cliente.
     */
    @Test
    public void createMedioDePagoTest () throws BusinessLogicException{ 
        MedioDePagoEntity newEntity = factory.manufacturePojo(MedioDePagoEntity.class);
        MedioDePagoEntity result = medioDePago.createMedioDePago(newEntity);
        Assert.assertNotNull(result);
        MedioDePagoEntity entity = em.find(MedioDePagoEntity.class,result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
        Assert.assertEquals(newEntity.getNumeroReferencia(), entity.getNumeroReferencia());
        
    }
    /**
     * Prueba para consultar la lista de MedioDePago.
     */
    @Test
    public void geMediosDePagoTest(){
       List<MedioDePagoEntity> list = medioDePago.getMediosDePago();
       Assert.assertEquals(data.size(), list.size());
       for(MedioDePagoEntity entity : list){
           boolean found = false;
           for(MedioDePagoEntity storeEntity : data){
               if(entity.getId().equals(storeEntity.getId())){
                   found = true;
               }
           }
           Assert.assertTrue(found);
       }
    }
     /**
     * Prueba consultar un MedioDePago.
     */
    @Test
    public void getMedioDePagoTest(){
       MedioDePagoEntity entity = data.get(0);
       MedioDePagoEntity result = medioDePago.getMedioDePago(entity.getId());
       Assert.assertNotNull(result);
       Assert.assertEquals(entity.getId(), result.getId());
       Assert.assertEquals(entity.getTipo(), result.getTipo());
       Assert.assertEquals(entity.getNumeroReferencia(), result.getNumeroReferencia());
    }
    
    /**
     * Prueba para actualizar un MedioDePago.
     **/
    @Test
    public void updateMedioDePagoTest() throws BusinessLogicException {
      MedioDePagoEntity entity = data.get(0);
      MedioDePagoEntity pojoEntity = factory.manufacturePojo(MedioDePagoEntity.class);
      pojoEntity.setId(entity.getId());
      medioDePago.updateMedioDePago(pojoEntity.getId(), pojoEntity);
      MedioDePagoEntity resp = em.find(MedioDePagoEntity.class, entity.getId());
      Assert.assertEquals(pojoEntity.getId(), resp.getId());
      Assert.assertEquals(pojoEntity.getTipo(), resp.getTipo());
      Assert.assertEquals(pojoEntity.getNumeroReferencia(), resp.getNumeroReferencia());
    }
     /**
     * Prueba para eliminar un MedioDePago.
     */
    @Test
    public void deleteMedioDePagoTest(){
       MedioDePagoEntity entity = data.get(0);
       medioDePago.deleteMedioDePago(entity.getId());
       MedioDePagoEntity deleted = em.find(MedioDePagoEntity.class, entity.getId());
       Assert.assertNull(deleted);
    }
}
