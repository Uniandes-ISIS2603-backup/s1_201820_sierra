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
    
    /**
     * Injeccion de la clase de logica del cliente.
     */
    @Inject 
    private ClienteLogic clienteLogic;
    
    /**
     * Convierte una lista de entitys en una coleccion de DTOs
     * @param entityList Colleccion de entitys
     * @return coleccion de DOTs de los medios de pago.
     */
    private List<MedioDePagoDTO> mediosListEntityDTO(List<MedioDePagoEntity> entityList){
        List<MedioDePagoDTO> list = new ArrayList<>();
        for(MedioDePagoEntity entity : entityList){
            list.add(new MedioDePagoDTO(entity));
        }
        return list;
    }
    
    /**
     * Convierte una list de DTOs en una coleccion de Entitys
     * @param dtos Lista de DOTs 
     * @return Coleccion de entitys de medios de pago
     */
    private List<MedioDePagoEntity> mediosListDTOEntity(List<MedioDePagoDTO> dtos){
        List<MedioDePagoEntity> list = new ArrayList<>();
        for (MedioDePagoDTO dto : dtos ){
            list.add(dto.toEntity());
        }
        return list;
    } 
    
    /**
     * Obtiene una lista con todos los medios de pago de un cliente.
     * @param clienteId Identificador del cliente.
     * @return lista de medios de pago asociados a un cliente.
     */
    @GET
    public List<MedioDePagoDTO> listMedios(@PathParam("clienteId") Long clienteId){
        return mediosListEntityDTO(clienteLogic.listMedios(clienteId));
    }
    
    /**
     * Obtiene un medio de pago especifico asociado a un cliente.
     * @param clienteId Identificador del cliente.
     * @param medioId Identificador del medio de pago a buscar.
     * @return El medio de  pago asociado al cliente.
     */
    @GET
    @Path("{medioId: \\d+}")
    public MedioDePagoDTO getMedio(@PathParam("clienteId") Long clienteId, @PathParam("medioId")Long medioId){
        return new MedioDePagoDTO(clienteLogic.getMedio(clienteId, medioId));
    }
   
    /**
     * Asocia un medio de pago a un cliente especifico.
     * @param clienteId
     * @param medioId
     * @return 
     */
   @POST
   @Path("{medioId:\\d+}")
   public MedioDePagoDTO addMedio(@PathParam("clienteId") Long clienteId, @PathParam("medioId") Long medioId){
       return new MedioDePagoDTO(clienteLogic.addMedio(clienteId, medioId));
   }
   
    /**
     * Elimina un medio de pago asociado a un cliente.
     * @param clienteId Identificador del cliente.
     * @param medioId Identificador del medio de pago.
     */
   @DELETE
   @Path("{medioId:\\d+}")
   public void removeMedio(@PathParam("clienteId") Long clienteId, @PathParam("medioId") Long medioId){
       clienteLogic.removeMedio(clienteId, medioId);
   }
}
