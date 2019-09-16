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
public class Rodoviaria extends Endereco{
    private String nome;
    private List<Empresa> empresas = new ArrayList<>();

    public Rodoviaria(String nome,String estado, String rua, String bairro, String cidade) {
        super(estado, rua, bairro, cidade);
        this.nome = nome;
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
    
    
}
