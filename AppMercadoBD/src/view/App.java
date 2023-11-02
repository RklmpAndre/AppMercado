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
<<<<<<< HEAD
        Produto p = new Produto("Logitech", "G300s", "Mouse gamer", 100, 8.99, TipoProduto.BENS_DE_USO_COMUM);

        ProdutoDAO prdao = ProdutoDAO.getInstance();

        prdao.create(p);
=======
        ProdutoDAO prdao = ProdutoDAO.getInstance();
>>>>>>> 758ad7525a836734ad12c7492839ab0931aeb85b
        
        System.out.println(prdao.read(1));
        System.out.println(prdao.read(2));
        System.out.println(prdao.read(3));
    }
}
