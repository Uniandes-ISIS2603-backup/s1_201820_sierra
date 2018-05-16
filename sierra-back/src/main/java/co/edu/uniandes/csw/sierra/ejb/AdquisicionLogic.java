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
import co.edu.uniandes.csw.sierra.entities.ClienteEntity;
import co.edu.uniandes.csw.sierra.entities.FacturaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaAdoptadaEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaVentaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.AdquisicionPersistence;
import java.util.ArrayList;
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
    
    @Inject
    private FacturaLogic factLogic;
    
    @Inject
    private ClienteLogic clLogic;
    
    @Inject
    private MascotaAdoptadaLogic mascotaAdoptadaLogic;
    
    @Inject
    private MascotaVentaLogic mascotaVentaLogic;
    
    /**
     * Revisa que la entidad que se quiere crear cumpla las reglas de negocio y
     * la crea
     * @param ent la entidad que se quiere persistir
     * @return la entidad persistida con el id autogenerado
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
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
        LOGGER.info("AdquisicionLogic: Consultando todas las entidades de Adquisicion");
        List<AdquisicionEntity> r = persistencia.findAll();
        LOGGER.info("AdquisicionLogic: consultadas todas las entidades de Adquisicion");
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
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    public AdquisicionEntity update(AdquisicionEntity ent) throws BusinessLogicException{
        if(ent.getValorTotal() < 0)
            throw new BusinessLogicException("El valor total no puede ser negativo");
        LOGGER.log(Level.INFO, "Actualizando la entidad de Adquisicion con el id={0}", ent.getId());
        return persistencia.update(ent);
    }
    
    /**
     * Elimina una Adquisicion
     * @param id
     * @throws BusinessLogicException Excepcion lanzada cuando no existe la adquisicion
     */
    public void delete(Long id) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Eliminando la Adquisicion con id ={0}", id);
        if(persistencia.find(id) != null){ 
            persistencia.delete(id);
        }else{
            throw new BusinessLogicException("No existe una adquisicion con el id dado");
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
    
    
    public FacturaEntity addFactura(Long adqId, Long facId)
    {
        AdquisicionEntity adqEntity = getById(adqId);
        FacturaEntity facEntity = factLogic.getById(facId);
        facEntity.setAdquisicion(adqEntity);
        adqEntity.setFactura(facEntity);
        return facEntity;
    }

    public AdquisicionEntity linkAdquisicion(Long adqId, Long clId, Long mascotaId) throws BusinessLogicException 
    {
        //Revisa que exista la adquisicion
        AdquisicionEntity adqEntity = getById(adqId);
        if(adqEntity == null)
        {
            throw new BusinessLogicException("La adquisicion del Id: " + adqId + " no existe");
        }
        
        //Revisa que exista el cliente
        ClienteEntity clEntity = clLogic.getCliente(clId);
        if(clEntity == null)
        {
            throw new BusinessLogicException("No existe un cliente con el Id: " + clId);
        }
        
        //Revisa que exista la mascota, primero busca la mascotaAdopcion y luego la de venta, esto se puede ya que
        //MascotaVenta y MascotaAdopcion comparten la misma llave primaria, entonces si se busca en ambas, solo se
        //Puede encontrar en una
        MascotaAdoptadaEntity mascAdopEntity = mascotaAdoptadaLogic.getMascotaAdoptadaById(mascotaId);
        MascotaVentaEntity mascVentEntity = mascotaVentaLogic.getById(mascotaId);
        if(mascAdopEntity != null)
        {
            adqEntity.setMascota(mascAdopEntity);
            adqEntity.setCliente(clEntity);
            mascAdopEntity.setAdquisicion(adqEntity);
            if(clEntity.getAdquisiciones() == null)
            {
                clEntity.setAdquisiciones(new ArrayList<>());
            }
            clEntity.getAdquisiciones().add(adqEntity);
            return adqEntity;
        }
        else if(mascVentEntity != null)
        {
            adqEntity.setMascota(mascVentEntity);
            adqEntity.setCliente(clEntity);
            mascVentEntity.setAdquisicion(adqEntity);
            if(clEntity.getAdquisiciones() == null)
            {
                clEntity.setAdquisiciones(new ArrayList<>());
            }
            clEntity.getAdquisiciones().add(adqEntity);
            return adqEntity;
        }
        else
        {
            throw new BusinessLogicException("No existe una mascota con el id: " + mascotaId);
        }
        
        
    }
    
    
}
