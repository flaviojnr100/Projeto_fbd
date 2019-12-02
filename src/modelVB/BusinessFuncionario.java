/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoFuncionario;
import modelVO.Funcionario;

/**
 *
 * @author Flavio
 */
public class BusinessFuncionario {
    private DaoFuncionario dao;

    public BusinessFuncionario() {
        this.dao = new DaoFuncionario();
    }
    public boolean salvar(Funcionario funcionario){
        if(verificarCpf(funcionario.getCpf())){
            this.dao.salvar(funcionario);
            return true;
        }
        return false;
        
    
    }
    public Funcionario buscarCpf(String cpf){
        return dao.buscarCpf(cpf);
    }
    public Funcionario buscarLogin(String login,String senha){
        return dao.buscarLogin(login, senha);
    }
    public List<Funcionario> getAll(){
        return dao.getAll();
        
    }
    public boolean editar(Funcionario funcionario,Funcionario funcionario_novo){
        return dao.editar(funcionario, funcionario_novo);
    }
    public boolean removerCpf(String cpf){
        return dao.removerCpf(cpf);
        
    }
    public List<Funcionario> buscarLike(String nome,String busca){
         return dao.buscarLike(nome, busca);
    }
    
    public boolean verificarCpf(String cpf){
        return dao.verificarCpf(cpf);
    }
     public boolean autenticar(Funcionario funcionario){
         return dao.autenticar(funcionario);
     }
     
   public boolean alterarStatus(String cpf,String status){
       return dao.alterarStatus(cpf, status);
   }
   
}
