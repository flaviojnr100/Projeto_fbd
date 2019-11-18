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
import modelVO.Destino;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoDestino {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    private DaoEndereco enderecoDao;
    public DaoDestino() {
        enderecoDao = new DaoEndereco();
    }
    
    public boolean salvar(Destino destino){
        
        try {
            if(enderecoDao.verificarExistencia(destino.getPartida())){
                enderecoDao.salvar(destino.getPartida());
                destino.getPartida().setId(enderecoDao.retornar_id(destino.getPartida()));
            }else{
                destino.getPartida().setId(enderecoDao.retornar_id(destino.getPartida()));
            }
            
            if(enderecoDao.verificarExistencia(destino.getDestino())){
                enderecoDao.salvar(destino.getDestino());
                destino.getDestino().setId(enderecoDao.retornar_id(destino.getDestino()));
            }else{
                destino.getDestino().setId(enderecoDao.retornar_id(destino.getDestino()));
            }
            
            
            
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Destino.INSERT_ALL);
            statement.setString(1, destino.getNome());
            statement.setInt(2, destino.getPartida().getId());
            statement.setString(3, destino.getHorario());
            statement.setInt(4, destino.getDestino().getId());
            statement.setString(5, destino.getPreco());
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoDestino.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return false;
    }
    
    public Destino buscarId(int id){
       
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Destino.BUSCAR_ID);
            statement.setInt(1, id);
            result = statement.executeQuery();
             conexao.close();
            if(result.next()){
                return new Destino(result.getInt(1), result.getString(2), enderecoDao.buscarId(result.getInt(3)), enderecoDao.buscarId(result.getInt(5)), result.getString(4),result.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoDestino.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
    
    public List<Destino> getAll(){
        List<Destino> destinos = new ArrayList<>();
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Destino.BUSCAR_ALL);
            result = statement.executeQuery();
            
            while(result.next()){
                
                destinos.add(new Destino(result.getInt(1), result.getString(2), enderecoDao.buscarId(result.getInt(3)), enderecoDao.buscarId(result.getInt(5)), result.getString(4), result.getString(6)));
            }
            conexao.close();
            return destinos;
        } catch (SQLException ex) {
            Logger.getLogger(DaoDestino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return destinos;
    }
    
    public List<Destino> buscaLike(String nome,String busca){
        List<Destino> destinos = new ArrayList<>();
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(busca);
            statement.setString(1, nome+"%");
            result = statement.executeQuery();
            
            while(result.next()){
                
                destinos.add(new Destino(result.getInt(1), result.getString(2), enderecoDao.buscarId(result.getInt(3)), enderecoDao.buscarId(result.getInt(5)), result.getString(4), result.getString(6)));
            }
            conexao.close();
            return destinos;
        } catch (SQLException ex) {
            Logger.getLogger(DaoDestino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return destinos;
    }
   
   public boolean editar(int id,Destino destino){
       
        try {
            if(enderecoDao.verificarExistencia(destino.getPartida())){
                enderecoDao.salvar(destino.getPartida());
                destino.getPartida().setId(enderecoDao.retornar_id(destino.getPartida()));
            }else{
                destino.getPartida().setId(enderecoDao.retornar_id(destino.getPartida()));
            }
            
            if(enderecoDao.verificarExistencia(destino.getDestino())){
                enderecoDao.salvar(destino.getDestino());
                destino.getDestino().setId(enderecoDao.retornar_id(destino.getDestino()));
            }else{
                destino.getDestino().setId(enderecoDao.retornar_id(destino.getDestino()));
            }
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Destino.EDITAR);
            statement.setString(1, destino.getNome());
            statement.setInt(2, destino.getPartida().getId());
            statement.setString(3, destino.getHorario());
            statement.setInt(4, destino.getDestino().getId());
            statement.setString(5, destino.getPreco());
            statement.setInt(6, id);
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoDestino.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return false;
   }
   public boolean removerId(int id){
       
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Destino.REMOVE_ID);
            statement.setInt(1, id);
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoDestino.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
   }
    
}
