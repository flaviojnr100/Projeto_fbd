/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.SwingUtilities;
import modelVO.Viagem;
import view.ConsultarViagem;

/**
 *
 * @author Flavio
 */
public class ControllerConsultarViagem {
    private ConsultarViagem tela;
    private Fachada fachada;

    public ControllerConsultarViagem(ConsultarViagem tela, Fachada fachada) {
        this.tela = tela;
        this.fachada = fachada;
        Control();
    }
    private void Control(){
        tela.getjTableViagens().addMouseListener(new Caixa());
    }
    public boolean limpar(){
        List<Viagem> viagens = fachada.getAllViagem();
        for(int i=0;i<viagens.size();i++){
            for(int j=0;j<tela.getjTableViagens().getColumnCount();j++){
                tela.getjTableViagens().getModel().setValueAt("", i, j);
            }
        }
        if(viagens.size()>0){
            return true;
        }else{
            return false;
        }
    }
    public void colocarDados(){
        List<Viagem> viagens = fachada.getAllViagem();
        for(int i=0;i<viagens.size();i++){
            tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getId(), i, 0);
            tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getPassageiro().getNome(), i, 1);
           /* tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getTransporte().getTipo().getNome(), i, 2);
            tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getTransporte().getDestino().getHorario(), i, 3);
            tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getTransporte().getDestino().getPreco(), i, 4);*/
            
        }
    }
    
    private class Caixa extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                try{
                if(!tela.getjTableViagens().getModel().getValueAt(tela.getjTableViagens().getSelectedRow(), 0).equals("")){
                    tela.getjPopupMenu1().show(tela.getjTableViagens(), e.getX(), e.getY());
                }
                }catch(Exception e1){
                    
                }
            }
        }

       
        
    }
}
