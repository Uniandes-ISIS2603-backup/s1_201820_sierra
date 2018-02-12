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

/**
 * EspecieDTO Objeto de transferencia de datos de la entidad de Especie. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
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
 * </pre>
 * Por ejemplo una entidad de Especie se representa asi:<br>
 * <p>
 * <pre>
 *
 *   {
 *      "id": 1,
 *      "nombre": "Lobo Siberiano",
 *      "caracteristicas": "Perros  similares a los lobos, pelo blanco,negro  o cafe  con una combinacion de color", 
 *      "clasificacion": "perro"
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
     * caracteristicas de la  especie
     */
    private String caracteristicas;
    
    /**
     * Clasificacion de la  especie
     */
    private String clasificacion;
    
    /**
     * id  de la  especie
     */
    private int  id;
    
      /**
   *Constructor por defecto
   */
   public EspecieDTO()
   {
        //Constructor por defecto
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
    public String getCalificacion() {
        return clasificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(String calificacion) {
        this.clasificacion = calificacion;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
   
   
   
    
}
