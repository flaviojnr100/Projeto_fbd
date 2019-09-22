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
import modelVO.Motorista;
import sql.SQLConexao;
import sql.SQLUtil;

/**
 *
 * @author Flavio
 */
public class DaoRodoviaria {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    public boolean salvar(Motorista motorista){
       return true;
    }
    public Motorista buscarCpf(String cpf){
       return null;
    }
    public boolean editar(Motorista motorista, Motorista motorista_atualizado){
      return true;
    }
    public List<Motorista> getAll(){
       return null;
    }
    public boolean remover(String cpf){
      return true;
    }
    public boolean verificarExistencia(String cpf){
        return true;
    }
}
