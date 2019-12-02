/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import fachada.Fachada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelVO.BaseDados;
import modelVO.Transporte;
import view.CadastroFuncionario;
import view.CadastroMotorista;
import view.CadastroPassageiro;
import view.CadastroRota;
import view.CadastroTransporte;
import view.CadastroViagem;
import view.ConsultarFinança;
import view.ConsultarFuncionario;
import view.ConsultarMotorista;
import view.ConsultarPassageiro;
import view.ConsultarRota;
import view.ConsultarTransporte;
import view.ConsultarViagem;
import view.DashBoard;
import view.InformacaoAtualVeiculo;
import view.Mensagens;
import view.Sobre;
import view.TelaLogin;

import view.Veiculo;

/**
 *
 * @author Flavio
 */
public class ControllerDashBoard extends Observable {
    private DashBoard principal;
    private CadastroFuncionario cFuncionario;
    private ConsultarFuncionario ccFuncionario;
    private CadastroMotorista cMotorista;
    private ConsultarMotorista ccMotorista;
    private CadastroTransporte cTransporte;
    private ConsultarTransporte ccTransporte;
    private CadastroPassageiro cPassageiro;
    private ConsultarPassageiro ccPassageiro;
    private CadastroViagem cViagem;
    private ConsultarViagem ccViagem;
    private CadastroRota cRota;
    private ConsultarRota ccRota;
    
