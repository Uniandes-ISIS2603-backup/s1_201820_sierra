/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jc.sanchez12
 */
public class ComprobanteEntity extends BaseEntity implements Serializable{
    
    private Long id;
    private Integer valorTotal;
    private Date fecha;
    private Long clienteId;
    
    
    /**
     * Factura ligada al comprobante actual.
     */ 
//   private FacturaDTO factura;
//
    /**
     * Medio de pago usado para el actual comprobante.
     */
//   private MedioDePagoDTO medioDePago;    
//    
    
    /**
     * Métdo que retorna el id del Comprobante.
     * @return id
     */ 
    @Override
    public Long getId() {
        return id;
    }
    
    /**
     * Método que retorna el valor total del comprobante.
     * @return valorTotal
     */
    public Integer getValorTotal() {
        return valorTotal;
    }
    
    /**
     * Método que retorna la fecha en que se genero el comprobante.
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }
    
    /**
     * Método que retorna el id del cliente ligado al comprobante.
     * @return clienteId
     */
    public Long getClienteId() {
        return clienteId;
    }
    
    /**
     * Metodo que recibe el id del comprobante como parametro.
     * @param id 
     */ 
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Método que recibe el valor total del comprobante como parametro.
     * @param valorTotal 
     */
    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    /**
     * Método que recibe la fecha del comprobante como parametro.
     * @param fecha
     */ 
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    /**
     * Método que retorna el id del cliente como parametro.
     * @param clienteId 
     */
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    
    /**
     * Método que retorna la factura ligada al c omprobante.
     * @return factura
     */ 
//  public FacturaDTO getFactura()    
//  {
//      return this.factura;
//  }
    /**
     * Método que recibe a la factura ligada al comprobante actual como parámetro.
     * @param factura
     */
//  public void setFactura(FacturaDTO factura)
//  {
//      this.factura = factura;
//  }
    /**
     * Método que retorna al medio de pago usad en el comprobante actual.
     * return medio de pago usado en el comprobante actual.
     */ 
//  public MedioDePagoDTO getMedioDePago()
//  {
//      return this.medioDePago;
//  }
    /**
     * Método que recibe al medio de pago usado en el comprobante actual como parametro.
     * @param medioDePago
     */ 
//  public void setMedioDePago(MedioDePagoDTO medioDePago)
//  {  
//      this.medioDePago = medioDePago;
//  }
}
