/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import modelVO.Motorista;
import fachada.Fachada;
import sql.SQLConexao;
/**
 *
 * @author Flavio
 */
public class App {
    public static void main(String[] args) {
        Motorista motorista = new Motorista("Marcos", "Vinicius", "546532127", "326598", "12/56/1236", "654312321");
        
       /* Fachada fachada1 =Fachada.getInstance();
        if(fachada1.salvar(motorista)){
            System.out.println("Deu certo");
        }else{
            System.out.println("Erro");
        }
      */
       // System.out.println(SQLConexao.getConnectionInstance(SQLConexao.BD_CONEXAO).toString());
        
        
    }
    
}
