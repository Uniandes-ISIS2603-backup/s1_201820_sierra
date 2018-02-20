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


import co.edu.uniandes.csw.sierra.entities.MascotaEntity;
import co.edu.uniandes.csw.sierra.persistence.MascotaPersistence;
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
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jc.sanchez12
 */
@RunWith(Arquillian.class)
public class MascotaPersistenceTest
{
    
     /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Company, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MascotaEntity.class.getPackage())
                .addPackage(MascotaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

     /**
     * Inyección de la dependencia a la clase MascotaPersistence cuyos métodos
     * se van a probar.
     */    
    @Inject
    private MascotaPersistence mascotaPersistence;
    
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
    
    private List<MascotaEntity> data = new ArrayList<MascotaEntity>();
    
    
     /**
     * Prueba para crear una Mascoat.
     */    
    @Test
    public void createMascota()
    {
         PodamFactory factory = new PodamFactoryImpl();
         MascotaEntity newEntity= factory.manufacturePojo(MascotaEntity.class);
         MascotaEntity result= mascotaPersistence.create(newEntity);
         
         Assert.assertNotNull(result);
         
         MascotaEntity entity = em.find(MascotaEntity.class, result.getId());
         
         Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
         Assert.assertEquals(newEntity.getColor(), entity.getColor());
         Assert.assertEquals(newEntity.getEdad(), entity.getEdad());
         Assert.assertEquals(newEntity.getGenero(), entity.getGenero());
         Assert.assertEquals(newEntity.getImagen(), entity.getImagen());
         Assert.assertEquals(newEntity.getNacimiento(), entity.getNacimiento());
         Assert.assertEquals(newEntity.getMuerte(), entity.getMuerte());
         Assert.assertEquals(newEntity.getTamano(), entity.getTamano());
    }
}
