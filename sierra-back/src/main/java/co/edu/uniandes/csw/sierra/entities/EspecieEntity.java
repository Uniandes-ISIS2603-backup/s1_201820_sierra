/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jc.sanchez12
 */
public class EspecieEntity extends BaseEntity implements Serializable
{
    //Atributos
      /**
     * nombre de la especie
     */
    private String nombre;
    /**
     * caracteristicas de la  especie
     */
    private String caracteristicas;
    
    /**
     * Clasificacion de la  especie
     */
    private String clasificacion;
    
    
    /**
     * Lista de mascotas que contiene una  especie
     */
    private List<MascotaEntity> mascotas;
 
    /**
     * Lista de razas que contiene una  especie
     */
    private List<RazaEntity> razas;

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
     * @return the caracteristicas
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * @param caracteristicas the caracteristicas to set
     */
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    /**
     * @return the clasificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * @return the mascotas
     */
    public List<MascotaEntity> getMascotas() {
        return mascotas;
    }

    /**
     * @param mascotas the mascotas to set
     */
    public void setMascotas(List<MascotaEntity> mascotas) {
        this.mascotas = mascotas;
    }

    /**
     * @return the razas
     */
    public List<RazaEntity> getRazas() {
        return razas;
    }

    /**
     * @param razas the razas to set
     */
    public void setRazas(List<RazaEntity> razas) {
        this.razas = razas;
    }
    
    
    
}
