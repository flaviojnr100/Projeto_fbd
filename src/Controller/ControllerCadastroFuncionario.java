/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelVO.Funcionario;
import view.CadastroFuncionario;
import view.ConsultarFuncionario;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerCadastroFuncionario {
    private CadastroFuncionario tela;
    private Fachada fachada;
    private ConsultarFuncionario cFuncionario;
    public ControllerCadastroFuncionario(CadastroFuncionario tela,Fachada fachada,ConsultarFuncionario cFuncionario) {
        this.tela = tela;
        this.fachada = fachada;
        this.cFuncionario = cFuncionario;
        Control();
    }
    private void Control(){
        tela.getBtnCadastrar().addActionListener(new Botoes());
        tela.getBtnLimpar().addActionListener(new Botoes());
        tela.getBtnCancelar().addActionListener(new Botoes());
        tela.getNomeTxt().addKeyListener(new Botoes());
        tela.getSobrenomeTxt().addKeyListener(new Botoes());
        tela.getCpfTxt().addKeyListener(new Botoes());
        tela.getLoginTxt().addKeyListener(new Botoes());
        tela.getSenhaTxt().addKeyListener(new Botoes());
        tela.getConfirmarTxt().addKeyListener(new Botoes());
        
    }
    private class Botoes extends KeyAdapter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnCadastrar()){
                if(tela.getSenhaTxt().getText().equals(tela.getConfirmarTxt().getText())){
                    if(fachada.salvar(new Funcionario(tela.getNomeTxt().getText().toUpperCase(), tela.getSobrenomeTxt().getText().toUpperCase(), tela.getRgTxt().getText(), tela.getCpfTxt().getText(), tela.getDataTxt().getText(), tela.getLoginTxt().getText(), tela.getSenhaTxt().getText()))){
                        Mensagens.mensagem("Funcionario cadastrado com sucesso!");
                        tela.getBtnLimpar().doClick();
                        tela.getBtnCancelar().doClick();
                        cFuncionario.getjMenuAtualizar().doClick();
                    }else{
                        Mensagens.mensagem("Erro, esse registro ja foi cadastrado no sistema!");
                    }
                }else{
                    Mensagens.mensagem("As senhas não coincidem!");
                }
            }
            if(e.getSource() == tela.getBtnLimpar()){
                tela.getNomeTxt().setText("");
                tela.getSobrenomeTxt().setText("");
                tela.getRgTxt().setText(""); 
                tela.getCpfTxt().setText("");
                tela.getDataTxt().setText("");
                tela.getLoginTxt().setText("");
                tela.getSenhaTxt().setText("");
                tela.getConfirmarTxt().setText("");
            }
            if(e.getSource() == tela.getBtnCancelar()){
                tela.setVisible(false);
            }
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if(tela.getCpfTxt().hasFocus() || tela.getNomeTxt().hasFocus() || tela.getSobrenomeTxt().hasFocus() || tela.getLoginTxt().hasFocus() || tela.getSenhaTxt().hasFocus() || tela.getConfirmarTxt().hasFocus()){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    tela.getBtnCadastrar().doClick();
                }
            }
        }
    
    }
}
