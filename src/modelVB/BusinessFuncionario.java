/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoFuncionario;
import modelVO.Funcionario;
import view.Mensagens;

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
            if(dao.verificarLogin(funcionario.getLogin())){
            this.dao.salvar(funcionario);
            return true;
            }else{
                Mensagens.mensagem("Esse nome de usuário ja esta registrado no sistema!");
                return false;
            }
        }else{
            Mensagens.mensagem("Erro, esse registro ja foi cadastrado no sistema!");
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
     public boolean autenticarStatus(Funcionario funcionario){
         return dao.autenticarStatus(funcionario);
     }
     
   public boolean alterarStatus(String cpf,String status){
       return dao.alterarStatus(cpf, status);
   }
   
}
