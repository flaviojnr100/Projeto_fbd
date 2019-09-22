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
import javax.swing.JOptionPane;
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
        if(!dao.verificarExistencia(motorista.getCpf())){
            
            return dao.salvar(motorista);
        }
        JOptionPane.showMessageDialog(null, "Esse motorista já foi cadastrado");
        return false;
    }
    public boolean editar(Motorista motorista, Motorista motorista_atualizado){
        if(dao.verificarExistencia(motorista.getCpf())){
            return dao.editar(motorista,motorista_atualizado);
        }
        JOptionPane.showMessageDialog(null, "Esse motorista não existe!");
        return false;
    }
    public List<Motorista> getAll(){
        List<Motorista> motoristas = dao.getAll();
        if(dao.getAll().size()>1){
            return dao.getAll();
        }
        JOptionPane.showMessageDialog(null, "Não há motoristas cadastrados no sistema!");
        return null;
    }
    public boolean remover(String cpf){
        if(dao.verificarExistencia(cpf)){
            return dao.remover(cpf);
        }
        return false;
    }
    public Motorista buscarCpf(String cpf){
        Motorista motorista = dao.buscarCpf(cpf);
        if(motorista==null){
            JOptionPane.showMessageDialog(null, "Esse motorista não está cadastrado no sistema");
            return null;
        }else{
            return motorista;
        }
        
    }
    public boolean verificarExistencia(String cpf){
        return dao.verificarExistencia(cpf);
    }
}
