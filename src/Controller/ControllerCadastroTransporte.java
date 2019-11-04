/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import modelVO.Destino;
import modelVO.Motorista;
import modelVO.Tipo_transporte;
import modelVO.Transporte;
import view.CadastroMotorista;
import view.CadastroRota;
import view.CadastroTipoTransporte;
import view.CadastroTransporte;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerCadastroTransporte extends Observable {
    private CadastroTransporte tela;
    private Fachada fachada;
    private String listaHorario;
    private String listaRotas;
    private CadastroMotorista cMotorista;
    private CadastroTipoTransporte cTipoTransporte;
    private CadastroRota cRota;
    

    public ControllerCadastroTransporte(CadastroTransporte tela, Fachada fachada, CadastroMotorista cMotorista, CadastroTipoTransporte cTipoTransporte, CadastroRota cRota) {
        this.tela = tela;
        this.fachada = fachada;
        this.cMotorista = cMotorista;
        this.cTipoTransporte = cTipoTransporte;
        this.cRota = cRota;
        Control();
    }
    
    
    private void Control(){
        tela.getBtnCadastrar().addActionListener(new Botoes());
        tela.getBtnLimpar().addActionListener(new Botoes());
        tela.getBtnSair().addActionListener(new Botoes());
        tela.getBtnAdicionarMotorista().addActionListener(new Botoes());
        tela.getBtnAdicionarRota().addActionListener(new Botoes());
        tela.getBtnAdicionarTransporte().addActionListener(new Botoes());
    }
    
    public void montarComboMotorista(){
        tela.getComboMotorista().removeAllItems();
        List<Motorista> motoristas = fachada.getAllMotorista();
        for(Motorista m:motoristas){
            tela.getComboMotorista().addItem(m.getNome()+" "+m.getSobrenome());
        }
    }
    public void montarComboTipo(){
        tela.getComboTipo().removeAllItems();
        List<Tipo_transporte> tipo = fachada.getAllTipoTransporte();
        for(Tipo_transporte ti:tipo){
            tela.getComboTipo().addItem(ti.getNome()+", Nº de assentos: "+ti.getAssentos());
        }
    }
    public void montarComboRota(){
        tela.getComboRota().removeAllItems();
        List<Destino> destinos = fachada.getAllDestino();
        for(Destino d:destinos){
            tela.getComboRota().addItem(d.getNome());
        }
    }
    
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnCadastrar()){
                if(fachada.salvar(new Transporte(tela.getCorText().getText(), tela.getPlacaText().getText(), tela.getChassiText().getText(), getTipos().get(tela.getComboTipo().getSelectedIndex()), getMotoristas().get(tela.getComboMotorista().getSelectedIndex()), new Destino(4)))){
                    Mensagens.mensagem("Cadastrado com sucesso!");
                    tela.getBtnLimpar().doClick();
                    tela.getBtnSair().doClick();
                    montarComboMotorista();
                    montarComboRota();
                    montarComboTipo();
                }else{
                    Mensagens.mensagem("Erro ao cadastrar!");
                }
            }
            if(e.getSource() == tela.getBtnLimpar()){
            
            }
            if(e.getSource() == tela.getBtnSair()){
                tela.setVisible(false);
            }
            if(e.getSource() == tela.getBtnAdicionarMotorista()){
                cMotorista.setVisible(true);
            }
            if(e.getSource() == tela.getBtnAdicionarRota()){
                cRota.setVisible(true);
            }
            if(e.getSource() == tela.getBtnAdicionarTransporte()){
                cTipoTransporte.setVisible(true);
            }
        }
    }

    public List<Motorista> getMotoristas() {
        return fachada.getAllMotorista();
    }

    

    public List<Tipo_transporte> getTipos() {
        return fachada.getAllTipoTransporte();
    }

    
    
}
