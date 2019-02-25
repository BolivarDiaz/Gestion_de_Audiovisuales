/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;



/**
 *
 * @author Bolivar
 */
@Named(value = "rangousuario")
@ManagedBean
@Dependent
public class rangousuario {

    /**
     * Creates a new instance of rangousuario
     * 
     * 
     */
    boolean rango;
    public rangousuario() {
            if(ComprobarLogin.tipousuario.equals("Normal")){
        rango=true;
    }else{
        rango=false;
    }
    }

    public boolean isRango() {
        return rango;
    }

    public void setRango(boolean rango) {
        this.rango = rango;
    }
    /*
       public void validate(FacesContext arg0, UIComponent arg1, Object arg2)throws ValidatorException {
      
      if (ComprobarLogin.tipousuario.equals("Normal")) {
         throw new ValidatorException(new FacesMessage("No tienes permiso para acceder a ese modulo!"));
      }
   }*/
       
     
}
