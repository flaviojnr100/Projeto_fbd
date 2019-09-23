/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoPagamento;
import modelVO.Pagamento;
/**
 *
 * @author Flavio
 */
public class BusinessPagamento {
    private DaoPagamento dao;

    public BusinessPagamento() {
        this.dao = new DaoPagamento();
    }
    
    public boolean salvar(Pagamento pagamento){
        return dao.salvar(pagamento);
    }
    public Pagamento buscarId(int id){
        return dao.buscarId(id);
    }
    public List<Pagamento> getAll(){
        return dao.getAll();
    }
    public boolean remover(int id){
        return dao.remover(id);
    }
    public boolean editar(Pagamento pagamento,Pagamento pagamento_novo){
        return dao.editar(pagamento, pagamento_novo);
    }
    
    
    
}
