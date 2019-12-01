/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.ArrayList;
import java.util.List;
import modelDAO.DaoAssento;
import modelVO.Assento;

/**
 *
 * @author Flavio
 */
public class BusinessAssento {
    private DaoAssento dao;

    public BusinessAssento() {
        this.dao = new DaoAssento();
    }
    
     public boolean salvar(Assento assento){
        return dao.salvar(assento);
    }
    public Assento buscarNumero(int numero){
        return dao.buscarNumero(numero);
    }
     public int buscarNumeroId(int numero){
         return dao.buscarNumeroId(numero);
     }
    public int buscarIdTransporteAssento(int id_transporte,int id_assento){
        return dao.buscarIdTransporteAssento(id_transporte, id_assento);
    }
    public List<Assento> getAll(){
        return dao.getAll();
    }
    public List<Assento> buscarLivre(){
        return dao.buscarLivre();
    }
    public List<Assento> buscarLivreVaga(int id){
        return dao.buscarLivreVaga(id);
    }
    public boolean editar(Assento assento,Assento assento_novo){return true;}
    public boolean remover(int numero){return true;}
     public boolean adicionarPassageiroAssento(int id_assento, int id_passageiro){
         return dao.adicionarPassageiroAssento(id_assento, id_passageiro);
     }
     public boolean removerPassageiroAssento(int id_transporte,int id_assento){
         return dao.removerPassageiroAssento(id_transporte, id_assento);
     }
}
