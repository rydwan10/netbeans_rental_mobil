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
import form.form_karyawan;

/**
 *
 * @author Muhammad Rydwan
 */
public class method_karyawan {
    Connection con = new Rental_mobil().getCon();
    Statement stat = null;
    ResultSet res = null;
    String sql = "";
    
    public void bersih (form_karyawan b){
      
        b.jtNama.setText(null);
        b.jtAlamat.setText(null);
        b.jtTelepon.setText(null);
        b.jcStatus.setSelectedItem("--Pilihan--");
        b.jtUsername.setText(null);
        b.jpPassword.setText(null);
        b.jpKonfirmasi.setText(null);
    }
    public void kunci (form_karyawan k){
        
        k.jtNama.setEnabled(false);
        k.jtAlamat.setEnabled(false);
        k.jtTelepon.setEnabled(false);
        k.jcStatus.setEnabled(false);
        k.jtUsername.setEnabled(false);
        k.jpPassword.setEnabled(false);
        k.jpKonfirmasi.setEnabled(false);
        
        k.btnSimpan.setEnabled(false);
        k.btnUbah.setEnabled(false);
        k.btnHapus.setEnabled(false);
    }
    public void buka_kunci(form_karyawan bk){
       
        bk.jtNama.setEnabled(true);
         bk.jtNama.requestFocus();
        bk.jtAlamat.setEnabled(true);
        bk.jtTelepon.setEnabled(true);
        bk.jcStatus.setEnabled(true);
        bk.jtUsername.setEnabled(true);
        bk.jpPassword.setEnabled(true);
        bk.jpKonfirmasi.setEnabled(true);
        
        bk.btnSimpan.setEnabled(true);
        
    }
    
