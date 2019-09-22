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
    private Empresa empresa;

    public Tipo_transporte(String nome, int assentos,Empresa empresa) {
        this.nome = nome;
        this.assentos = assentos;
        this.empresa = empresa;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
