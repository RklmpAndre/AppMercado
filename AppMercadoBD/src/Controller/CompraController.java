package Controller;

import entity.ItemEscolhido;
import persist.ItensCarrinhoDAO;
import persist.ProdutoDAO;
import entity.ItensCarrinho;
import entity.Pessoa;
import entity.Produto;
import java.util.List;
import persist.ItemEscolhidoDAO;

/**
 *
 * @author andre
 */
public class CompraController {

    private ItensCarrinhoDAO icdao = ItensCarrinhoDAO.getInstance();
    private ItemEscolhidoDAO iedao = ItemEscolhidoDAO.getInstance();
    private ProdutoDAO pdao = ProdutoDAO.getInstance();

    public CompraController() {
    }

    public boolean menosProduto(int carrinho_id, int produto_id, int quantidade) {
        Integer ids[] = {carrinho_id, produto_id};
        ItensCarrinho ic = new ItensCarrinho(carrinho_id, produto_id, quantidade, 0.0);
        if (icdao.retornoCarrinhoProduto(ids) != null) {
            if (quantidade > ic.getQuantidade()) {
                ic.setQuantidade(0);
                icdao.update(ic);
                return true;
            } else {
                ic.setQuantidade(quantidade - ic.getQuantidade());
                icdao.update(ic);
                return true;
            }
        }
        return false;
    }

    public boolean maisProduto(Pessoa usuario, Produto produto, int quantidade) {
        ItemEscolhido ie = new ItemEscolhido(produto, quantidade, valorProdutosCarrinho(produto.getId(), quantidade), usuario);
        if(iedao.read(ie) == null){
            iedao.create(ie);
        }else{
            ie.setQuantidade(quantidade * ie.getQuantidade());
            iedao.update(ie);
        }
        return false;
    }

    public void limparCarrinho(int carrinhoId) {
        List<ItensCarrinho> itens = listarProdutosCarrinho(carrinhoId);
        for (ItensCarrinho item : itens) {
            removerProduto(carrinhoId, item.getProduto_id());
        }
    }

    public boolean removerProduto(int carrinho_id, int produto_id) {
        Integer ids[] = {carrinho_id, produto_id};
        ItensCarrinho ic = (ItensCarrinho) icdao.retornoCarrinhoProduto(ids);
        if (icdao.delete(ic)) {
            return true;
        }
        return false;
    }

    public double valorProdutosCarrinho(int produto_id, int quantidade) {
        double valor = 0.0;
        if (pdao.read(produto_id) != null) {
            Produto p = (Produto) pdao.read(produto_id);
            valor = quantidade * p.getPreco();
            return valor;
        }
        return 0.0;
    }

    public List<ItensCarrinho> listarProdutosCarrinho(int carrinho_id) {
        return icdao.listarItensCarrinho(carrinho_id);
    }

}
