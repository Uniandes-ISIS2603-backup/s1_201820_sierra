/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.ClienteEntity;
import co.edu.uniandes.csw.sierra.entities.ComprobanteEntity;
import co.edu.uniandes.csw.sierra.entities.MedioDePagoEntity;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 * MedioDePagoDTO Objeto de transferencia de datos datallada de la entidad Medio
 * de pago. Los DTO contienen las representaciones de los JSON que se
 * transfieren entre el cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo:<br>
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
 * </pre> Por ejemplo una entidad Medio de pago se representa asi:<br>
 * <p>
 * <
 * pre>
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
public class MedioDePagoDetailDTO extends MedioDePagoDTO {

    private List<ClienteDTO> clientes;
    private ComprobanteDTO comprobante;

    /**
     * Constructor por defecto.
     */
    public MedioDePagoDetailDTO() {
        super();
    }

    public MedioDePagoDetailDTO(MedioDePagoEntity entity) {
        super(entity);
        if(entity != null){
            if(entity.getClientes() != null){
                clientes = new ArrayList<>();
                for(ClienteEntity cliente : entity.getClientes()){
                    clientes.add(new ClienteDTO(cliente));
                }
            }
        }
    }

    @Override
    public MedioDePagoEntity toEntity() {
        MedioDePagoEntity medio = super.toEntity();
        if (clientes != null) {
           List<ClienteEntity> clienteEntity = new ArrayList<>();
           for(ClienteDTO dtoCliente : clientes){
            clienteEntity.add(dtoCliente.toEntity());
             }
           medio.setClientes(clienteEntity);
        }
        return medio;
    }

    /**
     * Obtiene la informacion del cliente que selecciona un medio de pago.
     *
     * @return El cliente que selecciono un medio de pago.
     */
    public List<ClienteDTO> getClientes() {
        return clientes;
    }

    /**
     * Asigna un cliente que desea seleccionar un medio de pago.
     *
     * @param cliente El nuevo cliente.
     */
    public void setCliente(List<ClienteDTO> clientes) {
        this.clientes = clientes;
    }

}
