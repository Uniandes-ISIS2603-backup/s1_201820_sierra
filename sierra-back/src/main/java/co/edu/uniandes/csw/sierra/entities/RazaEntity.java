/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    @OneToMany(mappedBy = "raza")
    private List<MascotaEntity> mascotas;
    
    @ManyToOne
    private EspecieEntity especie;

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public String getCuidados() {
        return cuidados;
    }

    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
    }

    public String getDestacable() {
        return destacable;
    }

    public void setDestacable(String destacable) {
        this.destacable = destacable;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    
    
}
