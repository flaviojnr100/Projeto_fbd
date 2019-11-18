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
import modelVO.Destino;
import sql.SQLUtil;
import view.CadastroRota;
import view.ConsultarRota;
import view.EditarRota;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerConsultarRota extends Observable {
    private ConsultarRota tela;
    private Fachada fachada;
    private EditarRota eRota;
    private ControllerEditarRota ccRota;
    private CadastroRota cRota;
    private List<Destino> rotasLike;
    public ControllerConsultarRota(ConsultarRota tela, Fachada fachada,EditarRota eRota,ControllerEditarRota ccRota,CadastroRota cRota) {
        this.tela = tela;
        this.fachada = fachada;
        this.eRota = eRota;
        this.ccRota = ccRota;
        this.cRota = cRota;
        Control();
    }
    private void Control(){
        tela.getjTableRotas().addMouseListener(new Caixa());
        
        tela.getjMenuAtualizar().addActionListener(new Caixa());
        tela.getjMenuCadastrar().addActionListener(new Caixa());
        tela.getjMenuEditar().addActionListener(new Caixa());
        tela.getjMenuRemover().addActionListener(new Caixa());
        tela.getjMenuSair().addActionListener(new Caixa());
        
        tela.getBtnBuscar().addActionListener(new Caixa());
        tela.getBuscarTxt().addKeyListener(new Teclado());
    }
    
    public void colocarDados(){
        List<Destino> rotas = fachada.getAllDestino();
        
        for(int i=0;i<rotas.size();i++){
            tela.getjTableRotas().getModel().setValueAt(rotas.get(i).getId(), i, 0);
            tela.getjTableRotas().getModel().setValueAt(rotas.get(i).getNome(), i, 1);
            tela.getjTableRotas().getModel().setValueAt(rotas.get(i).getPreco(), i, 2);
            
        }
    }
    public void colocarDados(List<Destino> rotas){
                
        for(int i=0;i<rotas.size();i++){
            tela.getjTableRotas().getModel().setValueAt(rotas.get(i).getId(), i, 0);
            tela.getjTableRotas().getModel().setValueAt(rotas.get(i).getNome(), i, 1);
            tela.getjTableRotas().getModel().setValueAt(rotas.get(i).getPreco(), i, 2);
            
        }
    }
    
    public boolean LimparDados(){
        List<Destino> rotas = fachada.getAllDestino();
        
        for(int i=0;i<rotas.size()+1;i++){
            for(int j=0;j<3;j++){
                tela.getjTableRotas().getModel().setValueAt("", i, j);
            }
        }
        if(rotas.size()>=0){
            return true;
        }else{
            return false;
        }
    }
    
    private class Caixa extends MouseAdapter implements ActionListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                try{
                if(!tela.getjTableRotas().getModel().getValueAt(tela.getjTableRotas().getSelectedRow(), 0).equals("")){
                    tela.getjPopupMenu1().show(tela.getjTableRotas(), e.getX(), e.getY());
                }
                }catch(Exception e1){
                    
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getjMenuAtualizar()){
                setChanged();
                notifyObservers("atualizar");
            }
            if(e.getSource() == tela.getjMenuCadastrar()){
                cRota.setVisible(true);
            }
            if(e.getSource() == tela.getjMenuEditar()){
                Destino destino = fachada.buscarIdDestino((int)tela.getjTableRotas().getModel().getValueAt(tela.getjTableRotas().getSelectedRow(), 0));
                eRota.getNomeTxt().setText(destino.getNome().toLowerCase());
                eRota.getEstadoTxt().setText(destino.getPartida().getEstado().toLowerCase());
                eRota.getRuaTxt().setText(destino.getPartida().getRua().toLowerCase());
                eRota.getBairroTxt().setText(destino.getPartida().getBairro().toLowerCase());
                eRota.getCidadeTxt().setText(destino.getPartida().getCidade().toLowerCase());
                eRota.getComplementoTxt().setText(destino.getPartida().getComplemento().toLowerCase());
                
                eRota.getEstadoTxt2().setText(destino.getDestino().getEstado().toLowerCase());
                eRota.getRuaTxt2().setText(destino.getDestino().getRua().toLowerCase());
                eRota.getBairroTxt2().setText(destino.getDestino().getBairro().toLowerCase());
                eRota.getCidadeTxt2().setText(destino.getDestino().getCidade().toLowerCase());
                eRota.getComplementoTxt2().setText(destino.getDestino().getComplemento().toLowerCase());
                
                eRota.getPrecoTxt().setText(destino.getPreco().toLowerCase());
                eRota.getHorarioTxt().setText(destino.getHorario().toLowerCase());
                
                ccRota.setCodigo((int)tela.getjTableRotas().getModel().getValueAt(tela.getjTableRotas().getSelectedRow(), 0));
                
                eRota.setVisible(true);
            }
            if(e.getSource() == tela.getjMenuRemover()){
                if(Mensagens.mensagemConfirmacao("Deseja remover o registro?")){
                    if(fachada.removerId((int)tela.getjTableRotas().getModel().getValueAt(tela.getjTableRotas().getSelectedRow(), 0))){
                        Mensagens.mensagem("Registro removido com sucesso!");
                        tela.getjMenuAtualizar().doClick();
                    }else{
                        Mensagens.mensagem("Erro ao remover o registro!");
                    }
                }
            }
            if(e.getSource() == tela.getjMenuSair()){
                tela.setVisible(false);
            }
            if(e.getSource() == tela.getBtnBuscar()){
                if(tela.getjRadioNome().isSelected()){
                    rotasLike = fachada.buscaLikeDestino(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Destino.BUSCARLIKENOME);
                }else if(tela.getjRadioPreco().isSelected()){
                    rotasLike = fachada.buscaLikeDestino(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Destino.BUSCARLIKEPRECO);
                }
                setChanged();
                notifyObservers("like");
            }
        }

       
    }
    private class Teclado extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e) {
            if(tela.getBuscarTxt().hasFocus()){
                if(tela.getjRadioNome().isSelected()){
                    rotasLike = fachada.buscaLikeDestino(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Destino.BUSCARLIKENOME);
                }else if(tela.getjRadioPreco().isSelected()){
                    rotasLike = fachada.buscaLikeDestino(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Destino.BUSCARLIKEPRECO);
                }
                setChanged();
                notifyObservers("like");
            }
        }
    }

    public ConsultarRota getTela() {
        return tela;
    }

    public List<Destino> getRotasLike() {
        return rotasLike;
    }
    
}
