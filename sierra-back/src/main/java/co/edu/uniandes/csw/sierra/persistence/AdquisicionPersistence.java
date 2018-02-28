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

import co.edu.uniandes.csw.sierra.entities.AdquisicionEntity;
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
public class AdquisicionPersistence {

    private static final Logger LOGGER = Logger.getLogger(AdquisicionPersistence.class.getName());

    @PersistenceContext(unitName = "SierraPU")
    protected EntityManager em;

    /**
     *
     * @param ent la entidad que se quiere guardar en la base de datos
     * @return la entity creada con el id dado por la base de datos
     */
    public AdquisicionEntity create(AdquisicionEntity ent) {
        LOGGER.info("Creando una nueva entidad de Adquisicion");
        em.persist(ent);
        LOGGER.info("Creando una entidad de Adquisicion");
        return ent;
    }

    public List<AdquisicionEntity> findAll() {
        LOGGER.info("Consultando todas las entidades de Adquisicion");
        TypedQuery<AdquisicionEntity> query = em.createQuery("select u from AdquisicionEntity u", AdquisicionEntity.class);
        return query.getResultList();
    }

    public AdquisicionEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Adquisicion con id={0}", id);
        return em.find(AdquisicionEntity.class, id);
    }

    public AdquisicionEntity update(AdquisicionEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Adquisicion con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando Adquisicion con id={0}", id);
        AdquisicionEntity entity = em.find(AdquisicionEntity.class, id);
        em.remove(entity);
    }

}

