package entity;

import java.util.Objects;
import util.UnidadeFederacao;

/**
 *
 * @author andre; arthur
 */
public class Endereco {
    private String nome, logradouro, complemento, bairro, cidade, cep;
    private int numero;
    private UnidadeFederacao estado;

    public Endereco() {
    }
    
    public Endereco(String cep, String cidade, UnidadeFederacao estado, String bairro, String logradouro, int numero, String complemento, String nome) {
        setCep(cep);
        setCidade(cidade);
        setEstado(estado);
        setBairro(bairro);
        setLogradouro(logradouro);
        setNumero(numero);
        setComplemento(complemento);
        setNome(nome);
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public UnidadeFederacao getEstado() {
        return estado;
    }

    public void setEstado(UnidadeFederacao estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.logradouro);
        hash = 67 * hash + Objects.hashCode(this.complemento);
        hash = 67 * hash + Objects.hashCode(this.bairro);
        hash = 67 * hash + Objects.hashCode(this.cidade);
        hash = 67 * hash + Objects.hashCode(this.cep);
        hash = 67 * hash + this.numero;
        hash = 67 * hash + Objects.hashCode(this.estado);
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
        final Endereco other = (Endereco) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.logradouro, other.logradouro)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        return this.estado == other.estado;
    }
    
    @Override
    public String toString() {
        return "Rua='" + getLogradouro() + '\'' +
                ", numero='" + getNumero() + '\'' +
                ", complemento='" + getComplemento() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", bairro='" + getBairro() + '\'' +
                ", cidade='" + getCidade() + '\'' +
                ", estado='" + getEstado() + '\'' +
                ", cep='" + getCep() + '\'' +
                '}';
    }
}
