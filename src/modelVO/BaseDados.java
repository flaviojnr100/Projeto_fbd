/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVO;

import fachada.Fachada;
import java.util.List;

/**
 *
 * @author Flavio
 */
public class BaseDados {
    private static List<Transporte> transportes;
    private static List<Tipo_transporte> tipoTransportes;
    private static List<Destino> destinos;
    private static List<Motorista> motoristas;
    private static List<Passageiro> passageiros;
    private static List<Funcionario> funcionarios;
    private static List<Destino> rotas;
    private static List<Viagem> viagens;
    
    public static void CarregarTransporte(){
        transportes = Fachada.getInstance().getAllTransporte();
    }
    public static void CarregarTipoTransporte(){
        tipoTransportes = Fachada.getInstance().getAllTipoTransporte();
    }

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public static void CarregarDestino(){
        destinos = Fachada.getInstance().getAllDestino();
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
    public static List<Transporte> getTransportes() {
        return transportes;
    }

    public static List<Tipo_transporte> getTipoTransportes() {
        return tipoTransportes;
    }

    public static List<Destino> getDestinos() {
        return destinos;
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
    public static void CarregarRota(){
        rotas = Fachada.getInstance().getAllDestino();
    }

    public static List<Viagem> getViagens() {
        return viagens;
    }
    
}
