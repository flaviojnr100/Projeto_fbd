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
import modelVO.Passageiro;

/**
 *
 * @author Flavio
 */
public class DaoPassageiro {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Passageiro passageiro){return true;}
    public Passageiro buscarCpf(String cpf){return null;}
    public List<Passageiro> getAll(){return null;}
    public boolean editar(Passageiro passageiro,Passageiro passageiro_novo){return true;}
    public boolean removerCpf(String cpf){return true;}
}
