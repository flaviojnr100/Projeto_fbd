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
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Observable;
import modelVO.Financa;
import view.ConsultarFinança;

/**
 *
 * @author Flavio
 */
public class ControllerConsultaFinanca extends Observable {
    private ConsultarFinança tela;
    private Fachada fachada;
    private List<Financa> financaLike;
    public ControllerConsultaFinanca(ConsultarFinança tela, Fachada fachada) {
        this.tela = tela;
        this.fachada = fachada;
        Control();
    }
    private void Control(){
        tela.getBtnBuscar().addActionListener(new Busca());
        tela.getBtnBuscar().addKeyListener(new Busca());
        tela.getBuscarTxt().addKeyListener(new Busca());
    }
    
    public boolean Limpar(){
        int size = fachada.getAllFinanca().size();
        for(int i=0;i<size;i++){
            tela.getjTableFinancas().getModel().setValueAt("", i, 0);
            tela.getjTableFinancas().getModel().setValueAt("", i, 1);
            tela.getjTableFinancas().getModel().setValueAt("", i, 2);
        }
        if(size>0){
            return true;
        }
        return false;
    }
    public void ColocarDados(){
        List<Financa> financas = fachada.getAllFinanca();
        int i=0;
        for(Financa f:financas){
            tela.getjTableFinancas().getModel().setValueAt(f.getId(), i, 0);
            tela.getjTableFinancas().getModel().setValueAt(f.getData(), i, 1);
            tela.getjTableFinancas().getModel().setValueAt(f.getValor(), i, 2);
            i++;
        }
    }
    public void ColocarDados(List<Financa> financas){
        
        int i=0;
        for(Financa f:financas){
            tela.getjTableFinancas().getModel().setValueAt(f.getId(), i, 0);
            tela.getjTableFinancas().getModel().setValueAt(f.getData(), i, 1);
            tela.getjTableFinancas().getModel().setValueAt(f.getValor(), i, 2);
            i++;
        }
    }
    private class Busca extends KeyAdapter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnBuscar()){
                financaLike  = fachada.buscaLikeFinanca(tela.getBuscarTxt().getText());
                setChanged();
                notifyObservers("busca");
            }
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                if(tela.getBuscarTxt().hasFocus() || tela.getBtnBuscar().hasFocus()){
                    tela.getBtnBuscar().doClick();
                }
            }
        }

       
    }

    public List<Financa> getFinancaLike() {
        return financaLike;
    }
    
    
}
