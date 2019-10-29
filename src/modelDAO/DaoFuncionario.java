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
import modelVO.Funcionario;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoFuncionario {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Funcionario funcionario){
       
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Funcionario.INSERT_ALL);
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getSobrenome());
            statement.setString(3, funcionario.getRg());
            statement.setString(4, funcionario.getCpf());
            statement.setString(5, funcionario.getData_nascimento());
            statement.setString(6, funcionario.getLogin());
            statement.setString(7, funcionario.getSenha());
            statement.execute();
            conexao.close();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    
    }
    public Funcionario buscarCpf(String cpf){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Funcionario.BUSCAR_CPF);
            statement.setString(1, cpf);
            result = statement.executeQuery();
            if(result.next()){
                return new Funcionario(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Funcionario> getAll(){
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Funcionario.BUSCAR_ALL);
            result = statement.executeQuery();
            conexao.close();
            while(result.next()){
                funcionarios.add(new Funcionario(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getString(8)));
            }
            conexao.close();
            return funcionarios;
        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean editar(Funcionario funcionario,Funcionario funcionario_novo){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Funcionario.EDITAR_CPF);
            statement.setString(1, funcionario_novo.getNome());
            statement.setString(2, funcionario_novo.getSobrenome());
            statement.setString(3, funcionario_novo.getRg());
            statement.setString(4, funcionario_novo.getCpf());
            statement.setString(5, funcionario_novo.getData_nascimento());
            statement.setString(6, funcionario_novo.getLogin());
            statement.setString(7, funcionario_novo.getSenha());
            statement.setInt(8, funcionario.getId());
            statement.setString(9, funcionario.getCpf());
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }
    public boolean removerCpf(String cpf){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Funcionario.REMOVER_CPF);
            statement.setString(1, cpf);
            statement.execute();
            conexao.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public List<Funcionario> buscarLike(String nome,String busca){
        List<Funcionario> funcionario= new ArrayList<>();
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(busca);
            statement.setString(1, nome+"%");
            result = statement.executeQuery();
            conexao.close();
            while(result.next()){
                funcionario.add(new Funcionario(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getString(8)));
            }
            return funcionario;
        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public boolean verificarCpf(String cpf){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Funcionario.VERIFICARCPF);
            statement.setString(1, cpf);
            result = statement.executeQuery();
            if(result.next()){
                if(result.getInt(1)==0){
                    return true;
                }else{
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

   
}
