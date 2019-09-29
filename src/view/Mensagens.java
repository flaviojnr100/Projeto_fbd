/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Flavio
 */
public class Mensagens {
    public static void mensagem(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
    public static boolean mensagemConfirmacao(String texto){
        if(JOptionPane.showConfirmDialog(null, texto,"Alerta",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            return true;
        }
        return false;
    }
}
