/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import rental_mobil.Rental_mobil;
import form.form_pelanggan;

/**
 *
 * @author Muhammad Rydwan
 */
public class method_pelanggan {
    Connection con = new Rental_mobil().getCon();
    Statement stat = null;
    ResultSet res = null;
    String sql = "";
    
    public void bersih(form_pelanggan b){
       
        b.jtnama.setText("");
        b.jtalamat.setText("");
        b.jtcari.setText("");
        b.jtno.setText("");
        
    }
    
    public void kunci(form_pelanggan k){
        
        k.jtnama.setEnabled(false);
        k.jtalamat.setEnabled(false);
        k.jtno.setEnabled(false);
        
        k.jbhapus.setEnabled(false);
        
        k.jbsimpan.setEnabled(false);
        k.jbubah.setEnabled(false);
       
        
      
    }
    public void buka_kunci(form_pelanggan bk){
        
        bk.jtnama.setEnabled(true);
        bk.jtnama.requestFocus();
        bk.jtalamat.setEnabled(true);
        bk.jtno.setEnabled(true);
        
        bk.jbbatal.setEnabled(true);
      
        
        bk.jbsimpan.setEnabled(true);
      
       
       
        bk.jbsimpan.setEnabled(true);
    }
     public void tampil_data(form_pelanggan td){
        
        DefaultTableModel tbPelanggan = new DefaultTableModel();
        tbPelanggan.addColumn("ID Pelanggan");
        tbPelanggan.addColumn("Nama");
        tbPelanggan.addColumn("Alamat");
        tbPelanggan.addColumn("No. Telepon");
        
        try{
            sql = "SELECT * FROM pelanggan";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while (res.next()){
                tbPelanggan.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4)});
            }
            td.jtable.setModel(tbPelanggan);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
     }
     public void id_oto(form_pelanggan io){
         try{
            
            sql = "SELECT * FROM pelanggan ORDER BY id_pelanggan DESC";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            if(res.next()){
                String id_pelanggan = res.getString("id_pelanggan").substring(1);
                String AN = "" + (Integer.parseInt(id_pelanggan)+1);
                String Nol = "";
                
                if(AN.length() == 1){
                    Nol = "0000";
                }else if(AN.length() == 2){
                    Nol = "000";
                }else if(AN.length() == 3){
                    Nol = "00";
                }else if(AN.length() == 4){
                    Nol = "0";
                }else if (AN.length() == 5){
                    Nol = "";
                }
                io.jtidpelanggan.setText("P" + Nol + AN);
            }else{
                io.jtidpelanggan.setText("P00001");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
     }
     public void simpan(form_pelanggan s){
         if(s.jtnama.getText().isEmpty() || s.jtalamat.getText().isEmpty() || s.jtno.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Isi semua data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
           s.jtnama.requestFocus();
         }else{
             
         try{
            sql = "INSERT INTO pelanggan VALUES ('"+s.jtidpelanggan.getText()+"', '"+s.jtnama.getText()+"', '"+s.jtalamat.getText()+"', '"+s.jtno.getText()+"')";
            stat = con.createStatement();
            stat.execute(sql);
            
           int pesan = JOptionPane.showConfirmDialog(null, "Data berhasil tersimpan, tambah lagi?", "Konfirmasi", 0, 3);
           if (pesan == 0){
               bersih(s);
               id_oto(s);
               tampil_data(s);
               s.jtnama.requestFocus();
           }else if(pesan == 1){
             kunci(s);
             bersih(s);
             tampil_data(s);
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
               }
     }
     public void hapus (form_pelanggan h){
            try{
         int pesan = JOptionPane.showConfirmDialog(null, "Yakin hapus data pelanggan ini?", "Konfirmasi", 0, 3);
           if (pesan == 0){
              
               sql = "DELETE FROM pelanggan WHERE id_pelanggan = '"+ h.jtidpelanggan.getText() +"' ";
               stat = con.createStatement();
               stat.execute(sql);
               
               JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
               tampil_data(h);
               bersih(h);
               h.jtidpelanggan.requestFocus();
               id_oto(h);
               kunci(h);
               h.jbhapus.setEnabled(false);
                h.jbubah.setEnabled(false);
           }else if(pesan == 1){
              bersih(h);
              id_oto(h);
              kunci(h);
              h.jbhapus.setEnabled(false);
              h.jbubah.setEnabled(false);
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
     }
     
     public void ubah(form_pelanggan u){
         try{
         int pesan = JOptionPane.showConfirmDialog(null, "Yakin ubah data pelanggan ini?", "Konfirmasi", 0, 3);
           if (pesan == 0){
               sql = "UPDATE pelanggan SET nama = '"+ u.jtnama.getText() +"', alamat = '"+ u.jtalamat.getText() +"', no_telp = '"+ u.jtno.getText() +"' WHERE id_pelanggan = '"+ u.jtidpelanggan.getText() +"'  ";
               stat = con.createStatement();
               stat.executeUpdate(sql);
               
               JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
               tampil_data(u);
               kunci (u);
               id_oto(u);
               bersih(u);
              u.jbubah.setEnabled(false);
              u.jbhapus.setEnabled(false);
           }else if(pesan == 1){
               bersih(u);
               id_oto(u);
               kunci(u);
               u.jtnama.requestFocus();
               u.jbubah.setEnabled(false);
               u.jbhapus.setEnabled(false);
           }
           }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
                   }
     }
     public void cari_data (form_pelanggan cd){
         DefaultTableModel tbPelanggan = new DefaultTableModel();
        tbPelanggan.addColumn("ID Pelanggan");
        tbPelanggan.addColumn("Nama");
        tbPelanggan.addColumn("Alamat");
        tbPelanggan.addColumn("No. Telepon");
      
       
        try{
           if(cd.jccari.getSelectedItem().equals("ID")){
               sql = "SELECT * FROM  pelanggan WHERE id_pelanggan LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           
           }else if(cd.jccari.getSelectedItem().equals("Nama")){
               sql = "SELECT * FROM  pelanggan WHERE nama LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Alamat")){
               sql = "SELECT * FROM  pelanggan WHERE alamat LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Telepon")){
               sql = "SELECT * FROM  pelanggan WHERE no_telp LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }
           while (res.next()){
                tbPelanggan.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4)});
            }
            cd.jtable.setModel(tbPelanggan);
           
            
           
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
     }
     public void klik_table(form_pelanggan kt){
           try{
               int row = kt.jtable.getSelectedRow();
        
        kt.jtidpelanggan.setText(kt.jtable.getModel().getValueAt(row, 0).toString());
        kt.jtnama.setText(kt.jtable.getModel().getValueAt(row, 1).toString());
        kt.jtalamat.setText(kt.jtable.getModel().getValueAt(row, 2).toString());
        kt.jtno.setText(kt.jtable.getModel().getValueAt(row, 3).toString());
       
     
        kt.jbsimpan.setEnabled(false);
        kt.jbhapus.setEnabled(true);
        kt.jbubah.setEnabled(true);
        
        kt.jtnama.setEnabled(true);
        kt.jtalamat.setEnabled(true);
        kt.jtno.setEnabled(true);
       
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        
    
}
     
}
}
