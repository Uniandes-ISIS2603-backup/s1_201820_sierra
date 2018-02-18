/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.persistence;
import co.edu.uniandes.csw.sierra.entities.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *Clase encargada de la persistencia de acontecimiento
 * @author ja.penat 
 */
@Stateless 
public class AcontecimientoPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(AcontecimientoPersistence.class.getName());

   // Contexto de la persistencia.
    @PersistenceContext(unitName = "SierraPU")
   //Entity manager.
    protected EntityManager em;
    

    /**
     * Metodo encargado de crear un acontecimiento, que entra por parametro, en la base de datos de la aplicacion.
     * @param acEntity la entidad que se quiere guardar en la base de datos
     * @return la entity creada con el id dado por la base de datos
     */
    public AcontecimientoEntity create(AcontecimientoEntity  acEntity)
    {
        LOGGER.info("Creando una nueva entidad de Acontecimiento");
        em.persist(acEntity);
        LOGGER.info("Creando una entidad de Acontecimiento");
        return acEntity;
    }

    /**
     * Metodo encargado de retornar una lista con todos los acontecimientos en la base de datos de la aplicacion.
     * @return la lista con todos los acontecimientos en la base de datos.
     */
    public List<AcontecimientoEntity> findAll()
    {
        LOGGER.info("Consultando todas las entidades de Acontecimiento");
        TypedQuery<AcontecimientoEntity> query = em.createQuery("select u from AcontecimientoEntity u", AcontecimientoEntity.class);
        return query.getResultList();
    }

    /**
     * Metodo encargado de encontrar el  acontecimiento en la base de datos con el id dado por parametro.
     * @param id del acontecimiento que se quiere buscar en la base de datos.
     * @return El acontecimiento con el id suministrado.
     */
    public AcontecimientoEntity find(Long id)
    {
        LOGGER.log(Level.INFO, "Consultando el Acontecimiento con  el id={0}", id);
        return em.find(AcontecimientoEntity.class, id);
    }

    /**
     * Metodo encargado de actualizar el  acontecimiento en la base de datos.
     * @param acEntity el acontecimiento que se quiere actualizar en la base de datos.
     * @return El acontecimiento actualizado.
     */
    public AcontecimientoEntity update(AcontecimientoEntity acEntity) 
    {
        LOGGER.log(Level.INFO, "Actualizando el Acontecimiento con id={0}", acEntity.getId());
        return em.merge(acEntity);
    }

    /**
     * Metodo encargado de borrar el  acontecimiento en la base de datos.
     * @param acEntity el acontecimiento que se quiere borrar en la base de datos.
     */

    public void delete(AcontecimientoEntity acEntity) 
    {
        LOGGER.log(Level.INFO, "Borrando el Acontecimiento con id={0}", acEntity.getId());
        em.remove(acEntity);
    }

}
