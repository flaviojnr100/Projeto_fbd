/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelVO.BaseDados;
import modelVO.Destino;
import modelVO.Endereco;
import view.EditarRota;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerEditarRota {
    private EditarRota tela;
    private Fachada fachada;
    private int codigo;
    private ControllerConsultarRota cccRota;
    public ControllerEditarRota(EditarRota tela, Fachada fachada) {
        this.tela = tela;
        this.fachada = fachada;
        this.cccRota = cccRota;
        Control();
    }
    private void Control(){
        tela.getBtnEditar().addActionListener(new Botoes());
        tela.getBtnLimpar().addActionListener(new Botoes());
        tela.getBtnCancelar().addActionListener(new Botoes());
    }
    
    private class Botoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnEditar()){
                if(fachada.editar(codigo,new Destino(tela.getNomeTxt().getText().toUpperCase(), new Endereco(tela.getEstadoTxt().getText().toUpperCase(), tela.getRuaTxt().getText().toUpperCase(), tela.getBairroTxt().getText().toUpperCase(), tela.getCidadeTxt().getText().toUpperCase(), tela.getComplementoTxt().getText().toUpperCase()), new Endereco(tela.getEstadoTxt2().getText().toUpperCase(), tela.getRuaTxt2().getText().toUpperCase(), tela.getBairroTxt2().getText().toUpperCase(), tela.getCidadeTxt2().getText().toUpperCase(), tela.getComplementoTxt2().getText().toUpperCase()), tela.getHorarioTxt().getText(), tela.getPrecoTxt().getText()))){
                    Mensagens.mensagem("Registro editado com sucesso!");
                    BaseDados.CarregarRota();
                    cccRota.getTela().getjMenuAtualizar().doClick();
                    tela.getBtnCancelar().doClick();
                }else{
                    Mensagens.mensagem("Erro ao editar o registro!");
                }
            }
            if(e.getSource() == tela.getBtnLimpar()){
                tela.getNomeTxt().setText("");
                tela.getEstadoTxt().setText("");
                tela.getRuaTxt().setText("");
                tela.getBairroTxt().setText("");
                tela.getCidadeTxt().setText("");
                tela.getComplementoTxt().setText("");
                tela.getEstadoTxt2().setText("");
                tela.getRuaTxt2().setText("");
                tela.getBairroTxt2().setText("");
                tela.getCidadeTxt2().setText("");
                tela.getComplementoTxt2().setText("");
                tela.getHorarioTxt().setText("");
                tela.getPrecoTxt().setText("");
            }
            if(e.getSource() == tela.getBtnCancelar()){
                tela.setVisible(false);
            }
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCccRota(ControllerConsultarRota cccRota) {
        this.cccRota = cccRota;
    }
    
}
