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
import form.form_merental;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;


/**
 *
 * @author Muhammad Rydwan
 */
public class method_merental {
    Connection con = new Rental_mobil().getCon();
    Statement stat = null;
    ResultSet res = null;
    String sql = "";
    
    public void bersih (form_merental b){
       b.jtnorental.setText(null);
       b.jtidpelanggan.setText(null);
       b.jcpelanggan.setSelectedItem("--Pilihan--");
       b.jtidmobil.setText(null);
       b.jcmobil.setSelectedItem("--Pilihan--");
       b.jdtanggalrental.setDate(null);
       b.jdtanggalkembali.setDate(null);
       b.jtcari.setText(null);
      // b.jtidkaryawan.setText(null);
       b.jthargasewa.setText(null);
    }
    public void kunci (form_merental k){
        k.jtnorental.setEnabled(false);
        k.jtidpelanggan.setEnabled(false);
        k.jcpelanggan.setEnabled(false);
        k.jtidmobil.setEnabled(false);
        k.jcmobil.setEnabled(false);
        k.jdtanggalrental.setEnabled(false);
        k.jdtanggalkembali.setEnabled(false);
        k.jtidkaryawan.setEnabled(false);
        k.jthargasewa.setEnabled(false);
        
        k.jbsimpan.setEnabled(false);
        k.jbhapus.setEnabled(false);
        k.jbubah.setEnabled(false);
        k.jbtambah.setEnabled(true);
        k.jbbatal.setEnabled(false);
    }
    public void buka_kunci(form_merental bk){
        bk.jtnorental.setEnabled(false);
        bk.jtidpelanggan.setEnabled(false);
        bk.jcpelanggan.setEnabled(true);
        bk.jtidmobil.setEnabled(false);
        bk.jcmobil.setEnabled(true);
        bk.jdtanggalrental.setEnabled(true);
        bk.jdtanggalkembali.setEnabled(true);
        bk.jtidkaryawan.setEnabled(false);
        bk.jthargasewa.setEnabled(false);
        
        bk.jbsimpan.setEnabled(true);
        bk.jbhapus.setEnabled(false);
        bk.jbubah.setEnabled(false);
        bk.jbtambah.setEnabled(false);
        bk.jbbatal.setEnabled(true);
    }
    public void no_oto(form_merental no){
        try{
            
            sql = "SELECT * FROM merental ORDER BY no_rental DESC";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            if(res.next()){
                String no_rental = res.getString("no_rental").substring(1);
                String AN = "" + (Integer.parseInt(no_rental)+1);
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
                no.jtnorental.setText("R" + Nol + AN);
            }else{
                no.jtnorental.setText("R00001");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    public void tampil_data (form_merental td){
        DefaultTableModel tbmerental = new DefaultTableModel();
        tbmerental.addColumn("No. Rental");
        tbmerental.addColumn("Id Pelanggan");
        tbmerental.addColumn("Id Mobil");
        tbmerental.addColumn("Harga Sewa");
        tbmerental.addColumn("Tanggal Rental");
        tbmerental.addColumn("Tanggal Kembali");
        tbmerental.addColumn("Id Karyawan");
        
        try {
            sql = "SELECT * FROM merental";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while(res.next()){
                tbmerental.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7)
                });
            }
            td.jtable.setModel(tbmerental);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    public static Date getTanggal (JTable table, int kolom){
    
            JTable tabel = table;
            String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
            Date tanggal = null;
            
        try {
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        } catch (Exception e) {
            
        }return tanggal;
    
    }
    public void klik_table(form_merental kt){
        try {
            int row = kt.jtable.getSelectedRow();
            
            kt.jtnorental.setText(kt.jtable.getModel().getValueAt(row, 0).toString());
            kt.jtidpelanggan.setText(kt.jtable.getModel().getValueAt(row, 1).toString());
            kt.jtidmobil.setText(kt.jtable.getModel().getValueAt(row, 2).toString());
            kt.jthargasewa.setText(kt.jtable.getModel().getValueAt(row, 3).toString());
            kt.jdtanggalrental.setDate(getTanggal(kt.jtable, 4));
            kt.jdtanggalkembali.setDate(getTanggal(kt.jtable, 5));
            kt.jtidkaryawan.setText(kt.jtable.getModel().getValueAt(row, 6).toString());
            
            kt.jbsimpan.setEnabled(false);
            kt.jbhapus.setEnabled(true);
            kt.jbubah.setEnabled(true);
            
            kt.jcpelanggan.setEnabled(true);
            kt.jcmobil.setEnabled(true);
            kt.jdtanggalkembali.setEnabled(true);
            kt.jdtanggalrental.setEnabled(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void simpan(form_merental s){
        if(s.jtnorental.getText().isEmpty()||s.jtidpelanggan.getText().isEmpty() || s.jtidmobil.getText().isEmpty() || s.jdtanggalrental.getDate().equals(null) || s.jdtanggalkembali.getDate().equals(null) ){
           JOptionPane.showMessageDialog(null, "Isi semua data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
          
       }else{
            try{
                
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                     
           String tanggalrental = String.valueOf(format.format(s.jdtanggalrental.getDate()));
           String tanggalkembali = String.valueOf(format.format(s.jdtanggalkembali.getDate()));
                
            sql = "INSERT INTO merental VALUES ('"+s.jtnorental.getText()+"', '"+s.jtidpelanggan.getText()+"', '"+s.jtidmobil.getText()+"','"+s.jthargasewa.getText()+"', '"+tanggalrental+"', '"+tanggalkembali+"', '"+s.jtidkaryawan.getText()+"')";
            stat = con.createStatement();
            stat.execute(sql);
            
           int pesan = JOptionPane.showConfirmDialog(null, "Data berhasil tersimpan, tambah lagi?", "Konfirmasi", 0, 3);
           
           if (pesan == 0){
               bersih(s);
               no_oto(s);
               tampil_data(s);
              
           }else if(pesan == 1){
               int pesan_transaksi = JOptionPane.showConfirmDialog(null, "Lanjutkan ke Transaksi?", "Konfirmasi", 0, 3);
               
               if(pesan_transaksi == 0){
                   s.dispose();
                   new form.form_transaksi().setVisible(true);
               }else if (pesan_transaksi == 1){
                   kunci(s);
                   bersih(s);
                   tampil_data(s);
               }
             
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
               }
    }
    public void hapus (form_merental h){
    
        try{
         int pesan = JOptionPane.showConfirmDialog(null, "Yakin hapus data merental ini?", "Konfirmasi", 0, 3);
           if (pesan == 0){
              
               sql = "DELETE FROM merental WHERE no_rental = '"+ h.jtnorental.getText() +"' ";
               stat = con.createStatement();
               stat.execute(sql);
               
               JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
               tampil_data(h);
               bersih(h);
               
               no_oto(h);
               kunci(h);
               h.jbhapus.setEnabled(false);
               h.jbubah.setEnabled(false);
           }else if(pesan == 1){
              bersih(h);
              no_oto(h);
              kunci(h);
              h.jbhapus.setEnabled(false);
              h.jbubah.setEnabled(false);
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    public void ubah (form_merental u){
    
        try{
         int pesan = JOptionPane.showConfirmDialog(null, "Yakin ubah data merental ini?", "Konfirmasi", 0, 3);
           if (pesan == 0){
               
               SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
               String tanggalrental = String.valueOf(format.format(u.jdtanggalrental.getDate()));
               String tanggalkembali = String.valueOf(format.format(u.jdtanggalkembali.getDate()));
               
               sql = "UPDATE merental SET id_pelanggan = '"+ u.jtidpelanggan.getText() +"', id_mobil = '"+ u.jtidmobil.getText() +"',harga_sewa = '"+u.jthargasewa.getText()+"', tanggal_rental = '"+ tanggalrental +"', tanggal_kembali = '"+ tanggalkembali +"', id_karyawan = '"+u.jtidkaryawan.getText()+"' WHERE no_rental = '"+ u.jtnorental.getText() +"'  ";
               stat = con.createStatement();
               stat.executeUpdate(sql);
               
               JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
               tampil_data(u);
               kunci (u);
               no_oto(u);
               bersih(u);
              u.jbubah.setEnabled(false);
              u.jbhapus.setEnabled(false);
           }else if(pesan == 1){
               bersih(u);
               no_oto(u);
               kunci(u);
               
               u.jbubah.setEnabled(false);
               u.jbhapus.setEnabled(false);
           }
           }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
                   }
    
    }
    public void cari_data (form_merental cd){
        
        DefaultTableModel tbmerental = new DefaultTableModel();
        tbmerental.addColumn("No. Rental");
        tbmerental.addColumn("Id Pelanggan");
        tbmerental.addColumn("Id Mobil");
        tbmerental.addColumn("Harga Sewa");
        tbmerental.addColumn("Tanggal Rental");
        tbmerental.addColumn("Tanggal Kembali");
        tbmerental.addColumn("Id Karyawan");
         
        try{
           if(cd.jccari.getSelectedItem().equals("No  Rental")){
               sql = "SELECT * FROM  merental WHERE no_rental LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           
           }else if(cd.jccari.getSelectedItem().equals("Id Pelanggan")){
               sql = "SELECT * FROM  merental WHERE id_pelanggan LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Id Mobil")){
               sql = "SELECT * FROM  merental WHERE id_mobil LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Tanggal Rental")){
               sql = "SELECT * FROM  merental WHERE tanggal_rental LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Tanggal Kembali")){
               sql = "SELECT * FROM  merental WHERE tanggal_kembali LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Id Karyawan")){
               sql = "SELECT * FROM merental WHERE id_karyawan LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }
           while (res.next()){
                tbmerental.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7)});
            }
            cd.jtable.setModel(tbmerental);
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    
    }
    
    public void tampil_nama_pelanggan(form_merental tnp){
        DefaultComboBoxModel model = new DefaultComboBoxModel<>();
        try {
            sql = "SELECT * FROM pelanggan";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while(res.next()){
                model.addElement(res.getString(2));
            }
            tnp.jcpelanggan.setModel(model);
            tampil_id_pelanggan(tnp);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
               
    }
    public void tampil_id_pelanggan(form_merental tip){
        try {
            sql = "SELECT * FROM pelanggan WHERE nama LIKE '%"+ tip.jcpelanggan.getSelectedItem() +"%' ";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            if(res.next()){
                tip.jtidpelanggan.setText(res.getString(1));
            }
           
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tampil_nama_mobil(form_merental tnm){
        DefaultComboBoxModel model = new DefaultComboBoxModel<>();
        try {
            sql = "SELECT * FROM mobil";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while(res.next()){
                model.addElement(res.getString(2));
            }
            tnm.jcmobil.setModel(model);
            tampil_id_mobil(tnm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void tampil_id_mobil(form_merental tim){
        try {
            sql = "SELECT * FROM mobil WHERE nama_mobil LIKE '%"+tim.jcmobil.getSelectedItem()+"%' ";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            if(res.next()){
                tim.jtidmobil.setText(res.getString(1));
                tim.jthargasewa.setText(res.getString(3));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
