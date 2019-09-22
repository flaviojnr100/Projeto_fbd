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
    private List<Bilhete> bilhete;
    public Passageiro(String nome, String sobrenome, String cpf,Bilhete bilhete) {
        super(nome, sobrenome, cpf);
        this.bilhete = new ArrayList<>();
    }

    public List<Bilhete> getBilhete() {
        return bilhete;
    }

    public void setBilhete(List<Bilhete> bilhete) {
        this.bilhete = bilhete;
    }

   
    

    

   

    
    
}
