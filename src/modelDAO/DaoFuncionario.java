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
import modelVO.Funcionario;

/**
 *
 * @author Flavio
 */
public class DaoFuncionario {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Funcionario funcionario){return true;}
    public Funcionario buscarCpf(String cpf){return null;}
    public List<Funcionario> getAll(){return null;}
    public boolean editar(Funcionario funcionario,Funcionario funcionario_novo){return true;}
    public boolean removerCpf(String cpf){return true;}
}
