/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
/**
 *Entidad que representa un Acontecimiento.
 *@author ja.penat
 */
@Entity
public class AcontecimientoEntity extends BaseEntity implements Serializable
{

    private static final long serialVersionUID = 1L;
  
    private String nombre;
    
    private String descripcion;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    private Integer importancia;
    
    private String tipo;
    
    private String fotoURL;
    
    /**
     * Metodo que se encarga de retornar el nombre del acontecimiento.
     * @return El nombre del acontecimiento.
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Metodo que se encarga de cambiar el nombre del acontecimiento.
     * @param pNombre,  nuevo nombre.
     */
    public void setNombre(String pNombre)
    {
        this.nombre = pNombre;
    }
    
    /**
     * Metodo que se encarga de retornar la descripcion del acontecimiento.
     * @return La descripcion del acontecimiento.
     */
    public String getDescripcion()
    {
        return descripcion;
    }

     /**
     * Metodo que se encarga de cambiar la descripcion actual del acontecimiento.
     * @param pDescripcion,nueva descripcion.
     */
    public void setDescripcion(String pDescripcion)
    {
        this.descripcion = pDescripcion;
    }
    
    /**
     * Metodo que se encarga de retornar la fecha del acontecimiento.
     * @return la fecha
     */
    public Date getFecha() 
    {
        return fecha;
    }

    /**
     * Metodo que se encarga de cambiar la fecha actual del acontecimiento.
     * @param pFecha,  nueva fecha
     */
    public void setFecha(Date pFecha) 
    {
        this.fecha = pFecha;
    }
    
    /**
     * Metodo que se encarga de retornar la importancia del acontecimiento.
     * @return la importancia del acontecimiento.
     */
    public Integer getImportancia()
    {
        return importancia;
    }
    
    /**
     * Metodo que se encarga de cambiar la importancia  actual del acontecimiento.
     * @param pImportancia, nuevo indice de importancia
     */
    public void setImportancia(Integer pImportancia)
    {
        this.importancia = pImportancia;
    }
    
    /**
     * Metodo que se encarga de retornar el tipo  del acontecimiento.
     * @return el tipo  del acontecimiento.
     */
    public String getTipo()
    {
        return tipo;
    }
    
    /**
     * Metodo que se encarga de cambiar el tipo  actual del acontecimiento.
     * @param pTipo, el tipo
     */
    public void setTipo(String pTipo)
    {
        this.tipo = pTipo;
    } 
    
     /**
     * Metodo que se encarga de retornar la "foto"  del acontecimiento.
     * @return FotoURL.
     */
    public String getFotoURL()
    {
        return fotoURL;
    }
    
     /**
     * Metodo que se encarga de cambiar la foto  actual del acontecimiento.
     * @param pFotoURL.
     */
    public void setFotoURL(String pFotoURL)
    {
        this.fotoURL = pFotoURL;
    }
    
}
