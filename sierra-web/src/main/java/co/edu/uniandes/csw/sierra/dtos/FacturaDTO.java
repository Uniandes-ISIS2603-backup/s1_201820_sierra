/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

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
    private long id;
    private int valorTotal;
    private Date fecha;
    
    public FacturaDTO()
    {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public Date getFecha() {
        return fecha;
    }
    
    
}
