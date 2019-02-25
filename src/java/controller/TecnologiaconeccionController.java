package controller;

import entityclasespack.Tecnologiaconeccion;
import entityclasespack.Equipos;
import java.util.Collection;
import facade.TecnologiaconeccionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tecnologiaconeccionController")
@ViewScoped
public class TecnologiaconeccionController extends AbstractController<Tecnologiaconeccion> {

    // Flags to indicate if child collections are empty
    private boolean isEquiposCollectionEmpty;

    public TecnologiaconeccionController() {
        // Inform the Abstract parent controller of the concrete Tecnologiaconeccion Entity
        super(Tecnologiaconeccion.class);
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
        Tecnologiaconeccion selected = this.getSelected();
        if (selected != null) {
            TecnologiaconeccionFacade ejbFacade = (TecnologiaconeccionFacade) this.getFacade();
            this.isEquiposCollectionEmpty = ejbFacade.isEquiposCollectionEmpty(selected);
        } else {
            this.isEquiposCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Equipos entities that are
     * retrieved from Tecnologiaconeccion and returns the navigation outcome.
     *
     * @return navigation outcome for Equipos page
     */
    public String navigateEquiposCollection() {
        Tecnologiaconeccion selected = this.getSelected();
        if (selected != null) {
            TecnologiaconeccionFacade ejbFacade = (TecnologiaconeccionFacade) this.getFacade();
            Collection<Equipos> selectedEquiposCollection = ejbFacade.findEquiposCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Equipos_items", selectedEquiposCollection);
        }
        return "/app/equipos/index";
    }

}
