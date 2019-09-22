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
import modelVO.Assento;

/**
 *
 * @author Flavio
 */
public class DaoAssento {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Assento assento){return true;}
    public Assento buscarNumero(int numero){return null;}
    public List<Assento> getAll(){return null;}
    public boolean editar(Assento assento,Assento assento_novo){return true;}
    public boolean remover(int numero){return true;}
            
}
