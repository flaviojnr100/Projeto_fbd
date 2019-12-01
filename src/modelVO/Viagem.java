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
    private String data_viagem;
    private String hora_viagem;
    private String status;

    public Viagem(int id, Passageiro passageiro, Destino destino,Transporte transporte ,String preco,String data_viagem,String hora_viagem,String status) {
        this.id = id;
        this.passageiro = passageiro;
        this.transporte = transporte;
        this.destino = destino;
        this.preco = preco;
        this.data_viagem = data_viagem;
        this.hora_viagem = hora_viagem;
        this.status = status;
    }
    public Viagem(Passageiro passageiro, Destino destino,Transporte transporte ,String preco,String data_viagem,String hora_viagem) {
        this.passageiro = passageiro;
        this.transporte = transporte;
        this.destino = destino;
        this.preco = preco;
        this.data_viagem = data_viagem;
        this.hora_viagem = hora_viagem;
    }

    public Viagem() {
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

    public String getData_viagem() {
        return data_viagem;
    }

    public void setData_viagem(String data_viagem) {
        this.data_viagem = data_viagem;
    }

    public String getHora_viagem() {
        return hora_viagem;
    }

    public void setHora_viagem(String hora_viagem) {
        this.hora_viagem = hora_viagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
