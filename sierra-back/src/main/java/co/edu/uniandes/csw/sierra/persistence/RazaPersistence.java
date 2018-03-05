/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.persistence;


import co.edu.uniandes.csw.sierra.entities.RazaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author rj.gonzalez10
 */
@Stateless
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
     * Busca si hay alguna entidad de Especie con el nombre que se envía de argumento
     * @param name: Nombre de la entidad de Especie que se está buscando
     * @return null si no existe ninguna entidad Especie con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
	public RazaEntity findByName( String name )
	{
		LOGGER.log( Level.INFO, "Consultando entidades de raza por nombre ", name );

		// Se crea un query para buscar entidades de raza con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
		TypedQuery<RazaEntity> query = em.createQuery( "Select e From RazaEntity e where e.name = :name", RazaEntity.class );
		// Se remplaza el placeholder ":name" con el valor del argumento
		query = query.setParameter( "name", name );
		// Se invoca el query se obtiene la lista resultado
		List<RazaEntity> sameName = query.getResultList( );
		if( sameName.isEmpty( ) )
		{
			return null;
		}
		else
		{
			return sameName.get( 0 );
		}
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


