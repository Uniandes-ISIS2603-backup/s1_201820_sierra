/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Entidad que representa una calificacion.
 * 
 * @author Juan David Zambrano
 */
@Entity
public class CalificacionEntity extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**
     * Comentarios de la caificacion
     */
    private String comentarios;
    
    /**
     * El valor de la calificacion
     */
    private Double valor;
    
   /**
    * Sugerencias de la calificacion
    */
    private String sugerencia;

    
    //----------------
    //Asociaciones
    //---------------
    
    /**
     * La adquisicion a la que esta referenciada la calificacion
     */
    @OneToOne
    private AdquisicionEntity adquisicion;
    
    
    
    
    /**
     * @return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the sugerencia
     */
    public String getSugerencia() {
        return sugerencia;
    }

    /**
     * @param sugerencia the sugerencia to set
     */
    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    /**
     * @return the adquisicion
     */
    public AdquisicionEntity getAdquisicion() {
        return adquisicion;
    }

    /**
     * @param adquisicion the adquisicion to set
     */
    public void setAdquisicion(AdquisicionEntity adquisicion) {
        this.adquisicion = adquisicion;
    }

    
}
