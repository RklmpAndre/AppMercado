package persist;

import entity.ItensCarrinho;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import util.TipoPagamento;

/**
 *
 * @author andre
 */
public class HistoricoTO {
    private LocalDate data_compra, data_entrega;
    private boolean entrega;
    private TipoPagamento tipo_pagamento;
    private double valor_compra;
    private List<ItensCarrinho> produtos_comprados;
    private String endereco;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public HistoricoTO(LocalDate data_compra, LocalDate data_entrega, boolean entrega, TipoPagamento tipo_pagamento, double valor_compra, List<ItensCarrinho> produtos_comprados, String endereco) {
        setData_compra(data_compra);
        setData_entrega(data_entrega);
        setEntrega(entrega);
        setTipo_pagamento(tipo_pagamento);
        setValor_compra(valor_compra);
        setProdutos_comprados(produtos_comprados);
        setEndereco(endereco);
    }
    
    public String getDataCompraString() {
        return data_compra.format(formatter);
    }
    
    public String getDataEntregaString() {
        return data_entrega.format(formatter);
    }
    
    public LocalDate getDataCompra() {
        return data_compra;
    }

    public void setData_compra(LocalDate data_compra) {
        this.data_compra = data_compra;
    }

    public LocalDate getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(LocalDate data_entrega) {
        this.data_entrega = data_entrega;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public TipoPagamento getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(TipoPagamento tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(double valor_compra) {
        this.valor_compra = valor_compra;
    }

    public List<ItensCarrinho> getProdutos_comprados() {
        return produtos_comprados;
    }

    public void setProdutos_comprados(List<ItensCarrinho> produtos_comprados) {
        this.produtos_comprados = produtos_comprados;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "HistoricoTO{" + "data_compra=" + data_compra + ", data_entrega=" + data_entrega + ", entrega=" + entrega + ", tipo_pagamento=" + tipo_pagamento + ", valor_compra=" + valor_compra + ", produtos_comprados=" + produtos_comprados + ", endereco=" + endereco + ", formatter=" + formatter + '}';
    }
    
    
    
}
