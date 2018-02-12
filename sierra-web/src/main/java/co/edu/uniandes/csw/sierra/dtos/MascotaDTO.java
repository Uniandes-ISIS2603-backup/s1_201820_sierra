/*
MIT License
Copyright (c) 2017 ISIS2603
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

package co.edu.uniandes.csw.sierra.dtos;

import java.util.Date;

/**
 * MascotaDTO Objeto de transferencia de datos de la entidad de Mascota. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "name: String,
 *      "genero": String
 *      "edad": number,
 *      "color": String,
 *      "esteril":boolean,
 *      "adquirido":boolean,
 *      "imagen":String,
 *      "tamano":String,
 *      "nacimiento": Date,
 *      "muerte": Date,
 *   }
 * </pre>
 * Por ejemplo una entidad de Mascota se representa asi:<br>
 * <p>
 * <pre>
 *
 *   {
 *      "id": 31,
 *      "name: "Ircops",
 *      "edad": 2,
 *      "color":"negro",
 *      "esteril":true,
 *      "adquirido":false,
 *      "imagen":"data:image/jpeg;base64,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",
 *      "tamano":"Grande",
 *      "nacimiento": 03/10/2016,
 *      "muerte": 
 *   }
 *
 * </pre>
 *
 * @author jc.sanchez12
 */
public class MascotaDTO 
{
     /**
    * Id 
    */
    private Long id;
    
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
   *Constructor por defecto
   */
   public MascotaDTO()
   {
        //Constructor por defecto
   }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * @param genero the apellido to set
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
   
 
   
}
