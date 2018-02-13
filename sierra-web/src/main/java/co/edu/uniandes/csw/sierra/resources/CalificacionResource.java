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
* <pre>Clase que implementa el recurso "Calificaciones". URL: /api/calificaciones
* </pre>
* <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api"
* y este recurso tiene la ruta "calificaciones".</i>
* <h2> Anotaciones </h2>
* <pre>
* Path: indica la dirección después de "api" para acceder al recurso
* Produces/Consumes: indica que los servicios definidos en este recurso reciben y
devuelven objetos en formato JSON
* RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
* </pre>
* @author Juan David Zambrano
* @version 1.0
*/
@Path( "calificaciones" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class CalificacionResource {
    
    /**
     * <h1> POST /api/calificaciones : Crea una calificacion. </h1>
     * <pre> Cuerpo de la peticion: JSON (@link CalificacionDetailDTO).
     * Crea una nueva calificacion con la informacion que entra por el cuerpo de la peticion.
     * Retorna un nuevo objeto identico con un id autogenerado por la base de datos
     * Codigos de respuesta:
     * <code style="color:mediumseagreen; backround-color: #eaffe0;">
     * 200 OK La calificacion fue creada
     * </code>
     * <code style=" color: #c7254e; backround-color: #f9f2f4;">
     * 412 Precondition Failed: Ya existe una calificacion asociada a esa Adquisicion
     * </code>
     * </pre>
     * @param dto (@link CalificacionDetailDTO) - La nueva calificacion
     * @return JSON (@link CalificacionDetailDTO) - La calificacion guardada con el atributo id
     * @throws BusinessLogicException Error de logica: ya existe una calificacion asociada a la adquisicion dada
     */
    @POST
    public CalificacionDetailDTO createCalificacion(CalificacionDetailDTO dto) throws BusinessLogicException{
        return dto;
    }
    
    /**
    * <h1> GET /api/calificaciones : Obtener todas las calificaciones.</h1>
    *
    * <pre> Busca y devuelve todas las calificaciones que existen en la
    * aplicación.
    *
    * Códigos de respuesta:
    * <code style="color: mediumseagreen; background-color: #eaffe0;">
    * 200 OK Devuelve todas las calificaciones de la aplicación
    * </code>
    * </pre>
    * @return JSONArray {@link CalificacionDetailDTO} - Las calificaciones
    * encontradas en la aplicación. Si no hay ninguna retorna una
    * lista vacía.
    */
    @GET
    public List<CalificacionDetailDTO> getCalificaciones(){
        return new ArrayList<>();
    }
    
    /**
     * <h1> GET /api/calificaciones/{id}: Obtener la calificacion por id.</h1>
     * <pre> Busca la calificacion con el id recibido en el URL y lo retorna
     * 
     * Codigos de respuesta:
     * <code style = "color: mediumseagreen; backround-color: #eaffe0;">
     * 200 OK Devuelve la calificacion asociada al id.
     * </code>
     * <code style = "color: #c7254e; backround-color: #f9f2f4;">
     * 404 Not Found: No existe la calificacion con el id dado
     * </code>
     * </pre>
     * @param id el identificador unico de la calificacion, debe ser una cadena de digitos
     * @return JSON (@link CalificacionDetailDTO) - La calificacion buscada
     */
    
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
