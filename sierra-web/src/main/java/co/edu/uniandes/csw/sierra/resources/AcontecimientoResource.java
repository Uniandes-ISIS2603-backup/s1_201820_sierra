
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;
import co.edu.uniandes.csw.sierra.dtos.*;
import java.util.*;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.Produces;

/**
*<pre> Clase encargada de implementar el recurso "Acontecimiento".</pre>
 *URL: /api/acontecimientos 
 * @author Ja.penat
 *@version 1.0
 */
@Path("acontecimientos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AcontecimientoResource 
{
@POST
public AcontecimientoDTO createAcontecimiento(AcontecimientoDTO acDto)
{
  return acDto;
}
@GET
public List<AcontecimientoDTO> getAcontecimientos()
{
return new ArrayList();
}
@GET                    
@Path("{id: \\d+}")
public AcontecimientoDTO getAcontecimiento(@PathParam("id") long id)
{
return null;
}
@PUT
@Path("{id: \\d+}")
public void updateAcontecimiento(@PathParam("id") long id, AcontecimientoDTO acDto) 
{

}
@DELETE
@Path("{id:\\d+}")
public void deleteAcontecimiento(@PathParam("id") long id)
{
}
}
