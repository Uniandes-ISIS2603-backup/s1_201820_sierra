/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.MascotaVentaDTO;
import co.edu.uniandes.csw.sierra.dtos.MascotaVentaDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.MascotaVentaLogic;
import co.edu.uniandes.csw.sierra.entities.MascotaVentaEntity;
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

@Path("mascotasVenta")
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class MascotaVentaResource 
{
    /**
     * Se injecta la clase logica del recurso
     */
    @Inject
    private MascotaVentaLogic mascotaVentaLogica;
    
  
    /**
     * Convierte una lista de entities a una lista de Detaildto.
     *
     * @param entityList Lista  a convertir.
     * @return Lista convertida.
     * 
     */
    private List<MascotaVentaDetailDTO> listEntity2DTO(List<MascotaVentaEntity> entityList) {
        List<MascotaVentaDetailDTO> list = new ArrayList<>();
        for (MascotaVentaEntity entity : entityList) {
            list.add(new MascotaVentaDetailDTO(entity));
        }
        return list;
    }
    
      /**
     * <h1>GET /api/mascotasVenta : Obtener todos las mascotas en venta.</h1>
     *
     * <pre>Busca y devuelve todos las mascotas en venta que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las mascotas en venta de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link MascotaVentaDetailDTO} - Las mascotas Ventas encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */  
    @GET
    public List<MascotaVentaDetailDTO> getMascotasVenta(){
       return listEntity2DTO(mascotaVentaLogica.getAll());
    }
    
     /**
     * <h1>GET /api/mascotasVenta/{id} : Obtener mascota Venta por id.</h1>
     *
     * <pre>Busca la mascota Venta con el id asociado recibido en la URL y lo devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la mascota Venta correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una mascota Venta  con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la mascota Venta  que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link MascotaVentaDetailDTO} - La mascota Venta buscado
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando no se encuentra la mascota Venta
     */
    @GET
    @Path( "{id: \\d+}" )
    public MascotaVentaDetailDTO getMascotaVenta( @PathParam( "id" ) Long id ) throws BusinessLogicException
    {
        MascotaVentaEntity mascota= mascotaVentaLogica.getById(id);
        if (mascota==null) {
             throw new BusinessLogicException("La compania no existe.");
        }
        return new MascotaVentaDetailDTO(mascota);
    }

     /**
     * <h1>POST /api/mascotasVenta : Crear una mascota Venta.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link MascotaVentaDetailDTO}.
     * 
     * Crea una nueva mascota Venta con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo la mascota Venta  .
     * </code>
     * </pre>
     * @param dto {@link MascotaVentaDTO} -La mascota Venta  que se desea guardar.
     * @return JSON {@link MascotaVentaDTO}  - La mascotaVenta se a guardado con el atributo id autogenerado.
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    @POST
    public MascotaVentaDTO createMascota(MascotaVentaDTO dto) throws BusinessLogicException{
 
        return new MascotaVentaDTO(mascotaVentaLogica.create(dto.toEntity()));
    }
    
   /**
     * <h1>PUT /api/mascotasVenta/{id} : Actualizar mascota Venta con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link MascotaVentaDetailDTO}.
     *
     * Actualiza la mascota Venta  con el id recibido en la URL con la información que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la mascota Venta con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una mascota Venta con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la mascota Venta que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param dDTO {@link MascotaVentaDetailDTO} La mascota Venta que se desea guardar.
     * @return JSON {@link MascotaVentaDetailDTO} - La mascota Venta guardada.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica 
     */
    @PUT
    @Path( "{id: \\d+}" )
    public MascotaVentaDetailDTO updateMascotaVenta( @PathParam( "id" ) Long id, MascotaVentaDetailDTO dDTO ) throws BusinessLogicException
    {
        MascotaVentaEntity entity = dDTO.toEntity();
        entity.setId(id);
        MascotaVentaEntity oldEntity = mascotaVentaLogica.getById(id);
        if (oldEntity == null) {
            throw new BusinessLogicException("La la mascota Venta no existe");
        }
        entity.setCertificados(oldEntity.getCertificados());
        entity.setPublicaciones(oldEntity.getPublicaciones());
        entity.setAdquisicion(oldEntity.getAdquisicion());
        //entity.setEspecie(oldEntity.getEspecie());
        entity.setRaza(oldEntity.getRaza());
   
        return new MascotaVentaDetailDTO(mascotaVentaLogica.update(entity));
    }

     /**
     * <h1>DELETE /api/mascotasVenta/{id} : Borrar mascota Venta por id.</h1>
     *
     * <pre>Borra la mascota Venta  con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la mascota Venta  correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una mascota Venta  con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la mascotaVenta que se desea borrar. Este debe ser una cadena de dígitos.
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    @DELETE
    @Path( "{id: \\d+}" )
    public void deleteMascotaVenta( @PathParam( "id" ) Long id ) throws BusinessLogicException
    {
        MascotaVentaEntity entity = mascotaVentaLogica.getById(id);
        if (entity == null) {
            throw new BusinessLogicException("La mascota Venta no existe");
        }
        mascotaVentaLogica.delete(id);
    	
    }
    
}

