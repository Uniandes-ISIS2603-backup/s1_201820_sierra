/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.io.Serializable;
import java.util.Date;

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
    
    
}
