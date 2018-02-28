/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.test.logic;

import co.edu.uniandes.csw.sierra.ejb.FacturaLogic;
import co.edu.uniandes.csw.sierra.ejb.MascotaAdoptadaLogic;
import co.edu.uniandes.csw.sierra.entities.FacturaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.persistence.FacturaPersistence;
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
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ja.amortegui10
 */
@RunWith(Arquillian.class)
public class FacturaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    /**
     * Inyección de la dependencia FacturaLogic, cuyos métodos se probarán.
     */
    @Inject
    private FacturaLogic logic;
    
    /**
     * Inyección de la dependencia FacturaPersistence, cuyos métodos probarán.
     */
    @Inject
    private FacturaPersistence persistence;
    
    /**
     * Contexto de persistencia que se va a utilizar para acceder a la base de datos por fuera de los métodos
     * que se están probando.
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Variable para marcar las transacciones del em anterior cuando se 
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction userTX;
    
    /**
     *Lista guias. 
     */
    private List<FacturaEntity> data = new ArrayList<FacturaEntity>();
    
    /**
     * 
     * @return el jar que Arquillian va a desplegar en el Glassfish embebido. 
     * El jar contiene las clases de guia, el descriptor de la base de datos 
     * y el archivo beans.xml para resolver la inyección de dependencias.
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
     * Constructor por defecto.
     */
    public FacturaLogicTest()
    {
        //Proceso Constructor.
    }
    
   
}
/**
 * @OneToMany(mappedBy = "nombreClaseLocal", cascade = CascadeType.All, orphanRemoval...
 */