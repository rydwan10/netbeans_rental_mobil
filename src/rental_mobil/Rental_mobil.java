/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental_mobil;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
/**
 *
 * @author Muhammad Rydwan
 */
public class Rental_mobil {
    
    Connection connect = null;
    
    public Connection getCon(){
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return connect;
    }
   
    public static void main(String[] args) {
       // new form.form_login().setVisible(true);
     new form.form_login().setVisible(true);
    
    }
    
}
