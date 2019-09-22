/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelVO.Agencia_bancaria;

/**
 *
 * @author Flavio
 */
public class DaoAgencia {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Agencia_bancaria agencia){return true;}
    public Agencia_bancaria buscarId(int id){return null;}
    public List<Agencia_bancaria> getAll(){return null;}
    public boolean editar(Agencia_bancaria assento,Agencia_bancaria assento_novo){return true;}
    public boolean remover(int id){return true;}
}
