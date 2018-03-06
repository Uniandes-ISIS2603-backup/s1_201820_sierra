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
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.EspecieEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.entities.RazaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.MascotaAdoptadaPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jc.sanchez12
 */
@Stateless
public class MascotaAdoptadaLogic
{
     private static final Logger LOGGER = Logger.getLogger( MascotaAdoptadaLogic.class.getName( ) );
     
     @Inject
     private MascotaAdoptadaPersistence persistence;
     
      /**
         * Crea una  entity en la  base de datos  de tipo MascotaAdoptada
         * @param entity entidad con los datos  de la nueva  MascotaAdoptadaEntity 
         * @return Objeto de  tipo MascotaAdoptadaEntity con los  datos nuevos  
         * @throws BusinessLogicException 
         */
     public MascotaAdoptadaEntity create( MascotaAdoptadaEntity entity) throws BusinessLogicException
     {
         LOGGER.info( "Inicia proceso de creación de una entidad de Mascota adoptda" );
         if (persistence.findByName(entity.getNombre())!=null)
         {
             throw new BusinessLogicException( "Ya existe una entidad de Mascota adoptada con el nombre \"" + entity.getName( ) + "\"" );
         }
         else{
              
             persistence.create(entity);
             LOGGER.info( "Termina proceso de creación de una entidad de Mascota adoptada" );
             return entity;
         }
     }
     
      /**
     * Obtiene la lista de los registros de Mascotas adoptadas.
     *
     * @return Colección de objetos de MascotaAdoptadaEntity.
     */
     public List<MascotaAdoptadaEntity> getAll()
     {
                LOGGER.info( "Inicia proceso de consultar todas las entidades de Mascota adoptada" );
		List<MascotaAdoptadaEntity> entities = persistence.findAll( );
                LOGGER.info( "Termina proceso de consultar todas las entidades de Mascota adoptada" );
		return entities;
     }
     
     /**
     * Obtiene los datos de una instancia de Mascota adoptada a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de MascotaAdoptadaEntity con los datos de la mascota consultada.
     */
     public MascotaAdoptadaEntity getById( Long id )
     {
	return persistence.findById( id );
     }
     
     /**
     * Obtiene los datos de una instancia de Mascota adoptada a partir de su nombre.
     *
     * @param nombre nombre  de la instancia a consultar
     * @return Instancia de MascotaAdoptadaEntity con los datos de la especie consultada.
     */
     public MascotaAdoptadaEntity getByName( String nombre )
     {
	return persistence.findByName(nombre );
     }
    
     
      /**
     * Actualiza la información de una instancia de Mascota adoptada.
     *
     * @param entity Instancia de MascotaAdoptadaEntity con los nuevos datos.
     * @return Instancia de MascotaAdoptadaEntity con los datos actualizados.
     */
    public MascotaAdoptadaEntity update(MascotaAdoptadaEntity entity)
    {
        
        return persistence.update(entity);
    }
    
    /**
     * Elimina una instancia de Mascota adoptada de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void delete(Long id) {
        
        persistence.delete(id);
    }

        
}
