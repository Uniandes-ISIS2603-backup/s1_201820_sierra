/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Entidad que representa una calificacion.
 * 
 * @author Juan David Zambrano
 */
@Entity
public class CalificacionEntity extends BaseEntity implements Serializable{
    
    
    private String comentarios;
    
    private Double valor;
    
    private String sugerencia;

    
    //----------------
    //Asociaciones
    //0000000000000000
    
    @OneToOne(mappedBy= "calificacion")
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

    
}
