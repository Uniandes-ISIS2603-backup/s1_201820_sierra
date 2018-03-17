/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;


import co.edu.uniandes.csw.sierra.entities.EspecieEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.EspeciePersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que representa una especie en la capa logica.
 * @author jc.sanchez12
 */
@Stateless
public class EspecieLogic
{
    private static final Logger LOGGER = Logger.getLogger( SierraLogic.class.getName( ) );

	@Inject
	private EspeciePersistence persistence;
    
        /**
         * Crea una  entity en la  base de datos  de tipo especie
         * No existe  alguna  regla que  repercuta en la creacion de una especie mientras no exista ya en la base de datos.
         * @param entity Bojeto con los datos  de la nueva  EspecieEntity 
         * @return Objeto de  tipo EspecieEntity con los  datos nuevos  
         * @throws BusinessLogicException 
         */
     public EspecieEntity create( EspecieEntity entity) throws BusinessLogicException
     {
         LOGGER.info( "Inicia proceso de creación de una entidad de Especie" );
         if (persistence.findByName(entity.getNombre())!=null)
         {
             throw new BusinessLogicException( "Ya existe una entidad de Especie con el nombre \"" + entity.getName( ) + "\"" );
         }
         else{
             //El nombre de la  especie no puede ser vacio
             if (entity.getNombre().equals("")) {
                  throw new BusinessLogicException( "El nombre de la  especie \"" + entity.getName( ) + " no es un nombre valido\"" );
             }
             else{
             persistence.create(entity);
             LOGGER.info( "Termina proceso de creación de una entidad de Especie" );
             return entity;
             } 
         }
     }
     
     
    /**
     * Obtiene la lista de los registros de Especies.
     * No existe  alguna  regla que  repercuta en la obtencion de todas las especies en la base de datos.
     * @return Colección de objetos de EspecieEntity.
     */
     public List<EspecieEntity> getAll()
     {
                LOGGER.info( "Inicia proceso de consultar todas las entidades de Especie" );
		List<EspecieEntity> entities = persistence.findAll( );
                LOGGER.info( "Termina proceso de consultar todas las entidades de Especie" );
		return entities;
     }
     
     
     /**
     * Obtiene los datos de una instancia de Especie a partir de su ID.
     * @param id Identificador de la instancia a consultar
     * @return Instancia de EsoeciEntity con los datos de la especie consultada.
     */
     public EspecieEntity getById( Long id )
     {
	return persistence.findById(id );
     }
     
     /**
     * Obtiene los datos de una instancia de Especie a partir de su nombre.
     * @param nombre nombre  de la instancia a consultar
     * @return Instancia de EspecieEntity con los datos de la especie consultada.
     */
     public EspecieEntity getByName( String nombre )
     {
	return persistence.findByName(nombre );
     }
     
     /**
     * Actualiza la información de una instancia de Especie.
     * @param entity Instancia de EspecieEntity con los nuevos datos.
     * @return Instancia de EspecieEntity con los datos actualizados.
     */
    public EspecieEntity update(EspecieEntity entity)
    {//TODO: NO hay ninguna regla de negocio? 
        return persistence.update(entity);
    }
    
    /**
     * Elimina una instancia de Especie de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void delete(Long id) {
        // TODO: Hay que validar que existe Especie con ese id
        persistence.delete(id);
    }

}
