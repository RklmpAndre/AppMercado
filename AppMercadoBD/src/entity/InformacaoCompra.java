package entity;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author andre; arthur
 */
public class InformacaoCompra {
    private List<Produto> produtos;
    private double precoTotal;
    private LocalDate dataCompra;
    private boolean pedidoEntrega;
    private String tipoPagamento;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public boolean isPedidoEntrega() {
        return pedidoEntrega;
    }

    public void setPedidoEntrega(boolean pedidoEntrega) {
        this.pedidoEntrega = pedidoEntrega;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
