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
public class Viagem {
    private int id;
    private Passageiro passageiro;
    private Transporte transporte;
    private Destino destino;
    private String preco;

    public Viagem(int id, Passageiro passageiro, Transporte transporte, Destino destino,String preco) {
        this.id = id;
        this.passageiro = passageiro;
        this.transporte = transporte;
        this.destino = destino;
        this.preco = preco;
    }
    public Viagem(Passageiro passageiro, Transporte transporte, Destino destino,String preco) {
        this.passageiro = passageiro;
        this.transporte = transporte;
        this.destino = destino;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    
}
