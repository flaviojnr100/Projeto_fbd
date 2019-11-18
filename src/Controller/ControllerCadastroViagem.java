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
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.JCheckBox;
import modelVO.Assento;
import modelVO.Destino;
import modelVO.Passageiro;
import modelVO.Transporte;
import modelVO.Viagem;
import view.CadastroPassageiro;
import view.CadastroRota;
import view.CadastroTransporte;
import view.CadastroViagem;
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
    List<JCheckBox> vagas;
    List<Integer> id_selecionado;
    String vagasSelecionadas ="Foram selecionadas:\n";
    public ControllerCadastroViagem(CadastroViagem tela,Fachada fachada,CadastroPassageiro cPassageiro,CadastroRota cRota,CadastroTransporte cTransporte) {
        this.tela = tela;
        this.fachada = fachada;
        this.cPassageiro = cPassageiro;
        this.cRota = cRota;
        this.cTransporte = cTransporte;
        
        Control();
    }
    private void Control(){
        Botoes b = new Botoes();
        tela.getBtnFinalizar().addActionListener(b);
        tela.getBtnCancelar().addActionListener(b);
        
        tela.getBtnAdicionarPassageiro().addActionListener(b);
        
        tela.getBtnAdicionarTransporte().addActionListener(b);
        tela.getBtnConcluir().addActionListener(b);
        
        tela.getComboPassageiro().addItemListener(mudarE);
        tela.getComboTransporte().addItemListener(mudarE);
        
    }
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tela.getBtnFinalizar()){
                if(fachada.salvar(new Viagem(fachada.getAllPassageiro().get(tela.getComboPassageiro().getSelectedIndex()), fachada.getAllTransporte().get(comboMarcado), fachada.getAllTransporte().get(comboMarcado).getDestino(), tela.getLblPreco().getText()+""))){
                    Mensagens.mensagem("Compra realizado com sucesso!");
                }else{
                    Mensagens.mensagem("Erro ao realizar a compra!");
                }
            
            }
            if(e.getSource() == tela.getBtnCancelar()){
                tela.setVisible(false);
                        
            }
            if(e.getSource() == tela.getBtnAdicionarPassageiro()){
                cPassageiro.setVisible(true);
            }
            
            if(e.getSource() == tela.getBtnAdicionarTransporte()){
                cTransporte.setVisible(true);
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
        for(Passageiro p:fachada.getAllPassageiro()){
            tela.getComboPassageiro().addItem(p.getNome()+" "+p.getSobrenome());
        }
    }
    public void montarComboRota(){
        String nome = fachada.getAllTransporte().get(comboMarcado).getDestino().getNome();
        String preco = fachada.getAllTransporte().get(comboMarcado).getDestino().getPreco();
        tela.getLblNomeRota().setText(nome);
        tela.getLblPreco().setText(preco);
        
    }
    public void montarComboTransporte(){
        tela.getComboTransporte().removeAllItems();
        for(Transporte t:fachada.getAllTransporte()){
            tela.getComboTransporte().addItem(t.getTipo().getNome()+" Cor: "+t.getCor()+" Placa: "+t.getPlaca());
        }
    }
    public void montarComboHorario(){
        String horario = fachada.getAllTransporte().get(comboMarcado).getDestino().getHorario();
        tela.getLblHorario().setText(horario);
    }
    public void montarPreco(){
        double preco = Double.parseDouble(tela.getLblPreco().getText());
        double total = preco * id_selecionado.size();
        tela.getLblPrecoVariavel().setText(total+"");
    }
    
    public void montarAssentos(){
        tela.getjPanel7().removeAll();
        int id=fachada.buscarChassi(fachada.getAllTransporte().get(comboMarcado).getChassi()).getId();
        
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
    public void pegarVagas(){
        id_selecionado = new ArrayList<>();
        vagasSelecionadas ="Foram selecionadas:\n";
        for(JCheckBox jc:vagas){
            if(jc.isSelected()){
                String [] as = jc.getText().split(" ");
                int id_assento = fachada.buscarNumeroId(Integer.parseInt(as[1]));
                int id_transporte = fachada.buscarChassi(fachada.getAllTransporte().get(comboMarcado).getChassi()).getId();
                id_selecionado.add(fachada.buscarIdTransporteAssento(id_transporte, id_assento));
                vagasSelecionadas+=as[1]+"\n";
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
                String [] dados = {fachada.getAllPassageiro().get(tela.getComboPassageiro().getSelectedIndex()).getNome(),fachada.getAllPassageiro().get(tela.getComboPassageiro().getSelectedIndex()).getSobrenome(),fachada.getAllPassageiro().get(tela.getComboPassageiro().getSelectedIndex()).getCpf(),"passageiro"};
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
    
}
