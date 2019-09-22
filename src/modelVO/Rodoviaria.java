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
public class Rodoviaria{
    private String nome;
    private Endereco endereco;
    private List<Empresa> empresas = new ArrayList<>();

    public Rodoviaria(String nome,Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
}
