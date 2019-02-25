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
@Named(value = "validacioncedula")
@Dependent
@ManagedBean
public class validacioncedula {

    /**
     * Creates a new instance of validacioncedula
     */
    public validacioncedula() {
        
    }
    
    public void validate(FacesContext arg0, UIComponent arg1, Object arg2)throws ValidatorException {
      
      if ((validarCedula((String)arg2))==false) {
         throw new ValidatorException(new FacesMessage("Cedula incorrecta!"));
      }
   }
    
    
    



public static boolean validarCedula(String cedula)
{

    int suma = 0;

    final char[] peso = { '1', '2', '1', '2', '1', '2', '1', '2', '1', '2' };

    // Comprobaciones iniciales


    if ((cedula == null) || (cedula.length() != 11))
            return false;

    // Si no es un nº => la descartamos
   

 	try
    {Long.parseLong(cedula);}

    		
	catch (Exception e)
    {
            return false;
    }



    
	for (int i = 0; i < 10; i++)
    {


		 int a = Character.getNumericValue(cedula.charAt(i));

	         int b = Character.getNumericValue(peso[i]);

	
	         char[] mult = Integer.toString(a * b).toCharArray();

	         if (mult.length > 1)
{

			a = Character.getNumericValue(mult[0]);

	                b = Character.getNumericValue(mult[1]);

	         }
else
{

                    	a = 0;
	                b = Character.getNumericValue(mult[0]);

            	 }

	
		suma = suma + a + b;
	}

	
	int digito = (10 - (suma % 10)) % 10;

    // Comprobamos que el dígito de control coincide
    

	if (digito != Character.getNumericValue(cedula.charAt(10)))
            return false;

    return true;
}
    
    
}
