/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.ComprobanteEntity;
import java.util.Date;

/**
 *ComprobanteDTO es el objeto de transferencia de datos detallada de la entidad Comprobante.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 * {
 *  "id":number,
 *  "valorTotal": number,
 *  "fecha": date,
 *  "clienteId": number
 * }
 * </pre>
 * Por ejemplo, un comprobante se representaría de la siguiente forma:<br>
 * <p>
 * <pre>
 * {
 *  "id":  1001,
 *  "valorTotal": 200000,
 *  "fecha": "13/02/2018",
 *  "clienteId": 2007
 * }
 * </pre>
 * @author ja.amortegui10
 */
public class ComprobanteDTO {
    private Long  id;
    private Integer valorTotal;
    private Date fecha;
    private Long clienteId;
    
    public ComprobanteDTO()
    {
        //Constructor por defecto
    }
    
    public ComprobanteDTO(ComprobanteEntity entity)
    {
        if(entity != null)
        {
            this.id = entity.getId();
            this.fecha = entity.getFecha();
            this.valorTotal = entity.getValorTotal();
            this.clienteId = entity.getClienteId();
        }
        
    }
    
    /**
     * Transforma la clase de DTO a Entity y la retorna.
     * @return 
     */
    public ComprobanteEntity toEntity()
    {
        ComprobanteEntity entity = new ComprobanteEntity();
        entity.setId(this.id);
        entity.setFecha(this.fecha);
        entity.setValorTotal(this.valorTotal);
        entity.setClienteId(this.clienteId);
        return entity;
    }
    
    public Long getId() {
        return id;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    
    
}
