package Controller;

import entity.ItemCarrinho;
import entity.Produto;
import java.util.List;
import persist.ItemCarrinhoDAO;
import persist.ProdutoDAO;

/**
 *
 * @author andre; arthur
 */
public class CarrinhoController {

    public boolean adicionarProdutosCarrinho(int carrinho_id, int produto_id, int quantidade) {
        ItemCarrinho item = new ItemCarrinho(carrinho_id, produto_id, quantidade);
        Integer chave[] = {item.getCarrinhoID(), item.getProdutoID()};
        if (!item.equals(ItemCarrinhoDAO.getInstance().read(chave))) {
            ItemCarrinhoDAO.getInstance().create(item);
            return true;
        } else {
            ItemCarrinhoDAO.getInstance().update(item);
        }
        return false;
    }

    public boolean removerProdutosCarrinho(int carrinho_id, int produto_id) {
        ItemCarrinho item = new ItemCarrinho(carrinho_id, produto_id);
        Integer chave[] = {item.getCarrinhoID(), item.getProdutoID()};
        if (ItemCarrinhoDAO.getInstance().delete(chave)) {
            return true;
        }
        return false;
    }

    public double calculoTotal(int carrinho_id) {
        List<ItemCarrinho> itens = listarProdutosCarrinho(carrinho_id);
        double total = 0.0;

        for (ItemCarrinho item : itens) {
            Produto produto = (Produto) ProdutoDAO.getInstance().read(item.getProdutoID()); // Obtenha informações do produto
            double preco = produto.getPreco();
            int quantidade = item.getQuantidade();

            total += preco * quantidade;
        }

        return total;
    }

    public double produtoValor(int carrinho_id, int produto_id) {
        List<ItemCarrinho> itens = listarProdutosCarrinho(carrinho_id);

        for (ItemCarrinho item : itens) {
            if (item.getProdutoID() == produto_id) {
                Produto produto = (Produto) ProdutoDAO.getInstance().read(item.getProdutoID()); // Obtenha informações do produto
                double preco = produto.getPreco();
                int quantidade = item.getQuantidade();
                return preco * quantidade;
            }
        }

        return 0.0; // Retorna 0 se o produto não for encontrado no carrinho
    }

    public List<ItemCarrinho> listarProdutosCarrinho(int carrinho_id) {

        return ItemCarrinhoDAO.getInstance().listarItensCarrinho(carrinho_id);

    }
}
