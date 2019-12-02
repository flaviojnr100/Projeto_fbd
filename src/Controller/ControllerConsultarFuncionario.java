/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.sun.java.swing.SwingUtilities3;
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
import javafx.beans.Observable;
import javax.swing.SwingUtilities;
import modelVO.BaseDados;
import modelVO.Funcionario;
import modelVO.Motorista;
import sql.SQLUtil;
import view.CadastroFuncionario;
import view.ConsultarFuncionario;
import view.InformacoesFuncionario;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerConsultarFuncionario extends java.util.Observable {
    private ConsultarFuncionario tela;
    private Fachada fachada;
    private InformacoesFuncionario iFuncionario;
    private ControllerEditarFuncionario eFuncionario;
    private CadastroFuncionario cFuncionario;
    private List<Funcionario> funcionarioLike;
    public ControllerConsultarFuncionario(ConsultarFuncionario tela,Fachada fachada,ControllerEditarFuncionario eFuncionario,CadastroFuncionario cFuncionario,InformacoesFuncionario iFuncionario) {
        this.tela = tela;
        this.fachada = fachada;
        this.eFuncionario = eFuncionario;
        this.cFuncionario = cFuncionario;
        this.iFuncionario=iFuncionario;
        Control();
    }
    private void Control(){
        tela.getjTableFuncionarios().addMouseListener(new CaixaPopup());
        tela.getjMenuAtualizar().addActionListener(new CaixaPopup());
        tela.getjMenuInformacoes().addActionListener(new CaixaPopup());
        tela.getjMenuCadastrar().addActionListener(new CaixaPopup());
        tela.getjMenuEditar().addActionListener(new CaixaPopup());
        tela.getjMenuStatus().addActionListener(new CaixaPopup());
        tela.getjMenuSair().addActionListener(new CaixaPopup());
        
        
        tela.getBtnBuscar().addActionListener(new Busca());
        tela.getBtnBuscar().addKeyListener(new Busca());
        tela.getBuscarTxt().addKeyListener(new Busca());
        tela.getjRadioNome().addKeyListener(new Busca());
        tela.getjRadioLogin().addKeyListener(new Busca());
        tela.getjRadioCpf().addKeyListener(new Busca());
        tela.getjRadioRg().addKeyListener(new Busca());
        
        iFuncionario.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iFuncionario.setVisible(false);
            }
        });
        iFuncionario.getBtnOk().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                iFuncionario.getBtnOk().doClick();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
    }
    
    private class Busca extends KeyAdapter implements ActionListener{

        @Override
        public void keyPressed(KeyEvent e) {
            if(tela.getBuscarTxt().hasFocus() || tela.getBtnBuscar().hasFocus() || tela.getjRadioNome().hasFocus() || tela.getjRadioLogin().hasFocus() || tela.getjRadioRg().hasFocus() || tela.getjRadioCpf().hasFocus()){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    tela.getBtnBuscar().doClick();
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(tela.getBtnBuscar() == e.getSource()){
                 if(tela.getjRadioNome().isSelected()){
                    funcionarioLike = fachada.buscarLike(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Funcionario.BUSCARLIKENOME);
                }else if(tela.getjRadioRg().isSelected()){
                    funcionarioLike = fachada.buscarLike(tela.getBuscarTxt().getText(), SQLUtil.Funcionario.BUSCARLIKERG);
                }else if(tela.getjRadioCpf().isSelected()){
                    funcionarioLike = fachada.buscarLike(tela.getBuscarTxt().getText(), SQLUtil.Funcionario.BUSCARLIKECPF);
                }else if(tela.getjRadioLogin().isSelected()){
                    funcionarioLike = fachada.buscarLike(tela.getBuscarTxt().getText(), SQLUtil.Funcionario.BUSCARLIKELOGIN);
                }
                setChanged();
                notifyObservers(tela.getBtnBuscar());
            }
        }
        
        
        
    }
    
    private class CaixaPopup extends MouseAdapter implements ActionListener{

        @Override
        public void mouseClicked(MouseEvent e) {
                       
            if(SwingUtilities.isRightMouseButton(e)){
                try{
                if(!tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 0).equals("")){
                    tela.getjMenuEditar().setVisible(true);
                    tela.getjMenuStatus().setVisible(true);
                    tela.getjMenuInformacoes().setVisible(true);
                    tela.getjPopupMenu1().show(tela.getjTableFuncionarios(), e.getX(), e.getY());
                }else{
                    tela.getjMenuEditar().setVisible(false);
                    tela.getjMenuStatus().setVisible(false);
                    tela.getjMenuInformacoes().setVisible(false);
                    tela.getjPopupMenu1().show(tela.getjTableFuncionarios(), e.getX(), e.getY());
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
                iFuncionario.getLblNome().setText((String)tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 1));
                iFuncionario.getLblSobrenome().setText((String)tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 2));
                iFuncionario.getLblRg().setText((String)tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 3));
                iFuncionario.getLblCpf().setText((String)tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 4));
                iFuncionario.getLblData().setText((String)tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 5));
                iFuncionario.getLblLogin().setText((String)tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 6));
                iFuncionario.setVisible(true);
            }
            if(e.getSource() == tela.getjMenuCadastrar()){
                cFuncionario.setVisible(true);
            }
            if(e.getSource() == tela.getjMenuEditar()){
                String cpf = (String) tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 4);
                Funcionario funcionario = fachada.buscarCpfFuncionario(cpf);
                eFuncionario.getTela().getNomeTxt().setText(funcionario.getNome().toLowerCase()+"");
                eFuncionario.getTela().getSobrenomeTxt().setText(funcionario.getSobrenome().toLowerCase()+"");
                eFuncionario.getTela().getRgTxt().setText(funcionario.getRg()+"");
                eFuncionario.getTela().getCpfTxt().setText(funcionario.getCpf()+"");
                eFuncionario.getTela().getDataTxt().setText(funcionario.getData_nascimento()+"");
                eFuncionario.getTela().getLoginTxt().setText(funcionario.getLogin()+"");
                eFuncionario.getTela().getSenhaTxt().setText(funcionario.getSenha()+"");
                eFuncionario.getTela().getConfirmarTxt().setText(funcionario.getSenha()+"");
                eFuncionario.setEditarFuncionario(funcionario);
                eFuncionario.setLinha(tela.getjTableFuncionarios().getSelectedRow());
                eFuncionario.getTela().setVisible(true);
            }
            if(e.getSource() == tela.getjMenuStatus()){
                if(Mensagens.mensagemConfirmacao("Deseja mudar o status desse registro?")){
                    String st="ATIVO";    
                    if(tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 7).equals("ATIVO")){
                        st="DESATIVADO";
                    }else{
                        st="ATIVO";
                    }
                    fachada.alterarStatusFuncionario((String)tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 4), st);
                    BaseDados.CarregarFuncionario();
                    setChanged();
                    notifyObservers(tela.getjMenuStatus());
                    }
                }
            
            if(e.getSource() == tela.getjMenuSair()){
                tela.setVisible(false);
            }
        }

       
    }
    
    public void colocar(){
       
        
         for(int i=0;i<BaseDados.getFuncionarios().size();i++){
            tela.getjTableFuncionarios().getModel().setValueAt(BaseDados.getFuncionarios().get(i).getId(), i, 0);
            tela.getjTableFuncionarios().getModel().setValueAt(BaseDados.getFuncionarios().get(i).getNome(), i, 1);
            tela.getjTableFuncionarios().getModel().setValueAt(BaseDados.getFuncionarios().get(i).getSobrenome(), i, 2);
            tela.getjTableFuncionarios().getModel().setValueAt(BaseDados.getFuncionarios().get(i).getRg(), i, 3);
            tela.getjTableFuncionarios().getModel().setValueAt(BaseDados.getFuncionarios().get(i).getCpf(), i, 4);
            tela.getjTableFuncionarios().getModel().setValueAt(BaseDados.getFuncionarios().get(i).getData_nascimento(), i, 5);
            tela.getjTableFuncionarios().getModel().setValueAt(BaseDados.getFuncionarios().get(i).getLogin(), i, 6);
            tela.getjTableFuncionarios().getModel().setValueAt(BaseDados.getFuncionarios().get(i).getStatus(), i, 7);
        }
    }
     public void colocar(List<Funcionario> funcionarios){
        
        
         for(int i=0;i<funcionarios.size();i++){
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getId(), i, 0);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getNome(), i, 1);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getSobrenome(), i, 2);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getRg(), i, 3);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getCpf(), i, 4);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getData_nascimento(), i, 5);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getLogin(), i, 6);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getStatus(), i, 7);
        }
    }
    public boolean Limpar(){
        
        for(int i=0;i<24;i++){
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 0);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 1);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 2);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 3);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 4);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 5);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 6);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 7);
        }
        if(BaseDados.getFuncionarios().size()>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean LimparSimples(){
        
        for(int i=0;i<BaseDados.getFuncionarios().size()+1;i++){
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 0);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 1);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 2);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 3);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 4);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 5);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 6);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 7);
        }
        if(BaseDados.getFuncionarios().size()>0){
            return true;
        }else{
            return false;
        }
    }

    public ConsultarFuncionario getTela() {
        return tela;
    }

    public List<Funcionario> getFuncionarioLike() {
        return funcionarioLike;
    }
    
}
