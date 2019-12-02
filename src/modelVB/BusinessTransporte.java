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
import view.Mensagens;

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
         if(dao.verificarPlaca(transporte.getPlaca())){
             if(dao.verificarChassi(transporte.getChassi())){
                return dao.salvar(transporte);
             }else{
                 Mensagens.mensagem("Esse veiculo já foi cadastrado no sistema!");
                 return false;
             }
         }else{
             Mensagens.mensagem("Essa placa de veiculo já foi cadastrado!");
             return false;
         }
     
        
    }
    public List<Transporte> getAll(){
        
        return dao.getAll();
        
        
    }
    public boolean remover(int id,String placa){
        
        return dao.remover(id,placa);
    }
    public Transporte buscarChassi(String chassi){
        return dao.buscarChassi(chassi);
    }
    public List<Transporte> buscarLike(String nome,String busca){
        return dao.buscarLike(nome, busca);
    }
    public Transporte buscarId(int id){
        return dao.buscarId(id);
    }
    public boolean editar(Transporte transporte,int id){
        if(buscarId(id).getChassi().equals(transporte.getChassi()) || dao.verificarChassi(transporte.getChassi())){
            if(buscarId(id).getPlaca().equals(transporte.getPlaca()) || dao.verificarPlaca(transporte.getPlaca())){
                 if(dao.editar(transporte, id)){
                     return true;
                 }
                 Mensagens.mensagem("Erro ao modificar o registro!");
                 return false;
            }else{
                Mensagens.mensagem("Essa placa já foi cadastrado no sistema!");
                return false;
            }
            }else{
                Mensagens.mensagem("Esse numero de chassi já foi cadastrado no sistema!");
                return false;
            }
        
    }
    public boolean alterarStatus(int id,String status){
        return dao.alterarStatus(id, status);
    }
}
