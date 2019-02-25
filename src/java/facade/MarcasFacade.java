/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entityclasespack.Marcas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entityclasespack.Marcas_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entityclasespack.Modelos;
import entityclasespack.Equipos;
import java.util.Collection;

/**
 *
 * @author Bolivar
 */
@Stateless
public class MarcasFacade extends AbstractFacade<Marcas> {

    @PersistenceContext(unitName = "GestionAudiovisualesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcasFacade() {
        super(Marcas.class);
    }

    public boolean isModelosCollectionEmpty(Marcas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Marcas> marcas = cq.from(Marcas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(marcas, entity), cb.isNotEmpty(marcas.get(Marcas_.modelosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Modelos> findModelosCollection(Marcas entity) {
        Marcas mergedEntity = this.getMergedEntity(entity);
        Collection<Modelos> modelosCollection = mergedEntity.getModelosCollection();
        modelosCollection.size();
        return modelosCollection;
    }

    public boolean isEquiposCollectionEmpty(Marcas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Marcas> marcas = cq.from(Marcas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(marcas, entity), cb.isNotEmpty(marcas.get(Marcas_.equiposCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Equipos> findEquiposCollection(Marcas entity) {
        Marcas mergedEntity = this.getMergedEntity(entity);
        Collection<Equipos> equiposCollection = mergedEntity.getEquiposCollection();
        equiposCollection.size();
        return equiposCollection;
    }
    
}
