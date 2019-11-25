/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoPassageiro;
import modelVO.Passageiro;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class BusinessPassageiro {
    private DaoPassageiro dao;

    public BusinessPassageiro() {
        this.dao = new DaoPassageiro();
    }
    public boolean salvar(Passageiro passageiro){
        if(dao.verificarCpf(passageiro.getCpf())){
            return dao.salvar(passageiro);
        }else{
            Mensagens.mensagem("Esse passageiro ja foi cadastrado!");
            return false;
        }
               
    }
    public Passageiro buscarCpf(String cpf){
        return dao.buscarCpf(cpf);
    }
    public List<Passageiro> getAll(){
        
        return dao.getAll();
    }
    public boolean editar(Passageiro passageiro,Passageiro passageiro_novo){
        if(passageiro.getCpf().equals(passageiro_novo.getCpf()) || dao.buscarCpf(passageiro_novo.getCpf())==null){
            return dao.editar(passageiro, passageiro_novo);
        }
        return false;
    }
    
    public List<Passageiro> buscaLike(String nome,String busca){
        return dao.buscarLike(nome, busca);
    }
   public void mudarStatus(int id,String status){
       dao.mudarStatus(id, status);
   }
    
}
