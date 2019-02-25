/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entityclasespack.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entityclasespack.Usuarios_;
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
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "GestionAudiovisualesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    public boolean isRentaydevolucionCollectionEmpty(Usuarios entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuarios> usuarios = cq.from(Usuarios.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuarios, entity), cb.isNotEmpty(usuarios.get(Usuarios_.rentaydevolucionCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Rentaydevolucion> findRentaydevolucionCollection(Usuarios entity) {
        Usuarios mergedEntity = this.getMergedEntity(entity);
        Collection<Rentaydevolucion> rentaydevolucionCollection = mergedEntity.getRentaydevolucionCollection();
        rentaydevolucionCollection.size();
        return rentaydevolucionCollection;
    }
    
}
