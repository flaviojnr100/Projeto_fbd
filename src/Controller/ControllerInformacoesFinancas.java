/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelVO.Viagem;
import view.InformacoesFinanca;

/**
 *
 * @author Flavio
 */
public class ControllerInformacoesFinancas {
    private InformacoesFinanca tela;
    private Fachada fachada;
    private List<Viagem> viagens;
    private String data;
    public ControllerInformacoesFinancas(InformacoesFinanca tela, Fachada fachada) {
        this.tela = tela;
        this.fachada = fachada;
        Control();
    }
    private void Control(){
        tela.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.setVisible(false);
            }
        });
    }
    public void colocarDados(){
        for(int i=0;i<viagens.size();i++){
            tela.getjTableFinancas().getModel().setValueAt(viagens.get(i).getId(), i, 0);
            tela.getjTableFinancas().getModel().setValueAt(viagens.get(i).getPassageiro().getNome(), i, 1);
            tela.getjTableFinancas().getModel().setValueAt(viagens.get(i).getPreco(), i, 2);
            tela.getjTableFinancas().getModel().setValueAt(viagens.get(i).getHora_viagem(), i, 3);
        }
    }
    public void limpar(){
        for(int i=0;i<tela.getjTableFinancas().getRowCount();i++){
            tela.getjTableFinancas().getModel().setValueAt("", i, 0);
            tela.getjTableFinancas().getModel().setValueAt("", i, 1);
            tela.getjTableFinancas().getModel().setValueAt("", i, 2);
            tela.getjTableFinancas().getModel().setValueAt("", i, 3);
        }
    
    }

   

    public List<Viagem> getViagens() {
        return viagens;
    }

   

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public InformacoesFinanca getTela() {
        return tela;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
