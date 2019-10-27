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
public class Motorista extends Pessoa {
   private String cnh;

    public Motorista(String nome, String sobrenome, String rg, String cpf, String data_nascimento,String cnh) {
        super(nome, sobrenome, rg, cpf, data_nascimento);
        this.cnh = cnh;
    }

    public Motorista(int id, String nome, String sobrenome, String rg, String cpf, String data_nascimento,String cnh) {
        super(id, nome, sobrenome, rg, cpf, data_nascimento);
        this.cnh = cnh;
    }
    
    
    

    public Motorista() {
        super(null, null, null);
    }
    

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    
    
    

    
    
    
    
}
