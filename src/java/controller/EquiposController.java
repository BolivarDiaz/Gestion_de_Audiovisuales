package controller;

import entityclasespack.Equipos;
import entityclasespack.Rentaydevolucion;
import java.util.Collection;
import facade.EquiposFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "equiposController")
@ViewScoped
public class EquiposController extends AbstractController<Equipos> {

    @Inject
    private MarcasController idmarcasController;
    @Inject
    private ModelosController idmodeloController;
    @Inject
    private TecnologiaconeccionController idtipotconeccionController;
    @Inject
    private TipoequiposController idtipoequiposController;

    // Flags to indicate if child collections are empty
    private boolean isRentaydevolucionCollectionEmpty;

    public EquiposController() {
        // Inform the Abstract parent controller of the concrete Equipos Entity
        super(Equipos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idmarcasController.setSelected(null);
        idmodeloController.setSelected(null);
        idtipotconeccionController.setSelected(null);
        idtipoequiposController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRentaydevolucionCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Marcas controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdmarcas(ActionEvent event) {
        Equipos selected = this.getSelected();
        if (selected != null && idmarcasController.getSelected() == null) {
            idmarcasController.setSelected(selected.getIdmarcas());
        }
    }

    /**
     * Sets the "selected" attribute of the Modelos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdmodelo(ActionEvent event) {
        Equipos selected = this.getSelected();
        if (selected != null && idmodeloController.getSelected() == null) {
            idmodeloController.setSelected(selected.getIdmodelo());
        }
    }

    /**
     * Sets the "selected" attribute of the Tecnologiaconeccion controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdtipotconeccion(ActionEvent event) {
        Equipos selected = this.getSelected();
        if (selected != null && idtipotconeccionController.getSelected() == null) {
            idtipotconeccionController.setSelected(selected.getIdtipotconeccion());
        }
    }

    /**
     * Sets the "selected" attribute of the Tipoequipos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdtipoequipos(ActionEvent event) {
        Equipos selected = this.getSelected();
        if (selected != null && idtipoequiposController.getSelected() == null) {
            idtipoequiposController.setSelected(selected.getIdtipoequipos());
        }
    }

    public boolean getIsRentaydevolucionCollectionEmpty() {
        return this.isRentaydevolucionCollectionEmpty;
    }

    private void setIsRentaydevolucionCollectionEmpty() {
        Equipos selected = this.getSelected();
        if (selected != null) {
            EquiposFacade ejbFacade = (EquiposFacade) this.getFacade();
            this.isRentaydevolucionCollectionEmpty = ejbFacade.isRentaydevolucionCollectionEmpty(selected);
        } else {
            this.isRentaydevolucionCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Rentaydevolucion entities
     * that are retrieved from Equipos and returns the navigation outcome.
     *
     * @return navigation outcome for Rentaydevolucion page
     */
    public String navigateRentaydevolucionCollection() {
        Equipos selected = this.getSelected();
        if (selected != null) {
            EquiposFacade ejbFacade = (EquiposFacade) this.getFacade();
            Collection<Rentaydevolucion> selectedRentaydevolucionCollection = ejbFacade.findRentaydevolucionCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Rentaydevolucion_items", selectedRentaydevolucionCollection);
        }
        return "/app/rentaydevolucion/index";
    }

}
