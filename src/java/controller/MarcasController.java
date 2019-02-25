package controller;

import entityclasespack.Marcas;
import entityclasespack.Modelos;
import entityclasespack.Equipos;
import java.util.Collection;
import facade.MarcasFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "marcasController")
@ViewScoped
public class MarcasController extends AbstractController<Marcas> {

    // Flags to indicate if child collections are empty
    private boolean isModelosCollectionEmpty;
    private boolean isEquiposCollectionEmpty;

    public MarcasController() {
        // Inform the Abstract parent controller of the concrete Marcas Entity
        super(Marcas.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsModelosCollectionEmpty();
        this.setIsEquiposCollectionEmpty();
    }

    public boolean getIsModelosCollectionEmpty() {
        return this.isModelosCollectionEmpty;
    }

    private void setIsModelosCollectionEmpty() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            this.isModelosCollectionEmpty = ejbFacade.isModelosCollectionEmpty(selected);
        } else {
            this.isModelosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Modelos entities that are
     * retrieved from Marcas and returns the navigation outcome.
     *
     * @return navigation outcome for Modelos page
     */
    public String navigateModelosCollection() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            Collection<Modelos> selectedModelosCollection = ejbFacade.findModelosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Modelos_items", selectedModelosCollection);
        }
        return "/app/modelos/index";
    }

    public boolean getIsEquiposCollectionEmpty() {
        return this.isEquiposCollectionEmpty;
    }

    private void setIsEquiposCollectionEmpty() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            this.isEquiposCollectionEmpty = ejbFacade.isEquiposCollectionEmpty(selected);
        } else {
            this.isEquiposCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Equipos entities that are
     * retrieved from Marcas and returns the navigation outcome.
     *
     * @return navigation outcome for Equipos page
     */
    public String navigateEquiposCollection() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            Collection<Equipos> selectedEquiposCollection = ejbFacade.findEquiposCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Equipos_items", selectedEquiposCollection);
        }
        return "/app/equipos/index";
    }

}
