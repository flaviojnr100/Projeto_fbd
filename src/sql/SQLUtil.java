/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 *
 * @author Flavio
 */
public class SQLUtil {
    
    public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/transportes_terrestre";
    public static String USUARIO_POSTGRES = "postgres";
    public static String SENHA_POSTGRES = "postgres";
    
    public static class Motorista{
         public static String INSERT_ALL = "insert into motorista(nome,sobrenome,rg,cpf,data_nascimento,cnh) values (?,?,?,?,?,?)";
         public static String BUSCAR_CPF = "select * from motorista where cpf=?";
         public static String BUSCAR_ALL = "select * from motorista";
         public static String REMOVER_CPF = "delete from motorista where cpf = ?";
         public static String EDITAR = "update motorista set nome = ?,sobrenome=?,rg=?,cpf=?,data_nascimento=?,cnh=? where id = ? and cpf = ?";
         public static String BUSCAR_ID = "select * from motorista where id=?";
         public static String VERIFICAREXISTENCIA = "select count(cpf) from motorista where cpf=?";
         public static String BUSCARLIKENOME = "select * from motorista where nome like ?";
         public static String BUSCARLIKERG = "select * from motorista where rg like ?";
         public static String BUSCARLIKECPF = "select * from motorista where cpf like ?";
         public static String BUSCARLIKECNH = "select * from motorista where cnh like ?";
         
    }
    
    public static class Transporte{
        public static String INSERT_ALL="insert into transporte(cor,placa,chassi,id_motorista,id_tipo_transporte,id_destino,id_transporte_horario) values (?,?,?,?,?,?,?)";
        public static String INSERT="insert into transporte(cor,placa,chassi) values (?,?,?)";
        public static String BUSCAR_CHASSI="select * from transporte where chassi = ?";
}
    public static class Destino{
        public static String INSERT_ALL = "insert into destino(nome,id_endereco) values(?,?)";
        public static String BUSCAR_ALL = "select * from destino";
        public static String BUSCAR_ID = "select * from destino where id=?";
        public static String BUSCAR_NOME = "select * from destino where nome=?";
        public static String REMOVE_ID = "delete from destino where id=?";
        public static String EDITAR = "update destino set nome=?,id_endereco=?";
    }
    public static class Endereco{
        public static String INSERT_ALL = "insert into endereco(estado,rua,bairro,cidade,complemento) values (?,?,?,?,?)";
        public static String BUSCAR_ID = "select * from endereco where id=?";
    }
    
    public static class Tipo_transporte{
        public static String INSERT_ALL = "insert into tipo_transporte(nome,assentos,id_empresa) values(?,?,?)";
        public static String BUSCAR_ID = "select * from tipo_transporte where id=?";
    }
    public static class Empresa{
        public static String INSERT_ALL = "insert into empresa(nome,cnpj) values(?,?)";
        public static String BUSCAR_ID = "select * from empresa where id=?";
        
    }
    public static class Rodoviaria{
        public static String INSERT_ALL = "insert into rodoviaria(nome,id_endereco) values(?,?)";
        public static String BUSCAR_ID = "select * from rodoviaria where id=?";
    }
    public static class Passageiro{
        public static String INSERT_ALL = "insert into passageiro(nome,sobrenome,cpf) values(?,?,?)";
        public static String BUSCAR_CPF = "select * from passageiro where cpf=?";
        public static String BUSCAR_ALL = "select * from passageiro";
        public static String BUSCAR_ID = "select * from passageiro where id=?";
        public static String REMOVER_CPF = "delete from passageiro where cpf=?";
        public static String EDITAR_CPF = "update passageiro set nome=?,sobrenome=?,cpf=? where id=? and cpf=?";
        public static String BUSCARLIKENOME = "select * from passageiro where nome like ?";
        public static String BUSCARLIKECPF = "select * from passageiro where cpf like ?";
        //public static String BUSCARLIKEBILHETE = "select * from passageiro where cpf like ?";
        public static String VERIFICARCPF = "select count(cpf) from passageiro where cpf=?";
        
    }
     public static class Funcionario{
        public static String INSERT_ALL = "insert into funcionario(nome,sobrenome,rg,cpf,data_nascimento,login,senha) values(?,?,?,?,?,?,?)";
        public static String BUSCAR_CPF = "select * from funcionario where cpf=?";
        public static String BUSCAR_ALL = "select * from funcionario";
        public static String BUSCAR_ID = "select * from funcionario where id=?";
        public static String REMOVER_CPF = "delete from funcionario where cpf=?";
        public static String EDITAR_CPF = "update funcionario set nome=?,sobrenome=?,rg=?,cpf=?,data_nascimento=?,login=?,senha=? where id=? and cpf=?";
        public static String BUSCARLIKENOME = "select * from funcionario where nome like ?";
        public static String BUSCARLIKERG = "select * from funcionario where rg like ?";
        public static String BUSCARLIKECPF = "select * from funcionario where cpf like ?";
        public static String BUSCARLIKELOGIN = "select * from funcionario where login like ?";
        public static String VERIFICARCPF = "select count(cpf) from funcionario where cpf=?";
    }
    
