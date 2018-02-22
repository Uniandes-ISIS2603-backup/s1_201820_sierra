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
    
    //Logger
    private static final Logger LOGGER = Logger.getLogger(MascotaVentaPersistence.class.getName());
    
    /**
     * Manejador de entidades
     */
    @PersistenceContext(unitName = "SierraPU")
    protected EntityManager em;
    
    /**
     * Crea una nueva MascotaVentaEntity
     * @param ent mascotaVenta que se quiere agregar a la base de datos
     * @return La entidad agregada a la base de dattos con el id
     * asignado automaticamente.
     */
    public MascotaVentaEntity create(MascotaVentaEntity ent){
        LOGGER.info("Creando una nueva entidad de Mascota Venta");
        em.persist(ent);
        LOGGER.info("Creada una nueva entidad de Mascota Venta");
        return ent;
    }
    
    public List<MascotaVentaEntity> findAll(){
        LOGGER.info("Consultando todas las entidades de MascotaVenta");
        TypedQuery<MascotaVentaEntity> query = em.createQuery("select u from MascotaVentaEntity u", MascotaVentaEntity.class);
        return query.getResultList();
    }
    
    public MascotaVentaEntity findById(Long id){
        LOGGER.log(Level.INFO, "Consultando Mascota Venta con id={0}", id);
        return em.find(MascotaVentaEntity.class, id);
    }

    public MascotaVentaEntity findByName(String name){
        
        LOGGER.log(Level.INFO, "Consultando una mascotaVenta por nombre: ", name);
        //TODO:
        //TypedQuery<MascotaVentaEntity> query = em.createQuery("Select e from MascotaVenta")
        return null;
    }
    
}
