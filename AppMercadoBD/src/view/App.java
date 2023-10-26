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

        PessoaDAO pdao = PessoaDAO.getInstance();

        System.out.println(pdao.read("040.217.400-31"));
    }

}
