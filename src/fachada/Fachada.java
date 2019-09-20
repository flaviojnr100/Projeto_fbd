/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.List;
import modelVB.BusinessMotorista;
import modelVO.Motorista;

/**
 *
 * @author Flavio
 */
public class Fachada implements Ifachada {
    private BusinessMotorista bMotorista;
    private static Fachada instance;

    private Fachada() {
        this.bMotorista = new BusinessMotorista();
    }
    public static Fachada getInstance(){
        if(instance == null){
            instance = new Fachada();
            return instance;
        }
        return instance;
    }
    
    
    
    @Override
    public boolean salvar(Motorista motorista) {
        
        return bMotorista.salvar(motorista);
    }

    @Override
    public boolean editar(Motorista motorista) {
        return bMotorista.editar(motorista);
    }

    @Override
    public List<Motorista> getAll() {
        return bMotorista.getAll();
    }

    @Override
    public boolean remover(String cpf) {
        return bMotorista.remover(cpf);
    }
    
}
