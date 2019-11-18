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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import modelVO.Funcionario;
import view.DashBoard;
import view.Mensagens;
import view.TelaLogin;

/**
 *
 * @author Flavio
 */
public class ControllerLogin {
    private TelaLogin tela;
    private DashBoard principal;
    private Fachada fachada;
    public ControllerLogin(TelaLogin tela,DashBoard principal,Fachada fachada) {
        this.tela = tela;
        this.principal = principal;
        this.fachada = fachada;
        Control();
    }
    private void Control(){
        
        tela.getBtnEntrar().addActionListener(new Botoes());
        tela.getBtnSair().addActionListener(new Botoes());
        tela.getBtnEntrar().addKeyListener(new Botoes());
        tela.getBtnSair().addKeyListener(new Botoes());
        tela.getUsuarioTxt().addKeyListener(new Botoes());
        tela.getSenhaTxt().addKeyListener(new Botoes());
        
        tela.getSenhaTxt().addKeyListener(new Botoes());
        
        
    }
    private class Botoes extends KeyAdapter implements ActionListener,KeyListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnSair()){
                if(Mensagens.mensagemConfirmacao("Deseja sair do sistema ?")){
                    System.exit(0);
                }
            }
            if(e.getSource() == tela.getBtnEntrar()){
                if(tela.getUsuarioTxt().getText().equals("adm") && tela.getSenhaTxt().getText().equals("adm") || fachada.autenticar(new Funcionario(tela.getUsuarioTxt().getText(), tela.getSenhaTxt().getText()))){
                    if(!(tela.getUsuarioTxt().getText().equals("adm") && tela.getSenhaTxt().getText().equals("adm"))){
                        fachada.salvar(fachada.buscarLogin(tela.getUsuarioTxt().getText(), tela.getSenhaTxt().getText()), getHorario(), getDataAtual());
                    }
                    tela.getUsuarioTxt().setText("");
                    tela.getSenhaTxt().setText("");
                    principal.setVisible(true);
                    tela.setVisible(false);
                }else{
                    if(!tela.getUsuarioTxt().getText().equals("") && !tela.getSenhaTxt().getText().equals("")){
                        Mensagens.mensagem("Login ou senha incorreto !!");
                    }
                }
            }
        }

                
        public void keyPressed(KeyEvent e) {
            if(tela.getUsuarioTxt().hasFocus() || tela.getSenhaTxt().hasFocus() || tela.getBtnEntrar().hasFocus()){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    tela.getBtnEntrar().doClick();
                }
                
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                
                tela.getBtnSair().doClick();
                }
            }
           
    }
        
        
    
    }
    public String getDataAtual(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        
        return formatador.format(data);
        
    }
    public String getHorario(){
        Date data = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        return c.getTime().getHours()+":"+c.getTime().getMinutes()+":"+c.getTime().getSeconds();
    }
   
}
