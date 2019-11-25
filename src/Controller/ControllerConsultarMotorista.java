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
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.SwingUtilities;
import modelVO.BaseDados;
import modelVO.Motorista;
import sql.SQLUtil;
import view.CadastroMotorista;
import view.ConsultarMotorista;
import view.InformacoesMotorista;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerConsultarMotorista extends Observable {
    private ConsultarMotorista tela;
    private CadastroMotorista tela1;
    private InformacoesMotorista iMotorista;
    private Fachada fachada;
    private ControllerEditarMotorista edMotorista;
    private List<Motorista> motoristasLike;
    public ControllerConsultarMotorista(ConsultarMotorista tela,Fachada fachada,ControllerEditarMotorista edMotorista,CadastroMotorista tela1,InformacoesMotorista iMotorista) {
        this.tela = tela;
        this.fachada = fachada;
        this.edMotorista = edMotorista;
        this.tela1 = tela1;
        this.iMotorista = iMotorista;
        Control();
    }

    public ControllerConsultarMotorista(ConsultarMotorista cMotorista) {
        this.tela = cMotorista;
    }
    
    private void Control(){
        tela.getBtnBuscar().addActionListener(new LerDados());
        tela.getjTableMotorista().addMouseListener(new CaixaMenu());
        tela.getjMenuAtualizar().addActionListener(new CaixaMenu());
        tela.getjMenuInformacoes().addActionListener(new CaixaMenu());
        tela.getjMenuSalvar().addActionListener(new CaixaMenu());
        tela.getjMenuRemover().addActionListener(new CaixaMenu());
        tela.getjMenuSair().addActionListener(new CaixaMenu());
        tela.getjMenuEditar().addActionListener(new CaixaMenu());
        tela.getBuscaTxt().addKeyListener(new LerDados());
        tela.getjRadioCnh().addKeyListener(new LerDados());
        tela.getjRadioCpf().addKeyListener(new LerDados());
        tela.getjRadioNome().addKeyListener(new LerDados());
        tela.getjRadioRg().addKeyListener(new LerDados());
        tela.getBtnBuscar().addKeyListener(new LerDados());
        
        iMotorista.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iMotorista.setVisible(false);
            }
        });
         iMotorista.getBtnOk().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                iMotorista.getBtnOk().doClick();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }
    
    private class LerDados extends KeyAdapter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnBuscar()){
                if(tela.getjRadioNome().isSelected()){   
                    motoristasLike = fachada.buscarLikeNome(tela.getBuscaTxt().getText().toUpperCase(), SQLUtil.Motorista.BUSCARLIKENOME);
                }else if(tela.getjRadioRg().isSelected()){
                    motoristasLike = fachada.buscarLikeNome(tela.getBuscaTxt().getText(), SQLUtil.Motorista.BUSCARLIKERG);
                }else if(tela.getjRadioCpf().isSelected()){
                    motoristasLike = fachada.buscarLikeNome(tela.getBuscaTxt().getText(), SQLUtil.Motorista.BUSCARLIKECPF);
                }else if(tela.getjRadioCnh().isSelected()){
                    motoristasLike = fachada.buscarLikeNome(tela.getBuscaTxt().getText(), SQLUtil.Motorista.BUSCARLIKECNH);
                }
                setChanged();
                notifyObservers(tela.getBtnBuscar());
                
                
            }
        }

       

        @Override
        public void keyPressed(KeyEvent e) {
            if(tela.getBuscaTxt().hasFocus() || tela.getBtnBuscar().hasFocus() || tela.getjRadioNome().hasFocus() || tela.getjRadioCnh().hasFocus() || tela.getjRadioCpf().hasFocus() || tela.getjRadioRg().hasFocus()){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    tela.getBtnBuscar().doClick();
                }
            }
        }

       
       
        
    }
    private class CaixaMenu extends MouseAdapter implements ActionListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                try{
                if(!tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 0).equals("")){
                    tela.getjMenuEditar().setVisible(true);
                    tela.getjMenuInformacoes().setVisible(true);
                    tela.getjMenuRemover().setVisible(true);
                    
                    tela.getjPopupMenu1().show(tela.getjTableMotorista(), e.getX(), e.getY());
                }else{
                    tela.getjMenuEditar().setVisible(false);
                    tela.getjMenuInformacoes().setVisible(false);
                    tela.getjMenuRemover().setVisible(false);
                    tela.getjPopupMenu1().show(tela.getjTableMotorista(), e.getX(), e.getY());
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
                iMotorista.getLblNome().setText((String)tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 1));
                iMotorista.getLblSobrenome().setText((String)tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 2));
                iMotorista.getLblRg().setText((String)tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 3));
                iMotorista.getLblCpf().setText((String)tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 4));
                iMotorista.getLblData().setText((String)tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 5));
                iMotorista.getLblCnh().setText((String)tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 6));
                iMotorista.setVisible(true);
            }
            if(e.getSource() == tela.getjMenuSalvar()){
                tela1.setVisible(true);
            }
            if(e.getSource() == tela.getjMenuEditar()){
                String cpf = (String) tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 4);
                edMotorista.setColunaSelecionada(tela.getjTableMotorista().getSelectedRow());
                edMotorista.setEditarMotorista(fachada.buscarCpf(cpf));
                edMotorista.getTela().getNomeTxt().setText(edMotorista.getEditarMotorista().getNome().toLowerCase());
                edMotorista.getTela().getSobrenomeTxt().setText(edMotorista.getEditarMotorista().getSobrenome().toLowerCase());
                edMotorista.getTela().getRgTxt().setText(edMotorista.getEditarMotorista().getRg());
                edMotorista.getTela().getCpfTxt().setText(edMotorista.getEditarMotorista().getCpf());
                edMotorista.getTela().getDataTxt().setText(edMotorista.getEditarMotorista().getData_nascimento());
                edMotorista.getTela().getCnhTxt().setText(edMotorista.getEditarMotorista().getCnh());
                edMotorista.getTela().setVisible(true);
            }
            if(e.getSource() == tela.getjMenuRemover()){
                if(Mensagens.mensagemConfirmacao("Deseja remover esse registro?")){
                fachada.removerMotorista(tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 4).toString());
                LimparDadosSimples();
                ColocarDados();
                BaseDados.CarregarMotorista();
                setChanged();
                notifyObservers();
                }
                
               
            }
            if(e.getSource() == tela.getjMenuSair()){
                tela.setVisible(false);
            }
        }

       
    
    }
     public void ColocarDados(){
                   
           for(int i=0;i<BaseDados.getMotoristas().size();i++){
                        tela.getjTableMotorista().getModel().setValueAt(BaseDados.getMotoristas().get(i).getId(), i, 0);
                        tela.getjTableMotorista().getModel().setValueAt(BaseDados.getMotoristas().get(i).getNome(), i, 1);
                        tela.getjTableMotorista().getModel().setValueAt(BaseDados.getMotoristas().get(i).getSobrenome(), i, 2);
                        tela.getjTableMotorista().getModel().setValueAt(BaseDados.getMotoristas().get(i).getRg(), i, 3);
                        tela.getjTableMotorista().getModel().setValueAt(BaseDados.getMotoristas().get(i).getCpf(), i, 4);
                        tela.getjTableMotorista().getModel().setValueAt(BaseDados.getMotoristas().get(i).getData_nascimento(), i, 5);
                        tela.getjTableMotorista().getModel().setValueAt(BaseDados.getMotoristas().get(i).getCnh(), i, 6);
                                           
                
                }
          
               
           
        }
     public void ColocarDados(List<Motorista> motoristas){
            this.LimparDadosSimples();
              
          
           for(int i=0;i<motoristas.size();i++){
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getId(), i, 0);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getNome(), i, 1);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getSobrenome(), i, 2);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getRg(), i, 3);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getCpf(), i, 4);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getData_nascimento(), i, 5);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getCnh(), i, 6);
                                           
                
                }
           
           
        }
     public boolean LimparDadosSimples(){
         
         
         for(int i=0;i<BaseDados.getMotoristas().size()+1;i++){
             for(int j=0;j<7;j++){
                 tela.getjTableMotorista().getModel().setValueAt("", i, j);
             }
                         
         }
         if(BaseDados.getMotoristas().size()>0){
             return true;
         }else{
             return false;
         }
         
         
     }
     public boolean LimparDados(){
         
         
         for(int i=0;i<tela.getjTableMotorista().getRowCount();i++){
             for(int j=0;j<7;j++){
                 tela.getjTableMotorista().getModel().setValueAt("", i, j);
             }
                         
         }
         if(BaseDados.getMotoristas().size()>0){
             return true;
         }else{
             return false;
         }
         
         
     }

    public ConsultarMotorista getTela() {
        return tela;
    }

    public List<Motorista> getMotoristasLike() {
        return motoristasLike;
    }

    
    
}
