/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.AcontecimientoEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.AcontecimientoPersistence;
import co.edu.uniandes.csw.sierra.persistence.MascotaAdoptadaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ja.penat
 */
@Stateless
public class AcontecimientoLogic 
{
     /**
     * Logger, self explanatory
     */
    private static final Logger LOGGER = Logger.getLogger(AcontecimientoLogic.class.getName());
    
    /**
     * objeto de persistencia de Acontecimiento
     */
    @Inject
    private AcontecimientoPersistence persistencia;
    
    /**
     * Objeto de persistencia de MascotaAdoptada.
     */
    @Inject
    private MascotaAdoptadaPersistence mascotaPersistencia;
    
    /**
     * Revisa que la entidad que se quiere crear cumpla las reglas de negocio y
     * la crea
     * @param ent la entidad que se quiere persistir
     * @return la entidad persistida con el id autogenerado
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    public AcontecimientoEntity create(AcontecimientoEntity ent) throws BusinessLogicException{
        if(persistencia.findByName(ent.getNombre()) != null)
        {
            throw new BusinessLogicException("Ya hay un acontecimiento con el mismo nombre");
        }
        else if( ent.getDescripcion() == null || ent.getDescripcion().equals("") || ent.getFecha()== null || ent.getImportancia() == null || ent.getNombre() == null || ent.getNombre().equals(""))
        {
           throw new BusinessLogicException("Los datos del acontecimiento no son validos o estan incompletos");
        }
        else
        {
        AcontecimientoEntity create = persistencia.create(ent);
        LOGGER.info("Termina la creacion de la entidad de Acontecimineto");
        return create;
        }
        
    }
    
    /**
     * Obtiene todas las entidades de Acontecimiento
     * @return 
     */
    public List<AcontecimientoEntity> getAll(){
        LOGGER.info("Consultando todas las entidades de Acontecimiento");
        List<AcontecimientoEntity> r = persistencia.findAll();
        LOGGER.info("consultadas todas las entidades de Acontecimiento");
        return r;
    }
    /**
     * Obtiene una entidad de Acontecimiento con base en un Id dado 
     * @param id el Id que se quiere encontrar
     * @return la Adquisicion con el Id dado, Null si no lo encuentra
     */
    public AcontecimientoEntity getById(Long id){
        LOGGER.log(Level.INFO, "Buscando el acontecimiento con el id={0}", id);
        return persistencia.find(id);
    }
    /**
     * Actualiza un Acontecmiento
     * @param ent la entidad con los datos que se quieren actualizar
     * @return la entidad con los cambios ya realizados
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    public AcontecimientoEntity update(AcontecimientoEntity ent) throws BusinessLogicException{
        if(persistencia.findByName(ent.getNombre()) != null)
        {
            throw new BusinessLogicException("Ya hay un acontecimiento con este nombre");
        }
         else if( ent.getDescripcion() == null || ent.getDescripcion().equals("") || ent.getFecha()== null || ent.getImportancia() == null || ent.getNombre() == null || ent.getNombre().equals(""))
        {
           throw new BusinessLogicException("Los datos del acontecimiento no son validos o estan incompletos");
        }
        LOGGER.log(Level.INFO, "Actualizando la entidad de Acontecimieto con el id={0}", ent.getId());
        return persistencia.update(ent);
    }
    
   /**
     * Elimina una Acontecimiento
     * @param id, el id del acontecimiento que se desea eliminar
     */
    public void delete(Long id)
    {
      
        AcontecimientoEntity eliminando = persistencia.find(id);
        if(eliminando != null)
        {
        LOGGER.log(Level.INFO, "Eliminando el Acontecimiento con id ={0}", id);
        persistencia.delete(id);
        }
    }   

    
}
