/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.ClienteEntity;

/**
 * ClienteDTO Objeto de transferencia de datos de la entidad Cliente. Los DTO
 * contienen las representaciones de los JSON que se transfieren entre el
 * cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguienta modelo:<br>
 * <pre>
 *  {
 * "nombre": string,
 * "apellido": string,
 * "cedula": number,
 * "id": number,
 * "telefono": number,
 * "correo":string,
 * "contrasenia":string
 *  }
 * </pre> Por ejemplo una entidad Cliente se representa asi:<br>
 * <p>
 * <
 * pre>
 *  {
 * "name": "Andres",
 * "apellido": "Castro",
 * "cedula": 1072548232,
 * "id": 001,
 * "telefono": 3182564852,
 * "correo": "andresCastro@gmail.com",
 * "contrasenia": "123456789"
 *   }
 * </pre>
 *
 * @author de.gutierrez
 */
public class ClienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private Long cedula;
    private Long telefono;
    private String correo;
    private String contrasenia;

    /**
     * Constructor por defecto.
     */
    public ClienteDTO() {

    }

    /**
     * Crea un objeto ClienteDTO a partir de un objeto ClienteEntity
     *
     * @param entity Entidad ClienteEntity desde la cual se va a crear el nuevo
     */
    public ClienteDTO(ClienteEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.nombre = entity.getNombre();
            this.apellido = entity.getApellido();
            this.cedula = entity.getCedula();
            this.telefono = entity.getTelefono();
            this.correo = entity.getCorreo();
            this.contrasenia = entity.getContrasenia();
        }
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public ClienteEntity toEntity() {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setApellido(this.apellido);
        entity.setCedula(this.cedula);
        entity.setTelefono(this.telefono);
        entity.setCorreo(this.correo);
        entity.setContrasenia(this.contrasenia);
        return entity;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del cliente.
     *
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del cliente.
     *
     * @return EL apellido del cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Asigna el apellido al cliente.
     *
     * @param apellido Nuevo apellido.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Ontiene la cedula del cliente.
     *
     * @return La cedula del cliente.
     */
    public Long getCedula() {
        return cedula;
    }

    /**
     * Asigna la cedula al cliente.
     *
     * @param cedula La nueva cedula.
     */
    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    
    /**
     * Obtiene el id del cliente.
     *
     * @return El id del cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el id al cliente.
     *
     * @param id El nuevo id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el telefono del cliente.
     *
     * @return El telefono del cliente.
     */
    public Long getTelefono() {
        return telefono;
    }

    /**
     * Asigna el telefono al cliente.
     * @param telefono El nuevo telefono.
     */
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electronico del cliente.
     * @return El telefono del cliente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Asigna el correo electronico al cliente.
     * @param correo El nuevo telefono.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contrasenia del cliente.
     * @return La contrasenia del cliente.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Asigna la contrasenia al cliente.
     * @param contrasenia La nueva contrasenia del cliente.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
}
