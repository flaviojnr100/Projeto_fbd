/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroTransporte;

/**
 *
 * @author Flavio
 */
public class ControllerCadastroTransporte {
    private CadastroTransporte tela;

    public ControllerCadastroTransporte(CadastroTransporte tela) {
        this.tela = tela;
        Control();
    }
    private void Control(){
        tela.getBtnCadastrar().addActionListener(new Botoes());
        tela.getBtnLimpar().addActionListener(new Botoes());
        tela.getBtnSair().addActionListener(new Botoes());
    }
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(tela.getBtnCadastrar() == e.getSource()){
                
            }
            if(tela.getBtnLimpar() == e.getSource()){
                
            }
            if(tela.getBtnSair() == e.getSource()){
                tela.setVisible(false);
            }
        }
    
    }
    
}
