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
import java.util.ArrayList;

import java.util.List;
import java.util.Observable;
import javax.swing.SwingUtilities;
import modelVO.BaseDados;
import modelVO.Passageiro;
import sql.SQLUtil;
import view.CadastroPassageiro;
import view.ConsultarPassageiro;
import view.InformacoesPassageiro;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerConsultarPassageiro extends Observable {
    private ConsultarPassageiro tela;
    private Fachada fachada;
    private ControllerEditarPassageiro ePassageiro;
    private List<Passageiro> passageiroLike;
    private CadastroPassageiro cPassageiro;
    private InformacoesPassageiro iPassageiro;
    public ControllerConsultarPassageiro(ConsultarPassageiro tela, Fachada fachada,ControllerEditarPassageiro ePassageiro,CadastroPassageiro cPassageiro,InformacoesPassageiro iPassageiro) {
        this.tela = tela;
        this.fachada = fachada;
        this.ePassageiro = ePassageiro;
        this.cPassageiro = cPassageiro;
        this.iPassageiro = iPassageiro;
        Control();
    }
    
    private void Control(){
        tela.getjTablePassageiro().addMouseListener(new CaixaMenu());
        tela.getjMenuAtualizar().addActionListener(new CaixaMenu());
        tela.getjMenuInformacoes().addActionListener(new CaixaMenu());
        tela.getjMenuCadastrar().addActionListener(new CaixaMenu());
        tela.getjMenuEditar().addActionListener(new CaixaMenu());
        tela.getjMenuMstatus().addActionListener(new CaixaMenu());
        tela.getjMenuSair().addActionListener(new CaixaMenu());
        tela.getBuscarTxt().addKeyListener(new BuscaLike());
        tela.getBtnBuscar().addActionListener(new BuscaLike());
        
        tela.getjRadioCodBilhete().addKeyListener(new BuscaLike());
        tela.getjRadioCpf().addKeyListener(new BuscaLike());
        tela.getjRadioNome().addKeyListener(new BuscaLike());
        tela.getBtnBuscar().addKeyListener(new BuscaLike());
        
        
        iPassageiro.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            iPassageiro.setVisible(false);
            }
        });
        iPassageiro.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                iPassageiro.getBtnOK().doClick();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }
    
    private class CaixaMenu extends MouseAdapter implements ActionListener{
       @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                try{
                    if(!tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 0).equals("")){
                        tela.getjMenuEditar().setVisible(true);
                        tela.getjMenuMstatus().setVisible(true);
                        tela.getjMenuInformacoes().setVisible(true);
                        tela.getjPopupMenu1().show(tela.getjTablePassageiro(), e.getX(), e.getY());
                    }else if(tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 0).equals("")){
                        tela.getjMenuEditar().setVisible(false);
                        tela.getjMenuMstatus().setVisible(false);
                        tela.getjMenuInformacoes().setVisible(false);
                        tela.getjPopupMenu1().show(tela.getjTablePassageiro(), e.getX(), e.getY());
                    }
                    }catch(Exception e1){
                    
                    }

               
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getjMenuAtualizar()){
                setChanged();
                notifyObservers(tela.getjMenuAtualizar());
            }
            if(e.getSource() == tela.getjMenuInformacoes()){
                iPassageiro.getLblNome().setText((String)tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 1));
                iPassageiro.getLblSobrenome().setText((String)tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 2));
                iPassageiro.getLblCpf().setText((String)tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 3));
                iPassageiro.setVisible(true);
            }
            if(e.getSource() == tela.getjMenuCadastrar()){
                cPassageiro.setVisible(true);
            }
            if(e.getSource() == tela.getjMenuEditar()){
                
                ePassageiro.setEditarPassageiro(fachada.buscarCpfPassageiro((String) tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 3)));
                ePassageiro.getTela().getNomeTxt().setText(ePassageiro.getEditarPassageiro().getNome().toLowerCase());
                ePassageiro.getTela().getSobrenomeTxt().setText(ePassageiro.getEditarPassageiro().getSobrenome().toLowerCase());
                ePassageiro.getTela().getCpfTxt().setText(ePassageiro.getEditarPassageiro().getCpf());
                ePassageiro.setLinha(tela.getjTablePassageiro().getSelectedRow());
                ePassageiro.getTela().setVisible(true);
            }
            if(e.getSource() == tela.getjMenuMstatus()){
                /*if(Mensagens.mensagemConfirmacao("Deseja remover esse registro?")){
                    if(fachada.removerPassageiro((String) tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 3))){
                        Mensagens.mensagem("Removido com sucesso!");
                        BaseDados.CarregarPassageiro();
                        setChanged();
                        notifyObservers(tela.getjMenuMstatus());
                    }else{
                        Mensagens.mensagem("Erro ao tentar remover um registro!");
                    }
                }*/
                if(tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 4).equals("ATIVO")){
                    fachada.mudarStatus((int)tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 0), SQLUtil.Passageiro.DESATIVAR_PASSAGEIRO);
                }else if(tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 4).equals("DESATIVADO")){
                    fachada.mudarStatus((int)tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 0), SQLUtil.Passageiro.ATIVAR_PASSAGEIRO);
                }
                Mensagens.mensagem("Alterado com sucesso com sucesso!");
                        BaseDados.CarregarPassageiro();
                        setChanged();
                        notifyObservers(tela.getjMenuMstatus());
                
            }
            if(e.getSource() == tela.getjMenuSair()){
                tela.setVisible(false);
            }
        }
    }
    private class BuscaLike extends KeyAdapter implements ActionListener{
    
        @Override
        public void keyPressed(KeyEvent e) {
            if(tela.getBuscarTxt().hasFocus() || tela.getBtnBuscar().hasFocus() || tela.getjRadioCodBilhete().hasFocus() || tela.getjRadioCpf().hasFocus() || tela.getjRadioNome().hasFocus()){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    tela.getBtnBuscar().doClick();
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           if(e.getSource() == tela.getBtnBuscar()){
               if(tela.getjRadioNome().isSelected()){
                    passageiroLike = fachada.buscarLikePassageiro(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Passageiro.BUSCARLIKENOME);
                }else if(tela.getjRadioCpf().isSelected()){
                    passageiroLike = fachada.buscarLikePassageiro(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Passageiro.BUSCARLIKECPF);
                }else if(tela.getjRadioCodBilhete().isSelected()){
                    passageiroLike = fachada.buscarLikeBilhete(Integer.parseInt(tela.getBuscarTxt().getText()), SQLUtil.Passageiro.BUSCARLIKEBILHETE);
                }
                setChanged();
                notifyObservers(tela.getBtnBuscar());
           }
        }
    }
    
     public void colocarDados(List<Passageiro> passageiros){
        
        if(passageiros.size()>0){
        for(int i=0;i<passageiros.size();i++){
            tela.getjTablePassageiro().getModel().setValueAt(passageiros.get(i).getId(), i, 0);
            tela.getjTablePassageiro().getModel().setValueAt(passageiros.get(i).getNome(), i, 1);
            tela.getjTablePassageiro().getModel().setValueAt(passageiros.get(i).getSobrenome(), i, 2);
            tela.getjTablePassageiro().getModel().setValueAt(passageiros.get(i).getCpf(), i, 3);
            tela.getjTablePassageiro().getModel().setValueAt(passageiros.get(i).getStatus(), i, 4);
            
        }
        }else{
            
        }
    }
    public void colocarDados(){
        
        if(BaseDados.getPassageiros().size()>0){
        for(int i=0;i<BaseDados.getPassageiros().size();i++){
            tela.getjTablePassageiro().getModel().setValueAt(BaseDados.getPassageiros().get(i).getId(), i, 0);
            tela.getjTablePassageiro().getModel().setValueAt(BaseDados.getPassageiros().get(i).getNome(), i, 1);
            tela.getjTablePassageiro().getModel().setValueAt(BaseDados.getPassageiros().get(i).getSobrenome(), i, 2);
            tela.getjTablePassageiro().getModel().setValueAt(BaseDados.getPassageiros().get(i).getCpf(), i, 3);
            tela.getjTablePassageiro().getModel().setValueAt(BaseDados.getPassageiros().get(i).getStatus(), i, 4);
        }
        }else{
            Mensagens.mensagem("Não há passageiros cadastrados no sistema!");
        }
    }
    
    public boolean limpar(){
        
        for(int i=0;i<tela.getjTablePassageiro().getRowCount();i++){
            for(int j=0;j<5;j++){
                tela.getjTablePassageiro().getModel().setValueAt("", i, j);
            }
        }
        if(BaseDados.getPassageiros().size()>0){
            return true;
        }else{
            return false;
        }
        
        
    }
    public boolean limparSimples(){
        
        for(int i=0;i<BaseDados.getPassageiros().size()+1;i++){
            for(int j=0;j<5;j++){
                tela.getjTablePassageiro().getModel().setValueAt("", i, j);
            }
        }
        if(BaseDados.getPassageiros().size()>0){
            return true;
        }else{
            return false;
        }
        
        
    }

    public ConsultarPassageiro getTela() {
        return tela;
    }

    public List<Passageiro> getPassageiroLike() {
        return passageiroLike;
    }
    
}
