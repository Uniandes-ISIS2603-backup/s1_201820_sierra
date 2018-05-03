/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.persistence;

import co.edu.uniandes.csw.sierra.entities.*;
import java.util.*;
import java.util.logging.*;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author de.gutierrez
 */
@Stateless
public class MedioDePagoPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(MedioDePagoPersistence.class.getName());
    @PersistenceContext( unitName = "SierraPU" )
    protected EntityManager em;
    
    /**
     * Crea un nuevo medioDePago.
     * @param entity objeto medioDePago que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public MedioDePagoEntity create(MedioDePagoEntity entity)
    {
        LOGGER.info("Creando un medioDePago");
        em.persist(entity);
        LOGGER.info("Creando el medioDePago");
        return entity;
    }
    
    /**
     * Busca el medioDePago con id que se envia por parametro
     * @param id correspondiente al medioDePago buscado.
     * @return La entidad medioDePago.
     */
    public MedioDePagoEntity find (Long id)
    {
        LOGGER.log(Level.INFO, "Obteniendo medioDePago por el id", id);
        return em.find(MedioDePagoEntity.class, id);
    }
    
    /**
     * Devuelve todos los medioDePago de la base de datos.
     * @return una lista con todos los medioDePago.
     */
    public List<MedioDePagoEntity> findAll()
    {
         LOGGER.info("Consultando todos los medioDePago");
         TypedQuery query = em.createQuery("select u from MedioDePagoEntity u", MedioDePagoEntity.class);
         return query.getResultList();
    }
    
    /**
     * Actualiza la informacion de un medioDePago.
     * @param entity.  El medioDePago que va actualizar.
     *@return el medioDePago actualizado.
     */
    public MedioDePagoEntity update(MedioDePagoEntity entity)
    {
       LOGGER.log(Level.INFO, "Actualizando el medioDePago", MedioDePagoEntity.class);
       return em.merge(entity);
    }
    
    /**
     * Elimina un medioDePago con el id que se envia por parametro.
     * @param  id: id correspondiente al medioDePago a eliminar.
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO,"Eliminando medioDePago", MedioDePagoEntity.class);
        MedioDePagoEntity entity = find(id);
        em.remove(entity);
    }
   
    public MedioDePagoEntity findByTipo (String tipo)
    {
        TypedQuery query = em.createQuery("Select e From MedioDePagoEntity e where e.tipo = :tipo", MedioDePagoEntity.class);
        query = query.setParameter("tipo", tipo);
        List<MedioDePagoEntity> sameName = query.getResultList();
        MedioDePagoEntity result; 
        result = null;
        if (sameName == null ) {
            result = null;
        } else if (sameName.isEmpty()) {
             result = null;
        } else {
            result =  sameName.get(0);
        }
        return result;
    }
    
    public MedioDePagoEntity findByReferencia (Long numeroReferencia)
    {
        TypedQuery query = em.createQuery("Select e From MedioDePagoEntity e where e.numeroReferencia = :numeroReferencia", MedioDePagoEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("numeroReferencia", numeroReferencia);
        // Se invoca el query se obtiene la lista resultado
        List<MedioDePagoEntity> sameName = query.getResultList();
        MedioDePagoEntity result; 
        result = null;
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

