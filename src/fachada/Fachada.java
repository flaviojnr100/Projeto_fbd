/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.List;
import modelVB.BusinessFuncionario;
import modelVB.BusinessMotorista;
import modelVB.BusinessPassageiro;
import modelVB.BusinessTransporte;
import modelVO.Funcionario;
import modelVO.Motorista;
import modelVO.Passageiro;
import modelVO.Transporte;

/**
 *
 * @author Flavio
 */
public class Fachada implements Ifachada {
    private BusinessMotorista bMotorista;
    private BusinessTransporte bTransporte;
    private BusinessFuncionario bFuncionario;
    private BusinessPassageiro bPassageiro;
    private static Fachada instance;

    private Fachada() {
        this.bMotorista = new BusinessMotorista();
        this.bTransporte = new BusinessTransporte();
        this.bFuncionario = new BusinessFuncionario();
        this.bPassageiro = new BusinessPassageiro();
    }
    public static Fachada getInstance(){
        if(instance == null){
            instance = new Fachada();
            return instance;
        }
        return instance;
    }
    
    //motorista
    
    @Override
    public boolean salvar(Motorista motorista) {
        
        return bMotorista.salvar(motorista);
    }
    @Override
    public Motorista buscarCpf(String cpf) {
        return bMotorista.buscarCpf(cpf);
    }

   

    @Override
    public List<Motorista> getAllMotorista() {
        return bMotorista.getAll();
    }

    @Override
    public boolean removerMotorista(String cpf) {
        return bMotorista.remover(cpf);
    }
    @Override
    public boolean verificarExistenciaMotorista(String cpf) {
       return bMotorista.verificarExistencia(cpf);
    }
    
    @Override
    public boolean editar(Motorista motorista, Motorista motorista_atualizado) {
        return bMotorista.editar(motorista, motorista_atualizado);
    }
    public List<Motorista> buscarLikeNome(String nome,String busca){
        return bMotorista.buscarLikeNome(nome,busca);
    }
   
    //Transporte
    @Override
    public boolean salvar(Transporte transporte) {
       return bTransporte.salvar(transporte);
    }

    @Override
    public boolean editar(Transporte transporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transporte> getAllTransporte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removerTransporte(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //Funcionario
    public boolean salvar(Funcionario funcionario) {
        return bFuncionario.salvar(funcionario);
    }
    public List<Funcionario> getAllFuncionario(){
        return bFuncionario.getAll();
    }
    public boolean removerFuncionario(String cpf){
        return bFuncionario.removerCpf(cpf);
    }
    public boolean editarFuncionario(Funcionario funcionario,Funcionario funcionario_antigo){
        return bFuncionario.editar(funcionario, funcionario_antigo);
    }
    public Funcionario buscarCpfFuncionario(String cpf){
        return bFuncionario.buscarCpf(cpf);
    }
     public List<Funcionario> buscarLike(String nome,String busca){
         return bFuncionario.buscarLike(nome, busca);
     }
   
    public boolean verificarCpfFuncionario(String cpf){
        return bFuncionario.verificarCpf(cpf);
    }
    //passageiro
    
    public boolean salvar(Passageiro passageiro){
        return bPassageiro.salvar(passageiro);
    }
    public List<Passageiro> getAllPassageiro(){
        return bPassageiro.getAll();
    }
    public boolean removerPassageiro(String cpf){
        return bPassageiro.removerCpf(cpf);
    }
    public boolean editarPassageiro(Passageiro passageiro,Passageiro passageiro_novo){
        return bPassageiro.editar(passageiro, passageiro_novo);
    }
    public Passageiro buscarCpfPassageiro(String cpf){
        return bPassageiro.buscarCpf(cpf);
    }
    public List<Passageiro> buscarLikePassageiro(String nome,String busca){
        return bPassageiro.buscaLike(nome, busca);
    }
   

    
    
}
