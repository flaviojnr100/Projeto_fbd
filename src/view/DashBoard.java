/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ControllerCadastroTransporte;
import Controller.ControllerConsultarTransporte;
import Controller.ControllerDashBoard;
import Controller.ControllerEditarTransporte;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author Flavio
 */
public class DashBoard extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuAtualizar = new javax.swing.JMenuItem();
        jFuncionario = new javax.swing.JMenu();
        jMenuCadastroFuncionario = new javax.swing.JMenuItem();
        jMenuConsultarFuincionario = new javax.swing.JMenuItem();
        jMotorista = new javax.swing.JMenu();
        jMenuCadastroMotorista = new javax.swing.JMenuItem();
        jMenuConsultarMotorista = new javax.swing.JMenuItem();
        jPassageiro = new javax.swing.JMenu();
        jMenuCadastrarPassageiro = new javax.swing.JMenuItem();
        jMenuConsultarPassageiro = new javax.swing.JMenuItem();
        jVeiculo = new javax.swing.JMenu();
        jMenuCadastroVeiculo = new javax.swing.JMenuItem();
        jMenuConsultaVeiculo = new javax.swing.JMenuItem();
        jRota = new javax.swing.JMenu();
        jMenuCadastroRota = new javax.swing.JMenuItem();
        jMenuConsultaRota = new javax.swing.JMenuItem();
        jViagem = new javax.swing.JMenu();
        jMenuCadastroViagem = new javax.swing.JMenuItem();
        jMenuConsultaViagem = new javax.swing.JMenuItem();
        jMenuFinanceiro = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenuItem();
        jMenuLoggof1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        painelBotoes = new javax.swing.JPanel();
        btnEfetuarViagem = new javax.swing.JButton();
        btnConsultarViagem = new javax.swing.JButton();
        btnConsultarVeiculos = new javax.swing.JButton();
        btnConsultarRotas = new javax.swing.JButton();
        btnConsultarPassageiros = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fundoPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuFuncionarioCadastro = new javax.swing.JMenuItem();
        jMenuFuncionarioConsulta = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuMotoristaCadastro = new javax.swing.JMenuItem();
        jMenuMotoristaConsulta = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuVeiculoCadastro = new javax.swing.JMenuItem();
        jMenuVeiculoConsulta = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuPassageiroCadastro = new javax.swing.JMenuItem();
        jMenuPassageiroConsulta = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuRotaCadastro = new javax.swing.JMenuItem();
        jMenuRotaConsulta = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuFinanceiroConsulta = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuSobre = new javax.swing.JMenuItem();
        jMenuControleAcesso = new javax.swing.JMenuItem();
        jMenuPersonalizar = new javax.swing.JMenuItem();
        Sair = new javax.swing.JMenu();
        jMenuLogoff = new javax.swing.JMenuItem();
        jMenuEncerrarSistema = new javax.swing.JMenuItem();

        jMenuAtualizar.setText("Atualizar");
        jPopupMenu1.add(jMenuAtualizar);

        jFuncionario.setText("Funcionario");

        jMenuCadastroFuncionario.setText("Cadastrar");
        jFuncionario.add(jMenuCadastroFuncionario);

        jMenuConsultarFuincionario.setText("Consultar");
        jFuncionario.add(jMenuConsultarFuincionario);

        jPopupMenu1.add(jFuncionario);

        jMotorista.setText("Motorista");

        jMenuCadastroMotorista.setText("Cadastrar");
        jMotorista.add(jMenuCadastroMotorista);

        jMenuConsultarMotorista.setText("Consultar");
        jMotorista.add(jMenuConsultarMotorista);

        jPopupMenu1.add(jMotorista);

        jPassageiro.setText("Passageiro");

        jMenuCadastrarPassageiro.setText("Cadastrar");
        jPassageiro.add(jMenuCadastrarPassageiro);

        jMenuConsultarPassageiro.setText("Consultar");
        jPassageiro.add(jMenuConsultarPassageiro);

        jPopupMenu1.add(jPassageiro);

        jVeiculo.setText("Veiculo");

        jMenuCadastroVeiculo.setText("Cadastrar");
        jVeiculo.add(jMenuCadastroVeiculo);

        jMenuConsultaVeiculo.setText("Consultar");
        jVeiculo.add(jMenuConsultaVeiculo);

        jPopupMenu1.add(jVeiculo);

        jRota.setText("Rota");

        jMenuCadastroRota.setText("Cadastrar");
        jRota.add(jMenuCadastroRota);

        jMenuConsultaRota.setText("Consultar");
        jRota.add(jMenuConsultaRota);

        jPopupMenu1.add(jRota);

        jViagem.setText("Viagem");

        jMenuCadastroViagem.setText("Cadastrar");
        jViagem.add(jMenuCadastroViagem);

        jMenuConsultaViagem.setText("Consultar");
        jViagem.add(jMenuConsultaViagem);

        jPopupMenu1.add(jViagem);

        jMenuFinanceiro.setText("Financeiro");
        jPopupMenu1.add(jMenuFinanceiro);

        jMenuSair.setText("Sair");
        jPopupMenu1.add(jMenuSair);

        jMenuLoggof1.setText("Logoff");
        jPopupMenu1.add(jMenuLoggof1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        painelBotoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEfetuarViagem.setBackground(new java.awt.Color(255, 255, 255));
        btnEfetuarViagem.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEfetuarViagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/gpslogo_oficial.png"))); // NOI18N
        btnEfetuarViagem.setText("Efetuar viagem");
        painelBotoes.add(btnEfetuarViagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 265, 104));

        btnConsultarViagem.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultarViagem.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnConsultarViagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/estrada2.png"))); // NOI18N
        btnConsultarViagem.setText("Consultar viagens");
        painelBotoes.add(btnConsultarViagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 265, 110));

        btnConsultarVeiculos.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultarVeiculos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnConsultarVeiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/logo_onibus_oficial.png"))); // NOI18N
        btnConsultarVeiculos.setText("Consultar veiculos");
        painelBotoes.add(btnConsultarVeiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 265, -1));

        btnConsultarRotas.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultarRotas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnConsultarRotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/rota.png"))); // NOI18N
        btnConsultarRotas.setText("Consultar rotas");
        painelBotoes.add(btnConsultarRotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 265, 111));

        btnConsultarPassageiros.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultarPassageiros.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnConsultarPassageiros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/passageiros.png"))); // NOI18N
        btnConsultarPassageiros.setText("Consultar passageiros");
        painelBotoes.add(btnConsultarPassageiros, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, 105));

        jPanel1.add(painelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(902, 0, 300, 650));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fundoPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout fundoPrincipalLayout = new javax.swing.GroupLayout(fundoPrincipal);
        fundoPrincipal.setLayout(fundoPrincipalLayout);
        fundoPrincipalLayout.setHorizontalGroup(
            fundoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
        );
        fundoPrincipalLayout.setVerticalGroup(
            fundoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(fundoPrincipal);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("Funcionario");
        jMenu1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jMenuFuncionarioCadastro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuFuncionarioCadastro.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuFuncionarioCadastro.setText("Cadastro");
        jMenu1.add(jMenuFuncionarioCadastro);

        jMenuFuncionarioConsulta.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuFuncionarioConsulta.setText("Consulta");
        jMenu1.add(jMenuFuncionarioConsulta);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Motorista");
        jMenu2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jMenuMotoristaCadastro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuMotoristaCadastro.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuMotoristaCadastro.setText("Cadastro");
        jMenu2.add(jMenuMotoristaCadastro);

        jMenuMotoristaConsulta.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuMotoristaConsulta.setText("Consulta");
        jMenu2.add(jMenuMotoristaConsulta);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Veiculo");
        jMenu3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jMenuVeiculoCadastro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuVeiculoCadastro.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuVeiculoCadastro.setText("Cadastro");
        jMenu3.add(jMenuVeiculoCadastro);

        jMenuVeiculoConsulta.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuVeiculoConsulta.setText("Consulta");
        jMenu3.add(jMenuVeiculoConsulta);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Passageiro");
        jMenu4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jMenuPassageiroCadastro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuPassageiroCadastro.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuPassageiroCadastro.setText("Cadastro");
        jMenu4.add(jMenuPassageiroCadastro);

        jMenuPassageiroConsulta.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuPassageiroConsulta.setText("Consulta");
        jMenu4.add(jMenuPassageiroConsulta);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Rota");
        jMenu5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jMenuRotaCadastro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuRotaCadastro.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuRotaCadastro.setText("Cadastro");
        jMenu5.add(jMenuRotaCadastro);

        jMenuRotaConsulta.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuRotaConsulta.setText("Consulta");
        jMenu5.add(jMenuRotaConsulta);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Financeiro");
        jMenu6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jMenuFinanceiroConsulta.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuFinanceiroConsulta.setText("Consulta");
        jMenu6.add(jMenuFinanceiroConsulta);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Opções");
        jMenu7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jMenuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuSobre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuSobre.setText("Sobre");
        jMenu7.add(jMenuSobre);

        jMenuControleAcesso.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuControleAcesso.setText("Controle de acesso");
        jMenu7.add(jMenuControleAcesso);

        jMenuPersonalizar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuPersonalizar.setText("Personalizar");
        jMenu7.add(jMenuPersonalizar);

        jMenuBar1.add(jMenu7);

        Sair.setText("Sair");
        Sair.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jMenuLogoff.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuLogoff.setText("Fazer logoff");
        Sair.add(jMenuLogoff);

        jMenuEncerrarSistema.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuEncerrarSistema.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuEncerrarSistema.setText("Encerrar o sistema");
        Sair.add(jMenuEncerrarSistema);

        jMenuBar1.add(Sair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    public JPanel getFundoPrincipal() {
        return fundoPrincipal;
    }
    
    public JMenu getSair() {
        return Sair;
    }

    public JButton getBtnConsultarPassageiros() {
        return btnConsultarPassageiros;
    }

    public JButton getBtnConsultarRotas() {
        return btnConsultarRotas;
    }

    public JButton getBtnConsultarVeiculos() {
        return btnConsultarVeiculos;
    }

    public JButton getBtnConsultarViagem() {
        return btnConsultarViagem;
    }

    public JButton getBtnEfetuarViagem() {
        return btnEfetuarViagem;
    }

    public JMenuItem getjMenuFinanceiroConsulta() {
        return jMenuFinanceiroConsulta;
    }

    public JMenuItem getjMenuFuncionarioCadastro() {
        return jMenuFuncionarioCadastro;
    }

    public JMenuItem getjMenuFuncionarioConsulta() {
        return jMenuFuncionarioConsulta;
    }

    public JMenuItem getjMenuMotoristaCadastro() {
        return jMenuMotoristaCadastro;
    }

    public JMenuItem getjMenuMotoristaConsulta() {
        return jMenuMotoristaConsulta;
    }

    public JMenuItem getjMenuPassageiroCadastro() {
        return jMenuPassageiroCadastro;
    }

    public JMenuItem getjMenuPassageiroConsulta() {
        return jMenuPassageiroConsulta;
    }

    public JMenuItem getjMenuRotaCadastro() {
        return jMenuRotaCadastro;
    }

    public JMenuItem getjMenuRotaConsulta() {
        return jMenuRotaConsulta;
    }

    public JMenuItem getjMenuSobre() {
        return jMenuSobre;
    }

    public JMenuItem getjMenuVeiculoCadastro() {
        return jMenuVeiculoCadastro;
    }

    public JMenuItem getjMenuVeiculoConsulta() {
        return jMenuVeiculoConsulta;
    }

    public JMenuItem getjMenuEncerrarSistema() {
        return jMenuEncerrarSistema;
    }

    public JMenuItem getjMenuPersonalizar() {
        return jMenuPersonalizar;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    

    public JPanel getPainelBotoes() {
        return painelBotoes;
    }

    public JMenuItem getjMenuControleAcesso() {
        return jMenuControleAcesso;
    }

    public JMenuItem getjMenuLogoff() {
        return jMenuLogoff;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public JMenu getjMenu6() {
        return jMenu6;
    }

    public JMenuItem getjMenuAtualizar() {
        return jMenuAtualizar;
    }

    public JPopupMenu getjPopupMenu1() {
        return jPopupMenu1;
    }

    public JMenuItem getjMenuCadastrarPassageiro() {
        return jMenuCadastrarPassageiro;
    }

    public JMenuItem getjMenuCadastroFuncionario() {
        return jMenuCadastroFuncionario;
    }

    public JMenuItem getjMenuCadastroMotorista() {
        return jMenuCadastroMotorista;
    }

    public JMenuItem getjMenuCadastroRota() {
        return jMenuCadastroRota;
    }

    public JMenuItem getjMenuCadastroVeiculo() {
        return jMenuCadastroVeiculo;
    }

    public JMenuItem getjMenuCadastroViagem() {
        return jMenuCadastroViagem;
    }

    public JMenuItem getjMenuConsultaRota() {
        return jMenuConsultaRota;
    }

    public JMenuItem getjMenuConsultaVeiculo() {
        return jMenuConsultaVeiculo;
    }

    public JMenuItem getjMenuConsultaViagem() {
        return jMenuConsultaViagem;
    }

    public JMenuItem getjMenuConsultarFuincionario() {
        return jMenuConsultarFuincionario;
    }

    public JMenuItem getjMenuConsultarMotorista() {
        return jMenuConsultarMotorista;
    }

    public JMenuItem getjMenuConsultarPassageiro() {
        return jMenuConsultarPassageiro;
    }

    public JMenuItem getjMenuFinanceiro() {
        return jMenuFinanceiro;
    }

    public JMenuItem getjMenuLoggof1() {
        return jMenuLoggof1;
    }

    public JMenuItem getjMenuSair() {
        return jMenuSair;
    }

    public JMenu getjFuncionario() {
        return jFuncionario;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Sair;
    private javax.swing.JButton btnConsultarPassageiros;
    private javax.swing.JButton btnConsultarRotas;
    private javax.swing.JButton btnConsultarVeiculos;
    private javax.swing.JButton btnConsultarViagem;
    private javax.swing.JButton btnEfetuarViagem;
    private javax.swing.JPanel fundoPrincipal;
    private javax.swing.JMenu jFuncionario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuAtualizar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCadastrarPassageiro;
    private javax.swing.JMenuItem jMenuCadastroFuncionario;
    private javax.swing.JMenuItem jMenuCadastroMotorista;
    private javax.swing.JMenuItem jMenuCadastroRota;
    private javax.swing.JMenuItem jMenuCadastroVeiculo;
    private javax.swing.JMenuItem jMenuCadastroViagem;
    private javax.swing.JMenuItem jMenuConsultaRota;
    private javax.swing.JMenuItem jMenuConsultaVeiculo;
    private javax.swing.JMenuItem jMenuConsultaViagem;
    private javax.swing.JMenuItem jMenuConsultarFuincionario;
    private javax.swing.JMenuItem jMenuConsultarMotorista;
    private javax.swing.JMenuItem jMenuConsultarPassageiro;
    private javax.swing.JMenuItem jMenuControleAcesso;
    private javax.swing.JMenuItem jMenuEncerrarSistema;
    private javax.swing.JMenuItem jMenuFinanceiro;
    private javax.swing.JMenuItem jMenuFinanceiroConsulta;
    private javax.swing.JMenuItem jMenuFuncionarioCadastro;
    private javax.swing.JMenuItem jMenuFuncionarioConsulta;
    private javax.swing.JMenuItem jMenuLoggof1;
    private javax.swing.JMenuItem jMenuLogoff;
    private javax.swing.JMenuItem jMenuMotoristaCadastro;
    private javax.swing.JMenuItem jMenuMotoristaConsulta;
    private javax.swing.JMenuItem jMenuPassageiroCadastro;
    private javax.swing.JMenuItem jMenuPassageiroConsulta;
    private javax.swing.JMenuItem jMenuPersonalizar;
    private javax.swing.JMenuItem jMenuRotaCadastro;
    private javax.swing.JMenuItem jMenuRotaConsulta;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JMenuItem jMenuSobre;
    private javax.swing.JMenuItem jMenuVeiculoCadastro;
    private javax.swing.JMenuItem jMenuVeiculoConsulta;
    private javax.swing.JMenu jMotorista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenu jPassageiro;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenu jRota;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jVeiculo;
    private javax.swing.JMenu jViagem;
    private javax.swing.JPanel painelBotoes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
    /*    fundoPrincipal.setBackground((Color) arg);
        jPanel1.setBackground((Color) arg);
        jPanel3.setBackground((Color) arg);
        
        painelBotoes.setBackground((Color) arg);
        btnConsultarPassageiros.setBackground((Color) arg);
        btnConsultarRotas.setBackground((Color) arg);
        btnConsultarVeiculos.setBackground((Color) arg);
        btnConsultarViagem.setBackground((Color) arg);
        btnEfetuarViagem.setBackground((Color) arg);
        jMenuBar1.setBackground((Color) arg);
*/
    
    
    }
}
