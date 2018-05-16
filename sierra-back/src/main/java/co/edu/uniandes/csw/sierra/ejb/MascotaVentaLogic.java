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

import co.edu.uniandes.csw.sierra.entities.CertificadoEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaVentaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.CertificadoPersistence;
import co.edu.uniandes.csw.sierra.persistence.MascotaVentaPersistence;
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
public class MascotaVentaLogic {
    /**
     * Logger, self explanatory
     */
    private static final Logger LOGGER = Logger.getLogger(MascotaVentaLogic.class.getName());
    
    /**
     * objeto de persistencia de MascotaVenta
     */
    @Inject
    private MascotaVentaPersistence persistencia;
    
     /**
     * Objeto de persistencia de certificado.
     */
    @Inject
    private CertificadoLogic certificadoLogica;
    
    /**
     * Revisa que la entidad que se quiere crear cumpla las reglas de negocio y
     * la crea
     * @param ent la entidad que se quiere persistir
     * @return la entidad persistida con el id autogenerado
     * @throws co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException
     */
    public MascotaVentaEntity create(MascotaVentaEntity ent) throws BusinessLogicException{
        LOGGER.info("Creando una entidad de MascotaVenta");
        if(ent.getPrecio() < 0){
            throw new BusinessLogicException("El precio no debe ser negativo y fue: " + ent.getPrecio());
        }
        persistencia.create(ent);
        LOGGER.info("Termina la creacion de la entidad de MascotaVenta");
        return ent;
    }
    
    /**
     * Obtiene todas las entidades de MascotaVenta
     * @return 
     */
    public List<MascotaVentaEntity> getAll(){
        LOGGER.info("Consultando todas las entidades de MascotaVenta");
        List<MascotaVentaEntity> r = persistencia.findAll();
        LOGGER.info("consultadas todas las entidades de MascotaVenta");
        return r;
    }
    /**
     * Obtiene una entidad de MascotaVenta con base en un Id dado 
     * @param id el Id que se quiere encontrar
     * @return la MascotaVenta con el Id dado, Null si no lo encuentra
     */
    public MascotaVentaEntity getById(Long id){
        LOGGER.log(Level.INFO, "Buscando la MascotaVenta con el id={0}", id);
        return persistencia.find(id);
    }
    /**
     * Actualiza una MascotaVenta 
     * @param ent la entidad con los datos que se quieren actualizar
     * @return la entidad con los cambios ya realizados
     * @throws BusinessLogicException si el precio es menor o igual a 0
     */
    public MascotaVentaEntity update(MascotaVentaEntity ent) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Actualizando la entidad de MascotaVenta con el id={0}", ent.getId());
        if(ent.getPrecio() <= 0){
            throw new BusinessLogicException("El precio no debe ser negativo y fue: " + ent.getPrecio());
        }
        return persistencia.update(ent);
    }
    
    /**
     * Elimina una MascotaVenta
     * @param ent la mascota venta que se desea eliminar
     
    public void delete(MascotaVentaEntity ent){
        LOGGER.log(Level.INFO, "Eliminando la MascotaVenta con id ={0}", ent.getId());
        if(persistencia.find(ent.getId()) == null){
            throw new 
        }
        persistencia.delete(ent.getId());
    }
    */
    /**
     * Elimina una MascotaVenta
     * @param id la mascota venta que se desea eliminar
     */
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Eliminando la MascotaVenta con id ={0}", id);
        persistencia.delete(id);
    }
    
    /**
     * Linkea una mascotaVenta con un certificados.
     * @param mascotaVentaId
     * @param certificadoId
     * @return
     * @throws BusinessLogicException 
     */
     public MascotaVentaEntity addCertificado(Long mascotaVentaId, Long certificadoId) throws BusinessLogicException
    {
        MascotaVentaEntity mascota = persistencia.find(mascotaVentaId);
        if(mascota == null)
        {
            throw new BusinessLogicException("No existe una mascota con el id: " + mascotaVentaId);
        }
        CertificadoEntity certificado = certificadoLogica.getById(certificadoId);
        if(certificado != null)
        {
            if(mascota.getCertificados() == null)
            {
                mascota.setCertificados(new ArrayList<>());
            }
            mascota.getCertificados().add(certificado);
            certificado.setMascotaVenta(mascota);
            certificadoLogica.update(certificado);
            return persistencia.update(mascota);
        }
        else
        {
            throw new BusinessLogicException("No existe el certificado con el id: " + certificadoId);
        }
    }
}
    

    
    
