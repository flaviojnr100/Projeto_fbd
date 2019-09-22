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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelVO.Motorista;
import modelVO.Transporte;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoTransporte {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    public boolean salvar(Transporte transporte){
        this.conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
        try {
            statement = conexao.prepareStatement(SQLUtil.Transporte.INSERT_ALL);
            statement.setString(1, transporte.getCor());
            statement.setString(2, transporte.getPlaca());
            statement.setString(3, transporte.getChassi());
            statement.setString(4, transporte.getMotorista().getId()+"");
            statement.setString(5, transporte.getTipo().getId()+"");
            statement.setString(6,transporte.getDestino().getEndereco().getId()+"");
            
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        }
    
    public boolean salvar2(Transporte transporte){
        this.conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
        try {
            statement = conexao.prepareStatement(SQLUtil.Transporte.INSERT);
            statement.setString(1, transporte.getCor());
            statement.setString(2, transporte.getPlaca());
            statement.setString(3, transporte.getChassi());
            
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        }
    public boolean editar(Transporte transporte){return true;}
    public Transporte buscarPlaca(String placa){
        Transporte transporte = null;
        return transporte;
    }
    public Transporte buscarChassi(String chassi){
        Transporte transporte = new Transporte();
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Transporte.BUSCAR_CHASSI);
            statement.setString(1, chassi);
            result = statement.executeQuery();
            if(result.next()){
                transporte.setId(result.getInt(1));
                transporte.setCor(result.getString(2));
                transporte.setPlaca(result.getString(3));
                transporte.setChassi(result.getString(4));
                transporte.setMotorista(new DaoMotorista().buscarId(result.getInt(5)));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return transporte;
    }
    public List<Transporte> getAll(){
        return null;
    }
    public boolean remover(String placa){return true;}
    
}