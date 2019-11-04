/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.util.List;
import modelVO.Acesso;
import view.ControleAcesso;

/**
 *
 * @author Flavio
 */
public class ControllerControleAcesso {
    private ControleAcesso tela;
    private Fachada fachada;

    public ControllerControleAcesso(ControleAcesso tela, Fachada fachada) {
        this.tela = tela;
        this.fachada = fachada;
        Control();
    }
    private void Control(){
        
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
    public boolean limpar(){
        List<Acesso> acessos = fachada.getAllAcesso();
        for(int i=0;i<acessos.size();i++){
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

    public ControleAcesso getTela() {
        return tela;
    }
    
}
