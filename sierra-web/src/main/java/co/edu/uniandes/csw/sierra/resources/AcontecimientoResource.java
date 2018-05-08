
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.*;
import co.edu.uniandes.csw.sierra.ejb.AcontecimientoLogic;
import co.edu.uniandes.csw.sierra.entities.AcontecimientoEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import java.util.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Produces;

/**
 * <pre> Clase encargada de implementar el recurso "Acontecimiento".</pre>
 * URL:/api/acontecimientos
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "acontecimientos".</i>
 * <p>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 * @author Ja.penat
 * @version 1.0
 */
//TODO: Revisar el path para llegar a este recurso
@Path("acontecimientos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AcontecimientoResource
{ 
    /**
     * Se injecta la clase logica del recurso
     */
    @Inject
    private AcontecimientoLogic acontecimientoLogica;
    
     /**
     * Metodo que convierte una lista de entidades a una lista de DTO
     * @param lista la lista de entidades
     * @return la lista de DTO
     */
    public List<AcontecimientoDTO> listEntityToDTO(List<AcontecimientoEntity> lista)
    {
        List<AcontecimientoDTO> nuevo = new ArrayList<>();
        for(AcontecimientoEntity ent: lista)
        {
            nuevo.add(new AcontecimientoDTO(ent));
        }
        return nuevo;
    }
    
     /**
     * Metodo que convierte una lista de entidades a una lista de DetailDTO
     * @param lista la lista de entidades
     * @return la lista de DetailDTO
     */
    public List<AcontecimientoDetailDTO> listEntityToDetailDTO(List<AcontecimientoEntity> lista)
    {
        List<AcontecimientoDetailDTO> nuevo = new ArrayList<>();
        for(AcontecimientoEntity ent: lista)
        {
            nuevo.add(new AcontecimientoDetailDTO(ent));
        }
        return nuevo;
    }
    
    
    /**
     * <h1>GET /api/acontecimientos : Obtener todos los acontecimientos.</h1>
     * <pre>Busca y devuelve todos los acontecimientos  que existen en la aplicacion.
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los acontecimientos +de la aplicacion.</code>
     * </pre>
     * @return JSONArray {@link AcontecimientosnDetailDTO} - Los acontecimientos
     *  encontrados en la aplicación. Si no hay ninguno retorna una
     * lista vacía.
     */
    @GET
    public List<AcontecimientoDTO> getAcontecimientos() 
    {
        return listEntityToDTO(acontecimientoLogica.getAll());
    }
     /**
     *(Path no ligado a mascotas)
     * <h1>GET /api/acontecimientos/{id} : Obtener el acontecimiento por id.</h1>
     * <pre>Busca el acontecimiento con el id asociado recibido en la URL y la devuelve.
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el acontecimiento correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un acontecimiento  con el id dado.
     * </code>
     * </pre>
     * @param idCliente(No)
     * @param id Identificador del acontecimiento que se esta buscando. Este debe ser una cadena de digitos.
     * @return JSON {@link AcontecimientoDetailDTO} - El acontecimiento buscado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}. 
     */
    @GET
    @Path("{id: \\d+}")
    public AcontecimientoDTO getAcontecimiento(@PathParam("id") long id) throws  WebApplicationException
    {
         AcontecimientoEntity entity = acontecimientoLogica.getById(id);
        if (entity == null) 
        {
            throw new WebApplicationException("El recurso acontecimiento con el id " + id + " no existe.", 404);
        }
        return new AcontecimientoDTO(entity);
    }
/**
     * <h1>POST /api/acontecimientos : Crear un acontecimiento.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link AcontecimientoDTO}.
     *
     * Crea una nuevo acontecimiento con la informacion que se recibe en el cuerpo
     * de la petición y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo el acontecimiento  .
     * </code>
     * </pre>
     * @param acDto {@link AcontecimientoDTO} -El acontecimiento que se
     * desea guardar.
     * @return JSON {@link AcontecimientoDetailDTO} -El acontecimiento se a
     * guardado con el atributo id autogenerado.
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    @POST
    public AcontecimientoDTO createAcontecimiento(AcontecimientoDTO acDto)throws BusinessLogicException
    {
        return new AcontecimientoDTO(acontecimientoLogica.create(acDto.toEntity())); 
    }
     /**
     * <h1>PUT /api/acontecimientos/{id} : Actualizar el acontecimiento con el
     * id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link AcontecimientoDetailDTO}.
     *
     * Actualiza el acontecimiento  con el id recibido en la URL con la información que se recibe en el cuerpo de la petición.
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el acontecimiento  con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe el acontecimiento con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del acontecimiento que se desea actualizar. Este debe ser una cadena de digitos.
     * Este debe ser una cadena de dígitos.
     * @param acDto {@link AcontecimientoDetailDTO} El acontecimiento que se
     * desea guardar.
     * @return JSON {@link AcontecimientoDetailDTO} - El acontecimiento
     * guardado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de
     * lógica
     */
    @PUT
    @Path("{id: \\d+}")
    public AcontecimientoDTO updateAcontecimiento(@PathParam("id") long id, AcontecimientoDTO acDto) throws WebApplicationException, BusinessLogicException
    {
         acDto.setId(id);
         AcontecimientoEntity actualizada = acontecimientoLogica.getById(id);
         if(actualizada == null)
         {
             throw new WebApplicationException("El recurso /acontecimiento/" + id + " no existe.", 404);
         }
         else 
         {
             return new AcontecimientoDTO(acontecimientoLogica.update(acDto.toEntity()));
         }
    }

      /**
     * <h1> DELETE /api/acontecimientos{id} : Borra un acontecimiento.</h1>
     * <p>
     * <
     * pre> Borra la entidad medioDePago con el id asociado recibido en la URL.
     * codigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la entidad de acontecimiento correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de acontecimiento con el id dado. </code>
     * </pre>
     * @param idMascota(No)
     * @param id Identificador de la entidad de acontecimiento que se desea borrar.
     * Este debe ser una cadena de digitos.
     */
    @DELETE
    @Path("{id:\\d+}")
    public void deleteAcontecimiento(@PathParam("id") long id) throws WebApplicationException
    { 
       AcontecimientoEntity eliminado = acontecimientoLogica.getById(id);
        if (eliminado == null) 
        {
            throw new WebApplicationException("El recurso /acontecimiento/" + id + " no existe.", 404);
        }
        acontecimientoLogica.delete(id);
    }
}
