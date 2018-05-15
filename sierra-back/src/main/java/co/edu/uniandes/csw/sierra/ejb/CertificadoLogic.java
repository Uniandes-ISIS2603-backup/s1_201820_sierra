/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;

import co.edu.uniandes.csw.sierra.entities.CertificadoEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.CertificadoPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author rj.gonzalez10
 */
@Stateless
public class CertificadoLogic {
       private final static Logger LOGGER = Logger.getLogger(CertificadoLogic.class.getName());
    
    @Inject
    private CertificadoPersistence persistence;
    
    public CertificadoEntity create(CertificadoEntity entity)throws BusinessLogicException
    {
        LOGGER.info("Iniciando el proceso de creación de una entidad de certificado.");
        //TODO: No tiene sentido validar que existe la entidad con el id porque (preguntar)
        // aun no se tiene el id. EL id es la PK que crea la BD después de persistirlo y hacer commit de la transacción. 
        persistence.create(entity);
        LOGGER.info("Terminando el proceso de creación de una entidad de certificado.");
        return entity;
    }
    
    public List<CertificadoEntity> getAll()
    {
        LOGGER.info("Comienza el proceso de consultar todas las entidaddes de certificado existentes.");
        List<CertificadoEntity> entities = persistence.findAll();
        LOGGER.info("Termína el proceso de consultar todas las entidades de certificado existentes.");
        return entities;
    }
    
    public CertificadoEntity getById(Long id)
    {
        return persistence.find(id);
    }
    /**
     * 
     * @param entity
     * @return
     * @throws BusinessLogicException 
     */
    public CertificadoEntity update(CertificadoEntity entity) throws BusinessLogicException
    {
        LOGGER.info("Inicia el proceso de actualizar un certificado.");
         if(persistence.find(entity.getId()) == null)
            throw new BusinessLogicException("No existe un certificado con el id dado.");
          LOGGER.info("Termina el proceso de actualizar un certificado.");
        return persistence.update(entity);
    }
    
    public void delete(Long id) throws BusinessLogicException
    {
        LOGGER.info("Inicia el proceso de eliminar una entidad de certificado.");
        if(persistence.find(id) == null)
        {
            throw new BusinessLogicException("Ya existe una entidad de certificado con el mismo id: " + id);
        }
        persistence.delete(id);
        LOGGER.info("Termína el proceso de eliminar una entidad de certificado.");
    }
    
}
