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
import modelVO.Pagamento;

/**
 *
 * @author Flavio
 */
public class DaoPagamento {
     private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Pagamento pagamento){return true;}
    public Pagamento buscarId(int id){return null;}
    public List<Pagamento> getAll(){return null;}
    public boolean editar(Pagamento assento,Pagamento assento_novo){return true;}
    public boolean remover(int id){return true;}
}
