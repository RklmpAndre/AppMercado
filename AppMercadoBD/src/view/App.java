package view;

import Controller.Controller;
import entity.Historico;
import entity.ItemEscolhido;
import entity.Pessoa;
import entity.Produto;
import persist.ItemEscolhidoDAO;
import persist.PessoaDAO;
import persist.ProdutoDAO;
import util.TipoPagamento;

/**
 *
 * @author andre; arthur
 */
public class App {

    public static void main(String[] args) {
        new TelaLogin().setVisible(true);

    }
}
