/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVO;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Flavio
 */
public class Transporte {
    private int id;
    private Motorista motorista;
    private String cor;
    private String placa;
    private String chassi;
    private Tipo_transporte tipo;
    private Destino destino;
    private List<Assento> assentos = new ArrayList<>();
    private String horarios;

    public Transporte(String cor, String placa, String chassi,Motorista motorista ,Tipo_transporte tipo,Destino destino) {
        this.cor = cor;
        this.placa = placa;
        this.chassi = chassi;
        this.tipo = tipo;
        this.motorista = motorista;
        this.destino = destino;
    }
     public Transporte(int id,String cor, String placa, String chassi,Motorista motorista ,Tipo_transporte tipo,Destino destino) {
        this.cor = cor;
        this.placa = placa;
        this.chassi = chassi;
        this.tipo = tipo;
        this.motorista = motorista;
        this.destino = destino;
        this.id=id;
    }
    public Transporte(String cor, String placa, String chassi) {
        this.cor = cor;
        this.placa = placa;
        this.chassi = chassi;
        
    }

    public Transporte() {
    }
    

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Tipo_transporte getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_transporte tipo) {
        this.tipo = tipo;
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    
    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }
    
    
    
}
