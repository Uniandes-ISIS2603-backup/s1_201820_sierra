/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.CalificacionDetailDTO;
import co.edu.uniandes.csw.sierra.dtos.EspecieDTO;
import co.edu.uniandes.csw.sierra.dtos.EspecieDetailDTO;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * <pre>Clase que implementa el recurso "especie".
 * URL: /api/sierras
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "especies".</i>
 * <p>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author jc.sanchez12
 * @version 1.0
 */

@Path( "especies" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class EspecieResource {
   
    @POST
    public EspecieDetailDTO createEspecie(EspecieDetailDTO dto){
        return dto;
    }
    
    @GET
    public List<EspecieDetailDTO> getEspecies(){
        return new ArrayList<>();
    }
    
    @GET
    @Path( "{id: \\d+}" )
    public EspecieDetailDTO getEspecie( @PathParam( "id" ) Long id )
    {
        return null;
    }
    
    @PUT
    @Path( "{id: \\d+}" )
    public EspecieDetailDTO updateEspecie( @PathParam( "id" ) Long id, EspecieDetailDTO dDTO ) throws BusinessLogicException
    {
	return dDTO;
    }
    
    @DELETE
    @Path( "{id: \\d+}" )
    public void deleteEspecie( @PathParam( "id" ) Long id )
    {
    	
    }
}
