/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import modelVO.Motorista;
import fachada.Fachada;
/**
 *
 * @author Flavio
 */
public class App {
    public static void main(String[] args) {
        Motorista motorista = new Motorista("Marcos", "Vinicius", "546532127", "326598", "12/56/1236", "654312321");
        Fachada.getInstance().salvar(motorista);
    }
    
}
