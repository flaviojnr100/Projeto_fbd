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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Observable;
import javax.swing.SwingUtilities;
import modelVO.Transporte;
import sql.SQLUtil;
import view.ConsultarTransporte;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerConsultarTransporte extends Observable {
    private ConsultarTransporte tela;
    private Fachada fachada;
    private List<Transporte> transporteLike;
    public ControllerConsultarTransporte(ConsultarTransporte tela, Fachada fachada) {
        this.tela = tela;
        this.fachada = fachada;
        transporteLike = fachada.getAllTransporte();
        Control();
    }
    private void Control(){
        tela.getjTableTransporte().addMouseListener(new CaixaMenu());
        tela.getMenuAtualizar().addActionListener(new CaixaMenu());
        tela.getMenuCadastrar().addActionListener(new CaixaMenu());
        tela.getMenuExcluir().addActionListener(new CaixaMenu());
        tela.getMenuEditar().addActionListener(new CaixaMenu());
        tela.getMenuSair().addActionListener(new CaixaMenu());
        
        tela.getBuscarTxt().addKeyListener(new Teclado());
    }
    public void ColocarDados(){
        List<Transporte> transportes = fachada.getAllTransporte();
        int i=0;
        for(Transporte t:transportes){
            tela.getjTableTransporte().getModel().setValueAt(t.getId(), i, 0);
            tela.getjTableTransporte().getModel().setValueAt(t.getCor(), i, 1);
            tela.getjTableTransporte().getModel().setValueAt(t.getPlaca(), i, 2);
            tela.getjTableTransporte().getModel().setValueAt(t.getChassi(), i, 3);
            tela.getjTableTransporte().getModel().setValueAt(t.getMotorista().getNome(), i, 4);
            tela.getjTableTransporte().getModel().setValueAt(t.getTipo().getNome(), i, 5);
            i++;
        }
    }
    
    public void ColocarDados(List<Transporte> transportes){
        
        int i=0;
        for(Transporte t:transportes){
            tela.getjTableTransporte().getModel().setValueAt(t.getId(), i, 0);
            tela.getjTableTransporte().getModel().setValueAt(t.getCor(), i, 1);
            tela.getjTableTransporte().getModel().setValueAt(t.getPlaca(), i, 2);
            tela.getjTableTransporte().getModel().setValueAt(t.getChassi(), i, 3);
            tela.getjTableTransporte().getModel().setValueAt(t.getMotorista().getNome(), i, 4);
            tela.getjTableTransporte().getModel().setValueAt(t.getTipo().getNome(), i, 5);
            i++;
        }
    }
    public boolean limpar(){
        List<Transporte> transportes = fachada.getAllTransporte();
        for(int i=0;i<transportes.size()+1;i++){
            for(int j=0;j<6;j++){
                tela.getjTableTransporte().getModel().setValueAt("", i, j);
            }
        }
        if(transportes.size()>0){
            return true;
        }else{
            return false;
        }
    }
    private class CaixaMenu extends MouseAdapter implements ActionListener{
    @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                try{
                if(!tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 0).equals("")){
                   tela.getjPopupMenu1().show(tela.getjTableTransporte(), e.getX(), e.getY());
                }
                }catch(Exception e1){
                    
                }
                
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getMenuAtualizar()){
                setChanged();
                notifyObservers("atualizar");
            }
            if(e.getSource() == tela.getMenuCadastrar()){
            
            }
            if(e.getSource() == tela.getMenuExcluir()){
                if(Mensagens.mensagemConfirmacao("Deseja remover esse registro?")){
                if(fachada.removerTransporte((int)tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 0), (String)tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 2))){
                    Mensagens.mensagem("Removido com sucesso!");
                    tela.getMenuAtualizar().doClick();
                }else{
                    Mensagens.mensagem("Erro ao tentar remover o registro!");
                }
                }
            }
            if(e.getSource() == tela.getMenuEditar()){
            
            }
            if(e.getSource() == tela.getMenuSair()){
                tela.setVisible(false);
            }
        }
    }
    
    private class Teclado extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e) {
            if(tela.getBuscarTxt().hasFocus()){
                if(tela.getjRadioChassi().isSelected()){
                    transporteLike = fachada.buscarLikeTransporte(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Transporte.BUSCARLIKECHASSI);
                }
                if(tela.getjRadioPlaca().isSelected()){
                    transporteLike = fachada.buscarLikeTransporte(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Transporte.BUSCARLIKEPLACA);
                }
                if(tela.getjRadioMotorista().isSelected()){
                    transporteLike = fachada.buscarLikeTransporte(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Transporte.BUSCARLIKEMOTORISTA);
                }
                setChanged();
                notifyObservers("like");
                
            }
        }
    }

    public List<Transporte> getTransporteLike() {
        return transporteLike;
    }

    public void setTransporteLike(List<Transporte> transporteLike) {
        this.transporteLike = transporteLike;
    }

    public ConsultarTransporte getTela() {
        return tela;
    }
    
}