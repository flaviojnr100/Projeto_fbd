/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoBilhete;
import modelVO.Bilhete;

/**
 *
 * @author Flavio
 */
public class BusinessBilhete {
    private DaoBilhete dao;

    public BusinessBilhete() {
        this.dao = new DaoBilhete();
    }
    public boolean salvar(Bilhete bilhete){
        return dao.salvar(bilhete);
    }
    public Bilhete buscarId(int id){
        return dao.buscarId(id);
    }
    public List<Bilhete> getAll(){
        return dao.getAll();
    }
    public boolean remover(int id){
        return dao.remover(id);
    }
    public boolean editar(Bilhete bilhete,Bilhete bilhete_novo){
        return dao.editar(bilhete, bilhete_novo);
    }
    
    
    
}
