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
import modelVO.Tipo_transporte;
import view.CadastroTipoTransporte;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerCadastroTipoTransporte extends Observable {
    private CadastroTipoTransporte tela;
    private Fachada fachada;
    private ControllerCadastroTransporte cTransporte;
    public ControllerCadastroTipoTransporte(CadastroTipoTransporte tela,Fachada fachada,ControllerCadastroTransporte cTransporte) {
        this.tela = tela;
        this.fachada = fachada;
        this.cTransporte = cTransporte;
        Control();
    }
    private void Control(){
        tela.getBtnCadastrar().addActionListener(new Botoes());
        tela.getBtnSair().addActionListener(new Botoes());
    }
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnCadastrar()){
                if(fachada.salvarTipo_transporte(new Tipo_transporte(tela.getNomeText().getText().toUpperCase(), Integer.parseInt(tela.getAssentosText().getText())))){
                    Mensagens.mensagem("Cadastro realizado com sucesso!");
                    setChanged();
                    notifyObservers();
                    BaseDados.CarregarTipoTransporte();
                }else{
                    Mensagens.mensagem("Erro ao realizar o cadastro!");
                }
            }
            if(e.getSource() == tela.getBtnSair()){
                tela.setVisible(false);
            }
        }
    }

    public ControllerCadastroTransporte getcTransporte() {
        return cTransporte;
    }
    
}
