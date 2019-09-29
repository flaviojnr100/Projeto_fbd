/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroRodoviaria;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerRodoviaria {
    private CadastroRodoviaria tela;

    public ControllerRodoviaria(CadastroRodoviaria tela) {
        this.tela = tela;
        Control();
    }
    private void Control(){
        tela.getBtnSair().addActionListener(new Botoes());
    }
    
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnSair()){
                if(Mensagens.mensagemConfirmacao("Deseja sair da tela de cadastro de rodoviaria ?")){
                    System.exit(0);
                }
            }
        }
    
    }
}
