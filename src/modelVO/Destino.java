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
public class Destino{
    private int id;
    private String nome;
    private Endereco partida;
    private Endereco destino;
    private String horario;
    public Destino(int id, String nome, Endereco partida, Endereco destino,String horario) {
        this.id = id;
        this.nome = nome;
        this.partida = partida;
        this.destino = destino;
        this.horario = horario;
    }

    public Destino(String nome, Endereco partida, Endereco destino,String horario) {
        this.nome = nome;
        this.partida = partida;
        this.destino = destino;
        this.horario = horario;
    }
    
    
    

    

    public Destino() {
    }
    public Destino(int id) {
        this.id = id;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Endereco getPartida() {
        return partida;
    }

    public void setPartida(Endereco partida) {
        this.partida = partida;
    }

    public Endereco getDestino() {
        return destino;
    }

    public void setDestino(Endereco destino) {
        this.destino = destino;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
    
}
