/*
MIT License
Copyright (c) 2017 ISIS2603
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.EspecieEntity;

/**
 * EspecieDTO Objeto de transferencia de datos de la entidad de Especie. Los DTO
 * contienen las represnetaciones de los JSON que se transfieren entre el
 * cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombre": String,
 *      "caracteristicas": String,
 *      "clasificacion": String
 *
 *   }
 * </pre> Por ejemplo una entidad de Especie se representa asi:<br>
 * <p>
 * <
 * pre>
 *
 *   {
 *      "id": 1,
 *      "nombre": "Mamifero",
 *      "caracteristicas": " similares a los lobos, pelo blanco,negro  o cafe  con una combinacion de color",
 *      "clasificacion": "Canino"
 *   }
 *
 * </pre>
 *
 * @author jc.sanchez12
 */
public class EspecieDTO {

    /**
     * nombre de la especie
     */
    private String nombre;
    /**
     * caracteristicas de la especie
     */
    private String caracteristicas;

    /**
     * Clasificacion de la especie
     */
    private String clasificacion;

    /**
     * id de la especie
     */
    private Long id;

    /**
     * Constructor por defecto
     */
    public EspecieDTO() {
        //Constructor por defecto
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param especieEntity: Es la entidad que se va a convertir a DTO
     */
    public EspecieDTO(EspecieEntity especieEntity) {   //TODO: especieEntity puede ser null
        this.id = especieEntity.getId();
        this.nombre = especieEntity.getNombre();
        this.clasificacion = especieEntity.getClasificacion();
        this.caracteristicas = especieEntity.getCaracteristicas();

    }

    /**
     * Convertir un DTO a Entity
     *
     * @return especieEntity es a entidad que se crea a partir de DTO
     */
    public EspecieEntity toEntity() {
        EspecieEntity entity = new EspecieEntity();
        entity.setId(id);
        entity.setNombre(nombre);
        entity.setCaracteristicas(caracteristicas);
        entity.setClasificacion(clasificacion);
        return entity;
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
     * @return the caracteristicas
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * @param caracteristicas the caracteristicas to set
     */
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    /**
     * @return the calificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setClasificacion(String calificacion) {
        this.clasificacion = calificacion;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

}
