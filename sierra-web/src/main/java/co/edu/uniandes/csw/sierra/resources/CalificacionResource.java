/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.CalificacionDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.CalificacionLogic;
import co.edu.uniandes.csw.sierra.entities.CalificacionEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.mappers.BusinessLogicExceptionMapper;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

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
     * la conexion con logic
     */
    @Inject
    private CalificacionLogic calificacionLogic;
    
    /**
     * Metodo que convierte una lista de entidades a una lista de DetailDTO
     * @param lista la lista de entidades
     * @return la lista de DetailDTO
     */
    public List<CalificacionDetailDTO> listEntityToDTO(List<CalificacionEntity> lista){
        List<CalificacionDetailDTO> r = new ArrayList<>();
        for(CalificacionEntity ent: lista){
            r.add(new CalificacionDetailDTO(ent));
        }
        return r;
    }
    
    
    
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
     * 412 Precondition Failed: Ya existe una calificacion asociada a esa Calificacion
     * </code>
     * </pre>
     * @param dto (@link CalificacionDetailDTO) - La nueva calificacion
     * @return JSON (@link CalificacionDetailDTO) - La calificacion guardada con el atributo id
     * @throws BusinessLogicException Error de logica: ya existe una calificacion asociada a la calificacion dada
     */
    @POST
    public CalificacionDetailDTO createCalificacion(CalificacionDetailDTO dto) throws BusinessLogicException{
        return new CalificacionDetailDTO(calificacionLogic.create(dto.toEntity()));
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
        return listEntityToDTO(calificacionLogic.getAll());
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
        CalificacionEntity ent = calificacionLogic.getById(id);
        if(ent == null){
            throw new WebApplicationException("La calificacion con el id: " + id + " no existe", 404);
        }
        return new CalificacionDetailDTO(ent);
    }
    
    /**
     * <h1> PUT /api/calificaciones/id{id} : Actualiza una calificacion con el id dado</h1>
     * <pre> Cuerpo de peticion: JSON {@link CalificacionDetailDTO}.
     * 
     * Actualiza la entidad de Calificacion con el id dado con la informacion 
     * recibida en el cuerpo de la peticion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; backround-color: #eaffe0;">
     * 200 OK Actualiza la entidad exitosamente y retorna un objeto identico
     * </code>
     * <code style="color: #c7254e; backround-color: #f3f2f4;">
     * 404 Not Found no existe una calificacion con el id dado
     * </code>
     * </pre>
     * @param id el id de la entidad que se quiere actualizar
     * @param dDTO {@link CalificacionDetailDTO} La entidad de Calificacion que
     * desea guardar.
     * @return JSON {@link CalificacionDetailDTO} La entidad Calificacion actualizada
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de 
     * logica del negocio.
     */
    @PUT
    @Path( "{id: \\d+}" )
    public CalificacionDetailDTO updateCalificacion( @PathParam( "id" ) Long id, CalificacionDetailDTO dDTO ) throws BusinessLogicException
    {
        CalificacionEntity ent = dDTO.toEntity();
        ent.setId(id);
        //revisa si existe la entidad
        CalificacionEntity oldEnt = calificacionLogic.getById(id);
        if(oldEnt == null)
           throw new WebApplicationException("La calificacion con el id: " + id + " no existe", 404);
        
        ent.setAdquisicion(oldEnt.getAdquisicion());
        return new CalificacionDetailDTO(calificacionLogic.update(ent));
    }
    
    /**
     * <h1> DELETE /api/calificaciones/id{id} : Eliminaa una calificacion con el id dado
     * <pre> 
     * 
     * Borra la entidad de Calificacion con el id dado.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; backround-color: #eaffe0;">
     * 200 OK Elimina la entidad exitosamente.
     * </code>
     * <code style="color: #c7254e; backround-color: #f3f2f4;">
     * 404 Not Found no existe una calificacion con el id dado
     * </code>
     * </pre>
     * @param id el id de la entidad que se quiere borrar.
     */
    @DELETE
    @Path( "{id: \\d+}" )
    public void deleteCalificacion( @PathParam( "id" ) Long id )
    {
    	CalificacionEntity ent = calificacionLogic.getById(id);
        if(ent == null)
            throw new WebApplicationException("La calificacion con el id: " + id + " no existe", 404);
        calificacionLogic.delete(ent);
    }
    
}
