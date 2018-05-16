/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.AdquisicionDetailDTO;
import co.edu.uniandes.csw.sierra.dtos.CalificacionDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.ClienteLogic;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;


/**
 * <pre>Clase que implementa el recurso "adquisiciones/{id}/calificaciones".
 * URL: /api/clientes/{clienteId}/adquisiciones
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "/api/clientes/{clienteId}/adquisiciones".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author jd.zambrano
 * @version 1.0
 */
@Path("clientes/{clienteId: \\d+}/adquisiciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteAdquisicionResource {
    
    @Inject
    private ClienteLogic cLogic;
    
    /**
     * <h1>POST /api/clientes/{clienteId}/adquisiciones/{adquisicionId} : Guarda una adquisicion 
     * dentro de la cliente.</h1>
     *
     * <pre> Guarda una adquisicion dentro de un cliente con la informacion que 
     * recibe el la URL. Se devuelve la adquisicion que se guarda en el cliente.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Guardó la adquisicion nueva.
     * </code>
     * </pre>
     * @param clId Identificador de la cliente que se esta buscando. Este debe ser una cadena de dígitos.
     * @param adqId Identificador de la adquisicion que se desea guardar. Este debe ser una cadena de dígitos.
     * @return JSON {@link CalificacionDetailDTO} - La adquisicion guardada en la cliente
     */
    /*
    @POST
    @Path("{adquisicionId: \\d+}")
    public AdquisicionDetailDTO addAdquisicion(@PathParam("clienteId") Long clId, @PathParam("adquisicionId") Long adqId){
        System.out.println("ClienteADquisicionResource: \n clId: " + clId + "\n adqId: " + adqId);
        try
        {
            //return new AdquisicionDetailDTO(cLogic.addAdquisicion(clId, adqId));
            return null;
        }
        catch(BusinessLogicException e)
        {
            throw new WebApplicationException("404: " + e.getMessage());
        }
    }
    */
}
