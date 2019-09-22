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
import modelVO.Bilhete;

/**
 *
 * @author Flavio
 */
public class DaoBilhete {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Bilhete bilhete){return true;}
    public boolean remover(int id){return true;}
    public boolean editar(Bilhete bilhete,Bilhete bilhete_atualizado){return true;}
    public Bilhete buscarId(int id){return null;}
    public List<Bilhete> getAll(){return null;}
}
