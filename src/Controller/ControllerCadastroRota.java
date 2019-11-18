/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelVO.Destino;
import modelVO.Endereco;
import view.CadastroRota;
import view.ConsultarRota;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerCadastroRota {
    private CadastroRota tela;
    private Fachada fachada;
    private ConsultarRota ccRota;
    public ControllerCadastroRota(CadastroRota tela,Fachada fachada,ConsultarRota ccRota) {
        this.tela = tela;
        this.fachada = fachada;
        this.ccRota = ccRota;
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
                Destino dest = new Destino(tela.getNomeTxt().getText().toUpperCase(), new Endereco(tela.getEstadoTxt().getText().toUpperCase(), tela.getRuaTxt().getText().toUpperCase(), tela.getBairroTxt().getText().toUpperCase(), tela.getCidadeTxt().getText().toUpperCase(),tela.getComplementoTxt().getText().toUpperCase()), new Endereco(tela.getEstado2Txt().getText().toUpperCase(), tela.getRua2Txt().getText().toUpperCase(), tela.getBairro2Txt().getText().toUpperCase(), tela.getCidade2Txt().getText().toUpperCase(),tela.getComplemento2Txt().getText().toUpperCase()), tela.getHorarioTxt().getText(),tela.getPrecoTxt().getText());
                if(fachada.salvarDestino(dest)){
                    Mensagens.mensagem("Cadastro realizado com sucesso!");
                    ccRota.getjMenuAtualizar().doClick();
                    tela.getBtnLimpar().doClick();
                    tela.getBtnCancelar().doClick();
                }else{
                    Mensagens.mensagem("Erro ao realizar o cadastro!");
                }
                
           
            }
            if(e.getSource() == tela.getBtnLimpar()){
                tela.getNomeTxt().setText("");
                tela.getBairroTxt().setText("");
                tela.getBairro2Txt().setText("");
                tela.getEstadoTxt().setText("");
                tela.getEstado2Txt().setText("");
                tela.getCidadeTxt().setText("");
                tela.getCidade2Txt().setText("");
                tela.getRuaTxt().setText("");
                tela.getRua2Txt().setText("");
                tela.getPrecoTxt().setText("");
                tela.getHorarioTxt().setText("");
                tela.getComplementoTxt().setText("");
                tela.getComplemento2Txt().setText("");
                
            }
            if(e.getSource() == tela.getBtnCancelar()){
                tela.setVisible(false);
            }
        }
    
    }
}
