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
import java.util.Observable;
import modelVO.Passageiro;
import view.CadastroPassageiro;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerCadastroPassageiro{
    private CadastroPassageiro tela;
    private Fachada fachada;
    private ControllerConsultarPassageiro cccPassageiro;
    public ControllerCadastroPassageiro(CadastroPassageiro tela,Fachada fachada,ControllerConsultarPassageiro cccPassageiro) {
        this.tela = tela;
        this.fachada = fachada;
        this.cccPassageiro = cccPassageiro;
        Control();
    }
    
    private void Control(){
        tela.getBtnCadastrar().addActionListener(new Botoes());
        tela.getBtnLimpar().addActionListener(new Botoes());
        tela.getBtnCancelar().addActionListener(new Botoes());
        tela.getNomeTxt().addKeyListener(new Botoes());
        tela.getSobrenomeTxt().addKeyListener(new Botoes());
        tela.getCpfTxt().addKeyListener(new Botoes());
    }
    private class Botoes extends KeyAdapter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnCadastrar()){
                if(fachada.salvar(new Passageiro(tela.getNomeTxt().getText().toUpperCase(), tela.getSobrenomeTxt().getText().toUpperCase(), tela.getCpfTxt().getText()))){
                    Mensagens.mensagem("Cadastro realizado com sucesso!");
                    tela.getBtnLimpar().doClick();
                    tela.getBtnCancelar().doClick();
                    cccPassageiro.getTela().getjMenuAtualizar().doClick();
                    
                }
            }
            if(e.getSource() == tela.getBtnLimpar()){
                tela.getNomeTxt().setText("");
                tela.getSobrenomeTxt().setText("");
                tela.getCpfTxt().setText("");
            }
            if(e.getSource() == tela.getBtnCancelar()){
                tela.setVisible(false);
            }
        }
         @Override
        public void keyPressed(KeyEvent e) {
            if(tela.getNomeTxt().hasFocus() || tela.getSobrenomeTxt().hasFocus() || tela.getCpfTxt().hasFocus()){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    tela.getBtnCadastrar().doClick();
                }
            }
        }
    
    }
}
