/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.persistence;

import co.edu.uniandes.csw.sierra.ejb.*;
import co.edu.uniandes.csw.sierra.entities.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
}
