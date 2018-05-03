
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.PublicacionDTO;
import co.edu.uniandes.csw.sierra.dtos.PublicacionDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.PublicacionLogic;
import co.edu.uniandes.csw.sierra.entities.PublicacionEntity;
import co.edu.uniandes.csw.sierra.mappers.WebApplicationExceptionMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
*<pre> Clase encargada de implementar el recurso "Publicación".</pre>
 *URL: /api/publicaciones 
 *@author Ja.penat
 *@version 1.0
 */

@Path("publicaciones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PublicacionResource
 {
     /**
     * Se injecta la clase logica del recurso
     */
     @Inject
     private PublicacionLogic publicacionLogica;
     
      /**
     * Metodo que convierte una lista de entidades a una lista de DTO
     * @param lista la lista de entidades
     * @return la lista de DTO
     */
    public List<PublicacionDTO> listEntityToDTO(List<PublicacionEntity> lista)
    {
        List<PublicacionDTO> nuevo = new ArrayList<>();
        for(PublicacionEntity ent: lista)
        {
            nuevo.add(new PublicacionDTO(ent));
        }
        return nuevo;
    }

     /**
     * Metodo que convierte una lista de entidades a una lista de DetailDTO
     * @param lista la lista de entidades
     * @return la lista de DetailDTO
     */
    public List<PublicacionDetailDTO> listEntityToDetailDTO(List<PublicacionEntity> lista)
    {
        List<PublicacionDetailDTO> nuevo = new ArrayList<>();
        for(PublicacionEntity ent: lista)
        {
            nuevo.add(new PublicacionDetailDTO(ent));
        }
        return nuevo;
    }
    
@POST
public PublicacionDTO createPublicacion(PublicacionDTO puDto)
{
  return puDto;
}

    /**
     * <h1>GET /api/publicaciones : Obtener todos las publicaciones.</h1>
     * <pre>Busca y devuelve todos las publicaciones  que existen en la aplicacion.
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las publicaciones +de la aplicacion.</code>
     * </pre>
     * @return JSONArray {@link PublicacionDetailDTO} - Las publicaciones
     *  encontrados en la aplicación. Si no hay ninguno retorna una
     * lista vacía.
     */
@GET
public List<PublicacionDTO> getPublicaciones()
{
return listEntityToDTO(publicacionLogica.getAll());
}
/**
     * <h1>GET /api/publicaciones/{id} : Obtener las publicaciones por id.</h1>
     * <pre>Busca la publicacion con el id asociado recibido en la URL y la devuelve.
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la publicacion correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una publicacion con el id dado.
     * </code>
     * </pre>
     * @param idCliente(No)
     * @param id Identificador de la publicacion que se esta buscando. Este debe ser una cadena de digitos.
     * @return JSON {@link PublicacionDetailDTO} - La publicacion buscada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}. 
     */
@GET                    
@Path("{id: \\d+}")
public PublicacionDTO getPublicacion(@PathParam("id") long id)throws WebApplicationException
{
        PublicacionEntity entity = publicacionLogica.getById(id);
        if (entity == null) 
        {
            throw new WebApplicationException("El recurso publicacion con el id " + id + " no existe.", 404);
        }
        return new PublicacionDTO(entity);
}
@PUT
@Path("{id: \\d+}")
public void updatePublicacion(@PathParam("id") long id, PublicacionDTO puDto) 
{

}
@DELETE
@Path("{id:\\d+}")
public void deletePublicacion(@PathParam("id") long id)
{
}
}
