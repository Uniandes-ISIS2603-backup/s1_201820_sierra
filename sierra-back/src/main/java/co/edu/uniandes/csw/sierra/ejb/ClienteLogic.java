/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.ClienteEntity;
import co.edu.uniandes.csw.sierra.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.ClientePersistence;
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
public class ClienteLogic 
{
    private static final Logger LOGGER = Logger.getLogger( ClienteLogic.class.getName( ) );
    @Inject
    private ClientePersistence persistence;
    @Inject 
    private MedioDePagoLogic medioLogic;
    
    /*
    @Inject 
    private AdquisicionLogic adqLogic;
    */
    
    /**
     * Crea una nueva entidad Cliente.
     * @param entity la entidad de tipo cliente que se va a persistir. 
     * @return La entidad luego de persistirla.
     * @throws BusinessLogicException Si ya existe un cliente con esa informacion.
     */
    public ClienteEntity createCliente(ClienteEntity entity) throws BusinessLogicException
    {
        LOGGER.info("Inicia el proceso de creacion de un nuevo cliente");

        if(persistence.findByCedula(entity.getCedula()) != null)
        {
            throw new BusinessLogicException("Ya existe un cliente con ese numero de cedula:" + entity.getCedula());
        }
        else if(persistence.findByCorreo(entity.getCorreo()) != null)
        {
            throw new BusinessLogicException("Ya existe un cliente con ese correo electronico:" + entity.getCorreo());
        }
        else if(persistence.findByTelefono(entity.getTelefono())!= null)
        {
            throw new BusinessLogicException("Ya existe un cliente con ese numero de telefono:" + entity.getTelefono());
        }
        persistence.create(entity);
        LOGGER.info("Termina el proceso de creacion del cliente");
        return entity;
    }
    /***
     * Obtiene todos los clientes que hay en la base de datos.
     * @return Lista de la entidades de tipo Cliente.
     */
    public List<ClienteEntity> getClientes()
    {
        LOGGER.info("Inicia el proceso de consultar todos los clientes");
        List<ClienteEntity> clientes = persistence.findAll();
        LOGGER.info("Termina el proceso de consultar todos los clientes");
        return clientes;
    }
    
    /**
     * Obtiene un cliente con el id especificado.
     * @param id El identificador del cliente buscado.
     * @return El cliente correspondiente a el id.
     */
    public ClienteEntity getCliente(Long id){
        LOGGER.log(Level.INFO,"Inicia el proceso de consultar un cliente con id={0}", id);
        ClienteEntity cliente = persistence.find(id);
        if(cliente == null)
        {
            LOGGER.log(Level.SEVERE, "El cliente con el id={0} no existe", id);
        }
        LOGGER.log(Level.SEVERE,"Termina el proceso de consultar un cliente con id={0}", id);
        return cliente;
    }
   
    /**
     * Actualiza un cliente con el id dado.
     * @param id Identificador del cliente que se quiere actualizar.
     * @param entity Nueva informacion del cliente.
     * @return La entidad cliente con la nueva informacion.
     * @throws BusinessLogicException Excepciones por reglas de negocio.
     */
    public ClienteEntity updateCliente (Long id, ClienteEntity entity) throws BusinessLogicException{
       LOGGER.log(Level.SEVERE, "Inicia el proceso de actualizar un cliente");
        ClienteEntity cliente = persistence.find(id);
        if(cliente == null)
        {
            LOGGER.log(Level.SEVERE, "El cliente con el id={0} no existe para ser actualizado", entity.getId());
        }
        else if(persistence.findByCedula(entity.getCedula()) != null)
        {
            throw new BusinessLogicException("Ya existe un cliente con ese numero de cedula:" + entity.getCedula());
        }
        else if(persistence.findByCorreo(entity.getCorreo()) != null)
        {
            throw new BusinessLogicException("Ya existe un cliente con ese correo electronico:" + entity.getCorreo());
        }
        else if(persistence.findByTelefono(entity.getTelefono())!= null)
        {
            throw new BusinessLogicException("Ya existe un cliente con ese numero de telefono:" + entity.getTelefono());
        }
       
        persistence.update(entity);
        LOGGER.log(Level.SEVERE, "Termina el proceso de actualizar un cliente");
        return entity;
    }
    
