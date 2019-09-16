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
public class Pagamento {
    private String situacao;
    private Tipo_pagamento tipo;

    public Pagamento(String situacao, Tipo_pagamento tipo) {
        this.situacao = situacao;
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Tipo_pagamento getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_pagamento tipo) {
        this.tipo = tipo;
    }
    
}
