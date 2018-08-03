package br.com.entra21java.bean;

/**
 * @author Alunos
 */

public class AlimentoBean {
    
    private int id;
    private String nome;
    private byte quantidade;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(byte quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
