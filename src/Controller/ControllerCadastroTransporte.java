/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import modelVO.BaseDados;
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
    private mudarCombo mudarE = new mudarCombo();

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
        
        tela.getComboRota().addItemListener(mudarE);
    }
    
    public void montarComboMotorista(){
        tela.getComboMotorista().removeAllItems();
        
        for(Motorista m:BaseDados.getMotoristas()){
            tela.getComboMotorista().addItem(m.getNome()+" "+m.getSobrenome());
        }
        
    }
    public void montarComboTipo(){
        tela.getComboTipo().removeAllItems();
        
        for(Tipo_transporte ti:BaseDados.getTipoTransportes()){
            tela.getComboTipo().addItem(ti.getNome()+", Nº de assentos: "+ti.getAssentos());
        }
        
    }
    public void montarComboRota(){
        tela.getComboRota().removeItemListener(new mudarCombo());
        tela.getComboRota().removeAllItems();
        
        for(Destino d:BaseDados.getDestinos()){
            tela.getComboRota().addItem(d.getNome()+", Horario: "+d.getHorario());
        }
        
        
    }
    
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnCadastrar()){
                Transporte transporte = new Transporte(tela.getCorText().getText().toUpperCase(), tela.getPlacaText().getText().toUpperCase(), tela.getChassiText().getText().toUpperCase(), getMotoristas().get(tela.getComboMotorista().getSelectedIndex()), getTipos().get(tela.getComboTipo().getSelectedIndex()), fachada.buscarIdDestino(fachada.getAllDestino().get(tela.getComboRota().getSelectedIndex()).getId()));
                              
                    if(fachada.salvar(transporte)){
                        Mensagens.mensagem("Cadastrado com sucesso!");
                        tela.getBtnLimpar().doClick();
                        tela.getBtnSair().doClick();
                        desabilitarEvento();
                        montarComboMotorista();
                        montarComboRota();
                        montarComboTipo();
                        habilitarEvento();
                        BaseDados.CarregarTransporte();
                
                }else{
                    if(tela.getComboMotorista().getSelectedItem().equals("Vazio")){
                        Mensagens.mensagem("Erro, não pode efetuar o cadastro sem escolher um motorista, cadastre pelo menos um");
                    }
                    if(tela.getComboRota().getSelectedItem().equals("Vazio")){
                        Mensagens.mensagem("Erro, não pode efetuar o cadastro sem escolher uma rota, cadastre pelo menos um");
                    }
                    if(tela.getComboTipo().getSelectedItem().equals("Vazio")){
                        Mensagens.mensagem("Erro, não pode efetuar o cadastro sem escolher o tipo do veiculo, cadastre pelo menos um");
                    }
                }
            }
            if(e.getSource() == tela.getBtnLimpar()){
                tela.getCorText().setText("");
                tela.getPlacaText().setText("");
                tela.getChassiText().setText("");
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
    
    public void desabilitarEvento(){
        tela.getComboRota().removeItemListener(mudarE);
    }
    public void habilitarEvento(){
        tela.getComboRota().addItemListener(mudarE);
    }

    public List<Motorista> getMotoristas() {
        return fachada.getAllMotorista();
    }

    

    public List<Tipo_transporte> getTipos() {
        return fachada.getAllTipoTransporte();
    }
    
    private class mudarCombo implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource() == tela.getComboRota()){
                Destino destino = BaseDados.getDestinos().get(tela.getComboRota().getSelectedIndex());
                String texto = "Nome: "+destino.getNome()+"\nCidade de partida: "+destino.getPartida().getCidade()+"\nCidade de destino: "+destino.getDestino().getCidade()+"\nHorario: "+destino.getHorario()+"\nPreço: "+destino.getPreco();
                setChanged();
                notifyObservers(texto);
              
                
                    
            }
        }
    }

    public CadastroTransporte getTela() {
        return tela;
    }

    
    
}
