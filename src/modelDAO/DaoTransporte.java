/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import fachada.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private DaoTipo_transporte tipoDao;
    private DaoMotorista motoristaDao;
    private DaoDestino destinoDao;
    private DaoAssento assentoDao;
    public DaoTransporte() {
        this.tipoDao = new DaoTipo_transporte();
        this.motoristaDao = new DaoMotorista();
        this.destinoDao = new DaoDestino();
        this.assentoDao = new DaoAssento();
    }
    
    public boolean salvar(Transporte transporte){
        this.conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
        try {
            
            statement = conexao.prepareStatement(SQLUtil.Transporte.INSERT_ALL);
            statement.setString(1, transporte.getCor());
            statement.setString(2, transporte.getPlaca());
            statement.setString(3, transporte.getChassi());
            statement.setInt(4, transporte.getMotorista().getId());
            statement.setInt(5, transporte.getTipo().getId());
            statement.setInt(6, transporte.getDestino().getId());
            statement.execute();
            conexao.close();
            relacionar_veiculo_assento(buscarId(buscar_prox_id()));
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
    
     public boolean verificarPlaca(String placa){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Transporte.VERIFICAR_PLACA);
            statement.setString(1, placa);
            result = statement.executeQuery();
            conexao.close();
            if(result.next()){
                if(result.getInt(1)==0){
                    return true;
                }else{
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
     public boolean verificarChassi(String chassi){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Transporte.VERIFICAR_CHASSI);
            statement.setString(1, chassi);
            result = statement.executeQuery();
            conexao.close();
            if(result.next()){
                if(result.getInt(1)==0){
                    return true;
                }else{
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public int buscar_prox_id(){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Transporte.BUSCAR_PROX_ID);
            result = statement.executeQuery();
            if(result.next()){
                return (result.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    
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
            conexao.close();
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
     public Transporte buscarId(int id){
        Transporte transporte = new Transporte();
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Transporte.BUSCAR_ID);
            statement.setInt(1, id);
            result = statement.executeQuery();
            conexao.close();
            if(result.next()){
                transporte.setId(result.getInt(1));
                transporte.setCor(result.getString(2));
                transporte.setPlaca(result.getString(3));
                transporte.setChassi(result.getString(4));
                transporte.setMotorista(new DaoMotorista().buscarId(result.getInt(5)));
                transporte.setTipo(tipoDao.buscarId(result.getInt(6)));
                return transporte;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return transporte;
    }
    
    public List<Transporte> getAll(){
        List<Transporte> transportes = new ArrayList<>();
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Transporte.BUSCAR_ALL);
            result = statement.executeQuery();
            conexao.close();
            while(result.next()){
                transportes.add(new Transporte(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), motoristaDao.buscarId(result.getInt(5)), tipoDao.buscarId(result.getInt(6)), destinoDao.buscarId(result.getInt(7)),result.getString(8)));
            }
            return transportes;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean remover(int id,String placa){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Transporte.REMOVER_PLACA);
            statement.setInt(1,id);
            statement.setString(2,placa);
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Transporte> buscarLike(String nome,String busca){
        List<Transporte> transportes = new ArrayList<>();
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(busca);
            statement.setString(1, nome+"%");
            result = statement.executeQuery();
            conexao.close();
            
            while(result.next()){
                transportes.add(new Transporte(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), motoristaDao.buscarId(result.getInt(5)), tipoDao.buscarId(result.getInt(6)), destinoDao.buscarId(result.getInt(7)),result.getString(8)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transportes;
    }
    
    public void adicionarVeiculo_assento(Transporte transporte,int assento){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Assento.ADICIONAR_TRANSPORTE_ASSENTO);
            statement.setInt(1, transporte.getId());
            statement.setInt(2, assento);
            statement.execute();
            conexao.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void relacionar_veiculo_assento(Transporte transporte){
        List<Integer> assentos = new ArrayList<>();
        int quant = transporte.getTipo().getAssentos(); 
        
        for(int i=0;i<quant;i++){
            assentos.add(assentoDao.buscarNumeroId(i+1));
        }
        for(Integer id:assentos){
            adicionarVeiculo_assento(transporte, id);
        }
    }
    public boolean editar(Transporte transporte,int id){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Transporte.EDITAR);
            statement.setString(1, transporte.getCor());
            statement.setString(3, transporte.getChassi());
            statement.setString(2, transporte.getPlaca());
            
            statement.setInt(4, id);
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean alterarStatus(int id,String status){
        conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
        try {
            statement = conexao.prepareStatement(SQLUtil.Transporte.ALTERAR_STATUS);
            statement.setString(1, status);
            statement.setInt(2, id);
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
}
