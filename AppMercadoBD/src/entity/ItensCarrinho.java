package entity;

/**
 *
 * @author andre, arthur;
 */
public class ItensCarrinho {
    private int id, carrinho_id, produto_id, quantidade;
    private double valor;

    public ItensCarrinho(int carrinho_id, int produto_id, int quantidade, double valor) {
        setCarrinho_id(carrinho_id);
        setProduto_id(produto_id);
        setQuantidade(quantidade);
        setValor(valor);
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

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final ItensCarrinho other = (ItensCarrinho) obj;
        if (this.carrinho_id != other.carrinho_id) {
            return false;
        }
        if (this.produto_id != other.produto_id) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        return Double.doubleToLongBits(this.valor) == Double.doubleToLongBits(other.valor);
    }

    @Override
    public String toString() {
        return "ItensCarrinho{" + "id=" + id + ", carrinho_id=" + carrinho_id + ", produto_id=" + produto_id + ", quantidade=" + quantidade + ", valor=" + valor + '}';
    }
    
    
    
}
