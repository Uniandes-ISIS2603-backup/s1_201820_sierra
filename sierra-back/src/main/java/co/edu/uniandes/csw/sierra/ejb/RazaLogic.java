/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaVentaEntity;
import co.edu.uniandes.csw.sierra.entities.RazaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.RazaPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author rj.gonzalez10
 */
@Stateless
public class RazaLogic {

    private static final Logger LOGGER = Logger.getLogger(SierraLogic.class.getName());

    @Inject
    private RazaPersistence persistence;

    @Inject
    private MascotaAdoptadaLogic mascAdopLogic;

    @Inject
    private MascotaVentaLogic mascVentLogic;

    /**
     * Crea una entity en la base de datos de tipo Raza
     *
     * @param entity Bojeto con los datos de la nueva RazaEntity
     * @return Objeto de tipo RazaEntity con los datos nuevos
     * @throws BusinessLogicException
     */
    public RazaEntity create(RazaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de una entidad de Raza");
        if (persistence.findByName(entity.getNombreRaza()) != null) {
            throw new BusinessLogicException("Ya existe una entidad de Raza con el nombre \"" + entity.getName() + "\"");
        } else {
            persistence.create(entity);
            LOGGER.info("Termina proceso de creación de una entidad de Raza");
            return entity;
        }
    }

    /**
     * Obtiene la lista de los registros de Raza.
     *
     * @return Colección de objetos de RazaEntity.
     */
    public List<RazaEntity> getAll() {
        LOGGER.info("Inicia proceso de consultar todas las entidades de Raza");
        List<RazaEntity> entities = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las entidades de Raza");
        return entities;
    }

    /**
     * Obtiene los datos de una instancia de Raza a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de EsoeciEntity con los datos de la raza consultada.
     */
    public RazaEntity getById(Long id) {
        return persistence.find(id);
    }

    /**
     * Obtiene los datos de una instancia de Raza a partir de su nombre.
     *
     * @param nombre nombre de la instancia a consultar
     * @return Instancia de RazaEntity con los datos de la especie consultada.
     */
    public RazaEntity getByName(String nombre) {
        return persistence.findByName(nombre);
    }

    /**
     * Actualiza la información de una instancia de Raza.
     *
     * @param entity Instancia de RazaEntity con los nuevos datos.
     * @return Instancia de RazaEntity con los datos actualizados.
     */
    public RazaEntity update(RazaEntity entity) {
        RazaEntity ent = persistence.find(entity.getId());
        if (ent != null) {
            if (("").equals(entity.getNombreRaza())) {
                return null;
            } else {
                return persistence.update(entity);
            }
        }
        return null;
    }

    /**
     * Elimina una instancia de Raza de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @throws BusinessLogicException exception cuando no exite una raza con ese
     * id.
     */
    public void delete(Long id) throws BusinessLogicException {
        if (persistence.find(id) == null) {
            throw new BusinessLogicException("El elemento que se desea eliminar no existe");
        }
        persistence.delete(id);
    }

    public RazaEntity addMascota(Long razaId, Long mascotaId) throws BusinessLogicException {

        //Revisa que existe la raza
        RazaEntity razaEnt = getById(razaId);
        if (razaEnt == null) {
            throw new BusinessLogicException("No existe una raza con el id: " + razaId);
        }

        //revisa que existe la mascota con el id dado, busca primero en mascota adoopcion y luego en venta
        //Se sabe que el id es unico para mascotas en general, entonces no existe ninguna
        //mascota en venta que tenga el mismo id que la mascota para adopcion y viceversa (Asi se escribe?)
        MascotaAdoptadaEntity mascAdopEntity =mascAdopLogic.getMascotaAdoptadaById(mascotaId);
        MascotaVentaEntity mascVentEntity = mascVentLogic.getById(mascotaId);
        if (mascAdopEntity != null) {
            if (razaEnt.getMascotas() == null) {
                razaEnt.setMascotas(new ArrayList<>());
            }
            razaEnt.getMascotas().add(mascVentEntity);
            mascAdopEntity.setRaza(razaEnt);
            return razaEnt;
        } else if (mascVentEntity != null) {
            if (razaEnt.getMascotas() == null) {
                razaEnt.setMascotas(new ArrayList<>());
            }
            razaEnt.getMascotas().add(mascVentEntity);
            mascVentEntity.setRaza(razaEnt);
            return razaEnt;
        } else {
            throw new BusinessLogicException("No existe una mascota con el id: " + mascotaId);
        }

    }

}
