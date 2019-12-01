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
import modelVO.Passageiro;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoPassageiro {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Passageiro passageiro){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Passageiro.INSERT_ALL);
            statement.setString(1, passageiro.getNome());
            statement.setString(2, passageiro.getSobrenome());
            statement.setString(3, passageiro.getCpf());
            statement.setString(4, passageiro.getStatus());
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPassageiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public Passageiro buscarCpf(String cpf){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Passageiro.BUSCAR_CPF);
            statement.setString(1, cpf);
            result = statement.executeQuery();
            conexao.close();
            if(result.next()){
                return new Passageiro(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),result.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPassageiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Passageiro buscarId(int id){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Passageiro.BUSCAR_ID);
            statement.setInt(1, id);
            result = statement.executeQuery();
            conexao.close();
            if(result.next()){
                return new Passageiro(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),result.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPassageiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Passageiro> getAll(){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Passageiro.BUSCAR_ALL);
            List<Passageiro> passageiros = new ArrayList<>();
            result = statement.executeQuery();
            conexao.close();
            while(result.next()){
                passageiros.add(new Passageiro(result.getInt(1), result.getString(2), result.getString(3),result.getString(4),result.getString(5)));
            }
            return passageiros;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoPassageiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean editar(Passageiro passageiro,Passageiro passageiro_novo){
    
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Passageiro.EDITAR_CPF);
            statement.setString(1, passageiro_novo.getNome());
            statement.setString(2, passageiro_novo.getSobrenome());
            statement.setString(3, passageiro_novo.getCpf());
            statement.setInt(4, passageiro.getId());
            statement.setString(5, passageiro.getCpf());
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPassageiro.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        return false;
    }
   
    public void mudarStatus(int id,String status){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(status);
            statement.setInt(1, id);
            statement.execute();
            conexao.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoPassageiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Passageiro> buscarLike(String nome,String busca){
        List<Passageiro> passageiros = new ArrayList<>();
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(busca);
            statement.setString(1, nome+"%");
            result = statement.executeQuery();
            conexao.close();
            while(result.next()){
                passageiros.add(new Passageiro(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),result.getString(5)));
            }
            return passageiros;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPassageiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Passageiro> buscarLikeBilhete(int nome,String busca){
        List<Passageiro> passageiros = new ArrayList<>();
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(busca);
            statement.setInt(1, nome);
            result = statement.executeQuery();
            conexao.close();
            while(result.next()){
                passageiros.add(new Passageiro(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),result.getString(5)));
            }
            return passageiros;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPassageiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean verificarCpf(String cpf){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Passageiro.VERIFICARCPF);
            statement.setString(1, cpf);
            result = statement.executeQuery();
            conexao.close();
            if(result.next()){
                if(result.getInt(1)>0){
                    return false;
                }else{
                    return true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoPassageiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
}
