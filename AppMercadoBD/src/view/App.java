package view;

import entity.Pessoa;
import entity.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import persist.PessoaDAO;
import util.TipoUsuario;

/**
 *
 * @author andre
 */
public class App {

    public static void main(String[] args) {
        PessoaDAO pdao = PessoaDAO.getInstance();

        Usuario user = new Usuario("a@aa.com", "12345678");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse("03/07/2003", formatter);

        Pessoa p = new Pessoa("111.222.333-45", "Balan Sarrola", dataNascimento);

        p.setUser(user);
                
        pdao.create(p);
        
       //ALTERAR
       Pessoa p2 = p;
       Usuario user2 = user;
       user.setTipoUsuario(TipoUsuario.ADMIN);
       p2.setUser(user2);
       
       pdao.update(p2);

    }

}
