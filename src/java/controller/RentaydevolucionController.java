package controller;

import entityclasespack.Rentaydevolucion;
import facade.RentaydevolucionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "rentaydevolucionController")
@ViewScoped
public class RentaydevolucionController extends AbstractController<Rentaydevolucion> {

    @Inject
    private EmpleadosController idempleadoController;
    @Inject
    private EquiposController idequipoController;
    @Inject
    private UsuariosController idusuarioController;

    public RentaydevolucionController() {
        // Inform the Abstract parent controller of the concrete Rentaydevolucion Entity
        super(Rentaydevolucion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idempleadoController.setSelected(null);
        idequipoController.setSelected(null);
        idusuarioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Empleados controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdempleado(ActionEvent event) {
        Rentaydevolucion selected = this.getSelected();
        if (selected != null && idempleadoController.getSelected() == null) {
            idempleadoController.setSelected(selected.getIdempleado());
        }
    }

    /**
     * Sets the "selected" attribute of the Equipos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdequipo(ActionEvent event) {
        Rentaydevolucion selected = this.getSelected();
        if (selected != null && idequipoController.getSelected() == null) {
            idequipoController.setSelected(selected.getIdequipo());
        }
    }

    /**
     * Sets the "selected" attribute of the Usuarios controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdusuario(ActionEvent event) {
        Rentaydevolucion selected = this.getSelected();
        if (selected != null && idusuarioController.getSelected() == null) {
            idusuarioController.setSelected(selected.getIdusuario());
        }
    }

}
