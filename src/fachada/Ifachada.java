/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.List;
import modelVO.Motorista;

/**
 *
 * @author Flavio
 */
public interface Ifachada {
    public boolean salvar(Motorista motorista);
    public boolean editar(Motorista motorista);
    public List<Motorista> getAll();
    public boolean remover(String cpf);
        
}
