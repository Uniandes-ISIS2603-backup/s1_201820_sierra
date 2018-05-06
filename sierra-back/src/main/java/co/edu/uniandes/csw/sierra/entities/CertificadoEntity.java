/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;
import co.edu.uniandes.csw.sierra.podam.DateStrategy;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author jc.sanchez12
 */
@Entity
public class CertificadoEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // fecha de expedición del certicado
    @Temporal(javax.persistence.TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fecha;
    //String que contiene  la descripción del certificado de pureza del perro
    private String descripcion;
    // String que contiene el url de la imagen
    private String imagen;
    
    @ManyToOne
    @PodamExclude
    private MascotaVentaEntity mascotaVenta;

    /**
     * Obtiene la fecha en la que se realizo el certificado.
     * @return Fecha del certificado.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Asigna la fecha al certificado.
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la descripcion del certificado.
     * @return Descripcion del cerificado.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna la descripcion del certificado.
     * @param descripcion Nueva descripcion del certificado.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la url de la imagen de la mascota del certificado.
     * @return Url de la imagen de la mascota.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Asigna direccion url de la imagen de la mascota.
     * @param imagen Url de la mascota del certificado.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene la mascota que se vendio.
     * @return the mascotaVenta a la que pertenece el certificado.
     */
    public MascotaVentaEntity getMascotaVenta() {
        return mascotaVenta;
    }

    /**
     * Asigna la mascota en venta del certificado
     * @param mascotaVenta the mascotaVenta por asignar al certificado.
     */
    public void setMascotaVenta(MascotaVentaEntity mascotaVenta) {
        this.mascotaVenta = mascotaVenta;
    }
    
    
}
