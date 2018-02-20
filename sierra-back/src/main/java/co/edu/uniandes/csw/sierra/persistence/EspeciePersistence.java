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

import co.edu.uniandes.csw.sierra.entities.EspecieEntity;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Clase de persistencia  de  Especie
 * @author jc.sanchez12
 */
@Stateless
public class EspeciePersistence 
{
    private static final Logger LOGGER = Logger.getLogger( SierraPersistence.class.getName( ) );
    
    /**
     * Base de datos de persistencia
     */
    @PersistenceContext(unitName="SierraPU")
    
    /**
     * Manejador  de Entities
     */
    protected EntityManager em;
    
    /**
     * Crear una  EspecieEntity
     * @param entity objeto compania que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public EspecieEntity create(EspecieEntity entity)
        {
        LOGGER.info( "Creando una nueva entidad de Especie" );
        em.persist(entity);
        LOGGER.info( "Creando una  entidad de Especie" );
        return entity;
        }
    
     /**
     * Devuelve todas las especies de la base de datos.
     *
     * @return una lista con todas las especies que encuentre en la base de
     * datos, "select u from EspecieEntity u" es como un "select * from
     * EspecieEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<EspecieEntity> findAll( )
	{
            LOGGER.info( "Consultando todas las entidades de Especie" );
            TypedQuery<EspecieEntity> query = em.createQuery( "select u from EspecieEntity u", EspecieEntity.class );
            return query.getResultList( );
	}
    
    
    /**
     * Busca si hay alguna especie con el id que se envía de argumento
     *
     * @param id: id correspondiente a la especie buscada.
     * @return una especie.
     */   
     public EspecieEntity findById(Long id) {
        LOGGER.log(Level.INFO, "Consultando especie con id={0}", id);
        return em.find(EspecieEntity.class, id);
    }


    /**
     * Busca si hay alguna entidad de Especie con el nombre que se envía de argumento
     * @param name: Nombre de la entidad de Especie que se está buscando
     * @return null si no existe ninguna entidad Especie con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
	public EspecieEntity findByName( String name )
	{
		LOGGER.log( Level.INFO, "Consultando entidades de Especie por nombre ", name );

		// Se crea un query para buscar entidades de especie con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
		TypedQuery<EspecieEntity> query = em.createQuery( "Select e From EspecieEntity e where e.name = :name", EspecieEntity.class );
		// Se remplaza el placeholder ":name" con el valor del argumento
		query = query.setParameter( "name", name );
		// Se invoca el query se obtiene la lista resultado
		List<EspecieEntity> sameName = query.getResultList( );
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
     * Borra una especie de la base de datos recibiendo como argumento el id
     * de la especie
     *
     * @param id: id correspondiente a la especie a borrar.
     */
    public void delete(Long id) {
        LOGGER.log( Level.INFO, "Consultando entidades de Especie por id ", id );
        EspecieEntity entity = em.find(EspecieEntity.class, id);
        em.remove(entity);
    }
    
    /**
     * Actualiza una especie.
     *
     * @param entity: la especie que viene con los nuevos cambios. Por ejemplo
     * el nombre pudo cambiar. En ese caso, se haria uso del método update.
     * @return una especie con los cambios aplicados.
     */
    public EspecieEntity update(EspecieEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando especie con id={0}", entity.getId());
        return em.merge(entity);
    }
        
}
