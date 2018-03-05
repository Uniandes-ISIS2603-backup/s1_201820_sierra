/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.*;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.mappers.BusinessLogicExceptionMapper;
import java.util.*;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *<pre>Clase que implementa el recurso "cliente".
 * URL: /api/clientes
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "clientes".</i>
 * <p>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 * @author de.gutierrez
 */
@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ClienteResource 
{
    /**
     * <h1> POST /api/clientes : Crea un nuevo cliente</h1>
     * <p>
     * <pre> Cuerpo de peticion: JSON {@link ClienteDetailDTO}.
     * 
     * Crea un nuevo cliente con la informacion que se recibe en el cuerpo 
     * de la peticion y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo un nuevo cliente
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe un cliente.
     * </code>
     * </pre>
     * @param cliente {@link ClienteDetailDTO} - El cliente que se desea guardar
     * @return JSON {@link ClienteDetailDTO} - El cliente guardado con el atributo id generado
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de logica que se genera cuando ya existe un cliente.
     */
    @POST
    public ClienteDetailDTO createCliente(ClienteDetailDTO cliente) throws BusinessLogicException
    {
        return cliente;
    }
   
    /**
     * <h1>GET /api/clientes : Obtener todos los clientes.</h1>
     * <p>
     * <pre> Busca y devuelve todos los clientes.
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos clientes de la aplicacion.</code>
     * </pre>
     * 
     * @return JSONArray {@link ClienteDetailDTO} - los clientes encontrados en la aplicacion. Si no hay ninguno retorna vacio.
     */
    @GET
    public List<ClienteDetailDTO> getClientes ()
    {
        return new ArrayList<>();
    }
    
    /**
     * <h1>GET /api/clientes/{id} : Obtener un cliente por id.</h1>
     * 
     * <pre>Busca el cliente con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el cliente correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un cliente con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del cliente que se esta buscando. Este debe ser una cadena de digitos.
     * @return JSON {@link ClienteDetailDTO} - El cliente buscado.
     */
    @GET
    @Path("{id: \\d+}")
    public ClienteDetailDTO getCliente(@PathParam("id") Long id)
    {
        return null;
    }
    
    /**
     * <h1>  PUT /api/clientes/{id} : Actualizar una entidad de cliente con el id dado. </h1>
     * <pre> Cuerpo de peticion: JSON {@link ClienteDetailDTO}.
     * 
     * Actualiza la entidad de cliente con el id recibido en la URL con la informacion que se recibe en el cuerpo de la peticion.
     * 
     ** Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la entidad de Cliente con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de Cliente con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la entidad de cliente que se desea actualizar. Este debe ser una cadena de digitos.
     * @param infoCliente {@link ClienteDetailDTO} la entidad de cliente que se desea guardar.
     * @return JSON {@link ClienteDetailDTO} - La entidad de cliente guardada.
     * @throws BusinessLogicException {@link BusinessLogicException}  Error de logica que se genera al no poder actualizar la entidad de Cliente porque ya existe una con ese nombre.
     */
    @PUT 
    @Path( "{id: \\d+}")
    public ClienteDetailDTO updateCliente (@PathParam ("id") Long id, ClienteDetailDTO infoCliente) throws BusinessLogicException
    {
        return infoCliente;
    }
    
    /**
     * <h1> DELETE /api/clientes/{id} : Borra un cliente con el id. </h1>
     * <p>
     * <pre> Borra la entidad cliente con el id asociado recibido en la URL.
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la entidad de Cliente correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de Cliente con el id dado. </code>
     * </pre>
     * 
     * @param id Identificar de la entidad del cliente que se desea borrar. Este debe ser una cadena de digitos.
     */
    @DELETE
    @Path ( "{id: \\d+}" )
    public void deleteCliente (@PathParam ("id") Long id)
    {
        //voi
    }
}
