/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laporan_method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import rental_mobil.Rental_mobil;
import laporan_form.form_laporan_karyawan;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Muhammad Rydwan
 */
public class method_laporan_karyawan {
    
    Connection con = new Rental_mobil().getCon();
    Statement stat = null;
    ResultSet res = null;
    String sql = "";
    
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    Map<String, Object> param = new HashMap<String, Object>();
  
    
    public void cetak(form_laporan_karyawan flk){
        try {
            File file = new File("src/laporan/karyawan.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            param.clear();
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tampil_data(form_laporan_karyawan td){
        
        DefaultTableModel tbPegawai = new DefaultTableModel();
        tbPegawai.addColumn("ID Karyawan");
        tbPegawai.addColumn("Nama");
        tbPegawai.addColumn("Alamat");
        tbPegawai.addColumn("No. Telepon");
        tbPegawai.addColumn("Status");

        
        try{
            sql = "SELECT id_karyawan, nama, alamat, no_telp, status FROM karyawan";
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            
            while (res.next()){
                tbPegawai.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
            }
            td.jtable.setModel(tbPegawai);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
}
