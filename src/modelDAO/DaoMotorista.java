/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelVO.Motorista;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoMotorista {
    
    private Connection conexao;
    private PreparedStatement statement;
    
    public boolean salvar(Motorista motorista){
       
        try {
            this.conexao = SQLConexao.getConnectionInstance(SQLConexao.BD_CONEXAO);
            this.statement = conexao.prepareStatement(SQLUtil.Motorista.INSERT_ALL);
            statement.setString(1, motorista.getNome());
            statement.setString(2, motorista.getSobrenome());
            statement.setString(3, motorista.getRg());
            statement.setString(4, motorista.getCpf());
            statement.setString(5, motorista.getData_nascimento());
            statement.setString(6, motorista.getCnh());
            
            statement.execute();
            this.conexao.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
       return true;
    }
    public Motorista buscarCpf(String cpf){
        Motorista motorista = null;
        return motorista;
    }
    public boolean editar(Motorista motorista){return true;}
    public List<Motorista> getAll(){
    List<Motorista> motoristas = new ArrayList<>();
    return motoristas;
    }
    public boolean remover(String cpf){return true;}
    public boolean verificarExistencia(String cpf){return true;}
    
}
