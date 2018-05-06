/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Entidad que representa una calificacion.
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

    /**
     * La adquisicion a la que esta referenciada la calificacion
     */
    @OneToOne
    @PodamExclude
    private AdquisicionEntity adquisicion;
    
    /**
     * Obtiene los comentarios que acompañan una calificacion.
     * @return the comentarios de una calificacion.
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Asigna los comentarios a una calificacion.
     * @param comentarios the comentarios realizados junto con la calificacion.
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Obtiene el valor por el que se realizo la calificacion.
     * @return the valor de la calificacion realizada.
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Asigna el valor de la calificacion.
     * @param valor the valor de la nueva calificacion.
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Obtiene las sugerencias realizadas junto con la calificacion.
     * @return the sugerencia realizada para mejorar el servicio.
     */
    public String getSugerencia() {
        return sugerencia;
    }

    /**
     * Asigna una sugerencia por el servicio.
     * @param sugerencia the sugerencia para mejorar el sevicio.
     */
    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    /**
     * Obtiene la adquisicion a la que se realiza la calificacion.
     * @return the adquisicion a la que pertenece la calificacion.
     */
    public AdquisicionEntity getAdquisicion() {
        return adquisicion;
    }

    /**
     * Asocia la adquisicion a la calificacion.
     * @param adquisicion the adquisicion a la que pertenece la calificacion.
     */
    public void setAdquisicion(AdquisicionEntity adquisicion) {
        this.adquisicion = adquisicion;
    }

    
}