    private TelaLogin tLogin;
    private ControllerConsultarMotorista cccMotorista;
    private ControllerConsultarFuncionario cccFuncionario;
    private ControllerConsultarPassageiro cccPassageiro;
    private ControllerCadastroTransporte ccVeiculo;
    private ControllerConsultarTransporte cccVeiculo;
    private ControllerControleAcesso ccAcesso;
    private ControllerConsultarRota cccRota;
    private ControllerCadastroViagem cccViagem;
    private ControllerConsultarViagem ccccViagem;
    private ConsultarFinança ccFinanca;
    private ControllerConsultaFinanca cccFinanca;
    private List<Veiculo> veiculos;
    private InformacaoAtualVeiculo iaVeiculo;
    private Sobre sobre;
    public ControllerDashBoard(DashBoard principal, CadastroFuncionario cFuncionario, ConsultarFuncionario ccFuncionario, CadastroMotorista cMotorista, ConsultarMotorista ccMotorista, CadastroTransporte cTransporte, ConsultarTransporte ccTransporte, CadastroPassageiro cPassageiro, ConsultarPassageiro ccPassageiro, CadastroRota cRota, ConsultarRota ccRota,CadastroViagem cViagem,ConsultarViagem ccViagem,ControllerConsultarMotorista cccMotorista,ControllerConsultarFuncionario cccFuncionario,ControllerConsultarPassageiro cccPassageiro,ControllerCadastroTransporte ccVeiculo,ControllerConsultarTransporte cccVeiculo,ControllerControleAcesso ccAcesso,TelaLogin tLogin,ControllerConsultarRota cccRota,ControllerCadastroViagem cccViagem,ControllerConsultarViagem ccccViagem,ConsultarFinança ccFinanca,ControllerConsultaFinanca cccFinanca,InformacaoAtualVeiculo iaVeiculo,Sobre sobre) {
        this.principal = principal;
        this.cFuncionario = cFuncionario;
        this.ccFuncionario = ccFuncionario;
        this.cMotorista = cMotorista;
        this.ccMotorista = ccMotorista;
        this.cTransporte = cTransporte;
        this.ccTransporte = ccTransporte;
        this.cPassageiro = cPassageiro;
        this.ccPassageiro = ccPassageiro;
        this.cRota = cRota;
        this.ccRota = ccRota;
        
        this.cViagem = cViagem;
        this.ccViagem = ccViagem;
        this.cccMotorista = cccMotorista;
        this.cccFuncionario = cccFuncionario;
        this.cccPassageiro = cccPassageiro;
        this.ccVeiculo = ccVeiculo;
        this.cccVeiculo = cccVeiculo;
        this.ccAcesso = ccAcesso;
        this.tLogin = tLogin;
        this.cccRota = cccRota;
        this.cccViagem = cccViagem;
        this.ccccViagem = ccccViagem;
        this.ccFinanca = ccFinanca;
        this.cccFinanca = cccFinanca;
        this.iaVeiculo = iaVeiculo;
        this.sobre = sobre;
        montarFundoPrincipal();
        Control();
    }
    

   
    private void Control(){
        principal.getjMenuFuncionarioCadastro().addActionListener(new Menu());
        principal.getjMenuFuncionarioConsulta().addActionListener(new Menu());
        
        principal.getjMenuMotoristaCadastro().addActionListener(new Menu());
        principal.getjMenuMotoristaConsulta().addActionListener(new Menu());
        
        principal.getjMenuVeiculoCadastro().addActionListener(new Menu());
        principal.getjMenuVeiculoConsulta().addActionListener(new Menu());
        
        principal.getjMenuPassageiroCadastro().addActionListener(new Menu());
        principal.getjMenuPassageiroConsulta().addActionListener(new Menu());
        
        principal.getjMenuRotaCadastro().addActionListener(new Menu());
        principal.getjMenuRotaConsulta().addActionListener(new Menu());
        
        principal.getjMenuFinanceiroConsulta().addActionListener(new Menu());
        
        principal.getjMenuSobre().addActionListener(new Menu());
        principal.getjMenuControleAcesso().addActionListener(new Menu());
        
        
        principal.getjMenuLogoff().addActionListener(new Menu());
        principal.getjMenuEncerrarSistema().addActionListener(new Menu());
        
        principal.getBtnEfetuarViagem().addActionListener(new Botoes());
        principal.getBtnConsultarViagem().addActionListener(new Botoes());
        principal.getBtnConsultarVeiculos().addActionListener(new Botoes());
        principal.getBtnConsultarRotas().addActionListener(new Botoes());
        principal.getBtnConsultarPassageiros().addActionListener(new Botoes());
        
        
        iaVeiculo.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iaVeiculo.setVisible(false);
            }
        });
        
        principal.getFundoPrincipal().addMouseListener(new Caixa());
        
        principal.getjMenuAtualizar().addActionListener(new Caixa());
        principal.getjMenuCadastrarPassageiro().addActionListener(new Caixa());
        principal.getjMenuConsultarPassageiro().addActionListener(new Caixa());
        principal.getjMenuCadastroFuncionario().addActionListener(new Caixa());
        principal.getjMenuConsultarFuincionario().addActionListener(new Caixa());
        principal.getjMenuCadastroMotorista().addActionListener(new Caixa());
        principal.getjMenuConsultarMotorista().addActionListener(new Caixa());
        principal.getjMenuCadastroVeiculo().addActionListener(new Caixa());
        principal.getjMenuConsultaVeiculo().addActionListener(new Caixa());
        principal.getjMenuCadastroRota().addActionListener(new Caixa());
        principal.getjMenuConsultaRota().addActionListener(new Caixa());
        principal.getjMenuCadastroViagem().addActionListener(new Caixa());
        principal.getjMenuConsultaViagem().addActionListener(new Caixa());
        principal.getjMenuFinanceiro().addActionListener(new Caixa());
        principal.getjMenuSair().addActionListener(new Caixa());
        principal.getjMenuLoggof1().addActionListener(new Caixa());
        
        sobre.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==sobre.getBtnOk()){
                    sobre.setVisible(false);
                }
            }
        });
        
    }
    
    private class Botoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == principal.getBtnEfetuarViagem()){
                if(BaseDados.transporteCountActive()>0){
                cccViagem.desabilitarEvento();
                cccViagem.montarComboPassageiro();
                cccViagem.montarComboTransporte();
                cccViagem.montarComboRota();
                
                cccViagem.getTela().getComboPassageiro().setSelectedIndex(0);
                if(BaseDados.passageiroCountActive()>0){
                    cccViagem.getTela().getLblNome().setText(cccViagem.getPassageiros()[0].getNome());
                    cccViagem.getTela().getLblSobrenome().setText(cccViagem.getPassageiros()[0].getSobrenome());
                    cccViagem.getTela().getLblCpf().setText(cccViagem.getPassageiros()[0].getCpf());
                }
                cccViagem.setComboMarcado(0);
                cccViagem.montarAssentos();
                cccViagem.habilitarEvento();
                cViagem.getLblPrecoVariavel().setText("R$ 0,00");
                cViagem.setVisible(true);
                }else{
                    Mensagens.mensagem("Não é possivel realizar viagens no momento, pois não há transporte disponivel!");
                }
            }
            if(e.getSource() == principal.getBtnConsultarViagem()){
                
                if(ccccViagem.limpar()){
                    ccccViagem.colocarDados();
                    ccViagem.setVisible(true);
                }else{
                    Mensagens.mensagem("Não há viagens registrado no sistema!");
                }
            }
            if(e.getSource() == principal.getBtnConsultarVeiculos()){
                principal.getjMenuVeiculoConsulta().doClick();
            }
            if(e.getSource() == principal.getBtnConsultarRotas()){
                principal.getjMenuRotaConsulta().doClick();
            }
            if(e.getSource() == principal.getBtnConsultarPassageiros()){
                principal.getjMenuPassageiroConsulta().doClick();
            }
        }
        
    
    }
    public void montarFundoPrincipal(){
        principal.getFundoPrincipal().setVisible(false);
        principal.getFundoPrincipal().removeAll();
        veiculos = new ArrayList<>();
        int pX=10,pY=10,x=0;
        
        for(int i=0;i<BaseDados.getTransportes().size();i++){
            Veiculo v = new Veiculo();
            v.getInformacao().setText(BaseDados.getTransportes().get(i).getPlaca());
            if(BaseDados.getTransportes().get(i).getStatus().equals("DESATIVADO")){
                v.getStatus().setIcon(new ImageIcon(getClass().getClassLoader().getResource("resource/off.png")));
            }else{
                v.getStatus().setIcon(new ImageIcon(getClass().getClassLoader().getResource("resource/on.png")));
            }
            if(Fachada.getInstance().buscarLivre(BaseDados.getTransportes().get(i).getPlaca())==0){
                v.getStatus().setIcon(new ImageIcon(getClass().getClassLoader().getResource("resource/ocupado.png")));
            }
            v.getInformacao().addActionListener(new FundoPrincipal());
            v.setLocation(pX, pY);
            veiculos.add(v);
            principal.getFundoPrincipal().add(veiculos.get(i));
            pX+=5+v.getWidth();
            if(x==5){
                pX=10;
                pY+=v.getHeight()+5;
                x=0;
            }else{
                x++;
            }
        }
        principal.getFundoPrincipal().setVisible(true);
        
    }
    private class FundoPrincipal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int i=0;
            for(Veiculo v:veiculos){
                if(e.getSource() == v.getInformacao()){
                    Transporte t = BaseDados.getTransportes().get(i);
                    iaVeiculo.getLblPlaca().setText(t.getPlaca());
                    iaVeiculo.getLblTipo().setText(t.getTipo().getNome());
                    iaVeiculo.getLblCor().setText(t.getCor());
                    iaVeiculo.getLblChassi().setText(t.getChassi());
                    iaVeiculo.getLblAssentosTotal().setText(t.getTipo().getAssentos()+"");
                    iaVeiculo.getLblNomeMotorista().setText(t.getMotorista().getNome());
                    iaVeiculo.getLblSobrenomeMotorista().setText(t.getMotorista().getSobrenome());
                    iaVeiculo.getLblCnh().setText(t.getMotorista().getCnh());
                    iaVeiculo.getLblNomeViagem().setText(t.getDestino().getNome());
                    iaVeiculo.getLblHorario().setText(t.getDestino().getHorario());
                    iaVeiculo.getLblPreco().setText(t.getDestino().getPreco());
                    
                    int vagas = Fachada.getInstance().buscarLivre(t.getPlaca());
                    iaVeiculo.getLblAssentosVazio().setText(vagas+"");
                    iaVeiculo.setVisible(true);
                    break;
                            
                }
                i++;
            }
            
        }

        
    }
    private class Caixa implements MouseListener,ActionListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                principal.getjPopupMenu1().show(principal.getFundoPrincipal(), e.getX(), e.getY());
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == principal.getjMenuAtualizar()){
                montarFundoPrincipal();
            }
            if(e.getSource() == principal.getjMenuCadastrarPassageiro()){
                principal.getjMenuPassageiroCadastro().doClick();
            }
            if(e.getSource() == principal.getjMenuCadastroFuncionario()){
                principal.getjMenuFuncionarioCadastro().doClick();
            }
            if(e.getSource() == principal.getjMenuCadastroMotorista()){
                principal.getjMenuMotoristaCadastro().doClick();
            }
            if(e.getSource() == principal.getjMenuCadastroRota()){
                principal.getjMenuRotaCadastro().doClick();
            }
            if(e.getSource() == principal.getjMenuCadastroVeiculo()){
                principal.getjMenuVeiculoCadastro().doClick();
            }
            if(e.getSource() == principal.getjMenuCadastroViagem()){
                principal.getBtnEfetuarViagem().doClick();
            }
            if(e.getSource() == principal.getjMenuConsultaRota()){
                principal.getjMenuRotaConsulta().doClick();
            }
            if(e.getSource() == principal.getjMenuConsultaVeiculo()){
                principal.getjMenuVeiculoConsulta().doClick();
            }
            if(e.getSource() == principal.getjMenuConsultaViagem()){
                principal.getBtnConsultarViagem().doClick();
            }
            if(e.getSource() == principal.getjMenuConsultarFuincionario()){
                principal.getjMenuFuncionarioConsulta().doClick();
            }
            if(e.getSource() == principal.getjMenuConsultarMotorista()){
                principal.getjMenuMotoristaConsulta().doClick();
            }
            if(e.getSource() == principal.getjMenuConsultarPassageiro()){
                principal.getjMenuPassageiroConsulta().doClick();
            }
            if(e.getSource() == principal.getjMenuFinanceiro()){
                principal.getjMenuFinanceiroConsulta().doClick();
            }
            if(e.getSource() == principal.getjMenuLoggof1()){
                principal.getjMenuLogoff().doClick();
            }
            if(e.getSource() == principal.getjMenuSair()){
                principal.getjMenuEncerrarSistema().doClick();
            }
        }
    }
    private class Menu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == principal.getjMenuFuncionarioCadastro()){
                cFuncionario.setVisible(true);
            }
            
            if(e.getSource() == principal.getjMenuFuncionarioConsulta()){
                ccFuncionario.setVisible(true);
                boolean condicao = cccFuncionario.Limpar();
                cccFuncionario.colocar();
                if(condicao){
                    ccFuncionario.setVisible(true);
                }
            }
            if(e.getSource() == principal.getjMenuMotoristaCadastro()){
                cMotorista.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuMotoristaConsulta()){
                boolean condicao = cccMotorista.LimparDados();
                cccMotorista.ColocarDados();
                if(condicao){
                    ccMotorista.setVisible(true);
                }
            }
            if(e.getSource() == principal.getjMenuVeiculoCadastro()){
                ccVeiculo.desabilitarEvento();
                ccVeiculo.montarComboMotorista();
                ccVeiculo.montarComboTipo();
                ccVeiculo.montarComboRota();
                ccVeiculo.getTela().getComboMotorista().setSelectedIndex(0);
                ccVeiculo.getTela().getComboRota().setSelectedIndex(0);
                ccVeiculo.getTela().getComboTipo().setSelectedIndex(0);
                ccVeiculo.mudarLista();
                ccVeiculo.habilitarEvento();
                cTransporte.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuVeiculoConsulta()){
                if(cccVeiculo.limpar()){
                    cccVeiculo.ColocarDados();
                    ccTransporte.setVisible(true);
                }
            }
            if(e.getSource() == principal.getjMenuPassageiroCadastro()){
                cPassageiro.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuPassageiroConsulta()){
                if(cccPassageiro.limpar()){
                    cccPassageiro.colocarDados();
                    ccPassageiro.setVisible(true);
                }
                
            }
            if(e.getSource() == principal.getjMenuRotaCadastro()){
                cRota.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuRotaConsulta()){
                if(cccRota.LimparDados()){
                    cccRota.colocarDados();
                    ccRota.setVisible(true);
                }
            }
            if(e.getSource() == principal.getjMenuFinanceiroConsulta()){
                if(cccFinanca.Limpar()){
                    cccFinanca.ColocarDados();
                    ccFinanca.setVisible(true);
                }else{
                    Mensagens.mensagem("Não há nenhum dado financeiro registrado no sistema!");
                }
            }
            if(e.getSource() == principal.getjMenuSobre()){
                sobre.setVisible(true);
            }
            if(e.getSource() == principal.getjMenuControleAcesso()){
                if(ccAcesso.limpar()){
                    ccAcesso.colocarDados();
                    ccAcesso.getTela().setVisible(true);
                    
                }
            }
                        
            if(e.getSource() == principal.getjMenuLogoff()){
                if(Mensagens.mensagemConfirmacao("Você deseja sair do sistema?")){
                    principal.setVisible(false);
                    tLogin.setVisible(true);
                }
            }
            
            if(e.getSource() == principal.getjMenuEncerrarSistema()){
                if(Mensagens.mensagemConfirmacao("Deseja sair do sistema?")){
                    System.exit(0);
                }
            }
        }
    
    }
    
    
}
