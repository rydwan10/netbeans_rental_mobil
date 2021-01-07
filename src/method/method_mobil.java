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
import form.form_mobil;

/**
 *
 * @author Muhammad Rydwan
 */
public class method_mobil {
    Connection con = new Rental_mobil().getCon();
    Statement stat = null;
    ResultSet res = null;
    String sql = "";
    
    public void bersih(form_mobil b){
       
        b.jtnama.setText(null);
        b.jtharga.setText(null);
        b.jtwarna.setText(null);
        b.jtpolisi.setText(null);
        b.jtcari.setText(null);
        
    }
    
    public void kunci(form_mobil k){
        k.jtid.setEnabled(false);
        k.jtnama.setEnabled(false);
        k.jtharga.setEnabled(false);
        k.jtpolisi.setEnabled(false);
        k.jtwarna.setEnabled(false);
       
 
        k.jbhapus.setEnabled(false);
        k.jbsimpan.setEnabled(false);
        k.jbubah.setEnabled(false);
        k.jbtambah.setEnabled(true);
   
    }
    
    public void buka_kunci(form_mobil bk){
        bk.jtid.setEnabled(false);
        bk.jtnama.setEnabled(true);
        bk.jtharga.setEnabled(true);
        bk.jtpolisi.setEnabled(true);
        bk.jtwarna.setEnabled(true);
        bk.jtcari.setEnabled(true);
        bk.jccari.setEnabled(true);
        
        bk.jtnama.requestFocus();
        bk.jbhapus.setEnabled(false);
        bk.jbsimpan.setEnabled(true);
        bk.jbubah.setEnabled(false); 
        bk.jbtambah.setEnabled(false);
    }
    
    public void tampil_data(form_mobil td){
        
        DefaultTableModel tbMobil = new DefaultTableModel();
        tbMobil.addColumn("ID Mobil");
        tbMobil.addColumn("Nama");
        tbMobil.addColumn("Harga Sewa");
        tbMobil.addColumn("Warna");
        tbMobil.addColumn("No. Polisi");
       
        try{
             sql = "SELECT * FROM mobil";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while (res.next()){
                tbMobil.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
            }
            td.jtablemobil.setModel(tbMobil);
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
        
        public void klik_table(form_mobil kt){
           try{
               int row = kt.jtablemobil.getSelectedRow();
        
        kt.jtid.setText(kt.jtablemobil.getModel().getValueAt(row, 0).toString());
        kt.jtnama.setText(kt.jtablemobil.getModel().getValueAt(row, 1).toString());
        kt.jtharga.setText(kt.jtablemobil.getModel().getValueAt(row, 2).toString());
        kt.jtwarna.setText(kt.jtablemobil.getModel().getValueAt(row, 3).toString());
        kt.jtpolisi.setText(kt.jtablemobil.getModel().getValueAt(row, 4).toString());
     
        kt.jbsimpan.setEnabled(false);
        kt.jbhapus.setEnabled(true);
        kt.jbubah.setEnabled(true);
        
        kt.jtnama.setEnabled(true);
        kt.jtwarna.setEnabled(true);
        kt.jtharga.setEnabled(true);
        kt.jtpolisi.setEnabled(true);
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        
    
}
  }       
        public void ubah (form_mobil u){
               
        try{
         int pesan = JOptionPane.showConfirmDialog(null, "Yakin ubah data mobil ini?", "Konfirmasi", 0, 3);
           if (pesan == 0){
               sql = "UPDATE mobil SET nama_mobil = '"+ u.jtnama.getText() +"', harga_sewa = '"+ u.jtharga.getText() +"', warna = '"+ u.jtwarna.getText() +"', no_polisi = '"+ u.jtpolisi.getText() +"' WHERE id_mobil = '"+ u.jtid.getText() +"'  ";
               stat = con.createStatement();
               stat.executeUpdate(sql);
               
               JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
               tampil_data(u);
               kunci (u);
               kd_oto(u);
               bersih(u);
              u.jbubah.setEnabled(false);
              u.jbhapus.setEnabled(false);
           }else if(pesan == 1){
               bersih(u);
               kd_oto(u);
               kunci(u);
               u.jtnama.requestFocus();
               u.jbubah.setEnabled(false);
               u.jbhapus.setEnabled(false);
           }
           }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
                   }
           }
         public void kd_oto (form_mobil ko){
         try{
            
            sql = "SELECT * FROM mobil ORDER BY id_mobil DESC";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            if(res.next()){
                String KD_user = res.getString("id_mobil").substring(1);
                String AN = "" + (Integer.parseInt(KD_user)+1);
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
                ko.jtid.setText("M" + Nol + AN);
            }else{
                ko.jtid.setText("M00001");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
         }
         public void simpan(form_mobil s){
           if(s.jtnama.getText().isEmpty() || s.jtharga.getText().isEmpty() || s.jtwarna.getText().isEmpty() || s.jtpolisi.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Isi semua data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
           s.jtnama.requestFocus();
       }else{
            try{
            sql = "INSERT INTO mobil (id_mobil, nama_mobil, harga_sewa, warna, no_polisi) VALUES ('"+s.jtid.getText()+"', '"+s.jtnama.getText()+"', '"+s.jtharga.getText()+"', '"+s.jtwarna.getText()+"', '"+s.jtpolisi.getText()+"')";
            stat = con.createStatement();
            stat.execute(sql);
            
           int pesan = JOptionPane.showConfirmDialog(null, "Data berhasil tersimpan, tambah lagi?", "Konfirmasi", 0, 3);
           if (pesan == 0){
               bersih(s);
               kd_oto(s);
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
        public void hapus (form_mobil h){
        try{
         int pesan = JOptionPane.showConfirmDialog(null, "Yakin hapus data mobil ini?", "Konfirmasi", 0, 3);
           if (pesan == 0){
              
               sql = "DELETE FROM mobil WHERE id_mobil = '"+ h.jtid.getText() +"' ";
               stat = con.createStatement();
               stat.execute(sql);
               
               JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
               tampil_data(h);
               bersih(h);
               h.jtid.requestFocus();
               kd_oto(h);
               kunci(h);
               h.jbhapus.setEnabled(false);
                h.jbubah.setEnabled(false);
           }else if(pesan == 1){
              bersih(h);
              kd_oto(h);
              kunci(h);
              h.jbhapus.setEnabled(false);
              h.jbubah.setEnabled(false);
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
}
        public void cari_data(form_mobil cd){
       
        DefaultTableModel tbMobil = new DefaultTableModel();
        tbMobil.addColumn("ID Mobil");
        tbMobil.addColumn("Nama");
        tbMobil.addColumn("Harga Sewa");
        tbMobil.addColumn("Warna");
        tbMobil.addColumn("No. Polisi");
       
        try{
           if(cd.jccari.getSelectedItem().equals("ID")){
               sql = "SELECT * FROM  mobil WHERE id_mobil LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           
           }else if(cd.jccari.getSelectedItem().equals("Nama")){
               sql = "SELECT * FROM  mobil WHERE nama_mobil LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Harga")){
               sql = "SELECT * FROM  mobil WHERE harga_sewa LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Warna")){
               sql = "SELECT * FROM  mobil WHERE warna LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("No. Polisi")){
               sql = "SELECT * FROM  mobil WHERE no_polisi LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }
           while (res.next()){
                tbMobil.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
            }
            cd.jtablemobil.setModel(tbMobil);
           
            
           
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
            
        
        }
}
