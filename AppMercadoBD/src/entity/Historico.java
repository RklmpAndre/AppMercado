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
    private String endereco;//
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

    public Historico(int carrinho_id, TipoPagamento tipo_pagamento, boolean entrega, String endereco, LocalDate data, double total_compra) {
        this(carrinho_id, tipo_pagamento, entrega, total_compra);
        setEndereco(endereco);
        setData(data);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
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
    
    public LocalDate getData() {
        return data;
    }

    public String getDataString() {
        if (getData() == null) {
            return " ";
        }else return data.format(formatter);
    }

    public void setData(LocalDate data) {
        Objects.requireNonNull(data);
        this.data = data;
    }

    public String entregaString() {
        if(isEntrega()){
            return "Sim";
        }else return "Não";
    }
    
    @Override
    public String toString() {
        if(isEntrega()){
            return "Historico{" + "id=" + getId() + ", carrinho_id=" + getCarrinho_id() + ", endereco=" + getEndereco() + ", data_entrega=" + getDataString() + ", forma_pagamento=" +
                getTipoPagamento() + ", entrega=Sim"+ ", total_compra=" + getTotal_compra();
        }else{
            return "Historico[" + "id=" + getId() + ", carrinho_id=" + getCarrinho_id() + ", forma_pagamento=" + getTipoPagamento() + ", entrega=Não" + ", total_compra=" + getTotal_compra();
        }
        
    }

    
    
}
