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
 
    //--------------------ATRIBUTOS--------------//
    
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
    
    
    //---------------RELACIONES-------------------//
   
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

    
    //---------------METODOS---------------------//

    
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
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(Integer edad) {
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
    public Boolean isEsteril() {
        return esteril;
    }

    /**
     * @param esteril the esteril to set
     */
    public void setEsteril(Boolean esteril) {
        this.esteril = esteril;
    }

    /**
     * @return the adquirida
     */
    public Boolean isAdquirido() {
        return adquirido;
    }

    /**
     * @param adquirido the adquirida to set
     */
    public void setAdquirido(Boolean adquirido) {
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

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the adquisicion
     */
    public AdquisicionEntity getAdquisicion() {
        return adquisicion;
    }

    /**
     * @param adquisicion the adquisicion to set
     */
    public void setAdquisicion(AdquisicionEntity adquisicion) {
        this.adquisicion = adquisicion;
    }

    /**
     * @return the raza
     */
    public RazaEntity getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(RazaEntity raza) {
        this.raza = raza;
    }

    /**
     * @return the publicaciones
     */
    public List<PublicacionEntity> getPublicaciones() {
        return publicaciones;
    }

    /**
     * @param publicaciones the publicaciones to set
     */
    public void setPublicaciones(List<PublicacionEntity> publicaciones) {
        this.publicaciones = publicaciones;
    }
    
}
