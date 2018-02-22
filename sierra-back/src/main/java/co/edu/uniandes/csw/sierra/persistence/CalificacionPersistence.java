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
package co.edu.uniandes.csw.sierra.persistence;

import co.edu.uniandes.csw.sierra.entities.CalificacionEntity;
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
public class CalificacionPersistence {

    private static final Logger LOGGER = Logger.getLogger(CalificacionPersistence.class.getName());

    @PersistenceContext(unitName = "SierraPU")
    protected EntityManager em;

    /**
     *
     * @param ent la entidad que se quiere guardar en la base de datos
     * @return la entity creada con el id dado por la base de datos
     */
    public CalificacionEntity create(CalificacionEntity ent) {
        LOGGER.info("Creando una nueva entidad de Calificacion");
        em.persist(ent);
        LOGGER.info("Creando una entidad de Calificacion");
        return ent;
    }

    public List<CalificacionEntity> findAll() {
        LOGGER.info("Consultando todas las entidades de Calificacion");
        TypedQuery<CalificacionEntity> query = em.createQuery("select u from CalificacionEntity u", CalificacionEntity.class);
        return query.getResultList();
    }

    public CalificacionEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Calificacion con id={0}", id);
        return em.find(CalificacionEntity.class, id);
    }

    public CalificacionEntity update(CalificacionEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Calificacion con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(CalificacionEntity entity) {
        LOGGER.log(Level.INFO, "Borrando Calificacion con id={0}", entity.getId());
        em.remove(entity);
    }

    public CalificacionEntity findByAdquisicion() {
        //TODO:terminar
        return null;
    }

}
