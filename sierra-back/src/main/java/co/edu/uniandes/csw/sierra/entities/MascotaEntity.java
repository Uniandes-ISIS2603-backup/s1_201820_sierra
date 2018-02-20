/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 *
 * @author jc.sanchez12
 */
@MappedSuperclass
public abstract class MascotaEntity extends BaseEntity
{
    
    /**
     * Codigo serializable por SA
     */
    private static final long serialVersionUID = 1L;
    
    
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
    private boolean adquirido;
    
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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nacimiento;
    
     /**
     * Fecha dela muerte de la amscota
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date muerte;
    

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
    public boolean isAdquirido() {
        return adquirido;
    }

    /**
     * @param adquirido the adquirida to set
     */
    public void setAdquirido(boolean adquirido) {
        this.adquirido = adquirido;
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
    @SuppressWarnings("deprecation")
    public  String  getNacimientoFecha() {
       return nacimiento.getDay()+"/"+nacimiento.getMonth()+"/"+ nacimiento.getYear();
    }

    /**
     * @return the nacimiento
     */
    public  Date  getNacimiento() {
       return nacimiento;
    }
    
    /**
     * @param nacimiento the nacimiento to set
     */
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * 
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
    
}
