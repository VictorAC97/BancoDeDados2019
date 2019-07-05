package model.bean;

public class Veiculo {

    private String placa;
    private int anofab;
    private Marca marca;
    private Modelo modelo;
    private String local_uf;
    private String local_cep;

    public Veiculo(){
    }
    
    public Veiculo(String placa, int anofab, String local_uf, String local_cep) {
        this.placa = placa;
        this.anofab = anofab;
        this.local_uf = local_uf;
        this.local_cep = local_cep;
    }

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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
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
