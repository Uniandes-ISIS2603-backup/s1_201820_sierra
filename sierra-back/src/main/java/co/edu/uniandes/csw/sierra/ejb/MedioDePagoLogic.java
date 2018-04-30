/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.ClienteEntity;
import co.edu.uniandes.csw.sierra.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.MedioDePagoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author de.gutierrez
 */
@Stateless
public class MedioDePagoLogic {

    private static final Logger LOGGER = Logger.getLogger(MedioDePagoLogic.class.getName());
    @Inject
    private MedioDePagoPersistence persistence;
    

    /**
     * Crea una nueva entidad MedioDePago.
     *
     * @param idCliente
     * @param entity La entidad de tipo MedioDePago que se va a persistir.
     * @return La entidad luego de persistirla.
     * @throws BusinessLogicException Si ya existe un MedioDePago con esa
     * informacion.
     */
    public MedioDePagoEntity createMedioDePago(MedioDePagoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia el proceso de creacion de un nuevo medio de pago");
        if(persistence.findByReferencia(entity.getNumeroReferencia()) != null)
        {
            throw new BusinessLogicException("Ya existe un medio de pago con ese numero de referencia:" + entity.getNumeroReferencia());        
        }
        else if(persistence.findByTipo(entity.getTipo()) != null)
        {
            throw new BusinessLogicException("Ya existe un medio de pago con ese tipo:" + entity.getTipo());
        }
        persistence.create(entity);
        LOGGER.info("Termina el proceso de creacion del medio de pago");
        return entity;
    }

    /**
     * *
     * Obtiene todos los MedioDePago que hay en la base de datos.
     *
     * @return Lista de la entidades de tipo MedioDePago.
     */
    public List<MedioDePagoEntity> getMediosDePago()  {
        LOGGER.info("Inicia el proceso de consultar todos los medio de pago");
        List<MedioDePagoEntity> list = persistence.findAll();
        LOGGER.info("Termina el proceso de consultar todos los medio de pago");
        return list;
    }

    /**
     * Obtiene un MedioDePago con el id especificado.
     * @param id
     * @param clienteId
     * @param medioId
     * @return El MedioDePago correspondiente a el id.
     */
    
    public MedioDePagoEntity getMedioDePago(Long id) {
        LOGGER.log(Level.INFO,"Inicia el proceso de consultar un medio de pago con id={0}", id);
        MedioDePagoEntity medio = persistence.find(id);
        if(medio == null)
        {
            LOGGER.log(Level.SEVERE, "El medio de pago con el id={0} no existe", id);
        }
        return  medio;
        
    }

    /**
     * Actualiza un MedioDePago con el id dado.
     *
     * @param idCliente
     * @param entity Nueva informacion del MedioDePago.
     * @return La entidad MedioDePago con la nueva informacion.
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    
    public MedioDePagoEntity updateMedioDePago(Long id, MedioDePagoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.SEVERE, "Inicia el proceso de actualizar un medio de pago");
        MedioDePagoEntity medio = persistence.find(id);
        if(medio == null)
        {
            LOGGER.log(Level.SEVERE, "El medio de pago con el id={0} no existe para ser actualizado", entity.getId());
        }
        else if (persistence.findByReferencia(entity.getNumeroReferencia()) != null)
        {
          throw new BusinessLogicException("Ya existe un medio de pago con ese numero de referencia:" + entity.getNumeroReferencia());        
        }
        else if(persistence.findByTipo(entity.getTipo()) != null)
        {
            throw new BusinessLogicException("Ya existe un medio de pago con ese tipo:" + entity.getTipo());
        }
        persistence.update(entity);
        return entity;
    }

    /**
     * *
     * Elimina un MedioDePago segun el id.
     *
     * @param id Identificador del MedioDePago a eliminar.
     */
    public void deleteMedioDePago( Long id) {
        LOGGER.log(Level.SEVERE, "Inicia el proceso de eliminar un cliente");
        MedioDePagoEntity medio = persistence.find(id); 
        if(medio == null)
        {
            LOGGER.log(Level.SEVERE, "El medio de pago con el id={0} no existe para ser elimiado", medio.getId());
        }
        persistence.delete(id);
        LOGGER.log(Level.SEVERE, "Termina el proceso de eliminar un medui de pago");    
    }

    public List<ClienteEntity> listClientes (Long id)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los clientes del medio de pago con id = {0}", id);
        return getMedioDePago(id).getClientes();
    }
    
   public ClienteEntity getCliente (Long id, Long clienteId){
       LOGGER.log(Level.INFO, "Inicia proceso de consultar un cliente que utiliza el medio de pago con id = {0}", id);
       List<ClienteEntity> list = getMedioDePago(id).getClientes();
       ClienteEntity clientesEntity = new ClienteEntity();
       clientesEntity.setId(clienteId);
       int index = list.indexOf(clientesEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
   }
   
   public ClienteEntity addCliente(Long id, Long clienteId){
       MedioDePagoEntity medio = getMedioDePago(id);
       ClienteEntity cliente = new ClienteEntity();
       cliente.setId(clienteId);
       medio.getClientes().add(cliente);
       return getCliente(id, clienteId);
   }
   
   public List<ClienteEntity> replaceCliente (Long id, List<ClienteEntity> list){
       MedioDePagoEntity medio = getMedioDePago(id);
       medio.setClientes(list);
       return medio.getClientes();
   }
   
   public void removeCliente(Long id, Long clienteId){
       MedioDePagoEntity medio = getMedioDePago(id);
       ClienteEntity cliente = new ClienteEntity();
       medio.getClientes().remove(cliente);
   }
}
