/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.persistence;

import co.edu.uniandes.csw.sierra.entities.CertificadoEntity;
import co.edu.uniandes.csw.sierra.entities.ClienteEntity;
import co.edu.uniandes.csw.sierra.entities.RazaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author rj.gonzalez10
 */
public class RazaPersistence {
        private static final Logger LOGGER = Logger.getLogger(RazaPersistence.class.getName());
    @PersistenceContext( unitName = "SierraPU" )
    protected EntityManager em;
    
    /**
     * Crea un nuevo cliente.
     * @param entity objeto raza que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public RazaEntity create(RazaEntity entity)
    {
        LOGGER.info("Creando una raza");
        em.persist(entity);
        LOGGER.info("Creando la raza");
        return entity;
    }
    
    /**
     * Busca el cliente con id que se envia por parametro
     * @param id correspondiente al la raza buscada.
     * @return La entidad raza.
     */
    public RazaEntity find (Long id)
    {
        LOGGER.log(Level.INFO, "Obteniendo raza por el id", id);
        return em.find(RazaEntity.class, id);
    }
    
    /**
     * Devuelve todas las razas de la base de datos.
     * @return una lista con todas las razas.
     */
    public List<RazaEntity> findAll()
    {
         LOGGER.info("Consultando todas las razas");
         TypedQuery query = em.createQuery("select u from RazaEntity u", RazaEntity.class);
         return query.getResultList();
    }
    
    /**
     * Actualiza la informacion de una raza
     * @param entity.  la raza que va actualizar.
     *@return la raza actualizada.
     */
    public RazaEntity update(RazaEntity entity)
    {
       LOGGER.log(Level.INFO, "Actualizando raza", RazaEntity.class);
       return em.merge(entity);
    }
    
    /**
     * Elimina una raza con el id que se envia por parametro
     * @param  id: id correspondiente a la raza a eliminar
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO,"Eliminando raza", RazaEntity.class);
       RazaEntity entity = find(id);
        
        em.remove(entity);
    }


}


