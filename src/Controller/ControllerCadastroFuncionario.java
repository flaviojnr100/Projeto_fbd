/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroFuncionario;

/**
 *
 * @author Flavio
 */
public class ControllerCadastroFuncionario {
    private CadastroFuncionario tela;

    public ControllerCadastroFuncionario(CadastroFuncionario tela) {
        this.tela = tela;
        Control();
    }
    private void Control(){
        tela.getBtnCadastrar().addActionListener(new Botoes());
        tela.getBtnLimpar().addActionListener(new Botoes());
        tela.getBtnCancelar().addActionListener(new Botoes());
        
    }
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnCadastrar()){
            
            }
            if(e.getSource() == tela.getBtnLimpar()){
            
            }
            if(e.getSource() == tela.getBtnCancelar()){
                tela.setVisible(false);
            }
        }
    
    }
}
