/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.PrimaryKeyJoinColumn;
import uk.co.jemos.podam.common.PodamIntValue;

/**
 *
 * @author Juan David Zambrano
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class MascotaVentaEntity extends MascotaEntity
{
    private static final long serialVersionUID = 1L;
    
    /**
     * Precio a pagar por la mascota
     */
    @PodamIntValue(minValue = 0)
    private Integer precio;
    
    /**
     * Certificados asociados a la mascota
     */
    @OneToMany(mappedBy = "mascotaVenta", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @PodamExclude
    private List<CertificadoEntity> certificados;

    /**
     * Obtiene el precio de la mascota que se va vender.
     * @return the precio de la mascota en venta.
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * Asigna el precio de una mascota en venta.
     * @param precio the precio de una mascota.
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     * Obtiene los certificados de la mascota en venta.
     * @return the certificados de la mascota.
     */
    public List<CertificadoEntity> getCertificados() {
        return certificados;
    }

    /**
     * Asigna certificados a una mascota en venta.
     * @param certificados the certificados de una mascota en venta.
     */
    public void setCertificados(List<CertificadoEntity> certificados) {
        this.certificados = certificados;
    }
}
