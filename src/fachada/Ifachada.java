/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.List;
import modelVO.Motorista;
import modelVO.Transporte;

/**
 *
 * @author Flavio
 */
public interface Ifachada {
    public boolean salvar(Motorista motorista);
    public boolean editar(Motorista motorista,Motorista motorista_atualizado);
    public List<Motorista> getAllMotorista();
    public boolean removerMotorista(String cpf);
    public Motorista buscarCpf(String cpf);
    public boolean verificarExistenciaMotorista(String cpf);
    
     public boolean salvar(Transporte transporte);
    public boolean editar(Transporte transporte,int id);
    public List<Transporte> getAllTransporte();
    public boolean removerTransporte(int id,String placa);
        
}
