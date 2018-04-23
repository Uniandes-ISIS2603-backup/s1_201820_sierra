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
public class MascotaAdopcionDTO extends  MascotaDTO
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
     * Fecha dela muerte de la amscota
     */
    private Date muerte;

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
        super(mascotaAdoptadaEntity);
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @return MascotaAdoptadaEntity: Es la entidad que se va a convertir a DTO
     */
    
    public MascotaAdoptadaEntity toEntity() {
        MascotaAdoptadaEntity entity = new MascotaAdoptadaEntity();
        super.toEntity(entity);
        return entity;
    }
}
