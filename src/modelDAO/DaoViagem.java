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
import modelVO.Passageiro;
import modelVO.Viagem;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoViagem {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    private DaoPassageiro passageiroDao = new DaoPassageiro();
    private DaoTransporte transporteDao = new DaoTransporte();
    private DaoDestino destinoDao = new DaoDestino();
    public boolean salvar(Viagem viagem){
        
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Viagem.INSERT);
            statement.setInt(1, viagem.getPassageiro().getId());
            statement.setInt(2, viagem.getDestino().getId());
            statement.setInt(3, viagem.getTransporte().getId());
            statement.setString(4, viagem.getPreco());
            statement.execute();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoViagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public List<Viagem> getAll(){
        List<Viagem> viagens = new ArrayList<>();
       
        try {
            conexao = SQLConexao.getConnectionInstance(SQLConexao.NOME_BD_CONNECTION_POSTGRESS);
            statement = conexao.prepareStatement(SQLUtil.Viagem.BUSCAR_ALL);
            result = statement.executeQuery();
            conexao.close();
            while(result.next()){
                viagens.add(new Viagem(result.getInt(1), passageiroDao.buscarId(result.getInt(2)), transporteDao.buscarId(result.getInt(3)), destinoDao.buscarId(result.getInt(4)), result.getString(5)));
            }
            return viagens;
        } catch (SQLException ex) {
            Logger.getLogger(DaoViagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return viagens;
    }
}
