/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.PublicacionEntity;
import java.util.Date;

/**
 *
 * @author jd.zambrano
 */
public class PublicacionDTO {
    
    private Long id;
    
    private String comentario;
    
    private String fotoURL;
    
    private String tipo;
    
    private Date fecha;

    public PublicacionDTO( )
    {
       //Defecto
    } 
    
     public PublicacionDTO(PublicacionEntity Entity)
    {
        this.comentario = Entity.getComentario();
        this.fecha = Entity.getFecha();
        this.fotoURL = Entity.getFotoURL();
        this.id = Entity.getId();
        this.tipo = Entity.getTipo();
    } 
     
    public PublicacionEntity toEntity()
    {
        PublicacionEntity entity = new PublicacionEntity();
        entity.setFecha(fecha);
        entity.setTipo(tipo);
        entity.setComentario(comentario);
        entity.setFotoURL(fotoURL);
        entity.setId(id);
        
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
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the fotoURL
     */
    public String getFotoURL() {
        return fotoURL;
    }

    /**
     * @param fotoURL the fotoURL to set
     */
    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
