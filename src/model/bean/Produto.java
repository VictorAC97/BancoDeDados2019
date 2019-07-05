package model.bean;


public class Produto{
    
    private int idProduto;
    private String nome;
    private float preco;
    private float altura;
    private float largura;
    private float peso;
    private Categoria categoria;

    public Produto(){
    }

    public Produto(String nome, float preco, float altura, float largura, float peso, Categoria categoria){
        this.nome = nome;
        this.preco = preco;
        this.altura = altura;
        this.largura = largura;
        this.peso = peso;
        this.categoria = categoria;
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString(){
        return getNome();
    }
    
}