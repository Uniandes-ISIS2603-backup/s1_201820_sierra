/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.sierra.persistence;

import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaEntity;
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
public class MascotaAdoptadaPersistence
{
    private static final Logger LOGGER = Logger.getLogger( MascotaAdoptadaPersistence.class.getName( ) ); 
    
    /**
     * Base de datos de persistencia
     */
    @PersistenceContext(unitName = "SierraPU")
    
    /**
     * Manejador  de Entities
     */
    protected EntityManager em;
    
    /**
     * Crear una  MascotaAdoptadaEntity
     * @param entity objeto mascota adoptada que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public MascotaAdoptadaEntity create(MascotaAdoptadaEntity entity)
        {
        LOGGER.info( "Creando una nueva entidad de Mascota adoptada" );
        em.persist(entity);
        LOGGER.info( "Creando una  entidad de Mascota adoptada" );
        return entity;
       }
    
     /**
     * Devuelve todas las mascotas de la base de datos.
     * @return una lista con todas las mascotas que encuentre en la base de
     * datos, "select u from MascotaAdoptadaEntity u" es como un "select * from
     * MascotaAdoptadaEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<MascotaAdoptadaEntity> findAll( )
	{
        LOGGER.info("Consultando todas las entidades de MascotaAdoptada");
        TypedQuery<MascotaAdoptadaEntity> query = em.createQuery("select u from MascotaAdoptadaEntity u", MascotaAdoptadaEntity.class);
        return query.getResultList();
	}
    
    
    
       /**
     * Devuelve todas las mascotas de la base de datos.
     * @return una lista con todas las mascotas que encuentre en la base de
     * datos, "select u from MascotaEntity u" es como un "select * from
     * MascotaAdoptadaEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<MascotaEntity> findAllMascotas( )
	{
        LOGGER.info("Consultando todas las entidades de Mascota");
        TypedQuery<MascotaEntity> query = em.createQuery("select u from Mascota u", MascotaEntity.class);
        return query.getResultList();
	}
    
    
     /**
     * Busca si hay alguna mascota adoptada con el id que se envía de argumento
     *
     * @param id: id correspondiente a la mascota adoptada buscada.
     * @return una mascota adoptada.
     */   
     public MascotaAdoptadaEntity findById(Long id) {
        LOGGER.log(Level.INFO, "Consultando especie con id={0}", id);
        return em.find(MascotaAdoptadaEntity.class, id);
    }
     
     
    /**
     * Busca si hay alguna entidad de Mascota Adoptada con el nombre que se envía de argumento
     * @param name: Nombre de la entidad de Mascota  adoptada  que se está buscando
     * @return null si no existe ninguna entidad Mascota adoptada con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
	public MascotaAdoptadaEntity findByName( String name )
	{
		LOGGER.log( Level.INFO, "Consultando entidades de Mascota adoptada por nombre ", name );

		// Se crea un query para buscar entidades de especie con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
		TypedQuery<MascotaAdoptadaEntity> query = em.createQuery("Select e From MascotaEntity e where e.name = :name", MascotaAdoptadaEntity.class );
		// Se remplaza el placeholder ":name" con el valor del argumento
		query = query.setParameter( "name", name );
		// Se invoca el query se obtiene la lista resultado
		List<MascotaAdoptadaEntity> sameName = query.getResultList( );
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
     *
     * Borra una mascota  adoptada de la base de datos recibiendo como argumento el id
     * de la mascota adoptada 
     *
     * @param id: id correspondiente a la mascota a borrar.
     */
    public void delete(Long id) {
        LOGGER.log( Level.INFO, "Consultando entidades de Mascota adoptada por id ", id );
        MascotaAdoptadaEntity entity = em.find(MascotaAdoptadaEntity.class, id);
        em.remove(entity);
    }
    
     /**
     * Actualiza una mascota adoptada.
     * @param entity: la mascota que viene con los nuevos cambios. Por ejemplo
     * el nombre pudo cambiar. En ese caso, se haria uso del método update.
     * @return una mascota adoptada  con los cambios aplicados.
     */
    public MascotaAdoptadaEntity update(MascotaAdoptadaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando mascota adoptada  con id={0}", entity.getId());
        return em.merge(entity);
    }
        
}
