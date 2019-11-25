/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.SwingUtilities;
import modelVO.BaseDados;
import modelVO.Viagem;
import view.ConsultarViagem;
import view.InformacoesViagem;

/**
 *
 * @author Flavio
 */
public class ControllerConsultarViagem {
    private ConsultarViagem tela;
    private Fachada fachada;
    private InformacoesViagem iViagem;

    public ControllerConsultarViagem(ConsultarViagem tela, Fachada fachada,InformacoesViagem iViagem) {
        this.tela = tela;
        this.fachada = fachada;
        this.iViagem = iViagem;
        Control();
    }
    private void Control(){
        tela.getjTableViagens().addMouseListener(new Caixa());
        tela.getjMenuAtualizar().addActionListener(new Caixa());
        tela.getjMenuCadastrar().addActionListener(new Caixa());
        tela.getjMenuEditar().addActionListener(new Caixa());
        tela.getjMenuInformacoes().addActionListener(new Caixa());
        tela.getjMenuRemover().addActionListener(new Caixa());
        tela.getjMenuSair().addActionListener(new Caixa());
        
        iViagem.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iViagem.setVisible(false);
            }
        });
        iViagem.getBtnOK().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(iViagem.getBtnOK().hasFocus()){
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        iViagem.getBtnOK().doClick();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }
    public boolean limparSimples(){
        
        for(int i=0;i<BaseDados.getViagens().size();i++){
            for(int j=0;j<tela.getjTableViagens().getColumnCount();j++){
                tela.getjTableViagens().getModel().setValueAt("", i, j);
            }
        }
        if(BaseDados.getViagens().size()>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean limpar(){
        
        for(int i=0;i<tela.getjTableViagens().getRowCount();i++){
            for(int j=0;j<tela.getjTableViagens().getColumnCount();j++){
                tela.getjTableViagens().getModel().setValueAt("", i, j);
            }
        }
        if(BaseDados.getViagens().size()>0){
            return true;
        }else{
            return false;
        }
    }
    public void colocarDados(){
        
        for(int i=0;i<BaseDados.getViagens().size();i++){
            tela.getjTableViagens().getModel().setValueAt(BaseDados.getViagens().get(i).getId(), i, 0);
            tela.getjTableViagens().getModel().setValueAt(BaseDados.getViagens().get(i).getPassageiro().getNome(), i, 1);
            tela.getjTableViagens().getModel().setValueAt(BaseDados.getViagens().get(i).getTransporte().getTipo().getNome(), i, 2);
            tela.getjTableViagens().getModel().setValueAt(BaseDados.getViagens().get(i).getDestino().getNome(), i, 3);
            tela.getjTableViagens().getModel().setValueAt(BaseDados.getViagens().get(i).getDestino().getHorario(), i, 4);
            tela.getjTableViagens().getModel().setValueAt(BaseDados.getViagens().get(i).getPreco(), i, 5);
            
        }
    }
    
    private class Caixa extends MouseAdapter implements ActionListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                try{
                if(!tela.getjTableViagens().getModel().getValueAt(tela.getjTableViagens().getSelectedRow(), 0).equals("")){
                    tela.getjMenuEditar().setVisible(true);
                    tela.getjMenuRemover().setVisible(true);
                    tela.getjMenuInformacoes().setVisible(true);
                    tela.getjPopupMenu1().show(tela.getjTableViagens(), e.getX(), e.getY());
                }else{
                    tela.getjMenuEditar().setVisible(false);
                    tela.getjMenuRemover().setVisible(false);
                    tela.getjMenuInformacoes().setVisible(false);
                    tela.getjPopupMenu1().show(tela.getjTableViagens(), e.getX(), e.getY());
                }
                }catch(Exception e1){
                    
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getjMenuAtualizar()){
            
            }
            if(e.getSource() == tela.getjMenuCadastrar()){
            
            }
            if(e.getSource() == tela.getjMenuEditar()){
            
            }
            if(e.getSource() == tela.getjMenuInformacoes()){
                int id = (int)tela.getjTableViagens().getModel().getValueAt(tela.getjTableViagens().getSelectedRow(), 0);
                Viagem viagem = fachada.buscarIdViagem(id);
                iViagem.getLblNome().setText(viagem.getPassageiro().getNome());
                iViagem.getLblSobrenome().setText(viagem.getPassageiro().getSobrenome());
                iViagem.getLblCpf().setText(viagem.getPassageiro().getCpf());
                
                iViagem.getLblTipo().setText(viagem.getTransporte().getTipo().getNome());
                iViagem.getLblCor().setText(viagem.getTransporte().getCor());
                iViagem.getLblPlaca().setText(viagem.getTransporte().getPlaca());
                
                iViagem.getLblNomeRota().setText(viagem.getDestino().getNome());
                iViagem.getLblHorarioRota().setText(viagem.getDestino().getHorario());
                iViagem.getLblPrecoRota().setText(viagem.getDestino().getPreco());
                
                iViagem.getLblHorarioCompra().setText(viagem.getHora_viagem());
                iViagem.getLblDataCompra().setText(viagem.getData_viagem());
                iViagem.getLblValorCompra().setText(viagem.getPreco());
                
                iViagem.setVisible(true);
            }
            if(e.getSource() == tela.getjMenuRemover()){
            
            }
            if(e.getSource() == tela.getjMenuSair()){
                tela.setVisible(false);
            }
        }

       
        
    }
}
