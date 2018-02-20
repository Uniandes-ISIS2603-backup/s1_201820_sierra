/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.MascotaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.MascotaPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jc.sanchez12
 */
@Stateless
public class MascotaLogic
{
    
    private static final Logger LOGGER = Logger.getLogger( SierraLogic.class.getName( ) );

	@Inject
	private MascotaPersistence persistence;
        
    
        /**
         * Crea una  entity en la  base de datos  de tipo Mascota
         * @param entity Bojeto con los datos  de la nueva  MascotaEntity 
         * @return Objeto de  tipo MascotaEntity con los  datos nuevos  
         * @throws BusinessLogicException 
         */
     public MascotaEntity create( MascotaEntity entity) throws BusinessLogicException
     {
         LOGGER.info( "Inicia proceso de creación de una entidad de Mascota" );
         if (persistence.findByName(entity.getNombre())!=null)
         {
             throw new BusinessLogicException( "Ya existe una entidad de Mascota con el nombre \"" + entity.getName( ) + "\"" );
         }
         else{
             persistence.create(entity);
             LOGGER.info( "Termina proceso de creación de una entidad de Mascota" );
             return entity;
         }
     }
     
      /**
     * Obtiene la lista de los registros de Mascotas.
     *
     * @return Colección de objetos de MascotaEntity.
     */
     public List<MascotaEntity> getAll()
     {
                LOGGER.info( "Inicia proceso de consultar todas las entidades de Mascota" );
		List<MascotaEntity> entities = persistence.findAll( );
                LOGGER.info( "Termina proceso de consultar todas las entidades de Mascota" );
		return entities;
     }
     
     /**
     * Obtiene los datos de una instancia de Mascota a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de MascotaEntity con los datos de la mascota consultada.
     */
     public MascotaEntity getById( Long id )
     {
	return persistence.findById( id );
     }
     
     /**
     * Obtiene los datos de una instancia de Mascota a partir de su nombre.
     *
     * @param nombre nombre  de la instancia a consultar
     * @return Instancia de MascotaEntity con los datos de la especie consultada.
     */
     public MascotaEntity getByName( String nombre )
     {
	return persistence.findByName(nombre );
     }
    
     
      /**
     * Actualiza la información de una instancia de Mascota.
     *
     * @param entity Instancia de MascotaEntity con los nuevos datos.
     * @return Instancia de MascotaEntity con los datos actualizados.
     */
    public MascotaEntity update(MascotaEntity entity)
    {
        
        return persistence.update(entity);
    }
    
    /**
     * Elimina una instancia de Mascota de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void delete(Long id) {
        
        persistence.delete(id);
    }

}
