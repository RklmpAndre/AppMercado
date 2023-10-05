package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author andre
 */
public class Pessoa {

    //relaciona o Usuário com a pessoa
    private Usuario user;
    //cpf será final pois uma pessoa tem apenas 1 cpf
    private String cpf;
    //relaciona o endereço com a pessoa
    private Endereco endereco;

    private String nome, sobrenome;

    private LocalDate dataNascimento;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pessoa(String cpf, String nome, String sobrenome, LocalDate dataNascimento, Endereco endereco) {
        setCpf(cpf);
        setNome(nome);
        setSobrenome(sobrenome);
        setDataNascimento(dataNascimento);
        setEndereco(endereco);
    }
    
    public Pessoa(){
        
    }
    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        Objects.requireNonNull(user);
        this.user = user;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        Objects.requireNonNull(endereco);
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf){
        Objects.requireNonNull(cpf);
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Objects.requireNonNull(nome);
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Objects.requireNonNull(sobrenome);
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getDataNascimentoString() {
        return dataNascimento.format(formatter);
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        Objects.requireNonNull(dataNascimento);
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.sobrenome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " " + getSobrenome() + "\nCPF: " + getCpf() + "\nData de Nascimento: " + getDataNascimentoString()+ "\n" + getEndereco() + "\n";
    }
    
}
