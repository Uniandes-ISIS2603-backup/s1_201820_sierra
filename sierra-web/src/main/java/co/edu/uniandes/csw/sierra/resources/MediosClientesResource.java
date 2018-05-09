/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.ClienteDTO;
import co.edu.uniandes.csw.sierra.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.MedioDePagoLogic;
import co.edu.uniandes.csw.sierra.entities.ClienteEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author de.gutierrez
 */
@Path("mediosDePago/{medioId:\\d+}/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MediosClientesResource {
    
    @Inject
    private MedioDePagoLogic medioLogic;
    
    private List<ClienteDTO> clientesListEntityDTO(List<ClienteEntity> entityList){
        List<ClienteDTO> list = new ArrayList<>();
        for(ClienteEntity entity : entityList ){
            list.add(new ClienteDTO(entity));
        }
        return list;
    }
    
    private List<ClienteEntity> clientesListDTOEntity (List<ClienteDTO> dtos){
        List<ClienteEntity> list = new ArrayList<>();
        for(ClienteDTO dto : dtos ){
            list.add(dto.toEntity());
        }
        return list;
    }
    
    @GET 
    public List<ClienteDTO> getClientes(@PathParam("medioId") Long medioId){
        return clientesListEntityDTO(medioLogic.listClientes(medioId));
    }
    
    @GET
    @Path("{clienteId:\\d+}")
    public ClienteDTO getCliente(@PathParam("medioId") Long medioId, @PathParam("clienteId") Long clienteId){
        return new ClienteDTO(medioLogic.getCliente(medioId, clienteId));
    }
    
    @POST
    @Path("{clienteId:\\d+}")
    public ClienteDTO addCliente(@PathParam("medioId") Long medioId, @PathParam("clienteId") Long clienteId){
        return new ClienteDTO(medioLogic.addCliente(medioId, clienteId));
    }
    
    @PUT
    @Path("{clienteId:\\d+}")
    public List<ClienteDTO> replaceClientes(@PathParam("medioid") Long medioId, List<ClienteDTO> clientes){
        return clientesListEntityDTO(medioLogic.replaceCliente(medioId, clientesListDTOEntity(clientes)));
    }
    
    @DELETE
    @Path("{clienteId:\\d+}")
    public void removeCliente(@PathParam("medioId") Long medioId, @PathParam("clienteId") Long clienteId){
        medioLogic.removeCliente(medioId, clienteId);
    }

}
