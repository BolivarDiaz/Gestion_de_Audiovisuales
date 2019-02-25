/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entityclasespack.Tipoequipos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entityclasespack.Tipoequipos_;
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
public class TipoequiposFacade extends AbstractFacade<Tipoequipos> {

    @PersistenceContext(unitName = "GestionAudiovisualesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoequiposFacade() {
        super(Tipoequipos.class);
    }

    public boolean isEquiposCollectionEmpty(Tipoequipos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tipoequipos> tipoequipos = cq.from(Tipoequipos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoequipos, entity), cb.isNotEmpty(tipoequipos.get(Tipoequipos_.equiposCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Equipos> findEquiposCollection(Tipoequipos entity) {
        Tipoequipos mergedEntity = this.getMergedEntity(entity);
        Collection<Equipos> equiposCollection = mergedEntity.getEquiposCollection();
        equiposCollection.size();
        return equiposCollection;
    }
    
}
