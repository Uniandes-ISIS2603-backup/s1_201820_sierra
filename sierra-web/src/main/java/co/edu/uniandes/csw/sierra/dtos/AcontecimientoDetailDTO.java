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
 },
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
