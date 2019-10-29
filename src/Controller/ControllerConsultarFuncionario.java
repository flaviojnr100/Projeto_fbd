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
import modelVO.Funcionario;
import modelVO.Motorista;
import sql.SQLUtil;
import view.CadastroFuncionario;
import view.ConsultarFuncionario;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerConsultarFuncionario extends java.util.Observable {
    private ConsultarFuncionario tela;
    private Fachada fachada;
    private ControllerEditarFuncionario eFuncionario;
    private CadastroFuncionario cFuncionario;
    private List<Funcionario> funcionarioLike;
    public ControllerConsultarFuncionario(ConsultarFuncionario tela,Fachada fachada,ControllerEditarFuncionario eFuncionario,CadastroFuncionario cFuncionario) {
        this.tela = tela;
        this.fachada = fachada;
        this.eFuncionario = eFuncionario;
        this.cFuncionario = cFuncionario;
        Control();
    }
    private void Control(){
        tela.getjTableFuncionarios().addMouseListener(new CaixaPopup());
        tela.getjMenuAtualizar().addActionListener(new CaixaPopup());
        tela.getjMenuCadastrar().addActionListener(new CaixaPopup());
        tela.getjMenuEditar().addActionListener(new CaixaPopup());
        tela.getjMenuRemover().addActionListener(new CaixaPopup());
        tela.getjMenuSair().addActionListener(new CaixaPopup());
        tela.getBuscarTxt().addKeyListener(new Busca());
    }
    
    private class Busca extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e) {
            if(tela.getBuscarTxt().hasFocus()){
                if(tela.getjRadioNome().isSelected()){
                    funcionarioLike = fachada.buscarLike(tela.getBuscarTxt().getText(), SQLUtil.Funcionario.BUSCARLIKENOME);
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
            if(e.getSource() == tela.getjMenuCadastrar()){
                cFuncionario.setVisible(true);
            }
            if(e.getSource() == tela.getjMenuEditar()){
                String cpf = (String) tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 4);
                Funcionario funcionario = fachada.buscarCpfFuncionario(cpf);
                eFuncionario.getTela().getNomeTxt().setText(funcionario.getNome()+"");
                eFuncionario.getTela().getSobrenomeTxt().setText(funcionario.getSobrenome()+"");
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
            if(e.getSource() == tela.getjMenuRemover()){
                if(Mensagens.mensagemConfirmacao("Deseja remover esse registro?")){
                    String cpf = (String) tela.getjTableFuncionarios().getModel().getValueAt(tela.getjTableFuncionarios().getSelectedRow(), 4);
                    if(fachada.removerFuncionario(cpf)){
                        Mensagens.mensagem("Removido com sucesso");
                        setChanged();
                        notifyObservers(tela.getjMenuRemover());
                    }else{
                    Mensagens.mensagem("Falha ao remover o registro!");
                    }
                }
            }
            if(e.getSource() == tela.getjMenuSair()){
                tela.setVisible(false);
            }
        }

       
    }
    
    public void colocar(){
        List<Funcionario> funcionarios = fachada.getAllFuncionario();
        
         for(int i=0;i<funcionarios.size();i++){
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getId(), i, 0);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getNome(), i, 1);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getSobrenome(), i, 2);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getRg(), i, 3);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getCpf(), i, 4);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getData_nascimento(), i, 5);
            tela.getjTableFuncionarios().getModel().setValueAt(funcionarios.get(i).getLogin(), i, 6);
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
        }
    }
    public boolean Limpar(){
        List<Funcionario> funcionarios = fachada.getAllFuncionario();
        for(int i=0;i<funcionarios.size()+1;i++){
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 0);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 1);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 2);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 3);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 4);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 5);
            tela.getjTableFuncionarios().getModel().setValueAt("", i, 6);
        }
        if(funcionarios.size()>0){
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
