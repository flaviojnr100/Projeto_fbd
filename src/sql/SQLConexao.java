/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Flavio
 */
public class SQLConexao {
    public static final String BD_CONEXAO = "transportes_terrestre";
    public static Connection conexao= null;
    
     public static synchronized Connection getConnectionInstance(String bd){
         
        try {
            
            if (conexao == null || conexao.isClosed()) {

                switch (bd) {
                    case BD_CONEXAO: {
                        
                        conexao = DriverManager.getConnection(
                                SQLUtil.URL_POSTGRES,
                                SQLUtil.USUARIO_POSTGRES,
                                SQLUtil.SENHA_POSTGRES
                        );
                    }
                    break;
                    
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return conexao;

    }
    
    
}
