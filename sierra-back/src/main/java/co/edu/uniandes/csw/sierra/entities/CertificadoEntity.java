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

    /**
     * @return the mascotaVenta
     */
    public MascotaVentaEntity getMascotaVenta() {
        return mascotaVenta;
    }

    /**
     * @param mascotaVenta the mascotaVenta to set
     */
    public void setMascotaVenta(MascotaVentaEntity mascotaVenta) {
        this.mascotaVenta = mascotaVenta;
    }
    
    
}
