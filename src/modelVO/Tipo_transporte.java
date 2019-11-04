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
public class Tipo_transporte {
    private int id;
    private String nome;
    private int assentos;
    

    public Tipo_transporte(String nome, int assentos) {
        this.nome = nome;
        this.assentos = assentos;
        
    }

    public Tipo_transporte(int id, String nome, int assentos) {
        this.id = id;
        this.nome = nome;
        this.assentos = assentos;
        
    }
    

    public Tipo_transporte() {
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
