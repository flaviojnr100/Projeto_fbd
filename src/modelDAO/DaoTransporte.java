/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.util.List;
import modelVO.Transporte;

/**
 *
 * @author Flavio
 */
public class DaoTransporte {

    public boolean salvar(Transporte transporte){return true;}
    public boolean editar(Transporte transporte){return true;}
    public Transporte buscarPlaca(String placa){
        Transporte transporte = null;
        return transporte;
    }
    public Transporte buscarChassi(String chassi){
        Transporte transporte = null;
        return transporte;
    }
    public List<Transporte> getAll(){
        return null;
    }
    public boolean remover(String placa){return true;}
    
}
