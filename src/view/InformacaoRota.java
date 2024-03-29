/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Flavio
 */
public class InformacaoRota extends javax.swing.JFrame {

    /**
     * Creates new form InformacaoRota
     */
    public InformacaoRota() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("resource/logo_onibus_oficial.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblEstado1 = new javax.swing.JLabel();
        lblRua1 = new javax.swing.JLabel();
        lblBairro1 = new javax.swing.JLabel();
        lblCidade1 = new javax.swing.JLabel();
        lblComplemento1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblEstado2 = new javax.swing.JLabel();
        lblRua2 = new javax.swing.JLabel();
        lblBairro2 = new javax.swing.JLabel();
        lblCidade2 = new javax.swing.JLabel();
        lblComplemento2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Informações");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNome.setText("jLabel3");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço partida:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Estado:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Rua:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 49, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setText("Bairro:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 76, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setText("Cidade:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 105, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("Complemento:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 132, -1, -1));

        lblEstado1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEstado1.setText("jLabel9");
        jPanel4.add(lblEstado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 28, -1, -1));

        lblRua1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRua1.setText("jLabel10");
        jPanel4.add(lblRua1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 50, -1, -1));

        lblBairro1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblBairro1.setText("jLabel11");
        jPanel4.add(lblBairro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 77, -1, -1));

        lblCidade1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCidade1.setText("jLabel12");
        jPanel4.add(lblCidade1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 106, -1, -1));

        lblComplemento1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblComplemento1.setText("jLabel13");
        jPanel4.add(lblComplemento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 133, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 131, 260, 172));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço destino:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setText("Estado:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, -1, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel15.setText("Rua:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 49, -1, -1));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setText("Bairro:");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 76, -1, -1));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel17.setText("Cidade:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 105, -1, -1));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel18.setText("Complemento:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 132, -1, -1));

        lblEstado2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEstado2.setText("jLabel9");
        jPanel5.add(lblEstado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 28, -1, -1));

        lblRua2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRua2.setText("jLabel10");
        jPanel5.add(lblRua2, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 50, -1, -1));

        lblBairro2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblBairro2.setText("jLabel11");
        jPanel5.add(lblBairro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 77, -1, -1));

        lblCidade2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCidade2.setText("jLabel12");
        jPanel5.add(lblCidade2, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 106, -1, -1));

        lblComplemento2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblComplemento2.setText("jLabel13");
        jPanel5.add(lblComplemento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 133, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 131, 250, 170));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel24.setText("Horario:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        lblHorario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblHorario.setText("jLabel25");
        jPanel1.add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel26.setText("Preço:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        lblPreco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPreco.setText("jLabel27");
        jPanel1.add(lblPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        btnOK.setBackground(new java.awt.Color(255, 255, 255));
        btnOK.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnOK.setText("OK");
        jPanel1.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(InformacaoRota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacaoRota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacaoRota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacaoRota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacaoRota().setVisible(true);
            }
        });
    }

    public JLabel getLblBairro1() {
        return lblBairro1;
    }

    public JLabel getLblBairro2() {
        return lblBairro2;
    }

    public JLabel getLblCidade1() {
        return lblCidade1;
    }

    public JLabel getLblCidade2() {
        return lblCidade2;
    }

    public JLabel getLblComplemento1() {
        return lblComplemento1;
    }

    public JLabel getLblComplemento2() {
        return lblComplemento2;
    }

    public JLabel getLblEstado1() {
        return lblEstado1;
    }

    public JLabel getLblEstado2() {
        return lblEstado2;
    }

    public JLabel getLblHorario() {
        return lblHorario;
    }

    public JLabel getLblNome() {
        return lblNome;
    }

    public JLabel getLblPreco() {
        return lblPreco;
    }

    public JLabel getLblRua1() {
        return lblRua1;
    }

    public JLabel getLblRua2() {
        return lblRua2;
    }

    public JButton getBtnOK() {
        return btnOK;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblBairro1;
    private javax.swing.JLabel lblBairro2;
    private javax.swing.JLabel lblCidade1;
    private javax.swing.JLabel lblCidade2;
    private javax.swing.JLabel lblComplemento1;
    private javax.swing.JLabel lblComplemento2;
    private javax.swing.JLabel lblEstado1;
    private javax.swing.JLabel lblEstado2;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblRua1;
    private javax.swing.JLabel lblRua2;
    // End of variables declaration//GEN-END:variables
}
