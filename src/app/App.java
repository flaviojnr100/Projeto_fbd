/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;




import modelVO.Motorista;
import fachada.Fachada;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelDAO.DaoMotorista;
import modelDAO.DaoTransporte;
import modelVO.Transporte;
import view.CadastroFuncionario;
import view.CadastroMotorista;
import view.CadastroPassageiro;
import view.CadastroRota;


import view.CadastroTipoTransporte;
import view.CadastroTransporte;
import view.CadastroViagem;
import view.ConsultarPassageiro;
import view.ConsultarRota;
import view.ConsultarTransporte;
import view.DashBoard;
import view.TelaLogin;



/**
 *
 * @author Flavio
 */
public class App {
    public static void main(String[] args) {
       
     //   Motorista motorista1 = new Motorista("Roberta", "Paula", "546532127", "326598", "12/56/1236", "654312321");
       // Transporte transporte = new Transporte("Amarelo", "1235cvn", "3554fd");
     //   Fachada fachada1 =Fachada.getInstance();
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
      new CadastroViagem().setVisible(true);
    }
    
}
