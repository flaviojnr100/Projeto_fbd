/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modelVO.Motorista;

/**
 *
 * @author Flavio
 */
public class DaoMotorista {
    
    private Connection conexao;
    private PreparedStatement statement;
    
    public boolean salvar(Motorista motorista){
        
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
