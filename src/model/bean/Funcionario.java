package model.bean;

import java.util.Date;

public class Funcionario {

    private int idfuncionario;
    private String nome;
    private String telefone;
    private String dataent;
    private int horas;
    private int id_tipo_funcionario;

    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private enum sexo{
        M, F;
    }
    private sexo aux;

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataent() {
        return dataent;
    }

    public void setDataent(String dataent) {
        this.dataent = dataent;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getId_tipo_funcionario() {
        return id_tipo_funcionario;
    }

    public void setId_tipo_funcionario(int id_tipo_funcionario) {
        this.id_tipo_funcionario = id_tipo_funcionario;
    }


    public String getSexo() {
        return this.aux.name();
    }

    public void setSexo(String input) {
        this.aux = sexo.valueOf(input);
    }
}
