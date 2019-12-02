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
import java.util.Observable;
import javax.swing.SwingUtilities;
import modelVO.BaseDados;
import modelVO.Financa;
import modelVO.Viagem;
import sql.SQLUtil;
import view.CadastroViagem;
import view.ConsultarViagem;
import view.InformacoesViagem;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerConsultarViagem extends Observable{
    private ConsultarViagem tela;
    private Fachada fachada;
    private InformacoesViagem iViagem;
    private List<Viagem> viagensLike;
    private Viagem mudarStatus;
    private int linha=0;
    private ControllerCadastroViagem ccViagem;
    public ControllerConsultarViagem(ConsultarViagem tela, Fachada fachada,InformacoesViagem iViagem,ControllerCadastroViagem ccViagem) {
        this.tela = tela;
        this.fachada = fachada;
        this.iViagem = iViagem;
        this.ccViagem = ccViagem;
        Control();
    }
    private void Control(){
        tela.getjTableViagens().addMouseListener(new Caixa());
        tela.getjMenuAtualizar().addActionListener(new Caixa());
        tela.getjMenuCadastrar().addActionListener(new Caixa());
        tela.getjMenuInformacoes().addActionListener(new Caixa());
        tela.getjMenuCancelar().addActionListener(new Caixa());
        tela.getjMenuSair().addActionListener(new Caixa());
        tela.getBtnBuscar().addActionListener(new Busca());
        tela.getBtnBuscar().addKeyListener(new Busca());
        tela.getBuscarTxt().addKeyListener(new Busca());
        tela.getjRadioData().addKeyListener(new Busca());
        tela.getjRadioHorario().addKeyListener(new Busca());
        tela.getjRadioPassageiro().addKeyListener(new Busca());
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
            tela.getjTableViagens().getModel().setValueAt(BaseDados.getViagens().get(i).getStatus(), i, 6);
            
        }
    }
    public void colocarDados(List<Viagem> viagens){
        
        for(int i=0;i<viagens.size();i++){
            tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getId(), i, 0);
            tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getPassageiro().getNome(), i, 1);
            tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getTransporte().getTipo().getNome(), i, 2);
            tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getDestino().getNome(), i, 3);
            tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getDestino().getHorario(), i, 4);
            tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getPreco(), i, 5);
            tela.getjTableViagens().getModel().setValueAt(viagens.get(i).getStatus(), i, 6);
            
        }
    }
    
    private class Caixa extends MouseAdapter implements ActionListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                try{
                if(!tela.getjTableViagens().getModel().getValueAt(tela.getjTableViagens().getSelectedRow(), 0).equals("")){
                    tela.getjMenuCancelar().setVisible(true);
                    tela.getjMenuInformacoes().setVisible(true);
                    tela.getjPopupMenu1().show(tela.getjTableViagens(), e.getX(), e.getY());
                }else{
                    tela.getjMenuCancelar().setVisible(false);
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
                setChanged();
                notifyObservers("atualizar");
            }
            if(e.getSource() == tela.getjMenuCadastrar()){
                ccViagem.desabilitarEvento();
                ccViagem.montarComboPassageiro();
                ccViagem.montarComboRota();
                ccViagem.montarComboTransporte();
                ccViagem.getTela().getComboPassageiro().setSelectedIndex(0);
                ccViagem.getTela().getLblNome().setText(ccViagem.getFachada().getAllPassageiro().get(0).getNome());
                ccViagem.getTela().getLblSobrenome().setText(ccViagem.getFachada().getAllPassageiro().get(0).getSobrenome());
                ccViagem.getTela().getLblCpf().setText(ccViagem.getFachada().getAllPassageiro().get(0).getCpf());
                ccViagem.setComboMarcado(0);
                ccViagem.montarAssentos();
                ccViagem.habilitarEvento();
                ccViagem.getTela().setVisible(true);
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
            if(e.getSource() == tela.getjMenuCancelar()){
                Viagem viagem = fachada.buscarIdViagem((int)tela.getjTableViagens().getModel().getValueAt(tela.getjTableViagens().getSelectedRow(), 0));
                if(viagem.getStatus().equals("ATIVO")){
                    viagem.setStatus("CANCELADO");
                    fachada.alterar_financa(fachada.buscar_data(viagem.getData_viagem()), Double.parseDouble(viagem.getPreco()), "CANCELADO");
                }else{
                    viagem.setStatus("ATIVO");
                    fachada.alterar_financa(fachada.buscar_data(viagem.getData_viagem()), Double.parseDouble(viagem.getPreco()), "ATIVO");
                }
                if(!fachada.alterarStatus(viagem)){
                    Mensagens.mensagem("Erro ao mudar status");
                }else{
                    mudarStatus = viagem;
                    linha = tela.getjTableViagens().getSelectedRow();
                    BaseDados.CarregarViagem();
                    BaseDados.CarregarFinanca();
                    setChanged();
                    notifyObservers("status");
                }
            }
            if(e.getSource() == tela.getjMenuSair()){
                tela.setVisible(false);
            }
        }

       

       
        
    }
    private class Busca implements ActionListener,KeyListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(tela.getjRadioPassageiro().isSelected()){
                viagensLike = fachada.buscarLikeViagem(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Viagem.BUSCARLIKENOME);
            }else if(tela.getjRadioData().isSelected()){
                viagensLike = fachada.buscarLikeViagem(tela.getBuscarTxt().getText(), SQLUtil.Viagem.BUSCARLIKEDATA);
            }else if(tela.getjRadioHorario().isSelected()){
                viagensLike = fachada.buscarLikeViagem(tela.getBuscarTxt().getText(), SQLUtil.Viagem.BUSCARLIKEHORARIO);
            }
            setChanged();
            notifyObservers("like");
            
            
        }
         @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                if(tela.getBuscarTxt().hasFocus() || tela.getBtnBuscar().hasFocus() || tela.getjRadioData().hasFocus() || tela.getjRadioHorario().hasFocus() || tela.getjRadioPassageiro().hasFocus()){
                    tela.getBtnBuscar().doClick();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    
    }

    public List<Viagem> getViagensLike() {
        return viagensLike;
    }

    public Viagem getMudarStatus() {
        return mudarStatus;
    }

    public int getLinha() {
        return linha;
    }

    public ConsultarViagem getTela() {
        return tela;
    }
    
}
