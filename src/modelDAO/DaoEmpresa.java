/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelVO.Empresa;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoEmpresa {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Empresa empresa){
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Empresa.INSERT_ALL);
            statement.setString(1, empresa.getNome());
            statement.setString(2, empresa.getCnpj());
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Empresa buscarId(int id){
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Empresa.BUSCAR_ID);
            statement.setInt(1, id);
            result = statement.executeQuery();
            Empresa empresa = null;
            if(result.next()){
                empresa = new Empresa();
                empresa.setId(result.getInt(1));
                empresa.setNome(result.getString(2));
                empresa.setCnpj(result.getString(3));
                
            }
            
            
            conexao.close();
            return empresa;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
