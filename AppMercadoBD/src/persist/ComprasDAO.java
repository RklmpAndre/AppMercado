package persist;

import entity.Carrinho;
import entity.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author andre; arthur
 */
public class ComprasDAO implements DAO {

    private static ComprasDAO cdao;
    private static Connection conexao;

    public static ComprasDAO getInstance() {
        if (cdao == null) {
            cdao = new ComprasDAO();
        }
        return cdao;
    }

    private ComprasDAO() {
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
        if (obj instanceof Compra) {
            Compra c = (Compra) obj;
            int id = -1;
            int historico_id = c.getHistorico_id();
            String data_compra = c.getDataCompraString();
            int pedido_entrega = 0;
            if (c.getPedidoEntrega()) {
                pedido_entrega = 1;
            }
            int forma_pagamento = c.getTipoPagamento().ordinal();
            double total_compra = c.getPrecoTotal();
            String produtos = c.getItemComprado().toString();
            String endereco_entrega = c.getPedidoEntrega() ? c.getEnderecoEntrega().toString() : " ";
            String data_entrega = c.getPedidoEntrega() ? c.getDataEntregaString() : " ";
            try {
                String sql = "INSERT INTO compras (historico_id, data_compra, pedido_entrega, forma_pagamento, total_compra, produtos, endereco_entrega, data_entrega)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, historico_id);
                pstmt.setString(2, data_compra);
                pstmt.setInt(3, pedido_entrega);
                pstmt.setInt(4, forma_pagamento);
                pstmt.setDouble(5, total_compra);
                pstmt.setString(6, produtos);
                pstmt.setString(7, endereco_entrega);
                pstmt.setString(8, data_entrega);
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
