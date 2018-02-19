/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.persistence;

import co.edu.uniandes.csw.sierra.ejb.*;
import co.edu.uniandes.csw.sierra.entities.CertificadoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author rj.gonzalez10
 */
public class CertificadoPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(CertificadoPersistence.class.getName());
    @PersistenceContext( unitName = "SierraPU" )
    protected EntityManager em;
    
    /**
     * Crea un nuevo certificado.
     * @param entity objeto certificado que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CertificadoEntity create(CertificadoEntity entity)
    {
        LOGGER.info("Creando un certificado");
        em.persist(entity);
        LOGGER.info("Creando el certicado");
        return entity;
    }
    
    /**
     * Busca el certificado con id que se envia por parametro
     * @param id correspondiente al certificado buscado.
     * @return La entidad certificado.
     */
    public CertificadoEntity find (Long id)
    {
        LOGGER.log(Level.INFO, "Obteniendo certificado por el id", id);
        return em.find(CertificadoEntity.class, id);
    }
    
    /**
     * Devuelve todos los certificados de la base de datos.
     * @return una lista con todos los certificados.
     */
    public List<CertificadoEntity> findAll()
    {
         LOGGER.info("Consultando todos los certificados");
         TypedQuery query = em.createQuery("select u from CertificadoEntity u", CertificadoEntity.class);
         return query.getResultList();
    }
    
    /**
     * Actualiza la informacion de un cliente
     * @param entity.  El certificado que va actualizar.
     *@return el certificado actualizado.
     */
    public CertificadoEntity update(CertificadoEntity entity)
    {
       LOGGER.log(Level.INFO, "Actualizando certificado", CertificadoEntity.class);
       return em.merge(entity);
    }
    
    /**
     * Elimina un cliente con el id que se envia por parametro
     * @param  id: id correspondiente al certificado a eliminar
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO,"Eliminando certificado", CertificadoEntity.class);
        CertificadoEntity entity = find(id);
        
        em.remove(entity);
    }


}
