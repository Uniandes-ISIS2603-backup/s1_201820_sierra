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
 * CalificacionDetailDTO es el objeto de transferencia de datos detallada de la entidad Calificacion.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 *  {
 *      "id":number,
 *      "comentarios":string,
 *      "valor":number,
 *      "sugerencia":string,
 *      "adquisicion":
 *          {
 *          "id":number,
 *          "valorTotal":number,
 *          "fecha":date
 *          }
 *  }
 * </pre>
 * * Por ejemplo, una Calificacion detallada se representaria de la siguiente manera:<br>
 * <p>
 * <pre>
 *  {
 *      "id":5,
 *      "comentarios":"muy buenna pagina, todo funciona super bien y fue muy buena la experiencia",
 *      "valor":20000,
 *      "sugerencia":"You don't mess with perfection",
 *      "adquisicion":
 *          {
 *          "id":3,
 *          "valorTotal":10000000,
 *          "fecha":"10/5/1973"
 *          }
 *  }
 * </pre>
 * @author Juan David Zambrano
 */
public class CalificacionDetailDTO extends CalificacionDTO{
    
    private AdquisicionDTO adquisicion;
    
    public CalificacionDetailDTO(){
        super();
    }
    
    /**
     * constructor que convierte una Entity a un DetailDTO
     * @param ent la entidad que se quiere convertir
     */
    public CalificacionDetailDTO(CalificacionEntity ent){
        super(ent);
        if(ent != null){
            this.adquisicion = new AdquisicionDTO(ent.getAdquisicion());
        }
    }
    
    /**
     * Metodo que convierte un DetailDTO a una entity
     * @return 
     */
    @Override
    public CalificacionEntity toEntity(){
        CalificacionEntity ent = super.toEntity();
        if(adquisicion != null){
            ent.setAdquisicion(adquisicion.toEntity());
        }
        return ent;
    }

    /**
     * @return the adquisicion
     */
    public AdquisicionDTO getAdquisicion() {
        return adquisicion;
    }

    /**
     * @param adquisicion the adquisicion to set
     */
    public void setAdquisicion(AdquisicionDTO adquisicion) {
        this.adquisicion = adquisicion;
    }
}
