/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.applet.Main;

/**
 *
 * @author Flavio
 */
public class Veiculo extends JFrame {
    private JLabel imagemLogo;
    private JLabel placa;
    private JLabel status;
    
    public Veiculo() {
        super();
        setSize(142, 151);
        setLayout(null);
        
            
        imagemLogo = new JLabel("logo_onibus_oficial.png");
        imagemLogo.setSize(100, 20);
        add(imagemLogo);
        imagemLogo.setLocation(21, 20);
      
        
        setVisible(true);
    }
    public static void main(String []args){
        new Veiculo();
    }
       
}
