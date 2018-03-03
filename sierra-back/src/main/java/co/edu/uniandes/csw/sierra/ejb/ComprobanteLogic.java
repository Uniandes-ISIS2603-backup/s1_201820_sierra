/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.ComprobanteEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.ComprobantePersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jc.sanchez12
 */
@Stateless
public class ComprobanteLogic {
    
    private static final Logger LOGGER = Logger.getLogger(ComprobanteLogic.class.getName());
    
    @Inject
    private ComprobantePersistence persistence; 
    
    public ComprobanteEntity create(ComprobanteEntity entity)throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de cración de una entidad de Comprobante");
        
        if(persistence.find(entity.getId()) != null)
            throw new BusinessLogicException("Ya existe una entidad Comprobante con e id dado: " + entity.getId());
        
        persistence.create(entity);
        LOGGER.info("Termmína proceso de creación de la entidad de Comprobante.");
        
        return entity;
        
    }
    
    public List<ComprobanteEntity> getAll()
    {
        LOGGER.info("Inicia el proceso de consultar todas las entidades de Comprobante.");
        List<ComprobanteEntity> entitys = persistence.findAll();
        LOGGER.info("Termina el proceso de consultar todas las entidades de Comprobante.");
        return entitys;
    }
    
    public ComprobanteEntity getById(Long id)
    {
        return persistence.find(id);
    }
    
    public ComprobanteEntity update(ComprobanteEntity entity)
    {
        return persistence.update(entity);
    }
    
    public void delete(Long id)
    {
        LOGGER.info("Inicia el proceso de borrar una entidad de Comprobante.");
        persistence.delete(id);
        LOGGER.info("Termína el proceso de borrar una entidad de Comprobante.");
    }
}
