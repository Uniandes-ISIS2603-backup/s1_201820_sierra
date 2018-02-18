/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;

/**
 *
 * @author jc.sanchez12
 */
public class RazaEntity extends BaseEntity implements Serializable {
       //identificador numerico de la raza
    private Long id;
    //nombre de la raza a la que corresponde el animal
    private String nombreRaza;
    // cuidados que se deben tener con la raza 
    private String cuidados;
    //información que vale la pena resaltar de la raza
    private String destacable;
    //caracteristicas de la raza
    private String caracteristicas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
