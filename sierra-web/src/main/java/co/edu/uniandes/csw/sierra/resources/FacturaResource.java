/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.FacturaDetailDTO;
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
 *<pre>Clase que implementa el recurso "Facturas". URL: /api/facturas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api"
 * y este recurso tiene la ruta "facturas".</i>
 * <h2>Anotaciones</h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
* Produces/Consumes: indica que los servicios definidos en este recurso reciben y
*devuelven objetos en formato JSON
* RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
* </pre>
 * 
 * @author ja.amortegui10
 */

@Path( "adquisiciones" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class FacturaResource {
    /**
     * <h1> POST /api/factura : Crea una factura. </h1>
     * <pre>
     * Cuerpo de la peticion: JSON (@link FacturaDetailDTO).
     * Crea una nueva factura con la informacion que entra por el cuerpo de la petición.
     * Retorna un nuevo objeto identico con un id autogenerado por la base de datos.
     * Códigos de respuesta:
     * <code style="color:mediumseagreen; backround-color: #eaffe0;">
     * 200 OK La factura fue creada.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe una factura.
     * </code>
     *  </pre>
     * @param factura {@link FacturaDetailDTO} - La factura que se desea guardar
     * @return JSON {@link FacturaDetailDTO} - La factura guardada con el atributo id generado
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de logica que se genera cuando ya existe una factura.
     *
     */
    @POST
    public FacturaDetailDTO createFactura(FacturaDetailDTO factura) throws BusinessLogicException
    {
        return factura;
    }
    
    /**
     * <h1>GET /api/facturas : Obtener todas las facturas.</h1>
     * <p>
     * <pre> Busca y devuelve todas las facturas.
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las facturas de la aplicación.</code>
     * </pre>
     * 
     * @return JSONArray {@link FacturaDetailDTO} - las facturas encontradas en la aplicación. Si no hay ninguna retorna vacio.
     */
    
    @GET
    public List<FacturaDetailDTO> getFacturas()
    {
        return new ArrayList<FacturaDetailDTO>();
    }
    
    /**
     * <h1>GET /api/facturas/{id} : Obtener una factura por id.</h1>
     * 
     * <pre>Busca la factura con el id asociado recibido en la URL y la devuelve.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la factura correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una factura con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la factura que se está buscando. Este debe ser una cadena de digitos.
     * @return JSON {@link FacturaDetailDTO} - La factura buscada.
     */
    
    @GET
    @Path("{id: \\d+}")
    public FacturaDetailDTO getFactura(@PathParam("id") Long id)
    {
        return null;
    }
    
    /**
     * <h1>  PUT /api/facturas/{id} : Actualizar una entidad de factura con el id dado. </h1>
     * <pre> Cuerpo de peticion: JSON {@link FacturaDetailDTO}.
     * 
     * Actualiza la entidad de factura con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     ** Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la entidad de Factura con el id dado con la información enviada como parámetro. Retorna un objeto idéntico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de Factura con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la entidad de factura que se desea actualizar. Este debe ser una cadena de digitos.
     * @param infoFactura {@link FacturaDetailDETO} la entidad de factura que se desea guardar.
     * @return JSON {@link FacturaDetailDTO} - La entidad de factura guardada.
     * @throws BusinessLogicException {@link BusinessLogicException}  Error de logica que se genera al no poder actualizar la entidad de Factura porque ya existe una con ese nombre.
     */
    
    @PUT
    @Path("(id: \\d+)")
    public FacturaDetailDTO updateFactura(@PathParam("id") Long id, FacturaDetailDTO infoFactura)throws BusinessLogicException
    {
        return infoFactura;
    }
    
    /**
     * <h1> DELETE /api/facturas/{id} : Borra una factura con el id. </h1>
     * <p>
     * <pre> Borra la entidad factura con el id asociado recibido en la URL.
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la entidad de Factura correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de Factura con el id dado. </code>
     * </pre>
     * 
     * @param id Identificar de la entidad de la factura que se desea borrar. Este debe ser una cadena de digitos.
     */
    
    @DELETE
    @Path("(id: \\d+)")
    public void deleteFactura(@PathParam("id") Long id)throws BusinessLogicException
    {
        //process
    }
}
