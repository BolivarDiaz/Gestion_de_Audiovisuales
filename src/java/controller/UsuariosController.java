package controller;

import entityclasespack.Usuarios;
import entityclasespack.Rentaydevolucion;
import java.util.Collection;
import facade.UsuariosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "usuariosController")
@ViewScoped
public class UsuariosController extends AbstractController<Usuarios> {

    // Flags to indicate if child collections are empty
    private boolean isRentaydevolucionCollectionEmpty;

    public UsuariosController() {
        // Inform the Abstract parent controller of the concrete Usuarios Entity
        super(Usuarios.class);
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
        Usuarios selected = this.getSelected();
        if (selected != null) {
            UsuariosFacade ejbFacade = (UsuariosFacade) this.getFacade();
            this.isRentaydevolucionCollectionEmpty = ejbFacade.isRentaydevolucionCollectionEmpty(selected);
        } else {
            this.isRentaydevolucionCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Rentaydevolucion entities
     * that are retrieved from Usuarios and returns the navigation outcome.
     *
     * @return navigation outcome for Rentaydevolucion page
     */
    public String navigateRentaydevolucionCollection() {
        Usuarios selected = this.getSelected();
        if (selected != null) {
            UsuariosFacade ejbFacade = (UsuariosFacade) this.getFacade();
            Collection<Rentaydevolucion> selectedRentaydevolucionCollection = ejbFacade.findRentaydevolucionCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Rentaydevolucion_items", selectedRentaydevolucionCollection);
        }
        return "/app/rentaydevolucion/index";
    }

}
