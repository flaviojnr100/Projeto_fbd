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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelVO.Assento;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoAssento {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Assento assento){
        conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Assento.INSERT_ALL);
            statement.setInt(1, assento.getNumero());
            statement.setString(2, assento.getEstado_ocupacao());
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAssento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public Assento buscarNumero(int numero){
        conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Assento.BUSCAR_NUMERO);
            statement.setInt(1, numero);
            result = statement.executeQuery();
            if(result.next()){
                return new Assento(result.getInt(1), result.getInt(2), result.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAssento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int buscarNumeroId(int numero){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Assento.BUSCAR_NUMERO_ID);
            statement.setInt(1, numero);
            result = statement.executeQuery();
            if(result.next()){
                return result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAssento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
     public int buscarIdTransporteAssento(int id_transporte,int id_assento){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Assento.BUSCAR_ID_TRANSPORTE_ASSENTO);
            statement.setInt(1, id_transporte);
            statement.setInt(2, id_assento);
            result = statement.executeQuery();
            if(result.next()){
                return result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAssento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int buscarLivre(String placa){
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Assento.BUSCAR_LIVRE);
            statement.setString(1, placa);
            result = statement.executeQuery();
            if(result.next()){
                return result.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoAssento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public List<Assento> buscarLivreVaga(int id){
        List<Assento> livres = new ArrayList<>();
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Assento.BUSCAR_LIVRE_ASSENTO);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while(result.next()){
                livres.add(new Assento(result.getInt(1), result.getInt(2), "vazio"));
            }
            return livres;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAssento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livres;
    }
    
    public List<Assento> getAll(){
        List<Assento> assentos = new ArrayList<>();
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Assento.BUSCAR_ALL);
            result = statement.executeQuery();
            while(result.next()){
                assentos.add(new Assento(result.getInt(1), result.getInt(2), result.getString(3)));
            }
            return assentos;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoAssento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assentos;
    }
    public boolean editar(Assento assento,Assento assento_novo){return true;}
    public boolean remover(int numero){return true;}
    
     public boolean adicionarPassageiroAssento(int id_assento, int id_passageiro){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Assento.ADICIONAR_PASSAGEIRO_ASSENTO);
            statement.setInt(1, id_passageiro);
            statement.setInt(2, id_assento);
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public boolean removerPassageiroAssento(int id_transporte,int id_assento){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Assento.ADICIONAR_PASSAGEIRO_ASSENTO);
            statement.setNull(1, Types.INTEGER);
            statement.setInt(2, id_transporte);
            statement.setInt(3, id_assento);
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
