/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import Exceções.ExceptionDaoMotorista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelVO.Motorista;

import sql.SQLUtil;
import sql.SQLConexao;
import sun.applet.Main;

/**
 *
 * @author Flavio
 */
public class DaoMotorista {
    
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    public boolean salvar(Motorista motorista){
        try{
        this.conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
        this.statement = conexao.prepareStatement(SQLUtil.Motorista.INSERT_ALL);
       statement.setString(1, motorista.getNome());
       statement.setString(2, motorista.getSobrenome());
       statement.setString(3, motorista.getRg());
       statement.setString(4, motorista.getCpf());
       statement.setString(5, motorista.getData_nascimento());
       statement.setString(6, motorista.getCnh());
       statement.execute();
       conexao.close();
       return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoMotorista.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Motorista buscarCpf(String cpf){
        Motorista motorista = new Motorista();
        try {
            
            this.conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.Motorista.BUSCAR_CPF);
            statement.setString(1, cpf);
            
            result = statement.executeQuery();
            if(result.next()){
                
            motorista.setId(result.getInt(1));
            motorista.setNome(result.getString(2));
            motorista.setSobrenome(result.getString(3));
            motorista.setRg(result.getString(4));
            motorista.setCpf(result.getString(5));
            motorista.setData_nascimento(result.getString(6));
            motorista.setCnh(result.getString(7));
            }
            conexao.close();
            return motorista;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoMotorista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public Motorista buscarId(int id){
        Motorista motorista = new Motorista();
        try {
            
            this.conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.Motorista.BUSCAR_ID);
            statement.setInt(1, id);
            
            result = statement.executeQuery();
            if(result.next()){
                
            motorista.setId(result.getInt(1));
            motorista.setNome(result.getString(2));
            motorista.setSobrenome(result.getString(3));
            motorista.setRg(result.getString(4));
            motorista.setCpf(result.getString(5));
            motorista.setData_nascimento(result.getString(6));
            motorista.setCnh(result.getString(7));
            }
            conexao.close();
            return motorista;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoMotorista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public boolean editar(Motorista motorista, Motorista motorista_atualizado){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Motorista.EDITAR);
            statement.setString(1, motorista_atualizado.getNome());
            statement.setString(2, motorista_atualizado.getSobrenome());
            statement.setString(3, motorista_atualizado.getRg());
            statement.setString(4, motorista_atualizado.getCpf());
            statement.setString(5, motorista_atualizado.getData_nascimento());
            statement.setString(6, motorista_atualizado.getCnh());
            statement.setInt(7, motorista.getId());
            statement.setString(8, motorista.getCpf());
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoMotorista.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    public List<Motorista> getAll(){
        List<Motorista> motoristas = new ArrayList<>();
        
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Motorista.BUSCAR_ALL);
            result = statement.executeQuery();
            while(result.next()){
                Motorista motorista = new Motorista();
                motorista.setId(result.getInt(1));
                motorista.setNome(result.getString(2));
                motorista.setSobrenome(result.getString(3));
                motorista.setRg(result.getString(4));
                motorista.setCpf(result.getString(5));
                motorista.setData_nascimento(result.getString(6));
                motorista.setCnh(result.getString(7));
                motoristas.add(motorista);
                
                motorista = null;
            
            }
            System.gc();
            return motoristas;
        } catch (SQLException ex) {
            Logger.getLogger(DaoMotorista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return motoristas;
    }
    public boolean remover(String cpf){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Motorista.REMOVER_CPF);
            statement.setString(1, cpf);
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoMotorista.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean verificarExistencia(String cpf){
       
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Motorista.VERIFICAREXISTENCIA);
            statement.setString(1, cpf);
            ResultSet r = statement.executeQuery();
            if(r.next()){
            if(r.getInt(1)==0){
                return true;
            }
            return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoMotorista.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       return false;
    }
    
    public List<Motorista> buscarLike(String nome,String busca){
        List<Motorista> motorista= new ArrayList<>();
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(busca);
            statement.setString(1, nome+"%");
            result = statement.executeQuery();
            while(result.next()){
                motorista.add(new Motorista(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),result.getString(5) ,result.getString(6),result.getString(7)));
            }
            return motorista;
        } catch (SQLException ex) {
            Logger.getLogger(DaoMotorista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public static void main(String[] args) {
        DaoMotorista dm = new DaoMotorista();
        List<Motorista> motoristas = dm.buscarLike("55",SQLUtil.Motorista.BUSCARLIKERG);
        for(Motorista m:motoristas){
            System.out.println("RG: "+m.getNome());
        }
    }
    
}
