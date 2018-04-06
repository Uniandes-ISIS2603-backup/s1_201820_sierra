/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;


import co.edu.uniandes.csw.sierra.dtos.MascotaAdopcionDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.MascotaAdoptadaLogic;
import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
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
import javax.ws.rs.WebApplicationException;

/**
 * <pre>Clase que implementa el recurso "mascotaAdoptada".
 * URL: /api/mascotaAdoptadas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "mascotasAdoptadas".</i>
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
@Path("mascotasAdoptadas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MascotaAdoptadaResource {

    /**
     * Se injecta la clase logica del recurso
     */
    @Inject
    private MascotaAdoptadaLogic mascotaAdoptadaLogica;

    /**
     * Convierte una lista de entities a una lista de Detaildto.
     *
     * @param entityList Lista a convertir.
     * @return Lista convertida.
     *
     */
    private List<MascotaAdopcionDetailDTO> listEntity2DTO(List<MascotaAdoptadaEntity> entityList) {
        List<MascotaAdopcionDetailDTO> list = new ArrayList<>();
        for (MascotaAdoptadaEntity entity : entityList) {
            list.add(new MascotaAdopcionDetailDTO(entity));
        }
        return list;
    }

    /**
     * <h1>GET /api/mascotasAdoptadas : Obtener todos las mascotas
     * adoptadas.</h1>
     *
     * <pre>Busca y devuelve todos las mascotas adoptadas que existen en la aplicacion.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las mascotas adoptadas de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link MascotaAdopcionDetailDTO} - Las mascotas
     * adoptadas encontrados en la aplicación. Si no hay ninguno retorna una
     * lista vacía.
     */
    @GET
    public List<MascotaAdopcionDetailDTO> getMascotasAdoptadas() {
        return listEntity2DTO(mascotaAdoptadaLogica.getAllMascotasAdoptadas());
    }

    /**
     * <h1>GET /api/mascotasAdoptadas/{id} : Obtener mascota adoptada por
     * id.</h1>
     *
     * <pre>Busca la mascota adoptada con el id asociado recibido en la URL y lo devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la mascota adoptada correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una mascota adoptada  con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la mascota adoptada que se esta buscando. Este
     * debe ser una cadena de dígitos.
     * @return JSON {@link MascotaAdopcionDetailDTO} - La mascota adoptada
     * buscado
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de
     * lógica que se genera cuando no se encuentra la mascota adoptada
     */
    @GET
    @Path("{id: \\d+}")
    public MascotaAdopcionDetailDTO getMascotaAdoptada(@PathParam("id") Long id) throws BusinessLogicException {
        MascotaAdoptadaEntity mascota = mascotaAdoptadaLogica.getMascotaAdoptadaById(id);
        if (mascota == null) {
            throw new WebApplicationException("La compania no existe.");
        }
        return new MascotaAdopcionDetailDTO(mascota);
    }

    /**
     * <h1>POST /api/mascotasAdoptadas : Crear una mascota adoptada.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link MascotaAdopcionDetailDTO}.
     *
     * Crea una nueva mascota adoptada con la informacion que se recibe en el cuerpo
     * de la petición y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo la mascota adoptada  .
     * </code>
     * </pre>
     *
     * @param dto {@link MascotaAdopcionDetailDTO} -La mascota adoptada que se
     * desea guardar.
     * @return JSON {@link MascotaAdopcionDetailDTO} - La mascotaadoptada se a
     * guardado con el atributo id autogenerado.
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    @POST
    public MascotaAdopcionDetailDTO createMascota(MascotaAdopcionDetailDTO dto) throws BusinessLogicException {

        return new MascotaAdopcionDetailDTO(mascotaAdoptadaLogica.createMascotaAdoptada(dto.toEntity()));
    }

    /**
     * <h1>PUT /api/mascotasAdoptadas/{id} : Actualizar mascota adoptada con el
     * id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link MascotaAdopcionDetailDTO}.
     *
     * Actualiza la mascota adoptada  con el id recibido en la URL con la información que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la mascota adoptada con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una mascota adoptada con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la mascota adoptada que se desea actualizar.
     * Este debe ser una cadena de dígitos.
     * @param dDTO {@link MascotaAdopcionDetailDTO} La mascota adoptada que se
     * desea guardar.
     * @return JSON {@link MascotaAdopcionDetailDTO} - La mascota adoptada
     * guardada.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de
     * lógica
     */
    @PUT
    @Path("{id: \\d+}")
    public MascotaAdopcionDetailDTO updateMascotaAdoptada(@PathParam("id") Long id, MascotaAdopcionDetailDTO dDTO) throws BusinessLogicException {
        MascotaAdoptadaEntity entity = dDTO.toEntity();
        entity.setId(id);
        MascotaAdoptadaEntity oldEntity = mascotaAdoptadaLogica.getMascotaAdoptadaById(id);
        if (oldEntity == null) {
            throw new WebApplicationException("La la mascota adoptada no existe");
        }
        entity.setAcontecimientos(oldEntity.getAcontecimientos());
        entity.setPublicaciones(oldEntity.getPublicaciones());
        entity.setAdquisicion(oldEntity.getAdquisicion());
        entity.setEspecie(oldEntity.getEspecie());
        entity.setRaza(oldEntity.getRaza());

        return new MascotaAdopcionDetailDTO(mascotaAdoptadaLogica.updateMascotaAdoptada(entity));
    }

    /**
     * <h1>DELETE /api/mascotasAdoptadas/{id} : Borrar mascota adoptada por
     * id.</h1>
     *
     * <pre>Borra la mascota adoptada  con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la mascota adoptada  correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una mascota adoptada  con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la mascotaadoptada que se desea borrar. Este
     * debe ser una cadena de dígitos.
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteMascotaAdoptada(@PathParam("id") Long id) throws BusinessLogicException {
        MascotaAdoptadaEntity entity = mascotaAdoptadaLogica.getMascotaAdoptadaById(id);
        if (entity == null) {
            throw new WebApplicationException("La mascota adoptada no existe");
        }
        mascotaAdoptadaLogica.deleteMascotaAdoptada(id);

    }

}
