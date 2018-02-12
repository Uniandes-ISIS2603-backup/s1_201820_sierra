/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

/**
 * CalificacionDTO es el objeto de transferencia de datos de la entidad Calificacion.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 *  {
 *      "id":number,
 *      "comentarios":string,
 *      "valor":number,
 *      "sugerencia":string
 *  }
 * </pre>
 * * Por ejemplo, una Calificacion se representaria de la siguiente manera:<br>
 * <p>
 * <pre>
 *  {
 *      "id":5,
 *      "comentarios":"muy buenna pagina, todo funciona super bien y fue muy buena la experiencia",
 *      "valor":20000,
 *      "sugerencia":"You don't mess with perfection"
 *  }
 * </pre>
 * @author Juan David Zambrano
 */
public class CalificacionDTO {
    
    private Long id;
    
    private String comentarios;
    
    private Double valor;
    
    private String sugerencia;

    /**
     * @return the ID
     */
    public Long getID() {
        return id;
    }

    /**
     * @param ID the ID to set
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
