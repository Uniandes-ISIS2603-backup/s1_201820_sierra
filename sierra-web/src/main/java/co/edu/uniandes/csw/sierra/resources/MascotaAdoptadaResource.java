/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.MascotaAdopcionDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.MascotaAdoptadaLogic;
import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * <pre>Clase que implementa el recurso "mascotaAdoptada".
 * URL: /api/mascotaAdoptadas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "especies".</i>
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
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class MascotaAdoptadaResource 
{
    /**
     * Se injecta la claselogica del recurso
     */
    @Inject
    private MascotaAdoptadaLogic mascotaAdoptadaLogica;
    
    /**
     * Convierte una lista de entities a una lista de Detaildto.
     *
     * @param entityList Lista  a convertir.
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
    
}
