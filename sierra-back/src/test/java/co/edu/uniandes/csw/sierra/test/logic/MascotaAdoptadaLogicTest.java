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

import co.edu.uniandes.csw.sierra.ejb.AcontecimientoLogic;
import co.edu.uniandes.csw.sierra.ejb.MascotaAdoptadaLogic;
import co.edu.uniandes.csw.sierra.entities.AcontecimientoEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.MascotaAdoptadaPersistence;
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
public class MascotaAdoptadaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    /**
     * Inyección de la dependencia a la clase EspecieLogic cuyos métodos se van
     * a probar.
     */
    @Inject
    private MascotaAdoptadaLogic mascotaAdoptadaLogic;

    /**
     * Inyección de la dependencia a la clase EspeciePersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private MascotaAdoptadaPersistence mascotaAdoptadaPersistence;
    
    @Inject
    private AcontecimientoLogic aLogic;
    
    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager ent;
    
    /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction userTX;
    
     /**
     * Lista de guias
     */
    private List<MascotaAdoptadaEntity> data = new ArrayList<MascotaAdoptadaEntity>();

      /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Guia, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MascotaAdoptadaLogic.class.getPackage())
                .addPackage(MascotaAdoptadaEntity.class.getPackage())
                .addPackage(MascotaAdoptadaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Constructor por defecto
     */
    public MascotaAdoptadaLogicTest() {
        //Constructor por defecto
    }
    
    @Before
    public void setUp() {
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
        ent.createQuery("delete from MascotaAdoptadaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            MascotaAdoptadaEntity entity = factory.manufacturePojo(MascotaAdoptadaEntity.class);
            ent.persist(entity);
            data.add(entity);

        }
    }
     /**
     * Prueba para crear una MascotaAdoptada
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    @Test
    public void createMascotaAdoptadaTest() throws BusinessLogicException {
        MascotaAdoptadaEntity newEntity= factory.manufacturePojo(MascotaAdoptadaEntity.class);
        MascotaAdoptadaEntity resultado= mascotaAdoptadaLogic.createMascotaAdoptada(newEntity);
        Assert.assertNotNull(resultado);
        MascotaAdoptadaEntity entity= ent.find(MascotaAdoptadaEntity.class, resultado.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        
    }
    
     /**
     * Prueba para consultar la lista de Mascotas Adoptadas
     *
     */
    @Test
    public void getMascotasAdoptadasTest() {
        List<MascotaAdoptadaEntity> list = mascotaAdoptadaLogic.getAllMascotasAdoptadas();
        Assert.assertEquals(data.size(), list.size());
        for (MascotaAdoptadaEntity entity : list) {
            boolean found = false;
            for (MascotaAdoptadaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
     /**
     * Prueba para consultar un Especie
     *
     */
    @Test
    public void getMascotaAdoptadaTest() {
        MascotaAdoptadaEntity entity = data.get(0);
        MascotaAdoptadaEntity resultEntity = mascotaAdoptadaLogic.getMascotaAdoptadaById(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
        Assert.assertEquals(entity.getEdad(), resultEntity.getEdad());
        Assert.assertEquals(entity.getGenero(), resultEntity.getGenero());
        Assert.assertEquals(entity.getImagen(), resultEntity.getImagen());
        Assert.assertEquals(entity.getTamano(), resultEntity.getTamano());
        Assert.assertEquals(entity.getNacimientoFecha(), resultEntity.getNacimientoFecha());
    }
    
     /**
     * Prueba para eliminar un MascotaAdoptada
     *
     */
    @Test
    public void deleteMascotaTest() {
        MascotaAdoptadaEntity entity = data.get(0);
        mascotaAdoptadaLogic.deleteMascotaAdoptada(entity.getId());
        MascotaAdoptadaEntity deleted = ent.find(MascotaAdoptadaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
     /**
     * Prueba para actualizar un MascotaAdoptada
     */
    @Test
    public void updateMascotaTest() throws BusinessLogicException {
        MascotaAdoptadaEntity entity = data.get(0);
        MascotaAdoptadaEntity pojoEntity = factory.manufacturePojo(MascotaAdoptadaEntity.class);

        pojoEntity.setId(entity.getId());
        
        try {
            mascotaAdoptadaLogic.updateMascotaAdoptada(pojoEntity);
        } catch (Exception e) {
        }
        

        MascotaAdoptadaEntity resp = ent.find(MascotaAdoptadaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getEdad(), resp.getEdad());
        Assert.assertEquals(pojoEntity.getGenero(), resp.getGenero());
        Assert.assertEquals(pojoEntity.getImagen(), resp.getImagen());
        Assert.assertEquals(pojoEntity.getTamano(), resp.getTamano());
        Assert.assertEquals(pojoEntity.getNacimientoFecha(), resp.getNacimientoFecha());
    }
    
    @Test
    public void addAcontecimientoTest(){
        
        MascotaAdoptadaEntity mEnt = factory.manufacturePojo(MascotaAdoptadaEntity.class);
        AcontecimientoEntity aEnt = factory.manufacturePojo(AcontecimientoEntity.class);
        System.out.println("====================================\n==========================================\n");
        try{
            mEnt = mascotaAdoptadaLogic.createMascotaAdoptada(mEnt);
            aEnt = aLogic.create(aEnt);
            mascotaAdoptadaLogic.addAcontecimiento(mEnt.getId(), aEnt.getId());
            MascotaAdoptadaEntity newEnt = mascotaAdoptadaLogic.getMascotaAdoptadaById(mEnt.getId());
            aLogic.delete(aEnt.getId());
            mascotaAdoptadaLogic.deleteMascotaAdoptada(mEnt.getId());
            
        } catch (BusinessLogicException ex) {
            Assert.fail("no deberia causar exception");
        }
        
    }
    
}
