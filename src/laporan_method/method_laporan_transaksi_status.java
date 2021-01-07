/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laporan_method;
import java.sql.Connection;

import java.io.File;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;

import rental_mobil.Rental_mobil;
import laporan_form.form_laporan_transaksi_status;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Muhammad Rydwan
 */
public class method_laporan_transaksi_status {
    
    Connection con = new Rental_mobil().getCon();
    Map<String, Object> param = new HashMap<String, Object>();
    
    JasperReport jasperreport;
    JasperDesign jasperdesign;
    JasperPrint jasperprint;
    
    public void cetak_lunas(form_laporan_transaksi_status c){
        try {
            File file = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\rental_mobil\\src\\laporan\\transaksi_lunas.jrxml");
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
    public void cetak_belum_lunas(form_laporan_transaksi_status cbl){
        try {
            File file = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\rental_mobil\\src\\laporan\\transaksi_belum_lunas.jrxml");
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
}
