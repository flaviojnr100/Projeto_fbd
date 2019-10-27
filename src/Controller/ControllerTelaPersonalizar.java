/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.sun.prism.paint.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import view.DashBoard;
import view.TelaPersonalizar;
import javax.swing.event.*;

/**
 *
 * @author Flavio
 */
public class ControllerTelaPersonalizar extends Observable {
    private TelaPersonalizar tela;
    private DashBoard principal;

    public ControllerTelaPersonalizar(TelaPersonalizar tela,DashBoard dash) {
        this.tela = tela;
        this.principal = dash;
        Control();
    }
    private void Control(){
        tela.getBtnMudar().addActionListener(new Botoes());
        tela.getBtnCancelar().addActionListener(new Botoes());
        tela.getBtnDefault().addActionListener(new Botoes());
        
        
    }
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnMudar()){
                setChanged();
                notifyObservers(tela.getPainelCor().getColor());
            }
            if(e.getSource() == tela.getBtnCancelar()){
                tela.setVisible(false);
            }
            if(e.getSource() == tela.getBtnDefault()){
                setChanged();
                notifyObservers(new Color(0, 0, 0, 0));
            }
        }
       
    }
     

        

        
       
    
    
    
   
    
}
