/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Flavio
 */
public class Passageiro extends Pessoa implements IPassageiro {
    private String status;
    public Passageiro(String nome, String sobrenome, String cpf) {
        super(nome, sobrenome, cpf);
        this.status = "ativo";
        
    }
     public Passageiro(int id, String nome, String sobrenome, String cpf,String status) {
        super(id,nome, sobrenome, cpf);
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
    

   
    

    

   

    
    
}
