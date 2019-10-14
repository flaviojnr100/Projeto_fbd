/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.DashBoard;
import view.Mensagens;
import view.TelaLogin;

/**
 *
 * @author Flavio
 */
public class ControllerLogin {
    private TelaLogin tela;
    private DashBoard principal;
    public ControllerLogin(TelaLogin tela,DashBoard principal) {
        this.tela = tela;
        this.principal = principal;
        Control();
    }
    private void Control(){
        tela.getBtnEntrar().addActionListener(new Botoes());
        tela.getBtnSair().addActionListener(new Botoes());
        tela.getBtnEntrar().addKeyListener(new Botoes());
        tela.getBtnSair().addKeyListener(new Botoes());
        
        
    }
    private class Botoes implements ActionListener,KeyListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnSair()){
                if(Mensagens.mensagemConfirmacao("Deseja sair do sistema ?")){
                    System.exit(0);
                }
            }
            if(e.getSource() == tela.getBtnEntrar()){
                if(tela.getUsuarioTxt().getText().equals("adm") && tela.getSenhaTxt().getText().equals("adm")){
                    principal.setVisible(true);
                }
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                tela.getBtnEntrar().doClick();
            }
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                tela.getBtnSair().doClick();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    }
}
