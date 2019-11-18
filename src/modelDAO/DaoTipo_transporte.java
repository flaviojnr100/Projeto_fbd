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
import modelVO.Assento;
import modelVO.Tipo_transporte;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoTipo_transporte {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    private DaoAssento assentoDao = new DaoAssento();
    public boolean salvar(Tipo_transporte t_transporte){
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Tipo_transporte.INSERT_ALL);
            statement.setString(1, t_transporte.getNome());
            statement.setInt(2, t_transporte.getAssentos());
            
            statement.execute();
            conexao.close();
            adicionarAssentos(t_transporte.getAssentos());
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipo_transporte.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Tipo_transporte buscarId(int id){
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Tipo_transporte.BUSCAR_ID);
            statement.setInt(1, id);
            result = statement.executeQuery();
            conexao.close();
            if(result.next()){
                return new Tipo_transporte(result.getInt(1), result.getString(2),result.getInt(3));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipo_transporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Tipo_transporte> getAll(){
        List<Tipo_transporte> transportes = new ArrayList<>();
        
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Tipo_transporte.BUSCAR_ALL);
            result = statement.executeQuery();
            while(result.next()){
                transportes.add(new Tipo_transporte(result.getInt(1), result.getString(2), result.getInt(3)));
            }
            conexao.close();
            return transportes;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipo_transporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void adicionarAssentos(int numero){
        int i=0;
        List<Assento> assentos = new ArrayList<>();
        while(i<numero){
            assentos.add(new Assento(i+1));
            i++;
        }
        for(Assento a:assentos){
            if(assentoDao.buscarNumero(a.getNumero())==null){
                assentoDao.salvar(a);
            }
        }
    }
   
}
