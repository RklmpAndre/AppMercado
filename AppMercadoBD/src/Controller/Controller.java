package Controller;

import entity.Carrinho;
import entity.ItemEscolhido;
import entity.ItensCarrinho;
import entity.Pessoa;
import entity.Produto;
import java.time.LocalDate;
import java.util.List;
import persist.CarrinhoDAO;
import persist.ItemEscolhidoDAO;
import persist.ProdutoDAO;

/**
 *
 * @author andre
 */
public class Controller {

    ItemEscolhidoDAO iedao = ItemEscolhidoDAO.getInstance();
    ProdutoDAO pdao = ProdutoDAO.getInstance();
    CarrinhoDAO cdao = CarrinhoDAO.getInstance();

    public Controller() {
    }
    
    public void esvaziarCarrinho(Pessoa usuario) {
        for (ItemEscolhido item : listarItens(usuario)) {
            Object[] keys = {item.getProduto().getId(), usuario.getCpf()};
            iedao.delete(keys);
        }
    }
    
    public boolean maisProduto(Pessoa usuario, Produto produto, int quantidade) {
        ItemEscolhido item_escolhido = new ItemEscolhido(produto, quantidade, valorProdutoCarrinho(produto, quantidade), usuario);
        Object[] keys = {produto.getId(), usuario.getCpf()};
        if (iedao.read(keys) == null) {
            iedao.create(item_escolhido);
            return true;
        } else if (iedao.read(keys) != null) {
            ItemEscolhido item_esEscolhido2 = (ItemEscolhido) iedao.read(keys);
            int quantidadeTotal = item_esEscolhido2.getQuantidade() + quantidade;
            item_escolhido.setQuantidade(quantidadeTotal);
            item_escolhido.setValor(valorProdutoCarrinho(produto, item_escolhido.getQuantidade()));
            iedao.update(item_escolhido);
            return true;
        }
        return false;

    }

    public boolean menosProduto(Pessoa usuario, Produto produto, int quantidade) {
        Object keys[] = {produto.getId(), usuario.getCpf()};
        if (iedao.read(keys) != null) {
            ItemEscolhido item_escolhido = (ItemEscolhido) iedao.read(keys);
            if (quantidade >= item_escolhido.getQuantidade()) {
                iedao.delete(keys);
                return true;
            } else {
                ItemEscolhido item_esEscolhido2 = (ItemEscolhido) iedao.read(keys);
                int quantidadeTotal = item_esEscolhido2.getQuantidade() - quantidade;
                item_escolhido.setQuantidade(quantidadeTotal);
                item_escolhido.setValor(valorProdutoCarrinho(produto, item_escolhido.getQuantidade()));
                iedao.update(item_escolhido);
                return true;
            }
        }
        return false;
    }

    public double valorProdutoCarrinho(Produto produto, int quantidade) {
        double valor = 0.0;
        if (pdao.read(produto.getId()) != null) {
            Produto p = (Produto) pdao.read(produto.getId());
            valor = quantidade * p.getPreco();
            return valor;
        }
        return 0.0;
    }
    
    
    
    public List<ItemEscolhido> listarItens(Pessoa usuario) {
        return iedao.listarItemEscolhido(usuario.getCpf());
    }
    
    public ItensCarrinho itemFinal(ItemEscolhido item_escolhido, int carrinho_id){
        Produto produto = item_escolhido.getProduto();
        int quantidade = item_escolhido.getQuantidade();
        double valor = item_escolhido.getValor();
        ItensCarrinho item_carrinho = new ItensCarrinho(carrinho_id, produto.getId(), quantidade, valor);
        return item_carrinho;
    }
    
}
