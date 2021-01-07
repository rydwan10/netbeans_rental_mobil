/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laporan_method;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import rental_mobil.Rental_mobil;
import laporan_form.form_laporan_transaksi_cetak_semua;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
/**
 *
 * @author Muhammad Rydwan
 */
public class method_laporan_transaksi_semua {
    Connection con = new Rental_mobil().getCon();
    Statement stat = null;
    ResultSet res = null;
    String sql = "";
    
    JasperReport jasperreport;
    JasperPrint jasperprint;
    JasperDesign jasperdesign;
    
    Map<String, Object> param = new HashMap<String, Object>();
    
    public void cetak (form_laporan_transaksi_cetak_semua c){
        try {
            File file = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\rental_mobil\\src\\laporan\\transaksi_semua.jrxml");
            jasperdesign = JRXmlLoader.load(file);
            param.clear();
            jasperreport = JasperCompileManager.compileReport(jasperdesign);
            jasperprint = JasperFillManager.fillReport(jasperreport, param, con);
            JasperViewer.viewReport(jasperprint, false);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void tampil_data(form_laporan_transaksi_cetak_semua td){
        DefaultTableModel tbTransaksi = new DefaultTableModel();
        tbTransaksi.addColumn("ID Transaksi");
        tbTransaksi.addColumn("No. Rental");
        tbTransaksi.addColumn("Nama Pelanggan");
        tbTransaksi.addColumn("Harga");
        tbTransaksi.addColumn("Potongan");
        tbTransaksi.addColumn("Total Harga");
        tbTransaksi.addColumn("Dibayar");
        tbTransaksi.addColumn("Kembalian");
        tbTransaksi.addColumn("Status");
        tbTransaksi.addColumn("Nama Karyawan");
       
        try{
            sql = "SELECT transaksi.id_transaksi, transaksi.no_rental, pelanggan.nama, transaksi.harga, transaksi.potongan, transaksi.total_harga, transaksi.dibayar, transaksi.kembalian, transaksi.status, karyawan.nama FROM karyawan INNER JOIN transaksi ON karyawan.id_karyawan = transaksi.id_karyawan INNER JOIN merental ON karyawan.id_karyawan = merental.id_karyawan AND merental.no_rental = transaksi.no_rental INNER JOIN pelanggan ON merental.id_pelanggan = pelanggan.id_pelanggan ORDER BY transaksi.id_transaksi;";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while (res.next()){
                tbTransaksi.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),res.getString(7), res.getString(8), res.getString(9), res.getString(10)});
            }
            td.jtable.setModel(tbTransaksi);
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
}
