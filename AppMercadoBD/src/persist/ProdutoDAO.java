package persist;

import entity.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.PreparedStatement;
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
s
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
            Enum tipoEnum = p.getTipo();
            int tipoOrdinal = tipoEnum.ordinal();
            try {
                String sql = "INSERT INTO estoque (cpf, altura,medidacintura, peso, pressaomin, pressaomax, data) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, cpf);
                pstmt.setInt(2, altura);
                pstmt.setInt(3, cintura);
                pstmt.setDouble(4, peso);
                pstmt.setInt(5, pressaoMin);
                pstmt.setInt(6, pressoaMax);
                pstmt.setString(7, data);
                pstmt.executeUpdate();

                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1); //geralmente a chave primária é a primeira coluna
                    hist.setId(id);
                }
                return id;
            } catch (SQLException sqe) {
                System.out.println("Erro = " + sqe);
            }
        }
        return false;
    }

    @Override
    public Object read(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
