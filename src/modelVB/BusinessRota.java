/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoDestino;
import modelVO.Destino;

/**
 *
 * @author Flavio
 */
public class BusinessRota {
    private DaoDestino dao;

    public BusinessRota() {
        this.dao = new DaoDestino();
    }
    public boolean salvar(Destino destino){
        return dao.salvar(destino);
    }
    public List<Destino> getAll(){
        return dao.getAll();
    }
    public Destino buscarId(int id){
        return dao.buscarId(id);
    }
    public boolean editar(int id,Destino destino){
        return dao.editar(id, destino);
    }
    public boolean removerId(int id){
        return dao.removerId(id);
    }
     public List<Destino> buscaLike(String nome,String busca){
         return dao.buscaLike(nome, busca);
     }
     public boolean alterarStatus(int id,String status){
         return dao.alterarStatus(id, status);
     }
}
