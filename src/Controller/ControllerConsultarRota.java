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
import modelVO.Destino;
import sql.SQLUtil;
import view.CadastroRota;
import view.ConsultarRota;
import view.EditarRota;
import view.InformacaoRota;
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
    private InformacaoRota iRota;
    public ControllerConsultarRota(ConsultarRota tela, Fachada fachada,EditarRota eRota,ControllerEditarRota ccRota,CadastroRota cRota,InformacaoRota iRota) {
        this.tela = tela;
        this.fachada = fachada;
        this.eRota = eRota;
        this.ccRota = ccRota;
        this.cRota = cRota;
        this.iRota = iRota;
        Control();
    }
    private void Control(){
        tela.getjTableRotas().addMouseListener(new Caixa());
        
        tela.getjMenuAtualizar().addActionListener(new Caixa());
        tela.getjMenuInformacoes().addActionListener(new Caixa());
        tela.getjMenuCadastrar().addActionListener(new Caixa());
        tela.getjMenuEditar().addActionListener(new Caixa());
        tela.getjMenuRemover().addActionListener(new Caixa());
        tela.getjMenuSair().addActionListener(new Caixa());
        
        tela.getBtnBuscar().addActionListener(new Caixa());
        
        tela.getBuscarTxt().addKeyListener(new Teclado());
        tela.getjRadioNome().addKeyListener(new Teclado());
        tela.getjRadioPreco().addKeyListener(new Teclado());
        tela.getBtnBuscar().addKeyListener(new Teclado());
        
        iRota.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               iRota.setVisible(false);
                 
            }
        });
        iRota.getBtnOK().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                iRota.getBtnOK().doClick();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }
    
    public void colocarDados(){
        
        
        for(int i=0;i<BaseDados.getRotas().size();i++){
            tela.getjTableRotas().getModel().setValueAt(BaseDados.getRotas().get(i).getId(), i, 0);
            tela.getjTableRotas().getModel().setValueAt(BaseDados.getRotas().get(i).getNome(), i, 1);
            tela.getjTableRotas().getModel().setValueAt(BaseDados.getRotas().get(i).getPreco(), i, 2);
            
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
        
        
        for(int i=0;i<tela.getjTableRotas().getRowCount();i++){
            for(int j=0;j<3;j++){
                tela.getjTableRotas().getModel().setValueAt("", i, j);
            }
        }
        if(BaseDados.getRotas().size()>=0){
            return true;
        }else{
            return false;
        }
    }
    public boolean LimparDadosSimples(){
        
        
        for(int i=0;i<BaseDados.getRotas().size()+1;i++){
            for(int j=0;j<3;j++){
                tela.getjTableRotas().getModel().setValueAt("", i, j);
            }
        }
        if(BaseDados.getRotas().size()>=0){
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
                    tela.getjMenuEditar().setVisible(true);
                    tela.getjMenuRemover().setVisible(true);
                    tela.getjMenuInformacoes().setVisible(true);
                    tela.getjPopupMenu1().show(tela.getjTableRotas(), e.getX(), e.getY());
                }else{
                    tela.getjMenuEditar().setVisible(false);
                    tela.getjMenuRemover().setVisible(false);
                    tela.getjMenuInformacoes().setVisible(false);
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
            if(e.getSource() == tela.getjMenuInformacoes()){
                Destino destino = fachada.buscarIdDestino((int)tela.getjTableRotas().getModel().getValueAt(tela.getjTableRotas().getSelectedRow(), 0));
                iRota.getLblNome().setText(destino.getNome());
                iRota.getLblHorario().setText(destino.getHorario());
                iRota.getLblPreco().setText(destino.getPreco());
                iRota.getLblEstado1().setText(destino.getPartida().getEstado());
                iRota.getLblEstado2().setText(destino.getDestino().getEstado());
                iRota.getLblRua1().setText(destino.getPartida().getRua());
                iRota.getLblRua2().setText(destino.getDestino().getRua());
                iRota.getLblBairro1().setText(destino.getPartida().getBairro());
                iRota.getLblBairro2().setText(destino.getDestino().getBairro());
                iRota.getLblCidade1().setText(destino.getPartida().getCidade());
                iRota.getLblCidade2().setText(destino.getDestino().getCidade());
                iRota.getLblComplemento1().setText(destino.getPartida().getComplemento());
                iRota.getLblComplemento2().setText(destino.getDestino().getComplemento());
                iRota.setVisible(true);
                
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
                        BaseDados.CarregarRota();
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
        public void keyPressed(KeyEvent e) {
            if(tela.getBuscarTxt().hasFocus() || tela.getjRadioNome().hasFocus() || tela.getjRadioPreco().hasFocus() || tela.getBtnBuscar().hasFocus()){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    tela.getBtnBuscar().doClick();
                }
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
