/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jc.sanchez12
 */
public class MascotaEntity extends BaseEntity implements Serializable
{
    //Atributos
    
     /**
     * nombre de la  mascota
     */
    private String nombre;
    
    /**
     * apellido de la  mascota
     */
    private String genero;
    
    /**
     * edad de la mascota
     */
    private int edad;
    
    /**
     * color de la  mascota
     */
    private String color;
    
    /**
     * verificacion si la mascota es esteril
     */
    private boolean esteril;
    
    /**
     * verificacion si esta  adquirida la mascota
     */
    private boolean adquirida;
    
    /**
     * imagen de la mascota
     */
    private String  imagen;
    
    /**
     * tamano  de la mascota
     */
    private String tamano;
    
    /**
     * Fecha de la  nacimiento de la amscota
     */
    private Date nacimiento;
    
     /**
     * Fecha dela muerte de la amscota
     */
    private Date muerte;
    
     /**
     * Especie de la mascota
     */
    private EspecieEntity especie;
    
    /**
     * Raza de la  mascota
     */
    private RazaEntity raza;
    
    /**
     * Publicaciones de la mascota
     */
     private List<PublicacionEntity> publicaciones;
     
     /**
      *  Adquisiciones de a mascota
      */
      private List<AdquisicionEntity> adquisiciones;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the esteril
     */
    public boolean isEsteril() {
        return esteril;
    }

    /**
     * @param esteril the esteril to set
     */
    public void setEsteril(boolean esteril) {
        this.esteril = esteril;
    }

    /**
     * @return the adquirida
     */
    public boolean isAdquirida() {
        return adquirida;
    }

    /**
     * @param adquirida the adquirida to set
     */
    public void setAdquirida(boolean adquirida) {
        this.adquirida = adquirida;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the tamano
     */
    public String getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    /**
     * @return the nacimiento
     */
    public Date getNacimiento() {
        return nacimiento;
    }

    /**
     * @param nacimiento the nacimiento to set
     */
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * @return the muerte
     */
    public Date getMuerte() {
        return muerte;
    }

    /**
     * @param muerte the muerte to set
     */
    public void setMuerte(Date muerte) {
        this.muerte = muerte;
    }

    /**
     * @return the especie
     */
    public EspecieEntity getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(EspecieEntity especie) {
        this.especie = especie;
    }

    /**
     * @return the raza
     */
    public RazaEntity getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(RazaEntity raza) {
        this.raza = raza;
    }

    /**
     * @return the publicaciones
     */
    public List<PublicacionEntity> getPublicaciones() {
        return publicaciones;
    }

    /**
     * @param publicaciones the publicaciones to set
     */
    public void setPublicaciones(List<PublicacionEntity> publicaciones) {
        this.publicaciones = publicaciones;
    }

    /**
     * @return the adquisiciones
     */
    public List<AdquisicionEntity> getAdquisiciones() {
        return adquisiciones;
    }

    /**
     * @param adquisiciones the adquisiciones to set
     */
    public void setAdquisiciones(List<AdquisicionEntity> adquisiciones) {
        this.adquisiciones = adquisiciones;
    }
      
      
      
}
