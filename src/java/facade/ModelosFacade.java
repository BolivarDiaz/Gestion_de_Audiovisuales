/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entityclasespack.Modelos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entityclasespack.Modelos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entityclasespack.Marcas;
import entityclasespack.Equipos;
import java.util.Collection;

/**
 *
 * @author Bolivar
 */
@Stateless
public class ModelosFacade extends AbstractFacade<Modelos> {

    @PersistenceContext(unitName = "GestionAudiovisualesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModelosFacade() {
        super(Modelos.class);
    }

    public boolean isIdmarcasEmpty(Modelos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Modelos> modelos = cq.from(Modelos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(modelos, entity), cb.isNotNull(modelos.get(Modelos_.idmarcas)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Marcas findIdmarcas(Modelos entity) {
        return this.getMergedEntity(entity).getIdmarcas();
    }

    public boolean isEquiposCollectionEmpty(Modelos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Modelos> modelos = cq.from(Modelos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(modelos, entity), cb.isNotEmpty(modelos.get(Modelos_.equiposCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Equipos> findEquiposCollection(Modelos entity) {
        Modelos mergedEntity = this.getMergedEntity(entity);
        Collection<Equipos> equiposCollection = mergedEntity.getEquiposCollection();
        equiposCollection.size();
        return equiposCollection;
    }
    
}
