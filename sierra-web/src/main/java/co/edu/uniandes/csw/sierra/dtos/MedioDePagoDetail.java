/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

/**
 *MedioDePagoDTO Objeto de transferencia de datos datallada de la entidad Medio de pago. Los DTO contienen las 
 * representaciones de los JSON que se transfieren entre el cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase  implementa el siguiente modelo:<br>
 * <pre>
 *  {
 * "id": number,
 * "numeroReferencia": number,
 * "tipo": string,
 * cliente:
 *        {
 *        "name": string,
 *        "apellido": string,
 *        "cedula": number,
 *        "id": number,
 *        "telefono": number
 *         } 
 *  }
 * </pre>
 * Por ejemplo una entidad Medio de pago se representa asi:<br>
 * <p>
 * <pre>
 *  {
 * "id": 010,
 * "numeroReferencia": 100,
 * "tipo": "efectivo",
 * cliente:
 *         {
 *         "name": "Andres",
 *         "apellido": "Castro",
 *         "cedula": 1072548232,
 *         "id": 001,
 *         "telefono": 3182564852
 *         }
 *  }
 * </pre>
 * 
 * @author de.gutierrez
 */
public class MedioDePagoDetail extends MedioDePagoDTO
{
    private ClienteDTO cliente;
    
    /**
     * Constructor por defecto.
     */
    public MedioDePagoDetail()
    {
        super();
    }
    
    /**
     * Obtiene la informacion del cliente que selecciona un medio de pago.
     * @return El cliente que selecciono un medio de pago.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Asigna un cliente que desea seleccionar un medio de pago.
     * @param cliente El nuevo cliente.
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
        
}
