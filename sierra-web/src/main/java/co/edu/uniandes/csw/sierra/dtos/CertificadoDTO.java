/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.CertificadoEntity;
import java.util.Date;

/**
 *
 * CertificadoDTO Objeto de transferencia de datos de la entidad de certificado. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "fecha: Date,
 *      "descripción": String
 *      "imagen": String,
 *   }
 * </pre>
 * Por ejemplo una entidad de Certificado se representa asi:<br>
 * <p>
 * <pre>
 *
 *   {
 *     
 *      "id": 1231,
 *      "fecha: 28/02/2017,
 *      "descripción": "otorgado a la tercera camada de labradores cuyos progenitores fueron..."
 *      "imagen": "https://perrostiernos.com/labradores/cachorros.jpg",
 *   }
 *
 * </pre>
 *
 * @author rj.gonzalez10
 */
public class CertificadoDTO {
      //Identificador único del certificado
    private Long id;
    // fecha de expedisión del certicado
    private Date fecha;
    //String que contiene  la descripción del certificado de pureza del perro
    private String descripcion;
    // String que contiene el url de la imagen
    private String imagen;
    
    
    public CertificadoDTO(){
        //constructor por default
    }
    public CertificadoDTO(CertificadoEntity entity)
    {
        this.fecha = entity.getFecha();
        this.descripcion = entity.getDescripcion();
        this.imagen = entity.getImagen();
        this.id = entity.getId();
    }
    
    public CertificadoEntity toEntity()
    {
        CertificadoEntity entity = new CertificadoEntity();
         entity.setFecha(fecha);
         entity.setDescripcion(descripcion);
         entity.setImagen(imagen);
         entity.setId(id);
        
        
        return entity;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
    
    
    
    
}
