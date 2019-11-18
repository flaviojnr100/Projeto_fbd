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
    private String estado_ocupacao;
    
    public Assento(int numero) {
        this.numero = numero;
        this.estado_ocupacao = "vazio";
        
        
    }

    public Assento(int id, int numero, String estado_ocupacao) {
        this.id = id;
        this.numero = numero;
        this.estado_ocupacao = estado_ocupacao;
    }

    
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    public String getEstado_ocupacao() {
        return estado_ocupacao;
    }

    public void setEstado_ocupacao(String estado_ocupacao) {
        this.estado_ocupacao = estado_ocupacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
