/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.eclipse.persistence.jpa.config.Cascade;
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
    private Integer precio;
    private String animalAdquirido;
    
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
     * 
     * @return 
     */
    public Long getIdCliente() {
        return idCliente;
    }
    
    /**
     * 
     * @return 
     */
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    /**
     * 
     * @return 
     */
    public String getAnimalAdquirido() {
        return animalAdquirido;
    }
    
    /**
     * 
     * @param idCliente 
     */
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    
    /**
     * 
     * @param nombreCliente 
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    /**
     * 
     * @param animalAdquirido 
     */
    public void setAnimalAdquirido(String animalAdquirido) {
        this.animalAdquirido = animalAdquirido;
    }
    
    
    
   
    
    
    /**
     * Método que retorna el valor total de la factura.
     * @return 
     */
    public Integer getPrecio() {
        return precio;
    }
    

   
    
    /**
     * Método que recibe como parámetro el valor total de la factura.
     * @param valorTotal 
     */
    public void setPrecio(Integer valorTotal) {
        this.precio = valorTotal;
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