    public static class Agencia_bancaria{
        public static String INSERT_ALL = "insert into agencia_bancaria(nome,cnpf) values(?,?)";
        public static String BUSCAR_ID = "select * from agencia_bancaria where id=?";
        public static String BUSCAR_ALL = "select * from agencia_bancaria";
        public static String REMOVER_CNPJ = "delete from agencia_bancaria where id =? and cnpj=?";
        public static String EDITAR_CNPJ = "update agencia_bancaria set nome=?,cnpj=? where id=? and cnpj=?";
        
    }
    public static class Tipo_pagamento{
        public static String INSERT_ALL="insert into tipo_pagamento(modo_pagamento,id_agencia) values (?,?)";
        public static String BUSCAR_ID = "select * from tipo_pagamento where id=?";
        public static String BUSCAR_ALL = "select * from tipo_pagamento";
        public static String REMOVER_ID = "delete from tipo_pagamento where id=?";
        public static String EDITAR_ID = "update tipo_pagamento set modo_pagamento=?,id_agencia=?";
        
    }
    public static class Pagamento{
        public static String INSERT_ALL = "insert into pagamento(situacao,id_tipo_pagamento) values (?,?)";
        public static String BUSCAR_ID = "select * from pagamento where id=?";
        public static String BUSCAR_ALL = "select * from pagamento";
        public static String REMOVER_ID = "delete from pagamento where id=?";
        public static String EDITAR_ID = "update pagamento set situacao=?,id_tipo_pagamento=? where id=?";
    }
    
    public static class Horario{
        public static String INSERT_ALL = "insert into horario(hora,data,id_transporte_horario) values (?,?,?)";
        public static String INSERT = "insert into horario(hora,data) values (?,?)";
        public static String BUSCAR_ID = "select * from horario where id=?";
        public static String BUSCAR_ALL = "select * from horario";
        public static String REMOVER_ID = "delete from horario where id=?";
        public static String EDITAR_ID = "update horario set hora=?,data=?,id_transporte_horario=? where id=?";
    }
    public static class Assento{
        public static String INSERT_ALL = "insert into assento(numero,posicao,estado_ocupacao,id_transporte_assento) values (?,?,?,?)";
        public static String BUSCAR_ID = "select * from assento where id=?";
        public static String BUSCAR_NUMERO = "select * from assento where numero=?";
        public static String BUSCAR = "select * from assento";
        public static String REMOVER_NUMERO = "delete from assento where numero=?";
        public static String EDITAR_ID = "update assento set numero=?,posicao=?,estado_ocupacao=?,id_transporte_assento=? where id=?";
    }
}

