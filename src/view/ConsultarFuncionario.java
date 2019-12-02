/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ControllerConsultarFuncionario;
import Controller.ControllerEditarFuncionario;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;


/**
 *
 * @author Flavio
 */
public class ConsultarFuncionario extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form ConsultarFuncionario
     */
    public ConsultarFuncionario() {
        initComponents();
        jRadioNome.setSelected(true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuAtualizar = new javax.swing.JMenuItem();
        jMenuInformacoes = new javax.swing.JMenuItem();
        jMenuCadastrar = new javax.swing.JMenuItem();
        jMenuEditar = new javax.swing.JMenuItem();
        jMenuStatus = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buscarTxt = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jRadioNome = new javax.swing.JRadioButton();
        jRadioRg = new javax.swing.JRadioButton();
        jRadioCpf = new javax.swing.JRadioButton();
        jRadioLogin = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();

        jMenuAtualizar.setText("Atualizar");
        jPopupMenu1.add(jMenuAtualizar);

        jMenuInformacoes.setText("Ver informações");
        jPopupMenu1.add(jMenuInformacoes);

        jMenuCadastrar.setText("Cadastrar");
        jPopupMenu1.add(jMenuCadastrar);

        jMenuEditar.setText("Editar");
        jPopupMenu1.add(jMenuEditar);

        jMenuStatus.setText("Mudar status");
        jPopupMenu1.add(jMenuStatus);

        jMenuSair.setText("Sair");
        jPopupMenu1.add(jMenuSair);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busca:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/busca.png"))); // NOI18N
        btnBuscar.setText("Buscar");

        jRadioNome.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioNome);
        jRadioNome.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jRadioNome.setText("Nome");

        jRadioRg.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioRg);
        jRadioRg.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jRadioRg.setText("RG");

        jRadioCpf.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioCpf);
        jRadioCpf.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jRadioCpf.setText("CPF");

        jRadioLogin.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioLogin);
        jRadioLogin.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jRadioLogin.setText("Login");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioNome)
                        .addGap(66, 66, 66)
                        .addComponent(jRadioRg)
                        .addGap(62, 62, 62)
                        .addComponent(jRadioCpf)
                        .addGap(68, 68, 68)
                        .addComponent(jRadioLogin))
                    .addComponent(buscarTxt))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioNome)
                    .addComponent(jRadioRg)
                    .addComponent(jRadioCpf)
                    .addComponent(jRadioLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funcionários:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        jTableFuncionarios.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Sobrenome", "RG", "CPF", "Data nascimento", "Login", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTableFuncionarios);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(ConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarFuncionario().setVisible(true);
            }
        });
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JTextField getBuscarTxt() {
        return buscarTxt;
    }

    public JRadioButton getjRadioCpf() {
        return jRadioCpf;
    }

    public JRadioButton getjRadioLogin() {
        return jRadioLogin;
    }

    public JRadioButton getjRadioNome() {
        return jRadioNome;
    }

    public JRadioButton getjRadioRg() {
        return jRadioRg;
    }

    public JTable getjTableFuncionarios() {
        return jTableFuncionarios;
    }

    public JMenuItem getjMenuAtualizar() {
        return jMenuAtualizar;
    }

    public JMenuItem getjMenuCadastrar() {
        return jMenuCadastrar;
    }

    public JMenuItem getjMenuEditar() {
        return jMenuEditar;
    }

    public JMenuItem getjMenuStatus() {
        return jMenuStatus;
    }

    public JMenuItem getjMenuSair() {
        return jMenuSair;
    }

    public JPopupMenu getjPopupMenu1() {
        return jPopupMenu1;
    }

    public JMenuItem getjMenuInformacoes() {
        return jMenuInformacoes;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem jMenuAtualizar;
    private javax.swing.JMenuItem jMenuCadastrar;
    private javax.swing.JMenuItem jMenuEditar;
    private javax.swing.JMenuItem jMenuInformacoes;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JMenuItem jMenuStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioCpf;
    private javax.swing.JRadioButton jRadioLogin;
    private javax.swing.JRadioButton jRadioNome;
    private javax.swing.JRadioButton jRadioRg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFuncionarios;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ControllerConsultarFuncionario && ((ControllerConsultarFuncionario)o).getTela().getjMenuStatus().equals(arg)){
            ((ControllerConsultarFuncionario)o).LimparSimples();
            ((ControllerConsultarFuncionario)o).colocar();
        }
        if(o instanceof ControllerEditarFuncionario){
            String [] fu = (String[]) arg;
            jTableFuncionarios.getModel().setValueAt(Integer.parseInt(fu[fu.length-1]), Integer.parseInt(fu[fu.length-2]), 0);
            for(int i=0;i<fu.length-2;i++){
                jTableFuncionarios.getModel().setValueAt(fu[i], Integer.parseInt(fu[fu.length-2]), i+1);
            }
           
           
        }
        if(o instanceof ControllerConsultarFuncionario && ((ControllerConsultarFuncionario)o).getTela().getjMenuAtualizar().equals(arg)){
            ((ControllerConsultarFuncionario)o).LimparSimples();
            ((ControllerConsultarFuncionario)o).colocar();
        }
        if(o instanceof ControllerConsultarFuncionario && ((ControllerConsultarFuncionario)o).getTela().getBtnBuscar().equals(arg)){
            ((ControllerConsultarFuncionario)o).LimparSimples();
            ((ControllerConsultarFuncionario)o).colocar(((ControllerConsultarFuncionario)o).getFuncionarioLike());
            
        }
    }
}
