/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Observable;
import javax.swing.JCheckBox;
import modelVO.Assento;
import modelVO.BaseDados;
import modelVO.Destino;
import modelVO.Financa;
import modelVO.Passageiro;
import modelVO.Transporte;
import modelVO.Viagem;
import view.CadastroPassageiro;
import view.CadastroRota;
import view.CadastroTransporte;
import view.CadastroViagem;
import view.ConsultarViagem;
import view.Mensagens;

/**
 *
 * @author Flavio
 */
public class ControllerCadastroViagem extends Observable {
    private CadastroViagem tela;
    private Fachada fachada;
    private CadastroPassageiro cPassageiro;
    private CadastroRota cRota;
    private CadastroTransporte cTransporte;
    private List<Assento> assentoL;
    private mudarCombo mudarE = new mudarCombo();
    private int comboMarcado =0;
    private List<JCheckBox> vagas;
    List<Integer> id_selecionado;
    private String vagasSelecionadas ="Foram selecionadas:\n";
    private double preco = 0;
    private ConsultarViagem ccViagem;
    private Passageiro [] passageiros;
    public ControllerCadastroViagem(CadastroViagem tela,Fachada fachada,CadastroPassageiro cPassageiro,CadastroRota cRota,CadastroTransporte cTransporte,ConsultarViagem ccViagem) {
        this.tela = tela;
        this.fachada = fachada;
        this.cPassageiro = cPassageiro;
        this.cRota = cRota;
        this.cTransporte = cTransporte;
        this.ccViagem = ccViagem;
        
        Control();
    }
    private void Control(){
        Botoes b = new Botoes();
        tela.getBtnFinalizar().addActionListener(b);
        tela.getBtnCancelar().addActionListener(b);
        
        tela.getBtnAdicionarPassageiro().addActionListener(b);
        
       
        tela.getBtnConcluir().addActionListener(b);
        
        tela.getComboPassageiro().addItemListener(mudarE);
        tela.getComboTransporte().addItemListener(mudarE);
        
    }
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnFinalizar()){
                if(!tela.getComboPassageiro().getSelectedItem().equals("Vazio")){
                Transporte transporte = BaseDados.getTransportes().get(comboMarcado);
                Passageiro passageiro = fachada.buscarCpfPassageiro(tela.getLblCpf().getText());
                if(fachada.salvar(new Viagem(passageiro,transporte.getDestino(), transporte, preco+"",getDataAtual(),getHorario()))){
                    ocuparVagas(passageiro, transporte);
                    fachada.salvar(new Financa(getDataAtual(), preco));
                    BaseDados.CarregarViagem();
                    BaseDados.CarregarFinanca();
                    Mensagens.mensagem("Compra realizado com sucesso!");
                    tela.getBtnCancelar().doClick();
                    ccViagem.getjMenuAtualizar().doClick();
                }else{
                    Mensagens.mensagem("Erro ao realizar a compra!");
                }
                }else{
                    Mensagens.mensagem("Erro, não é possivel cadastrar uma viagem sem passageiro!");
                }
            }
            if(e.getSource() == tela.getBtnCancelar()){
                tela.setVisible(false);
                        
            }
            if(e.getSource() == tela.getBtnAdicionarPassageiro()){
                cPassageiro.setVisible(true);
            }
                        
            if(e.getSource() == tela.getBtnConcluir()){
                pegarVagas();
                
                setChanged();
                 String [] dados = {"concluir","","",""};
                notifyObservers(dados);
            }
        }
    
    }
    
    public void montarComboPassageiro(){
        tela.getComboPassageiro().removeAllItems();
        passageiros = new Passageiro[BaseDados.passageiroCountActive()];
        int i=0;
        if(BaseDados.passageiroCountActive()>0){
        for(Passageiro p:BaseDados.getPassageiros()){
            if(p.getStatus().equals("ATIVO")){
                tela.getComboPassageiro().addItem(p.getNome()+" "+p.getSobrenome());
                passageiros[i] = p;
                i++;
            }
        }
        }else{
            tela.getComboPassageiro().addItem("Vazio");
        }
    }
    public void montarComboRota(){
        Transporte transporte = BaseDados.getTransportes().get(comboMarcado);
        String nome = transporte.getDestino().getNome();
        String preco = transporte.getDestino().getPreco();
        tela.getLblNomeRota().setText(nome);
        tela.getLblPreco().setText(preco);
        
    }
    public void montarComboTransporte(){
        tela.getComboTransporte().removeAllItems();
        for(Transporte t:BaseDados.getTransportes()){
            tela.getComboTransporte().addItem(t.getTipo().getNome()+" Cor: "+t.getCor()+" Placa: "+t.getPlaca());
        }
    }
    public void montarComboHorario(){
        String horario = BaseDados.getTransportes().get(comboMarcado).getDestino().getHorario();
        tela.getLblHorario().setText(horario);
    }
    public void montarPreco(){
        double preco1 = Double.parseDouble(tela.getLblPreco().getText());
        double total = preco1 * id_selecionado.size();
        preco = total;
        DecimalFormat df = new DecimalFormat("R$ #,##0.00");
        tela.getLblPrecoVariavel().setText(df.format(total));
    }
    
    public void montarAssentos(){
        tela.getjPanel7().removeAll();
        
        int id=BaseDados.getTransportes().get(comboMarcado).getId();
        
        assentoL = fachada.buscarLivreVaga(id);
        int quant = assentoL.size();
        vagas = new ArrayList<>();
        for(int i=0;i<quant;i++){
            JCheckBox jcb = new JCheckBox("Assento "+(assentoL.get(i).getNumero())); 
            jcb.setBackground(Color.WHITE);
            vagas.add(jcb);
        }
        for(JCheckBox jc:vagas){
            tela.getjPanel7().add(jc);
        }
        
    }
    public void ocuparVagas(Passageiro passageiro,Transporte transporte){
        for(int i:id_selecionado){
            fachada.adicionarPassageiroAssento(i, passageiro.getId());
        }
    }
    public void pegarVagas(){
        id_selecionado = new ArrayList<>();
        vagasSelecionadas ="Foram selecionadas:\n";
        for(JCheckBox jc:vagas){
            if(jc.isSelected()){
                String [] as = jc.getText().split(" ");
                int id_assento = fachada.buscarNumeroId(Integer.parseInt(as[1]));
                int id_transporte = BaseDados.getTransportes().get(comboMarcado).getId();
                id_selecionado.add(fachada.buscarIdTransporteAssento(id_transporte, id_assento));
                vagasSelecionadas+="Cadeira nº"+as[1]+"\n";
            }
        }
    }
    
    
    public void desabilitarEvento(){
        tela.getComboPassageiro().removeItemListener(mudarE);
    }
    public void habilitarEvento(){
        tela.getComboPassageiro().addItemListener(mudarE);
    }
    
    private class mudarCombo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource() == tela.getComboPassageiro()){
                setChanged();
                Passageiro passageiro = passageiros[tela.getComboPassageiro().getSelectedIndex()];
                String [] dados = {passageiro.getNome(),passageiro.getSobrenome(),passageiro.getCpf(),"passageiro"};
                notifyObservers(dados);
            }
            if(e.getSource() == tela.getComboTransporte()){
                
                comboMarcado = tela.getComboTransporte().getSelectedIndex();
                if(comboMarcado!=-1){
                    String [] dados = {"vagas_livres","","",""};
                    setChanged();
                    notifyObservers(dados);
                }
                
            }
        }
    }
    public String getDataAtual(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        
        return formatador.format(data);
        
    }
    public String getHorario(){
        Date data = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        return c.getTime().getHours()+":"+c.getTime().getMinutes()+":"+c.getTime().getSeconds();
    }

    public CadastroViagem getTela() {
        return tela;
    }

    public Fachada getFachada() {
        return fachada;
    }

    public int getComboMarcado() {
        return comboMarcado;
    }

    public void setComboMarcado(int comboMarcado) {
        this.comboMarcado = comboMarcado;
    }

    public String getVagasSelecionadas() {
        return vagasSelecionadas;
    }

    public void setVagasSelecionadas(String vagasSelecionadas) {
        this.vagasSelecionadas = vagasSelecionadas;
    }

    public Passageiro[] getPassageiros() {
        return passageiros;
    }
    
}
