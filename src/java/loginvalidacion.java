/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Bolivar
 */

@ManagedBean(name ="loginvalidaicon")
@SessionScoped



public class loginvalidacion implements Serializable {
private static final long serialVersionUID = 1L;
static boolean rango=false;
String nombre;
String pass;

    public boolean isRango() {
        return rango;
    }

    public void setRango(boolean rango) {
        this.rango = rango;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    /**
     * Creates a new instance of loginvalidacion
     */
   
    public String mostrarnombre(){
    return "Usuario actual: "+nombre;
    }
    
 public String loginEfecto() {
     System.out.println("Esta llamando al metodo");
        boolean result = ComprobarLogin.login(nombre, pass);
        

         
        if (result) {
            return "index";
            
            
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Credenciales Invalidas!",
                    "Please Try Again!"));
            return "Login";
        }
    
 
    }
}
    
  
    