    /***
     * Elimina un cliente segun el id.
     * @param id Identificador del cliente a eliminar.
     */
    public void deleteCliente (Long id)
    {
        LOGGER.log(Level.SEVERE, "Inicia el proceso de eliminar un cliente");
        ClienteEntity cliente = persistence.find(id);
        if(cliente == null)
        {
            LOGGER.log(Level.SEVERE, "El cliente con el id={0} no existe para ser eliminado", id);
        }
        persistence.delete(id);
        LOGGER.log(Level.SEVERE, "Termina el proceso de eliminar un cliente");
    }

    /**
     * Obtiene una coleccion de las instacias de medio de pago asociadas a un cliente.
     * @param clienteId Identificador del cliente.
     * @return Coleccion con las instacias de medio de pago asociadas al cliente.
     */
    public List<MedioDePagoEntity> listMedios(Long clienteId){
        return getCliente(clienteId).getMediosDePago();
    }
    
    /**
     * Obtiene un medio de pago asociado al cliente.
     * @param clienteId Identificador del Medio de pago. 
     * @param medioId Identificador del cliente.
     * @return La instacia de medio de pago asociada al cliente con id especificado.
     */
    public MedioDePagoEntity getMedio (Long clienteId, Long medioId){
        List<MedioDePagoEntity> list = getCliente(clienteId).getMediosDePago();
        MedioDePagoEntity medio = new MedioDePagoEntity();
        medio.setId(medioId);
        int index = list.indexOf(medio);
        if(index >= 0){
            return list.get(index);
        }
        return null;
    }
    
    /**
     * Asocia un medio de pago a un cliente existente.
     * @param clienteId Identificador del cliente.
     * @param medioId Identificador del medio de pago a asociar.
     * @return El medio de pago asociado al cliente.
     */
    public MedioDePagoEntity addMedio (Long clienteId, Long medioId){
        medioLogic.addCliente(medioId, clienteId);
        return medioLogic.getMedioDePago(medioId);
    }
    
    /**
     * Reemplaza la informacion de los medios de pago asociados a un cliente.
     * @param clienteId Identificador del cliente.
     * @param list Coleccion de medios de pago con la nueva informacion a actualizar
     * respecto a los medios de pago asociados.
     * @return Los medios de pago asociados al cliente.
     */
    public List<MedioDePagoEntity> replaceMedio (Long clienteId, List<MedioDePagoEntity> list )
    {
        ClienteEntity cliente = getCliente(clienteId);
        List<MedioDePagoEntity> medios = cliente.getMediosDePago();
        for(MedioDePagoEntity medio : medios )
        {
            if(list.contains(medio)){
                if(!medio.getClientes().contains(cliente)){
                    medioLogic.addCliente(medio.getId(), clienteId);
                } else {
                    medioLogic.removeCliente(medio.getId(), clienteId);
                }
            }
        }
        cliente.setMediosDePago(medios);
        return cliente.getMediosDePago();
    }
    
    /**
     * Desasocia un medio de pago existente de un cliente.
     * @param clienteId Identificador del cliente.
     * @param medioId Identificador del medio de pago a retirar.
     */
    public void removeMedio (Long clienteId, Long medioId)
    {
        medioLogic.removeCliente(medioId, clienteId);
    }

    /*
    public AdquisicionEntity addAdquisicion(Long clId, Long adqId) throws BusinessLogicException{
        System.out.println("ClienteLogic: \n clId: " + clId + "\n adqId: " + adqId);
        ClienteEntity clEntity = getCliente(clId);
        AdquisicionEntity adqEntity = adqLogic.getById(adqId);
        if(clEntity == null)
        {
            throw new BusinessLogicException("No existe un cliente con el Id: " + clId);
        }
        if(adqEntity == null)
        {
            throw new BusinessLogicException("No existe una adquisicion con el Id: " + adqId);
        }
        if(clEntity.getAdquisiciones() != null)
        {
            clEntity.getAdquisiciones().add(adqEntity);
        }
        else
        {
            clEntity.setAdquisiciones(new ArrayList<>());
            clEntity.getAdquisiciones().add(adqEntity);
        }
        adqEntity.setCliente(clEntity);
        return adqEntity;
    }
    */
}
