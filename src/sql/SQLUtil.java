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
         public static String INSERT_ALL = "insert into motorista(nome,sobrenome,rg,cpf,data_nascimento,cnh) "
                + "values (?,?,?,?,?,?)";
         public static String BUSCAR_CPF = "select * from motorista where cpf=?";
         public static String BUSCAR_ALL = "select * from motorista";
         public static String REMOVER_CPF = "delete from motorista where cpf = ?";
         public static String EDITAR = "update motorista set nome = ?,sobrenome=?,rg=?,cpf=?,data_nascimento=?,cnh=? where id = ? and cpf = ?";
         public static String BUSCAR_ID = "select * from motorista where id=?";
    }
    
    public static class Transporte{
        public static String INSERT_ALL="insert into transporte(cor,placa,chassi,id_motorista,id_tipo_transporte,id_destino) "
                + "values (?,?,?,?,?,?,)";
        public static String INSERT="insert into transporte(cor,placa,chassi) "
                + "values (?,?,?)";
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
    
}

