/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * Clase que modela la entidad del medio de pago.
 * @author de.gutierrez "Esteban Gutierrez"
 */
@Entity
public class MedioDePagoEntity extends BaseEntity implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Long numeroReferencia; //Atributo que contiene el numero de referencia de un medio de pago.
    private String tipo; //Atributo que contiene el tipo del medio de pago. Efectivo o tarjeta.

    /**
     * Metodo que obtiene el numero de referencia de un medio de pago.
     * @return El numero de referencia.
     */
    public Long getNumeroReferencia() {
        return numeroReferencia;
    }

    /**
     * Metodo que establece el numero de referencia. 
     * @param numeroReferencia Nuevo numero de referencia.
     */
    public void setNumeroReferencia(Long numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    /**
     * Obtiene el tipo del medio de pago seleccionado por un usuario.
     * @return El tipo de pago.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna el tipo de medio de pago con el que un usuario debe pagar.
     * @param tipo Nuevo tipo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    } 
}

