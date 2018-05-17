/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.resources;

import co.edu.uniandes.csw.sierra.dtos.FacturaDetailDTO;
import co.edu.uniandes.csw.sierra.ejb.ComprobanteLogic;
import co.edu.uniandes.csw.sierra.ejb.FacturaLogic;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
/**
 * <pre>Clase que implementa el recurso "facturas/{id}/comprobantes".
 * URL: /api/factura/{facturaId}/comprobantes
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "facturas/{facturaId}/comprobantes".</i>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 * @version 1.0
 * @author ja.penat
 */
@Path("facturas/(facturaId: \\d+}/comprobantes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FacturaComprobanteResource 
{
    @Inject
    private ComprobanteLogic comprobanteLogica ;
    
    /**
     * <h1>POST /api/facturas/{facturaId}/comprobantes/{comprobanteId} : Guarda un comprobante
     * dentro de la factura.</h1>
     *
     * <pre> Guarda un comprobante dentro de una factura con la informacion que
     * recibe el la URL. Se devuelve la factura que guarda los comprobantes
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Guardó el nuevo comprobante.
     * </code>
     * </pre>
     * @param facturaId Identificador de la factura que se esta buscando. Este debe ser una cadena de dígitos.
     * @param comprobanteId Identificador del comprobante  que se desea guardar. Este debe ser una cadena de dígitos.
     * @return JSON {@link facturaDetailDTO} - La factura donde se guardara el comprobante
     */
    @POST
    @Path("{comprobanteId: \\d+}")
    public FacturaDetailDTO crearFacturaComprobante(@PathParam("facturaId") Long facturaId, @PathParam("comprobanteId") Long comprobanteId)
    {
        System.out.println("facturaIdResoure: \n facturaId: " +  facturaId + "\n comprobanteId: " + comprobanteId);
        try
        {
            return new FacturaDetailDTO(comprobanteLogica.addComprobante(facturaId, comprobanteId));
        }
        catch(BusinessLogicException e)
        {
            throw new WebApplicationException("404: " + e.getMessage());
        }
        
    }
    
}
