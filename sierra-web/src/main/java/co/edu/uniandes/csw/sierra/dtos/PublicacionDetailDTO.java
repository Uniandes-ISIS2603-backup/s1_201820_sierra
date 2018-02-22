/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

/**
 * PublicacionDTO es el objeto de transferencia de datos detallada de la entidad Publicacion.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 * {
 * "id": number,
 * "comentario": String,
 * "fecha": Date,
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
public class PublicacionDetailDTO extends PublicacionDTO{
    
    private MascotaAdoptadaDTO mascota;
    
    public PublicacionDetailDTO(){
        super();
    }
     /**
     * @return the mascota
     */
    public MascotaAdoptadaDTO getMascota() {
        return mascota;
    }

    /**
     * @param mascota the mascota to set
     */
    public void setMascota(MascotaAdoptadaDTO mascota) {
        this.mascota = mascota;
    }
}
