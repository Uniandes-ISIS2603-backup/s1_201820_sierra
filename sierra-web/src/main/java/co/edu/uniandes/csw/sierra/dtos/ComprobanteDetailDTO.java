/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

/**
 *ComprobanteDetailDTO es el objeto de transferencia de datos detallada de la entidad detallada Comprobante.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 * {
 *      "id":number,
 *      "valorTotal": number,
 *      "fecha": date,
 *      "clienteId": number,
 *      "factura":
 *      {
 *      "id": number,
 *      "valorTotal":  number, 
 *      "fecha": date
 *      },
 *      "medioDePago":
 *      {
 *          "id": number,
 *          "numeroReferencia": number,
 *          "tipo": string
 *      }
 *  }
 *  </pre>
 *  Por ejemplo, un comprobante se representaría de la siguiente forma:<br>
 *  <p>
 *  <pre>
 *  {
 *      "id":1003,
 *      "valorTotal": 20000,
 *      "fecha": "13/02/2018",
 *      "clienteId": 2008,
 *      "factura":
 *      {
 *          "id": 2002,
 *          "valorTotal":  20000, 
 *          "fecha": "13/02/2018"
 *      },
 *      "medioDePago":
 *      {
 *          "id": 0005,
 *          "numeroReferencia": 27,
 *          "tipo": "Débito"
 *      }
 *  }
 *  </pre>
 * @author ja.amortegui10
 */
public class ComprobanteDetailDTO extends ComprobanteDTO{
    private FacturaDTO factura;
    private MedioDePagoDTO medioDePago;
    public ComprobanteDetailDTO()
    {
        super();
    }
    
}
