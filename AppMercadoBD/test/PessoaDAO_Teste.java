
import entity.Endereco;
import entity.Pessoa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import persist.PessoaDAO;
import util.UnidadeFederacao;

/**
 *
 * @author andre
 */
public class PessoaDAO_Teste {

    public static void main(String[] args) {
        PessoaDAO pdao = PessoaDAO.getInstance();
        Endereco endereco = new Endereco("Casa", "Brasil", "Capão da Canoa", "Santa Luzia", "Rua Dona Alice", 115, UnidadeFederacao.RIO_GRANDE_DO_SUL);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse("03/07/2003", formato);

        Pessoa p = new Pessoa("040.217.400-31", "André", "Mendes Pinto", dataNascimento, endereco);
        
        pdao.create(p);
    }
}
