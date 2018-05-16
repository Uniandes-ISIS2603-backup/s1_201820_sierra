/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.AcontecimientoEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.entities.PublicacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jd.zambrano
 */
public class MascotaAdopcionDetailDTO extends MascotaAdopcionDTO {

    /**
     * Lista de acontecimientos de una mascota adoptada
     */
    private List<AcontecimientoDTO> acontecimientos;

    /**
     * Raza de la mascota
     */
    private RazaDTO raza;

    /**
     * Publicaciones de la mascota
     */
    private List<PublicacionDTO> publicaciones;

    /**
     * Adquisicion de a mascota
     */
    private AdquisicionDTO adquisicion;

    /**
     * Constructor por defecto
     */
    public MascotaAdopcionDetailDTO() {
        super();
    }

    /**
     * Crea un objeto MascotaAdopcionDetailDTO a partir de un objeto
     * MascotaAdoptadaEntity incluyendo los atributos de EspecieDTO.
     *
     * @param entity Entidad MascotaAdoptadaEntity desde la cual se va a crear
     * el nuevo objeto.
     *
     */
    public MascotaAdopcionDetailDTO(MascotaAdoptadaEntity entity) {
        super(entity);
        if (entity != null) {
            if (entity.getRaza() != null) {
                this.raza = new RazaDTO(entity.getRaza());
            } else {
                entity.setRaza(null);
            }
            if (entity.getAdquisicion() != null) {
                this.adquisicion = new AdquisicionDTO(entity.getAdquisicion());
            } else {
                entity.setAdquisicion(null);
            }
            if (entity.getPublicaciones() != null) {
                publicaciones = new ArrayList<>();
                for (PublicacionEntity entityPublicacion : entity.getPublicaciones()) {
                    publicaciones.add(new PublicacionDTO(entityPublicacion));
                }
            }
            if (entity.getAcontecimientos() != null) {
                acontecimientos = new ArrayList<>();
                for (AcontecimientoEntity entityAcontecimiento : entity.getAcontecimientos()) {
                    acontecimientos.add(new AcontecimientoDTO(entityAcontecimiento));
                }
            }
        }

    }

    /**
     * Transformar el DTO a una entidad
     *
     * @return La entidad que representa la mascota.
     */
    @Override
    public MascotaAdoptadaEntity toEntity() {
        MascotaAdoptadaEntity mascota = super.toEntity();
        if (this.getRaza() != null) {
            mascota.setRaza(this.getRaza().toEntity());
        }
        if (this.getAdquisicion() != null) {
            mascota.setAdquisicion(this.getAdquisicion().toEntity());
        }
        if (publicaciones != null) {
            List<PublicacionEntity> publicacionEnity = new ArrayList<>();
            for (PublicacionDTO dtopub : publicaciones) {
                publicacionEnity.add(dtopub.toEntity());
            }
            mascota.setPublicaciones(publicacionEnity);
        }

        if (acontecimientos != null) {
            List<AcontecimientoEntity> acontecimientoEntity = new ArrayList<>();
            for (AcontecimientoDTO acontecimientoDto : acontecimientos) {
                acontecimientoEntity.add(acontecimientoDto.toEntity());
            }
            mascota.setAcontecimientos(acontecimientoEntity);
        }
        return mascota;

    }

    /**
     * @return the acontecimientos
     */
    public List<AcontecimientoDTO> getAcontecimientos() {
        return acontecimientos;
    }

    /**
     * @param acontecimientos the acontecimientos to set
     */
    public void setAcontecimientos(List<AcontecimientoDTO> acontecimientos) {
        this.acontecimientos = acontecimientos;
    }

    /**
     * @return the raza
     */
    public RazaDTO getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(RazaDTO raza) {
        this.raza = raza;
    }

    /**
     * @return the publicaciones
     */
    public List<PublicacionDTO> getPublicaciones() {
        return publicaciones;
    }

    /**
     * @param publicaciones the publicaciones to set
     */
    public void setPublicaciones(List<PublicacionDTO> publicaciones) {
        this.publicaciones = publicaciones;
    }

    /**
     * @return the adquisicion
     */
    public AdquisicionDTO getAdquisicion() {
        return adquisicion;
    }

    /**
     * @param adquisicion the adquisicion to set
     */
    public void setAdquisicion(AdquisicionDTO adquisicion) {
        this.adquisicion = adquisicion;
    }

}
