package model.bean;

public class Tipo_Funcionario {

    private int idtipo_funcionario;

    private enum nome{
        MOTORISTA, OPERADOR;
    }

    public nome aux;

    public int getIdtipo_funcionario() {
        return idtipo_funcionario;
    }

    public void setIdtipo_funcionario(int idtipo_funcionario) {
        this.idtipo_funcionario = idtipo_funcionario;
    }

    public String getNome() {
        return this.aux.name();
    }

    public void setNome(String input) {
        this.aux = nome.valueOf(input);
    }  
    
}
