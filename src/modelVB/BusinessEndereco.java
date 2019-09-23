/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import modelDAO.DaoEndereco;
import modelVO.Endereco;

/**
 *
 * @author Flavio
 */
public class BusinessEndereco {
    private DaoEndereco dao;

    public BusinessEndereco() {
        this.dao = new DaoEndereco();
    }
    
    public boolean salvar(Endereco endereco){
        return dao.salvar(endereco);
    }
    public Endereco buscarId(int id){
        return dao.buscarId(id);
    }
    
    
    
}
