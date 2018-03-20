/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.RazaDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.RazaLogic;
import co.edu.uniandes.csw.sierra.entities.RazaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
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

/**
 * <pre>Clase que implementa el recurso "raza".
 * URL: /api/razas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "razas".</i>
 * <p>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author rj.gonzalez10
 * @version 1.0
 */
@Path("razas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class RazaResource {

    /**
     * Injecccion de la logica
     */
    @Inject
    private RazaLogic razaLogic;

    /**
     * Convierte una lista de entities a una lista de Detaildto.
     *
     * @param entityList Lista a convertir.
     * @return Lista convertida.
     *
     */
    private List<RazaDetailDTO> listEntity2DTO(List<RazaEntity> entityList) {
        List<RazaDetailDTO> list = new ArrayList<>();
        for (RazaEntity entity : entityList) {
            list.add(new RazaDetailDTO(entity));
        }
        return list;
    }

    /**
     * <h1> POST /api/razas : Crea una nueva raza.</h1>
     * <p>
     * <
     * pre> Cuerpo de la peticion: JSON {@link RazaDetail}.
     *
     * Crea una nueva raza con la informacion que se recibe en el cuerpo
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
     * @param medio {@link MedioDePagoDetail} - El medio de pago que se desea
     * guardar.
     * @return JSON {@link MedioDePagoDetail}- El medio de pago guardado con el
     * atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de
     * logica que se genera cuando ya existe un medio de pago.
     */
    @POST
    public RazaDetailDTO createRaza(RazaDetailDTO dto) throws BusinessLogicException {
        return new RazaDetailDTO(razaLogic.create(dto.toEntity()));
    }

    /**
     * <h1> GET /api/razas : Obtener todas las razas asociadas a las mascotas.
     * </h1>
     * <p>
     * <
     * pre> busca y retorna todas las razas.
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las razas de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link  RazaDetail} - Los medios de pago en la
     * aplicacion. Si no hay ninguno retorna vacio.
     */
    @GET
    public List<RazaDetailDTO> getRazas() {
        return listEntity2DTO(razaLogic.getAll());
    }

    /**
     * <h1> GET /api/razas/{id} Obtenre una raza por su id.</h1>
     * <p>
     * <
     * pre> Busca una raza con el id asociado recibido por la URL y la devuelve.
     *
     * Codigos de respuesta:
     *
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la raza correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una raza con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la raza que se esta buscando. Este debe ser
     * una cadena de digitos.
     * @return JSON {@link RazaDetail} - la raza buscada.
     *
     */

    @GET
    @Path("{id: \\d+}")
    public RazaDetailDTO getRaza(@PathParam("id") Long id) throws BusinessLogicException {
        RazaEntity raza = razaLogic.getById(id);
        //TODO: disparar WebApplicationException
        if (raza == null) {
            throw new BusinessLogicException("La raza que desea buscar no esta registrada en la base de datos.");
        }
        return new RazaDetailDTO(raza);
    }

    /**
     * <h1> PUT /api/razas/{id} : Actualizar una raza. </h1>
     * <pre> Cuerpo de peticion: JSON {@link RazaDetail}.
     *
     * Actualiza la raza con el id recibido en la URL con la informacion que se recibe en el cuerpo de la peticion.
     ** Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la entidad de raza con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de Raza con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la entidad raza que se desea actualizar. Este
     * debe ser una cadena de digitos.
     * @param medio {@link RazaDetail} La entidad de raza que se desea guardar.
     * @return JSON {@link RazaDetail} - La entidad de raza guardada.
     * @throws BusinessLogicException {@link BusinessLogicException} Error de
     * logica que se genera al no poder actualizar la entidad de Raza porque ya
     * existe una con ese nombre.
     */

    @PUT
    @Path("{id: \\d+}")
    public RazaDetailDTO updateRaza(@PathParam("id") Long id, RazaDetailDTO dDTO) throws BusinessLogicException {
        RazaEntity entity = dDTO.toEntity();
        entity.setId(id);
        RazaEntity oldEntity = razaLogic.getById(id);
        //TODO: disparar WebApplicationException
        if (oldEntity == null) {
            throw new BusinessLogicException("La raza no existe");
        }
        entity.setMascotas(oldEntity.getMascotas());
        return new RazaDetailDTO(razaLogic.update(entity));
    }

    /**
     * <h1> DELETE /api/razas{id} : Borra una raza.</h1>
     * <p>
     * <
     * pre> Borra la entidad raza con el id asociado recibido en la URL.
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la entidad de raza correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de raza con el id dado. </code>
     * </pre>
     *
     * @param id Identificador de la entidad de raza que se desea borrar. Este
     * debe ser una cadena de digitos.
     */
    @DELETE
    @Path("{id:\\d+}")
    public void deleteRaza(@PathParam("id") Long id) throws BusinessLogicException {
        RazaEntity entity = razaLogic.getById(id);
        //TODO: disparar WebApplicationException
        if (entity == null) {
            throw new BusinessLogicException("La raza que desea borrar no existe en la base de datos");
        }
        razaLogic.delete(id);
    }
}
