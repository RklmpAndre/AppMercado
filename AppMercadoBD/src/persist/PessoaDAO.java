package persist;

import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class PessoaDAO implements DAO{
    
    private static PessoaDAO pdao;
    public static Connection conexao;
    
    public static PessoaDAO getInstance(){
        if(pdao == null) pdao = new PessoaDAO();
        return pdao;
    }
    
    private PessoaDAO(){
        ConexaoBD conbd;
        try {
            conbd = ConexaoBD.getInstance();
            conexao = (Connection) conbd.getConexao();
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro = " + ex);
        } catch (SQLException ex){
            System.out.println("Erro = " + ex); 
       }
    }
    
    @Override
    public boolean create(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
