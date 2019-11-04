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
import modelDAO.DaoTransporte;
import modelVO.Transporte;

/**
 *
 * @author Flavio
 */
public class BusinessTransporte {
    private DaoTransporte dao;

    public BusinessTransporte() {
        this.dao = new DaoTransporte();
    }
      public boolean salvar(Transporte transporte){
          // if(transporte.getDestino()== null && transporte.getMotorista()== null){
         //      return dao.salvar2(transporte);
         //  }
          return dao.salvar(transporte);
     
        
    }
    public boolean editar(Transporte transporte){
       
            return dao.editar(transporte);
        
        
    }
    public List<Transporte> getAll(){
        
        return dao.getAll();
        
        
    }
    public boolean remover(int id,String placa){
        
        return dao.remover(id,placa);
    }
    public static void main(String []args){
        BusinessTransporte bt = new BusinessTransporte();
        System.out.println("Nome: "+bt.getAll().get(0).getMotorista().getNome());
        System.out.println("Nome: "+bt.getAll().get(0).getMotorista().getSobrenome());
        System.out.println("Nome: "+bt.getAll().get(0).getMotorista().getCpf());
        System.out.println("Nome: "+bt.getAll().get(0).getMotorista().getCnh());
    }
    
}
