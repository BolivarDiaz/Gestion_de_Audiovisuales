/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entityclasespack.Rentaydevolucion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entityclasespack.Rentaydevolucion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entityclasespack.Empleados;
import entityclasespack.Equipos;
import entityclasespack.Usuarios;

/**
 *
 * @author Bolivar
 */
@Stateless
public class RentaydevolucionFacade extends AbstractFacade<Rentaydevolucion> {

    @PersistenceContext(unitName = "GestionAudiovisualesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentaydevolucionFacade() {
        super(Rentaydevolucion.class);
    }

    public boolean isIdempleadoEmpty(Rentaydevolucion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Rentaydevolucion> rentaydevolucion = cq.from(Rentaydevolucion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(rentaydevolucion, entity), cb.isNotNull(rentaydevolucion.get(Rentaydevolucion_.idempleado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Empleados findIdempleado(Rentaydevolucion entity) {
        return this.getMergedEntity(entity).getIdempleado();
    }

    public boolean isIdequipoEmpty(Rentaydevolucion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Rentaydevolucion> rentaydevolucion = cq.from(Rentaydevolucion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(rentaydevolucion, entity), cb.isNotNull(rentaydevolucion.get(Rentaydevolucion_.idequipo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Equipos findIdequipo(Rentaydevolucion entity) {
        return this.getMergedEntity(entity).getIdequipo();
    }

    public boolean isIdusuarioEmpty(Rentaydevolucion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Rentaydevolucion> rentaydevolucion = cq.from(Rentaydevolucion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(rentaydevolucion, entity), cb.isNotNull(rentaydevolucion.get(Rentaydevolucion_.idusuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuarios findIdusuario(Rentaydevolucion entity) {
        return this.getMergedEntity(entity).getIdusuario();
    }
    
}
