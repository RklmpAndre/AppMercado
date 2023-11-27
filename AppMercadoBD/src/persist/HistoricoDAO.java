package persist;

import entity.Historico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            Historico h = (Historico) obj;
            int id = -1;
            int itens_carrinho_id = h.getCarrinho_id();
            int pedido_entrega = 0;
            if (h.isEntrega()) {
                pedido_entrega = 1;
            }
            int forma_pagamento = h.getTipoPagamento().ordinal();
            String endereco_entrega = h.isEntrega() ? h.getEnderecoEntrega().toString() : " ";
            String data_entrega = h.isEntrega() ? h.getDataString() : " ";
            double total_compra = h.getTotal_compra();
            try {
                String sql = "INSERT INTO historico (carrinho_id, endereco, data, forma_pagamento, entrega, total_compra)"
                        + " VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, itens_carrinho_id);
                pstmt.setString(2, endereco_entrega);
                pstmt.setString(3, data_entrega);
                pstmt.setInt(4, forma_pagamento);
                pstmt.setInt(5, pedido_entrega);
                pstmt.setDouble(6, total_compra);
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
