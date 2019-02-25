package controller;

import entityclasespack.Tipoequipos;
import entityclasespack.Equipos;
import java.util.Collection;
import facade.TipoequiposFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoequiposController")
@ViewScoped
public class TipoequiposController extends AbstractController<Tipoequipos> {

    // Flags to indicate if child collections are empty
    private boolean isEquiposCollectionEmpty;

    public TipoequiposController() {
        // Inform the Abstract parent controller of the concrete Tipoequipos Entity
        super(Tipoequipos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsEquiposCollectionEmpty();
    }

    public boolean getIsEquiposCollectionEmpty() {
        return this.isEquiposCollectionEmpty;
    }

    private void setIsEquiposCollectionEmpty() {
        Tipoequipos selected = this.getSelected();
        if (selected != null) {
            TipoequiposFacade ejbFacade = (TipoequiposFacade) this.getFacade();
            this.isEquiposCollectionEmpty = ejbFacade.isEquiposCollectionEmpty(selected);
        } else {
            this.isEquiposCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Equipos entities that are
     * retrieved from Tipoequipos and returns the navigation outcome.
     *
     * @return navigation outcome for Equipos page
     */
    public String navigateEquiposCollection() {
        Tipoequipos selected = this.getSelected();
        if (selected != null) {
            TipoequiposFacade ejbFacade = (TipoequiposFacade) this.getFacade();
            Collection<Equipos> selectedEquiposCollection = ejbFacade.findEquiposCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Equipos_items", selectedEquiposCollection);
        }
        return "/app/equipos/index";
    }

}
