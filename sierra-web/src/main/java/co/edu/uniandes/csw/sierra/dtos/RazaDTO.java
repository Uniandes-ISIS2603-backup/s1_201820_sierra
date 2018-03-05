/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.RazaEntity;

/**
 *
 * RazaDTO Objeto de transferencia de datos de la entidad de certificado. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombreRaza": String,
 *      "cuidados": String
 *      "destacable": String,
 *      "caracteristicas": String,
 *   }
 * </pre>
 * Por ejemplo una entidad de Raza se representa asi:<br>
 * <p>
 * <pre>
 *
 *   {
 *     
 *      "id": 164613,
 *      "nombreRaza": "yorkshire",
 *      "cuidados": "concentrado razas pequeñas, paseos constantes, despues de los seis años ir al veterinario cada seis meses"
 *      "destacable": "raza preferible para apartamentos de pequeñas dimensiones, no son la mejor raza para los niños",
 *      "caracteristicas": "raza pequeña de pelo liso, tonalidad que combina negro, sorado y café, requieren una actividad física media",
 *   }
 *
 * </pre>
 *
 * @author rj.gonzalez10
 */
public class RazaDTO {
    //identificador numerico de la raza
    private Long id;
    //nombre de la raza a la que corresponde el animal
    private String nombreRaza;
    // cuidados que se deben tener con la raza 
    private String cuidados;
    //información que vale la pena resaltar de la raza
    private String destacable;
    //caracteristicas de la raza
    private String caracteristicas;
    
    
    public RazaDTO(){
        //constructor por defecto
    }
    public RazaDTO(RazaEntity razaEntity)
    {
        this.caracteristicas = razaEntity.getCaracteristicas();
        this.cuidados = razaEntity.getCuidados();
        this.destacable = razaEntity.getDestacable();
        this.id = razaEntity.getId();
        this.nombreRaza = razaEntity.getNombreRaza();
    }
    public RazaEntity toEntity(){
        RazaEntity entity = new RazaEntity();
        entity.setCaracteristicas(caracteristicas);
        entity.setCuidados(cuidados);
        entity.setDestacable(destacable);
        entity.setName(nombreRaza);
        entity.setId(Long.MIN_VALUE);
        
        return entity;
                

    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public String getCuidados() {
        return cuidados;
    }

    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
    }

    public String getDestacable() {
        return destacable;
    }

    public void setDestacable(String destacable) {
        this.destacable = destacable;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
