/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import java.util.Date;

/**
 * * MascotaAdopcionDTO Objeto de transferencia de datos de la entidad de
 * MascotaAdopcion. Los DTO contienen las represnetaciones de los JSON que se
 * transfieren entre el cliente y el servidor.
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
 *   }
 * </pre> Por ejemplo una entidad de Mascota se representa asi:<br>
 * <p>
 * <
 * pre>
 *
 *   {
 *      "id": 31,
 *      "name: "Ircops",
 *      "edad": 2,
 *      "color":"negro",
 *      "esteril":true,
 *      "adquirido":false,
 *      "imagen":"perritolindo.jpg"
 *      "tamano":"Grande",
 *      "nacimiento": 03/10/2016,
 *   
 *   }
 *
 * </pre>
 *
 * @author Juan Camilo Sanchez
 */
public class MascotaAdopcionDTO
{

    /**
     * Id
     */
    private Long id;

    /**
     * nombre de la mascota
     */
    private String nombre;

    /**
     * apellido de la mascota
     */
    private String genero;

    /**
     * edad de la mascota
     */
    private Integer edad;

    /**
     * color de la mascota
     */
    private String color;

    /**
     * verificacion si la mascota es esteril
     */
    private Boolean esteril;

    /**
     * verificacion si esta adquirida la mascota
     */
    private Boolean adquirido;

    /**
     * imagen de la mascota
     */
    private String imagen;

    /**
     * tamano de la mascota
     */
    private String tamano;

    /**
     * Fecha de la nacimiento de la amscota
     */
    private Date nacimiento;


    /**
     * Constructor por defecto
     */
    public MascotaAdopcionDTO() {
        //Constructor por defecto
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param mascotaAdoptadaEntity: Es la entidad que se va a convertir a DTO
     */
    public MascotaAdopcionDTO(MascotaAdoptadaEntity mascotaAdoptadaEntity) {
        if (mascotaAdoptadaEntity!=null) {
         this.id = mascotaAdoptadaEntity.getId();
        this.nombre = mascotaAdoptadaEntity.getNombre();
        this.genero = mascotaAdoptadaEntity.getGenero();
        this.edad = mascotaAdoptadaEntity.getEdad();
        this.color = mascotaAdoptadaEntity.getColor();
        this.esteril = mascotaAdoptadaEntity.isEsteril();
        this.adquirido = mascotaAdoptadaEntity.isAdquirido();
        this.imagen = mascotaAdoptadaEntity.getImagen();
        this.tamano = mascotaAdoptadaEntity.getTamano();
        this.nacimiento = mascotaAdoptadaEntity.getNacimiento();
        }

    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @return MascotaAdoptadaEntity: Es la entidad que se va a convertir a DTO
     */
    
    public MascotaAdoptadaEntity toEntity() {
        MascotaAdoptadaEntity entity = new MascotaAdoptadaEntity();
        entity.setNombre(nombre);
        entity.setId(id);
        entity.setAdquirido(adquirido);
        entity.setGenero(genero);
        entity.setEdad(edad);
        entity.setColor(color);
        entity.setEsteril(esteril);
        entity.setImagen(imagen);
        entity.setTamano(tamano);
        entity.setNacimiento(nacimiento);
        return entity;
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
    public Boolean getEsteril() {
        return esteril;
    }

    /**
     * @param esteril the esteril to set
     */
    public void setEsteril(Boolean esteril) {
        this.esteril = esteril;
    }

    /**
     * @return the adquirido
     */
    public Boolean getAdquirido() {
        return adquirido;
    }

    /**
     * @param adquirido the adquirido to set
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
    public Date getNacimiento() {
        return nacimiento;
    }

    /**
     * @param nacimiento the nacimiento to set
     */
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }    
}
