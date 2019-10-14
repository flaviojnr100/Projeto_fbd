/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Financeiro;

/**
 *
 * @author Flavio
 */
public class ControllerFinanceiro {
    private Financeiro tela;

    public ControllerFinanceiro(Financeiro tela) {
        this.tela = tela;
        Control();
    }
    private void Control(){
        tela.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.setVisible(false);
            }
        });
    }
}

