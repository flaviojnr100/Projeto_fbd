/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVO;

/**
 *
 * @author Flavio
 */
public class Funcionario extends Pessoa {
    private String login;
    private String senha;
    private String status;
    public Funcionario(String nome, String sobrenome, String rg, String cpf, String data_nascimento,String login,String senha) {
        super(nome, sobrenome, rg, cpf, data_nascimento);
        this.login=login;
        this.senha = senha;
    }

    public Funcionario(int id, String nome, String sobrenome, String rg, String cpf, String data_nascimento,String login, String senha,String status) {
        super(id, nome, sobrenome, rg, cpf, data_nascimento);
        this.login = login;
        this.senha = senha;
        this.status = status;
    }
    public Funcionario(String login,String senha){
        this.login = login;
        this.senha = senha;
    }

    public Funcionario(String login) {
        this.login = login;
    }
    
    
    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
