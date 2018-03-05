/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.MedioDePagoDetail;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import java.util.*;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;

/**
 *<pre>Clase que implementa el recurso "medioDePago".
 * URL: /api/mediosDePago
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "mediosDePago".</i>
 * <p>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 * @author de.gutierrez
 */
@Path("/mediosDePago")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MedioDePagoResource 
{
    /**
     * <h1> POST /api/mediosDePago : Crea un nuevo medio de pago.</h1>
     * <p>
     * <pre> Cuerpo de la peticion: JSON {@link MedioDePagoDetail}.
     * 
     * Crea un nuevo medio de pago con la informacion que se recibe en el cuerpo 
     * de la peticion y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 PK Creo un nuevo medio de pago.
     * </code>
     * <code style="color: #c7254; background-color: #f9f2f4;">
     * 412 Precondition Failed: ya existe ese medio de pago:
     * </code>
     * </pre>
     * 
     * @param medio {@link MedioDePagoDetail} - El medio de pago que se desea guardar.
     * @return JSON {@link MedioDePagoDetail}- El medio de pago guardado con el  atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} -  Error de logica que se genera cuando ya existe un medio de pago.
     */
    @POST
    public MedioDePagoDetail createMedioDePago(MedioDePagoDetail medio) throws BusinessLogicException
    {
        return medio;
    }
    
    /**
     * <h1> GET /api/mediosDePago : Obtener todos los medios de pago que acepta el negocio. </h1>
     * <p>
     * <pre> Busca y devuelve todos los medios de pago.
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los medioDePago de la aplicacion.</code>
     * </pre>
     * @return JSONArray {@link  MedioDePagoDetail} - Los medios de pago en la aplicacion. Si no hay ninguno retorna vacio. 
     */
    @GET
    public List<MedioDePagoDetail> getMediosDePago() 
    {
        return new ArrayList<>();
    }
    
    /**
     * <h1> GET /api/mediosDePago/{id} Obtener un medio de pago con el id.</h1>
     * <p>
     * <pre> Busca un medio de pago con el id asociado recibido por la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * 
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el medioDePago correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un medioDePago con el id dado.
     * </code>
     *</pre>
     * @param id Identificador del medio de pago que se esta buscando. Este debe ser una cadena de digitos.
     * @return JSON {@link MedioDePagoDetail} - El medio de pago buscado.
     * 
     */
    @GET
    @Path("{id: \\d+}")
    public MedioDePagoDetail getMedioDePago(@PathParam ("id") Long id)  
    {
        return null;
    }
    
    /**
     * <h1> PUT /api/mediosDePago/{id} : Actualizar un medio de pago. </h1>
     * <pre> Cuerpo de peticion: JSON {@link MedioDePagoDetail}.
     * 
     * Actualiza el medio de pago con el id recibido en la URL con la informacion que se recibe en el cuerpo de la peticion.
     ** Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la entidad de medioDePago con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de medioDePago con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la entidad medio de pago que se desea actualizar. Este debe ser una cadena de digitos.
     * @param medio {@link MedioDePagoDetail} La entidad de medio de pago que se desea guardar.
     * @return JSON {@link MedioDePagoDetail} - La entidad de medio de pago guardada.
     *  @throws BusinessLogicException {@link BusinessLogicException}  Error de logica que se genera al no poder actualizar la entidad de Cliente porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d++}")
    public MedioDePagoDetail updateMedioDePago(@PathParam("id") Long id, MedioDePagoDetail medio) throws BusinessLogicException
    {
        return medio;
    }
    
    /**
     * <h1> DELETE /api/mediosDePago7{id} : Borra un medio de pago.</h1>
     * <p>
     * <pre> Borra la entidad medioDePago con el id asociado recibido en la URL.
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la entidad de medioDePago correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de medioDePago con el id dado. </code>
     * </pre>
     *
     * @param id Identificador de la entidad de medioDePago que se desea borrar. Este debe ser una cadena de digitos.
     */
    @DELETE
    @Path ("{id: \\d++}")
    public void deleteMedioDePago ( @PathParam ("id") Long id)
    {
        
    }
}
