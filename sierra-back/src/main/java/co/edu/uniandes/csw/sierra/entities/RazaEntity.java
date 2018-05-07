/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jc.sanchez12
 */
@Entity
public class RazaEntity extends BaseEntity implements Serializable {

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

    private static final long serialVersionUID = 1L;
    //nombre de la raza a la que corresponde el animal
    private String nombreRaza;
    // cuidados que se deben tener con la raza 
    private String cuidados;
    //información que vale la pena resaltar de la raza
    private String destacable;
    //caracteristicas de la raza
    private String caracteristicas;
    
    //Asociaciones, lo hace Juan zambrano porque Rodrigo esta incapacitado
    @OneToMany(mappedBy = "raza", cascade = CascadeType.PERSIST)
    @PodamExclude
    private List<MascotaEntity> mascotas;
    
    @ManyToOne
    @PodamExclude
    private EspecieEntity especie;

    /**
     * Obtiene el nombre de la raza.
     * @return Nombre de un araza.
     */
    public String getNombreRaza() {
        return nombreRaza;
    }

    /**
     * Asigana el nombre a una raza.
     * @param nombreRaza Nuevo nombre de una raza.
     */
    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    /**
     * Obtiene los cuidados que se deben tener de una mascota.
     * @return Los cuidados necesarios de una mascota.
     */
    public String getCuidados() {
        return cuidados;
    }

    /**
     * Asigan los cuidados que se deben tener para una mascota.
     * @param cuidados Los cuidados definidos para una mascota.
     */
    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
    }
    
    /**
     * Obtiene aspectos destacables a resaltar de la mascotas.
     * @return Lo destacable de cada raza.
     */
    public String getDestacable() {
        return destacable;
    }

    /**
     * Asigna los aspectos destables de una mascota.
     * @param destacable Aspectos destacables de una raza.
     */
    public void setDestacable(String destacable) {
        this.destacable = destacable;
    }

    /**
     * Obtiene las caracteristicas de la mascota.
     * @return Caracteristicas de una mascota.
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * Asigna las caracteristicas de una mascota.
     * @param caracteristicas Nuevas caracteristicas de una mascota.
     */
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }  
}
