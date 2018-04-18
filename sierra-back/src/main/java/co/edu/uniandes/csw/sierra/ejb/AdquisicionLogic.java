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

import co.edu.uniandes.csw.sierra.entities.AdquisicionEntity;
import co.edu.uniandes.csw.sierra.entities.CalificacionEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.AdquisicionPersistence;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Juan David Zambrano
 */
@Stateless
public class AdquisicionLogic {
    /**
     * Logger, self explanatory
     */
    private static final Logger LOGGER = Logger.getLogger(AdquisicionLogic.class.getName());
    
    /**
     * objeto de persistencia de Adquisicion
     */
    @Inject
    private AdquisicionPersistence persistencia;
    
    @Inject
    private CalificacionLogic calLogic;
    
    /**
     * Revisa que la entidad que se quiere crear cumpla las reglas de negocio y
     * la crea
     * @param ent la entidad que se quiere persistir
     * @return la entidad persistida con el id autogenerado
     */
    public AdquisicionEntity create(AdquisicionEntity ent) throws BusinessLogicException{
        LOGGER.info("Creando una entidad de Adquisicion");
        if(ent.getValorTotal() < 0)
            throw new BusinessLogicException("El valor total no puede ser negativo");
        persistencia.create(ent);
        LOGGER.info("Termina la creacion de la entidad de Adquisicion");
        return ent;
    }
    
    /**
     * Obtiene todas las entidades de Adquisicion
     * @return 
     */
    public List<AdquisicionEntity> getAll(){
        LOGGER.info("Consultando todas las entidades de Adquisicion");
        List<AdquisicionEntity> r = persistencia.findAll();
        LOGGER.info("consultadas todas las entidades de Adquisicion");
        return r;
    }
    /**
     * Obtiene una entidad de ADquiicion con base en un Id dado 
     * @param id el Id que se quiere encontrar
     * @return la Adquisicion con el Id dado, Null si no lo encuentra
     */
    public AdquisicionEntity getById(Long id){
        LOGGER.log(Level.INFO, "Buscando la Adquisicion con el id={0}", id);
        return persistencia.find(id);
    }
    /**
     * Actualiza una Adquisicion 
     * @param ent la entidad con los datos que se quieren actualizar
     * @return la entidad con los cambios ya realizados
     */
    public AdquisicionEntity update(AdquisicionEntity ent) throws BusinessLogicException{
        if(ent.getValorTotal() < 0)
            throw new BusinessLogicException("El valor total no puede ser negativo");
        LOGGER.log(Level.INFO, "Actualizando la entidad de Adquisicion con el id={0}", ent.getId());
        return persistencia.update(ent);
    }
    
    /**
     * Elimina una Adquisicion
     * @param ent la adquiisicion que se desea eliminar
     */
    public void delete(Long id) throws Exception{
        LOGGER.log(Level.INFO, "Eliminando la Adquisicion con id ={0}", id);
        if(persistencia.find(id) != null){ 
            persistencia.delete(id);
        }else{
            throw new Exception("No existe una adquisicion con el id dado");
        }
    }

    public CalificacionEntity addCalificacion(Long adqId, Long calId) {
        System.out.println("adqId: " + adqId + "\ncalId: " + calId);
        AdquisicionEntity adqEntity = getById(adqId);
        CalificacionEntity calEntity = calLogic.getById(calId);
        calEntity.setAdquisicion(adqEntity);
        adqEntity.setCalificacion(calEntity);
        return calEntity;
    }
    
    
    
    
    
}
