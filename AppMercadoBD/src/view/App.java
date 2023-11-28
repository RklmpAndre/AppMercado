package view;

import Controller.Controller;
import entity.Carrinho;
import entity.Historico;
import entity.ItensCarrinho;
import entity.Pessoa;
import persist.CarrinhoDAO;
import persist.HistoricoDAO;
import persist.ItensCarrinhoDAO;
import persist.PessoaDAO;

/**
 *
 * @author andre; arthur
 */
public class App {

    public static void main(String[] args) {
//        PessoaDAO pdao = PessoaDAO.getInstance();
//        CarrinhoDAO cdao = CarrinhoDAO.getInstance();
//        ItensCarrinhoDAO icdao = ItensCarrinhoDAO.getInstance();
//        Controller cntrl = new Controller();
//        HistoricoDAO hdao = HistoricoDAO.getInstance();
//
//        Pessoa usuario = (Pessoa) pdao.read("040.217.400-31");
//
//        for (Carrinho c : cdao.listarCarrinhos(usuario)) {
//            Historico h = (Historico) hdao.read(c.getId());
//            System.out.println(h.toString());
//        }
//        for (ItensCarrinho ic : icdao.listarItensCarrinho(3)) {
//            System.out.println(ic.toString());
//        }
        new TelaLogin().setVisible(true);
    }
}
