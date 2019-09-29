/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroFuncionario;
import view.Mensagens;

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
        tela.getBtnSair().addActionListener(new Botoes());
        tela.getBtnLimpar().addActionListener(new Botoes());
    }
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(tela.getBtnSair() == e.getSource()){
                if(Mensagens.mensagemConfirmacao("Deseja sair da tela de cadastro ?")){
                    System.exit(0);
                }
                
            }
            if(tela.getBtnLimpar() == e.getSource()){
                tela.getNomeText().setText("");
                tela.getSobrenomeText().setText("");
                tela.getSenhaText().setText("");
                tela.getRgText().setText("");
                tela.getCpfText().setText("");
                tela.getCsenhaText().setText("");
                tela.getLoginText().setText("");
                tela.getDataText().setText("");
                
            }
        }
        
    }
    
}
