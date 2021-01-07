/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;



import form.form_transaksi;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author Muhammad Rydwan
 */

public class method_transaksi {
    
    Connection con = new rental_mobil.Rental_mobil().getCon();
    ResultSet res = null;
    Statement stat = null;
    String sql = "";
      
    public void bersih (form_transaksi b){
        //b.jtidtransaksi.setText(null);
        b.jtnorental.setText(null);
        b.jtidpelanggan.setText(null);
        b.jtnamapelanggan.setText(null);
        b.jtidmobil.setText(null);
        b.jtnamamobil.setText(null);
        b.jthargasewa.setText(null);
        b.jttanggalrental.setText(null);
        b.jttanggalkembali.setText(null);
        b.jtlamasewa.setText(null);
        b.jtharga.setText(null);
        b.jtpotongan.setText(null);
        b.jttotalharga.setText(null);
        b.jtdibayar.setText(null);
        b.jtkembalian.setText(null);
        b.jtharga.setText(null);
        b.jtpotongan.setText(null);
        b.jttotalharga.setText(null);
        b.jtdibayar.setText(null);
        b.jtkembalian.setText(null);
        b.lbstatus.setText("[LUNAS/BELUM LUNAS]");
    }
    public void bersih_batal(form_transaksi bb){
        bb.jtlamasewa.setText(null);
        bb.jtharga.setText(null);
        bb.jtpotongan.setText(null);
        bb.jttotalharga.setText(null);
        bb.jtkembalian.setText(null);
        bb.jtdibayar.setText(null);
        bb.lbstatus.setText("[LUNAS/BELUM LUNAS]");
    }
    public void kunci (form_transaksi k){
        k.jtidtransaksi.setEnabled(false);
        k.jtnorental.setEnabled(false);
        k.jcnorental.setEnabled(false);
        k.jtidpelanggan.setEnabled(false);
        k.jtnamapelanggan.setEnabled(false);
        k.jtidmobil.setEnabled(false);
        k.jtnamamobil.setEnabled(false);
        k.jthargasewa.setEnabled(false);
        k.jttanggalrental.setEnabled(false);
        k.jttanggalkembali.setEnabled(false);
        k.jtlamasewa.setEnabled(false);
        k.jtharga.setEnabled(false);
        k.jtpotongan.setEnabled(false);
        k.jttotalharga.setEnabled(false);
        k.jtdibayar.setEnabled(false);
        k.jtkembalian.setEnabled(false);
        
        k.jbsimpan.setEnabled(false);
        k.jbhapus.setEnabled(false);
        k.jbubah.setEnabled(false);
        k.jbtambah.setEnabled(true);
        k.jbbatal.setEnabled(false);
    }
    public void buka_kunci (form_transaksi bk){
        bk.jtidtransaksi.setEnabled(false);
        bk.jtnorental.setEnabled(false);
        bk.jcnorental.setEnabled(true);
        bk.jtidpelanggan.setEnabled(false);
        bk.jtnamapelanggan.setEnabled(true);
        bk.jtidmobil.setEnabled(false);
        bk.jtnamamobil.setEnabled(true);
        bk.jthargasewa.setEnabled(true);
        bk.jttanggalrental.setEnabled(true);
        bk.jttanggalkembali.setEnabled(true);
        bk.jtlamasewa.setEnabled(true);
        bk.jtharga.setEnabled(true);
        bk.jtpotongan.setEnabled(true);
        bk.jttotalharga.setEnabled(true);
        bk.jtdibayar.setEnabled(true);
        bk.jtkembalian.setEnabled(true);
        bk.jtlamasewa.requestFocus();
        
        bk.jbsimpan.setEnabled(true);
        bk.jbhapus.setEnabled(false);
        bk.jbubah.setEnabled(false);
        bk.jbtambah.setEnabled(false);
        bk.jbbatal.setEnabled(true);
    }
    
