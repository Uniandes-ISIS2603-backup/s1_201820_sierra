/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.sierra.test.persistence;


import co.edu.uniandes.csw.sierra.entities.CertificadoEntity;
import co.edu.uniandes.csw.sierra.persistence.CertificadoPersistence;
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
 * @author rj.gonzalez10
 */
@RunWith(Arquillian.class)
public class CertificadoPersistenceTest {
    
    /**
     * @return Devuelve el jar que se va a desplegar en glassfish 
     */
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CertificadoEntity.class.getPackage())
                .addPackage(CertificadoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private CertificadoPersistence certificadoPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    
    private List<CertificadoEntity> data = new ArrayList<>();
    
    /**
     * prepara los datos para la prueba
     */
    @Before
    public void setUp(){
        try{
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        }catch (Exception e){
            e.printStackTrace();
            try{
                utx.rollback();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    /**
     * limpia las tablas pertientes
     */
    private void clearData(){
        em.createQuery("delete from CertificadoEntity").executeUpdate();
    }
    
    /**
     * crea nuevos datos para la prueba
     */
    private void insertData(){
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i < 10; i++){
            CertificadoEntity ent = factory.manufacturePojo(CertificadoEntity.class);
            em.persist(ent);
            data.add(ent);
        }
    }
    
    
    /**
     * Prueba para crear una Calificacion
     */
    @Test
    public void createCertificadoTest(){
        PodamFactory factory = new PodamFactoryImpl();
        CertificadoEntity newEntity = factory.manufacturePojo(CertificadoEntity.class);
        CertificadoEntity result = certificadoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CertificadoEntity entity = em.find(CertificadoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
        
    }
    
    /**
     * Prueba que se pueden recuperar los objetos de la base de datos
     */
    @Test
    public void getCertificadosTest(){
        List<CertificadoEntity> list =  certificadoPersistence.findAll();
        //Revisa que ambas listas tengan el mismo tamano
        Assert.assertEquals(data.size(), list.size());
        for(CertificadoEntity ent: list){
            boolean fand= false;
            //Revisa que ambas calificaciones tengan el mismo ID
            for(CertificadoEntity ent2: data){
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
    public void getCertificadoTest(){
        CertificadoEntity ent = data.get(0);
        CertificadoEntity ent2 = certificadoPersistence.find(ent.getId());
        Assert.assertNotNull(ent2);
        Assert.assertEquals(ent.getId(), ent2.getId());
        Assert.assertEquals(ent.getImagen(), ent2.getImagen());
    }

    /**
     * Prueba para borrar una Calificacion
     */
    @Test
    public void deleteCertificadoTest(){
        CertificadoEntity ent = data.get(0);
        certificadoPersistence.delete(ent.getId());
        CertificadoEntity notFound = em.find(CertificadoEntity.class, ent.getId());
        Assert.assertNull(notFound);
        
    }
    /**
     * Test para actualizar una Calificacion
     */
    @Test
    public void updateCertificadoTest(){
        CertificadoEntity ent = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CertificadoEntity newEnt = factory.manufacturePojo(CertificadoEntity.class);
        newEnt.setId(ent.getId());
        certificadoPersistence.update(newEnt);
        CertificadoEntity retrievedEnt = em.find(CertificadoEntity.class, ent.getId());
        Assert.assertEquals(newEnt.getName(), retrievedEnt.getName());
        
    }
    
    
}
