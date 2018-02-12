/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import java.util.List;

/**
 *
 * @author de.gutierrez
 */
public class ClienteDetailDTO extends ClienteDTO
{
    private List<MedioDePagoDTO> mediosPago;
    private List<AdquisicionDTO> aquisiciones;
    private List<MascotaDTO> deseadas;
    
    /**
     * Metodo constructor por defecto.
     */
    public ClienteDetailDTO()
    {
        
    }

    /**
     * Obtiene la lista de los medios de pago de un cliente.
     * @return Lista de medios de pago.
     */
    public List<MedioDePagoDTO> getMediosPago() {
        return mediosPago;
    }

    /**
     * Agrega medios de pago de un cliente a una lista.
     * @param medioPago El que se desea agregar.
     */
    public void setMediosPago(List<MedioDePagoDTO> medioPago) {
        this.mediosPago = medioPago;
    }

    /**
     * Obtiene una lista con las adquisiciones de un cliente.
     * @return Las adquisiciones asociadas a un cliente.
     */
    public List<AdquisicionDTO> getAquisiciones() {
        return aquisiciones;
    }

    /**
     * Agrega una nueva adquisicion a la lista de un cliente.
     * @param aquisiciones Las nuevas adquisiciones.
     */
    public void setAquisiciones(List<AdquisicionDTO> aquisiciones) {
        this.aquisiciones = aquisiciones;
    }

    /**
     * Obtiene una lista las mascotas que desea un cliente.
     * @return Las mascotas deseadas.
     */
    public List<MascotaDTO> getDeseadas() {
        return deseadas;
    }

    /**
     * Agrega una nueva mascota a la lista de deseadas.
     * @param deseadas Las mascotas que le interesan adquirir.
     */
    public void setDeseadas(List<MascotaDTO> deseadas) {
        this.deseadas = deseadas;
    }
    
    
   

    
            
    
}
