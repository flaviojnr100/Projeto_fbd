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

/**
 *
 * @author Flavio
 */
public class App {
    public static void main(String[] args) {
       
        Motorista motorista1 = new Motorista("Roberta", "Paula", "546532127", "326598", "12/56/1236", "654312321");
       // Transporte transporte = new Transporte("Amarelo", "1235cvn", "3554fd");
        Fachada fachada1 =Fachada.getInstance();
         Motorista motorista = fachada1.buscarCpf("326598");
        fachada1.editar(motorista, motorista1);
      
        
        
        
    }
    
}
