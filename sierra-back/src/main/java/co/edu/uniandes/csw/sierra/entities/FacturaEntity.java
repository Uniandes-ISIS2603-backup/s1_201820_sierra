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
public class FacturaEntity extends BaseEntity implements Serializable{
    
    private Long id;
    private Integer valorTotal;
    private Date fecha;

       
    /**
     * Adquisición ligada a la factura.
     */ 
//       @OneToMany
//      private AdquisicionDTO adquisicion;
//      
    /**
     * Lista de comprobantes ligaras a la factura.
     */ 
//      @OneToMany
//      private IList<ComprobanteDetailDTO> comprobantes;
    
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
     * public Adquisicion getAdquisicion()
     */
//     {
//      return adquisicion;
//     }
//
    /**
     * Asigna una adquisición a la Factura.
     * @Param adquisicion
     */
//   public void setAdquisicion(AdquisicionDTO adquisicion) 
//   {
//      this.adquiscion = adquisicion;    
//   } 
    
    /**
     * Retorna una lista de comprobantes
     * @return una lista de comprobantes.
     */
//    public IList<ComprobanteDetailDTO> getComprobantes()
//    {
//         return this.adquisiciones;
//    }
    
    
    /**
     * Recibe como parámetro una lista de comprobantes
     * @param comprobantes
     */
//   public void setComprobantes(IList<ComproanteDetailDTO> comprobantes)
//   {
//       this.comprobantes = comprobante;
//   }    
}
