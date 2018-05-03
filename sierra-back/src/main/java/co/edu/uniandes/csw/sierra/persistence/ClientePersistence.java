/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.persistence;

import co.edu.uniandes.csw.sierra.entities.ClienteEntity;
import java.util.*;
import java.util.logging.*;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author de.gutierrez
 */
@Stateless
public class ClientePersistence {
  
    private static final Logger LOGGER = Logger.getLogger(ClientePersistence.class.getName());
    @PersistenceContext( unitName = "SierraPU" )
    protected EntityManager em;
    
    /**
     * Crea un nuevo cliente.
     * @param entity objeto Cliente que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ClienteEntity create(ClienteEntity entity)
    {
        LOGGER.info("Creando un cliente");
        em.persist(entity);
        LOGGER.info("Creando el cliente");
        return entity;
    }
    
    /**
     * Busca el cliente con id que se envia por parametro.
     * @param id correspondiente al cliente buscado.
     * @return La entidad cliente.
     */
    public ClienteEntity find (Long id)
    {
        LOGGER.log(Level.INFO, "Obteniendo cliente por el id", id);
        return em.find(ClienteEntity.class, id);
    }
    
    /**
     * Devuelve todos los clientes de la base de datos.
     * @return una lista con todos los clientes.
     */
    public List<ClienteEntity> findAll()
    {
         LOGGER.info("Consultando todos los clientes");
         TypedQuery query = em.createQuery("select u from ClienteEntity u", ClienteEntity.class);
         return query.getResultList();
    }
    
    /**
     * Actualiza la informacion de un cliente
     * @param entity.  El cliente que va actualizar.
     *@return el cliente actualizado.
     */
    public ClienteEntity update(ClienteEntity entity)
    {
       LOGGER.log(Level.INFO, "Actualizando cliente", ClienteEntity.class);
       return em.merge(entity);
    }
    
    /**
     * Elimina un cliente con el id que se envia por parametro
     * @param  id: id correspondiente al cliente a eliminar
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO,"Eliminando cliente", ClienteEntity.class);
        ClienteEntity entity = find(id);  
        em.remove(entity);
    }
    
    public ClienteEntity findByCedula(Long cedula )
    {
	TypedQuery<ClienteEntity> query = em.createQuery( "Select e From ClienteEntity e where e.cedula = :cedula", ClienteEntity.class );	
	query = query.setParameter( "cedula", cedula );
        List<ClienteEntity> sameName = query.getResultList( );
        ClienteEntity result = null; 
        if (sameName == null ) {
            result = null;
        } else if (sameName.isEmpty()) {
             result = null;
        } else {
            result =  sameName.get(0);
        }
        return result;
    }
    
    public ClienteEntity findByCorreo(String correo )
    {
	TypedQuery<ClienteEntity> query = em.createQuery( "Select e From ClienteEntity e where e.correo = :correo", ClienteEntity.class );	
	query = query.setParameter( "correo", correo );
        List<ClienteEntity> sameName = query.getResultList( );
        ClienteEntity result = null; 
        if (sameName == null ) {
            result = null;
        } else if (sameName.isEmpty()) {
             result = null;
        } else {
            result =  sameName.get(0);
        }
        return result;
    }
    
    public ClienteEntity findByTelefono(Long telefono )
    {
	TypedQuery<ClienteEntity> query = em.createQuery( "Select e From ClienteEntity e where e.telefono = :telefono", ClienteEntity.class );	
	query = query.setParameter( "telefono", telefono );
        List<ClienteEntity> sameName = query.getResultList( );
        ClienteEntity result = null; 
        if (sameName == null ) {
            result = null;
        } else if (sameName.isEmpty()) {
             result = null;
        } else {
            result =  sameName.get(0);
        }
        return result;
    }
}

