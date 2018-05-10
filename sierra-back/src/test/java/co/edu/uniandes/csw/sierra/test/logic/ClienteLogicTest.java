/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.test.logic;

import co.edu.uniandes.csw.sierra.ejb.ClienteLogic;
import co.edu.uniandes.csw.sierra.entities.ClienteEntity;
import co.edu.uniandes.csw.sierra.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.ClientePersistence;
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
 * @author de.gutierrez
 */
@RunWith(Arquillian.class)
public class ClienteLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private ClienteLogic clienteLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
   
    private final List<ClienteEntity> data;
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Guia, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyecciÃ³n de dependencias.
     */
    @Deployment
    public static JavaArchive createDeploment(){
        return  ShrinkWrap.create(JavaArchive.class)
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClienteLogic.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");              
    }
    
    /**
     * Constructor por defecto.
     */
    public ClienteLogicTest(){
        this.data = new ArrayList<>();
        
    }
    /**
     * ConfiguraciÃ³n inicial de la prueba.
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
     * Limpia las tablas que estÃ¡n implicadas en la prueba.
     */
    private void clearData(){
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }
      /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un cliente.
     * @throws BusinessLogicException Si ya existe un cliente.
     */
    @Test
    public void createClienteTest () throws BusinessLogicException{
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
        ClienteEntity result = clienteLogic.createCliente(newEntity);
        Assert.assertNotNull(result);
        ClienteEntity entity = em.find(ClienteEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getApellido(), entity.getApellido());
        Assert.assertEquals(newEntity.getCedula(), entity.getCedula());
        Assert.assertEquals(newEntity.getTelefono(), entity.getTelefono());
    }
    /**
     * Prueba para consultar la lista de clientes.
     */
    @Test
    public void getClientesTest(){
        List<ClienteEntity> list = clienteLogic.getClientes();
        Assert.assertEquals(data.size(), list.size());
        for(ClienteEntity entity : list){
            boolean found = false;
            for(ClienteEntity storeEntity : data){
                if(entity.getId().equals(storeEntity.getId())){
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba consultar un cliente.
     */
    @Test
    public void getClienteTest(){
        ClienteEntity entity = data.get(0);
        ClienteEntity result = clienteLogic.getCliente(entity.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getNombre(), result.getNombre());
        Assert.assertEquals(entity.getApellido(), result.getApellido());
        Assert.assertEquals(entity.getCedula(), result.getCedula());
        Assert.assertEquals(entity.getTelefono(), result.getTelefono());   
    }
    /**
     * Prueba para actualizar un cliente.
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     **/
    @Test
    public void updateClienteTest() throws BusinessLogicException{
        ClienteEntity entity = data.get(0);
        ClienteEntity pojoEntity = factory.manufacturePojo(ClienteEntity.class);
        pojoEntity.setId(entity.getId());
        clienteLogic.updateCliente(pojoEntity.getId(), pojoEntity);
        ClienteEntity resp = em.find(ClienteEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getApellido(), resp.getApellido());
        Assert.assertEquals(pojoEntity.getCedula(), resp.getCedula());
        Assert.assertEquals(pojoEntity.getTelefono(), resp.getTelefono()); 
    }
    
    /**
     * Prueba para eliminar un cliente.
     */
    @Test
    public void deleteClienteTest(){
        ClienteEntity entity = data.get(0);
        clienteLogic.deleteCliente(entity.getId());
        ClienteEntity deleted = em.find(ClienteEntity.class, entity.getId());
        Assert.assertNull(deleted );
    }
    
    /**
     * Prueba para obtener los medios de pago de un cliente.
     */
    @Test
    public void getMediosDePagoCliente(){
        ClienteEntity cliente = data.get(0);
        List<MedioDePagoEntity> list = clienteLogic.listMedios(cliente.getId());
        int cantidad = data.get(0).getMediosDePago().size();
        Assert.assertEquals(cantidad, list.size());
        for(MedioDePagoEntity entity : list){
            boolean found = false;
            for(MedioDePagoEntity storeEntity : data.get(0).getMediosDePago()){
                if(entity.getId().equals(storeEntity.getId())){
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
