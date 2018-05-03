
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.*;
import co.edu.uniandes.csw.sierra.ejb.AcontecimientoLogic;
import co.edu.uniandes.csw.sierra.entities.AcontecimientoEntity;
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

    @POST
    public AcontecimientoDTO createAcontecimiento(AcontecimientoDTO acDto) {
        return acDto;
    }
    @PUT
    @Path("{id: \\d+}")
    public void updateAcontecimiento(@PathParam("id") long id, AcontecimientoDTO acDto) {

    }

    @DELETE
    @Path("{id:\\d+}")
    public void deleteAcontecimiento(@PathParam("id") long id) {
    }
}
