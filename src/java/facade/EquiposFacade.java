/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entityclasespack.Equipos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entityclasespack.Equipos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entityclasespack.Marcas;
import entityclasespack.Modelos;
import entityclasespack.Tecnologiaconeccion;
import entityclasespack.Tipoequipos;
import entityclasespack.Rentaydevolucion;
import java.util.Collection;

/**
 *
 * @author Bolivar
 */
@Stateless
public class EquiposFacade extends AbstractFacade<Equipos> {

    @PersistenceContext(unitName = "GestionAudiovisualesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquiposFacade() {
        super(Equipos.class);
    }

    public boolean isIdmarcasEmpty(Equipos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipos> equipos = cq.from(Equipos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipos, entity), cb.isNotNull(equipos.get(Equipos_.idmarcas)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Marcas findIdmarcas(Equipos entity) {
        return this.getMergedEntity(entity).getIdmarcas();
    }

    public boolean isIdmodeloEmpty(Equipos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipos> equipos = cq.from(Equipos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipos, entity), cb.isNotNull(equipos.get(Equipos_.idmodelo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Modelos findIdmodelo(Equipos entity) {
        return this.getMergedEntity(entity).getIdmodelo();
    }

    public boolean isIdtipotconeccionEmpty(Equipos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipos> equipos = cq.from(Equipos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipos, entity), cb.isNotNull(equipos.get(Equipos_.idtipotconeccion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Tecnologiaconeccion findIdtipotconeccion(Equipos entity) {
        return this.getMergedEntity(entity).getIdtipotconeccion();
    }

    public boolean isIdtipoequiposEmpty(Equipos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipos> equipos = cq.from(Equipos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipos, entity), cb.isNotNull(equipos.get(Equipos_.idtipoequipos)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Tipoequipos findIdtipoequipos(Equipos entity) {
        return this.getMergedEntity(entity).getIdtipoequipos();
    }

    public boolean isRentaydevolucionCollectionEmpty(Equipos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipos> equipos = cq.from(Equipos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipos, entity), cb.isNotEmpty(equipos.get(Equipos_.rentaydevolucionCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Rentaydevolucion> findRentaydevolucionCollection(Equipos entity) {
        Equipos mergedEntity = this.getMergedEntity(entity);
        Collection<Rentaydevolucion> rentaydevolucionCollection = mergedEntity.getRentaydevolucionCollection();
        rentaydevolucionCollection.size();
        return rentaydevolucionCollection;
    }
    
}
