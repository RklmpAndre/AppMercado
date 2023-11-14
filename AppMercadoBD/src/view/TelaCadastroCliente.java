package view;

import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author andre; arthur
 */
public class TelaCadastroCliente extends JFrame{
    
    public TelaCadastroCliente(){
        super("Cadastro");
        initComponents();
    }
    
    
    
    private void initComponents(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 500);
        JPanel dadosPessoaisPanel = new JPanel();
        dadosPessoaisPanel.setLayout(new GridBagLayout());
        add(dadosPessoaisPanel);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        TelaCadastroCliente tela = new TelaCadastroCliente();
    }
}
