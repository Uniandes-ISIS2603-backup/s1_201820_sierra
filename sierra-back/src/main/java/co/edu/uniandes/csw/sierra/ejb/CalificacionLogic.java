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
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.CalificacionEntity;
import co.edu.uniandes.csw.sierra.persistence.CalificacionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Juan David Zambrano
 */
@Stateless
public class CalificacionLogic {
    /**
     * Logger, self explanatory
     */
    private static final Logger LOGGER = Logger.getLogger(CalificacionLogic.class.getName());
    
    /**
     * objeto de persistencia de Calificacion
     */
    @Inject
    private CalificacionPersistence persistencia;
    
    /**
     * Revisa que la entidad que se quiere crear cumpla las reglas de negocio y
     * la crea
     * @param ent la entidad que se quiere persistir
     * @return la entidad persistida con el id autogenerado
     */
    public CalificacionEntity create(CalificacionEntity ent){
        LOGGER.info("Creando una entidad de Calificacion");
        //TODO: Definir reglas de negocio
        persistencia.create(ent);
        LOGGER.info("Termina la creacion de la entidad de Calificacion");
        return ent;
    }
    
    /**
     * Obtiene todas las entidades de Calificacion
     * @return 
     */
    public List<CalificacionEntity> getAll(){
        LOGGER.info("Consultando todas las entidades de Calificacion");
        List<CalificacionEntity> r = persistencia.findAll();
        LOGGER.info("consultadas todas las entidades de Calificacion");
        return r;
    }
    /**
     * Obtiene una entidad de Calificacion base en un Id dado 
     * @param id el Id que se quiere encontrar
     * @return la Calificacion con el Id dado, Null si no lo encuentra
     */
    public CalificacionEntity getById(Long id){
        LOGGER.log(Level.INFO, "Buscando la Calificacion con el id={0}", id);
        return persistencia.find(id);
    }
    /**
     * Actualiza una Calificacion 
     * @param ent la entidad con los datos que se quieren actualizar
     * @return la entidad con los cambios ya realizados
     */
    public CalificacionEntity update(CalificacionEntity ent){
        //TODO: Agregar reglas de negocio
        LOGGER.log(Level.INFO, "Actualizando la entidad de Calificacion con el id={0}", ent.getId());
        return persistencia.update(ent);
    }
    
    /**
     * Elimina una Calificacion
     * @param ent la calificacion que se desea eliminar
     */
    public void delete(CalificacionEntity ent){
        LOGGER.log(Level.INFO, "Eliminando la Calificacion con id ={0}", ent.getId());
        persistencia.delete(ent);
    }
    
}
    
    
