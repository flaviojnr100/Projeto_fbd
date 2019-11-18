/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import javax.swing.JOptionPane;
import modelVO.Motorista;
import view.CadastroMotorista;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerCadastroMotorista extends Observable {
    private CadastroMotorista tela;
    private Fachada fachada;
    private ControllerConsultarMotorista cMotorista;
    public ControllerCadastroMotorista(CadastroMotorista tela,Fachada fachada,ControllerConsultarMotorista cMotorista) {
        this.tela = tela;
        this.fachada = fachada;
        this.cMotorista = cMotorista;        
        Control();
        
    }
    private void Control(){
        tela.getBtnCadastrar().addActionListener(new Botoes());
        tela.getBtnLimpar().addActionListener(new Botoes());
        tela.getBtnCancelar().addActionListener(new Botoes());
        tela.getNomeTxt().addMouseListener(new Botoes());
        tela.getSobrenomeTxt().addMouseListener(new Botoes());
        tela.getRgTxt().addMouseListener(new Botoes());
        tela.getCpfTxt().addMouseListener(new Botoes());
        tela.getDataTxt().addMouseListener(new Botoes());
        tela.getCnhTxt().addMouseListener(new Botoes());
        
        tela.getNomeTxt().addKeyListener(new Botoes());
        tela.getSobrenomeTxt().addKeyListener(new Botoes());
        tela.getRgTxt().addKeyListener(new Botoes());
        tela.getCpfTxt().addKeyListener(new Botoes());
        tela.getDataTxt().addKeyListener(new Botoes());
        tela.getCnhTxt().addKeyListener(new Botoes());
    }
    private class Botoes extends MouseAdapter implements ActionListener,KeyListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnCadastrar()){
                
                if(!tela.getNomeTxt().getText().equals("") && !tela.getSobrenomeTxt().getText().equals("")){
                    if(!fachada.salvar(new Motorista(tela.getNomeTxt().getText().toUpperCase(), tela.getSobrenomeTxt().getText().toUpperCase(), tela.getRgTxt().getText(), tela.getCpfTxt().getText(), tela.getDataTxt().getText(), tela.getCnhTxt().getText()))){
                        Mensagens.mensagem("Esse motorista já foi cadastrado!");
                        setChanged();
                        notifyObservers();
                    }else{
                        Mensagens.mensagem("Cadastro realizado com sucesso!");
                        tela.getBtnLimpar().doClick();
                        tela.getBtnCancelar().doClick();
                        cMotorista.getTela().getjMenuAtualizar().doClick();
                    }
              /*   }else{
                    if(tela.getCpfTxt().getText().equals("   .   .   -  ")){
                        tela.getNomeTxt().setBackground(Color.red);
                    }
                    if(tela.getSobrenomeTxt().getText().equals("")){
                    tela.getSobrenomeTxt().setBackground(Color.red);
                    }
                    if(tela.getCpfTxt().getText().length()!=15){
                        tela.getCpfTxt().setBackground(Color.red);
                    }
                    if(tela.getRgTxt().getText().equals("  .   .   -  ")){
                        tela.getRgTxt().setBackground(Color.red);
                    }
                    if(tela.getDataTxt().getText().length()!=10){
                        tela.getDataTxt().setBackground(Color.red);
                    }
                    if(tela.getCnhTxt().getText().equals("           ")){
                        tela.getCnhTxt().setBackground(Color.red);
                    }
                    
                */
                }       
            }
            if(e.getSource() == tela.getBtnLimpar()){
                tela.getNomeTxt().setText("");
                 tela.getSobrenomeTxt().setText("");
                 tela.getRgTxt().setText("");
                 tela.getCpfTxt().setText("");
                 tela.getDataTxt().setText("");
                 tela.getCnhTxt().setText("");
                 
              /*   tela.getNomeTxt().setBackground(Color.WHITE);
                 tela.getSobrenomeTxt().setBackground(Color.WHITE);
                 tela.getRgTxt().setBackground(Color.WHITE);
                 tela.getCpfTxt().setBackground(Color.WHITE);
                 tela.getDataTxt().setBackground(Color.WHITE);
                 tela.getCnhTxt().setBackground(Color.WHITE);
          */  }
            if(e.getSource() == tela.getBtnCancelar()){
                tela.setVisible(false);
            }
        }

        
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == tela.getNomeTxt()){
                tela.getNomeTxt().setBackground(Color.WHITE);
            }
            if(e.getSource() == tela.getSobrenomeTxt()){
                tela.getSobrenomeTxt().setBackground(Color.WHITE);
            }
            if(e.getSource() == tela.getRgTxt()){
                tela.getRgTxt().setBackground(Color.WHITE);
            }
            if(e.getSource() == tela.getCpfTxt()){
                tela.getCpfTxt().setBackground(Color.WHITE);
            }
            if(e.getSource() == tela.getDataTxt()){
                tela.getDataTxt().setBackground(Color.WHITE);
            }
            if(e.getSource() == tela.getCnhTxt()){
                tela.getCnhTxt().setBackground(Color.WHITE);
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(tela.getNomeTxt().hasFocus() || tela.getSobrenomeTxt().hasFocus() || tela.getRgTxt().hasFocus() || tela.getCpfTxt().hasFocus() || tela.getDataTxt().hasFocus() || tela.getCnhTxt().hasFocus()){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                tela.getBtnCadastrar().doClick();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
        
       
    
    }
}
