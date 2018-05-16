/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que modela la entidad del medio de pago.
 * @author de.gutierrez "Esteban Gutierrez"
 */
@Entity
public class MedioDePagoEntity extends BaseEntity implements Serializable
{
    private Long numeroReferencia; //Atributo que contiene el numero de referencia de un medio de pago.
    private String tipo; //Atributo que contiene el tipo del medio de pago. Efectivo o tarjeta.

    /**
     * Lista de los clientes que emplean cierto medio de pago.
     */
    @PodamExclude
    @ManyToMany
    private List<ClienteEntity> clientes = new ArrayList<>();
    
    @PodamExclude
    @OneToOne(mappedBy="medioDePago", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private ComprobanteEntity comprobante;
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

    /**
     * Obtiene todos los clientes que pagan con determinado medio de pago.
     * @return Los clientes que tienen asociado el medio de pago.
     */
    public List<ClienteEntity> getClientes() {
        return clientes;
    }

    /**
     * Asigna clientes a un medio de pago.
     * @param clientes Lista de clientes para asignar  a un cliente.
     */
    public void setClientes(List<ClienteEntity> clientes) {
        this.clientes = clientes;
    }
    
    /**
     * Obtiene un comprobante asociado cuando se pago con el medio especifico.
     * @return El comprobante cuando se pago.
     */
    public ComprobanteEntity getComprobante() {
        return comprobante;
    }

    /**
     * Modifica el comprobante caundo se realiza un pago con un medio.
     * @param comprobante Nuevo comprobante por asignar.
     */
    public void setComprobante(ComprobanteEntity comprobante) {
        this.comprobante = comprobante;
    }
}
