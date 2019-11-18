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
        public static String INSERT_ALL="insert into transporte(cor,placa,chassi,id_motorista,id_tipo_transporte,id_destino) values (?,?,?,?,?,?)";
        public static String ATUALIZAR_INSERT = "update transporte set id_motorista=?,id_tipo_transporte=?,id_destino=?";
        public static String INSERT="insert into transporte(cor,placa,chassi) values (?,?,?)";
        public static String BUSCAR_CHASSI="select * from transporte where chassi = ?";
        public static String BUSCAR_ALL = "select * from transporte";
        public static String REMOVER_PLACA = "delete from transporte where id=? and placa = ?";
        public static String BUSCARLIKECOR = "select * from transporte where cor like ?";
        public static String BUSCARLIKECHASSI = "select a.id,a.cor,a.placa,a.chassi,b.id,c.id from transporte as a,motorista as b,tipo_transporte as c,rota as d where a.id_motorista=b.id and c.id=a.id_tipo_transporte and d.id = a.id_destino and a.chassi like ?";
        public static String BUSCARLIKEPLACA = "select a.id,a.cor,a.placa,a.chassi,b.id,c.id from transporte as a,motorista as b,tipo_transporte as c,rota as d where a.id_motorista=b.id and c.id=a.id_tipo_transporte and d.id = a.id_destino and  a.placa like ?";
        public static String BUSCARLIKEMOTORISTA = "select a.id,a.cor,a.placa,a.chassi,b.id,c.id from transporte as a,motorista as b,tipo_transporte as c,rota as d where a.id_motorista=b.id and c.id=a.id_tipo_transporte and d.id = a.id_destino and  b.nome like ?";
        public static String BUSCAR_PROX_ID = "select max(id) from transporte";
        public static String BUSCAR_ID = "select * from transporte where id=?";
    }
    public static class Destino{
        public static String INSERT_ALL = "insert into rota(nome,id_endereco_partida,horario,id_endereco_destino,preco) values(?,?,?,?,?)";
        public static String BUSCAR_ALL = "select * from rota";
        public static String BUSCAR_ID = "select * from rota where id=?";
        public static String BUSCAR_NOME = "select * from rota where nome=?";
        public static String REMOVE_ID = "delete from rota where id=?";
        public static String EDITAR = "update rota set nome=?,id_endereco_partida=?,horario=?,id_endereco_destino=?,preco=? where id = ?";
        public static String BUSCARLIKENOME = "select * from rota where nome like ?";
        public static String BUSCARLIKEPRECO = "select * from rota where preco like ?";
    }
    public static class Endereco{
        public static String INSERT_ALL = "insert into endereco(estado,rua,bairro,cidade,complemento) values (?,?,?,?,?)";
        public static String BUSCAR_ID = "select * from endereco where id=?";
        public static String VERIFICAR_EXISTENCIA = "select count(estado) from endereco where estado=? and rua=? and bairro=? and cidade=?";
        public static String RETORNAR_ID = "select id from endereco where estado=? and rua=? and bairro=? and cidade=?";
    }
    
    public static class Tipo_transporte{
        public static String INSERT_ALL = "insert into tipo_transporte(nome,assentos) values(?,?)";
        public static String BUSCAR_ID = "select * from tipo_transporte where id=?";
        public static String BUSCAR_ALL = "select * from tipo_transporte";
        public static String BUSCAR_NOME = "select * from tipo_transporte where nome=?";
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
        public static String BUSCAR_ALL = "select * from funcionario order by id";
        public static String BUSCAR_ID = "select * from funcionario where id=?";
        public static String REMOVER_CPF = "delete from funcionario where cpf=?";
        public static String EDITAR_CPF = "update funcionario set nome=?,sobrenome=?,rg=?,cpf=?,data_nascimento=?,login=?,senha=? where id=? and cpf=?";
        public static String BUSCARLIKENOME = "select * from funcionario where nome like ? order by id";
        public static String BUSCARLIKERG = "select * from funcionario where rg like ? order by id";
        public static String BUSCARLIKECPF = "select * from funcionario where cpf like ? order by id";
        public static String BUSCARLIKELOGIN = "select * from funcionario where login like ? order by id";
        public static String VERIFICARCPF = "select count(cpf) from funcionario where cpf=?";
        public static String AUTENTICAR = "select count(nome) from funcionario where login=? and senha=?";
        public static String BUSCAR_LOGIN = "select * from funcionario where login=? and senha=?";
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
        public static String INSERT_ALL = "insert into assento(numero,estado_ocupacao) values (?,?)";
        public static String BUSCAR_ID = "select * from assento where id=?";
        public static String BUSCAR_NUMERO = "select * from assento where numero=?";
        public static String BUSCAR_NUMERO_ID = "select id from assento where numero=?";
        public static String BUSCAR_ALL = "select * from assento";
        public static String REMOVER_NUMERO = "delete from assento where numero=?";
        public static String EDITAR_ID = "update assento set numero=?,posicao=?,estado_ocupacao=?,id_transporte_assento=? where id=?";
        public static String BUSCAR_LIVRE = "select * from assento where estado_ocupacao='vazio'";
        public static String BUSCAR_LIVRE_ASSENTO = "select a.* from transporte_assento as c, assento as a,transporte as b where c.id_passageiro is null and c.id_transporte=b.id and c.id_assento= a.id and b.id=? order by a.numero";
        public static String BUSCAR_ID_TRANSPORTE_ASSENTO = "select id from transporte_assento where id_transporte =? and id_assento=?";
        public static String ADICIONAR_TRANSPORTE_ASSENTO = "insert into transporte_assento(id_transporte,id_assento) values(?,?)";
        public static String ADICIONAR_PASSAGEIRO_ASSENTO = "update transporte_assento set id_passageiro=? where id=?";
    }
    
    public static class Acesso{
        public static String SALVAR_ACESSO = "insert into acesso(cod_funcionario,horario,data) values(?,?,?)";
        public static String BUSCAR_ALL = "select a.id,b.login,a.horario,a.data from acesso as a, funcionario as b where a.cod_funcionario = b.id order by id";
        public static String BUSCAR_LIKEDATA = "select a.id,b.login,a.horario,a.data from acesso as a, funcionario as b where a.cod_funcionario = b.id and data like ? order by id";;
        public static String BUSCAR_LIKENOME = "select a.id,b.login,a.horario,a.data from acesso as a,funcionario as b where a.cod_funcionario=b.id and b.nome  like ?";
       }
    public static class Viagem{
        public static String INSERT = "insert into viagem(id_passageiro,id_rota,id_transporte,preco) values(?,?,?,?)";
        public static String BUSCAR_ALL="select * from viagem";
    }
    
}

