/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.AdquisicionDetailDTO;
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
* <pre>Clase que implementa el recurso "Adquisiciones". URL: /api/adquisiciones
* </pre>
* <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api"
* y este recurso tiene la ruta "adquisiciones".</i>
* <h2> Anotaciones </h2>
* <pre>
* Path: indica la dirección después de "api" para acceder al recurso
* Produces/Consumes: indica que los servicios definidos en este recurso reciben y
* devuelven objetos en formato JSON
* RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
* </pre>
* @author Juan David Zambrano
* @version 1.0
*/

@Path( "adquisiciones" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class AdquisicionResource {
    
    /**
     * <h1> POST /api/adquisiciones : Crea una adquisicion. </h1>
     * <pre> Cuerpo de la peticion: JSON (@link AdquisicionDetailDTO).
     * Crea una nueva adquisicion con la informacion que entra por el cuerpo de la peticion.
     * Retorna un nuevo objeto identico con un id autogenerado por la base de datos
     * Codigos de respuesta:
     * <code style="color:mediumseagreen; backround-color: #eaffe0;">
     * 200 OK La adquisicion fue creada
     * </code>
     * <code style=" color: #c7254e; backround-color: #f9f2f4;">
     * 412 Precondition Failed: Ya existe una adquisicion igual
     * </code>
     * </pre>
     * @param dto (@link AdquisicionDetailDTO) - La nueva adquisicion
     * @return JSON (@link AdquisicionDetailDTO) - La adquisicion guardada con el atributo id
     * @throws BusinessLogicException Error de logica: ya existe una adquisicion igual.
     */
    @POST
    public AdquisicionDetailDTO createAdquisicion(AdquisicionDetailDTO dto) throws BusinessLogicException{
        return dto;
    }
    
    /**
    * <h1> GET /api/adquisiciones : Obtener todas las adquisiciones.</h1>
    *
    * <pre> Busca y devuelve todas las adquisiciones que existen en la
    * aplicación.
    *
    * Códigos de respuesta:
    * <code style="color: mediumseagreen; background-color: #eaffe0;">
    * 200 OK Devuelve todas las adquisiciones de la aplicación
    * </code>
    * </pre>
    * @return JSONArray {@link AdquisicionDetailDTO} - Las adquisiciones
    * encontradas en la aplicación. Si no hay ninguna retorna una
    * lista vacía.
    */
    @GET
    public List<AdquisicionDetailDTO> getAdquisiciones(){
        return new ArrayList<>();
    }
    
    
    /**
     * <h1> GET /api/adquisiciones/{id}: Obtener la adquisicion por id.</h1>
     * <pre> Busca la adquisicion con el id recibido en el URL y lo retorna
     * 
     * Codigos de respuesta:
     * <code style = "color: mediumseagreen; backround-color: #eaffe0;">
     * 200 OK Devuelve la adquisicion asociada al id.
     * </code>
     * <code style = "color: #c7254e; backround-color: #f9f2f4;">
     * 404 Not Found: No existe la adquisicion con el id dado
     * </code>
     * </pre>
     * @param id el identificador unico de la adquisicion, debe ser una cadena de digitos
     * @return JSON (@link AdquisicionDetailDTO) - La adquisicion buscada
     */
    @GET
    @Path( "{id: \\d+}" )
    public AdquisicionDetailDTO getAdquisicion( @PathParam( "id" ) Long id )
    {
        return null;
    }
    
    /**
     * <h1> PUT /api/adquisiciones/id{id} : Actualiza una adquisicion con el id dado
     * <pre> Cuerpo de peticion: JSON {@link AdquisicionDetailDTO}.
     * 
     * Actualiza la entidad de Adquisicion con el id dado con la informacion 
     * recibida en el cuerpo de la peticion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; backround-color: #eaffe0;">
     * 200 OK Actualiza la entidad exitosamente y retorna un objeto identico
     * </code>
     * <code style="color: #c7254e; backround-color: #f3f2f4;">
     * 404 Not Found no existe una adquisicion con el id dado
     * </code>
     * </pre>
     * @param id el id de la entidad que se quiere actualizar
     * @param dDTO {@link AdquisicionDetailDTO} La entidad de Adquisicion que
     * desea guardar.
     * @return JSON {@link AdquisicionDetailDTO} La entidad Adquisicion actualizada
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de 
     * logica del negocio.
     */
    @PUT
    @Path( "{id: \\d+}" )
    public AdquisicionDetailDTO updateAdquisicion( @PathParam( "id" ) Long id, AdquisicionDetailDTO dDTO ) throws BusinessLogicException
    {
	return dDTO;
    }
    
    /**
     * <h1> DELETE /api/adquisiciones/id{id} : Eliminaa una adquisicion con el id dado
     * <pre> 
     * 
     * Borra la entidad de Adquisicion con el id dado.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; backround-color: #eaffe0;">
     * 200 OK Elimina la entidad exitosamente. 
     * </code>
     * <code style="color: #c7254e; backround-color: #f3f2f4;">
     * 404 Not Found no existe una adquisicion con el id dado
     * </code>
     * </pre>
     * @param id el id de la entidad que se quiere borrar.
     */
    @DELETE
    @Path( "{id: \\d+}" )
    public void deleteAdquisicion( @PathParam( "id" ) Long id )
    {
    	
    }
}
