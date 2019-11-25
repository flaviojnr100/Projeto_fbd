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
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyValue;
import modelVO.Acesso;
import modelVO.Funcionario;
import sql.SQLConexao;
import sql.SQLUtil;


/**
 *
 * @author Flavio
 */
public class DaoAcesso {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    private DaoFuncionario funcionarioDao;

    public DaoAcesso() {
        funcionarioDao = new DaoFuncionario();
    }
    
    public boolean Salvar(Funcionario funcionario,String horario,String data){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Acesso.SALVAR_ACESSO);
            statement.setInt(1,funcionario.getId());
            statement.setString(2,horario);
            statement.setString(3,data);
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Acesso> getAll(){
        List<Acesso> acessos = new ArrayList<>();
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Acesso.BUSCAR_ALL);
            result = statement.executeQuery();
            conexao.close();
            while(result.next()){
                
                Acesso ac = new Acesso(result.getInt(1), new Funcionario(result.getString(2)), result.getString(3), result.getString(4)); 
                
                acessos.add(ac);
            }
            return acessos;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Acesso> buscaLike(String nome,String sql){
        List<Acesso> acessos = new ArrayList<>();
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(sql);
            statement.setString(1, nome+"%");
            result = statement.executeQuery();
            conexao.close();
            while(result.next()){
                
                Acesso ac = new Acesso(result.getInt(1), new Funcionario(result.getString(2)), result.getString(3), result.getString(4)); 
                
                acessos.add(ac);
            }
            return acessos;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
}
