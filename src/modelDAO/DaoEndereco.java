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
import modelVO.Endereco;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoEndereco {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Endereco endereco){
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Endereco.INSERT_ALL);
            statement.setString(1, endereco.getEstado());
            statement.setString(2, endereco.getRua());
            statement.setString(3, endereco.getBairro());
            statement.setString(4, endereco.getCidade());
            statement.setString(5, endereco.getComplemento());
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEndereco.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Endereco buscarId(int id){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Endereco.BUSCAR_ID);
            statement.setInt(1,id);
            result = statement.executeQuery();
            Endereco endereco;
            if(result.next()){
                endereco = new Endereco();
                endereco.setId(result.getInt(1));
                endereco.setEstado(result.getString(2));
                endereco.setRua(result.getString(3));
                endereco.setBairro(result.getString(4));
                endereco.setCidade(result.getString(5));
                endereco.setComplemento(result.getString(6));
                conexao.close();
                return endereco;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEndereco.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
        
    }
    
    public boolean verificarExistencia(Endereco endereco){
        
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Endereco.VERIFICAR_EXISTENCIA);
            
            statement.setString(1, endereco.getEstado());
            statement.setString(2, endereco.getRua());
            statement.setString(3, endereco.getBairro());
            statement.setString(4, endereco.getCidade());
            result = statement.executeQuery();
             conexao.close();
            if(result.next()){
                if(result.getInt(1) == 1){
                    return false;
                }else{
                    return true;
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
       public int retornar_id(Endereco endereco){
        
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Endereco.RETORNAR_ID);
            
            statement.setString(1, endereco.getEstado());
            statement.setString(2, endereco.getRua());
            statement.setString(3, endereco.getBairro());
            statement.setString(4, endereco.getCidade());
            result = statement.executeQuery();
             conexao.close();
            if(result.next()){
                return result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
   
}
