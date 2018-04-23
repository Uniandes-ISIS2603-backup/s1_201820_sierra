/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.ClienteEntity;
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
    
    /**
     * Crea una nueva entidad Cliente.
     * @param entity la entidad de tipo cliente que se va a persistir. 
     * @return La entidad luego de persistirla.
     * @throws BusinessLogicException Si ya existe un cliente con esa informacion.
     */
    public ClienteEntity createCliente(ClienteEntity entity) throws BusinessLogicException
    {
        LOGGER.info("Inicia el proceso de creacion de un nuevo cliente");
//         
//        ClienteEntity cliente = persistence.find(entity.getId());
//        if(cliente.getId() != null)
//        {
//            throw new BusinessLogicException("Ya existe un cliente con ese id:" + entity.getId());
//        }
//        if(cliente.getCedula() != null)
//        {
//            throw new BusinessLogicException("Ya existe un cliente con ese numero de cedula:" + entity.getCedula());
//        }
//        else if(cliente.getCorreo() != null)
//        {
//            throw new BusinessLogicException("Ya existe un cliente con ese correo electronico:" + entity.getCorreo());
//        }
//        else if(cliente.getTelefono()!= null)
//        {
//            throw new BusinessLogicException("Ya existe un cliente con ese numero de telefono:" + entity.getTelefono());
//        }
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
    public ClienteEntity getCliente(Long id)
    {
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
     */
    public ClienteEntity updateCliente (Long id, ClienteEntity entity)
    {
        LOGGER.log(Level.SEVERE, "Inicia el proceso de actualizar un cliente");
        ClienteEntity cliente = persistence.find(id);
        if(cliente == null)
        {
            LOGGER.log(Level.SEVERE, "El cliente con el id={0} no existe para ser actualizado", entity.getId());
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
        if(cliente != null)
        {
        //    LOGGER.log(Level.SEVERE, "El cliente con el id={0} no existe para ser eliminado", id);
             persistence.delete(id);
        }
       
        LOGGER.log(Level.SEVERE, "Termina el proceso de eliminar un cliente");
    }

}
