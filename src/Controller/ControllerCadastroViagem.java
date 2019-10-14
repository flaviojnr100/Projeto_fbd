/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroViagem;

/**
 *
 * @author Flavio
 */
public class ControllerCadastroViagem {
    private CadastroViagem tela;

    public ControllerCadastroViagem(CadastroViagem tela) {
        this.tela = tela;
        Control();
    }
    private void Control(){
        tela.getBtnFinalizar().addActionListener(new Botoes());
        tela.getBtnCancelar().addActionListener(new Botoes());
    }
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnFinalizar()){
            
            }
            if(e.getSource() == tela.getBtnCancelar()){
                tela.setVisible(false);
                        
            }
        }
    
    }
}
