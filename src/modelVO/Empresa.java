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
public class Empresa extends Entidade_empresa{
    
    public Empresa(String nome, String cnpj) {
        super(nome, cnpj);
    }

    public Empresa() {
        super(null, null);
    }
    
    
}
