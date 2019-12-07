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
public class InformacaoAtualVeiculo extends javax.swing.JFrame {

    /** Creates new form InformacaoAtualVeiculo */
    public InformacaoAtualVeiculo() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("resource/logo_onibus_oficial.png")));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblPlaca = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblCor = new javax.swing.JLabel();
        lblChassi = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblAssentosTotal = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblNomeMotorista = new javax.swing.JLabel();
        lblSobrenomeMotorista = new javax.swing.JLabel();
        lblCnh = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblNomeViagem = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblAssentosVazio = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPlaca.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblPlaca.setForeground(new java.awt.Color(255, 255, 255));
        lblPlaca.setText("jLabel1");
        jPanel2.add(lblPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do veiculo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Tipo:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Cor:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Chassi:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTipo.setText("jLabel5");
        jPanel3.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        lblCor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCor.setText("jLabel6");
        jPanel3.add(lblCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        lblChassi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblChassi.setText("jLabel7");
        jPanel3.add(lblChassi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setText("Nº de assentos:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lblAssentosTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAssentosTotal.setText("jLabel15");
        jPanel3.add(lblAssentosTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 340, 120));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do motorista:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Nome:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Sobrenome:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("CNH:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblNomeMotorista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomeMotorista.setText("jLabel11");
        jPanel4.add(lblNomeMotorista, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        lblSobrenomeMotorista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSobrenomeMotorista.setText("jLabel12");
        jPanel4.add(lblSobrenomeMotorista, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        lblCnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCnh.setText("jLabel13");
        jPanel4.add(lblCnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 230, 120));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da viagem:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setText("Nome:");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setText("Horario:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setText("Preço:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblNomeViagem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomeViagem.setText("jLabel19");
        jPanel5.add(lblNomeViagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        lblHorario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHorario.setText("jLabel20");
        jPanel5.add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        lblPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPreco.setText("jLabel21");
        jPanel5.add(lblPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Nº de assentos vazios:");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        lblAssentosVazio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAssentosVazio.setText("jLabel5");
        jPanel5.add(lblAssentosVazio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 580, 100));

        btnOk.setBackground(new java.awt.Color(255, 255, 255));
        btnOk.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnOk.setText("OK");
        jPanel1.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 390));

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
            java.util.logging.Logger.getLogger(InformacaoAtualVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacaoAtualVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacaoAtualVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacaoAtualVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacaoAtualVeiculo().setVisible(true);
            }
        });
    }

    public JButton getBtnOk() {
        return btnOk;
    }

    public JLabel getLblAssentosTotal() {
        return lblAssentosTotal;
    }

    public JLabel getLblAssentosVazio() {
        return lblAssentosVazio;
    }

    public JLabel getLblChassi() {
        return lblChassi;
    }

    public JLabel getLblCnh() {
        return lblCnh;
    }

    public JLabel getLblCor() {
        return lblCor;
    }

    public JLabel getLblHorario() {
        return lblHorario;
    }

    public JLabel getLblNomeMotorista() {
        return lblNomeMotorista;
    }

    public JLabel getLblNomeViagem() {
        return lblNomeViagem;
    }

    public JLabel getLblPlaca() {
        return lblPlaca;
    }

    public JLabel getLblPreco() {
        return lblPreco;
    }

    public JLabel getLblSobrenomeMotorista() {
        return lblSobrenomeMotorista;
    }

    public JLabel getLblTipo() {
        return lblTipo;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblAssentosTotal;
    private javax.swing.JLabel lblAssentosVazio;
    private javax.swing.JLabel lblChassi;
    private javax.swing.JLabel lblCnh;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblNomeMotorista;
    private javax.swing.JLabel lblNomeViagem;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblSobrenomeMotorista;
    private javax.swing.JLabel lblTipo;
    // End of variables declaration//GEN-END:variables

}