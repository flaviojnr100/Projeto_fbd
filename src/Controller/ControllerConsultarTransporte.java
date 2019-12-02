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
import modelVO.Transporte;
import sql.SQLUtil;
import view.ConsultarTransporte;
import view.EditarTransporte;
import view.InformacoesVeiculo;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerConsultarTransporte extends Observable {
    private ConsultarTransporte tela;
    private Fachada fachada;
    private List<Transporte> transporteLike;
    private InformacoesVeiculo iVeiculo;
    private ControllerEditarTransporte ceTransporte;
    private ControllerCadastroTransporte ccTransporte;
    public ControllerConsultarTransporte(ConsultarTransporte tela, Fachada fachada,InformacoesVeiculo iVeiculo,ControllerEditarTransporte ceTransporte,ControllerCadastroTransporte ccTransporte) {
        this.tela = tela;
        this.fachada = fachada;
        this.iVeiculo = iVeiculo;
        this.ceTransporte = ceTransporte;
        this.ccTransporte = ccTransporte;
        transporteLike = BaseDados.getTransportes();
        Control();
    }
    private void Control(){
       // tela.getjTableTransporte().addMouseListener(new CaixaMenu());
        tela.getMenuAtualizar().addActionListener(new CaixaMenu());
        tela.getjMenuInformacoes().addActionListener(new CaixaMenu());
        tela.getMenuCadastrar().addActionListener(new CaixaMenu());
        tela.getMenuStatus().addActionListener(new CaixaMenu());
        tela.getMenuEditar().addActionListener(new CaixaMenu());
        tela.getMenuSair().addActionListener(new CaixaMenu());
        
        tela.getBuscarTxt().addKeyListener(new Teclado());
        tela.getjRadioChassi().addKeyListener(new Teclado());
        tela.getjRadioMotorista().addKeyListener(new Teclado());
        tela.getjRadioPlaca().addKeyListener(new Teclado());
        tela.getBtnBuscar().addKeyListener(new Teclado());
        tela.getBtnBuscar().addActionListener(new Teclado());
        
        iVeiculo.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            iVeiculo.setVisible(false);
            }
        });
    }
    public void ColocarDados(){
        
        int i=0;
        for(Transporte t:BaseDados.getTransportes()){
            tela.getjTableTransporte().getModel().setValueAt(t.getId(), i, 0);
            tela.getjTableTransporte().getModel().setValueAt(t.getCor(), i, 1);
            tela.getjTableTransporte().getModel().setValueAt(t.getPlaca(), i, 2);
            tela.getjTableTransporte().getModel().setValueAt(t.getChassi(), i, 3);
            tela.getjTableTransporte().getModel().setValueAt(t.getMotorista().getNome(), i, 4);
            tela.getjTableTransporte().getModel().setValueAt(t.getTipo().getNome(), i, 5);
            tela.getjTableTransporte().getModel().setValueAt(t.getDestino().getNome(), i, 6);
            tela.getjTableTransporte().getModel().setValueAt(t.getStatus(), i, 7);
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
            tela.getjTableTransporte().getModel().setValueAt(t.getDestino().getNome(), i, 6);
            tela.getjTableTransporte().getModel().setValueAt(t.getStatus(), i, 7);
            i++;
        }
    }
    public boolean limpar(){
        
        for(int i=0;i<tela.getjTableTransporte().getRowCount();i++){
            for(int j=0;j<8;j++){
                tela.getjTableTransporte().getModel().setValueAt("", i, j);
            }
        }
        if(BaseDados.getTransportes().size()>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean limparSimples(){
        
        for(int i=0;i<BaseDados.getTransportes().size()+1;i++){
            for(int j=0;j<8;j++){
                tela.getjTableTransporte().getModel().setValueAt("", i, j);
            }
        }
        if(BaseDados.getTransportes().size()>0){
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
                if(!tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 1).equals("")){
                    tela.getMenuEditar().setVisible(true);
                    tela.getMenuStatus().setVisible(true);
                    tela.getjMenuInformacoes().setVisible(true);
                    
                }else{
                    tela.getMenuEditar().setVisible(false);
                    tela.getMenuStatus().setVisible(false);
                    tela.getjMenuInformacoes().setVisible(false);
                }
                tela.getjPopupMenu1().show(tela.getjTableTransporte(), e.getX(), e.getY());
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
            if(e.getSource() == tela.getjMenuInformacoes()){
                iVeiculo.getLblCor().setText((String)tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 1));
                iVeiculo.getLblPlaca().setText((String)tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 2));
                iVeiculo.getLblChassi().setText((String)tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 3));
                iVeiculo.getLblMotorista().setText((String)tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 4));
                iVeiculo.getLblTipo().setText((String)tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 5));
                iVeiculo.getLblRota().setText((String)tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 6));
                iVeiculo.setVisible(true);
            }
            if(e.getSource() == tela.getMenuCadastrar()){
                ccTransporte.desabilitarEvento();
                ccTransporte.montarComboMotorista();
                ccTransporte.montarComboTipo();
                ccTransporte.montarComboRota();
                ccTransporte.getTela().getComboMotorista().setSelectedIndex(0);
                ccTransporte.getTela().getComboRota().setSelectedIndex(0);
                ccTransporte.getTela().getComboTipo().setSelectedIndex(0);
                ccTransporte.mudarLista();
                ccTransporte.habilitarEvento();
                
                ccTransporte.getTela().setVisible(true);
            }
            if(e.getSource() == tela.getMenuStatus()){
                if(Mensagens.mensagemConfirmacao("Deseja mudar o status desse registro?")){
                    Transporte transporte = BaseDados.getTransportes().get(tela.getjTableTransporte().getSelectedRow());
                    String st="ATIVO";
                    if(tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 7).equals("ATIVO")){
                        st="DESATIVADO";
                        fachada.alterarStatusTransporte(transporte.getId(),st);
                    }else{
                        st="ATIVO";
                        fachada.alterarStatusTransporte(transporte.getId(),st);
                    }
                    BaseDados.CarregarTransporte();
                    
                    
                    setChanged();
                    notifyObservers("atualizar");
                }
            }
            if(e.getSource() == tela.getMenuEditar()){
                Transporte transporte = fachada.buscarIdTransporte((int)tela.getjTableTransporte().getModel().getValueAt(tela.getjTableTransporte().getSelectedRow(), 0));
                
                ceTransporte.getTela().getLblNome().setText(transporte.getTipo().getNome());
                ceTransporte.getTela().getLblAssentos().setText(transporte.getTipo().getAssentos()+"");
                ceTransporte.getTela().getChassiText().setText(transporte.getChassi());
                ceTransporte.getTela().getCorText().setText(transporte.getCor());
                ceTransporte.getTela().getPlacaText().setText(transporte.getPlaca());
                ceTransporte.getTela().getLblNomeMotorista().setText(transporte.getMotorista().getNome());
                ceTransporte.getTela().getLblSobrenomeMotorista().setText(transporte.getMotorista().getSobrenome());
               
               ceTransporte.setId(BaseDados.getTransportes().get(tela.getjTableTransporte().getSelectedRow()).getId());
               ceTransporte.getTela().setVisible(true);
            }
            if(e.getSource() == tela.getMenuSair()){
                tela.setVisible(false);
            }
        }
    }
    
    private class Teclado extends KeyAdapter implements ActionListener{

        @Override
        public void keyPressed(KeyEvent e) {
            if(tela.getBuscarTxt().hasFocus() || tela.getjRadioChassi().hasFocus() || tela.getjRadioMotorista().hasFocus() || tela.getjRadioPlaca().hasFocus() || tela.getBtnBuscar().hasFocus()){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    tela.getBtnBuscar().doClick();
                }
                
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnBuscar()){
                if(tela.getjRadioChassi().isSelected()){
                    transporteLike = fachada.buscarLikeTransporte(tela.getBuscarTxt().getText(), SQLUtil.Transporte.BUSCARLIKECHASSI);
                }
                if(tela.getjRadioPlaca().isSelected()){
                    transporteLike = fachada.buscarLikeTransporte(tela.getBuscarTxt().getText(), SQLUtil.Transporte.BUSCARLIKEPLACA);
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
