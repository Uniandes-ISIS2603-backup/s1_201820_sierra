/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.AdquisicionDetailDTO;
import co.edu.uniandes.csw.sierra.dtos.SierraDetailDTO;
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
 * <pre>Clase que implementa el recurso "Adquisicion".
 * URL: /api/adquisiciones
 * </pre>
 *
 * @author ISIS2603
 * @version 1.0
 */

@Path( "adquisiciones" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class AdquisicionResource {
    
    
    @POST
    public AdquisicionDetailDTO createAdquisicion(AdquisicionDetailDTO dto){
        return dto;
    }
    
    @GET
    public ArrayList<AdquisicionDetailDTO> getAdquisiciones(){
        return new ArrayList<>();
    }
    
    @GET
    @Path( "{id: \\d+}" )
    public AdquisicionDetailDTO getAdquisicion( @PathParam( "id" ) Long id )
    {
        return null;
    }
    
    @PUT
    @Path( "{id: \\d+}" )
    public AdquisicionDetailDTO updateAdquisicion( @PathParam( "id" ) Long id, AdquisicionDetailDTO dDTO ) throws BusinessLogicException
    {
	return dDTO;
    }
    
    @DELETE
    @Path( "{id: \\d+}" )
    public void deleteAdquisicion( @PathParam( "id" ) Long id )
    {
    	
    }
}
