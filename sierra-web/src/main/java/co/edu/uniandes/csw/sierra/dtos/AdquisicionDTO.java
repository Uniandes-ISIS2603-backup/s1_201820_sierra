/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import java.util.Date;



/**
 * AdquisicionDTO es el objeto de transferencia de datos de la entidad Adquisicion.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 *  {
 *      "id":number,
 *      "valorTotal":number,
 *      "fecha":date
 *  }
 * </pre>
 * * Por ejemplo, una Adquisicion se representaria de la siguiente manera:<br>
 * <p>
 * <pre>
 *  {
 *      "id":1,
 *      "valorTotal":10000,
 *      "fecha":"20/05/2014"
 *  }
 * </pre>
 * @author Juan David Zambrano
 */
public class AdquisicionDTO {
    
    private Long id;
    
    private Double valorTotal;
    
    private Date fecha;
    
    public AdquisicionDTO(){
        
    }

    /**
     * @return the ID
     */
    public Long getID() {
        return id;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(Long id) {
        this.id = id;
    }

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
    
    
    
}
