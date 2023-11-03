package persist;

import entity.Carrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import util.StatusCarrinho;

/**
 *
 * @author andre; arthur
 */
public class CarrinhoDAO implements DAO {

    private static CarrinhoDAO cdao;
    private static Connection conexao;

    public static CarrinhoDAO getInstance() {
        if (cdao == null) {
            cdao = new CarrinhoDAO();
        }
        return cdao;
    }

    private CarrinhoDAO() {
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
        if (obj instanceof Carrinho) {
            Carrinho c = (Carrinho) obj;
            int id = -1;
            String usercpf = c.getUserCPF();
            String data_criacao = c.getDataCriacaoString();
            int status = c.getStatus().ordinal();
            try {
                String sql = "INSERT INTO carrinhos (userID, data_criação, condição) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, usercpf);
                pstmt.setString(2, data_criacao);
                pstmt.setInt(3, status);
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1); //geralmente a chave primária é a primeira coluna
                    c.setId(id);
                }
                return true;
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
                String sql = "SELECT * FROM carrinhos WHERE id = '" + id + "'";
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.isBeforeFirst()) {
                    rs.next();
                    String userID = rs.getString(2);
                    String data_criacao = rs.getString(3);
                    int status = rs.getInt(4);
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    Carrinho c = new Carrinho(userID, LocalDate.parse(data_criacao, formato));
                    c.setId(rs.getInt(1));
                    c.setStatus(StatusCarrinho.fromInt(status));
                    return c;
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
        if (obj instanceof Carrinho) {
            Carrinho c = (Carrinho) obj;
            try {
                String sql = "UPDATE carrinhos SET data_criação = ?, condição = ? WHERE id = ?";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setString(1, c.getDataCriacaoString());
                pstmt.setInt(2, c.getStatus().ordinal());
                pstmt.setInt(3, c.getId());
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
            Integer id = (Integer) obj;
            try {
                String sql = "DELETE FROM carrinhos WHERE id = '" + id + "'";
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

    public Carrinho readUser(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof String) {
            String userID = (String) obj;
            try {
                String sql = "SELECT * FROM carrinhos WHERE userID = '" + userID + "'";
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.isBeforeFirst()) {
                    rs.next();
                    int id = rs.getInt(1);
                    String data_criacao = rs.getString(3);
                    int status = rs.getInt(4);

                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    Carrinho c = new Carrinho(userID, LocalDate.parse(data_criacao, formato));
                    c.setId(id);
                    c.setStatus(StatusCarrinho.fromInt(status));

                    return c;
                }
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex);
            }
        }
        return null; // Retorna null se nenhum carrinho for encontrado para o usuário com o CPF especificado
    }
}
