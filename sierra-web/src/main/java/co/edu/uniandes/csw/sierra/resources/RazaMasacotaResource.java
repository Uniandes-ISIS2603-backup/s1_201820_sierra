/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.



THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.RazaDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.RazaLogic;
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
 * <pre>Clase que implementa el recurso "razas/{id}/mascotas".
 * URL: /api/razas/{razaId}/mascotas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "razas/{razaId}/mascotas".</i>
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
@Path("razas/{razaId: \\d+}/mascotas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RazaMasacotaResource {
    
    
    @Inject
    private RazaLogic razaLogic;
    
    /**
     * <h1>POST /api/razas/{razaId}/mascotas/{mascotaId} : Guarda una mascota 
     * dentro de la raza.</h1>
     *
     * <pre> Guarda una mascota dentro de una raza con la informacion que 
     * recibe el la URL. Se devuelve la mascota que se guarda en la raza.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Guardó la mascota nueva.
     * </code>
     * </pre>
     * @param razaId Identificador de la raza que se esta buscando. Este debe ser una cadena de dígitos.
     * @param mascotaId Identificador de la mascota que se desea guardar. Este debe ser una cadena de dígitos.
     * @return JSON {@link RazaDetailDTO} - La raza donde se guardada la mascota
     */
    @POST
    @Path("{mascotaId: \\d+}")
    public RazaDetailDTO linkRazaMascota(@PathParam("razaId") Long razaId, @PathParam("mascotaId") Long mascotaId)
    {
        System.out.println("RazaMascotaResoure: \n razaId: " + razaId + "\nmascotaId: " + mascotaId);
        
        try
        {
            return new RazaDetailDTO(razaLogic.addMascota(razaId, mascotaId));
        }
        catch(BusinessLogicException e){
            throw new WebApplicationException("404: " + e.getMessage());
        }
        
    }
    
}
