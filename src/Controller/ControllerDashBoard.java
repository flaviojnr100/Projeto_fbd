/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroFuncionario;
import view.CadastroMotorista;
import view.CadastroPassageiro;
import view.CadastroRota;
import view.CadastroTransporte;
import view.CadastroViagem;
import view.ConsultarFuncionario;
import view.ConsultarMotorista;
import view.ConsultarPassageiro;
import view.ConsultarRota;
import view.ConsultarTransporte;
import view.ConsultarViagem;
import view.DashBoard;
import view.Financeiro;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerDashBoard {
    private DashBoard principal;
    private CadastroFuncionario cFuncionario;
    private ConsultarFuncionario ccFuncionario;
    private CadastroMotorista cMotorista;
    private ConsultarMotorista ccMotorista;
    private CadastroTransporte cTransporte;
    private ConsultarTransporte ccTransporte;
    private CadastroPassageiro cPassageiro;
    private ConsultarPassageiro ccPassageiro;
    private CadastroViagem cViagem;
    private ConsultarViagem ccViagem;
    private CadastroRota cRota;
    private ConsultarRota ccRota;
    private Financeiro financeiro;

    public ControllerDashBoard(DashBoard principal, CadastroFuncionario cFuncionario, ConsultarFuncionario ccFuncionario, CadastroMotorista cMotorista, ConsultarMotorista ccMotorista, CadastroTransporte cTransporte, ConsultarTransporte ccTransporte, CadastroPassageiro cPassageiro, ConsultarPassageiro ccPassageiro, CadastroRota cRota, ConsultarRota ccRota, Financeiro financeiro,CadastroViagem cViagem,ConsultarViagem ccViagem) {
        this.principal = principal;
        this.cFuncionario = cFuncionario;
        this.ccFuncionario = ccFuncionario;
        this.cMotorista = cMotorista;
        this.ccMotorista = ccMotorista;
        this.cTransporte = cTransporte;
        this.ccTransporte = ccTransporte;
        this.cPassageiro = cPassageiro;
        this.ccPassageiro = ccPassageiro;
        this.cRota = cRota;
        this.ccRota = ccRota;
        this.financeiro = financeiro;
        this.cViagem = cViagem;
        this.ccViagem = ccViagem;
        Control();
    }
    

   
    private void Control(){
        principal.getjMenuFuncionarioCadastro().addActionListener(new Menu());
        principal.getjMenuFuncionarioConsulta().addActionListener(new Menu());
        
        principal.getjMenuMotoristaCadastro().addActionListener(new Menu());
        principal.getjMenuMotoristaConsulta().addActionListener(new Menu());
        
        principal.getjMenuVeiculoCadastro().addActionListener(new Menu());
        principal.getjMenuVeiculoConsulta().addActionListener(new Menu());
        
        principal.getjMenuPassageiroCadastro().addActionListener(new Menu());
        principal.getjMenuPassageiroConsulta().addActionListener(new Menu());
        
        principal.getjMenuRotaCadastro().addActionListener(new Menu());
        principal.getjMenuRotaConsulta().addActionListener(new Menu());
        
        principal.getjMenuFinanceiroConsulta().addActionListener(new Menu());
        
        principal.getjMenuSobre().addActionListener(new Menu());
        principal.getjMenuEncerrarSistema().addActionListener(new Menu());
        
        principal.getBtnEfetuarViagem().addActionListener(new Botoes());
        principal.getBtnConsultarViagem().addActionListener(new Botoes());
        principal.getBtnConsultarVeiculos().addActionListener(new Botoes());
        principal.getBtnConsultarRotas().addActionListener(new Botoes());
        principal.getBtnConsultarPassageiros().addActionListener(new Botoes());
        
        
        
        
    }
    
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == principal.getBtnEfetuarViagem()){
                cViagem.setVisible(true);
            }
            if(e.getSource() == principal.getBtnConsultarViagem()){
                ccViagem.setVisible(true);
            }
            if(e.getSource() == principal.getBtnConsultarVeiculos()){
                principal.getjMenuVeiculoConsulta().doClick();
            }
            if(e.getSource() == principal.getBtnConsultarRotas()){
                principal.getjMenuRotaConsulta().doClick();
            }
            if(e.getSource() == principal.getBtnConsultarPassageiros()){
                principal.getjMenuPassageiroConsulta().doClick();
            }
        }
        
    
    }
    private class Menu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == principal.getjMenuFuncionarioCadastro()){
                cFuncionario.setVisible(true);
            }
            
            if(e.getSource() == principal.getjMenuFuncionarioConsulta()){
                ccFuncionario.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuMotoristaCadastro()){
                cMotorista.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuMotoristaConsulta()){
                ccMotorista.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuVeiculoCadastro()){
                cTransporte.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuVeiculoConsulta()){
                ccTransporte.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuPassageiroCadastro()){
                cPassageiro.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuPassageiroConsulta()){
                ccPassageiro.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuRotaCadastro()){
                cRota.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuRotaConsulta()){
                ccRota.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuFinanceiroConsulta()){
                financeiro.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuSobre()){
                
            }
            if(e.getSource() == principal.getjMenuEncerrarSistema()){
                if(Mensagens.mensagemConfirmacao("Deseja sair do sistema?")){
                    System.exit(0);
                }
            }
        }
    
    }
    
}
