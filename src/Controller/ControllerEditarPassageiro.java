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
import java.util.Observable;
import modelVO.BaseDados;
import modelVO.Passageiro;
import view.EditarPassageiro;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerEditarPassageiro extends Observable {
    private EditarPassageiro tela;
    private Fachada fachada;
    private Passageiro editarPassageiro;
    private int linha;
    public ControllerEditarPassageiro(EditarPassageiro tela, Fachada fachada) {
        this.tela = tela;
        this.fachada = fachada;
        Control();
    }
    private void Control(){
        tela.getBtnEditar().addActionListener(new Botoes());
        tela.getBtnCancelar().addActionListener(new Botoes());
        tela.getNomeTxt().addKeyListener(new Botoes());
        tela.getSobrenomeTxt().addKeyListener(new Botoes());
        tela.getCpfTxt().addKeyListener(new Botoes());
    }
    private class Botoes extends KeyAdapter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnEditar()){
                if(fachada.editarPassageiro(editarPassageiro, new Passageiro(tela.getNomeTxt().getText().toUpperCase(), tela.getSobrenomeTxt().getText().toUpperCase(), tela.getCpfTxt().getText()))){
                    Mensagens.mensagem("Registro editado com sucesso!");
                    BaseDados.CarregarPassageiro();
                    setChanged();
                    String [] dados={tela.getNomeTxt().getText().toUpperCase(), tela.getSobrenomeTxt().getText().toUpperCase(), tela.getCpfTxt().getText(),editarPassageiro.getId()+"",linha+""};
                    notifyObservers(dados);
                    tela.getBtnCancelar().doClick();
                }else{
                    Mensagens.mensagem("Erro ao editar o registro!");
                }
            }
            
            if(e.getSource() == tela.getBtnCancelar()){
                tela.setVisible(false);
            }
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if(tela.getNomeTxt().hasFocus() || tela.getSobrenomeTxt().hasFocus() || tela.getCpfTxt().hasFocus()){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    tela.getBtnEditar().doClick();
                }
            }   
        }
    }

    public Passageiro getEditarPassageiro() {
        return editarPassageiro;
    }

    public void setEditarPassageiro(Passageiro editarPassageiro) {
        this.editarPassageiro = editarPassageiro;
    }

    public EditarPassageiro getTela() {
        return tela;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }
    
}
