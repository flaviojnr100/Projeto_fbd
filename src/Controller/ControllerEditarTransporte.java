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
import java.util.Observable;
import modelVO.BaseDados;
import modelVO.Destino;
import modelVO.Motorista;
import modelVO.Transporte;
import view.EditarTransporte;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerEditarTransporte extends Observable {
    private EditarTransporte tela;
    private Fachada fachada;
    private Motorista [] motoristas;
    private Destino [] rotas;
   
    
    private int id;
    private ControllerConsultarTransporte ccTransporte;
    public ControllerEditarTransporte(EditarTransporte tela, Fachada fachada) {
        this.tela = tela;
        this.fachada = fachada;
       
        Control();
    }
    private void Control(){
        tela.getBtnSalvar().addActionListener(new Botoes());
        tela.getBtnSair().addActionListener(new Botoes());
        
    }
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnSalvar()){
                if(Mensagens.mensagemConfirmacao("Deseja alterar o registro?")){
                    
                    
                if(fachada.editar(new Transporte(tela.getCorText().getText(),tela.getPlacaText().getText(),tela.getChassiText().getText()),id)){
                    Mensagens.mensagem("Editado com sucesso!");
                    BaseDados.CarregarTransporte();
                    ccTransporte.getTela().getMenuAtualizar().doClick();
                    tela.getBtnSair().doClick();
                    
                }else{
                    Mensagens.mensagem("Erro ao editar o registro!");
                }
                }
                
            }else if(e.getSource() == tela.getBtnSair()){
                tela.setVisible(false);
            }
        }
    }
    
    

    public Motorista[] getMotoristas() {
        return motoristas;
    }

   

   

    public EditarTransporte getTela() {
        return tela;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCcTransporte(ControllerConsultarTransporte ccTransporte) {
        this.ccTransporte = ccTransporte;
    }

   
    
}
