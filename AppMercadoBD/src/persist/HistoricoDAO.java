package persist;

import entity.Historico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 *
 * @author andre; arthur
 */
public class HistoricoDAO implements DAO {

    private static HistoricoDAO hdao;
    private static Connection conexao;

    public static HistoricoDAO getInstance() {
        if (hdao == null) {
            hdao = new HistoricoDAO();
        }
        return hdao;
    }

    private HistoricoDAO() {
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
        if (obj instanceof Historico) {
            try {
                Historico h = (Historico) obj;
                int id = -1;
                String user_id = h.getUserId();
                String sql = "INSERT INTO historicos (user_id) VALUES (?)";
                PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, user_id);
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1); //geralmente a chave primária é a primeira coluna
                    h.setId(id);
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
                String sql = "SELECT * FROM historicos WHERE id = '" + id + "'";
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.isBeforeFirst()) {
                    rs.next();
                    String user_id = rs.getString(2);
                    id = rs.getInt(1);
                    Historico h = new Historico(user_id);
                    h.setId(id);
                    return h;
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
        if (obj instanceof Historico) {
            Historico h = (Historico) obj;
            try {
                String sql = "UPDATE historicos SET user_id = ? WHERE id = ?";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setString(1, h.getUserId());
                pstmt.setInt(2, h.getId());
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
                String sql = "DELETE FROM historicos WHERE id = '" + id + "'";
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

}
