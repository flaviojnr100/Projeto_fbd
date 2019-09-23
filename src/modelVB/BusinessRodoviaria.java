/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoRodoviaria;
import modelVO.Rodoviaria;

/**
 *
 * @author Flavio
 */
public class BusinessRodoviaria {
    private DaoRodoviaria dao;

    public BusinessRodoviaria() {
        this.dao = new DaoRodoviaria();
    }
    
    public boolean salvar(Rodoviaria rodoviaria){
        return dao.salvar(rodoviaria);
    }
    public Rodoviaria buscarId(int id){
        return dao.buscarId(id);
    }
    public List<Rodoviaria> getAll(){
        return dao.getAll();
    }
    public boolean editar(Rodoviaria rodoviaria, Rodoviaria rodoviaria_novo){
        return dao.editar(rodoviaria, rodoviaria_novo);
    }
    public boolean remover(int id){
        return dao.remover(id);
    }
    
    
}
