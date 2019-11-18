/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoViagem;
import modelVO.Viagem;

/**
 *
 * @author Flavio
 */
public class BusinessViagem {
    private DaoViagem dao;

    public BusinessViagem() {
        this.dao = new DaoViagem();
    }
    
    public boolean salvar(Viagem viagem){
        return dao.salvar(viagem);
    }
    public List<Viagem> getAll(){
        return dao.getAll();
    }
    
}
