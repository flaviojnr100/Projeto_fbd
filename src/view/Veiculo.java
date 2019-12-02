/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.applet.Main;

/**
 *
 * @author Flavio
 */
public class Veiculo extends JPanel implements Observer {
    private JLabel imagemLogo;
    //private JLabel placa;
    private JLabel status;
    private JButton informacao;
    private int posicaoX;
    private int posicaoY;
    
    public Veiculo() {
        super();
        setSize(130, 160);
               
        setLayout(null);
        setBackground(Color.WHITE);
        setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0),2));
                
        imagemLogo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resource/logo_onibus_oficial.png")));
        imagemLogo.setSize(100, 100);
        add(imagemLogo);
        imagemLogo.setLocation(18, 10);
        
       /* placa = new JLabel("CMD-2356");
        placa.setSize(70, 10);
        placa.setLocation(38, 120);
        add(placa);*/
        
        status = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resource/on.png")));
        status.setSize(50, 15);
        status.setLocation(41, 137);
        add(status);
        
        informacao = new JButton();
        informacao.setLocation(20, 120);
        informacao.setSize(95, 20);
        informacao.setBackground(Color.WHITE);
        
        add(informacao);
        setVisible(true);
    }

    public JLabel getImagemLogo() {
        return imagemLogo;
    }

 /*   public JLabel getPlaca() {
        return placa;
    }*/

    public JLabel getStatus() {
        return status;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public JButton getInformacao() {
        return informacao;
    }
    
    

    @Override
    public void update(Observable o, Object arg) {
      /*  String [] modificacao = (String[]) arg;
        placa.setText(modificacao[0]);
        if(modificacao[1].equals("on")){
            status.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resource/on.png")));
            
        }else if(modificacao[1].equals("off")){
            status.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resource/off.png")));
        }else if(modificacao[1].equals("ocupado")){
            status.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resource/ocupado.png")));
        }
    */}
    
       
}
