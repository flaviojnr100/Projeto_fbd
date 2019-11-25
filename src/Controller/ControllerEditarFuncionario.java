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
import modelVO.BaseDados;
import modelVO.Funcionario;
import view.EditarFuncionario;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerEditarFuncionario extends Observable {
    private EditarFuncionario tela;
    private Fachada fachada;
    private Funcionario editarFuncionario;
    private int linha;
    public ControllerEditarFuncionario(EditarFuncionario tela, Fachada fachada) {
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
            if(e.getSource() == tela.getBtnEditar()){
                if(tela.getSenhaTxt().getText().equals(tela.getConfirmarTxt().getText()) && (editarFuncionario.getCpf().equals(tela.getCpfTxt().getText()) || fachada.verificarCpfFuncionario(tela.getCpfTxt().getText()))){
                     
                if(fachada.editarFuncionario(editarFuncionario,new Funcionario(tela.getNomeTxt().getText().toUpperCase(), tela.getSobrenomeTxt().getText().toUpperCase(), tela.getRgTxt().getText(), tela.getCpfTxt().getText(), tela.getDataTxt().getText(), tela.getLoginTxt().getText(), tela.getSenhaTxt().getText()))){
                    Mensagens.mensagem("Registro editado com sucesso!");
                    String [] fu={tela.getNomeTxt().getText().toUpperCase(), tela.getSobrenomeTxt().getText().toUpperCase(), tela.getRgTxt().getText(), tela.getCpfTxt().getText(), tela.getDataTxt().getText(), tela.getLoginTxt().getText(),linha+"",editarFuncionario.getId()+""};
                    BaseDados.CarregarFuncionario();
                    setChanged();
                    notifyObservers(fu);
                    tela.getBtnCancelar().doClick();
                }else{
                        Mensagens.mensagem("Erro ao editar o registro!");
                }
                }else{
                    if(tela.getSenhaTxt().getText().equals(tela.getConfirmarTxt().getText())){
                    Mensagens.mensagem("Erro, as senhas não coincidem!");
                    }
                    if((editarFuncionario.getCpf().equals(tela.getCpfTxt().getText()) || fachada.verificarCpfFuncionario(tela.getCpfTxt().getText()))){
                    Mensagens.mensagem("Erro, esse registro ja foi cadastrado no sistema!");
                    }
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
    }

    public Funcionario getEditarFuncionario() {
        return editarFuncionario;
    }

    public void setEditarFuncionario(Funcionario editarFuncionario) {
        this.editarFuncionario = editarFuncionario;
    }

    public EditarFuncionario getTela() {
        return tela;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }
    
}
