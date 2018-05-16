/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.



THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.MascotaDTO;
import co.edu.uniandes.csw.sierra.ejb.EspecieLogic;
import co.edu.uniandes.csw.sierra.entities.MascotaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * <pre>Clase que implementa el recurso "especies/{id}/mascotas".
 * URL: /api/especies/{especieId}/mascotas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "especies/{especieId}/mascotas".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author jd.zambrano
 * @version 1.0
 */

@Path("especies/{especieId: \\d+}/mascotas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EspecieMascotaResource {
    
    @Inject
    private EspecieLogic especieLogic;
    
    
    /**
     * Metodo que convierte una lista de entidades a una lista de DetailDTO
     * @param lista la lista de entidades
     * @return la lista de DetailDTO
     */
    public List<MascotaDTO> listEntityToDTO(List<MascotaEntity> lista){
        List<MascotaDTO> r = new ArrayList<>();
        for(MascotaEntity ent: lista){
            r.add(new MascotaDTO(ent));
        }
        return r;
    }
    
    @GET
    public List<MascotaDTO> getMascotasPorEspecie()
    {
        ArrayList<MascotaDTO> list = new ArrayList<>(); 
        
        
        
        return list;
    }
    
    
}
