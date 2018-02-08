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
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.SierraEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.SierraPersistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author ISIS2603
 */
@Stateless
public class SierraLogic
{

	private static final Logger LOGGER = Logger.getLogger( SierraLogic.class.getName( ) );

	@Inject
	private SierraPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

	public SierraEntity create( SierraEntity entity ) throws BusinessLogicException
	{
		LOGGER.info( "Inicia proceso de creación de una entidad de Sierra" );
		// Verifica la regla de negocio que dice que no puede haber dos entidades de Sierra con el mismo nombre
		if( persistence.findByName( entity.getName( ) ) != null )
		{
			throw new BusinessLogicException( "Ya existe una entidad de Sierra con el nombre \"" + entity.getName( ) + "\"" );
		}
		// Invoca la persistencia para crear la entidad de Sierra
		persistence.create( entity );
		LOGGER.info( "Termina proceso de creación de entidad de Sierra" );
		return entity;
	}

	public List<SierraEntity> getAll( )
	{
		LOGGER.info( "Inicia proceso de consultar todas las entidades de Sierra" );
		// Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
		List<SierraEntity> entities = persistence.findAll( );
		LOGGER.info( "Termina proceso de consultar todas las entidades de Sierra" );
		return entities;
	}

	public SierraEntity getById( Long id )
	{
		return persistence.find( id );
	}

	public SierraEntity update( SierraEntity entity ) throws BusinessLogicException
	{
		if( persistence.findByName( entity.getName( ) ) != null )
		{
			throw new BusinessLogicException( "Ya existe una entidad de Sierra con el nombre \"" + entity.getName( ) + "\"" );
		}
		return persistence.update( entity );
	}

	public void delete( SierraEntity entity ) throws BusinessLogicException
	{
		LOGGER.log( Level.INFO, "Inicia proceso de borrar la entidad de Sierra con id={0}", entity.getId( ) );
		persistence.delete( entity );
		LOGGER.log( Level.INFO, "Termina proceso de borrar la entidad de Sierra con id={0}", entity.getId( ) );
	}
}
