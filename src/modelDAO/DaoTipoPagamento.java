/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelVO.Tipo_pagamento;

/**
 *
 * @author Flavio
 */
public class DaoTipoPagamento {
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    
    public boolean salvar(Tipo_pagamento pagamento){return true;}
    public Tipo_pagamento buscarId(int id){return null;}
    public List<Tipo_pagamento> getAll(){return null;}
    public boolean editar(Tipo_pagamento pagamento,Tipo_pagamento pagamento_novo){return true;}
    public boolean remover(int id){return true;}
}
