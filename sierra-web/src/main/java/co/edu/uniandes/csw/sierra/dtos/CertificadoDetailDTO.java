/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.CertificadoEntity;

/**
 *
 * @author rj.gonzalez10
 */
public class CertificadoDetailDTO extends CertificadoDTO {
    /**
     * Mascota asociada al certificado
     */
    private MascotaVentaDTO mascotaVenta;

   
   
    /**
     * Constructor por defecto
     */
    public CertificadoDetailDTO() {
        super();

    }

    /**
     * Crea un objeto CertificadoDetailDTO a partir de un objeto CertificadoEntity
     * incluyendo los atributos de CertificadoDTO.
     *
     * @param entity Entidad CertificadoEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public CertificadoDetailDTO(CertificadoEntity entity) {
        super(entity);
        if (entity != null) {
             if (entity.getMascotaVenta() != null) {
                this.mascotaVenta = new MascotaVentaDTO(entity.getMascotaVenta());
            }
        }

    }

    /**
     * Convierte un objeto CertificadoDetailDTO a CertificadoEntity incluyendo los
     * atributos de CertificadoDTO.
     *
     * @return Nueva objeto CertificadoEntity.
     *
     */
    @Override
    public CertificadoEntity toEntity() {
        CertificadoEntity entity = super.toEntity();
        if (mascotaVenta != null) {
           entity.setMascotaVenta(mascotaVenta.toEntity());
            }
           
        return entity;
    }

    /**
     * @return the mascotas
     */
    public MascotaVentaDTO getMascotaVenta() {
        return mascotaVenta;
    }

    /**
     * @param pMascotaVenta the mascotas to set
     */
    public void setMascotaVenta(MascotaVentaDTO pMascotaVenta) {
        this.mascotaVenta = pMascotaVenta;
    }


}
