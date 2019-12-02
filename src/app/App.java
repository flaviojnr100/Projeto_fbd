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
import Controller.ControllerConsultaFinanca;
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
import Controller.ControllerEditarTransporte;
import Controller.ControllerInformacoesFinancas;
import Controller.ControllerLogin;
import Controller.ControllerTelaPersonalizar;
import fachada.Fachada;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelDAO.DaoDestino;
import modelDAO.DaoMotorista;
import modelDAO.DaoTransporte;
import modelVB.BusinessMotorista;
import modelVO.BaseDados;
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
import view.ConsultarFinança;
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
import view.InformacaoAtualVeiculo;
import view.InformacaoRota;
import view.InformacoesFinanca;
import view.InformacoesFuncionario;
import view.InformacoesMotorista;
import view.InformacoesPassageiro;
import view.InformacoesVeiculo;
import view.InformacoesViagem;
import view.Sobre;
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
        BaseDados.CarregarTransporte();
        BaseDados.CarregarRota();
        BaseDados.CarregarMotorista();
        BaseDados.CarregarTipoTransporte();
        BaseDados.CarregarPassageiro();
        BaseDados.CarregarFuncionario();
        BaseDados.CarregarViagem();
        BaseDados.CarregarFinanca();
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
       DashBoard dash = new DashBoard();
       
       
      CadastroFuncionario cFuncionario = new CadastroFuncionario();
      ConsultarFuncionario ccFuncionario = new ConsultarFuncionario();
      new ControllerCadastroFuncionario(cFuncionario,fachada1,ccFuncionario);
      InformacoesFuncionario iFuncionario = new InformacoesFuncionario();
      EditarFuncionario eFuncionario = new EditarFuncionario();
      ControllerEditarFuncionario ecFuncionario = new ControllerEditarFuncionario(eFuncionario, fachada1);
      ControllerConsultarFuncionario cccFuncionario = new ControllerConsultarFuncionario(ccFuncionario, fachada1,ecFuncionario,cFuncionario,iFuncionario);
      
      cccFuncionario.addObserver(ccFuncionario);
      ecFuncionario.addObserver(ccFuncionario);
      
      CadastroPassageiro cPassageiro = new CadastroPassageiro();
      InformacoesPassageiro iPassageiro = new InformacoesPassageiro();
      ConsultarPassageiro ccPassageiro = new ConsultarPassageiro();
      EditarPassageiro ePassageiro = new EditarPassageiro();
      ControllerEditarPassageiro ecPassageiro = new ControllerEditarPassageiro(ePassageiro, fachada1);
      ControllerConsultarPassageiro cccPassageiro = new ControllerConsultarPassageiro(ccPassageiro, fachada1,ecPassageiro,cPassageiro,iPassageiro);
      new ControllerCadastroPassageiro(cPassageiro,fachada1,cccPassageiro);
      cccPassageiro.addObserver(ccPassageiro);
      ecPassageiro.addObserver(ccPassageiro);
      
      
      CadastroMotorista cMotorista = new CadastroMotorista();
      InformacoesMotorista iMotorista = new InformacoesMotorista();
      ConsultarMotorista ccMotorista = new ConsultarMotorista();
      EditarMotorista eMotorista = new EditarMotorista();
      ControllerEditarMotorista ceMotorista = new ControllerEditarMotorista(eMotorista, fachada1);
      ControllerConsultarMotorista cccMotorista = new ControllerConsultarMotorista(ccMotorista, fachada1,ceMotorista,cMotorista,iMotorista);
      ControllerCadastroMotorista cadMotorista =  new ControllerCadastroMotorista(cMotorista,fachada1,cccMotorista);
      cccMotorista.addObserver(ccMotorista);
      ceMotorista.addObserver(ccMotorista);
      
      CadastroRota cRota = new CadastroRota();
      ConsultarRota ccRota = new ConsultarRota();
      InformacaoRota iRota = new InformacaoRota();
      EditarRota eRota = new EditarRota();
     ControllerCadastroRota caRota =  new ControllerCadastroRota(cRota,fachada1,ccRota);
     
      ControllerEditarRota ceRota = new ControllerEditarRota(eRota, fachada1);
      ControllerConsultarRota cccRota = new ControllerConsultarRota(ccRota,fachada1,eRota,ceRota,cRota,iRota);
      
      ceRota.setCccRota(cccRota);
      cccRota.addObserver(ccRota);
      
      CadastroTipoTransporte cTipoTransporte = new CadastroTipoTransporte();
      EditarTransporte eTransporte = new EditarTransporte();
      CadastroTransporte cTransporte = new CadastroTransporte();
      InformacoesVeiculo iVeiculo = new InformacoesVeiculo();
      ControllerCadastroTransporte cccTransporte = new ControllerCadastroTransporte(cTransporte, fachada1, cMotorista, cTipoTransporte, cRota);
      ConsultarTransporte ccTransporte = new ConsultarTransporte();
      
      
      
      ControllerCadastroTipoTransporte ccTipo = new ControllerCadastroTipoTransporte(cTipoTransporte,fachada1,cccTransporte);
      ControllerEditarTransporte ceTransporte = new ControllerEditarTransporte(eTransporte, fachada1);
      ControllerConsultarTransporte ccccTransporte = new ControllerConsultarTransporte(ccTransporte, fachada1,iVeiculo,ceTransporte,cccTransporte);
      
      ceTransporte.setCcTransporte(ccccTransporte);
      cccTransporte.addObserver(cTransporte);
      ccTipo.addObserver(cTransporte);
      cadMotorista.addObserver(cTransporte);
      cccTransporte.addObserver(cTransporte);
      caRota.addObserver(cTransporte);
      
      ccccTransporte.addObserver(ccTransporte);
      ceTransporte.addObserver(eTransporte);
      CadastroViagem cViagem = new CadastroViagem();
      InformacoesViagem iViagem = new InformacoesViagem();
      ConsultarViagem ccViagem = new ConsultarViagem();
      ControllerCadastroViagem cccViagem = new ControllerCadastroViagem(cViagem, fachada1, cPassageiro, cRota,cTransporte,ccViagem);
      ControllerConsultarViagem ccccViagem = new ControllerConsultarViagem(ccViagem, fachada1,iViagem,cccViagem);
       
      cccViagem.addObserver(cViagem);
      ccccViagem.addObserver(ccViagem);
      
      ControleAcesso cAcesso = new ControleAcesso();
      ControllerControleAcesso ccAcesso = new ControllerControleAcesso(cAcesso, fachada1);
      
      InformacoesFinanca iFinanca = new InformacoesFinanca();
      ControllerInformacoesFinancas cciFinanca = new ControllerInformacoesFinancas(iFinanca, fachada1);
      ConsultarFinança ccFinanca = new ConsultarFinança();
      ControllerConsultaFinanca cccFinanca = new ControllerConsultaFinanca(ccFinanca, fachada1,cciFinanca);
      cccFinanca.addObserver(ccFinanca);
      
      TelaLogin telaLogin = new TelaLogin();
      Sobre sobre = new Sobre();
      TelaPersonalizar personalizar = new TelaPersonalizar();
      InformacaoAtualVeiculo iaVeiculo = new InformacaoAtualVeiculo();
      ControllerDashBoard ccDash =new ControllerDashBoard(dash, cFuncionario, ccFuncionario, cMotorista, ccMotorista, cTransporte, ccTransporte, cPassageiro, ccPassageiro, cRota, ccRota, cViagem, ccViagem,personalizar,cccMotorista,cccFuncionario,cccPassageiro,cccTransporte,ccccTransporte,ccAcesso,telaLogin,cccRota,cccViagem,ccccViagem,ccFinanca,cccFinanca,iaVeiculo,sobre);
      ControllerTelaPersonalizar c= new ControllerTelaPersonalizar(personalizar,dash);
      c.addObserver(dash);
      //ccDash.addObserver(dash);
      ControllerLogin cLogin = new ControllerLogin(telaLogin, dash,fachada1);
     // telaLogin.setVisible(true);
      TelaCarregamento tCarregamento = new TelaCarregamento();
      tCarregamento.setVisible(true);
      new ControllerCarregamento(tCarregamento, telaLogin);
      ccAcesso.addObserver(cAcesso);
      

  
 
  
  
       
       
      
      
    }
    
}
