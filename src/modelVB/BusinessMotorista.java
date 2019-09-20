/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelDAO.DaoMotorista;
import modelVO.Motorista;

/**
 *
 * @author Flavio
 */
public class BusinessMotorista {
    private static DaoMotorista dao;

    public BusinessMotorista() {
       this.dao = new DaoMotorista();
    }
    
    
    public boolean salvar(Motorista motorista){
       // if(!dao.verificarExistencia(motorista.getCpf())){
            try {
                return dao.salvar(motorista);
            } catch (SQLException ex) {
                Logger.getLogger(BusinessMotorista.class.getName()).log(Level.SEVERE, null, ex);
            }
      //  }
        return false;
    }
    public boolean editar(Motorista motorista){
        if(dao.verificarExistencia(motorista.getCpf())){
            return dao.editar(motorista);
        }
        return false;
    }
    public List<Motorista> getAll(){
        if(dao.getAll().size()>1){
            return dao.getAll();
        }
        return null;
    }
    public boolean remover(String cpf){
        if(dao.verificarExistencia(cpf)){
            return dao.remover(cpf);
        }
        return false;
    }
}
