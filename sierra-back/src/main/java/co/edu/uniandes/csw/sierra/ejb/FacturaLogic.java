/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.FacturaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.AdquisicionPersistence;
import co.edu.uniandes.csw.sierra.persistence.ComprobantePersistence;
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
    private FacturaPersistence facturaPersistence;
    
    @Inject 
    private AdquisicionPersistence adquisicionPersistence;
    
    @Inject
    private ComprobantePersistence comprobantePersistence;
    
    
    
    public FacturaEntity create(FacturaEntity entity)throws BusinessLogicException
    {
        LOGGER.info("Iniciando el proceso de creación de una entidad de Factura.");
       
        if(entity.getValor() == null || entity.getIdCliente() == null || entity.getNombreCliente() == null)
            throw new BusinessLogicException("La información suministrada para la creación de la factura está incompleta.");
        
        facturaPersistence.create(entity);
        LOGGER.info("Terminando el proceso de creación de una entidad de factura.");
        return entity;
    }
    
    public List<FacturaEntity> getAll()
    {
        LOGGER.info("Comienza el proceso de consultar todas las entidaddes de Factura existentes.");
        List<FacturaEntity> entities = facturaPersistence.findAll();
        LOGGER.info("Termína el proceso de consultar todas las entidades de Factura existentes.");
        return entities;
    }
    
    public FacturaEntity getById(Long id)
    {
        return facturaPersistence.find(id);
    }
    
    public FacturaEntity update(FacturaEntity entity)throws BusinessLogicException
    {//TODO: No hay ninguna regla de negocio? 
        
        LOGGER.info("Comienza el proceso de actualizar una factura.");
        if(facturaPersistence.find(entity.getId()) == null)
            throw new BusinessLogicException("No existe una entidad con el id dado.");
        LOGGER.info("Termína el proceso de actualizar un comprobante.");
        return facturaPersistence.update(entity);
    }
    
    public void delete(Long id)throws BusinessLogicException
    {
        LOGGER.info("Inicia el proceso de eliminar una entidad de factura.");
       
       if(facturaPersistence.find(id) == null)
           throw new BusinessLogicException("No existe una factura con el id dado.");
       
        facturaPersistence.delete(id);
        LOGGER.info("Termína el proceso de eliminar una entidad de factura.");
    }
}
