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
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *Entidad que representa una publicacion.
 *@author ja.penat
 */
@Entity
public class PublicacionEntity extends BaseEntity implements Serializable
{

    private static final long serialVersionUID = 1L;
    
    /**
     * La mascota que  tiene  publicaciones
     */
    @ManyToOne
    private MascotaEntity mascota;
    
    /**
     * Tipo de publicacion
     */    
    private String tipo;
    
    /**
     * Foto asociada a la publicacion
     */
    private String fotoURL;
    
    /**
     * Fecha de la publicacion
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fecha;
       
    /**
     * Comentario  de la publicacion
     */
    private String comentario;
    
     /**
     * Metodo que se encarga de retornar el tipo de la publicacion.
     * @return el tipo  de la publicacion.
     */
    public String getTipo()
    {
        return tipo;
    }
    
    /**
     * Metodo que se encarga de cambiar el tipo  actual de la publicacion.
     * @param pTipo, el tipo
     */
    public void setTipo(String pTipo)
    {
        this.tipo = pTipo;
    } 
    
     /**
     * Metodo que se encarga de retornar la "foto"  de la publicacion.
     * @return FotoURL.
     */
    public String getFotoURL()
    {
        return fotoURL;
    }
    
     /**
     * Metodo que se encarga de cambiar la foto de la actual publicacion.
     * @param pFotoURL.
     */
    public void setFotoURL(String pFotoURL)
    {
        this.fotoURL = pFotoURL;
    }
    
     /**
     * Metodo que se encarga de retornar la fecha de la publicacion .
     * @return la fecha
     */
    public Date getFecha() 
    {
        return fecha;
    }

    /**
     * Metodo que se encarga de cambiar la fecha actual de la pbulicacion.
     * @param pFecha,  nueva fecha
     */
    public void setFecha(Date pFecha) 
    {
        this.fecha = pFecha;
    }

     /**
     * Metodo que se encarga de retornar el comentario de la publicacion.
     * @return el comentario de la publicacion.
     */
    public String getComentario()
    {
        return comentario;
    }

     /**
     * Metodo que se encarga de cambiar el comentario de la actual publicacion.
     * @param pComentario,nuevo comentario.
     */
    public void setComentario(String pComentario)
    {
        this.comentario = pComentario;
    }
    
     /**
     * Metodo que se encarga de retornar la mascota asociada a la publicacion.
     * @return mascota.
     */
    public MascotaEntity getMascota()
    {
        return mascota;
    }
    
    /**
     * Metodo encargado de cambiar la mascota a la que esta asignada la publicacion.
     * @param pMascota
     */
    public void setMascota(MascotaEntity  pMascota)
    {
        mascota = pMascota;
    }
}


