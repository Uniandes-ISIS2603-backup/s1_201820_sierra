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

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * 
 * @author jc.sanchez12
 */
@Entity
public class EspecieEntity extends BaseEntity implements Serializable
{
    /**
     * Codigo serializable por SA
     */
    private static final long serialVersionUID = 1L;
    
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
     * Imagen de la especie
     */
    private String imagen;
    
    /**
     * Lista de razas de una especie
     */
    @OneToMany(mappedBy = "especie", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<RazaEntity> razas;
        
    /**
     * Lista de  mascotas que se pueden comprar de una especie
     
    @OneToMany(mappedBy = "especie",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<MascotaEntity>  mascotas;
    
    /**
     * Obtiene el nombre de la especie.
     * @return the nombre de la especie.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre a la especie.
     * @param nombre the nombre de la especie por asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obiene las caracteristicas de la especie. 
     * @return the caracteristicas de la especie.
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * Asigna las caracteristicas de la especie.
     * @param caracteristicas the caracteristicas por asignar a la especie.
     */
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    /**
     * Obtiene la clasificacion de la especie.
     * @return the clasificacion a la que pertenece la especie.
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * Asigna la clasificacion a la que pertenece la especie.
     * @param clasificacion the clasificacion a la que debe pertenecer la especie.
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * Obtiene la imagen que identifica a la especie.
     * @return  la imagen de la especie.
     */
    public String getImagen()
    {
        return imagen;
    }
    
    /**
     * Cambia la imagen por la entrada por parametro
     * @param imagen Nueva imagen de la especie.
     */
    public void setImagen(String imagen)
    {
        this.imagen=imagen;
    }
    
    /**
     * Obtiene todas las razas asociadas a una especie.
     * @return the razas que pertenecen a la especie.
     */
    public List<RazaEntity> getRazas() {
        return razas;
    }

    /**
     * Coleccion de razas por asignar a la especie.
     * @param razas the razas por asignar a una especie.
     */
    public void setRazas(List<RazaEntity> razas) {
        this.razas = razas;
    }

    /**
     * Obtiene las mascotas que pertenecen a la especie.
     * @return the mascotasVenta de la especie.
     
    public List<MascotaEntity> getMascotas() {
        return mascotas;
    }

    
     * Coleccion de mascotas por asignar a la especie.
     * @param mascotas Nuevas mascotas de una especie.
     
    public void setMascotaS(List<MascotaEntity> mascotas) {
        this.mascotas = mascotas;
    }   
    * */
}
