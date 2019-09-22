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
}

