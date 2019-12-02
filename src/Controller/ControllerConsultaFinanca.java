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
import modelVO.BaseDados;
import modelVO.Financa;
import sql.SQLUtil;
import view.ConsultarFinança;

/**
 *
 * @author Flavio
 */
public class ControllerConsultaFinanca extends Observable {
    private ConsultarFinança tela;
    private Fachada fachada;
    private List<Financa> financaLike;
    private ControllerInformacoesFinancas ccInformacao;
    public ControllerConsultaFinanca(ConsultarFinança tela, Fachada fachada,ControllerInformacoesFinancas ccInformacao) {
        this.tela = tela;
        this.fachada = fachada;
        this.ccInformacao = ccInformacao;
        Control();
    }
    private void Control(){
        tela.getBtnBuscar().addActionListener(new Busca());
        tela.getBtnBuscar().addKeyListener(new Busca());
        tela.getBuscarTxt().addKeyListener(new Busca());
        
        tela.getjTableFinancas().addMouseListener(new Caixa());
        tela.getjMenuAtualizar().addActionListener(new Caixa());
        tela.getjMenuInformacoes().addActionListener(new Caixa());
        tela.getjMenuSair().addActionListener(new Caixa());
    }
    
    public boolean Limpar(){
        
        for(int i=0;i<tela.getjTableFinancas().getRowCount();i++){
            tela.getjTableFinancas().getModel().setValueAt("", i, 0);
            tela.getjTableFinancas().getModel().setValueAt("", i, 1);
            tela.getjTableFinancas().getModel().setValueAt("", i, 2);
        }
        if(BaseDados.getFinancas().size()>0){
            return true;
        }
        return false;
    }
    public boolean LimparSimples(){
        int size = BaseDados.getFinancas().size();
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
        int i=0;
        for(Financa f:BaseDados.getFinancas()){
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
    
    private class Caixa extends MouseAdapter implements ActionListener{
     
        @Override
        public void mouseClicked(MouseEvent e) {
            try{
            if(SwingUtilities.isRightMouseButton(e)){
                if(!tela.getjTableFinancas().getModel().getValueAt(tela.getjTableFinancas().getSelectedRow(), 0).equals("")){
                    tela.getjMenuInformacoes().setVisible(true);
                }else{
                    tela.getjMenuInformacoes().setVisible(false);
                }
                tela.getjPopupMenu1().show(tela.getjTableFinancas(), e.getX(), e.getY());
            }
            }catch(Exception e1){
                
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getjMenuAtualizar()){
                setChanged();
                notifyObservers("atualizar");
            }
            if(e.getSource() == tela.getjMenuInformacoes()){
                ccInformacao.setViagens(fachada.buscarLikeViagem((String)tela.getjTableFinancas().getModel().getValueAt(tela.getjTableFinancas().getSelectedRow(), 1), SQLUtil.Viagem.BUSCARLIKEDATA));
                ccInformacao.setData(tela.getjTableFinancas().getModel().getValueAt(tela.getjTableFinancas().getSelectedRow(), 1)+"");
                ccInformacao.limpar();
                ccInformacao.colocarDados();
                ccInformacao.getTela().getLblData().setText(ccInformacao.getData());
                ccInformacao.getTela().setVisible(true);
            }
            if(e.getSource() == tela.getjMenuSair()){
                tela.setVisible(false);
            }
        }
    }

    public List<Financa> getFinancaLike() {
        return financaLike;
    }
    
    
}
