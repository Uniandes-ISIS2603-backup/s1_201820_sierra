/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;
/**
 * ClienteDTO Objeto de transferencia  de datos de la entidad Cliente. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguienta modelo:<br>
 * <pre>
 *  {
 * "name": string,
 * "apellido": string,
 * "cedula": number,
 * "id": number,
 * "telefono": number
 *  }
 * </pre>
 * Por ejemplo una entidad Cliente se representa asi:<br>
 * <p>
 * <pre>
 *  {
 * "name": "Andres",
 * "apellido": "Castro",
 * "cedula": 1072548232,
 * "id": 001,
 * "telefono": 3182564852
 *   }
 * </pre>
 *
 * @author de.gutierrez
 */
public class ClienteDTO
{
    private String nombre;
    private String apellido;
    private Long cedula;
    private Long id;  
    private Long telefono;
    
    /**
     * Constructor por defecto.
     */
    public ClienteDTO()
    {
        
    }

    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del cliente.
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del cliente.
     * @return EL apellido del cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Asigna el apellido al cliente.
     * @param apellido Nuevo apellido.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /**
     * Ontiene la cedula del cliente.
     * @return La cedula del cliente.
     */
    public Long  getCedula() {
        return cedula;
    }
    
    /**
     * Asigna la cedula al cliente.
     * @param cedula La nueva cedula.
     */
    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }
    
    /**
     * Obtiene el id del cliente.
     * @return El id del cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el id al cliente.
     * @param id El nuevo id.
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Obtiene el telefono del cliente.
     * @return El telefono del cliente.
     */
    public Long getTelefono() {
        return telefono;
    }

    /*
     * Asigna el telefono al cliente.
     * @param telefono El nuevo telefono.
     */
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
}