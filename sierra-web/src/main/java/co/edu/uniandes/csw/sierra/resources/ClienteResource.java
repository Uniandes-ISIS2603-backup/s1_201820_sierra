/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.*;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import java.util.*;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.Produces;

/**
 *
 * @author de.gutierrez
 */
@Path("clientes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ClienteResource 
{
    /**
     * <h1> POST /api/clientes: Crea un nuevo cliente</h1>
     * <p>
     * <pre> Cuerpo de peticion: JSON {@link ClienteDetailDTO}.
     * 
     * Crea un nuevo cliente con la informacion que se recibe...
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
     * @return JSON {@link ClienteDetailDTO} - El cliente guardado con el atributo id gererado
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de logica que se genera cuando ya existe un cliente.
     */
    @POST
    public ClienteDTO createCliente(ClienteDTO cliente) throws BusinessLogicException
    {
        return cliente;
    }
   
    /**
     * <h1>GET /api/clientes : Obtener todos los clientes.</h1>
     * <pre> Busca y devuelve todos los clientes.
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos clientes de la aplicacion.</code>
     * </pre>
     * 
     * @return JSONArray {@link CLienteDetailDTO} - los clientes encontrados en la aplicacion. Si no hay ninguno retorna vacio.
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
    @Path("{id: \\d+")
    public ClienteDetailDTO getCliente(@PathParam("id") Long id)
    {
        return null;
    }
}
