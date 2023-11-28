package persist;

import entity.Historico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import util.TipoPagamento;

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
            String endereco_entrega = h.isEntrega() ? h.getEndereco() : " ";
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
        if (obj != null && obj instanceof Integer) {
            int carrinho_id = (int) obj;
            String sql = "SELECT * FROM historico WHERE carrinho_id = '" + carrinho_id + "'";
            try {
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String endereco = rs.getString("endereco");
                    String data = rs.getString("data");
                    int forma_pagamento = rs.getInt("forma_pagamento");
                    int entrega = rs.getInt("entrega");
                    double total_compra = rs.getDouble("total_compra");
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    Historico historico;
                    if(entrega == 0){
                        historico = new Historico(carrinho_id, TipoPagamento.fromInt(forma_pagamento), false, total_compra);
                        historico.setId(id);
                        return historico;
                    }else{
                        historico = new Historico(carrinho_id, TipoPagamento.fromInt(forma_pagamento), true, endereco, LocalDate.parse(data, formato), total_compra);
                        historico.setId(id);
                        return historico;
                    }
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
