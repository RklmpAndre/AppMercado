package persist;

import entity.ItemCarrinho;
import java.sql.ResultSet;
import entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author andre; arthur
 */
public class ItemCarrinhoDAO implements DAO {

    private static ItemCarrinhoDAO idao;
    private static Connection conexao;

    public static ItemCarrinhoDAO getInstance() {
        if (idao == null) {
            idao = new ItemCarrinhoDAO();
        }
        return idao;
    }

    private ItemCarrinhoDAO() {
        ConexaoBD conexaoBD;

        try {
            conexaoBD = ConexaoBD.getInstance();
            conexao = ConexaoBD.getConexao();
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro = " + ex);
        } catch (SQLException ex) {
            //Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro = " + ex);
        }

    }

    @Override
    public boolean create(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof ItemCarrinho) {
            ItemCarrinho i = (ItemCarrinho) obj;
            int carrinho_id = i.getCarrinhoID();
            int produto_id = i.getProdutoID();
            int quantidade = i.getQuantidade();
            String sql = "INSERT INTO item_carrinho (carrinho_id, produto_id, quantidade)"
                    + "VALUES ( ?, ?, ?)";
            try {
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, carrinho_id);
                pstmt.setInt(2, produto_id);
                pstmt.setInt(3, quantidade);
                pstmt.executeUpdate();
                return true;
            } catch (SQLException sqe) {
                System.out.println("Erro = " + sqe);
                return true;
            }
        }
        return false;
    }

    @Override
    public Object read(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof Integer[]) {
            try {
                Integer[] keys = (Integer[]) obj;
                int carrinhoId = keys[0];
                int produtoId = keys[1];
                String sql = "SELECT * FROM item_carrinho WHERE carrinho_id = ? AND produto_id = ?";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, carrinhoId);
                pstmt.setInt(2, produtoId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    int quantidade = rs.getInt(3);
                    ItemCarrinho item = new ItemCarrinho(carrinhoId, produtoId, quantidade);
                    return item;
                }
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex);
            }
        }
        return null;

    }

    @Override
    public boolean update(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof ItemCarrinho) {
            ItemCarrinho i = (ItemCarrinho) obj;
            try {
                String sql = "UPDATE item_carrinho SET quantidade = ? WHERE carrinho_id = ? AND produto_id = ?";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, i.getQuantidade());
                pstmt.setInt(2, i.getCarrinhoID());
                pstmt.setInt(3, i.getProdutoID());
                pstmt.executeUpdate();
                return true;
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex);
            }
        }
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof Integer[]) {
            try {
                Integer[] keys = (Integer[]) obj;
                String sql = "DELETE FROM item_carrinho WHERE carrinho_id = '" + keys[0] + "' AND produto_id = '" + keys[1] + "'";
                Statement stmt = conexao.createStatement();
                int nreg = stmt.executeUpdate(sql);
                if (nreg > 0) {
                    return true;
                }
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex);
            }
        }
        return false;
    }

    public List<ItemCarrinho> listarItensCarrinho(int carrinho_id) {
        List<ItemCarrinho> itensCarrinho = new ArrayList<>();
        try {
            String sql = "SELECT * FROM item_carrinho WHERE carrinho_id = " + carrinho_id;
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int produtoId = rs.getInt(2);
                int quantidade = rs.getInt(3);

                ItemCarrinho item = new ItemCarrinho(carrinho_id, produtoId, quantidade);

                itensCarrinho.add(item);
            }
        } catch (SQLException sqe) {
            System.out.println("Erro = " + sqe);
        }
        return itensCarrinho;
    }
}
