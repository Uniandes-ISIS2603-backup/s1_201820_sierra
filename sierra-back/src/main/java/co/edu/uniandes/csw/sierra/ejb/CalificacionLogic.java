/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.CalificacionEntity;
import co.edu.uniandes.csw.sierra.persistence.CalificacionPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author jc.sanchez12
 */
public class CalificacionLogic {
    
    private static final Logger LOGGER = Logger.getLogger( CalificacionLogic.class.getName( ) );
    
    @Inject
    private CalificacionPersistence persistence;
    
    public CalificacionEntity create (CalificacionEntity ent){
        
        LOGGER.info("Creando una entidad de Calificacion");
        //TODO: agregar reglas de negocio
        persistence.create(ent);
        LOGGER.info("Creada la entidad de Calificacion");
        return ent;
    }
    
    public List<CalificacionEntity> getAll(){
        LOGGER.info("Consultando todas las entidades de Calificacion");
        List<CalificacionEntity> list = persistence.findAll();
        LOGGER.info("Consultadas todas las entidades de Calificacion");
        return list;
    }
    
    

}
