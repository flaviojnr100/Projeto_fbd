/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoFinanca;
import modelVO.Financa;

/**
 *
 * @author Flavio
 */
public class BusinessFinanca {
    private DaoFinanca dao;

    public BusinessFinanca() {
        this.dao = new DaoFinanca();
    }
    
    public boolean salvar(Financa financa){
        Financa financa1 = dao.buscar_data(financa.getData());
        if(financa1 != null){
            financa1.setValor(financa1.getValor()+financa.getValor());
            return dao.adicionar_financa(financa1,financa1.getId());
        }
        
        return dao.salvar(financa);
    }
    public List<Financa> getAll(){
        return dao.getAll();
    }
    public Financa buscar_data(String data){
        return dao.buscar_data(data);
    }
    public boolean alterar_financa(Financa financa,double valor,String status){
        if(status.equals("ATIVO")){
            financa.setValor(financa.getValor()+valor);
        }else{
            financa.setValor(financa.getValor()-valor);
        }
        return dao.alterar_financa(financa);
    }
    public List<Financa> buscaLike(String texto){
        return dao.buscaLike(texto);
    }
    
}
