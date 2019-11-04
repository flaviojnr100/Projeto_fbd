/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.List;
import modelDAO.DaoTipo_transporte;
import modelVB.BusinessAcesso;
import modelVB.BusinessFuncionario;
import modelVB.BusinessMotorista;
import modelVB.BusinessPassageiro;
import modelVB.BusinessRota;
import modelVB.BusinessTipo_transporte;
import modelVB.BusinessTransporte;
import modelVO.Acesso;
import modelVO.Destino;
import modelVO.Funcionario;
import modelVO.Motorista;
import modelVO.Passageiro;
import modelVO.Tipo_transporte;
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
    private BusinessTipo_transporte bTipo_transporte;
    private BusinessRota bDestino;
    private BusinessAcesso bAcesso;
    private static Fachada instance;

    private Fachada() {
        this.bMotorista = new BusinessMotorista();
        this.bTransporte = new BusinessTransporte();
        this.bFuncionario = new BusinessFuncionario();
        this.bPassageiro = new BusinessPassageiro();
        this.bTipo_transporte = new BusinessTipo_transporte();
        this.bDestino = new BusinessRota();
        this.bAcesso = new BusinessAcesso();
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
        return bTransporte.getAll();
    }

    @Override
    public boolean removerTransporte(int id,String placa) {
        return bTransporte.remover(id, placa);
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
    public Funcionario buscarLogin(String login,String senha){
        return bFuncionario.buscarLogin(login, senha);
    }
     public List<Funcionario> buscarLike(String nome,String busca){
         return bFuncionario.buscarLike(nome, busca);
     }
   
    public boolean verificarCpfFuncionario(String cpf){
        return bFuncionario.verificarCpf(cpf);
    }
     public boolean autenticar(Funcionario funcionario){
         return bFuncionario.autenticar(funcionario);
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
   
    //Tipo transporte
     
    public boolean salvarTipo_transporte(Tipo_transporte tipo){
        return bTipo_transporte.salvar(tipo);
    }
    public List<Tipo_transporte> getAllTipoTransporte(){
        return bTipo_transporte.getAll();
    }
    public Tipo_transporte buscarIdTipo_Transporte(int id){
        return bTipo_transporte.buscarId(id);
    }
    
    //Destino
    public boolean salvarDestino(Destino destino){
        return bDestino.salvar(destino);
    }
    public List<Destino> getAllDestino(){
        return bDestino.getAll();
    }
    
    //acesso
    public boolean salvar(Funcionario funcionario,String horario,String data){
        return bAcesso.salvar(funcionario, horario, data);
    }
    public List<Acesso> getAllAcesso(){
        return bAcesso.getAll();
    }
}
