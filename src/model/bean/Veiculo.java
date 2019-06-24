package model.bean;

public class Veiculo {

    private String placa;
    private int anofab;
    private int id_marca;
    private int id_modelo;
    private String local_uf;
    private String local_cep;


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnofab() {
        return anofab;
    }

    public void setAnofab(int anofab) {
        this.anofab = anofab;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }

    public String getLocal_uf() {
        return local_uf;
    }

    public void setLocal_uf(String local_uf) {
        this.local_uf = local_uf;
    }

    public String getLocal_cep() {
        return local_cep;
    }

    public void setLocal_cep(String local_cep) {
        this.local_cep = local_cep;
    }
}
