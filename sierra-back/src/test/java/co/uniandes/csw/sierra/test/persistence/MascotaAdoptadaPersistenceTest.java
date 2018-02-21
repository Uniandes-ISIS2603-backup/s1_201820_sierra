/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

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
package co.uniandes.csw.sierra.test.persistence;


import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaEntity;
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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jc.sanchez12
 */
@RunWith(Arquillian.class)
public class MascotaAdoptadaPersistenceTest 
{
     /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private MascotaAdoptadaPersistence mascotaAdoptadaPersistence;
    
    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;
    
     /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
    
     /**
     *
     */
    private List<MascotaAdoptadaEntity> data = new ArrayList<MascotaAdoptadaEntity>();
    
    
    
     /**
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Company, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment()
    {
      return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MascotaAdoptadaEntity.class.getPackage())
                .addPackage(MascotaAdoptadaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");  
    }
    
     /**
     * Configuración inicial de la prueba.
     *
     *
     */
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
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
    private void clearData() {
        em.createQuery("delete from MascotaAdoptadaEntity").executeUpdate();
    }
    
   /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            MascotaAdoptadaEntity entity = factory.manufacturePojo(MascotaAdoptadaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una  MascotaAdoptadaPersistence.
     */
    @Test
    public void testCreate() {
            PodamFactory factory = new PodamFactoryImpl();
            MascotaAdoptadaEntity newEntity = factory.manufacturePojo(MascotaAdoptadaEntity.class);
            MascotaAdoptadaEntity result = mascotaAdoptadaPersistence.create(newEntity);

            Assert.assertNotNull(result);
            MascotaAdoptadaEntity entity = em.find(MascotaAdoptadaEntity.class, result.getId());
            Assert.assertNotNull(entity);
            Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
            Assert.assertEquals(newEntity.getEdad(), entity.getEdad());
            Assert.assertEquals(newEntity.getGenero(), entity.getGenero());
            Assert.assertEquals(newEntity.getImagen(), entity.getImagen());
            Assert.assertEquals(newEntity.getTamano(), entity.getTamano());
            Assert.assertEquals(newEntity.getNacimientoFecha(), entity.getNacimientoFecha());
         
    }
    
    /**
     * Prueba para  consultar la lista  de Mascotas Adoptadas
     */
    @Test
    public void getMascotasAdoptadasTest() {
        List<MascotaAdoptadaEntity> list= mascotaAdoptadaPersistence.findAll();
        Assert.assertEquals(list.size(), data.size());
        for (MascotaEntity ent : list) {
             boolean found = false;
            for (MascotaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }  
            } 
             Assert.assertTrue(found);
        }
    }
   
     /**
     * Prueba para consultar una Mascota Adoptada.
     */    
    @Test
    public void getMascotaAdoptadaTest() {
        MascotaAdoptadaEntity entity = data.get(0);
        MascotaAdoptadaEntity newEntity = mascotaAdoptadaPersistence.findById(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(newEntity.getEdad(), entity.getEdad());
        Assert.assertEquals(newEntity.getGenero(), entity.getGenero());
        Assert.assertEquals(newEntity.getImagen(), entity.getImagen());
        Assert.assertEquals(newEntity.getTamano(), entity.getTamano());
        Assert.assertEquals(newEntity.getNacimientoFecha(), entity.getNacimientoFecha());
        
    }
  
     /**
     * Prueba para eliminar una Mascota Adoptada
     */
    @Test
    public void deleteMascotaAdoptadaTest() {
        MascotaAdoptadaEntity entity = data.get(0);
        mascotaAdoptadaPersistence.delete(entity.getId());
        MascotaAdoptadaEntity deleted = em.find(MascotaAdoptadaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    
     /**
     * Prueba para actualizar una Especie.
     */    
    @Test
    public void updateEspecieTest() {
        MascotaAdoptadaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        MascotaAdoptadaEntity newEntity = factory.manufacturePojo(MascotaAdoptadaEntity.class);

        newEntity.setId(entity.getId());

        mascotaAdoptadaPersistence.update(newEntity);
        
        MascotaAdoptadaEntity resp = em.find(MascotaAdoptadaEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(newEntity.getEdad(), resp.getEdad());
        Assert.assertEquals(newEntity.getGenero(), resp.getGenero());
        Assert.assertEquals(newEntity.getImagen(), resp.getImagen());
        Assert.assertEquals(newEntity.getTamano(), resp.getTamano());
        Assert.assertEquals(newEntity.getNacimientoFecha(), resp.getNacimientoFecha());
        
    } 
    
}
