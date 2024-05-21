package Modelo;

public class Ferramentas {
    private int id;
    private String nome;
    private String marca;
    private double custo;

    public Ferramentas(int id, String nome, String marca, double custo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public double getCusto() {
        return custo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
