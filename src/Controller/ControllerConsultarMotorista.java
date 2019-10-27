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
import modelVO.Motorista;
import sql.SQLUtil;
import view.CadastroMotorista;
import view.ConsultarMotorista;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerConsultarMotorista extends Observable {
    private ConsultarMotorista tela;
    private CadastroMotorista tela1;
    private Fachada fachada;
    private ControllerEditarMotorista edMotorista;
    private List<Motorista> motoristasLike;
    public ControllerConsultarMotorista(ConsultarMotorista tela,Fachada fachada,ControllerEditarMotorista edMotorista,CadastroMotorista tela1) {
        this.tela = tela;
        this.fachada = fachada;
        this.edMotorista = edMotorista;
        this.tela1 = tela1;
        Control();
    }

    public ControllerConsultarMotorista(ConsultarMotorista cMotorista) {
        this.tela = cMotorista;
    }
    
    private void Control(){
        tela.getBtnBuscar().addActionListener(new LerDados());
        tela.getjTableMotorista().addMouseListener(new CaixaMenu());
        tela.getjMenuAtualizar().addActionListener(new CaixaMenu());
        tela.getjMenuSalvar().addActionListener(new CaixaMenu());
        tela.getjMenuRemover().addActionListener(new CaixaMenu());
        tela.getjMenuSair().addActionListener(new CaixaMenu());
        tela.getjMenuEditar().addActionListener(new CaixaMenu());
        tela.getBuscaTxt().addKeyListener(new LerDados());
        
    }
    
    private class LerDados extends KeyAdapter implements ActionListener,KeyListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnBuscar()){
                if(tela.getjRadioNome().isSelected()){   
                    motoristasLike = fachada.buscarLikeNome(tela.getBuscaTxt().getText(), SQLUtil.Motorista.BUSCARLIKENOME);
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
        public void keyReleased(KeyEvent e) {
            if(tela.getBuscaTxt().hasFocus()){
                if(tela.getjRadioNome().isSelected()){   
                    motoristasLike = fachada.buscarLikeNome(tela.getBuscaTxt().getText(), SQLUtil.Motorista.BUSCARLIKENOME);
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

       
       
        
    }
    private class CaixaMenu extends MouseAdapter implements ActionListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                try{
                if(!tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 0).equals("")){
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
            if(e.getSource() == tela.getjMenuSalvar()){
                tela1.setVisible(true);
            }
            if(e.getSource() == tela.getjMenuEditar()){
                String cpf = (String) tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 4);
                edMotorista.setColunaSelecionada(tela.getjTableMotorista().getSelectedRow());
                edMotorista.setEditarMotorista(fachada.buscarCpf(cpf));
                edMotorista.getTela().getNomeTxt().setText(edMotorista.getEditarMotorista().getNome());
                edMotorista.getTela().getSobrenomeTxt().setText(edMotorista.getEditarMotorista().getSobrenome());
                edMotorista.getTela().getRgTxt().setText(edMotorista.getEditarMotorista().getRg());
                edMotorista.getTela().getCpfTxt().setText(edMotorista.getEditarMotorista().getCpf());
                edMotorista.getTela().getDataTxt().setText(edMotorista.getEditarMotorista().getData_nascimento());
                edMotorista.getTela().getCnhTxt().setText(edMotorista.getEditarMotorista().getCnh());
                edMotorista.getTela().setVisible(true);
            }
            if(e.getSource() == tela.getjMenuRemover()){
                if(Mensagens.mensagemConfirmacao("Deseja remover esse registro?")){
                fachada.removerMotorista(tela.getjTableMotorista().getModel().getValueAt(tela.getjTableMotorista().getSelectedRow(), 4).toString());
                LimparDados();
                ColocarDados();
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
            List<Motorista> motoristas = fachada.getAllMotorista();
           /* if(tela.getjTableMotorista().getRowCount()<motoristas.size()){
                int diferenca = motoristas.size() - tela.getjTableMotorista().getRowCount();
                tela.getjTableMotorista().addRowSelectionInterval(0, diferenca);
                
            }
            */    
           if(motoristas!=null){
           for(int i=0;i<motoristas.size();i++){
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getId(), i, 0);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getNome(), i, 1);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getSobrenome(), i, 2);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getRg(), i, 3);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getCpf(), i, 4);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getData_nascimento(), i, 5);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getCnh(), i, 6);
                                           
                
                }
           }else{
               tela.setVisible(false);
           }
        }
     public void ColocarDados(List<Motorista> motoristas){
            this.LimparDados();
              
           if(motoristas!=null){
           for(int i=0;i<motoristas.size();i++){
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getId(), i, 0);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getNome(), i, 1);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getSobrenome(), i, 2);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getRg(), i, 3);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getCpf(), i, 4);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getData_nascimento(), i, 5);
                        tela.getjTableMotorista().getModel().setValueAt(motoristas.get(i).getCnh(), i, 6);
                                           
                
                }
           }else{
               tela.setVisible(false);
           }
        }
     public boolean LimparDados(){
         List<Motorista> motoristas = fachada.getAllMotorista();
         if(motoristas!=null){
         for(int i=0;i<motoristas.size()+1;i++){
             for(int j=0;j<7;j++){
                 tela.getjTableMotorista().getModel().setValueAt("", i, j);
             }
         }
         
         return true;
         }
         Mensagens.mensagem("Não há motorista cadastrado no banco de dados!");
         return false;
     }

    public ConsultarMotorista getTela() {
        return tela;
    }

    public List<Motorista> getMotoristasLike() {
        return motoristasLike;
    }

    
    
}
