/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.CertificadoDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.CalificacionLogic;
import co.edu.uniandes.csw.sierra.ejb.CertificadoLogic;
import co.edu.uniandes.csw.sierra.entities.CertificadoEntity;
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
 * <pre>Clase que implementa el recurso "Certificado".
 * URL: /api/certificados
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "certificados".</i>
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
//TODO: Revisar el path para llegar a este recurso
@Path("certificados")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CertificadoResource {

    /**
     * la conexion con logic
     */
    @Inject
    private CertificadoLogic certificadoLogic;

    /**
     * Metodo que convierte una lista de entidades a una lista de DetailDTO
     *
     * @param lista la lista de entidades
     * @return la lista de DetailDTO
     */
    public List<CertificadoDetailDTO> listEntityToDTO(List<CertificadoEntity> lista) {
        List<CertificadoDetailDTO> r = new ArrayList<>();
        for (CertificadoEntity ent : lista) {
            r.add(new CertificadoDetailDTO(ent));
        }
        return r;
    }

    /**
     * <h1> POST /api/certificados : Crea un nuevo certificado.</h1>
     * <p>
     * <
     * pre> Cuerpo de la peticion: JSON {@link CertificadoDetail}.
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
     * 412 Precondition Failed: ya existe ese certificado:
     * </code>
     * </pre>
     *
     * @param medio {@link CertificadoDetail - El certificado que se desea guardar.
     * @return JSON {@link CertificadoDetail}- El certificado guardado con el  atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} -  Error de logica que se genera cuando ya existe un medio de pago.
     */
    @POST
    public CertificadoDetailDTO createCertificado(CertificadoDetailDTO dto) throws BusinessLogicException {
        return new CertificadoDetailDTO(certificadoLogic.create(dto.toEntity()));
    }

    /**
     * <h1> GET /api/certificados : Obtener todos certificados asociados a las
     * mascotas. </h1>
     * <p>
     * <
     * pre> busca y retorna todos los certificados.
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los certificados de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link  CertificadoDetail} - Los medios de pago en la
     * aplicacion. Si no hay ninguno retorna vacio.
     */
    @GET
    public List<CertificadoDetailDTO> getCertificado() {
        return listEntityToDTO(certificadoLogic.getAll());
    }

    /**
     * <h1> GET /api/certificados/{id} Obtenre un certificado por su id.</h1>
     * <p>
     * <
     * pre> Busca un certificado con el id asociado recibido por la URL y la devuelve.
     *
     * Codigos de respuesta:
     *
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el certificado correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un certificado con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador del certificado que se esta buscando. Este debe
     * ser una cadena de digitos.
     * @return JSON {@link CertificadoDetail} - El certificado buscado.
     *
     */
    @GET
    @Path("{id: \\d+}")
    public CertificadoDetailDTO getCertificado(@PathParam("id") Long id) throws BusinessLogicException {
        CertificadoEntity ent = certificadoLogic.getById(id);
        //TODO: disparar WebApplicationException
        if (ent == null) {
            throw new BusinessLogicException("El certificado con el id: " + id + " no existe");
        }
        return new CertificadoDetailDTO(ent);
    }

    /**
     * <h1> PUT /api/certificados/{id} : Actualizar un medio de pago. </h1>
     * <pre> Cuerpo de peticion: JSON {@link CertificadoDetail}.
     *
     * Actualiza el certificado con el id recibido en la URL con la informacion que se recibe en el cuerpo de la peticion.
     ** Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la entidad de certificado con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de certificado con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la entidad certificado que se desea
     * actualizar. Este debe ser una cadena de digitos.
     * @param medio {@link CertificadoDetail} La entidad de certificado que se
     * desea guardar.
     * @return JSON {@link CertificadoDetail} - La entidad de certificado
     * guardada.
     * @throws BusinessLogicException {@link BusinessLogicException} Error de
     * logica que se genera al no poder actualizar la entidad de Certificado
     * porque ya existe una con ese nombre.
     */

    @PUT
    @Path("{id: \\d+}")
    public CertificadoDetailDTO updateCalificacion(@PathParam("id") Long id, CertificadoDetailDTO dDTO) throws BusinessLogicException {
        CertificadoEntity ent = dDTO.toEntity();
        ent.setId(id);
        //revisa si existe la entidad
        CertificadoEntity oldEnt = certificadoLogic.getById(id);
        //TODO: disparar WebApplicationException
        if (oldEnt == null) {
            throw new BusinessLogicException("No existe un certificado con el id: " + id);
        }

        ent.setMascotaVenta(oldEnt.getMascotaVenta());
        return new CertificadoDetailDTO(certificadoLogic.update(ent));
    }

    /**
     * <h1> DELETE /api/certificados{id} : Borra un certificado.</h1>
     * <p>
     * <
     * pre> Borra la entidad certificado con el id asociado recibido en la URL.
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la entidad de certificado correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una entidad de certificado con el id dado. </code>
     * </pre>
     *
     * @param id Identificador de la entidad de certificado que se desea borrar.
     * Este debe ser una cadena de digitos.
     */

    @DELETE
    @Path("{id:\\d+}")
    public void deleteCertificado(@PathParam("id") Long id) throws BusinessLogicException {
        CertificadoEntity ent = certificadoLogic.getById(id);
        //TODO: disparar WebApplicationException
        if (ent == null) {
            throw new BusinessLogicException("No existe el certificado con id: " + id);
        }
        certificadoLogic.delete(ent.getId());
    }
}
