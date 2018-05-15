/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.CertificadoDetailDTO;
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
import javax.ws.rs.WebApplicationException;

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
@Path("certificados")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CertificadoResource {

    /**
     * Injecccion de la logica
     */
    @Inject
    private CertificadoLogic certificadoLogic;

    /**
     * Convierte una lista de entities a una lista de Detaildto.
     *
     * @param entityList Lista a convertir.
     * @return Lista convertida.
     *
     */
    private List<CertificadoDetailDTO> listEntity2DTO(List<CertificadoEntity> entityList) {
        List<CertificadoDetailDTO> list = new ArrayList<>();
        for (CertificadoEntity entity : entityList) {
            list.add(new CertificadoDetailDTO(entity));
        }
        return list;
    }

    /**
     * <h1>GET /api/certificados : Obtener todos los certificados.</h1>
     *
     * <pre>Busca y devuelve todos los certificados que existen en la aplicacion.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los certificados de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link CertificadoDetailDTO} - Los certificados encontrados en
     * la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<CertificadoDetailDTO> getCertificados() {
        return listEntity2DTO(certificadoLogic.getAll());
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
    public CertificadoDetailDTO getCertificado(@PathParam("id") Long id) throws BusinessLogicException {
        CertificadoEntity certificado = certificadoLogic.getById(id);
        if (certificado == null) {
            throw new WebApplicationException("el certificado que desea buscar no esta registrada en la base de datos.");
        }
        return new CertificadoDetailDTO(certificado);
    }

    /**
     * <h1>POST /api/especies : Crear un especies.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link EspecieDetailDTO}.
     *
     * Crea un nuevo certificado con la informacion que se recibe en el cuerpo
     * de la petición y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo la especie  .
     * </code>
     * </pre>
     *
     * @param dto {@link CertificadoDetailDTO} -el certificado que se desea guardar.
     * @return JSON {@link CertificadoDetailDTO} - el certificado se a guardado con el
     * atributo id autogenerado.
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    @POST
    public CertificadoDetailDTO createCertificado(CertificadoDetailDTO dto) throws BusinessLogicException {
        return new CertificadoDetailDTO(certificadoLogic.create(dto.toEntity()));
    }

    /**
     * <h1>PUT /api/certificados/{id} : Actualizar certificado con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CertificadoDetailDTO}.
     *
     * Actualiza el certificado con el id recibido en la URL con la información que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el certificado con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un certificado con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador del certificado que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param dDTO {@link CertificadoDetailDTO} el Certificado que se desea guardar.
     * @return JSON {@link CertificadoDetailDTO} - el certificado guardado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de
     * lógica
     */
    @PUT
    @Path("{id: \\d+}")
    public CertificadoDetailDTO updateCertificado(@PathParam("id") Long id, CertificadoDetailDTO dDTO) throws  BusinessLogicException {
        CertificadoEntity entity = dDTO.toEntity();
        entity.setId(id);
        CertificadoEntity oldEntity = certificadoLogic.getById(id);
        if (oldEntity == null) {
            throw new WebApplicationException("el certificado no existe");
        }
        entity.setMascotaVenta(oldEntity.getMascotaVenta());
       
        return new CertificadoDetailDTO(certificadoLogic.update(entity));
    }

    /**
     * <h1>DELETE /api/certificados/{id} : Borrar certificado por id.</h1>
     *
     * <pre>Borra el certificado  con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el certificado correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un certificado con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador del certificado que se desea borrar. Este debe ser
     * una cadena de dígitos.
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCertificado(@PathParam("id") Long id) throws BusinessLogicException {
        CertificadoEntity entity = certificadoLogic.getById(id);
        if (entity == null) {
            throw new WebApplicationException("El certificado que desea borrar no existe en la base de datos");
        }
        certificadoLogic.delete(id);
        
    }
}
