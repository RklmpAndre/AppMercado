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

        pdao.delete("111.222.333-45");
        
    }

}
