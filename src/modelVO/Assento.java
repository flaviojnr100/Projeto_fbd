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
public class Assento {
    private int numero;
    private String posicao;
    private String estado_ocupacao;

    public Assento(Transporte transporte,int numero, String posicao) {
        this.numero = numero;
        this.posicao = posicao;
        this.estado_ocupacao = "vazio";
        transporte.getAssentos().add(this);
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getEstado_ocupacao() {
        return estado_ocupacao;
    }

    public void setEstado_ocupacao(String estado_ocupacao) {
        this.estado_ocupacao = estado_ocupacao;
    }
    
    
}
