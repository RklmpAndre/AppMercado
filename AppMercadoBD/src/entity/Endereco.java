package entity;

import util.UnidadeFederacao;

/**
 *
 * @author andre; arthur
 */
public class Endereco2 {
    private String logradouro, complemento, bairro, cidade, cep;
    private int numero;
    private UnidadeFederacao estado;

    public Endereco2() {
    }
    
    public Endereco2 (String logradouro, int numero, String complemento, String bairro, String cidade, UnidadeFederacao estado, String cep){
        setLogradouro(logradouro);
        setNumero(numero);
        setComplemento(complemento);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
        setCep(cep);
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
    public String toString() {
        return "Endereco{" +
                "rua='" + getLogradouro() + '\'' +
                ", numero='" + getNumero() + '\'' +
                ", complemento='" + getComplemento() + '\'' +
                ", bairro='" + getBairro() + '\'' +
                ", cidade='" + getCidade() + '\'' +
                ", estado='" + getEstado() + '\'' +
                ", cep='" + getCep() + '\'' +
                '}';
    }
}
