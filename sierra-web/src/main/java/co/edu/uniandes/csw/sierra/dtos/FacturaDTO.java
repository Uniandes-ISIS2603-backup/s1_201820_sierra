/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.FacturaEntity;
import java.util.Date;

/**
 *FacturaDTO, objeto de transferencia de datos de la entidad Factura
 * 
 * <p> 
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 * {
 *  "id": number,
 *  "valorTotal":  number, 
 *  "fecha": date
 * }
 * * </pre>
 * Por ejemplo, una factura se representa de la siguiente manera: <br>
 * <p>
 * <pre>
 * {
 *  "id":1001,
 *  "valorTotal": 40000,
 *  "fecha":  "13/02/2018"
 * }
 * </pre>
 * 
 * @author ja.amortegui10
 */
public class FacturaDTO {
    private Long id;
    private Integer precio;
    private String nombreCliente;
    private Long idCliente;
    
    public FacturaDTO()
    {
    }
    
    public FacturaDTO(FacturaEntity entity)
    {
        this.id = entity.getId();
        this.precio = entity.getPrecio();
        this.nombreCliente = entity.getNombreCliente();
        this.idCliente = entity.getIdCliente();
        
    }
    
    /**
     * Método que transforma la clase de un DTO a un Entity y retorna el resultado.
     * @return 
     */
    public FacturaEntity toEntity()
    {
        FacturaEntity entity = new FacturaEntity();
        entity.setId(id);
        entity.setPrecio(precio);
        entity.setNombreCliente(nombreCliente);
        entity.setIdCliente(idCliente);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValorTotal(Integer precio) {
        this.precio = precio;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getValorTotal() {
        return precio;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public void setIdCliente(Long idCliente)
    {
        this.idCliente = idCliente;
    }
    
    public Long getIdCliente()
    {
        return idCliente;
    }
    
    
}
