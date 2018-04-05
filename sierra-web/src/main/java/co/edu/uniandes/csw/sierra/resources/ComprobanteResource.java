/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.ComprobanteDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.ComprobanteLogic;
import co.edu.uniandes.csw.sierra.entities.ComprobanteEntity;
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
 * *<pre>Clase que implementa el recurso "Comprobantes". URL: /api/comprobantes
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api"
 * y este recurso tiene la ruta "comprobantes".</i>
 * <h2>Anotaciones</h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
* Produces/Consumes: indica que los servicios definidos en este recurso reciben y
*devuelven objetos en formato JSON
* RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
* </pre>
 * @author ja.amortegui10
 */
//TODO: Revisar el path para llegar a este recurso
@Path( "comprobantes" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class ComprobanteResource {
    
    /**
     * Injección de la lógica.
     */
    @Inject
    private ComprobanteLogic logic;
    
    /**
     * <h1> POST /api/comprobantes : Crea un comprobante. </h1>
     * <pre>
     * Cuerpo de la peticion: JSON (@link ComprobanteDetailDTO).
     * Crea una nueva factura con la información que entra por el cuerpo de la petición.
     * Retorna un nuevo objeto identico con un id autogenerado por la base de datos.
     * Códigos de respuesta:
     * <code style="color:mediumseagreen; backround-color: #eaffe0;">
     * 200 OK El comprobante fue creado.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe un comprobante.
     * </code>
     *  </pre>
     * @param dto {@link ComprobanteDetailDTO} - El comprobante que se desea guardar
     * @return JSON {@link ComprobanteDetailDTO} - El comprobante guardado con el atributo id generado
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de logica que se genera cuando ya existe un comprobante.
     *
     */
    @POST
    public ComprobanteDetailDTO createComprobante(ComprobanteDetailDTO dto) throws BusinessLogicException
    {
        return new ComprobanteDetailDTO(logic.create(dto.toEntity()));
    }
    
    
    /**
     * 
     * @param entities, lista de lista de entidades.
     * @return la lista de datos resultantes de la transformación de las entidades dadas por parámetro.
     */
    private List<ComprobanteDetailDTO> listEntity2DTO(List<ComprobanteEntity> entities)
    {
        List<ComprobanteDetailDTO> dtos = new ArrayList<>();
        for(ComprobanteEntity entityActual : entities)
            dtos.add(new ComprobanteDetailDTO(entityActual));
        return dtos;
    }
    
    /**
     * <h1>GET /api/comprobantes : Obtener todos los comprobantes.</h1>
     * <p>
     * <pre> Busca y devuelve todos los comprobantes.
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los comprobantes de la aplicación.</code>
     * </pre>
     * 
     * @return JSONArray {@link ComprobanteDetailDTO} - Los comprobantes encontrados en la aplicación. Si no hay ninguna retorna vacio.
     */
    @GET
    public List<ComprobanteDetailDTO> getComprobantes()
    {
        return listEntity2DTO(logic.getAll());
    }
    
    /**
     * <h1>GET /api/comprobantes/{id} : Obtener un comprobante por id.</h1>
     * 
     * <pre>Busca el comprobante con el id asociado recibido en la URL y lo devuelve.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el comprobante correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un comprobante con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del comprobante que se está buscando. Este debe ser una cadena de digitos.
     * @return JSON {@link ComprobanteDetailDTO} - El comprobante buscada.
     */
    
    @GET
    @Path("{id: \\d+}")
    public ComprobanteDetailDTO getComprobante(@PathParam("id") Long id)throws BusinessLogicException
    {
        ComprobanteEntity encontrado = logic.getById(id);
        //TODO: disparar WebApplicationException
        if(encontrado == null)
            throw new WebApplicationException("No existe un comprobante con el id dado por parámetro.");
        
        return new ComprobanteDetailDTO(encontrado);
    }
    
    /**
     * <h1>  PUT /api/comprobantes/{id} : Actualizar una entidad de comprobante con el id dado. </h1>
     * <pre> Cuerpo de peticion: JSON {@link ComprobanteDetailDTO}.
     * 
     * Actualiza la entidad de comprobante con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     ** Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la entidad de Comprobante con el id dado con la información enviada como parámetro. Retorna un objeto idéntico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de Comprobante con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la entidad de comprobante que se desea actualizar. Este debe ser una cadena de digitos.
     * @param infoComprobante {@link ComprobanteDetailDTO} la entidad de comprobante que se desea guardar.
     * @return JSON {@link ComprobanteDetailDTO} - La entidad de comprobante guardada.
     * @throws BusinessLogicException {@link BusinessLogicException}  Error de logica que se genera al no poder actualizar la entidad de Comprobante porque ya existe una con ese nombre.
     */
    
    @PUT
    @Path("{id: \\d+}")
    public ComprobanteDetailDTO updateComprobante(@PathParam("id") Long id, ComprobanteDetailDTO infoComprobante)throws BusinessLogicException
    {
        ComprobanteEntity entity = infoComprobante.toEntity();
        entity.setId(id);
        ComprobanteEntity oldEntity = logic.getById(id);
        //TODO: disparar WebApplicationException
        if(oldEntity == null)
            throw new WebApplicationException("El comprobante no existe.");
        entity.setFactura(oldEntity.getFactura());
        entity.setMedioDePago(oldEntity.getMedioDePago());
        return new ComprobanteDetailDTO(logic.update(entity));
    }
    
    /**
     * <h1> DELETE /api/comprobantes/{id} : Borra un comprobante con el id. </h1>
     * <p>
     * <pre> Borra la entidad comprobante con el id asociado recibido en la URL.
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la entidad de Comprobante correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de Comprobante con el id dado. </code>
     * </pre>
     * 
     * @param id Identificar de la entidad del comprobante que se desea borrar. Este debe ser una cadena de digitos.
     */
    
    @DELETE
    @Path("(id: \\d+)")
    public void deleteComprobante(@PathParam("id") Long id)throws BusinessLogicException
    {
        //process
        ComprobanteEntity entity = logic.getById(id);
        //TODO: disparar WebApplicationException
        if(entity == null)
            throw new WebApplicationException("El comprobante buscado no existe.");
        logic.delete(id);
    }
}
