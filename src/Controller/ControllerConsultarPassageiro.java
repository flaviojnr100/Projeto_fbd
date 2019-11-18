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
import modelVO.Passageiro;
import sql.SQLUtil;
import view.CadastroPassageiro;
import view.ConsultarPassageiro;
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
    public ControllerConsultarPassageiro(ConsultarPassageiro tela, Fachada fachada,ControllerEditarPassageiro ePassageiro,CadastroPassageiro cPassageiro) {
        this.tela = tela;
        this.fachada = fachada;
        this.ePassageiro = ePassageiro;
        this.cPassageiro = cPassageiro;
        Control();
    }
    
    private void Control(){
        tela.getjTablePassageiro().addMouseListener(new CaixaMenu());
        tela.getjMenuAtualizar().addActionListener(new CaixaMenu());
        tela.getjMenuCadastrar().addActionListener(new CaixaMenu());
        tela.getjMenuEditar().addActionListener(new CaixaMenu());
        tela.getjMenuRemover().addActionListener(new CaixaMenu());
        tela.getjMenuSair().addActionListener(new CaixaMenu());
        tela.getBuscarTxt().addKeyListener(new BuscaLike());
    }
    
    private class CaixaMenu extends MouseAdapter implements ActionListener{
       @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                try{
                    if(!tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 0).equals("")){
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
            if(e.getSource() == tela.getjMenuRemover()){
                if(Mensagens.mensagemConfirmacao("Deseja remover esse registro?")){
                    if(fachada.removerPassageiro((String) tela.getjTablePassageiro().getModel().getValueAt(tela.getjTablePassageiro().getSelectedRow(), 3))){
                        Mensagens.mensagem("Removido com sucesso!");
                        setChanged();
                        notifyObservers(tela.getjMenuRemover());
                    }else{
                        Mensagens.mensagem("Erro ao tentar remover um registro!");
                    }
                }
            }
            if(e.getSource() == tela.getjMenuSair()){
                tela.setVisible(false);
            }
        }
    }
    private class BuscaLike extends KeyAdapter{
    
        @Override
        public void keyReleased(KeyEvent e) {
            if(tela.getBuscarTxt().hasFocus()){
                if(tela.getjRadioNome().isSelected()){
                    passageiroLike = fachada.buscarLikePassageiro(tela.getBuscarTxt().getText(), SQLUtil.Passageiro.BUSCARLIKENOME);
                }else if(tela.getjRadioCpf().isSelected()){
                    passageiroLike = fachada.buscarLikePassageiro(tela.getBuscarTxt().getText(), SQLUtil.Passageiro.BUSCARLIKECPF);
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
        }
        }else{
            Mensagens.mensagem("Não há passageiros cadastrados no sistema!");
        }
    }
    public void colocarDados(){
        List<Passageiro> passageiros = fachada.getAllPassageiro();
        if(passageiros.size()>0){
        for(int i=0;i<passageiros.size();i++){
            tela.getjTablePassageiro().getModel().setValueAt(passageiros.get(i).getId(), i, 0);
            tela.getjTablePassageiro().getModel().setValueAt(passageiros.get(i).getNome(), i, 1);
            tela.getjTablePassageiro().getModel().setValueAt(passageiros.get(i).getSobrenome(), i, 2);
            tela.getjTablePassageiro().getModel().setValueAt(passageiros.get(i).getCpf(), i, 3);
        }
        }else{
            Mensagens.mensagem("Não há passageiros cadastrados no sistema!");
        }
    }
    
    public boolean limpar(){
        List<Passageiro> passageiros = fachada.getAllPassageiro();
        for(int i=0;i<passageiros.size()+1;i++){
            for(int j=0;j<4;j++){
                tela.getjTablePassageiro().getModel().setValueAt("", i, j);
            }
        }
        if(passageiros.size()>0){
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
