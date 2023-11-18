package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import util.TipoPagamento;

/**
 *
 * @author andre; arthur
 */
public class Compra {

    private List<ItemComprado> itemComprado;//
    private int id, historico_id;
    private double precoTotal;
    private LocalDate dataEntrega;
    private final LocalDate dataCompra = LocalDate.now();//
    private boolean pedidoEntrega;//
    private TipoPagamento tipoPagamento;
    private Endereco enderecoEntrega;//
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Compra() {
    }

    public Compra(int historico_id, List<ItemComprado> itemComprado, double precoTotal, LocalDate dataEntrega, boolean pedidoEntrega, TipoPagamento tipoPagamento) {
        setItemComprado(itemComprado);
        setPrecoTotal(precoTotal);
        setDataEntrega(dataEntrega);
        setPedidoEntrega(pedidoEntrega);
        setTipoPagamento(tipoPagamento);
        setHistorico_id(historico_id);

    }

    public Compra(int historico_id, List<ItemComprado> itemComprado, double precoTotal, LocalDate dataEntrega, boolean pedidoEntrega, TipoPagamento tipoPagamento, Endereco enderecoEntrega) {
        this(historico_id, itemComprado, precoTotal, dataEntrega, pedidoEntrega, tipoPagamento);
        setEnderecoEntrega(enderecoEntrega);
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public String getDataCompraString() {
        return dataCompra.format(formatter);
    }
    
    public boolean isPedidoEntrega() {
        return pedidoEntrega;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHistorico_id() {
        return historico_id;
    }

    public void setHistorico_id(int historico_id) {
        this.historico_id = historico_id;
    }

    public List<ItemComprado> getItemComprado() {
        return itemComprado;
    }

    public void setItemComprado(List<ItemComprado> itemComprado) {
        this.itemComprado = itemComprado;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public String getDataEntregaString() {
        return dataEntrega.format(formatter);
    }

    public void setDataEntrega(LocalDate dataCompra) {
        Objects.requireNonNull(dataCompra);
        this.dataEntrega = dataCompra;
    }

    public boolean getPedidoEntrega() {
        return pedidoEntrega;
    }

    public void setPedidoEntrega(boolean pedidoEntrega) {
        this.pedidoEntrega = pedidoEntrega;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {

        this.enderecoEntrega = enderecoEntrega;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String toString() {
        if (getPedidoEntrega()) {
            return "Compra do dia: " + getDataCompraString() + "\nPedido de Entrega: Sim" + "\nEndereço: " + getEnderecoEntrega()
                    + "\n" + itemComprado.toString() + "\nTotal: " + getPrecoTotal() + "\nForma de Pagamento: " + getTipoPagamento().getTipoProduto();
        }
        return "Compra do dia: " + getDataCompraString() + "\nPedido de Entrega: Não\n" + itemComprado.toString() + "Total: " + getPrecoTotal() + "\nForma de Pagamento: " + getTipoPagamento().getTipoProduto();
    }
    public static void CompraString(){
        
    }
}
