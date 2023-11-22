package persist;

import entity.Produto;
import java.util.List;

public class HistoricoTO {
    
    private List<Produto> produtos;
    private int carrinhoId, produtoId, quantidade, itensCarrinhoId, formaPagamento, entrega;
    private String dataEntrega, endereco, dataCompra;
    private double valor;
    
    

    public HistoricoTO(String dataCompra, int entrega, int formaPagamento, double totalCompra, List<Produto> produtos, String endereco, String dataEntrega) {
        setDataCompra(dataCompra);
        setEntrega(entrega);
        setFormaPagamento(formaPagamento);
        setValor(totalCompra);
        setProdutos(produtos);
        setEndereco(endereco);
        setDataEntrega(dataEntrega);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getCarrinhoId() {
        return carrinhoId;
    }

    public void setCarrinhoId(int carrinhoId) {
        this.carrinhoId = carrinhoId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getItensCarrinhoId() {
        return itensCarrinhoId;
    }

    public void setItensCarrinhoId(int itensCarrinhoId) {
        this.itensCarrinhoId = itensCarrinhoId;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getEntrega() {
        return entrega;
    }

    public void setEntrega(int entrega) {
        this.entrega = entrega;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
    
}
    