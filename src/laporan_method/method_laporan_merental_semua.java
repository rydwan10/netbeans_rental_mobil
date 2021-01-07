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
import javax.swing.table.DefaultTableModel;

import rental_mobil.Rental_mobil;
import laporan_form.form_laporan_merental_cetak_semua;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author Muhammad Rydwan
 */
public class method_laporan_merental_semua {
    Connection con = new Rental_mobil().getCon();
    Statement stat = null;
    ResultSet res = null;
    String sql = "";
    
    JasperReport jasperreport;
    JasperPrint jasperprint;
    JasperDesign jasperdesign;
    Map<String, Object> param = new HashMap<String, Object>();
    
    public void cetak(form_laporan_merental_cetak_semua c){
        try {
            File file = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\rental_mobil\\src\\laporan\\merental_semua.jrxml");
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
    public void tampil_data(form_laporan_merental_cetak_semua td){
        DefaultTableModel tbMerental = new DefaultTableModel();
        tbMerental.addColumn("No. Rental");
        tbMerental.addColumn("Nama Pelanggan");
        tbMerental.addColumn("Mobil");
        tbMerental.addColumn("Harga Sewa");
        tbMerental.addColumn("Tgl Rental");
        tbMerental.addColumn("Tgl Kembali");
        tbMerental.addColumn("Nama Karyawan");   
        
        try {
            sql = "SELECT merental.no_rental, pelanggan.nama, mobil.nama_mobil, mobil.harga_sewa, merental.tanggal_rental, merental.tanggal_kembali, karyawan.nama  FROM merental, pelanggan, mobil, karyawan WHERE merental.id_pelanggan = pelanggan.id_pelanggan AND mobil.id_mobil = merental.id_mobil AND merental.id_karyawan = karyawan.id_karyawan ORDER BY no_rental;";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while (res.next()){
                tbMerental.addRow(new Object[]{res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5),
                res.getString(6),
                res.getString(7)});
            }
            td.jtable.setModel(tbMerental);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
