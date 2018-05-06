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

import co.edu.uniandes.csw.sierra.podam.DateStrategy;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author jc.sanchez12
 */
//Se quita MappedSuperclass para que compilen los tests, falta revisar 
//como es la implementación correcta
//@MappedSuperclass
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
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
    private Integer edad;
    
    /**
     * color de la  mascota
     */
    private String color;
    
    /**
     * verificacion si la mascota es esteril
     */
    private Boolean esteril;
    
    /**
     * verificacion si esta  adquirida la mascota
     */
    private Boolean adquirido;
    
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
    @PodamStrategyValue(DateStrategy.class)
    private Date nacimiento;
   
    /**
     * Especie  de la mascota
     */
    @PodamExclude
    @ManyToOne
    private EspecieEntity especie;

    /**
     * Ciente  de la  mascota
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
    
    /**
     * Adquisicion a la que  esta  ligada la mascota
     */
    @PodamExclude
    @OneToOne(mappedBy= "mascota",cascade = CascadeType.PERSIST)
    private AdquisicionEntity adquisicion;
    
    /**
     * Raza de la  mascota
     */
    @PodamExclude
    @ManyToOne
    private RazaEntity raza;
    
    /**
     * Publicaciones de una  mascota
     */
    @PodamExclude
    @OneToMany(mappedBy="mascota",cascade = CascadeType.PERSIST)
    private List<PublicacionEntity> publicaciones;
 
    /**
     * Obtiene el nombre de la mascota.
     * @return the nombre de la mascota.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre a la mascota.
     * @param nombre the nombre por asignarle a la mascota.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el genero de la mascota.
     * @return the genero de una mascota.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Asigna el genero de la mascota.
     * @param genero the genero de una mascota.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la edad de la mascota.
     * @return the edad de una mascota.
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Asigna la edad a la mascota.
     * @param edad the edad por asignar a una mascota.
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el color de la mascota.
     * @return the color de la mascota.
     */
    public String getColor() {
        return color;
    }

    /**
     * Asigna el color a una mascota.
     * @param color the color por asignarle a una mascota.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene si la mascota esta esterilizada o no.
     * @return the esteril true si esta esterizada o false sino lo esta.
     */
    public Boolean isEsteril() {
        return esteril;
    }

    /**
     * Asigna a la mascota si esta o no esterilizada.
     * @param esteril the esteril si esta o no esterilizada.
     */
    public void setEsteril(Boolean esteril) {
        this.esteril = esteril;
    }

    /**
     * Obtiene el estado de adquisicion de la mascota.
     * @return the adquirida si esta o no adquirida la mascota.
     */
    public Boolean isAdquirido() {
        return adquirido;
    }

    /**
     * Asigna el estado a la mascota si esta o no adquirido.
     * @param adquirido the adquirida si esta o no adquirida.
     */
    public void setAdquirido(Boolean adquirido) {
        this.adquirido = adquirido;
    }

    /**
     * Obtiene la imagen de la mascota.
     * @return the imagen url de la mascota.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Asigna la  url de la imagen de la mascota.
     * @param imagen the imagen de la mascota.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene el tamaño de la mascota.
     * @return the tamano de la mascota.
     */
    public String getTamano() {
        return tamano;
    }

    /**
     * Asigna el tamaño a una mascota.
     * @param tamano the tamano de una mascota.
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    /**
     * Obtiene el formato de la fecha de nacimiento de la mascota.
     * @return the nacimiento de la mascota.
     */
    @SuppressWarnings("deprecation")
    public  String  getNacimientoFecha() {
       return nacimiento.getDay()+"/"+nacimiento.getMonth()+"/"+ nacimiento.getYear();
    }

    /**
     * Obtiene la fecha de nacimiento de una mascota.
     * @return the nacimiento de la mascota.
     */
    public  Date  getNacimiento() {
       return nacimiento;
    }
    
    /**
     * Asigna la fecha de nacimiento a una mascota.
     * @param nacimiento la fecha de nacimiento de una mascota.
     */
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    
    /**
     * Obtiene la especie de la mascota.
     * @return the especie de la mascota.
     */
    public EspecieEntity getEspecie() {
        return especie;
    }

    /**
     * Asigna la especie de una mascota.
     * @param especie the especie de una mascota.
     */
    public void setEspecie(EspecieEntity especie) {
        this.especie = especie;
    }

    /**
     * Obtiene el cliente dueño de la mascota.
     * @return the cliente dueño de la mascota.
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * Asigna el cliente que es dueno de una mascota.
     * @param cliente the cliente nuevo dueno de la mascota.
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la adquisicion a la que pertenece la mascota.
     * @return the adquisicion de mascota.
     */
    public AdquisicionEntity getAdquisicion() {
        return adquisicion;
    }

    /**
     * Asigna la adquisicion de una mascota.
     * @param adquisicion the adquisicion de una mascota.
     */
    public void setAdquisicion(AdquisicionEntity adquisicion) {
        this.adquisicion = adquisicion;
    }

    /**
     * Obtiene la raza de la mascota.
     * @return the raza de la mascota.
     */
    public RazaEntity getRaza() {
        return raza;
    }

    /**
     * Asigna la raza de una mascota.
     * @param raza the raza de una mascota.
     */
    public void setRaza(RazaEntity raza) {
        this.raza = raza;
    }

    /**
     * Obtiene las publicacion realidas a la mascota.
     * @return the publicaciones de la mascota.
     */
    public List<PublicacionEntity> getPublicaciones() {
        return publicaciones;
    }

    /**
     * Asigna publicaciones a una mascota.
     * @param publicaciones the publicaciones de una mascota.
     */
    public void setPublicaciones(List<PublicacionEntity> publicaciones) {
        this.publicaciones = publicaciones;
    }   
}
