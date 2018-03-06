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

import java.util.Date;
import co.edu.uniandes.csw.sierra.entities.AdquisicionEntity;

/**
 * AdquisicionDTO es el objeto de transferencia de datos de la entidad
 * Adquisicion.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 *  {
 *      "id":number,
 *      "valorTotal":number,
 *      "fecha":date
 *  }
 * </pre> * Por ejemplo, una Adquisicion se representaria de la siguiente
 * manera:<br>
 * <p>
 * <
 * pre>
 *  {
 *      "id":1,
 *      "valorTotal":10000,
 *      "fecha":"20/05/2014"
 *  }
 * </pre>
 *
 * @author Juan David Zambrano
 */
public class AdquisicionDTO {

    private Long id;

    private Double valorTotal;

    private Date fecha;

    public AdquisicionDTO() {

    }

    /**
     * Constructor que convierte una entidad a un DTO
     *
     * @param ent
     */
    public AdquisicionDTO(AdquisicionEntity ent) {
        if (ent != null) {
            this.id = ent.getId();
            this.valorTotal = ent.getValorTotal();
            this.fecha = ent.getFecha();
        }
    }

    /**
     * @return the id
     */
    public Long getID() {
        return id;
    }

    /**
     * @param id the ID to set
     */
    public void setID(Long id) {
        this.id = id;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
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
     * convierte un DTO a un Entity
     *
     * @return
     */
    public AdquisicionEntity toEntity() {
        AdquisicionEntity ent = new AdquisicionEntity();
        ent.setId(this.id);
        ent.setFecha(this.fecha);
        ent.setValorTotal(this.valorTotal);
        return ent;
    }

}
