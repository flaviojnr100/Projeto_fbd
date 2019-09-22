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
    
    public boolean salvar(Tipo_transporte t_transporte){
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Tipo_transporte.INSERT_ALL);
            statement.setString(1, t_transporte.getNome());
            statement.setInt(2, t_transporte.getAssentos());
            statement.setInt(3, t_transporte.getEmpresa().getId());
            statement.execute();
            conexao.close();
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
            Tipo_transporte t_transporte =null;
            if(result.next()){
                t_transporte = new Tipo_transporte();
                t_transporte.setId(result.getInt(1));
                t_transporte.setNome(result.getString(2));
                t_transporte.setAssentos(result.getInt(3));
                t_transporte.setEmpresa(new DaoEmpresa().buscarId(result.getInt(4)));
                
                conexao.close();
                return t_transporte;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipo_transporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
