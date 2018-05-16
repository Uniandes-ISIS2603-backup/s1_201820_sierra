/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.ComprobanteEntity;
import co.edu.uniandes.csw.sierra.entities.FacturaEntity;
import co.edu.uniandes.csw.sierra.entities.MedioDePagoEntity;
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
    
    @Inject
    private MedioDePagoLogic medioDePagoLogic;
    
    @Inject 
    private FacturaLogic facturaLogic;
    
  
    public void create(ComprobanteEntity entity, Long medioDePagoId, Long facturaId)throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de cración de una entidad de Comprobante");
         
        MedioDePagoEntity medioPago = medioDePagoLogic.getMedioDePago(medioDePagoId);
        if(medioPago == null)
            throw new BusinessLogicException("El medio de pago con el id dado por parámetro no existe.");
        FacturaEntity factura = facturaLogic.getById(facturaId);
        if(factura == null)
            throw new BusinessLogicException("La factura con el id dado por parámetro no existe.");
         
        entity = addMedioDePago(entity.getId(), medioDePagoId);
        entity = addFactura(entity.getId(), facturaId);
        persistence.create(entity);
        System.out.println(">----------------------------------< \n \nComprobante Id: "+entity.getId() +"cliente Id: " + entity.getClienteId()
        +"\n \n >----------------------------------<");
        
        LOGGER.info("Termmína proceso de creación de la entidad de Comprobante.");      
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
    
    public ComprobanteEntity update(ComprobanteEntity entity) throws BusinessLogicException
    {  //TODO: NO hay ninguna regla de negocio? 
        LOGGER.info("Inicia el proceso de actualizar una factura.");
        if(persistence.find(entity.getId()) == null)
            throw new BusinessLogicException("No existe un comprobante con el id dado.");
        LOGGER.info("Termina el proceso de actualizar una factuar.");
        return persistence.update(entity);
    }
    
    public ComprobanteEntity delete(Long id)throws BusinessLogicException
    {
        LOGGER.info("Inicia el proceso de borrar una entidad de Comprobante.");
       //TODO: Hay que validar que existe Comprobante con ese id  
       if(persistence.find(id) == null)
           throw new BusinessLogicException("No existe un comprobante con el id dado.");
       
        ComprobanteEntity entity = persistence.delete(id);
        LOGGER.info("Termína el proceso de borrar una entidad de Comprobante.");
        return entity;
    }
    
    public ComprobanteEntity addMedioDePago(Long comprobanteId, Long medioDePagoId)throws BusinessLogicException
    {
        ComprobanteEntity comprobanteEntity = getById(comprobanteId);
        MedioDePagoEntity medioDePagoEntity = medioDePagoLogic.getMedioDePago(medioDePagoId);
        comprobanteEntity.setMedioDePago(medioDePagoEntity);
        medioDePagoEntity.setComprobante(comprobanteEntity);
        return comprobanteEntity;
    }
    
    public ComprobanteEntity addFactura(Long comprobanteId, Long facturaId)
    {
        ComprobanteEntity comprobanteEntity = getById(comprobanteId);
        FacturaEntity facturaEntity = facturaLogic.getById(facturaId);
        comprobanteEntity.setFactura(facturaEntity);
        facturaEntity.setComprobante(comprobanteEntity);
        return comprobanteEntity;
    }
}
