/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.EspecieDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.EspecieLogic;
import co.edu.uniandes.csw.sierra.entities.EspecieEntity;
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
 * <pre>Clase que implementa el recurso "especie".
 * URL: /api/especies
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "especies".</i>
 * <p>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author jc.sanchez12
 * @version 1.0
 */
@Path("especies")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EspecieResource {

    /**
     * Injecccion de la logica
     */
    @Inject
    private EspecieLogic especieLogic;

    /**
     * Convierte una lista de entities a una lista de Detaildto.
     *
     * @param entityList Lista a convertir.
     * @return Lista convertida.
     *
     */
    private List<EspecieDetailDTO> listEntity2DTO(List<EspecieEntity> entityList) {
        List<EspecieDetailDTO> list = new ArrayList<>();
        for (EspecieEntity entity : entityList) {
            list.add(new EspecieDetailDTO(entity));
        }
        return list;
    }

    /**
     * <h1>GET /api/especies : Obtener todos las especies.</h1>
     *
     * <pre>Busca y devuelve todos las especies que existen en la aplicacion.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las especies de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link EspecieDetailDTO} - Las especies encontrados en
     * la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<EspecieDetailDTO> getEspecies() {
        return listEntity2DTO(especieLogic.getAll());
    }

    /**
     * <h1>GET /api/especies/{id} : Obtener especie por id.</h1>
     *
     * <pre>Busca la especie con el id asociado recibido en la URL y lo devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la especie correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una especie  con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la especie que se esta buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link EspecieDetailDTO} - La especie buscada
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de
     * lógica que se genera cuando no se encuentra la especie.
     */
    @GET
    @Path("{id: \\d+}")
    public EspecieDetailDTO getEspecie(@PathParam("id") Long id) throws BusinessLogicException {
        EspecieEntity especie = especieLogic.getById(id);
        //TODO: disparar WebApplicationException
        if (especie == null) {
            throw new BusinessLogicException("La especie que desea buscar no esta registrada en la base de datos.");
        }
        return new EspecieDetailDTO(especie);
    }

    /**
     * <h1>POST /api/especies : Crear un especies.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link EspecieDetailDTO}.
     *
     * Crea una nueva especie con la informacion que se recibe en el cuerpo
     * de la petición y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo la especie  .
     * </code>
     * </pre>
     *
     * @param dto {@link EspecieDetailDTO} -La especie que se desea guardar.
     * @return JSON {@link EspecieDetailDTO} - La especie se a guardado con el
     * atributo id autogenerado.
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    @POST
    public EspecieDetailDTO createEspecie(EspecieDetailDTO dto) throws BusinessLogicException {
        return new EspecieDetailDTO(especieLogic.create(dto.toEntity()));
    }

    /**
     * <h1>PUT /api/especies/{id} : Actualizar especie con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link EspecieDetailDTO}.
     *
     * Actualiza la especie  con el id recibido en la URL con la información que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la especie con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una especie con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la especie que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param dDTO {@link EspecieDetailDTO} La especie que se desea guardar.
     * @return JSON {@link EspecieDetailDTO} - La especie guardado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de
     * lógica
     */
    @PUT
    @Path("{id: \\d+}")
    public EspecieDetailDTO updateEspecie(@PathParam("id") Long id, EspecieDetailDTO dDTO) throws BusinessLogicException {
        EspecieEntity entity = dDTO.toEntity();
        entity.setId(id);
        EspecieEntity oldEntity = especieLogic.getById(id);
        //TODO: disparar WebApplicationException
        if (oldEntity == null) {
            throw new BusinessLogicException("La especie no existe");
        }
        entity.setMascotaS(oldEntity.getMascotas());
        entity.setRazas(oldEntity.getRazas());
        return new EspecieDetailDTO(especieLogic.update(entity));
    }

    /**
     * <h1>DELETE /api/especies/{id} : Borrar especie por id.</h1>
     *
     * <pre>Borra la especie  con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la especie  correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una especie  con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la especie que se desea borrar. Este debe ser
     * una cadena de dígitos.
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEspecie(@PathParam("id") Long id) throws BusinessLogicException {
        EspecieEntity entity = especieLogic.getById(id);
        //TODO: disparar WebApplicationException
        if (entity == null) {
            throw new BusinessLogicException("La especie que desea borrar no existe en la base de datos");
        }
        especieLogic.delete(id);
    }
}
