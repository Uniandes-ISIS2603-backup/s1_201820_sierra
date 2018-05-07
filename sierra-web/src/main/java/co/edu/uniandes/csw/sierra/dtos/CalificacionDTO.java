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

import co.edu.uniandes.csw.sierra.entities.CalificacionEntity;

/**
 * CalificacionDTO es el objeto de transferencia de datos de la entidad
 * Calificacion.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 *  {
 *      "id":number,
 *      "comentarios":string,
 *      "valor":number,
 *      "sugerencia":string
 *  }
 * </pre> * Por ejemplo, una Calificacion se representaria de la siguiente
 * manera:<br>
 * <p>
 * <
 * pre>
 *  {
 *      "id":5,
 *      "comentarios":"muy buenna pagina, to do funciona super bien y fue muy buena la experiencia",
 *      "valor":20000,
 *      "sugerencia":"You don't mess with perfection"
 *  }
 * </pre>
 *
 * @author Juan David Zambrano
 */
public class CalificacionDTO {

    private Long id;

    private String comentarios;

    private Double valor;

    private String sugerencia;

    public CalificacionDTO() {
        //Constructor por defecto
    }

    /**
     * Constructor que convierte una entity a un DTO
     *
     * @param ent
     */
    public CalificacionDTO(CalificacionEntity ent) {
        if (ent != null) {
            this.id = ent.getId();
            this.comentarios = ent.getComentarios();
            this.valor = ent.getValor();
            this.sugerencia = ent.getSugerencia();
        }
    }

    /**
     * Metodo que convierte un DTO a un Entity
     *
     * @return la entidad creada
     */
    public CalificacionEntity toEntity() {
        CalificacionEntity ent = new CalificacionEntity();
        ent.setId(id);
        ent.setComentarios(comentarios);
        ent.setValor(valor);
        ent.setSugerencia(sugerencia);
        return ent;
    }

    /**
     * @return the id
     */
    public Long getID() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setID(Long id) {
        this.id = id;
    }

    /**
     * @return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the sugerencia
     */
    public String getSugerencia() {
        return sugerencia;
    }

    /**
     * @param sugerencia the sugerencia to set
     */
    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

}
