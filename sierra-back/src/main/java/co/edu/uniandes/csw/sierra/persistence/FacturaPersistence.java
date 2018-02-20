/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.persistence;

import co.edu.uniandes.csw.sierra.ejb.*;
import co.edu.uniandes.csw.sierra.entities.FacturaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jc.sanchez12
 */
public class FacturaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(FacturaPersistence.class.getName());
    @PersistenceContext( unitName = "SierraPU")
    protected EntityManager em;
    
    /**
     * Crea una nueva factura.
     * @param entity
     * @return la Factura creada.
     */
    public FacturaEntity create(FacturaEntity entity)
    {
        LOGGER.info("Creando una Factura.");
        em.persist(entity);
        LOGGER.info("Creando una Factura.");
        return entity;
    }
    
    /**
     * Encuentra a la factura con el id dado por parámetro.
     * @param id
     * @return La factura cono el id dado por parámetro.
     */
    public FacturaEntity find(Long id)
    {
        LOGGER.log(Level.INFO, "Obteniendo facutra por id.", id);
        return em.find(FacturaEntity.class, id);
    }
    
    /**
     * Devuelve todas las facturas existentes.
     * @return una lista con todas las facturas existentes.
     */
    public List<FacturaEntity> findAll()
    {
        LOGGER.info("Consultando todas las facturas existentes.");
        TypedQuery query = em.createQuery("select u from FacturaEntity u", FacturaEntity.class);
        return query.getResultList();
    }
    
    /**
     * Actualiza la información de una factura.
     * @param entity
     * @return la factura con la nformación actualizada.
     */
    public FacturaEntity update(FacturaEntity entity)
    {
        LOGGER.log(Level.INFO, "Actualizando Factura.", FacturaEntity.class);
        return em.merge(entity);
    }
    
    /**
     * Elimina a la factura con el id dado por parámetro.
     * @param id 
     */
    public void delete (Long id)
    {
        LOGGER.log(Level.INFO, "Eliminando Factura.", FacturaEntity.class);
        FacturaEntity entity = find(id);
        em.remove(entity);
    }
}
