/*
MIT License

Copyright (c) 2017 ISIS2603

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

import co.edu.uniandes.csw.sierra.entities.SierraEntity;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author ISIS2603
 */
@Stateless
public class SierraPersistence
{
	private static final Logger LOGGER = Logger.getLogger( SierraPersistence.class.getName( ) );

	@PersistenceContext( unitName = "SierraPU" )
	protected EntityManager em;

	/**
	 * @param entity objeto Sierra que se creará en la base de datos
	 * @return devuelve la entidad creada con un id dado por la base de datos.
	 */
	public SierraEntity create( SierraEntity entity )
	{
		LOGGER.info( "Creando una nueva entidad de Sierra" );
		em.persist( entity );
		LOGGER.info( "Creando una entidad de Sierra" );
		return entity;
	}

	/**
	 * Busca si hay alguna entidad de Sierra con el nombre que se envía de argumento
	 *
	 * @param name: Nombre de la entidad de Sierra que se está buscando
	 * @return null si no existe ninguna entidad Sierra con el nombre del argumento. Si
	 * existe alguna devuelve la primera.
	 */
	public SierraEntity findByName( String name )
	{
		LOGGER.log( Level.INFO, "Consultando entidades de Sierra por nombre ", name );

		// Se crea un query para buscar entidades de Sierra con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
		TypedQuery<SierraEntity> query = em.createQuery( "Select e From SierraEntity e where e.name = :name", SierraEntity.class );
		// Se remplaza el placeholder ":name" con el valor del argumento
		query = query.setParameter( "name", name );
		// Se invoca el query se obtiene la lista resultado
		List<SierraEntity> sameName = query.getResultList( );
		if( sameName.isEmpty( ) )
		{
			return null;
		}
		else
		{
			return sameName.get( 0 );
		}
	}

	public List<SierraEntity> findAll( )
	{
		LOGGER.info( "Consultando todas las entidades de Sierra" );
		TypedQuery<SierraEntity> query = em.createQuery( "select u from SierraEntity u", SierraEntity.class );
		return query.getResultList( );
	}

	public SierraEntity find( Long id )
	{
		return em.find( SierraEntity.class, id );
	}

	public SierraEntity update( SierraEntity entity )
	{
		return em.merge( entity );
	}

	public void delete( SierraEntity entity )
	{
		em.remove( entity );
	}
}
