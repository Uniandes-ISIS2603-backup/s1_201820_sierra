/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import co.edu.uniandes.csw.sierra.podam.DateStrategy;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 * Entidad que representa una Adquisicion.
 * @author Juan David Zambrano
 */
@Entity
public class AdquisicionEntity extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**
     * Valor total registrado por la adquisicion
     */
    private Double valorTotal;
       
    /**
     * Fecha en la que  se produjo la adquisicion
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fecha;
    
    /**
     * Mascota asociada  a la adquisicion
     */
    @OneToOne 
    @PodamExclude
    private MascotaEntity mascota;
    
    /**
     * Cliente que  hizo la adquisicion
     */
    @ManyToOne
    @PodamExclude
    private ClienteEntity cliente;
    
    /**
     * Calificacion de la adquisicion
     */
    @OneToOne(mappedBy= "adquisicion", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @PodamExclude
    private CalificacionEntity calificacion;
    
    /**
     * Factura de la adquisicion
     */
    @OneToOne
    @PodamExclude
    private FacturaEntity factura;
 
    /**
     * Obtiene el valor de la adquisicion.
     * @return valorTotal de la adquisicion de la mascota. 
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * Asigna el valor total por una adquisicion.
     * @param valorTotal the valorTotal de una adquisicion.
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Obtiene la fecha en la que se realizo la adquisicion.
     * @return the fecha  de la adquisicion.
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

    /**
     * Obtiene la mascota de la adquisicion.
     * @return the mascota de la adquisicion.
     */
    public MascotaEntity getMascota() {
        return mascota;
    }

    /**
     * Asigna una mascota a una adquisicion.
     * @param mascota the mascota por asignar a la adqusicion.
     */
    public void setMascota(MascotaEntity mascota) {
        this.mascota = mascota;
    }

    /**
     * Obtiene el cliente que realiza la adquisicion.
     * @return the cliente que realizo la adquisicion.
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * Asigna a la adquisicion un cliente.
     * @param cliente the cliente que realiza una adquisicion.
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la calificacion recibida por el proceso de adquisicion.
     * @return the calificacion de la adquisicion.
     */
    public CalificacionEntity getCalificacion() {
        return calificacion;
    }

    /**
     * Asigna una calificacion a la adquisicion.
     * @param calificacion the calificacion por la adquisicion.
     */
    public void setCalificacion(CalificacionEntity calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Obtiene la factura asociada a una adquisicion.
     * @return the factura de una adquisicion.
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     * Asigna la factura correspondiente por la nueva aduisicion.
     * @param factura the factura generada por la adquisicion.
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }
    
}
