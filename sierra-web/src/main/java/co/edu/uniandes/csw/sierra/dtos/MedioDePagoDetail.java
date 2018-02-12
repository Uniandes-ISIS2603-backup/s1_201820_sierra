/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

/**
 *
 * @author de.gutierrez
 */
public class MedioDePagoDetail
{
    private ClienteDTO cliente;
    
    /**
     * Constructor por defecto.
     */
    public MedioDePagoDetail()
    {
        
    }
    
    /**
     * Obtiene la informacion del cliente que selecciona un medio de pago.
     * @return El cliente que selecciono un medio de pago.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Asigna un cliente que desea seleccionar un medio de pago.
     * @param cliente El nuevo cliente.
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
        
}
