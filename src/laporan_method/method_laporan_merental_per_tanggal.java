/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laporan_method;
import java.sql.Connection;

import rental_mobil.Rental_mobil;
import laporan_form.form_laporan_merental_pertanggal_rental;
import laporan_form.form_laporan_merental_pertanggal_kembali;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Muhammad Rydwan
 */
public class method_laporan_merental_per_tanggal {
    Connection con = new Rental_mobil().getCon();
    JasperDesign jasperdesign;
    JasperReport jasperreport;
    JasperPrint jasperprint;
    
    Map<String, Object> param = new HashMap<String, Object>();
    
    public void cetak_per_tgl_rental (form_laporan_merental_pertanggal_rental c){
        try {
            param.put("tgl_dari", c.jddaritanggal.getDate());
            param.put("tgl_sampai", c.jdsampaitanggal.getDate());
            File file = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\rental_mobil\\src\\laporan\\merental_per_tanggal_rental.jrxml");
            jasperdesign = JRXmlLoader.load(file);
            jasperreport = JasperCompileManager.compileReport(jasperdesign);
            jasperprint = JasperFillManager.fillReport(jasperreport, param, con);
            JasperViewer.viewReport(jasperprint, false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void cetak_per_tgl_kembali (form_laporan_merental_pertanggal_kembali ctk){
        try {
            param.put("tgl_dari", ctk.jddaritanggal.getDate());
            param.put("tgl_sampai", ctk.jdsampaitanggal.getDate());
            File file = new File("src/laporan/merental_per_tanggal_kembali.jrxml");
            jasperdesign = JRXmlLoader.load(file);
            jasperreport = JasperCompileManager.compileReport(jasperdesign);
            jasperprint = JasperFillManager.fillReport(jasperreport, param, con);
            JasperViewer.viewReport(jasperprint, false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
                    
                    
        }
        
    }
}
