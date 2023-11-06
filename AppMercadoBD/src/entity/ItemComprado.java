package entity;

/**
 *
 * @author andre; arthur
 */
public class ItemComprado{
    private int quantidade;
    private double valorUnitario;
    private Produto produto;
    
    public ItemComprado(Produto produto, int quantidade, double valorUnitario){
        setProduto(produto);
        setQuantidade(quantidade);
        setValorUnitario(valorUnitario);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    @Override
    public String toString() {
        return "Produto: " + produto.getMarca() + " " + produto.getNome() + " " + getQuantidade() + "un " + "R$" + getValorUnitario() + "\n";
    }
}
