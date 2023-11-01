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
        ProdutoDAO prdao = ProdutoDAO.getInstance();
        
        System.out.println(prdao.read(1));
        System.out.println(prdao.read(2));
        System.out.println(prdao.read(3));
    }

}
