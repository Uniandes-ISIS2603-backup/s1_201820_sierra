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

import co.edu.uniandes.csw.sierra.entities.SierraEntity;

/**
 * SierraDTO Objeto de transferencia de datos de la entidad de Sierra. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "name: string,
 *      "atributo": string
 *   }
 * </pre>
 * Por ejemplo una entidad de Sierra se representa asi:<br>
 * <p>
 * <pre>
 *
 *   {
 *      "id": 91852,
 *      "name: "Bogota, DC",
 *      "atributo": "abcd123"
 *   }
 *
 * </pre>
 *
 * @author ISIS2603
 */
public class SierraDTO
{
	private Long id;

	private String name;

	private String atributo;

	/**
	 * Constructor por defecto
	 */
	public SierraDTO( )
	{
            //Constructor por defecto
	}

	/**
	 * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
	 * la entidad que viene de argumento.
	 *
	 * @param sierraEntity: Es la entidad que se va a convertir a DTO
	 */
	public SierraDTO( SierraEntity sierraEntity )
	{
		this.id = sierraEntity.getId( );
		this.name = sierraEntity.getName( );
		this.atributo = sierraEntity.getAtributo( );

	}

	/**
	 * @return El ID de la entidad Sierra
	 */
	public Long getId( )
	{
		return id;
	}

	/**
	 * @param id El nuevo ID
	 */
	public void setId( Long id )
	{
		this.id = id;
	}

	/**
	 * @return El nombre de la entidad Sierra
	 */
	public String getName( )
	{
		return name;
	}

	/**
	 * @param name El nuevo nombre
	 */
	public void setName( String name )
	{
		this.name = name;
	}

	/**
	 * @return El atrinuto de la entidad Sierra
	 */
	public String getAtributo( )
	{
		return atributo;
	}

	/**
	 * @param atributo El nuevo atributo de la entidad Sierra
	 */
	public void setAtributo( String atributo )
	{
		this.atributo = atributo;
	}

	/**
	 * Convertir DTO a Entity
	 *
	 * @return Un Entity con los valores del DTO
	 */
	public SierraEntity toEntity( )
	{
		SierraEntity entity = new SierraEntity( );
		entity.setId( this.id );
		entity.setName( this.name );
		entity.setAtributo( this.atributo );
		return entity;
	}
}
