/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entityclasespack.Tecnologiaconeccion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entityclasespack.Tecnologiaconeccion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entityclasespack.Equipos;
import java.util.Collection;

/**
 *
 * @author Bolivar
 */
@Stateless
public class TecnologiaconeccionFacade extends AbstractFacade<Tecnologiaconeccion> {

    @PersistenceContext(unitName = "GestionAudiovisualesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TecnologiaconeccionFacade() {
        super(Tecnologiaconeccion.class);
    }

    public boolean isEquiposCollectionEmpty(Tecnologiaconeccion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tecnologiaconeccion> tecnologiaconeccion = cq.from(Tecnologiaconeccion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tecnologiaconeccion, entity), cb.isNotEmpty(tecnologiaconeccion.get(Tecnologiaconeccion_.equiposCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Equipos> findEquiposCollection(Tecnologiaconeccion entity) {
        Tecnologiaconeccion mergedEntity = this.getMergedEntity(entity);
        Collection<Equipos> equiposCollection = mergedEntity.getEquiposCollection();
        equiposCollection.size();
        return equiposCollection;
    }
    
}
