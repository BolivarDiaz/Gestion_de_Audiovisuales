/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entityclasespack.Empleados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entityclasespack.Empleados_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entityclasespack.Rentaydevolucion;
import java.util.Collection;

/**
 *
 * @author Bolivar
 */
@Stateless
public class EmpleadosFacade extends AbstractFacade<Empleados> {

    @PersistenceContext(unitName = "GestionAudiovisualesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadosFacade() {
        super(Empleados.class);
    }

    public boolean isRentaydevolucionCollectionEmpty(Empleados entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleados> empleados = cq.from(Empleados.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleados, entity), cb.isNotEmpty(empleados.get(Empleados_.rentaydevolucionCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Rentaydevolucion> findRentaydevolucionCollection(Empleados entity) {
        Empleados mergedEntity = this.getMergedEntity(entity);
        Collection<Rentaydevolucion> rentaydevolucionCollection = mergedEntity.getRentaydevolucionCollection();
        rentaydevolucionCollection.size();
        return rentaydevolucionCollection;
    }
    
}
