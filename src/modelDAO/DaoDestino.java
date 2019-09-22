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
    public DaoDestino() {
        
    }
    public boolean salvar(Destino destino){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Destino.INSERT_ALL);
            statement.setString(1, destino.getNome());
            statement.setInt(2, destino.getEndereco().getId());
            statement.execute();
            conexao.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoDestino.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public Destino buscarId(int id){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Destino.BUSCAR_ID);
            statement.setInt(1, id);
            
            result = statement.executeQuery();
            Destino destino;
            if(result.next()){
                destino = new Destino();
                destino.setId(result.getInt(1));
                destino.setNome(result.getString(2));
                destino.setEndereco(new DaoEndereco().buscarId(result.getInt(3)));
                conexao.close();
                return destino;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoDestino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
