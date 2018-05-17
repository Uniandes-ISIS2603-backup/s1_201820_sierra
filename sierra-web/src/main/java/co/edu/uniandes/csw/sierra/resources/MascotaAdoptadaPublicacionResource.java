/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;
import co.edu.uniandes.csw.sierra.dtos.MascotaAdopcionDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.MascotaAdoptadaLogic;
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
 * <pre>Clase que implementa el recurso "mascotasAdoptadas/{id}/publicaciones".
 * URL: /api/mascotasAdoptadas/{mascotaAdoptadaId}/publicaciones
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "mascotasAdoptadas/{mascotaAdoptadaId}/publicacoines".</i>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 * @version 1.0
 * @author ja.penat
 */
@Path("mascotasAdoptadas/{mascotaAdoptadaId: \\d+}/publicaciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MascotaAdoptadaPublicacionResource 
{
    @Inject
    private MascotaAdoptadaLogic mascotaLogica ;
    
    /**
     * <h1>POST /api/mascotasAdoptadas/{mascotadaAdoptadaId}/publicacion/{publicacionId} : Guarda una publicacion
     * dentro de la mascotaAdoptada.</h1>
     *
     * <pre> Guarda una publicacion dentro de una mascota con la informacion que
     * recibe el la URL. Se devuelve la mascota que guarda la publicacion
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Guardó la nueva publicacion.
     * </code>
     * </pre>
     * @param mascotaAdoptadaId Identificador de la mascota que se esta buscando. Este debe ser una cadena de dígitos.
     * @param publicacionId Identificador de la publicacion  que se desea guardar. Este debe ser una cadena de dígitos.
     * @return JSON {@link MascotaAdopcionDTO} - La mascota donde se guardara la publicacion.
     */
    @POST
    @Path("{publicacionId: \\d+}")
    public MascotaAdopcionDetailDTO crearMascotaAdoptadaPublicacion(@PathParam("mascotaAdoptadaId") Long mascotaAdoptadaId, @PathParam("publicacionId") Long publicacionId)
    {
        System.out.println("MascotaAdoptadaResoure: \n mascotaAdoptadaId: " + mascotaAdoptadaId + "\n acontecimientoId: " + publicacionId);
        try
        {
            return new MascotaAdopcionDetailDTO(mascotaLogica.addPublicacion(mascotaAdoptadaId, publicacionId));
        }
        catch(BusinessLogicException e)
        {
            throw new WebApplicationException("404: " + e.getMessage());
        }
        
    }
    
}
