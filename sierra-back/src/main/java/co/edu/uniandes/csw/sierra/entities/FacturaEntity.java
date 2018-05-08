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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jc.sanchez12
 */
@Entity
public class FacturaEntity extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Long idCliente;
    private String nombreCliente;
    private Integer valor;
    
     /**
     * Adquisición ligada a la factura.
     */ 
    @OneToOne(mappedBy="factura", cascade = CascadeType.PERSIST)
    @PodamExclude
    private AdquisicionEntity adquisicion;
    
    /**
     * Lista de comprobantes ligaras a la factura.
     */
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="factura")
    @PodamExclude
    private List<ComprobanteEntity> comprobantes;
    
    
    /**
     * Obtiene el identificador del cliente asignado a la factura.
     * @return El identificador del cliente.
     */
    public Long getIdCliente() {
        return idCliente;
    }
    
    /**
     * Obtiene el nombre del cliente asignado a la factura.
     * @return El nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }
        
    /**
     * Asigna el identificador del cliente a la factura.
     * @param idCliente Identificador del cliente.
     */
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    
    /**
     * Asigna el nombre del cliente a la factura.
     * @param nombreCliente Nombre del cliente a quien pertenece la factura.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    /**
     *Retorna el valor total de la factura.
     * @return el valor de la factura.
     */
    public Integer getValor() {
        return valor;
    }
    
    /**
     * Recibe como parámetro el valor total de la factura.
     * @param valorTotal de la factura.
     */
    public void setValor(Integer valorTotal) {
        this.valor = valorTotal;
    }
    
    /**
     * Retorna la Adquisición ligada a la Factura..
     * @return Adquisición ligada a la Factura.
     **/
     public AdquisicionEntity getAdquisicion() 
     {
        return adquisicion;
     }

    /**
     * Asigna una adquisición a la Factura.
     * @param adquisicion. La adquisición ligada a la factura.
     */
   public void setAdquisicion(AdquisicionEntity adquisicion) 
   {
      this.adquisicion = adquisicion;    
   } 
    
    /**
     * Retorna una lista de comprobantes
     * @return una lista de comprobantes.
     */
    public List<ComprobanteEntity> getComprobantes()
    {
         return comprobantes;
    }
   
    /**
     * Recibe como parámetro una lista de comprobantes
     * @param comprobantes
     */
   public void setComprobantes(List<ComprobanteEntity> comprobantes)
   {
       this.comprobantes = comprobantes;
   }  
   
   /**
    * Agrega un sólo comprobante a la lista de comprobantes.
    */
   public void setComprobante(ComprobanteEntity comprobanteEntity)
   {
       if(comprobantes == null)
           comprobantes = new ArrayList<ComprobanteEntity>();
       comprobantes.add(comprobanteEntity);
   }
}