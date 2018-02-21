/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.MascotaAdoptadaDetailDTO;
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
 * <pre>Clase que implementa el recurso "mascotaAdoptad".
 * URL: /api/sierras
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "mascotas".</i>
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
@Path( "mascotasAdoptadas" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class MascotaAdoptadaResource {
    @POST
public MascotaAdoptadaDetailDTO createMascota(MascotaAdoptadaDetailDTO Dto)
{
  return Dto;
}
@GET
public List<MascotaAdoptadaDetailDTO> getMascotas()
{
return new ArrayList();
}


@GET                    
@Path("{id: \\d+}")
public MascotaAdoptadaDetailDTO getMascota(@PathParam("id") long id)
{
return null;
}


@PUT
@Path("{id: \\d+}")
public void updateMascota(@PathParam("id") long id, MascotaAdoptadaDetailDTO acDto) 
{

}
@DELETE
@Path("{id:\\d+}")
public void deleteMascota(@PathParam("id") long id)
{
}
}
