package view;

import entity.Pessoa;
import entity.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import persist.PessoaDAO;

/**
 *
 * @author andre
 */
public class App {
    public static void main(String[] args) {
        Usuario user = new Usuario("a@a.com", "12345678");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse("03/07/2003", formato);
        
        Pessoa p = new Pessoa("040.217.400-31", "André", "Mendes Pinto", dataNascimento);
        p.setUser(user);
        
        PessoaDAO pdao = PessoaDAO.getInstance();
        
        pdao.create(p);
    }
    
}
