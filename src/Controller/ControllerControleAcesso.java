/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Observable;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import modelVO.Acesso;
import sql.SQLUtil;
import view.ControleAcesso;

/**
 *
 * @author Flavio
 */
public class ControllerControleAcesso extends Observable {
    private ControleAcesso tela;
    private Fachada fachada;
    private List<Acesso> acessoLike;
    public ControllerControleAcesso(ControleAcesso tela, Fachada fachada) {
        this.tela = tela;
        this.fachada = fachada;
        Control();
    }
    private void Control(){
        tela.getBuscarTxt().addKeyListener(new Teclado());
    }
    public void colocarDados(){
        List<Acesso> acessos = fachada.getAllAcesso();
        int i=0;
        for(Acesso a:acessos){
            tela.getjTableAcessos().getModel().setValueAt(a.getId(),i , 0);
            tela.getjTableAcessos().getModel().setValueAt(a.getFuncionario().getLogin(),i , 1);
            tela.getjTableAcessos().getModel().setValueAt(a.getHorario(),i , 2);
            tela.getjTableAcessos().getModel().setValueAt(a.getData(),i , 3);
            i++;
        }
    }
    
    public void colocarDados(List<Acesso> acessos){
        
        int i=0;
        for(Acesso a:acessos){
            tela.getjTableAcessos().getModel().setValueAt(a.getId(),i , 0);
            tela.getjTableAcessos().getModel().setValueAt(a.getFuncionario().getLogin(),i , 1);
            tela.getjTableAcessos().getModel().setValueAt(a.getHorario(),i , 2);
            tela.getjTableAcessos().getModel().setValueAt(a.getData(),i , 3);
            i++;
        }
    }
    public boolean limpar(){
        List<Acesso> acessos = fachada.getAllAcesso();
        for(int i=0;i<acessos.size()+1;i++){
            for(int j=0;j<4;j++){
                tela.getjTableAcessos().getModel().setValueAt("", i, j);
            }
        }
        if(acessos.size()>0){
            
            
            
            return true;
        }else{
            return false;
        }
    }
    public void limparLike(){
        
        for(int i=0;i<50;i++){
            for(int j=0;j<4;j++){
                tela.getjTableAcessos().getModel().setValueAt("", i, j);
            }
        }
        
    }
    
    
    

    public ControleAcesso getTela() {
        return tela;
    }

    public List<Acesso> getAcessoLike() {
        return acessoLike;
    }
    private class Teclado extends KeyAdapter{

        
        @Override
        public void keyReleased(KeyEvent e) {
            if(tela.getBuscarTxt().hasFocus()){
               if(tela.getjRadioData().isSelected()){
                  acessoLike = fachada.buscaLikeAcesso(tela.getBuscarTxt().getText(), SQLUtil.Acesso.BUSCAR_LIKEDATA);
               }else if(tela.getjRadioUsuario().isSelected()){
                  acessoLike =  fachada.buscaLikeAcesso(tela.getBuscarTxt().getText().toUpperCase(), SQLUtil.Acesso.BUSCAR_LIKENOME);
               }
               setChanged();
               notifyObservers("busca");
               
            }
        }
    }
}
