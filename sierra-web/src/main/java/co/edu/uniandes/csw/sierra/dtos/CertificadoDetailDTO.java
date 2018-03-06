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
     private MascotaVentaDTO mascotaVenta;
    public CertificadoDetailDTO(){
        super();
    }
     /**
     * constructor que convierte una Entity a un DetailDTO
     * @param ent la entidad que se quiere convertir
     */
    public CertificadoDetailDTO(CertificadoEntity ent){
        super(ent);
        if(ent != null){
            this.mascotaVenta = new MascotaVentaDTO(ent.getMascotaVenta());
        }
    }
    public MascotaVentaDTO getMascota() {
        return mascotaVenta;
    }

    /**
     * @param mascota the mascota to set
     */
    public void setMascota(MascotaVentaDTO mascota) {
        this.mascotaVenta = mascota;
    }
    
}
