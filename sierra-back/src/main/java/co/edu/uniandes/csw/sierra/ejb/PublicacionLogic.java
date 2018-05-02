/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaVentaEntity;
import co.edu.uniandes.csw.sierra.entities.PublicacionEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.MascotaAdoptadaPersistence;
import co.edu.uniandes.csw.sierra.persistence.MascotaVentaPersistence;
import co.edu.uniandes.csw.sierra.persistence.PublicacionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ja.penat
 */@Stateless
public class PublicacionLogic 
{
  /**
     * Logger, self explanatory
     */
    private static final Logger LOGGER = Logger.getLogger(PublicacionLogic.class.getName());
    
    /**
     * objeto de persistencia de publicacion
     */
    @Inject
    private PublicacionPersistence persistencia;
    
    
    @Inject
    private MascotaAdoptadaPersistence mascotaAdoptadaPersistencia;
        
     @Inject
    private MascotaVentaPersistence mascotaVentaPersistencia;
    
    /**
     * Revisa que la entidad que se quiere crear cumpla las reglas de negocio y
     * la crea
     * @param ent la entidad que se quiere persistir
     * @return la entidad persistida con el id autogenerado
     */
    public PublicacionEntity create(PublicacionEntity ent) throws BusinessLogicException
    {
       
 LOGGER.info("Creando una entidad de Publicacion");
        //TODO: No hay ninguna regla de negocio? 
        if (mascotaAdoptadaPersistencia.findById(ent.getId()) != ent.getMascota() && mascotaAdoptadaPersistencia.findById(ent.getId()) != null)
         {
             throw new BusinessLogicException( "No existe la Mascota asociada a la Publicación \"" + ent.getId( ) + "\"" );
         }
         else
        {
         if(ent.getMascota().getNacimiento().after(ent.getFecha()))
         {
              throw new BusinessLogicException( "La fecha de la Publicación no es válida\""  );
         }
         else
         {
        List<PublicacionEntity> listaPub = mascotaAdoptadaPersistencia.findById(ent.getMascota().getId()).getPublicaciones();
        listaPub.add(ent);
        MascotaEntity nuevo = ent.getMascota();
        nuevo.setPublicaciones(listaPub);
        if(nuevo.getClass().getName() =="MascotaAdopatada")
        {
        mascotaAdoptadaPersistencia.update((MascotaAdoptadaEntity) nuevo);
         persistencia.create(ent);
        LOGGER.info("Termina la creacion de la entidad de Publicacion");
        return ent;
        }
        else
        {
        mascotaVentaPersistencia.update((MascotaVentaEntity) nuevo);
        persistencia.create(ent);
        LOGGER.info("Termina la creacion de la entidad de Publicacion");
        return ent;
         }
         }
    }
        //Falta probar.
    }
    
    
    /**
     * Obtiene todas las entidades de Publicacion
     * @return 
     */
    public List<PublicacionEntity> getAll(){
        LOGGER.info("Consultando todas las entidades de Publicacion");
        List<PublicacionEntity> r = persistencia.findAll();
        LOGGER.info("consultadas todas las entidades de Publicacion");
        return r;
    }
    /**
     * Obtiene una entidad de Publicacion con base en un Id dado 
     * @param id el Id que se quiere encontrar
     * @return la Publiacion con el Id dado, Null si no lo encuentra
     */
    public PublicacionEntity getById(Long id){
        LOGGER.log(Level.INFO, "Buscando la publicacion con el id={0}", id);
        return persistencia.find(id);
    }
    /**
     * Actualiza una Publicacion
     * @param ent la entidad con los datos que se quieren actualizar
     * @return la entidad con los cambios ya realizados
     */
    public PublicacionEntity update(PublicacionEntity ent) throws BusinessLogicException{
      
        LOGGER.log(Level.INFO, "Actualizando la entidad de Publicacion con el id={0}", ent.getId());
        
//TODO: No hay ninguna regla de negocio? 
        return persistencia.update(ent);
    }
    
    /**
     * Elimina una Publicacion
     * @param ent la adquiisicion que se desea eliminar
     */
    public void delete(PublicacionEntity ent){
        LOGGER.log(Level.INFO, "Eliminando la publicacion con id ={0}", ent.getId());
        //TODO: este método debe recibir un id y hay que validar que existe Publicacion con ese id
        persistencia.delete(ent.getId());
    }
        
}
