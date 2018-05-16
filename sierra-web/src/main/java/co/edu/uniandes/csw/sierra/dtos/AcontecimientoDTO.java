/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.AcontecimientoEntity;
import java.util.Date;

/**
 *
 * @author ja.penat
 */
public class AcontecimientoDTO {

    private Long id;

    private String nombre;

    private String descripcion;

    private Date fecha;

    private Integer importancia;

    private String tipo;

    private String fotoURL;

    public AcontecimientoDTO() 
    { //Método constructor por Defecto.
    }

    public AcontecimientoDTO(AcontecimientoEntity entity)
    { 
       if(entity != null)
       {
        this.descripcion = entity.getDescripcion();
        this.fecha = entity.getFecha();
        this.fotoURL = entity.getFotoURL();
        this.id = entity.getId();
        this.tipo = entity.getTipo();
        this.nombre = entity.getNombre();
        this.importancia = entity.getImportancia();
    }
    }

    public AcontecimientoEntity toEntity() {
        AcontecimientoEntity entity = new AcontecimientoEntity();
        entity.setFecha(fecha);
        entity.setTipo(tipo);
        entity.setDescripcion(descripcion);
        entity.setFotoURL(fotoURL);
        entity.setId(id);
        entity.setImportancia(importancia);
        entity.setNombre(nombre);

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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    /**
     * @return the importancia
     */
    public int getImportancia() {
        return importancia;
    }

    /**
     * @param importancia the importancia to set
     */
    public void setImportancia(int importancia) {
        this.importancia = importancia;
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

}
