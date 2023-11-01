package persist;

import entity.Pessoa;
import entity.Produto;
import entity.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import util.TipoProduto;
import util.TipoUsuario;
/**
 *
 * @author andre; arthur
 */

public class ProdutoDAO implements DAO{
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
        if(obj instanceof Produto){
            Produto p = (Produto) obj;
            int id=0;
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
                    id = rs.getInt(1); //geralmente a chave primária é a primeira coluna
                    p.setId(id);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
