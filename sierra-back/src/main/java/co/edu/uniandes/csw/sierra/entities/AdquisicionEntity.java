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
 * Entidad que representa una Adquisicion.
 * 
 * 
 * @author Juan David Zambrano
 */
@Entity
public class AdquisicionEntity extends BaseEntity implements Serializable{
    
    private Double valorTotal;
       
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    //------------------
    //Asociaciones
    //------------------
    
        
    private MascotaEntity mascota;

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
