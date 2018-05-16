/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.sierra.resources;
import co.edu.uniandes.csw.sierra.dtos.MascotaAdopcionDTO;
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
 * <pre>Clase que implementa el recurso "mascotasAdoptadas/{id}/acontecimientos".
 * URL: /api/mascotasAdoptadas/{mascotaAdoptadaId}/acontecimientos
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "mascotasAdoptadas/{mascotaAdoptadaId}/acontecimientos".</i>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 * @version 1.0
 * @author ja.penat
 */
@Path("mascotasAdoptadas/{mascotaAdoptadaId: \\d+}/acontecimientos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MascotaAdoptadaAcontecimientoResource
{
    @Inject
    private MascotaAdoptadaLogic mascotaLogica ;
    
    /**
     * <h1>POST /api/mascotasAdoptadas/{mascotadaAdoptadaId}/acontecimiento/{acontecimientoId} : Guarda un acontecimiento
     * dentro de la mascotaAdoptada.</h1>
     *
     * <pre> Guarda un acontecimiento dentro de una mascota con la informacion que
     * recibe el la URL. Se devuelve el acontecimiento que se guarda en la mascota.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Guardó el nuevo acontecimiento .
     * </code>
     * </pre>
     * @param mascotaAdoptadaId Identificador de la mascota que se esta buscando. Este debe ser una cadena de dígitos.
     * @param acontecimientoId Identificador del acontecimiento  que se desea guardar. Este debe ser una cadena de dígitos.
     * @return JSON {@link MascotaAdopcionDTO} - La mascota donde se guardara la factura
     */
    @POST
    @Path("{acontecimientoId: \\d+}")
    public MascotaAdopcionDTO crearMascotaAdoptadaAcontecimiento(@PathParam("mascotaAdoptadaId") Long mascotaAdoptadaId, @PathParam("acontecimientoId") Long acontecimientoId)
    {
        System.out.println("MascotaAdoptadaResoure: \n mascotaAdoptadaId: " + mascotaAdoptadaId + "\n acontecimientoId: " + acontecimientoId);
        try
        {
            return new MascotaAdopcionDTO(mascotaLogica.addAcontecimiento(mascotaAdoptadaId, acontecimientoId));
        }
        catch(BusinessLogicException e){
            throw new WebApplicationException("404: " + e.getMessage());
        }
        
    }
    
}
