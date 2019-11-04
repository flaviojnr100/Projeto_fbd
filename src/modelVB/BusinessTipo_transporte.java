/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoTipo_transporte;
import modelVO.Tipo_transporte;

/**
 *
 * @author Flavio
 */
public class BusinessTipo_transporte {
    private DaoTipo_transporte dao;

    public BusinessTipo_transporte() {
        this.dao = new DaoTipo_transporte();
    }
    public boolean salvar(Tipo_transporte tipo){
        return dao.salvar(tipo);
    }
    public List<Tipo_transporte> getAll(){
        return dao.getAll();
    }
    public Tipo_transporte buscarId(int id){
        return dao.buscarId(id);
    }
    
}
