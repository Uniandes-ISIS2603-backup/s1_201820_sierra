    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.persistence;


import co.edu.uniandes.csw.sierra.entities.PublicacionEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ejb.Stateless;

/**
 *Clase encargada del la persistencia de publicacion.
 * @author ja.penat
 */
@Stateless
public class PublicacionPersistence 
{
      private static final Logger LOGGER = Logger.getLogger(PublicacionPersistence.class.getName());

   // Contexto de la persistencia.
    @PersistenceContext(unitName = "SierraPU")
   //Entity manager.
    protected EntityManager em;
    

    /**
     * Metodo encargado de crear una publicacion, que entra por parametro, en la base de datos de la aplicacion.
     * @param pubEntity la entidad que se quiere guardar en la base de datos.
     * @return la entity creada con el id dado por la base de datos
     */
    public PublicacionEntity create(PublicacionEntity  pubEntity)
    {
        LOGGER.info("Creando una nueva entidad de Publicacion");
        em.persist(pubEntity);
        LOGGER.info("Creando una entidad de Publicacion");
        return pubEntity;
    }

    /**
     * Metodo encargado de retornar una lista con todas las publicaciones en la base de datos de la aplicacion.
     * @return la lista con todas las publicaciones en la base de datos.
     */
    public List<PublicacionEntity> findAll()
    {
        LOGGER.info("Consultando todas las entidades de Publicacion");
        TypedQuery<PublicacionEntity> query = em.createQuery("select u from PublicacionEntity u", PublicacionEntity.class);
        return query.getResultList();
    }

    /**
     * Metodo encargado de encontrar la publicacion en la base de datos con el id dado por parametro.
     * @param id de la publicacion que se quiere buscar en la base de datos.
     * @return La publicacion con el id suministrado.
     */
    public PublicacionEntity find(Long id)
    {
        LOGGER.log(Level.INFO, "Consultando la Publicacion con  el id={0}", id);
        return em.find(PublicacionEntity.class, id);
    }

    /**
     * Metodo encargado de actualizar la Publicacion en la base de datos.
     * @param pubEntity de la publicacion que se quiere actualizar en la base de datos.
     * @return La publicacion actualizado.
     */
    public PublicacionEntity update(PublicacionEntity pubEntity) 
    {
        LOGGER.log(Level.INFO, "Actualizando la Publicacion con id={0}", pubEntity.getId());
        return em.merge(pubEntity);
    }

   /**
     * Metodo encargado de borrar la publicacion en la base de datos.
     * @param idPub id de la publicacion que se quiere borrar en la base de datos.
     */

    public void delete(Long idPub) 
    {
        LOGGER.log(Level.INFO,"Eliminando medioDePago",PublicacionEntity.class);
        PublicacionEntity entity = find(idPub);
        em.remove(entity);
    }


}
