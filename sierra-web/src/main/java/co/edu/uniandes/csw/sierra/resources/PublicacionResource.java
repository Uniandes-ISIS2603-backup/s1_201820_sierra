
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.PublicacionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Produces;

/**
*<pre> Clase encargada de implementar el recurso "Publicación".</pre>
 *URL: /api/publicaciones 
 *@author Ja.penat
 *@version 1.0
 */
@Path("publicaciones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PublicacionResource
 {

@POST
public PublicacionDTO createPublicacion(PublicacionDTO puDto)
{
  return puDto;
}
@GET
public List<PublicacionDTO> getPublicaciones()
{
return new ArrayList();
}
@GET                    
@Path("{id: \\d+}")
public PublicacionDTO getPublicacion(@PathParam("id") long id)
{
return null;
}
@PUT
@Path("{id: \\d+}")
public void updatePublicacion(@PathParam("id") long id, PublicacionDTO puDto) 
{

}
@DELETE
@Path("{id:\\d+}")
public void deletePublicacion(@PathParam("id") long id)
{
}
}
