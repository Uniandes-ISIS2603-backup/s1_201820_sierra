/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaEntity;
import co.edu.uniandes.csw.sierra.entities.RazaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rj.gonzalez10
 */
public class RazaDetailDTO extends RazaDTO {

    /**
     * Lista de mascotas que contiene una Raza
     */
    private List<MascotaDTO> mascotas;

    public RazaDetailDTO() {
        super();
    }

    /**
     * Crea un objeto RazaDetailDTO a partir de un objeto RazaEntity incluyendo
     * los atributos de RazaDTO.
     *
     * @param entity Entidad Raza Entity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public RazaDetailDTO(RazaEntity entity) {
        super(entity);
        if (entity != null) {

            mascotas = new ArrayList<>();
            for (MascotaEntity entityMascotas : entity.getMascotas()) {
                mascotas.add(new MascotaDTO(entityMascotas));
            }
        }

    }

    /**
     * Convierte un objeto RazaDetailDTO a RazaEntity incluyendo los atributos
     * de RazaDTO.
     *
     * @return Nueva objeto RazaEntity.
     *
     */
    @Override
    public RazaEntity toEntity() {
        RazaEntity entity = super.toEntity();
        if (mascotas != null) {
            List<MascotaEntity> mascotasEntity = new ArrayList<>();
            for (MascotaDTO mascotaDto : mascotas) {
                if (MascotaAdopcionDTO.class.isInstance(mascotaDto)) {
                    mascotasEntity.add(mascotaDto.toEntity(new MascotaAdoptadaEntity()));
                    entity.setMascotas(mascotasEntity);
                } else {
                    mascotasEntity.add(mascotaDto.toEntity(new MascotaAdoptadaEntity()));
                    entity.setMascotas(mascotasEntity);
                }
            }
            entity.setMascotas(mascotasEntity);
        }

        return entity;
    }

    /**
     * @return the mascotas
     */
    public List<MascotaDTO> getMascotas() {
        return mascotas;
    }

    /**
     * @param mascotas the mascotas to set
     */
    public void setMascotas(List<MascotaDTO> mascotas) {
        this.mascotas = mascotas;
    }

}
