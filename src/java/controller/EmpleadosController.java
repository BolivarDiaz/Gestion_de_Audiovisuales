package controller;

import entityclasespack.Empleados;
import entityclasespack.Rentaydevolucion;
import java.util.Collection;
import facade.EmpleadosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "empleadosController")
@ViewScoped
public class EmpleadosController extends AbstractController<Empleados> {

    // Flags to indicate if child collections are empty
    private boolean isRentaydevolucionCollectionEmpty;

    public EmpleadosController() {
        // Inform the Abstract parent controller of the concrete Empleados Entity
        super(Empleados.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRentaydevolucionCollectionEmpty();
    }

    public boolean getIsRentaydevolucionCollectionEmpty() {
        return this.isRentaydevolucionCollectionEmpty;
    }

    private void setIsRentaydevolucionCollectionEmpty() {
        Empleados selected = this.getSelected();
        if (selected != null) {
            EmpleadosFacade ejbFacade = (EmpleadosFacade) this.getFacade();
            this.isRentaydevolucionCollectionEmpty = ejbFacade.isRentaydevolucionCollectionEmpty(selected);
        } else {
            this.isRentaydevolucionCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Rentaydevolucion entities
     * that are retrieved from Empleados and returns the navigation outcome.
     *
     * @return navigation outcome for Rentaydevolucion page
     */
    public String navigateRentaydevolucionCollection() {
        Empleados selected = this.getSelected();
        if (selected != null) {
            EmpleadosFacade ejbFacade = (EmpleadosFacade) this.getFacade();
            Collection<Rentaydevolucion> selectedRentaydevolucionCollection = ejbFacade.findRentaydevolucionCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Rentaydevolucion_items", selectedRentaydevolucionCollection);
        }
        return "/app/rentaydevolucion/index";
    }

}
