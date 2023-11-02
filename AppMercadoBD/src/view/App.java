package view;

import entity.Pessoa;
import entity.Produto;
import entity.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import persist.PessoaDAO;
import persist.ProdutoDAO;
import util.TipoProduto;
import util.TipoUsuario;

/**
 *
 * @author andre
 */
public class App {

    public static void main(String[] args) {
        Produto p = new Produto("Logitech", "G300s", "Mouse gamer", 100, 8.99, TipoProduto.BENS_DE_USO_COMUM);

        ProdutoDAO prdao = ProdutoDAO.getInstance();

        prdao.create(p);
        
    }
}
