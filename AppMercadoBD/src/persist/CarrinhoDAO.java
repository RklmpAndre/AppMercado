package persist;

import entity.Carrinho;
import entity.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author andre
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
            Carrinho carrinho = (Carrinho) obj;
            int id = -1;
            String usuario_cpf = carrinho.getUsuarioCpf();
            String data_compra = carrinho.getDataCompraString();
            try {
                String sql = "INSERT INTO carrinhos (id_usuario, data) VALUES (?, ?)";
                PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, usuario_cpf);
                pstmt.setString(2, data_compra);
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                    carrinho.setId(id);
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
                String sql = "SELECT * FROM carrinhos WHERE id = '" + id + "'";
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.isBeforeFirst()) {
                    rs.next();
                    String usuario_id = rs.getString(2);
                    String data_compra = rs.getString(3);
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    Carrinho carrinho = new Carrinho(usuario_id, LocalDate.parse(data_compra, formato));
                    carrinho.setId(rs.getInt(1));
                    return carrinho;
                }
            } catch (SQLException sqe) {
                System.out.println("Erro = " + sqe);
            }
        }
        return null;
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            } catch (SQLException sqe) {
                System.out.println("Erro = " + sqe);
            }
        }
        return false;
    }

    public List<Carrinho> listarCarrinhos(Pessoa usuario) {
        List<Carrinho> carrinhos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM carrinhos WHERE id_usuario = '" + usuario.getCpf() + "'";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int carrinho_id = rs.getInt(1);
                String data_compra = rs.getString(3);
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                Carrinho carrinho = new Carrinho(usuario.getCpf(), LocalDate.parse(data_compra, formato));
                carrinho.setId(carrinho_id);

                carrinhos.add(carrinho);
            }
        } catch (SQLException sqe) {
            System.out.println("Erro = " + sqe);
        }
        return carrinhos;
    }
}
