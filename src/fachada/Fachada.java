/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.List;
import modelVB.BusinessMotorista;
import modelVB.BusinessTransporte;
import modelVO.Motorista;
import modelVO.Transporte;

/**
 *
 * @author Flavio
 */
public class Fachada implements Ifachada {
    private BusinessMotorista bMotorista;
    private BusinessTransporte bTransporte;
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
    public List<Motorista> getAllMotorista() {
        return bMotorista.getAll();
    }

    @Override
    public boolean removerMotorista(String cpf) {
        return bMotorista.remover(cpf);
    }

   
    @Override
    public boolean salvar(Transporte transporte) {
       return bTransporte.salvar(transporte);
    }

    @Override
    public boolean editar(Transporte transporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transporte> getAllTransporte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removerTransporte(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
