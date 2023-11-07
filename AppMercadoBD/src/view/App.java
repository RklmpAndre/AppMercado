package view;

import entity.Compra;
import entity.Endereco;
import entity.ItemComprado;
import entity.Produto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import persist.ComprasDAO;
import persist.HistoricoDAO;
import persist.ProdutoDAO;
import util.TipoPagamento;
import util.UnidadeFederacao;

/**
 *
 * @author andre; arthur
 */
public class App {

    public static void main(String[] args) {
        new TelaLogin().setVisible(true);
        
    }
}
