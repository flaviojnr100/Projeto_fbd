/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoTipoPagamento;
import modelVO.Tipo_pagamento;

/**
 *
 * @author Flavio
 */
public class BusinessTipoPagamento {
    private DaoTipoPagamento dao;

    public BusinessTipoPagamento() {
        this.dao = new DaoTipoPagamento();
    }
    
    public boolean salvar(Tipo_pagamento tipo){
        return dao.salvar(tipo);
    }
    public Tipo_pagamento buscarId(int id){
        return dao.buscarId(id);
    }
    public boolean remover(int id){
        return dao.remover(id);
    }
    public List<Tipo_pagamento> getAll(){
        return dao.getAll();
    }
    public boolean editar(Tipo_pagamento tipo,Tipo_pagamento tipo_novo){
        return dao.editar(tipo, tipo_novo);
    }
    
    
    
}
