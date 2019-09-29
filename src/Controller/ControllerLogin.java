/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import view.Login;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerLogin {
    private Login tela;

    public ControllerLogin(Login tela) {
        this.tela = tela;
        Control();
    }
    private void Control(){
        tela.getBtnSair().addActionListener(new Botoes());
        tela.getBtnEntrar().addMouseMotionListener(new Botoes());
        tela.getBtnSair().addMouseMotionListener(new Botoes());
    
    }
    
    private class Botoes implements ActionListener,MouseMotionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(tela.getBtnSair() == e.getSource()){
                if(Mensagens.mensagemConfirmacao("Deseja sair do sistema ?")){
                    System.exit(0);
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseMoved(MouseEvent e) {
           
        }
        
    }
    
}
