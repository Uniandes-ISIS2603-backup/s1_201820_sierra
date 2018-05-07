/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.persistence;


import co.edu.uniandes.csw.sierra.entities.ClienteEntity;
import co.edu.uniandes.csw.sierra.entities.ComprobanteEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jc.sanchez12
 */
@Stateless
public class ComprobantePersistence {
    private static final Logger LOGGER = Logger.getLogger(ComprobantePersistence.class.getName());
    @PersistenceContext( unitName = "SierraPU")
    protected EntityManager em;
    
    /**
     * Crea un nuevo comprobante.
     * @param entity objeto Comprobante que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ComprobanteEntity create(ComprobanteEntity entity)
    {
        LOGGER.info("Creando una nueva entidad de Comprobante.");
        em.persist(entity);
        LOGGER.info("Creando una entidad de Comprobante.");
        return entity;
    }
    
    /**
     * Busca el comprobante con el id dado por parámetro.
     * @param id correspondiente al comprobante buscado.
     * @return Comprobante  con el id dado por parámetro.
     */ 
    public ComprobanteEntity find(Long id)
    {
        LOGGER.log(Level.INFO, "Obteniendo comprobante por el id.", id);
        return em.find(ComprobanteEntity.class, id);
    }
    
    /**
     * Retorna todos los comprobantes existentes.
     * @return una lista con todos los comprobantes existentes.
     */
    public List<ComprobanteEntity> findAll()
    {
        LOGGER.info("Consultando todos los comprobantes.");
        TypedQuery query = em.createQuery("select u from ComprobanteEntity u", ComprobanteEntity.class);
        return (List<ComprobanteEntity>) query.getResultList();
    }
    
    /**
     * Actualiza un comprobante por el comprobante que llega por parámetro.
     * @param entity
     * @return Comprobante Actualizado.
     */
    public ComprobanteEntity update(ComprobanteEntity entity)
    {
        LOGGER.log(Level.INFO, "Actualizando Comprobante.", ComprobanteEntity.class);
        return em.merge(entity);
    }
    
    /**
     * Elimina un comprobante con el id dado por parámetro.
     * @param id 
     * @return el comprobante que se ha eliminado.
     */
    public ComprobanteEntity delete(Long id)
    {
        LOGGER.log(Level.INFO, "Eliminando Cliente.", ClienteEntity.class);
        ComprobanteEntity entity = find(id);
        em.remove(entity);
        return entity;
    }
}
