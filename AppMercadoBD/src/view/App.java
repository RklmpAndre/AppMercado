package view;

import Controller.CarrinhoController;
import entity.Carrinho;
import entity.ItemCarrinho;
import entity.Produto;
import persist.CarrinhoDAO;
import persist.ItemCarrinhoDAO;
import persist.ProdutoDAO;

/**
 *
 * @author andre; arthur
 */
public class App {

    public static void main(String[] args) {
        
        new TelaLogin().setVisible(true);
        
    }
}