    public void tampil_data(form_karyawan td){
        
        DefaultTableModel tbPegawai = new DefaultTableModel();
        tbPegawai.addColumn("ID Karyawan");
        tbPegawai.addColumn("Nama");
        tbPegawai.addColumn("Alamat");
        tbPegawai.addColumn("No. Telepon");
        tbPegawai.addColumn("Status");
        tbPegawai.addColumn("Username");
        tbPegawai.addColumn("Password");
        
        try{
            String sql = "SELECT id_karyawan, nama, alamat, no_telp, status, username, password FROM karyawan";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while (res.next()){
                tbPegawai.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7)});
            }
            td.tblKaryawan.setModel(tbPegawai);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void klik_table(form_karyawan kt){
         try {
             int row = kt.tblKaryawan.getSelectedRow();
        
        kt.jtID.setText(kt.tblKaryawan.getModel().getValueAt(row, 0).toString());
        kt.jtNama.setText(kt.tblKaryawan.getModel().getValueAt(row, 1).toString());
        kt.jtAlamat.setText(kt.tblKaryawan.getModel().getValueAt(row, 2).toString());
        kt.jtTelepon.setText(kt.tblKaryawan.getModel().getValueAt(row, 3).toString());
        kt.jcStatus.setSelectedItem(kt.tblKaryawan.getModel().getValueAt(row, 4).toString());
        kt.jtUsername.setText(kt.tblKaryawan.getModel().getValueAt(row, 5).toString());
        kt.jpPassword.setText(kt.tblKaryawan.getModel().getValueAt(row, 6).toString());
        
        
     
        kt.btnSimpan.setEnabled(false);
        kt.btnHapus.setEnabled(true);
        kt.btnUbah.setEnabled(true);
        
        kt.jtNama.setEnabled(true);
        kt.jtAlamat.setEnabled(true);
        kt.jtTelepon.setEnabled(true);
        kt.jcStatus.setEnabled(true);
        kt.jtUsername.setEnabled(true);
        kt.jtUsername.setEnabled(true);
        kt.jpPassword.setEnabled(true);
        kt.jpKonfirmasi.setEnabled(true);
        
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
       
    }
    public void kd_oto (form_karyawan ko){
         try{
            
            sql = "SELECT * FROM karyawan ORDER BY id_karyawan DESC";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            if(res.next()){
                String KD_user = res.getString("id_karyawan").substring(1);
                System.out.println(KD_user);
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
                    ko.jtID.setText("K" + Nol + AN);
                }else{
                    ko.jtID.setText("K00001");
                }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void simpan (form_karyawan s){
          if(s.jtNama.getText().isEmpty() || s.jtAlamat.getText().isEmpty() || s.jtTelepon.getText().isEmpty() || s.jcStatus.getSelectedItem().equals("--Pilihan--")|| s.jtUsername.getText().isEmpty() || s.jpPassword.getText().isEmpty() || s.jpKonfirmasi.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Isi semua data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
       }else if(s.jpPassword.getText() == null ? s.jpKonfirmasi.getText() !=null : !s.jpPassword.getText().equals(s.jpKonfirmasi.getText())){
           JOptionPane.showMessageDialog(null, "Pengetikan password tidak sama! Periksa kembali!", "Peringatan", JOptionPane.WARNING_MESSAGE);
       }else{
            try{
            sql = "INSERT INTO karyawan (id_karyawan, nama, alamat, no_telp, status, username, password) VALUES ('"+s.jtID.getText()+"', '"+s.jtNama.getText()+"', '"+s.jtAlamat.getText()+"', '"+s.jtTelepon.getText()+"', '"+s.jcStatus.getSelectedItem().toString()+"', '"+s.jtUsername.getText()+"', '"+s.jpPassword.getText()+"')";
            stat = con.createStatement();
            stat.execute(sql);
            
           int pesan = JOptionPane.showConfirmDialog(null, "Data berhasil tersimpan, tambah lagi?", "Konfirmasi", 0, 3);
           if (pesan == 0){
               bersih(s);
               kd_oto(s);
               tampil_data(s);
               s.jtNama.requestFocus();
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
    public void ubah (form_karyawan u){
        try{
         int pesan = JOptionPane.showConfirmDialog(null, "Yakin ubah data karyawan ini?", "Konfirmasi", 0, 3);
           if (pesan == 0){
               sql = "UPDATE karyawan SET nama = '"+ u.jtNama.getText() +"', alamat = '"+ u.jtAlamat.getText() +"', no_telp = '"+ u.jtTelepon.getText() +"', status = '"+ u.jcStatus.getSelectedItem() +"', username = '"+ u.jtUsername.getText() +"', password = '"+ u.jpPassword.getText() +"' WHERE id_karyawan = '"+ u.jtID.getText() +"'  ";
               stat = con.createStatement();
               stat.executeUpdate(sql);
               
               JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
               tampil_data(u);
               kunci (u);
               kd_oto(u);
               bersih(u);
              u.btnUbah.setEnabled(false);
              u.btnHapus.setEnabled(false);
           }else if(pesan == 1){
               bersih(u);
               kd_oto(u);
               kunci(u);
               u.jtNama.requestFocus();
               u.btnUbah.setEnabled(false);
               u.btnHapus.setEnabled(false);
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void hapus (form_karyawan h){
        try{
         int pesan = JOptionPane.showConfirmDialog(null, "Yakin ubah hapus data karyawan ini?", "Konfirmasi", 0, 3);
           if (pesan == 0){
              
               sql = "DELETE FROM karyawan WHERE id_karyawan = '"+ h.jtID.getText() +"' ";
               stat = con.createStatement();
               stat.execute(sql);
               
               JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
               tampil_data(h);
               bersih(h);
               h.jtID.requestFocus();
               kd_oto(h);
               kunci(h);
               h.btnHapus.setEnabled(false);
                h.btnUbah.setEnabled(false);
           }else if(pesan == 1){
              bersih(h);
              kd_oto(h);
              kunci(h);
              h.btnHapus.setEnabled(false);
              h.btnUbah.setEnabled(false);
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void cari_data(form_karyawan cd){
        
        DefaultTableModel tbPegawai = new DefaultTableModel();
        tbPegawai.addColumn("ID Karyawan");
        tbPegawai.addColumn("Nama");
        tbPegawai.addColumn("Alamat");
        tbPegawai.addColumn("No. Telepon");
        tbPegawai.addColumn("Status");
        tbPegawai.addColumn("Username");
        tbPegawai.addColumn("Password");
        
        try{
            if(cd.jcCari.getSelectedItem().equals("ID")){
            sql = "SELECT id_karyawan, nama, alamat, no_telp, status, username, password FROM karyawan WHERE id_karyawan LIKE '%"+ cd.jtCari.getText() +"%' ";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            }else if(cd.jcCari.getSelectedItem().equals("Nama")){
            sql = "SELECT id_karyawan, nama, alamat, no_telp, status, username, password FROM karyawan WHERE nama LIKE '%"+ cd.jtCari.getText() +"%' ";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            }else if(cd.jcCari.getSelectedItem().equals("Alamat")){
            sql = "SELECT id_karyawan, nama, alamat, no_telp, status, username, password FROM karyawan WHERE alamat LIKE '%"+ cd.jtCari.getText() +"%' ";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            }else if(cd.jcCari.getSelectedItem().equals("Status")){
            sql = "SELECT id_karyawan, nama, alamat, no_telp, status, username, password FROM karyawan WHERE status LIKE '%"+ cd.jtCari.getText() +"%' ";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            }else if(cd.jcCari.getSelectedItem().equals("Username")){
            sql = "SELECT id_karyawan, nama, alamat, no_telp, status, username, password FROM karyawan WHERE username LIKE '%"+ cd.jtCari.getText() +"%' ";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            }
            
            while (res.next()){
                tbPegawai.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7)});
            }
            cd.tblKaryawan.setModel(tbPegawai);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
            
}
