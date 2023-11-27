package entity;

import entity.*;
import java.util.Objects;
import util.TipoProduto;


/**
 *
 * @author andre; arthur
 */
public class Produto {
    
    private int id, quantidade;
    private String nome, descricao, marca;
    private double preco;
    private TipoProduto tipo;
    
    public Produto() {
    }

    public Produto(String marca, String nome, String descricao, int quantidade, double preco, TipoProduto tipo) {
        setMarca(marca);
        setNome(nome);
        setDescricao(descricao);
        setQuantidade(quantidade);
        setPreco(preco);
        setTipoProduto(tipo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(id < 0){
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Objects.requireNonNull(nome);
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        Objects.requireNonNull(descricao);
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        Objects.requireNonNull(marca);
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco < 0.0){
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipoProduto (TipoProduto tipo) {
        Objects.requireNonNull(tipo);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + getId() + ", marca=" + getMarca() + ", nome= " + getNome() + ", tipo=" + getTipo().getTipoProduto() + ", descri\u00e7\u00e3o=" + getDescricao() + ", pre\u00e7o=" + getPreco() + ", quantidade=" + getQuantidade() + "}\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + this.quantidade;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.descricao);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.tipo);
        return hash;
    }
    
}