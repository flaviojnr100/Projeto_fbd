/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.List;
import modelDAO.DaoTipo_transporte;
import modelVB.BusinessAcesso;
import modelVB.BusinessAssento;
import modelVB.BusinessFinanca;
import modelVB.BusinessFuncionario;
import modelVB.BusinessMotorista;
import modelVB.BusinessPassageiro;
import modelVB.BusinessRota;
import modelVB.BusinessTipo_transporte;
import modelVB.BusinessTransporte;
import modelVB.BusinessViagem;
import modelVO.Acesso;
import modelVO.Assento;
import modelVO.Destino;
import modelVO.Financa;
import modelVO.Funcionario;
import modelVO.Motorista;
import modelVO.Passageiro;
import modelVO.Tipo_transporte;
import modelVO.Transporte;
import modelVO.Viagem;

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
    private BusinessAssento bAssento;
    private BusinessViagem bViagem;
    private BusinessFinanca bFinanca;
    private static Fachada instance;

    private Fachada() {
        this.bMotorista = new BusinessMotorista();
        this.bTransporte = new BusinessTransporte();
        this.bFuncionario = new BusinessFuncionario();
        this.bPassageiro = new BusinessPassageiro();
        this.bTipo_transporte = new BusinessTipo_transporte();
        this.bDestino = new BusinessRota();
        this.bAcesso = new BusinessAcesso();
        this.bAssento = new BusinessAssento();
        this.bViagem = new BusinessViagem();
        this.bFinanca = new BusinessFinanca();
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
    public boolean alterarStatusMotorista(String cpf,String status){
        return bMotorista.alterarStatus(cpf, status);
    }
    
   
    //Transporte
    @Override
    public boolean salvar(Transporte transporte) {
       return bTransporte.salvar(transporte);
    }
    

    @Override
    public boolean editar(Transporte transporte,int id) {
        return bTransporte.editar(transporte,id);
    }

    @Override
    public List<Transporte> getAllTransporte() {
        return bTransporte.getAll();
    }

    @Override
    public boolean removerTransporte(int id,String placa) {
        return bTransporte.remover(id, placa);
    }
    
    public List<Transporte> buscarLikeTransporte(String nome,String busca){
        return bTransporte.buscarLike(nome, busca);
    }
    public Transporte buscarChassi(String chassi){
        return bTransporte.buscarChassi(chassi);
    }
    public Transporte buscarIdTransporte(int id){
        return bTransporte.buscarId(id);
    }
    public boolean alterarStatusTransporte(int id,String status){
        return bTransporte.alterarStatus(id, status);
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
     
     public boolean alterarStatusFuncionario(String cpf,String status){
         return bFuncionario.alterarStatus(cpf, status);
     }
    
    //passageiro
    
    public boolean salvar(Passageiro passageiro){
        return bPassageiro.salvar(passageiro);
    }
    public List<Passageiro> getAllPassageiro(){
        return bPassageiro.getAll();
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
    public void mudarStatus(int id,String status){
        bPassageiro.mudarStatus(id, status);
    }
    public List<Passageiro> buscarLikeBilhete(int nome,String busca){
        return bPassageiro.buscarLikeBilhete(nome, busca);
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
    public Destino buscarIdDestino(int id){
        return bDestino.buscarId(id);
    }
    public boolean editar(int id,Destino destino){
        return bDestino.editar(id, destino);
    }
    public boolean removerId(int id){
        return bDestino.removerId(id);
    }
     public List<Destino> buscaLikeDestino(String nome,String busca){
         return bDestino.buscaLike(nome, busca);
     }
     public boolean alterarStatusDestino(int id,String status){
         return bDestino.alterarStatus(id, status);
     }
    
    //acesso
    public boolean salvar(Funcionario funcionario,String horario,String data){
        return bAcesso.salvar(funcionario, horario, data);
    }
    public List<Acesso> getAllAcesso(){
        return bAcesso.getAll();
    }
     public List<Acesso> buscaLikeAcesso(String nome,String sql){
         return bAcesso.buscaLike(nome, sql);
     }
     
    //assento
     public boolean salvar(Assento assento){
         return bAssento.salvar(assento);
     }
     public Assento buscarNumero(int numero){
         return bAssento.buscarNumero(numero);
     }
     public List<Assento> getAllAssento(){
         return bAssento.getAll();
     }
    public int buscarLivre(String placa){
         return bAssento.buscarLivre(placa);
     }
     public List<Assento> buscarLivreVaga(int id){
         return bAssento.buscarLivreVaga(id);
     }
      public int buscarNumeroId(int numero){
          return bAssento.buscarNumeroId(numero);
      }
     public int buscarIdTransporteAssento(int id_transporte,int id_assento){
         return bAssento.buscarIdTransporteAssento(id_transporte, id_assento);
     }
     public boolean adicionarPassageiroAssento(int id_assento, int id_passageiro){
         return bAssento.adicionarPassageiroAssento(id_assento, id_passageiro);
     }
     public boolean removerPassageiroAssento(int id_transporte,int id_assento){
         return bAssento.removerPassageiroAssento(id_transporte, id_assento);
     }
     public void resetarAssento(){
         bAssento.resetarAssento();
     }
     
     //viagem
     public boolean salvar(Viagem viagem){
         return bViagem.salvar(viagem);
     }
     public List<Viagem> getAllViagem(){
         return bViagem.getAll();
     }
     public Viagem buscarIdViagem(int id){
         return bViagem.buscarId(id);
     }
     public List<Viagem> buscarLikeViagem(String texto,String busca){
         return bViagem.buscarLike(texto, busca);
     }
      public boolean alterarStatus(Viagem viagem){
          return bViagem.alterarStatus(viagem);
      }
       public boolean buscarDia(String data){
          return bViagem.buscarDia(data);
      }
  
     //Financa
     public boolean salvar(Financa financa){
         return bFinanca.salvar(financa);
     }
     public List<Financa> getAllFinanca(){
         return bFinanca.getAll();
     }
     public Financa buscar_data(String data){
         return bFinanca.buscar_data(data);
     }
     public boolean alterar_financa(Financa financa,double valor,String status){
         return bFinanca.alterar_financa(financa, valor, status);
     }
     public List<Financa> buscaLikeFinanca(String texto){
         return bFinanca.buscaLike(texto);
     }
     
}
