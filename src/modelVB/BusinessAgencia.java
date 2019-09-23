/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoAgencia;
import modelVO.Agencia_bancaria;

/**
 *
 * @author Flavio
 */
public class BusinessAgencia {
    private DaoAgencia dao;

    public BusinessAgencia() {
        this.dao = new DaoAgencia();
    }
    
    public boolean salvar(Agencia_bancaria agencia){
        return dao.salvar(agencia);
        }
    public boolean remover(int id){
        return dao.remover(id);
    }
    public boolean editar(Agencia_bancaria agencia,Agencia_bancaria agencia_novo){
        return dao.editar(agencia, agencia_novo);
    }
    public List<Agencia_bancaria> getAll(){
        return dao.getAll();
    }
    public Agencia_bancaria buscarId(int id){
        return dao.buscarId(id);
    }
    
    
}
