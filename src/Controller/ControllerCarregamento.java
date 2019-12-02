/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.TelaCarregamento;
import view.TelaLogin;

/**
 *
 * @author Flavio
 */
public class ControllerCarregamento extends Thread {
    private TelaCarregamento tela;
    private TelaLogin login;
    private int parada=5000;
    private Fachada fachada;
    public ControllerCarregamento(TelaCarregamento tela,TelaLogin login) {
        this.tela = tela;
        this.login = login;
        this.fachada = Fachada.getInstance();
        if(verificar()){
            fachada.resetarAssento();
        }
        start();
     
    }
    public boolean verificar(){
        if(!fachada.buscarDia(getDataAtual())){
            return true;
        }
        return false;
    }
    public void run(){
        
        while (true){
        
            try {
                if(parada==0){
                    login.setVisible(true);
                    tela.setVisible(false);
                    break;
                }
                sleep(1000);
                parada-=1000;
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerCarregamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
     public String getDataAtual(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        
        return formatador.format(data);
        
    }
    
}
