/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.sierra.resources;
import co.edu.uniandes.csw.sierra.dtos.MascotaVentaDTO;
import co.edu.uniandes.csw.sierra.dtos.MascotaVentaDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.MascotaVentaLogic;
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
 *  <pre>Clase que implementa el recurso "mascotasVenta/{id}/certificados".
 * URL: /api/mascotasVenta/{mascotaVentaId}/certificados
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "mascotasVenta/{mascotaVentaId}/certificados".</i>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 * @author ja.penat
 */

@Path("mascotasVenta/{mascotaVentaId: \\d+}/certificados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MascotaVentaCertificadoResource
{
    @Inject
    private MascotaVentaLogic mascotaLogica ;
    
    /**
     * <h1>POST /api/mascotasVenta/{mascotaVentaId}/certificados/{certificadoId} : Guarda un certificado
     * dentro de la mascotaVenta.</h1>
     *
     * <pre> Guarda un certificado dentro de una mascota con la informacion que
     * recibe el la URL. Se devuelve el certificado que se guarda en la mascota.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Guardó el nuevo certificado .
     * </code>
     * </pre>
     * @param mascotaVentaId Identificador de la mascota que se esta buscando. Este debe ser una cadena de dígitos.
     * @param certificadoId Identificador del certificado que se desea guardar. Este debe ser una cadena de dígitos.
     * @return JSON {@link MascotaVentaDetailDTO} - La mascota donde se guardara el certificado
     */
    @POST
    @Path("{certificadoId: \\d+}")
    public MascotaVentaDetailDTO crearMascotaVentaCertificado(@PathParam("mascotaVentaId") Long mascotaVentaId, @PathParam("certificadoId") Long certificadoId)
    {
        System.out.println("MascotaVentaResoure: \n mascotaVentaId: " + mascotaVentaId + "\n certificadoId: " + certificadoId);
        try
        {
            return new MascotaVentaDetailDTO(mascotaLogica.addCertificado(mascotaVentaId, certificadoId));
        }
        catch(BusinessLogicException e)
        {
            throw new WebApplicationException("404: " + e.getMessage());
        }
        
    }
}
