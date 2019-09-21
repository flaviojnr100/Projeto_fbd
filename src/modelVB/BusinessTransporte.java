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

    public BusinessTransporte(DaoTransporte dao) {
        this.dao = dao;
    }
      public boolean salvar(Transporte transporte){
           if(transporte.getDestino()==null || transporte.getMotorista()==null){
               return dao.salvar2(transporte);
           }
          return dao.salvar(transporte);
     
        
    }
    public boolean editar(Transporte transporte){
       
            return dao.editar(transporte);
        
        
    }
    public List<Transporte> getAll(){
        if(dao.getAll().size()>1){
            return dao.getAll();
        }
        return null;
    }
    public boolean remover(String placa){
        
        return dao.remover(placa);
    }
}
