/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.CalificacionDetailDTO;
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
 *
 * @author Juan David Zambrano
 */
@Path( "calificaciones" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class CalificacionResource {
    
    
    @POST
    public CalificacionDetailDTO createCalificacion(CalificacionDetailDTO dto){
        return dto;
    }
    
    @GET
    public List<CalificacionDetailDTO> getCalificaciones(){
        return new ArrayList<>();
    }
    
    @GET
    @Path( "{id: \\d+}" )
    public CalificacionDetailDTO getCalificacion( @PathParam( "id" ) Long id )
    {
        return null;
    }
    
    @PUT
    @Path( "{id: \\d+}" )
    public CalificacionDetailDTO updateCalificacion( @PathParam( "id" ) Long id, CalificacionDetailDTO dDTO ) throws BusinessLogicException
    {
	return dDTO;
    }
    
    @DELETE
    @Path( "{id: \\d+}" )
    public void deleteCalificacion( @PathParam( "id" ) Long id )
    {
    	
    }
}
