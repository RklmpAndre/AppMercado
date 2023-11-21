package persist;

import entity.Produto;
import java.util.List;
import java.util.Objects;

public class HistoricoTO {
    
    private List<Produto> produtos;
    private int carrinhoId, produtoId, quantidade, itensCarrinhoId, formaPagamento, entrega;
    private String dataEntrega, endereco, dataCompra;
    private double valor;
    

    public HistoricoTO(String dataCompra, int entrega, int formaPagamento, double totalCompra, List<Produto> produtos, String endereco, String dataEntrega) {
    }

    @Override
    public String toString() {
        return "HistoricoTO{" + "cpf=" + getCpf() + ", dataColeta=" + getDataColeta() + ", altura=" + getAltura() + ", peso=" + getPeso() + ", medidaCintura=" + getMedidaCintura() + ", pressaoMinima=" + getPressaoMinima() + ", pressaoMaxima=" + getPressaoMaxima() + '}';
    }
    