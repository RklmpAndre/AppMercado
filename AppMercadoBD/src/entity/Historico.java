package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import util.TipoPagamento;

/**
 *
 * @author andre; arthur
 */
public class Historico {

    private int id, carrinho_id;
    private LocalDate data;
    private boolean entrega;//
    private TipoPagamento tipoPagamento;
    private Endereco endereco;//
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private double total_compra;

    public Historico() {
    }

    public Historico(int carrinho_id, TipoPagamento tipo_pagamento, boolean entrega, double total_compra) {
        setCarrinho_id(carrinho_id);
        setTotal_compra(total_compra);
        setTipoPagamento(tipo_pagamento);
        setEntrega(entrega);
    }

    public Historico(int carrinho_id, TipoPagamento tipo_pagamento, boolean entrega, Endereco endereco, LocalDate data, double total_compra) {
        this(carrinho_id, tipo_pagamento, entrega, total_compra);
        setEnderecoEntrega(endereco);
        setData(data);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(double total_compra) {
        this.total_compra = total_compra;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarrinho_id() {
        return carrinho_id;
    }

    public void setCarrinho_id(int carrinho_id) {
        this.carrinho_id = carrinho_id;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Endereco getEnderecoEntrega() {
        return endereco;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.endereco = enderecoEntrega;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDataString() {
        return data.format(formatter);
    }

    public void setData(LocalDate data) {
        Objects.requireNonNull(data);
        this.data = data;
    }
}
