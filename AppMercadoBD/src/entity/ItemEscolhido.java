package entity;

/**
 *
 * @author andre
 */
public class ItemEscolhido {
    
    private Produto produto;
    private Pessoa pessoa;
    private int quantidade, id;
    private double valor;

    public ItemEscolhido(Produto produto, int quantidade, double valor, Pessoa p) {
        setProduto(produto);
        setQuantidade(quantidade);
        setValor(valor);
        setPessoa(p);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
