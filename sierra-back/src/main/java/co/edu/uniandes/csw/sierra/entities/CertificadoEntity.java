/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author jc.sanchez12
 */
@Entity
public class CertificadoEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // fecha de expedisión del certicado
    private Date fecha;
    //String que contiene  la descripción del certificado de pureza del perro
    private String descripcion;
    // String que contiene el url de la imagen
    private String imagen;
    
    @ManyToOne
    private MascotaVentaEntity mascotaVenta;


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
