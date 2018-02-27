/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jc.sanchez12
 */
@Entity
public class FacturaEntity extends BaseEntity implements Serializable{
    
    private Long id;
    private Integer valorTotal;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
     /**
     * Adquisición ligada a la factura.
     */ 
    @OneToOne
    private AdquisicionEntity adquisicion;
    
    /**
     * Lista de comprobantes ligaras a la factura.
     */ 
    @OneToMany
    private List<ComprobanteEntity> comprobantes;
   
    /**
     * Método que retorna el id de la factura.
     * @return 
     */
    @Override
    public Long getId() {
        return id;
    }
    
    /**
     * Método que retorna el valor total de la factura.
     * @return 
     */
    public Integer getValorTotal() {
        return valorTotal;
    }
    /**
     * Método que retorna la fecha en que se generó la factura.
     * @return 
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Método que recibe como parámetro el id de la Factura.
     * @param id 
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Método que recibe como parámetro el valor total de la factura.
     * @param valorTotal 
     */
    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    /**
     * Método que recibe coom parámetro la fecha en que se generó la Factura.
     *@param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
     * @Param adquisicion
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
}
