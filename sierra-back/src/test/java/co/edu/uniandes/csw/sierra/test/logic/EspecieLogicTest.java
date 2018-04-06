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

import co.edu.uniandes.csw.sierra.ejb.EspecieLogic;
import co.edu.uniandes.csw.sierra.entities.EspecieEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.EspeciePersistence;
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
public class EspecieLogicTest 
{
    private final PodamFactory factory = new PodamFactoryImpl();
    
    /**
     * Inyección de la dependencia a la clase EspecieLogic cuyos métodos se van
     * a probar.
     */
    @Inject
    private EspecieLogic especieLogic;

    /**
     * Inyección de la dependencia a la clase EspeciePersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private EspeciePersistence especiePersistence;
    
    
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
    private List<EspecieEntity> data = new ArrayList<EspecieEntity>();

      /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Guia, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EspecieLogic.class.getPackage())
                .addPackage(EspecieEntity.class.getPackage())
                .addPackage(EspeciePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Constructor por defecto
     */
    public EspecieLogicTest() {
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
        ent.createQuery("delete from EspecieEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            EspecieEntity entity = factory.manufacturePojo(EspecieEntity.class);
            ent.persist(entity);
            data.add(entity);

        }
    }
     /**
     * Prueba para crear un Especie
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    @Test
    public void createEspecieTest() throws BusinessLogicException {
        EspecieEntity newEntity= factory.manufacturePojo(EspecieEntity.class);
        EspecieEntity result = especieLogic.createEspecie(newEntity);
        Assert.assertNotNull(result);
        EspecieEntity entity = ent.find(EspecieEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getCaracteristicas(), entity.getCaracteristicas());
        Assert.assertEquals(newEntity.getClasificacion(), entity.getClasificacion());
    }
    
     /**
     * Prueba para consultar la lista de Especie
     *
     */
    @Test
    public void getEspeciesTest() {
        List<EspecieEntity> list = especieLogic.getAllEspecies();
        Assert.assertEquals(data.size(), list.size());
        for (EspecieEntity entity : list) {
            boolean found = false;
            for (EspecieEntity storedEntity : data) {
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
    public void getEspecieTest() {
        EspecieEntity entity = data.get(0);
        EspecieEntity resultEntity = especieLogic.getEspecieById(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
        Assert.assertEquals(entity.getCaracteristicas(), resultEntity.getCaracteristicas());
        Assert.assertEquals(entity.getClasificacion(), resultEntity.getClasificacion());
    }
    
     /**
     * Prueba para eliminar un Especie
     *
     */
    @Test
    public void deleteEspecieTest() {
        EspecieEntity entity = data.get(0);
        especieLogic.deleteEspecie(entity.getId());
        EspecieEntity deleted = ent.find(EspecieEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
     /**
     * Prueba para actualizar un Especie
     */
    @Test
    public void updateEspecieTest() {
        EspecieEntity entity = data.get(0);
        EspecieEntity pojoEntity = factory.manufacturePojo(EspecieEntity.class);

        pojoEntity.setId(entity.getId());

        especieLogic.updateEspecie(pojoEntity);

        EspecieEntity resp = ent.find(EspecieEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getCaracteristicas(), resp.getCaracteristicas());
        Assert.assertEquals(pojoEntity.getClasificacion(), resp.getClasificacion());
    }
}

