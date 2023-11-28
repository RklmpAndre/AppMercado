package persist;

import entity.ItensCarrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author andre, arthur;
 */
public class ItensCarrinhoDAO implements DAO {

    private static ItensCarrinhoDAO icdao;
    private static Connection conexao;

    public static ItensCarrinhoDAO getInstance() {
        if (icdao == null) {
            icdao = new ItensCarrinhoDAO();
        }
        return icdao;
    }

    private ItensCarrinhoDAO() {
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
        if (obj instanceof ItensCarrinho) {
            ItensCarrinho itensCarrinho = (ItensCarrinho) obj;
            try {
                int id = -1;
                int carrinho_id = itensCarrinho.getCarrinho_id();
                int produto_id = itensCarrinho.getProduto_id();
                int quantidade = itensCarrinho.getQuantidade();
                double valor = itensCarrinho.getValor();
                String sql = "INSERT INTO itens_carrinho (carrinho_id, produto_id, quantidade, valor) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, carrinho_id);
                pstmt.setInt(2, produto_id);
                pstmt.setInt(3, quantidade);
                pstmt.setDouble(4, valor);
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                    itensCarrinho.setId(id);
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
        if (obj instanceof Integer) {
            try {
                Integer id = (Integer) obj;
                String sql = "SELECT * FROM itens_carrinho WHERE id = '" + id + "'";
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.isBeforeFirst()) {
                    rs.next();
                    int carrinho_id = rs.getInt(2);
                    int produto_id = rs.getInt(3);
                    int quantidade = rs.getInt(4);
                    double valor = rs.getDouble(5);
                    ItensCarrinho itensCarrinho = new ItensCarrinho(carrinho_id, produto_id, quantidade, valor);
                    id = rs.getInt(1);
                    itensCarrinho.setId(id);
                    return itensCarrinho;
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
        if (obj instanceof ItensCarrinho) {
            ItensCarrinho ic = (ItensCarrinho) obj;
            String sql = "UPDATE itens_carrinho SET carrinho_id = ?, produto_id = ?, quantidade = ?, valor = ? WHERE id = ?";
            PreparedStatement pstmt;
            try {
                pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, ic.getCarrinho_id());
                pstmt.setInt(2, ic.getProduto_id());
                pstmt.setInt(3, ic.getQuantidade());
                pstmt.setDouble(4, ic.getValor());
                pstmt.setInt(5, ic.getId());
                pstmt.executeUpdate();
                return true;
            } catch (SQLException sqe) {
                System.out.println("Erro = " + sqe);
            }
        }
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object retornoCarrinhoProduto(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof Integer[]) {
            Integer[] ids = (Integer[]) obj;
            int carrinhoId = ids[0];
            int produtoId = ids[1];
            String sql = "SELECT * FROM itens_carrinho WHERE carrinho_id = ? AND produto_id = ?";
            try {
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, carrinhoId);
                pstmt.setInt(2, produtoId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    int quantidade = rs.getInt("quantidade");
                    double valor = rs.getDouble("valor");

                    ItensCarrinho ic = new ItensCarrinho(carrinhoId, produtoId, quantidade, valor);
                    return ic;
                }
            } catch (SQLException sqe) {
                System.out.println("Erro = " + sqe);
            }
        }
        return null;
    }

    public List<ItensCarrinho> listarItensCarrinho(int carrinho_id) {
        List<ItensCarrinho> itensCarrinho = new ArrayList<>();
        try {
            String sql = "SELECT * FROM itens_carrinho WHERE carrinho_id = '" + carrinho_id + "'";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int itens_carrinho_id = rs.getInt(1);
                int produtoId = rs.getInt(3);
                int quantidade = rs.getInt(4);
                double valor = rs.getDouble(5);
                ItensCarrinho item = new ItensCarrinho(carrinho_id, produtoId, quantidade, valor);
                item.setId(itens_carrinho_id);
                
                itensCarrinho.add(item);
            }
        } catch (SQLException sqe) {
            System.out.println("Erro = " + sqe);
        }
        return itensCarrinho;
    }

}
