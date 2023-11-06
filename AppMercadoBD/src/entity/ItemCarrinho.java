package entity;

/**
 *
 * @author andre; arthur
 */
public class ItemCarrinho {

    private int carrinhoID, produtoID, quantidade;

    public ItemCarrinho() {

    }
    
    public ItemCarrinho(int carrinhoID, int produtoID){
        setCarrinhoID(carrinhoID);
        setProdutoID(produtoID);
    }
    
    public ItemCarrinho(int carrinhoID, int produtoID, int quantidade) {
        this(carrinhoID, produtoID);
        setQuantidade(quantidade);
    }

    public int getCarrinhoID() {
        return carrinhoID;
    }

    public void setCarrinhoID(int carrinhoID) {
        if (carrinhoID < 0) {
            throw new IllegalArgumentException("CarrinhoID inválido");
        }
        this.carrinhoID = carrinhoID;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        if (produtoID < 0) {
            throw new IllegalArgumentException("ProdutoID inválido");
        }
        this.produtoID = produtoID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ItemCarrinho other = (ItemCarrinho) obj;
        if (this.carrinhoID != other.carrinhoID) {
            return false;
        }
        return this.produtoID == other.produtoID;
    }
    
    @Override
    public String toString() {
        return "ItemCarrinho{" + "carrinhoID=" + carrinhoID + ", produtoID=" + produtoID + ", quantidade=" + quantidade + '}';
    }
}
