/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVB;

import java.util.List;
import modelDAO.DaoAcesso;
import modelVO.Acesso;
import modelVO.Funcionario;

/**
 *
 * @author Flavio
 */
public class BusinessAcesso {
    private DaoAcesso dao;

    public BusinessAcesso() {
        this.dao = new DaoAcesso();
    }
    public boolean salvar(Funcionario funcionario,String horario,String data){
        return dao.Salvar(funcionario, horario, data);
    }
    public List<Acesso> getAll(){
        return dao.getAll();
    }
     public List<Acesso> buscaLike(String nome,String sql){
         return dao.buscaLike(nome, sql);
     }
    
}
