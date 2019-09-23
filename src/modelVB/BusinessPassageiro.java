/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import modelDAO.DaoPassageiro;
import modelVO.Passageiro;
import java.util.List;
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
        return dao.salvar(passageiro);
    }
    
    public boolean removerCpf(String cpf){
        return dao.removerCpf(cpf);
    }
    
    public boolean editar(Passageiro passageiro,Passageiro passageiro_novo){
        return dao.editar(passageiro, passageiro_novo);
    }
    public Passageiro buscarCpf(String cpf){
        return dao.buscarCpf(cpf);
    }
    
    public List<Passageiro> getAll(){
        return dao.getAll();
    }
    
    
}
