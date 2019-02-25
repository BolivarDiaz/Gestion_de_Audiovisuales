/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
/**
 *
 * @author Bolivar
 */
public class ComprobarLogin {
    static String tipousuario;
 
     public static boolean login(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/GestionAudiovisualesDB", "pas", "pas") ;
            ps = con.prepareStatement(
                    "select nombre, nocarnet,tipousuario from usuarios where nombre= ? and nocarnet= ? ");
            ps.setString(1, user);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(rs.getString("nombre"));
             tipousuario=rs.getString("tipousuario");
                /*PreparedStatement pt=con.prepareStatement("select tipousuario from usuarios where nombre='"+user+"' and nocarnet="+password+" ");
                ResultSet myrs=pt.executeQuery();
                while(myrs.next()){
                    tipousuario=myrs.getString(tipousuario);
                    
                }*/
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
            
        }
    }
    
    
    
    
}
