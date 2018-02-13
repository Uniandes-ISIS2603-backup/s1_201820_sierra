/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import java.util.List;

/**
 *FacturaDetailDTO es el objeto de transferencia de datos detallada de la entidad Factura.
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
 * </pre>
 * Por ejemplo, una Factura se representa de la siguiente manera: <br>
 * <p>
 * <pre>
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
 * </pre>
 * @author ja.amortegui10
 */
public class FacturaDetailDTO extends FacturaDTO{
    
    private AdquisicionDTO adquisicion;
    private List<ComprobanteDetailDTO> comprobantes;
    
    public FacturaDetailDTO()
    {
        super();
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
