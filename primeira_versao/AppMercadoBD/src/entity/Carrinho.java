package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import util.StatusCarrinho;

/**
 *
 * @author andre; arthur
 */
public class Carrinho {

    private int id;
    private double totalCompra;
    private String userCPF;
    private List<ItemCarrinho> itens;
    private LocalDate data_criacao;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private StatusCarrinho status;
     
   
    public Carrinho() {

    }
    
    public Carrinho(String userCPF, LocalDate data_criacao){
        setUserCPF(userCPF);
        setDataCricao(data_criacao);
        itens = new ArrayList<>();
        status = StatusCarrinho.ATIVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0){
            throw new IllegalArgumentException("ID inválido");
        }
        this.id = id;
    }

    public String getUserCPF() {
        return userCPF;
    }

    public void setUserCPF(String userCPF) {
        Objects.requireNonNull(userCPF);
        this.userCPF = userCPF;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }
    
    public LocalDate getDataCriacao() {
        return data_criacao;
    }

    public String getDataCriacaoString() {
        return data_criacao.format(formatter);
    }

    public void setDataCricao(LocalDate dataNascimento) {
        Objects.requireNonNull(dataNascimento);
        this.data_criacao = dataNascimento;
    }

    public StatusCarrinho getStatus() {
        return status;
    }

    public void setStatus(StatusCarrinho status) {
        this.status = status;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        if(totalCompra < 0.0){
            throw new IllegalArgumentException("Valor inválido");
        }
        this.totalCompra = totalCompra;
    }

    
    
}
