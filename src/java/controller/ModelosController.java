package controller;

import entityclasespack.Modelos;
import entityclasespack.Equipos;
import java.util.Collection;
import facade.ModelosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "modelosController")
@ViewScoped
public class ModelosController extends AbstractController<Modelos> {

    @Inject
    private MarcasController idmarcasController;

    // Flags to indicate if child collections are empty
    private boolean isEquiposCollectionEmpty;

    public ModelosController() {
        // Inform the Abstract parent controller of the concrete Modelos Entity
        super(Modelos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idmarcasController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsEquiposCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Marcas controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdmarcas(ActionEvent event) {
        Modelos selected = this.getSelected();
        if (selected != null && idmarcasController.getSelected() == null) {
            idmarcasController.setSelected(selected.getIdmarcas());
        }
    }

    public boolean getIsEquiposCollectionEmpty() {
        return this.isEquiposCollectionEmpty;
    }

    private void setIsEquiposCollectionEmpty() {
        Modelos selected = this.getSelected();
        if (selected != null) {
            ModelosFacade ejbFacade = (ModelosFacade) this.getFacade();
            this.isEquiposCollectionEmpty = ejbFacade.isEquiposCollectionEmpty(selected);
        } else {
            this.isEquiposCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Equipos entities that are
     * retrieved from Modelos and returns the navigation outcome.
     *
     * @return navigation outcome for Equipos page
     */
    public String navigateEquiposCollection() {
        Modelos selected = this.getSelected();
        if (selected != null) {
            ModelosFacade ejbFacade = (ModelosFacade) this.getFacade();
            Collection<Equipos> selectedEquiposCollection = ejbFacade.findEquiposCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Equipos_items", selectedEquiposCollection);
        }
        return "/app/equipos/index";
    }

}
