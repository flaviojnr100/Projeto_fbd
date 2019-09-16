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
public class Tipo_pagamento {
    private String modo_pagamento;
    private Agencia_bancaria agencia;

    public Tipo_pagamento(String modo_pagamento, Agencia_bancaria agencia) {
        this.modo_pagamento = modo_pagamento;
        this.agencia = agencia;
    }

    public String getModo_pagamento() {
        return modo_pagamento;
    }

    public void setModo_pagamento(String modo_pagamento) {
        this.modo_pagamento = modo_pagamento;
    }

    public Agencia_bancaria getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia_bancaria agencia) {
        this.agencia = agencia;
    }
    
}
