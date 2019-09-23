/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoHorario;
import modelVO.Horario;

/**
 *
 * @author Flavio
 */
public class BusinessHorario {
    private DaoHorario dao;

    public BusinessHorario() {
        this.dao = new DaoHorario();
    }
    public boolean salvar(Horario horario){
        return dao.salvar(horario);
    }
    public Horario buscarId(int id){
        return dao.buscarId(id);
    }
    public List<Horario> getAll(){
        return dao.getAll();
    }
    public boolean remover(int id){
        return dao.remover(id);
    }
    public boolean editar(Horario horario,Horario horario_novo){
        return dao.editar(horario, horario_novo);
    }
    
    
}
