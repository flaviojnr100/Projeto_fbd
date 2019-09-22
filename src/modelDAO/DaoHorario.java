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
import modelVO.Horario;

/**
 *
 * @author Flavio
 */
public class DaoHorario {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Horario horario){return true;}
    public Horario buscarId(int id){return null;}
    public List<Horario> getAll(){return null;}
    public boolean editar(Horario horario,Horario horario_novo){return true;}
    public boolean remover(int id){return true;}
}
