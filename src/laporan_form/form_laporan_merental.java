/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laporan_form;

/**
 *
 * @author Muhammad Rydwan
 */
public class form_laporan_merental extends javax.swing.JFrame {

    /**
     * Creates new form form_laporan_merental
     */
    public form_laporan_merental() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbkembali = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnpertanggalrental = new javax.swing.JButton();
        btncetaksemua = new javax.swing.JButton();
        btnpertangalkembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(56, 100, 240));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printer128.png"))); // NOI18N
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Laporan Data Merental");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/rent-a-car128.png"))); // NOI18N
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 130));

        jbkembali.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbkembali.setForeground(new java.awt.Color(204, 0, 0));
        jbkembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/back(1).png"))); // NOI18N
        jbkembali.setText("Kembali");
        jbkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbkembaliActionPerformed(evt);
            }
        });
        getContentPane().add(jbkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 120, 50));

        jPanel5.setBackground(new java.awt.Color(56, 100, 240));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 830, 60));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pilih kategori Laporan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnpertanggalrental.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnpertanggalrental.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/calendar.png"))); // NOI18N
        btnpertanggalrental.setText("Per-Tanggal Rental");
        btnpertanggalrental.setAlignmentY(11.0F);
        btnpertanggalrental.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnpertanggalrental.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnpertanggalrental.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnpertanggalrental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpertanggalrentalActionPerformed(evt);
            }
        });
        jPanel1.add(btnpertanggalrental, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 190, 170));

        btncetaksemua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btncetaksemua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printer128.png"))); // NOI18N
        btncetaksemua.setText("Cetak Semua");
        btncetaksemua.setAlignmentY(11.0F);
        btncetaksemua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncetaksemua.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btncetaksemua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncetaksemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetaksemuaActionPerformed(evt);
            }
        });
        jPanel1.add(btncetaksemua, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 200, 170));

        btnpertangalkembali.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnpertangalkembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/calendar.png"))); // NOI18N
        btnpertangalkembali.setText("Per-Tanggal Kembali");
        btnpertangalkembali.setAlignmentY(11.0F);
        btnpertangalkembali.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnpertangalkembali.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnpertangalkembali.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnpertangalkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpertangalkembaliActionPerformed(evt);
            }
        });
        jPanel1.add(btnpertangalkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 770, 240));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbkembaliActionPerformed
        dispose();
    }//GEN-LAST:event_jbkembaliActionPerformed

    private void btnpertanggalrentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpertanggalrentalActionPerformed
        new laporan_form.form_laporan_merental_pertanggal_rental().setVisible(true);
    }//GEN-LAST:event_btnpertanggalrentalActionPerformed

    private void btnpertangalkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpertangalkembaliActionPerformed
        new laporan_form.form_laporan_merental_pertanggal_kembali().setVisible(true);
    }//GEN-LAST:event_btnpertangalkembaliActionPerformed

    private void btncetaksemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetaksemuaActionPerformed
        new laporan_form.form_laporan_merental_cetak_semua().setVisible(true);
    }//GEN-LAST:event_btncetaksemuaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_laporan_merental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_laporan_merental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_laporan_merental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_laporan_merental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_laporan_merental().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btncetaksemua;
    public javax.swing.JButton btnpertangalkembali;
    public javax.swing.JButton btnpertanggalrental;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JButton jbkembali;
    // End of variables declaration//GEN-END:variables
}
