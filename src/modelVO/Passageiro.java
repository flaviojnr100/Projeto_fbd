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
public class Passageiro extends Pessoa implements IPassageiro {
    private Bilhete bilhete;
    public Passageiro(String nome, String sobrenome, String cpf,Bilhete bilhete) {
        super(nome, sobrenome, cpf);
        this.bilhete = bilhete;
    }

    public Bilhete getBilhete() {
        return bilhete;
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }
    

    

   

    
    
}
