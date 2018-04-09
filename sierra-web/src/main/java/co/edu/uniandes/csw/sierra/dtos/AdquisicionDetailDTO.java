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

import co.edu.uniandes.csw.sierra.entities.AdquisicionEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaVentaEntity;

/**
 * AdquisicionDTO es el objeto de transferencia de datos detallada de la entidad
 * Adquisicion.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 *  {
 *      "id":number,
 *      "valorTotal":number,
 *      "fecha":date,
 *      "calificacion":{
 *          "id":number,
 *          "comentarios":string,
 *          "valor":number,
 *          "sugerencia":string
 *      },
 *      "mascota":{
 *          "id": number,
 *          "name: String,
 *          "genero": String
 *          "edad": number,
 *          "color": String,
 *          "esteril":boolean,
 *          "adquirido":boolean,
 *          "imagen":String,
 *          "tamano":String,
 *          "nacimiento": Date,
 *          "muerte": Date
 *      },
 *      "factura":
 *      {
 *          "id": number,
 *          "valorTotal": number,
 *          "fecha": date
 *      },
 *      "cliente":{
 *          "name": string,
 *          "apellido": string,
 *          "cedula": number,
 *          "id": number,
 *          "telefono": number
 *      }
 *  }
 * </pre> * Por ejemplo, una Adquisicion se representaria de la siguiente
 * manera:<br>
 * <p>
 * <
 * pre>
 *  {
 *      "id":1,
 *      "valorTotal":10000,
 *      "fecha":"20/05/2014",
 *      "calificacion":{
 *          "id":5,
 *          "comentarios":"muy buenna pagina, to do funciona super bien y fue muy buena la experiencia",
 *          "valor":20000,
 *          "sugerencia":"You don't mess with perfection"
 *      },
 *      "mascota":{
 *          "id": 31,
 *          "name: "Ircops",
 *          "edad": 2,
 *          "color":"negro",
 *          "esteril":true,
 *          "adquirido":false,
 *          "imagen":"https://c1.staticflickr.com/5/4174/33634058024_74d000546d_b.jpg"
 *          "tamano":"Grande",
 *      "nacimiento": 03/10/2016,
 *          "muerte":
 *      },
 *      "factura":
 *      {
 *          "id": 1001,
 *          "valorTotal": 20000,
 *          "fecha": "13/02/2018"
 *      },
 *      "cliente":{
 *          "name": "Andres",
 *          "apellido": "Castro",
 *          "cedula": 1072548232,
 *          "id": 001,
 *          "telefono": 3182564852
 *      }
 *  }
 * </pre>
 *
 * @author Juan David Zambrano
 */
public class AdquisicionDetailDTO extends AdquisicionDTO {

    private CalificacionDTO calificacion;

    private MascotaDTO mascota;

    private FacturaDTO factura;

    private ClienteDTO cliente;

    public AdquisicionDetailDTO() {
        super();
    }

    /**
     * Constructor que convierte un Entity a un DetailDTO
     *
     * @param ent la entidad
     */
    public AdquisicionDetailDTO(AdquisicionEntity ent) {
        super(ent);
        if (ent != null) {
            if (ent.getCalificacion() != null) {
                calificacion = new CalificacionDTO(ent.getCalificacion());
            }
            if (ent.getMascota() != null) {
                mascota = new MascotaDTO(ent.getMascota());
            }
            if (ent.getFactura() != null) {
                factura = new FacturaDTO(ent.getFactura());
            }
            if (ent.getCliente() != null) {
                cliente = new ClienteDTO(ent.getCliente());
            }

        }
    }

    /**
     * Convierte una AdquisicionDetailDTO a una entidad de Adquisicion
     *
     * @return la entidad creada
     */
    @Override
    public AdquisicionEntity toEntity() {
        AdquisicionEntity ent = super.toEntity();
        if (calificacion != null) { 
            ent.setCalificacion(calificacion.toEntity()); 
        }
        if (mascota != null) {
            if (MascotaAdopcionDTO.class.isInstance(mascota)) {
                ent.setMascota(mascota.toEntity(new MascotaAdoptadaEntity()));
            } else {
                ent.setMascota(mascota.toEntity(new MascotaVentaEntity()));
            }

        }
        if (cliente != null) {
            ent.setCliente(cliente.toEntity());
        }
        if (factura != null) {
            ent.setFactura(factura.toEntity());
        }
        return ent;
    }

    /**
     * @return the calificacion
     */
    public CalificacionDTO getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(CalificacionDTO calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the mascota
     */
    public MascotaDTO getMascota() {
        return mascota;
    }

    /**
     * @param mascota the mascota to set
     */
    public void setMascota(MascotaDTO mascota) {
        this.mascota = mascota;
    }

    /**
     * @return the cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the factura
     */
    public FacturaDTO getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }
}
