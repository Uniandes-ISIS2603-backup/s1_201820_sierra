/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.MedioDePagoEntity;

/**
 *MedioDePagoDTO Objeto de transferencia de datos de la entidad Medio de pago. Los DTO contienen las 
 * representaciones de los JSON que se transfieren entre el cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase  implementa el siguiente modelo:<br>
 * <pre>
 *  {
 * "id": number,
 * "numeroReferencia": number,
 * "tipo": string
 *  }
 * </pre>
 * Por ejemplo una entidad Medio de pago se representa asi:<br>
 * <p>
 * <pre>
 *  {
 * "id": 1,
 * "numeroReferencia": 100,
 * "tipo": "efectivo"
 *  }
 * </pre>
 * 
 * @author de.gutierrez
 */
//TODO falta public
public class MedioDePagoDTO 
{
    private Long id;
    private Long numeroReferencia;
    private String tipo;
    
    /**
     * Contructor por defecto.
     */
   public MedioDePagoDTO ()
   {
       
   }

   /**
     * Crea un objeto MedioDePagoDTO a partir de un objeto MedioDePagoEntity.
     * @param entity Entidad MedioDePagoEntity desde la cual se va a crear el nuevo
     */ 
   public MedioDePagoDTO (MedioDePagoEntity entity)
   {
       if(entity != null)
       {
           this.id = entity.getId();
           this.numeroReferencia = entity.getNumeroReferencia();
           this.tipo = entity.getTipo();
       }
   }
   /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
   public MedioDePagoEntity toEntity()
   {
       MedioDePagoEntity entity = new MedioDePagoEntity();
       entity.setId(this.id);
       entity.setNumeroReferencia(this.numeroReferencia);
       entity.setTipo(this.tipo);
       return entity;
   }
   /**
    * Obtiene el id unico asociado a un medio de pago.
    * @return Id del medio de pago.
    */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el id a un medio de pago.
     * @param id El nuevo id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el numero de referencia que representa la transaccion al pagar.
     * @return El numero de referencia de la transaccion.
     */
    public Long getNumeroReferencia() {
        return numeroReferencia;
    }

    /**
     * Asigna un numero de referencia al momento de realizar la transaccion.
     * @param numeroReferencia Nuevo numero de referencia al momento de pagar.
     */
    public void setNumeroReferencia(Long numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    /**
     * Obtiene el tipo de medio de pago, puede ser en efectivo o con tarjeta.
     * @return El tipo de pago para la adquisicion.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna el tipo de pago con el que se realiza la compra.
     * @param tipo El nuevo tipo de pago.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }  
}
