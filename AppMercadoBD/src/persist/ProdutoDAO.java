package persist;

import entity.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.TipoProduto;

/**
 *
 * @author andre; arthur
 */
public class ProdutoDAO implements DAO {

    private static ProdutoDAO prdao;
    private static Connection conexao;

    public static ProdutoDAO getInstance() {
        if (prdao == null) {
            prdao = new ProdutoDAO();
        }
        return prdao;
    }

    private ProdutoDAO() {
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
        if (obj instanceof Produto) {
            int id = -1;
            Produto p = (Produto) obj;
            String descricao = p.getDescricao();
            String marca = p.getMarca();
            String nome = p.getNome();
            double preco = p.getPreco();
            int quantidade = p.getQuantidade();
            int tipoOrdinal = p.getTipo().ordinal();
            try {
                String sql = "INSERT INTO estoque (marca, nome, quantidade, descricao, preco, tipo) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, marca);
                pstmt.setString(2, nome);
                pstmt.setInt(3, quantidade);
                pstmt.setString(4, descricao);
                pstmt.setDouble(5, preco);
                pstmt.setInt(6, tipoOrdinal);
                pstmt.executeUpdate();

                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            } catch (SQLException sqe) {
                System.out.println("Erro = " + sqe);
            }
            return true;
        }
        return false;
    }

    @Override
    public Object read(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof Integer) {
            try {
                Integer codigo = (Integer) obj;
                String sql = "SELECT * FROM estoque WHERE id = '" + codigo + "'";
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.isBeforeFirst()) {
                    rs.next();
                    int id = rs.getInt(1);
                    String marca = rs.getString(2);
                    String nome = rs.getString(3);
                    int quantidade = rs.getInt(4);
                    String descricao = rs.getString(5);
                    double preco = rs.getDouble(6);
                    int tipo = rs.getInt(7);
                    Produto p = new Produto(marca, nome, descricao, quantidade, preco, TipoProduto.fromInt(tipo));

                    p.setId(id);

                    return p;
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
        if (obj instanceof Produto) {
            Produto p = (Produto) obj;
            try {
                String sql = "UPDATE estoque SET marca = ?, nome = ?, quantidade = ?, descricao = ?, preco = ?, tipo = ? WHERE id = ?";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setString(1, p.getMarca());
                pstmt.setString(2, p.getNome());
                pstmt.setInt(3, p.getQuantidade());
                pstmt.setString(4, p.getDescricao());
                pstmt.setDouble(5, p.getPreco());
                pstmt.setInt(6, p.getTipo().ordinal());
                pstmt.setInt(7, p.getId());
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
        if (obj instanceof Integer) {
            try {
                Integer id = (Integer) obj;
                String sql = "DELETE FROM estoque WHERE id = '" + id + "'";
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

    public List<Produto> listarTudo() {
        List<Produto> produtos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM estoque";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String marca = rs.getString(2);
                String nome = rs.getString(3);
                int quantidade = rs.getInt(4);
                String descricao = rs.getString(5);
                double preco = rs.getDouble(6);
                int tipo = rs.getInt(7);
                Produto produto = new Produto(marca, nome, descricao, quantidade, preco, TipoProduto.fromInt(tipo));
                produto.setId(id);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex);
        }
        return produtos;
    }

}
