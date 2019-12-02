/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVO;

import fachada.Fachada;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Flavio
 */
public class BaseDados {
    private static List<Transporte> transportes;
    private static List<Tipo_transporte> tipoTransportes;
    private static List<Motorista> motoristas;
    private static List<Passageiro> passageiros;
    private static List<Funcionario> funcionarios;
    private static List<Destino> rotas;
    private static List<Viagem> viagens;
    private static List<Financa> financas;
    private static List<Transporte> transporteAtivo;
    
    public static void CarregarTransporte(){
        transportes = Fachada.getInstance().getAllTransporte();
    }
    public static void CarregarTipoTransporte(){
        tipoTransportes = Fachada.getInstance().getAllTipoTransporte();
    }
    public static void CarregarTransporteAtivo(){
        transporteAtivo = new ArrayList<>();
        for(Transporte t:transportes){
            if(t.getStatus().equals("ATIVO")){
                transporteAtivo.add(t);
            }
        }
    }

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public static void CarregarViagem(){
        viagens = Fachada.getInstance().getAllViagem();
    }
    public static void CarregarMotorista(){
        motoristas = Fachada.getInstance().getAllMotorista();
    }
    public static void CarregarFuncionario(){
        funcionarios = Fachada.getInstance().getAllFuncionario();
    }
    
    public static void CarregarPassageiro(){
        passageiros = Fachada.getInstance().getAllPassageiro();
    }
    public static void CarregarFinanca(){
        financas = Fachada.getInstance().getAllFinanca();
    }
    public static void CarregarRota(){
        rotas = Fachada.getInstance().getAllDestino();
    }
    public static List<Transporte> getTransportes() {
        return transportes;
    }

    public static List<Tipo_transporte> getTipoTransportes() {
        return tipoTransportes;
    }

   
    public static List<Motorista> getMotoristas() {
        return motoristas;
    }

    public static List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public static List<Destino> getRotas() {
        return rotas;
    }
   

    public static List<Viagem> getViagens() {
        return viagens;
    }

    public static List<Financa> getFinancas() {
        return financas;
    }
    
    public static int passageiroCountActive(){
        int count=0;
        for(Passageiro p:passageiros){
            if(p.getStatus().equals("ATIVO")){
                count++;
            }
        }
        return count;
    }
    public static int motoristaCountActive(){
        int count=0;
        for(Motorista m:motoristas){
            if(m.getStatus().equals("ATIVO")){
                count++;
            }
        }
        return count;
    }
    public static int rotaCountActive(){
        int count=0;
        for(Destino d:rotas){
            if(d.getStatus().equals("ATIVO")){
                count++;
            }
        }
        return count;
    }
    public static int transporteCountActive(){
        int count =0;
        for(Transporte t:transportes){
            if(t.getStatus().equals("ATIVO")){
                count++;
            }
        }
        return count;
    }

    public static List<Transporte> getTransporteAtivo() {
        return transporteAtivo;
    }
    public static String getDataAtual(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        
        return formatador.format(data);
        
    }
    
}
