package entity;

import entity.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author andre; arthur
 */
public class Carrinho {

    private int id;
    private String usuario_cpf;
    private LocalDate data_compra;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   
    public Carrinho() {

    }
    
    public Carrinho(String usuario_cpf, LocalDate data_compra){
        setUsuarioCpf(usuario_cpf);
        setDataCompra(data_compra);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuarioCpf() {
        return usuario_cpf;
    }

    public void setUsuarioCpf(String usuario_cpf) {
        this.usuario_cpf = usuario_cpf;
    }

    public LocalDate getDataCompra() {
        return data_compra;
    }

    public String getDataCompraString() {
        return data_compra.format(formatter);
    }

    public void setDataCompra(LocalDate data_compra) {
        Objects.requireNonNull(data_compra);
        this.data_compra = data_compra;
    }

}
