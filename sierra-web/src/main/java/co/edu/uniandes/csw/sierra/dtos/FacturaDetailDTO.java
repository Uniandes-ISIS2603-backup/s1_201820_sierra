/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.ComprobanteEntity;
import co.edu.uniandes.csw.sierra.entities.FacturaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * FacturaDetailDTO es el objeto de transferencia de datos detallada de la
 * entidad Factura.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 * {
 *  "id": number,
 *  "valorTotal": number,
 *  "fecha": date,
 *  "adquisicion":
 *  {
 *      "id": number,
 *      "valorTotal": number,
 *      "fecha": date
 *  },
 *  "comprobantes":
 *  [
 *      {
 *          "id": number,
 *          "valorTotal": number,
 *          "fecha": date,
 *          "clienteId": number
 *      }
 *  ]
 * </pre> Por ejemplo, una Factura se representa de la siguiente manera: <br>
 * <p>
 * <
 * pre>
 * {
 *  "id": 20,
 *  "valorTotal": 20000,
 *  "fecha": "13/02/2018",
 *  "adquisicion":
 *  {
 *      "id": 1001,
 *      "valorTotal": 20000,
 *      "fecha": "13/02/2018"
 *  },
 *  "comprobantes":
 *  [
 *      {
 *          "id": 1003,
 *          "valorTotal": 20000,
 *          "fecha": "13/02/2018",
 *          "clienteId": 200
 *      },
 *      {
 *          "id": 1003,
 *          "valorTotal": 0,
 *          "fecha": "13/02/2018",
 *          "clienteId": 200
 *      }
 *  ]
 * }
 * </pre>
 *
 * @author ja.amortegui10
 */
public class FacturaDetailDTO extends FacturaDTO {

    private AdquisicionDTO adquisicion;
    private List<ComprobanteDetailDTO> comprobantes;

    public FacturaDetailDTO() {
        super();
    }

    public FacturaDetailDTO(FacturaEntity entity) {
        super(entity);
        if (entity != null) {
            this.adquisicion = new AdquisicionDetailDTO(entity.getAdquisicion());
            this.comprobantes = new ArrayList<>();
            List<ComprobanteEntity> comprobantesEntity = entity.getComprobantes();
            for (ComprobanteEntity comprobanteActual : comprobantesEntity) {
                this.comprobantes.add(new ComprobanteDetailDTO(comprobanteActual));
            }
        }

    }

    /**
     * Transforma la clase de un DetailDTO a un Entity y retora el
     * resultado.
     *
     * @return
     */
    @Override
    public FacturaEntity toEntity() {
        FacturaEntity entity = super.toEntity();
        if (adquisicion != null) {
            entity.setAdquisicion(adquisicion.toEntity());
        }
        List<ComprobanteEntity> comprobantesEntity = new ArrayList<>();
        if (comprobantes.size() > 0) {
            for (ComprobanteDetailDTO comprobanteActual : comprobantes) {
                comprobantesEntity.add(comprobanteActual.toEntity());
            }
        }

        return entity;

    }

    public AdquisicionDTO getAdquisicion() {
        return adquisicion;
    }

    public List<ComprobanteDetailDTO> getComprobantes() {
        return comprobantes;
    }

    public void setAdquisicion(AdquisicionDTO adquisicion) {
        this.adquisicion = adquisicion;
    }

    public void setComprobantes(List<ComprobanteDetailDTO> comprobantes) {
        this.comprobantes = comprobantes;
    }

}
