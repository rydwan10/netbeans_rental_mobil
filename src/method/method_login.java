/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import rental_mobil.Rental_mobil;
import form.form_login;
import form.form_menu_utama;

import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Rydwan
 */
public class method_login {
    Connection con = new Rental_mobil().getCon();
    Statement stat = null;
    ResultSet res = null;
    String sql = "";
   
    
    public void bersih (form_login b){
        b.jtUsername.setText("");
        b.jpPassword.setText("");
    }
    public void login (form_login l){
        
      if(l.jtUsername.getText().isEmpty() || l.jpPassword.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
      }else{
          
          try{
              
                sql = "SELECT * FROM karyawan WHERE username = '"+ l.jtUsername.getText() +"' ";
                stat = con.createStatement();
                res = stat.executeQuery(sql);
               
                if(res.next()){
                    
                    if(l.jpPassword.getText().equals(res.getString("password"))){
//                      String hakakses  = res.getString(5);
                       String IDkaryawan = res.getString(1);
                        //login berhasil
                       l.dispose();
                       JOptionPane.showMessageDialog(null, "Selamat Datang '"+res.getString(2)+"'!", "Login Berhasil!", JOptionPane.INFORMATION_MESSAGE);
                       form_menu_utama x = new form_menu_utama(IDkaryawan);
                     
                       x.setVisible(true);
                       
                        
                    }else{
                        int pesan = JOptionPane.showConfirmDialog(null, "Username atau Password salah!, ulangi?", "Konfirmasi",  0, 3);
                        if (pesan == 0){
                            l.jtUsername.setText("");
                            l.jtUsername.requestFocus();
                            
                        }else if(pesan == 1){
                            System.exit(0);
                        }
                    }
                }else{
                    int pesan = JOptionPane.showConfirmDialog(null, "Username atau Password tidak ditemukan!, ulangi?", "Konfirmasi",  0, 3);
                        if (pesan == 0){
                            l.jtUsername.setText("");
                            l.jpPassword.setText("");
                            l.jtUsername.requestFocus();
                            
                        }else if(pesan == 1){
                            System.exit(0);
                        }
                }
              
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, e, "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE);
              e.printStackTrace();
          }
          
      }
        
    }
    private void loginAdmin(form_menu_utama la){
        la.btnKaryawan.setEnabled(true);
        la.btnMerental.setEnabled(false);
    }
  
    
    
    
}
