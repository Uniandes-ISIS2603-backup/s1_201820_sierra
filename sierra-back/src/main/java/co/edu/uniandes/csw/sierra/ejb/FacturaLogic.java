/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.FacturaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.FacturaPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jc.sanchez12
 */
@Stateless
public class FacturaLogic {
    
    private final static Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());
    
    @Inject
    private FacturaPersistence persistence;
    
    public FacturaEntity create(FacturaEntity entity)throws BusinessLogicException
    {
        LOGGER.info("Iniciando el proceso de creación de una entidad de Factura.");
        if(persistence.find(entity.getId()) != null)
            throw new BusinessLogicException("Ya existe una entidad de Factura con el mismo id: " + entity.getId());
        
        persistence.create(entity);
        LOGGER.info("Terminando el proceso de creación de una entidad de factura.");
        return entity;
    }
    
    public List<FacturaEntity> getAll()
    {
        LOGGER.info("Comienza el proceso de consultar todas las entidaddes de Factura existentes.");
        List<FacturaEntity> entities = persistence.findAll();
        LOGGER.info("Termína el proceso de consultar todas las entidades de Factura existentes.");
        return entities;
    }
    
    public FacturaEntity getById(Long id)
    {
        return persistence.find(id);
    }
    
    public FacturaEntity update(FacturaEntity entity)
    {
        return persistence.update(entity);
    }
    
    public void delete(Long id)
    {
        LOGGER.info("Inicia el proceso de eliminar una entidad de factura.");
        persistence.delete(id);
        LOGGER.info("Termína el proceso de eliminar una entidad de factura.");
    }
}
