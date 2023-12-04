package Controller;

import entity.Carrinho;
import entity.ItemEscolhido;
import entity.ItensCarrinho;
import entity.Pessoa;
import entity.Produto;
import entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import persist.CarrinhoDAO;
import persist.HistoricoDAO;
import persist.ItemEscolhidoDAO;
import persist.ItensCarrinhoDAO;
import persist.PessoaDAO;
import persist.ProdutoDAO;

/**
 *
 * @author andre
 */
public class Controller {

    PessoaDAO pdao = PessoaDAO.getInstance();
    ItensCarrinhoDAO icdao = ItensCarrinhoDAO.getInstance();
    ItemEscolhidoDAO iedao = ItemEscolhidoDAO.getInstance();
    ProdutoDAO prdao = ProdutoDAO.getInstance();
    CarrinhoDAO cdao = CarrinhoDAO.getInstance();
    HistoricoDAO hdao = HistoricoDAO.getInstance();

    public Controller() {
    }

    public List<Pessoa> retornaTipoUsuario(int valor) {
        return pdao.listarPessoasPorTipo(valor);
    }

    public void esvaziarCarrinho(Pessoa usuario) {
        for (ItemEscolhido item : listarItensEscolhidos(usuario)) {
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
        if (prdao.read(produto.getId()) != null) {
            Produto p = (Produto) prdao.read(produto.getId());
            valor = quantidade * p.getPreco();
            return valor;
        }
        return 0.0;
    }

    public List<ItemEscolhido> listarItensEscolhidos(Pessoa usuario) {
        return iedao.listarItemEscolhido(usuario.getCpf());
    }

    public List<String> listarItensCarrinho(Carrinho carrinho) {
        List<String> produtos = new ArrayList<>();
        List<ItensCarrinho>ic = icdao.listarItensCarrinho(carrinho.getId());
        for(ItensCarrinho itens : icdao.listarItensCarrinho(carrinho.getId())){
            Produto p = (Produto) prdao.read(itens.getProduto_id());
            String produtosString = p.getMarca() + " " + p.getNome() + ", quantidade: " + itens.getQuantidade() + ", valor: " + itens.getValor();
            produtos.add(produtosString);
        }
        return produtos;
    }

    public ItensCarrinho itemFinal(ItemEscolhido item_escolhido, int carrinho_id) {
        Produto produto = item_escolhido.getProduto();
        int quantidade = item_escolhido.getQuantidade();
        double valor = item_escolhido.getValor();
        ItensCarrinho item_carrinho = new ItensCarrinho(carrinho_id, produto.getId(), quantidade, valor);
        return item_carrinho;
    }
    
    public boolean apagarDados(Pessoa usuario){
        for(Carrinho c : cdao.listarCarrinhos(usuario)){
            hdao.delete(c.getId());
            for(ItensCarrinho ic : icdao.listarItensCarrinho(c.getId())){
                icdao.delete(ic.getCarrinho_id());
            }
        }
        for(Carrinho c : cdao.listarCarrinhos(usuario)){
            cdao.delete(c.getId());
        }
        if(pdao.delete(usuario.getCpf())) return true;
        return false;
    }

}
