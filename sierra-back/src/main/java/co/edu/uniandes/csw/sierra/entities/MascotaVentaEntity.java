/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
import javax.persistence.Entity;

/**
 *
 * @author Juan David Zambrano
 */
@Entity
public class MascotaVentaEntity extends MascotaEntity
{
    
    private Integer precio;
    
    @OneToMany
    @PodamExclude
    private List<CertificadoEntity> certificados;

    /**
     * @return the precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     * @return the certificados
     */
    public List<CertificadoEntity> getCertificados() {
        return certificados;
    }

    /**
     * @param certificados the certificados to set
     */
    public void setCertificados(List<CertificadoEntity> certificados) {
        this.certificados = certificados;
    }
}
