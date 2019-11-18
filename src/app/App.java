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
import Controller.ControllerConsultarFuncionario;
import Controller.ControllerConsultarMotorista;
import Controller.ControllerConsultarPassageiro;
import Controller.ControllerConsultarRota;
import Controller.ControllerConsultarTransporte;
import Controller.ControllerConsultarViagem;
import Controller.ControllerControleAcesso;
import Controller.ControllerDashBoard;
import Controller.ControllerEditarFuncionario;
import Controller.ControllerEditarMotorista;
import Controller.ControllerEditarPassageiro;
import Controller.ControllerEditarRota;
import Controller.ControllerFinanceiro;
import Controller.ControllerLogin;
import Controller.ControllerTelaPersonalizar;
import fachada.Fachada;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelDAO.DaoDestino;
import modelDAO.DaoMotorista;
import modelDAO.DaoTransporte;
import modelVB.BusinessMotorista;
import modelVO.Destino;
import modelVO.Funcionario;
import modelVO.Motorista;
import modelVO.Tipo_transporte;
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
import view.ControleAcesso;
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
        //fachada1.salvar(new Funcionario("flavio", "cordeiro", "345346", "6546756", "12/12/1212", "fj", "234"));
        
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
      ConsultarFuncionario ccFuncionario = new ConsultarFuncionario();
      new ControllerCadastroFuncionario(cFuncionario,fachada1,ccFuncionario);
      
      EditarFuncionario eFuncionario = new EditarFuncionario();
      ControllerEditarFuncionario ecFuncionario = new ControllerEditarFuncionario(eFuncionario, fachada1);
      ControllerConsultarFuncionario cccFuncionario = new ControllerConsultarFuncionario(ccFuncionario, fachada1,ecFuncionario,cFuncionario);
      
      cccFuncionario.addObserver(ccFuncionario);
      ecFuncionario.addObserver(ccFuncionario);
      
      CadastroPassageiro cPassageiro = new CadastroPassageiro();
      
      ConsultarPassageiro ccPassageiro = new ConsultarPassageiro();
      EditarPassageiro ePassageiro = new EditarPassageiro();
      ControllerEditarPassageiro ecPassageiro = new ControllerEditarPassageiro(ePassageiro, fachada1);
      ControllerConsultarPassageiro cccPassageiro = new ControllerConsultarPassageiro(ccPassageiro, fachada1,ecPassageiro,cPassageiro);
      new ControllerCadastroPassageiro(cPassageiro,fachada1,cccPassageiro);
      cccPassageiro.addObserver(ccPassageiro);
      ecPassageiro.addObserver(ccPassageiro);
      
      
      CadastroMotorista cMotorista = new CadastroMotorista();
      
      ConsultarMotorista ccMotorista = new ConsultarMotorista();
      EditarMotorista eMotorista = new EditarMotorista();
      ControllerEditarMotorista ceMotorista = new ControllerEditarMotorista(eMotorista, fachada1);
      ControllerConsultarMotorista cccMotorista = new ControllerConsultarMotorista(ccMotorista, fachada1,ceMotorista,cMotorista);
      ControllerCadastroMotorista cadMotorista =  new ControllerCadastroMotorista(cMotorista,fachada1,cccMotorista);
      cccMotorista.addObserver(ccMotorista);
      ceMotorista.addObserver(ccMotorista);
      
      CadastroRota cRota = new CadastroRota();
      ConsultarRota ccRota = new ConsultarRota();
      EditarRota eRota = new EditarRota();
      new ControllerCadastroRota(cRota,fachada1,ccRota);
     
      ControllerEditarRota ceRota = new ControllerEditarRota(eRota, fachada1);
      ControllerConsultarRota cccRota = new ControllerConsultarRota(ccRota,fachada1,eRota,ceRota,cRota);
      
      ceRota.setCccRota(cccRota);
      cccRota.addObserver(ccRota);
      
      CadastroTipoTransporte cTipoTransporte = new CadastroTipoTransporte();
      
      CadastroTransporte cTransporte = new CadastroTransporte();
      ControllerCadastroTransporte cccTransporte = new ControllerCadastroTransporte(cTransporte, fachada1, cMotorista, cTipoTransporte, cRota);
      ConsultarTransporte ccTransporte = new ConsultarTransporte();
      EditarTransporte eTransporte = new EditarTransporte();
      
      
      ControllerCadastroTipoTransporte ccTipo = new ControllerCadastroTipoTransporte(cTipoTransporte,fachada1,cccTransporte);
      
      ControllerConsultarTransporte ccccTransporte = new ControllerConsultarTransporte(ccTransporte, fachada1);
      cccTransporte.addObserver(cTransporte);
      ccTipo.addObserver(cTransporte);
      cadMotorista.addObserver(cTransporte);
      cccTransporte.addObserver(cTransporte);
      
      ccccTransporte.addObserver(ccTransporte);
      
      CadastroViagem cViagem = new CadastroViagem();
      ControllerCadastroViagem cccViagem = new ControllerCadastroViagem(cViagem, fachada1, cPassageiro, cRota,cTransporte);
      ConsultarViagem ccViagem = new ConsultarViagem();
      ControllerConsultarViagem ccccViagem = new ControllerConsultarViagem(ccViagem, fachada1);
      
      cccViagem.addObserver(cViagem);
      Financeiro financeiro = new Financeiro();
      new ControllerFinanceiro(financeiro);
      
      ControleAcesso cAcesso = new ControleAcesso();
      ControllerControleAcesso ccAcesso = new ControllerControleAcesso(cAcesso, fachada1);
      
      TelaLogin telaLogin = new TelaLogin();
      DashBoard dash = new DashBoard();
      TelaPersonalizar personalizar = new TelaPersonalizar();
      new ControllerDashBoard(dash, cFuncionario, ccFuncionario, cMotorista, ccMotorista, cTransporte, ccTransporte, cPassageiro, ccPassageiro, cRota, ccRota, financeiro, cViagem, ccViagem,personalizar,cccMotorista,cccFuncionario,cccPassageiro,cccTransporte,ccccTransporte,ccAcesso,telaLogin,cccRota,cccViagem,ccccViagem);
      ControllerTelaPersonalizar c= new ControllerTelaPersonalizar(personalizar,dash);
      c.addObserver(dash);
     
      ControllerLogin cLogin = new ControllerLogin(telaLogin, dash,fachada1);
     // telaLogin.setVisible(true);
      TelaCarregamento tCarregamento = new TelaCarregamento();
      tCarregamento.setVisible(true);
      new ControllerCarregamento(tCarregamento, telaLogin);
      ccAcesso.addObserver(cAcesso);
      

  
      
        
  
  
       
       
      
      
    }
    
}
