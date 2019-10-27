/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Controller.ControllerCadastroFuncionario;
import Controller.ControllerCadastroMotorista;
import Controller.ControllerCadastroPassageiro;
import Controller.ControllerCadastroRota;
import Controller.ControllerCadastroTipoTransporte;
import Controller.ControllerCadastroTransporte;
import Controller.ControllerCadastroViagem;
import Controller.ControllerCarregamento;
import Controller.ControllerConsultarMotorista;
import Controller.ControllerDashBoard;
import Controller.ControllerEditarMotorista;
import Controller.ControllerFinanceiro;
import Controller.ControllerLogin;
import Controller.ControllerTelaPersonalizar;
import fachada.Fachada;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelDAO.DaoMotorista;
import modelDAO.DaoTransporte;
import modelVB.BusinessMotorista;
import modelVO.Motorista;
import modelVO.Transporte;
import view.CadastroFuncionario;
import view.CadastroMotorista;
import view.CadastroPassageiro;
import view.CadastroRota;


import view.CadastroTipoTransporte;
import view.CadastroTransporte;
import view.CadastroViagem;
import view.ConsultarFuncionario;
import view.ConsultarMotorista;
import view.ConsultarPassageiro;
import view.ConsultarRota;
import view.ConsultarTransporte;
import view.ConsultarViagem;
import view.DashBoard;
import view.EditarFuncionario;
import view.EditarMotorista;
import view.EditarPassageiro;
import view.EditarRota;
import view.EditarTransporte;
import view.Financeiro;
import view.TelaCarregamento;
import view.TelaLogin;
import view.TelaPersonalizar;



/**
 *
 * @author Flavio
 */
public class App {
    public static void main(String[] args) {
       
     //   Motorista motorista1 = new Motorista("Roberta", "Paula", "546532127", "326598", "12/56/1236", "654312321");
       // Transporte transporte = new Transporte("Amarelo", "1235cvn", "3554fd");
        Fachada fachada1 =Fachada.getInstance();
        
        //System.out.println(""+fachada1.verificarExistenciaMotorista("555.555.555-55546456"));
    //     Motorista motorista = fachada1.buscarCpf("326598");
    //    fachada1.editar(motorista, motorista1);
      
      /* Login login =  new Login();
       new Controller.ControllerLogin(login);
       login.setVisible(true);
        */
    /*  CadastroFuncionario cc =new CadastroFuncionario();
      new ControllerCadastroFuncionario(cc);
      cc.setVisible(true);
*/
  /*  CadastroEmpresa cc = new CadastroEmpresa();
    new ControllerCadastroEmpresa(cc);
    cc.setVisible(true);
        */
       // System.out.println("  .   .   -  ".length());
       //Arrumar o problema de validar cadastro(Colorir os campos invalidos)
  
      CadastroFuncionario cFuncionario = new CadastroFuncionario();
      new ControllerCadastroFuncionario(cFuncionario);
      ConsultarFuncionario ccFuncionario = new ConsultarFuncionario();
      EditarFuncionario eFuncionario = new EditarFuncionario();
      
      CadastroPassageiro cPassageiro = new CadastroPassageiro();
      new ControllerCadastroPassageiro(cPassageiro);
      ConsultarPassageiro ccPassageiro = new ConsultarPassageiro();
      EditarPassageiro ePassageiro = new EditarPassageiro();
      
      CadastroMotorista cMotorista = new CadastroMotorista();
      
      ConsultarMotorista ccMotorista = new ConsultarMotorista();
      EditarMotorista eMotorista = new EditarMotorista();
      ControllerEditarMotorista ceMotorista = new ControllerEditarMotorista(eMotorista, fachada1);
      ControllerConsultarMotorista cccMotorista = new ControllerConsultarMotorista(ccMotorista, fachada1,ceMotorista,cMotorista);
      new ControllerCadastroMotorista(cMotorista,fachada1,cccMotorista);
      cccMotorista.addObserver(ccMotorista);
      ceMotorista.addObserver(ccMotorista);
      
      CadastroRota cRota = new CadastroRota();
      new ControllerCadastroRota(cRota);
      ConsultarRota ccRota = new ConsultarRota();
      EditarRota eRota = new EditarRota();
      
      CadastroTipoTransporte cTipoTransporte = new CadastroTipoTransporte();
      new ControllerCadastroTipoTransporte(cTipoTransporte);
      
      CadastroTransporte cTransporte = new CadastroTransporte();
      new ControllerCadastroTransporte(cTransporte);
      ConsultarTransporte ccTransporte = new ConsultarTransporte();
      EditarTransporte eTransporte = new EditarTransporte();
      
      CadastroViagem cViagem = new CadastroViagem();
      new ControllerCadastroViagem(cViagem);
      ConsultarViagem ccViagem = new ConsultarViagem();
      
      Financeiro financeiro = new Financeiro();
      new ControllerFinanceiro(financeiro);
      
      
      
      DashBoard dash = new DashBoard();
      TelaPersonalizar personalizar = new TelaPersonalizar();
      new ControllerDashBoard(dash, cFuncionario, ccFuncionario, cMotorista, ccMotorista, cTransporte, ccTransporte, cPassageiro, ccPassageiro, cRota, ccRota, financeiro, cViagem, ccViagem,personalizar,cccMotorista);
      ControllerTelaPersonalizar c= new ControllerTelaPersonalizar(personalizar,dash);
      c.addObserver(dash);
      TelaLogin telaLogin = new TelaLogin();
      new ControllerLogin(telaLogin, dash);
     // telaLogin.setVisible(true);
      TelaCarregamento tCarregamento = new TelaCarregamento();
      tCarregamento.setVisible(true);
      new ControllerCarregamento(tCarregamento, telaLogin);
      
        
       
      
      
    }
    
}
