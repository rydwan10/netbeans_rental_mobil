/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


/**
 *
 * @author Muhammad Rydwan
 */
public class form_merental extends javax.swing.JFrame {

    /**
     * Creates new form form_merental
     * @param idkaryawan
     */
    public form_merental(String idkaryawan) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        new method.method_merental().bersih(this);
        new method.method_merental().kunci(this);
        new method.method_merental().tampil_data(this);
        new method.method_merental().no_oto(this);
        new method.method_merental().tampil_nama_pelanggan(this);
        new method.method_merental().tampil_nama_mobil(this);
        jtidkaryawan.setText(idkaryawan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtnorental = new javax.swing.JTextField();
        jtidpelanggan = new javax.swing.JTextField();
        jtidmobil = new javax.swing.JTextField();
        jbsimpan = new javax.swing.JButton();
        jbkembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jccari = new javax.swing.JComboBox<>();
        jtcari = new javax.swing.JTextField();
        jcpelanggan = new javax.swing.JComboBox<>();
        jcmobil = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jthargasewa = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jbtambah = new javax.swing.JButton();
        jbbatal = new javax.swing.JButton();
        jbhapus = new javax.swing.JButton();
        jbubah = new javax.swing.JButton();
        jtidkaryawan = new javax.swing.JTextField();
        jdtanggalrental = new com.toedter.calendar.JDateChooser();
        jdtanggalkembali = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("No Rental");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("ID Pelanggan");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("ID Mobil");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tanggal Rental");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tanggal Kembali");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("ID Karyawan");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        jtnorental.setText("jTextField1");
        getContentPane().add(jtnorental, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 165, 29));

        jtidpelanggan.setText("jTextField2");
        getContentPane().add(jtidpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 165, 30));

        jtidmobil.setText("jTextField3");
        getContentPane().add(jtidmobil, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 165, 30));

        jbsimpan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/checked32.png"))); // NOI18N
        jbsimpan.setText("Proses");
        jbsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(jbsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 110, 62));

        jbkembali.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbkembali.setForeground(new java.awt.Color(204, 0, 0));
        jbkembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/back(1).png"))); // NOI18N
        jbkembali.setText("Kembali");
        jbkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbkembaliActionPerformed(evt);
            }
        });
        getContentPane().add(jbkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 640, 130, 62));

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 850, 410));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cari :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, -1));

        jccari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No  Rental", "Id Pelanggan", "Id Mobil", "Tanggal Rental", "Tanggal Kembali", "Id Karyawan" }));
        jccari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jccariActionPerformed(evt);
            }
        });
        getContentPane().add(jccari, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 130, 28));

        jtcari.setText("jTextField7");
        jtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtcariActionPerformed(evt);
            }
        });
        getContentPane().add(jtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 203, 28));

        jcpelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilihan--" }));
        jcpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcpelangganActionPerformed(evt);
            }
        });
        getContentPane().add(jcpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 224, 29));

        jcmobil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilihan--" }));
        jcmobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmobilActionPerformed(evt);
            }
        });
        getContentPane().add(jcmobil, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 224, 29));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Harga Sewa");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jthargasewa.setText("jTextField3");
        getContentPane().add(jthargasewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 165, 30));

        jPanel5.setBackground(new java.awt.Color(234, 87, 6));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/rent-a-car128.png"))); // NOI18N
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Merental");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 150));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtambah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tambah32.png"))); // NOI18N
        jbtambah.setText("Tambah");
        jbtambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtambahActionPerformed(evt);
            }
        });
        jPanel8.add(jbtambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jbbatal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/reload 32.png"))); // NOI18N
        jbbatal.setText("Batal");
        jbbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbbatalActionPerformed(evt);
            }
        });
        jPanel8.add(jbbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 100, -1));

        jbhapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbhapus.setForeground(new java.awt.Color(204, 0, 0));
        jbhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/batal32.png"))); // NOI18N
        jbhapus.setText("Hapus");
        jbhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbhapusActionPerformed(evt);
            }
        });
        jPanel8.add(jbhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 110, 62));

        jbubah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/edt32.png"))); // NOI18N
        jbubah.setText("Ubah");
        jbubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbubahActionPerformed(evt);
            }
        });
        jPanel8.add(jbubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 100, 62));

        jtidkaryawan.setEditable(false);
        jtidkaryawan.setText("jTextField6");
        jPanel8.add(jtidkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 185, 27));
        jPanel8.add(jdtanggalrental, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 160, 30));
        jPanel8.add(jdtanggalkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 160, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 470, 570));

        jPanel9.setBackground(new java.awt.Color(234, 87, 6));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 1420, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtambahActionPerformed
        
        new method.method_merental().buka_kunci(this);
        
        new method.method_merental().bersih(this);
        new method.method_merental().no_oto(this);
       jtidkaryawan.setEnabled(true);
    }//GEN-LAST:event_jbtambahActionPerformed

    private void jbkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbkembaliActionPerformed
        dispose();
    }//GEN-LAST:event_jbkembaliActionPerformed

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked
        new method.method_merental().klik_table(this);
    }//GEN-LAST:event_jtableMouseClicked

    private void jdtanggalrentalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdtanggalrentalPropertyChange
        // TODO add your handling code here:
        if(jdtanggalrental.getDate() != null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String tgl = format.format(jdtanggalrental.getDate());
        }
    }//GEN-LAST:event_jdtanggalrentalPropertyChange

    private void jbbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbatalActionPerformed
        new method.method_merental().kunci(this);
        new method.method_merental().bersih(this);
    }//GEN-LAST:event_jbbatalActionPerformed

    private void jbsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsimpanActionPerformed
        new method.method_merental().simpan(this);
    }//GEN-LAST:event_jbsimpanActionPerformed

    private void jbubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbubahActionPerformed
       new method.method_merental().ubah(this);
    }//GEN-LAST:event_jbubahActionPerformed

    private void jbhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbhapusActionPerformed
       new method.method_merental().hapus(this);
    }//GEN-LAST:event_jbhapusActionPerformed

    private void jccariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jccariActionPerformed
       jtcari.requestFocus();
    }//GEN-LAST:event_jccariActionPerformed

    private void jtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtcariActionPerformed
        new method.method_merental().cari_data(this);
    }//GEN-LAST:event_jtcariActionPerformed

    private void jcpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcpelangganActionPerformed
        new method.method_merental().tampil_id_pelanggan(this);
    }//GEN-LAST:event_jcpelangganActionPerformed

    private void jcmobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmobilActionPerformed
         new method.method_merental().tampil_id_mobil(this);
    }//GEN-LAST:event_jcmobilActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(form_merental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(form_merental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(form_merental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(form_merental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new form_merental().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbbatal;
    public javax.swing.JButton jbhapus;
    public javax.swing.JButton jbkembali;
    public javax.swing.JButton jbsimpan;
    public javax.swing.JButton jbtambah;
    public javax.swing.JButton jbubah;
    public javax.swing.JComboBox<String> jccari;
    public javax.swing.JComboBox<String> jcmobil;
    public javax.swing.JComboBox<String> jcpelanggan;
    public com.toedter.calendar.JDateChooser jdtanggalkembali;
    public com.toedter.calendar.JDateChooser jdtanggalrental;
    public javax.swing.JTable jtable;
    public javax.swing.JTextField jtcari;
    public javax.swing.JTextField jthargasewa;
    public javax.swing.JTextField jtidkaryawan;
    public javax.swing.JTextField jtidmobil;
    public javax.swing.JTextField jtidpelanggan;
    public javax.swing.JTextField jtnorental;
    // End of variables declaration//GEN-END:variables
}
