/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.*;
import co.edu.uniandes.csw.sierra.ejb.ClienteLogic;
import co.edu.uniandes.csw.sierra.entities.*;
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
import java.util.ArrayList;

/**
 *
 * @author de.gutierrez
 */
@Path("clientes/{clienteId: \\d+}/mediosDePago")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteMediosResource {
    
    @Inject 
    private ClienteLogic clienteLogic;
    
    private List<MedioDePagoDTO> mediosListEntityDTO(List<MedioDePagoEntity> entityList){
        List<MedioDePagoDTO> list = new ArrayList<>();
        for(MedioDePagoEntity entity : entityList){
            list.add(new MedioDePagoDTO(entity));
        }
        return list;
    }
    
    private List<MedioDePagoEntity> mediosListDTOEntity(List<MedioDePagoDTO> dtos){
        List<MedioDePagoEntity> list = new ArrayList<>();
        for (MedioDePagoDTO dto : dtos ){
            list.add(dto.toEntity());
        }
        return list;
    } 
    
    @GET
    public List<MedioDePagoDTO> listMedios(@PathParam("clienteId") Long clienteId){
        return mediosListEntityDTO(clienteLogic.listMedios(clienteId));
    }
    
    @GET
    @Path("{medioId: \\d+}")
    public MedioDePagoDTO getMedio(@PathParam("clienteId") Long clienteId, @PathParam("medioId")Long medioId){
        return new MedioDePagoDTO(clienteLogic.getMedio(clienteId, medioId));
    }
    
   @POST
   @Path("{medioId:\\d+}")
   public MedioDePagoDTO addMedio(@PathParam("clienteId") Long clienteId, @PathParam("medioId") Long medioId){
       return new MedioDePagoDTO(clienteLogic.addMedio(clienteId, medioId));
   }
   
   @PUT
   public List<MedioDePagoDTO> replaceMedios(@PathParam("clienteId") Long clienteId, List<MedioDePagoDTO> medios){
       return mediosListEntityDTO(clienteLogic.replaceMedio(clienteId, mediosListDTOEntity(medios)));
   }
   
   @DELETE
   @Path("{medioId:\\d+}")
   public void removeMedio(@PathParam("clienteId") Long clienteId, @PathParam("medioId") Long medioId){
       clienteLogic.removeMedio(clienteId, medioId);
   }
}
