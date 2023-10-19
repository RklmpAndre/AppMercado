package persist;

import entity.Pessoa;
import entity.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author andre
 */
public class PessoaDAO implements DAO {

    private static PessoaDAO pdao;
    private static Connection conexao;

    public static PessoaDAO getInstance() {
        if (pdao == null) {
            pdao = new PessoaDAO();
        }
        return pdao;
    }

    private PessoaDAO() {
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
        if (obj != null && obj instanceof Pessoa) {
            Pessoa p = (Pessoa) obj;
            String nome = p.getNome() + " " + p.getSobrenome();
            String cpf = p.getCpf();
            String dataNascimento = p.getDataNascimentoString();
            String email = p.getUser().getLogin();
            String senha = p.getUser().getSenha();
            Enum tipo = p.getUser().getTipoUsuario();
            int tipoUser = tipo.ordinal();
            String sql = "INSERT INTO usuario (cpf, dataNascimento, email, nome, senha, tipoUsuario)"
                    + "VALUES ( ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setString(1, cpf);
                pstmt.setString(2, dataNascimento);
                pstmt.setString(3, email);
                pstmt.setString(4, nome);
                pstmt.setString(5, senha);
                pstmt.setInt(6, tipoUser);
                pstmt.executeUpdate();
                return true;
            } catch (SQLException sqe) {
                System.out.println("Erro = " + sqe);
            }
        }
        return false;
    }

    @Override
    //Em obj estará o cpf
    public Object read(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof String) {
            try {
                String cpf = (String) obj;
                String sql = "SELECT * FROM tbpessoa WHERE cpf = '" + cpf + "'";
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.isBeforeFirst()) {
                    rs.next();
                    String dataNascimento = rs.getString(2);
                    String email = rs.getString(3);
                    String nome = rs.getString(4);
                    String senha = rs.getString(5);
                    int tipo = rs.getInt(6);
                    Enum

                }
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
