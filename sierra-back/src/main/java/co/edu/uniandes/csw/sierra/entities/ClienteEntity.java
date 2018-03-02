/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author de.gutierrez "Esteban Gutierrez"
 */
@Entity
public class ClienteEntity extends BaseEntity implements Serializable
{
    private String nombre; //Atributo que contiene el nombre de un cliente.
    private String apellido; //Atributo que contiene el apellido de un cliente.
    private Long cedula; //Atributo que contiene el numero de cedula del cliente.
    private Long telefono; // Atributo que contiene el numero telefonico del cliente.

    /**
     * Lista de las mascotas que deseadas por un cliente.
     */
    @PodamExclude
    @OneToMany(mappedBy="cliente", cascade = CascadeType.PERSIST)
    private List<MascotaEntity> mascotas = new ArrayList<>();
    
    /**
     * Lista de todas las adquisiciones de un cliente.
     */
    @PodamExclude
    @OneToMany(mappedBy="cliente", cascade = CascadeType.PERSIST)
    private List<AdquisicionEntity> adquisiciones = new ArrayList<>();
    
    /**
     * Lista de todos los medios de pago de un cliente.
     */
    @PodamExclude
    @OneToMany(mappedBy="cliente", cascade = CascadeType.PERSIST)
    private List<MedioDePagoEntity> mediosDePago = new ArrayList<>();
    
    /**
     * Metodo que obtiene el nombre de un cliente.
     * @return El nombre de un cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre a un cliente.
     * @param nombre Nuevo nombre de un cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de un cliente.
     * @return El apellido de un cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Asigna el nuevo apellido a un cliente.
     * @param apellido El nuevo apellido de un cliente.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el numero de cedula del cliente.
     * @return La cedula de un cliente.
     */
    public Long getCedula() {
        return cedula;
    }

    /**
     * Asigna el numero de cedula al cliente.
     * @param cedula Nuevo numero de cedula de un cliente.
     */
    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el numero telefonico del cliente.
     * @return El numero de telefono.
     */
    public Long getTelefono() {
        return telefono;
    }

    /**
     * Asigna un numero de telefono al cliente.
     * @param telefono El nuevo de telefono del cliente.
     */
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene todos animales que desea un cliente.
     * @return Lista de las mascotas deseadas.
     */
    public List<MascotaEntity> getMascotas() {
        return mascotas;
    }

    /**
     * Asigna mascotas que desea un cliente
     * @param mascotas Lista de las mascotas deseadas.
     */
    public void setMascotas(List<MascotaEntity> mascotas) {
        this.mascotas = mascotas;
    }

    /**
     * Obtiene todas las adquisiciones de un cliente.
     * @return Lista de las adquisiciones.
     */
    public List<AdquisicionEntity> getAdquisiciones() {
        return adquisiciones;
    }

    /**
     * Asigna adquisiciones a un cliente.
     * @param adquisiciones Lista de adquisiciones.
     */
    public void setAdquisiciones(List<AdquisicionEntity> adquisiciones) {
        this.adquisiciones = adquisiciones;
    }

    /**
     * Obtiene los medios de pago del cliente.
     * @return Lista de los medios de pago de un cliente.
     */
    public List<MedioDePagoEntity> getMediosDePago() {
        return mediosDePago;
    }

    /**
     * Asigna los medios de pago a un cliente.
     * @param mediosDePago Lista de los medios de pago.
     */
    public void setMediosDePago(List<MedioDePagoEntity> mediosDePago) {
        this.mediosDePago = mediosDePago;
    }   
}