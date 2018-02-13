/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

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
    private long  id;
    private int valorTotal;
    private Date fecha;
    private long clienteId;
    
    public ComprobanteDTO()
    {
        
    }

    public long getId() {
        return id;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public long getClienteId() {
        return clienteId;
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

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }
    
    
}
