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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelVO.Financa;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoFinanca {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    public DaoFinanca() {
    }
    
    public boolean salvar(Financa financa){
         
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Financa.INSERT);
            statement.setString(1, financa.getData());
            statement.setDouble(2, financa.getValor());
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoFinanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public Financa buscar_data(String data){
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Financa.BUSCAR_DATA);
            statement.setString(1, data);
            result = statement.executeQuery();
            if(result.next()){
                return new Financa(result.getInt(1), result.getString(2), result.getDouble(3));
            }
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoFinanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public List<Financa> getAll(){
        try {
            List<Financa> financas = new ArrayList<>();
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Financa.BUSCAR_TODOS);
            result = statement.executeQuery();
            conexao.close();
            while(result.next()){
                financas.add(new Financa(result.getInt(1), result.getString(2), result.getDouble(3)));
            }
            return financas;
        } catch (SQLException ex) {
            Logger.getLogger(DaoFinanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public boolean adicionar_financa(Financa financa,int id){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Financa.ADICIONAR_FINANCA);
            statement.setDouble(1, financa.getValor());
            statement.setInt(2, id);
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoFinanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public boolean alterar_financa(Financa financa){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Financa.ALTERAR_FINANCA);
            statement.setDouble(1, financa.getValor());
            statement.setString(2, financa.getData());
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoFinanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public List<Financa> buscaLike(String texto){
        try {
            List<Financa> financas = new ArrayList<>();
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Financa.BUSCARLIKEDATA);
            statement.setString(1, texto+"%");
            result = statement.executeQuery();
            conexao.close();
            while(result.next()){
                financas.add(new Financa(result.getInt(1), result.getString(2), result.getDouble(3)));
            }
            return financas;
        } catch (SQLException ex) {
            Logger.getLogger(DaoFinanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
