/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.MascotaEntity;
import co.edu.uniandes.csw.sierra.entities.PublicacionEntity;

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
 *  *  </pre> Por ejemplo una entidad Medio de pago se representa asi:<br>
 * <p>
 * <
 * pre>
 * {
 * "id":01 ,
 * "nombre": "Mi primer juguete",
 * "comentario": "Mis dueños me han comprado mi primer juguete."
 * "fecha": "20/06/2014",
 * "tipo": "Feliz",
 * "fotoURL": "data/imagen_Lemon_primer_juguete",
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
 * }
 *  </pre>
 * @author Ja.penat
 **/
public class PublicacionDetailDTO extends PublicacionDTO{
    
    private MascotaDTO mascota;
    
    public PublicacionDetailDTO(){
        super();
    }
    
    /**
     * Crea un objeto PublicacionDetailDTO a partir de un objeto
     * PublicacionEntity incluyendo los atributos de MascotaDTO.
     * @param entity Entidad PublicacionEntity desde la cual se va a crear
     * el nuevo objeto.
     */
    public PublicacionDetailDTO(PublicacionEntity entity) {
        super(entity);
        if (entity != null)
          {
            if (entity.getMascota() != null) {
               this.mascota = new MascotaDTO(entity.getMascota());
            } else {
                entity.setMascota(null);
            }
    }
    }
     /**
     * Transformar el DTO a una entidad
     * @return 
     */
    @Override
    public PublicacionEntity toEntity()
    {
       PublicacionEntity publicacion = super.toEntity();
        if (this.getMascota() != null)
        {
  //          MascotaEntity nuevo = null ;
    //Problemas con el to entity de mascotaDto        publicacion.setMascota(this.getMascota().toEntity(nuevo));
        }
        return publicacion;
    }
     /**
     * @return the mascota
     */
    public MascotaDTO getMascota() {
        return mascota;
    }

    /**
     * @param mascota the mascota to set
     */
    public void setMascota(MascotaDTO mascota) {
        this.mascota = mascota;
    }
}
