package persist;

import entity.ItemEscolhido;
import entity.Produto;
import entity.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class ItemEscolhidoDAO implements DAO {

    private static ItemEscolhidoDAO itemEscolhidoDAO;
    private static Connection conexao;

    public static ItemEscolhidoDAO getInstance() {
        if (itemEscolhidoDAO == null) {
            itemEscolhidoDAO = new ItemEscolhidoDAO();
        }
        return itemEscolhidoDAO;
    }

    private ItemEscolhidoDAO() {
        ConexaoBD conexaoBD;

        try {
            conexaoBD = ConexaoBD.getInstance();
            conexao = ConexaoBD.getConexao();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro = " + ex);
        }
    }

    @Override
    public boolean create(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof ItemEscolhido) {
            ItemEscolhido itemEscolhido = (ItemEscolhido) obj;
            try {
                int idProduto = itemEscolhido.getProduto().getId();
                String usuario_id = itemEscolhido.getPessoa().getCpf();
                int quantidade = itemEscolhido.getQuantidade();
                double valor = itemEscolhido.getValor();

                String sql = "INSERT INTO item_escolhido (produto_id, quantidade, valor, usuario_id) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, idProduto);
                pstmt.setString(4, usuario_id);
                pstmt.setInt(2, quantidade);
                pstmt.setDouble(3, valor);

                pstmt.executeUpdate();

                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    itemEscolhido.setId(id);
                    return true;
                }
            } catch (SQLException sqe) {
                System.out.println("Erro = " + sqe);
            }
        }
        return false;
    }

    @Override
    public Object read(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof Object[]) {
            try {
                Object[] keys = (Object[]) obj;
                int produtoId = (int) keys[0];
                String usuarioId = (String) keys[1];

                String sql = "SELECT * FROM item_escolhido WHERE produto_id = ? AND usuario_id = ?";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, produtoId);
                pstmt.setString(2, usuarioId);

                ResultSet rs = pstmt.executeQuery();
                if (rs.isBeforeFirst()) {
                    rs.next();
                    int id = rs.getInt("id");
                    int quantidade = rs.getInt("quantidade");
                    double valor = rs.getDouble("valor");

                    Produto produto = (Produto) ProdutoDAO.getInstance().read(produtoId);
                    Pessoa pessoa = (Pessoa) PessoaDAO.getInstance().read(usuarioId);
                    ItemEscolhido itemEscolhido = new ItemEscolhido(produto, quantidade, valor, pessoa);
                    itemEscolhido.setId(id);
                    return itemEscolhido;
                }
            } catch (SQLException sqe) {
                System.out.println("Erro = " + sqe);
            }
        }
        return null;
    }

    @Override
    public boolean update(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof ItemEscolhido) {
            try {
                ItemEscolhido item_escolhido = (ItemEscolhido) obj;
                Produto produto = item_escolhido.getProduto();
                Pessoa pessoa = item_escolhido.getPessoa();
                int quantidade = item_escolhido.getQuantidade();
                double valor = item_escolhido.getValor();
                String sql = "UPDATE item_escolhido SET quantidade = ?, valor = ? WHERE produto_id = ? AND usuario_id = ?";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, quantidade);
                pstmt.setDouble(2, valor);
                pstmt.setInt(3, produto.getId());
                pstmt.setString(4, pessoa.getCpf());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex);
            }
        }
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof Object[]) {
            Object[] keys = (Object[]) obj;
            int produtoId = (int) keys[0];
            String usuarioId = (String) keys[1];
            try {
                String sql = "DELETE FROM item_escolhido WHERE produto_id = ? AND usuario_id = ?";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, produtoId);
                pstmt.setString(2, usuarioId);
                
                pstmt.executeUpdate();
            } catch (SQLException sqe) {
                System.out.println("Erro ao apagar item do usuário: " + sqe);
            }
        }

        return false;
    }

    public List<ItemEscolhido> listarItemEscolhido(String usuario_id) {
        List<ItemEscolhido> itensCarrinho = new ArrayList<>();
        try {
            String sql = "SELECT * FROM item_escolhido WHERE usuario_id = ?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, usuario_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idProduto = rs.getInt("produto_id");
                int quantidade = rs.getInt("quantidade");
                double valor = rs.getDouble("valor");

                Produto produto = (Produto) ProdutoDAO.getInstance().read(idProduto);
                Pessoa pessoa = (Pessoa) PessoaDAO.getInstance().read(usuario_id);

                ItemEscolhido itemEscolhido = new ItemEscolhido(produto, quantidade, valor, pessoa);
                itemEscolhido.setId(rs.getInt("id"));
                itensCarrinho.add(itemEscolhido);
            }
        } catch (SQLException sqe) {
            System.out.println("Erro = " + sqe);
        }
        return itensCarrinho;
    }
}