    public void id_oto(form_transaksi io){
        try {
            sql = "SELECT * FROM transaksi ORDER BY id_transaksi DESC";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            if(res.next()){
                String id_transaksi = res.getString("id_transaksi").substring(1);
                String AN = "" + (Integer.parseInt(id_transaksi)+1);
                String Nol = "";
                
                if(AN.length() == 1){
                    Nol = "0000";
                }else if(AN.length() == 2){
                    Nol = "000";
                }else if(AN.length() == 3){
                    Nol = "00";
                }else if(AN.length() == 4){
                    Nol = "0";
                }else if(AN.length() == 5){
                    Nol = "";
                }
                io.jtidtransaksi.setText("T" + Nol + AN);
            }else{
                io.jtidtransaksi.setText("T00001");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void tampil_data (form_transaksi td){
        DefaultTableModel tbtransaksi = new DefaultTableModel();
        tbtransaksi.addColumn("ID Transaksi");
        tbtransaksi.addColumn("No Rental");
        tbtransaksi.addColumn("Harga");
        tbtransaksi.addColumn("Potongan");
        tbtransaksi.addColumn("Total Harga");
        tbtransaksi.addColumn("Dibayar");
        tbtransaksi.addColumn("Kembalian");
        tbtransaksi.addColumn("Status");
        tbtransaksi.addColumn("ID Karyawan");
        
        try {
            sql = "SELECT * FROM transaksi";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while(res.next()){
                tbtransaksi.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9)       
                });
            }
            td.jtable.setModel(tbtransaksi);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public void klik_table (form_transaksi kt){
        try{
            int row = kt.jtable.getSelectedRow();
            
            kt.jtidtransaksi.setText(kt.jtable.getModel().getValueAt(row, 0).toString());
            kt.jtnorental.setText(kt.jtable.getModel().getValueAt(row, 1).toString());
            //kt.jcnorental.setSelectedItem(kt.jtable.getModel().getValueAt(row,1).toString());
            kt.jtharga.setText(kt.jtable.getModel().getValueAt(row, 2).toString());
            kt.jtpotongan.setText(kt.jtable.getModel().getValueAt(row, 3).toString());
            kt.jttotalharga.setText(kt.jtable.getModel().getValueAt(row, 4).toString());
            kt.jtdibayar.setText(kt.jtable.getModel().getValueAt(row, 5).toString());
            kt.jtkembalian.setText(kt.jtable.getModel().getValueAt(row, 6).toString());
            kt.lbstatus.setText(kt.jtable.getModel().getValueAt(row, 7).toString());
            //lbidkaryawan
            
            kt.jbsimpan.setEnabled(false);
            kt.jbhapus.setEnabled(true);
            kt.jbubah.setEnabled(true);
            
            kt.jtlamasewa.requestFocus();
            
            kt.jcnorental.setEnabled(true);
            kt.jtlamasewa.setEnabled(true);
            kt.jtpotongan.setEnabled(true);
            kt.jtdibayar.setEnabled(true);
            kt.jtkembalian.setEnabled(true);
            
            kt.jbbatal.setEnabled(true);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void tampil_no_rental(form_transaksi tnr){
        DefaultComboBoxModel model = new DefaultComboBoxModel<>();
        try {
            sql = "SELECT * FROM merental ORDER BY no_rental DESC";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while(res.next()){
                model.addElement(res.getString(1));
            }
            tnr.jcnorental.setModel(model);
            tampil_detail_merental(tnr);
            tampil_nama_pelanggan(tnr);
            tampil_nama_mobil(tnr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    
    public void tampil_detail_merental(form_transaksi tdm){
        try {
            sql = "SELECT * FROM merental WHERE no_rental LIKE '%"+ tdm.jcnorental.getSelectedItem() +"%' ";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            if(res.next()){
                tdm.jtnorental.setText(res.getString(1));
                tdm.jtidpelanggan.setText(res.getString(2));
                tdm.jtidmobil.setText(res.getString(3));
                tdm.jthargasewa.setText(res.getString(4));
                tdm.jttanggalrental.setText(res.getString(5));
                tdm.jttanggalkembali.setText(res.getString(6));
                tdm.jtidkaryawan.setText(res.getString(7));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void tampil_nama_pelanggan(form_transaksi tnp){
        try {
            sql = "SELECT * FROM pelanggan WHERE id_pelanggan LIKE '%"+ tnp.jtidpelanggan.getText() +"%' ";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while (res.next()){
                tnp.jtnamapelanggan.setText(res.getString(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void tampil_nama_mobil(form_transaksi tnm){
        try {
            sql = "SELECT * FROM mobil WHERE id_mobil LIKE '%"+ tnm.jtidmobil.getText() +"%' ";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while (res.next()){
                tnm.jtnamamobil.setText(res.getString(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void simpan(form_transaksi s){ 
        
        
        
      if(s.jtlamasewa.getText().isEmpty() || s.jtharga.getText().isEmpty() || s.jttotalharga.getText().isEmpty() || s.jtdibayar.getText().isEmpty()
         || s.jtkembalian.getText().isEmpty()   ){
          JOptionPane.showMessageDialog(null, "Mohon isi semua field!", "Peringatan", JOptionPane.WARNING_MESSAGE);
      }else{
          try {
              sql = "INSERT INTO transaksi(id_transaksi, no_rental, harga, potongan, total_harga, dibayar, kembalian, status, id_karyawan)"
                      + "VALUES ('"+s.jtidtransaksi.getText()+"', '"+s.jtnorental.getText()+"', '"+s.jtharga.getText()+"', "
                      + "'"+s.jtpotongan.getText()+"', '"+s.jttotalharga.getText()+"', '"+s.jtdibayar.getText()+"', "
                      + "'"+s.jtkembalian.getText()+"', '"+s.lbstatus.getText()+"', '"+s.jtidkaryawan.getText()+"')";
              stat = con.createStatement();
              stat.execute(sql);
              tampil_data(s);
              id_oto(s);
              bersih(s);
              JOptionPane.showMessageDialog(null, "Transaksi Sukses!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
          }
      }
            
    }
    public void validasi_no_rental (form_transaksi vnr){
        String x ;
        
        for(int i = 0; i < vnr.jtable.getRowCount(); i++){
            
            x = vnr.jtable.getValueAt(i, 1).toString().trim();
            
            if(vnr.jcnorental.getSelectedItem().equals(x)){
                
                JOptionPane.showMessageDialog(null, "No. Rental '"+vnr.jcnorental.getSelectedItem()+"'  telah melakukan transaksi","Peringatan",  JOptionPane.WARNING_MESSAGE);
                vnr.jcnorental.setSelectedIndex(0);
                tampil_detail_merental(vnr);
                tampil_nama_mobil(vnr);
                tampil_nama_pelanggan(vnr);
            }
        }
    }
    public void hapus (form_transaksi h){
        try{
         int pesan = JOptionPane.showConfirmDialog(null, "Yakin hapus data transaksi ini?", "Konfirmasi", 0, 3);
           if (pesan == 0){
              
               sql = "DELETE FROM transaksi WHERE id_transaksi = '"+ h.jtidtransaksi.getText() +"' ";
               stat = con.createStatement();
               stat.execute(sql);
               
               JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
               tampil_data(h);
               bersih(h);
               
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

    public void ubah(form_transaksi u){
        try{
         int pesan = JOptionPane.showConfirmDialog(null, "Yakin ubah data transaksi ini?", "Konfirmasi", 0, 3);
           if (pesan == 0){
               sql = " UPDATE transaksi SET harga = '"+u.jtharga.getText()+"', potongan = '"+u.jtpotongan.getText()+"', total_harga = '"+u.jttotalharga.getText()+"', "
                       + " dibayar = '"+u.jtdibayar.getText()+"', kembalian = '"+u.jtkembalian.getText()+"', status = '"+u.lbstatus.getText()+"', id_karyawan = '"+u.jtidkaryawan.getText()+"' "
                       + " WHERE id_transaksi = '"+u.jtidtransaksi.getText()+"' ";
             
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
               
               u.jbubah.setEnabled(false);
               u.jbhapus.setEnabled(false);
           }
           }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
                   }
    }
    public void cari_data(form_transaksi cd){
        DefaultTableModel tbtransaksi = new DefaultTableModel();
        tbtransaksi.addColumn("ID Transaksi");
        tbtransaksi.addColumn("No Rental");
        tbtransaksi.addColumn("Harga");
        tbtransaksi.addColumn("Potongan");
        tbtransaksi.addColumn("Total Harga");
        tbtransaksi.addColumn("Dibayar");
        tbtransaksi.addColumn("Kembalian");
        tbtransaksi.addColumn("Status");
        tbtransaksi.addColumn("ID Karyawan");
       
        try{
           if(cd.jccari.getSelectedItem().equals("ID Transaksi")){
               sql = "SELECT * FROM  transaksi WHERE id_transaksi LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           
           }else if(cd.jccari.getSelectedItem().equals("No Rental")){
               sql = "SELECT * FROM  transaksi WHERE no_rental LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Harga")){
               sql = "SELECT * FROM  transaksi WHERE harga LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Potongan")){
               sql = "SELECT * FROM  transaksi WHERE potongan LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Total Harga")){
               sql = "SELECT * FROM  transaksi WHERE total_harga LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Dibayar")){
               sql = "SELECT * FROM  transaksi WHERE Dibayar LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Kembalian")){
               sql = "SELECT * FROM  transaksi WHERE Kembalian LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("Status")){
               sql = "SELECT * FROM  transaksi WHERE Status LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }else if(cd.jccari.getSelectedItem().equals("ID Karyawan")){
               sql = "SELECT * FROM  transaksi WHERE ID_Karyawan LIKE '%"+cd.jtcari.getText()+"%' ";
               stat = con.createStatement();
               res = stat.executeQuery(sql);
           }
           while (res.next()){
                tbtransaksi.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9)});
            }
            cd.jtable.setModel(tbtransaksi);
           
            
           
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
}
