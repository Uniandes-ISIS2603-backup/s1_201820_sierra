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

import co.edu.uniandes.csw.sierra.entities.EspecieEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaEntity;
import co.edu.uniandes.csw.sierra.entities.RazaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * EspeciDetailDTO es el objeto de transferencia de datos detallada de la
 * entidad Especie.
 * <p>
 * Al serializarse como JSON, esta clase implementa el siguiente modelo:<br>
 * <pre>
 *  {
 *      "id":number,
 *      "nombre":string,
 *      "caracteristicas":string,
 *      "clasifitacion":number,
 *      "raza"
 *          {
 *          "id": number,
 *          "nombreRaza": String,
 *          "cuidados": String
 *          "destacable": String,
 *          "caracteristicas": String
 *          }
 *
 *  }
 * </pre> * Por ejemplo, una especie detallada se representaria de la siguiente
 * manera:<br>
 * <p>
 * <
 * pre>
 *  {
 *      "id": 1,
 *      "nombre": "Perro",
 *      "caracteristicas": "Perros  similares a los lobos, pelo blanco,negro  o cafe  con una combinacion de color",
 *      "clasificacion": "Mamifero",
 *      "raza"
 *         {
 *      "id": 164613,
 *      "nombreRaza": "Siberian Husky",
 *      "cuidados": "concentrado razas pequeñas, paseos constantes, despues de los seis años ir al veterinario cada seis meses"
 *      "destacable": "raza preferible para apartamentos de grandes dimensiones,  son la mejor raza para los niños",
 *      "caracteristicas": "raza gradne de pelo liso, tonalidad que combina negro, blanco y café, requieren una actividad física media"
 *         }
 *  }
 * </pre>
 *
 * @author jc.sanchez12
 */
public class EspecieDetailDTO extends EspecieDTO {

    /**
     * Lista de razas que contiene una especie
     */
    private List<RazaDTO> razas;
    
    private List<MascotaDTO> mascotas;

    /**
     * Constructor por defecto
     */
    public EspecieDetailDTO() {
        super();

    }

    /**
     * Crea un objeto EspecieDetailDTO a partir de un objeto EspeciEntity
     * incluyendo los atributos de EspecieDTO.
     *
     * @param entity Entidad EspecieEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public EspecieDetailDTO(EspecieEntity entity) {
        super(entity);
        if (entity != null) {
            razas = new ArrayList<>();
            for (RazaEntity entityRazas : entity.getRazas()) {
                razas.add(new RazaDTO(entityRazas));
            }
        }

    }

    /**
     * Convierte un objeto EspecieDetailDTO a EspecieEntity incluyendo los
     * atributos de EspecieDTO.
     *
     * @return Nueva objeto EspecieEntity.
     *
     */
    @Override
    public EspecieEntity toEntity() {
        EspecieEntity entity = super.toEntity();
        if (razas != null) {
            List<RazaEntity> razasEntity = new ArrayList<>();
            for (RazaDTO razaDto : razas) {
                 razasEntity.add(razaDto.toEntity()); 
            }
            entity.setRazas(razasEntity);
        }
        return entity;
    }

    /**
     * @return the razas
     */
    public List<RazaDTO> getRazas() {
        return razas;
    }

    /**
     * @param razas the razas to set
     */
    public void setRazas(List<RazaDTO> razas) {
        this.razas = razas;
    }

    /**
     * @return the mascotas
     */
    public List<MascotaDTO> getMascotas() {
        return mascotas;
    }

    /**
     * @param mascotas the mascotas to set
     */
    public void setMascotas(List<MascotaDTO> mascotas) {
        this.mascotas = mascotas;
    }
}
