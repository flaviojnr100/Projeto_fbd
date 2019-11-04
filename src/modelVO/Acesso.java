/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVO;

/**
 *
 * @author Flavio
 */
public class Acesso {
    private int id;
    private Funcionario funcionario;
    private String horario;
    private String data;

    public Acesso(int id, Funcionario funcionario, String horario, String data) {
        this.id = id;
        this.funcionario = funcionario;
        this.horario = horario;
        this.data = data;
    }
    public Acesso(Funcionario funcionario, String horario, String data) {
        this.funcionario = funcionario;
        this.horario = horario;
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getHorario() {
        return horario;
    }

    public String getData() {
        return data;
    }
    
    
}
