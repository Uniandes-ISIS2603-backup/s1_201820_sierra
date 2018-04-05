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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 * Entidad que representa una Adquisicion.
 * 
 * 
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
    
    //------------------
    //Asociaciones
    //------------------
    
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
    @OneToOne(mappedBy= "adquisicion", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @PodamExclude
    private CalificacionEntity calificacion;
    
    /**
     * Factura de la adquisicion
     */
    @OneToOne
    @PodamExclude
    private FacturaEntity factura;

    
    
    
    
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

    /**
     * @return the mascota
     */
    public MascotaEntity getMascota() {
        return mascota;
    }

    /**
     * @param mascota the mascota to set
     */
    public void setMascota(MascotaEntity mascota) {
        this.mascota = mascota;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the calificacion
     */
    public CalificacionEntity getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(CalificacionEntity calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the factura
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }
    
}
