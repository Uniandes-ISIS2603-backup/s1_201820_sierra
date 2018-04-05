/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

/**
 * AcontecimientoDTO es el objeto de transferencia de datos detallada de la entidad Acontecimiento.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 * {
 * "id":number,
 * "nombre": String,
 * "descripcion":String,
 * "fecha":Date,
 * "importancia":number,
 * "tipo": String,
 * "fotoURL":String,
 * "mascota":{
 *          "id": number,
 *          "name: String,
 *          "genero": String
 *          "edad": number,
 *          "color": String,
 *          "esteril":boolean,
 *          "adquirido":boolean,
 *          "imagen":String,
 *          "tamano":String,
 *          "nacimiento": Date,
 *          "muerte": Date
 *      }
 *  </pre> Por ejemplo una entidad Medio de pago se representa asi:<br>
 * <p>
 * <
 * pre>
 * {
 * "id":01 ,
 * "nombre": "Mi primer baño",
 * "descripcion": "De visita al veterinario debido a las pulgas he recibido un baño."
 * "fecha": "20/05/2014",
 * "importancia": 01,
 * "tipo": "Primera vez",
 * "fotoURL": "data/imagen_Lemon_primer_baño",
 * "mascota":{
 *          "id": 02,
 *          "name: "Lemon",
 *          "genero": "Macho"
 *          "edad": 05,
 *          "color": "Blanco con gris",
 *          "esteril": true ,
 *          "adquirido": true,
 *          "imagen": "data/imagen_Lemon",
 *          "tamano":"Pequeño",
 *          "nacimiento": "20/08/2016",
 *          "muerte": null,
 * }
 *  </pre>
 * @author Ja.penat
 **/
public class AcontecimientoDetailDTO extends AcontecimientoDTO {
    
    private MascotaDTO mascota;
    
    public AcontecimientoDetailDTO()
    {
        super(); 
 
    }
     /**
     * @return the mascota
     */
    public MascotaDTO getMascota() 
    {
        return mascota;
    }

    /**
     * @param mascota the mascota to set
     */
    public void setMascota(MascotaDTO mascota)
    {
        this.mascota = mascota;
    }
    
       //TODO: Falta el constructor que recibve un entity y falta el método toEntity 
}
