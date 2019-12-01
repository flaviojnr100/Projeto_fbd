/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVO;

/**
 *
 * @author Flavio
 */
public class Financa {
    private int id;
    private String data;
    private double valor;

    public Financa(int id, String data, double valor) {
        this.id = id;
        this.data = data;
        this.valor = valor;
    }
    public Financa( String data, double valor) {
        this.data = data;
        this.valor = valor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
