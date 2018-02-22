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
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

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
     * Lista de mascotas que contiene la especie
     */
    @PodamExclude
    @OneToMany
    private List<MascotaEntity> mascotas;

    /**
     * Lista de  razas que contiene  la especie
     */
    @PodamExclude
    @OneToMany
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
