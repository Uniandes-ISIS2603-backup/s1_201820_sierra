/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.persistence;

import co.edu.uniandes.csw.sierra.entities.MascotaVentaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juan David Zambrano
 */
@Stateless
public class MascotaVentaPersistence {
    
        private final static Logger LOGGER = Logger.getLogger(MascotaVentaPersistence.class.getName());
        
        /**
         * el manejaor de entidades con el persistence unit del proyecto
         */
        @PersistenceContext(unitName = "SierraPU")
        protected EntityManager em;
        
        /**
         * Guarda una entidad en la base de datos y la retorna con el id asignado
         * @param ent la entidad que se quiere persistir
         * @return la entidad persistida con el id asignado por la DB
         */
        public MascotaVentaEntity create(MascotaVentaEntity ent){
            LOGGER.info("Guardando una nueva entidad de MascotaVenta");
            em.persist(ent);
            LOGGER.info("La entidad fue guardada con exito");
            return ent;
        }
        
        /**
         * Consulta todas las entidades de mascotaVenta en la base de datos
         * @return una lista con todas las mascotas en venta
         */
        public List<MascotaVentaEntity> findAll(){
            LOGGER.info("Consultando todas las entidades de MascotaVenta");
            TypedQuery<MascotaVentaEntity> query = em.createQuery("select u from MascotaVentaEntity u", MascotaVentaEntity.class);
            return query.getResultList();
        }
        
        /**
         * consulta una entidad de mascota Venta con el id dado
         * @param id el id de la mascota venta buscada
         * @return la mascota con el id dado, Null si no existe
         */
        public MascotaVentaEntity find(Long id){
            LOGGER.log(Level.INFO, "Consultando MascotaVenta con el id= {0}", id);
            return em.find(MascotaVentaEntity.class, id);
        }
        
        /**
         * Busca una mascota en venta con el nombre dado y retorna la primera mascota que se encuentre con dicho nombre
         * @param name nombre de la mascota
         * @return la mascota encontrada. Null si no se encuetra
         */
        public List<MascotaVentaEntity> findByName(String name){
            LOGGER.log(Level.INFO, "Consultando MacotaVenta con el nombre :", name);
            
            TypedQuery<MascotaVentaEntity> query = em.createQuery("Select e from MascotaVentaEntity e where e.name = :name", MascotaVentaEntity.class);
            
            query.setParameter("name", name);
            
            List<MascotaVentaEntity> list = query.getResultList();
            
            if(list.isEmpty()){
                return null;
            }else{
                return list;
            }
        }   
        
        /**
         * Borra una entidad de MascotaVentacon el id dado
         * @param id el id de la mascota Venta que se quiere borrar
         */
        public void delete(Long id){
            LOGGER.log(Level.INFO, "Borrando una entidad de MascotaVenta con id={0}", id);
            MascotaVentaEntity ent = em.find(MascotaVentaEntity.class, id);
            em.remove(ent); 
        }
        /**
         * Actualiza una mascota en venta
         * @param ent la entidad de la mascota con los datos actualizados
         * @return la entidad con los cambios aplicados
         */
        public MascotaVentaEntity update(MascotaVentaEntity ent){
            LOGGER.log(Level.INFO, "Actualizanco una entidad de mascotaVenta con el id={0}", ent.getId());
            return em.merge(ent);
        }
        

}
