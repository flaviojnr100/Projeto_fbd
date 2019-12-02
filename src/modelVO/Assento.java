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
public class Assento {
    private int id;
    private int numero;
    
    
    public Assento(int numero) {
        this.numero = numero;
        
        
        
    }

    public Assento(int id, int numero) {
        this.id = id;
        this.numero = numero;
        
    }

    
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
