/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import modelVO.Motorista;
import view.EditarMotorista;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerEditarMotorista extends Observable {
    private EditarMotorista tela;
    private int colunaSelecionada=0;
    private Fachada fachada;
    private Motorista editarMotorista;
    public ControllerEditarMotorista(EditarMotorista tela,Fachada fachada) {
        this.tela = tela;
        
        this.fachada = fachada;
        Control();
    }
    private void Control(){
        tela.getBtnEditar().addActionListener(new Botoes());
        tela.getBtnLimpar().addActionListener(new Botoes());
        tela.getBtnCancelar().addActionListener(new Botoes());
    }
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(tela.getBtnEditar() == e.getSource()){
                if(Mensagens.mensagemConfirmacao("Deseja fazer a alteração no registro?")){
                    if((tela.getCpfTxt().getText().equals(editarMotorista.getCpf()) || fachada.verificarExistenciaMotorista(tela.getCpfTxt().getText())) && fachada.editar(editarMotorista, new Motorista(tela.getNomeTxt().getText().toUpperCase(), tela.getSobrenomeTxt().getText().toUpperCase(), tela.getRgTxt().getText(), tela.getCpfTxt().getText(), tela.getDataTxt().getText(), tela.getCnhTxt().getText()))){
                        
                        String [] m={tela.getNomeTxt().getText().toUpperCase(), tela.getSobrenomeTxt().getText().toUpperCase(), tela.getRgTxt().getText(), tela.getCpfTxt().getText(), tela.getDataTxt().getText(), tela.getCnhTxt().getText(),colunaSelecionada+""};
                        setChanged();
                        notifyObservers(m);
                        tela.getBtnCancelar().doClick();
                    }else{
                       Mensagens.mensagem("Erro ao fazer a alteração!");
                    }
                }
            }
            if(tela.getBtnCancelar() == e.getSource()){
                tela.setVisible(false);
            }
            if(tela.getBtnLimpar() == e.getSource()){
                tela.getNomeTxt().setText("");
                tela.getSobrenomeTxt().setText("");
                tela.getRgTxt().setText("");
                tela.getCpfTxt().setText("");
                tela.getDataTxt().setText("");
                tela.getCnhTxt().setText("");
                tela.getNomeTxt().requestFocus();
            }
        }
    
    }

    public Motorista getEditarMotorista() {
        return editarMotorista;
    }

    public void setEditarMotorista(Motorista editarMotorista) {
        this.editarMotorista = editarMotorista;
    }

    public EditarMotorista getTela() {
        return tela;
    }

    public int getColunaSelecionada() {
        return colunaSelecionada;
    }

    public void setColunaSelecionada(int colunaSelecionada) {
        this.colunaSelecionada = colunaSelecionada;
    }
    
    
}
