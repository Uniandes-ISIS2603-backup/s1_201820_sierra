/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

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
package co.edu.uniandes.csw.sierra.ejb;


import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.MascotaAdoptadaPersistence;
import co.edu.uniandes.csw.sierra.persistence.RazaPersistence;
import co.edu.uniandes.csw.sierra.persistence.EspeciePersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jc.sanchez12
 */
@Stateless
public class MascotaAdoptadaLogic {

    private static final Logger LOGGER = Logger.getLogger(MascotaAdoptadaLogic.class.getName());

    @Inject
    private MascotaAdoptadaPersistence persistence;

    @Inject
    private RazaPersistence razapersistence;
    
    @Inject
    private EspeciePersistence especiepersistence;
    
    /**
     * Crea una entity en la base de datos de tipo MascotaAdoptada
     *
     * @param entity entidad con los datos de la nueva MascotaAdoptadaEntity
     * @return Objeto de tipo MascotaAdoptadaEntity con los datos nuevos
     * @throws BusinessLogicException
     */
    public MascotaAdoptadaEntity createMascotaAdoptada(MascotaAdoptadaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de una entidad de Mascota adoptda");
       /** else if (entity.getRaza()==null) {
            throw new BusinessLogicException("La mascota adoptada necesita tener una raza designada \"");
        }
        else if (entity.getEspecie()==null) {
            throw new BusinessLogicException("La mascota adoptada necesita tener una especie designada \"");
        }
        * */
        
           /** if (razapersistence.findByName(entity.getRaza().getNombreRaza())==null) {
                razapersistence.create(entity.getRaza());
            }
            else if (especiepersistence.findByName(entity.getEspecie().getNombre())==null) {
                especiepersistence.create(entity.getEspecie());
            }
            * */
            persistence.create(entity);
            LOGGER.info("Termina proceso de creación de una entidad de Mascota adoptada");
            return entity;
        
    }

    /**
     * Obtiene la lista de los registros de Mascotas adoptadas.
     *
     * @return Colección de objetos de MascotaAdoptadaEntity.
     */
    public List<MascotaAdoptadaEntity> getAllMascotasAdoptadas() {
        LOGGER.info("Inicia proceso de consultar todas las entidades de Mascota adoptada");
        List<MascotaAdoptadaEntity> entities = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las entidades de Mascota adoptada");
        return entities;
    }
    
    
     /**
     * Obtiene la lista de los registros de Mascotas .
     *
     * @return Colección de objetos de Mascota.
     */
    public List<MascotaEntity> getAllMascotas() {
        LOGGER.info("Inicia proceso de consultar todas las entidades de Mascota");
        List<MascotaEntity> entities = persistence.findAllMascotas();
        LOGGER.info("Termina proceso de consultar todas las entidades de Mascota ");
        return entities;
    }
    

    /**
     * Obtiene los datos de una instancia de Mascota adoptada a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de MascotaAdoptadaEntity con los datos de la mascota
     * consultada.
     */
    public MascotaAdoptadaEntity getMascotaAdoptadaById(Long id) {
        return persistence.findById(id);
    }

    /**
     * Obtiene los datos de una instancia de Mascota adoptada a partir de su
     * nombre.
     *
     * @param nombre nombre de la instancia a consultar
     * @return Instancia de MascotaAdoptadaEntity con los datos de la especie
     * consultada.
     */
    public MascotaAdoptadaEntity getMascotaAdoptadaByName(String nombre) {
        return persistence.findByName(nombre);
    }

    /**
     * Actualiza la información de una instancia de Mascota adoptada.
     *
     * @param entity Instancia de MascotaAdoptadaEntity con los nuevos datos.
     * @return Instancia de MascotaAdoptadaEntity con los datos actualizados.
     */
    public MascotaAdoptadaEntity updateMascotaAdoptada(MascotaAdoptadaEntity entity)throws BusinessLogicException 
    {
       MascotaAdoptadaEntity ent= persistence.findById(entity.getId());
        if (ent !=null) {

        return persistence.update(entity);
        }
         return null;     
    }

    /**
     * Elimina una instancia de Mascota adoptada de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteMascotaAdoptada(Long id) {
        MascotaAdoptadaEntity ent=  persistence.findById(id);
        if (ent!=null) {
            persistence.delete(id);
        }
    }

}
