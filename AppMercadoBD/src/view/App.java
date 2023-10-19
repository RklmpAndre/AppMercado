package view;

import entity.Pessoa;
import entity.Produto;
import entity.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import persist.PessoaDAO;
import persist.ProdutoDAO;
import util.TipoProduto;

/**
 *
 * @author andre
 */
public class App {

    public static void main(String[] args) {
        Usuario user = new Usuario("v@x.com", "12345678");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse("03/07/2003", formato);

        Pessoa p = new Pessoa("022.254.960.21", "André", "Mendes Pinto", dataNascimento);
        p.setUser(user);

       
        PessoaDAO pdao = PessoaDAO.getInstance();
        
        pdao.create(p);
        
    }

}
