package persist;

/**
 *
 * @author andre
 */
public interface DAO {
    
    public boolean create(Object obj);
    
    //Pode retornar um objeto ou uma coleção de objetos
    //O parâmetro pode ser um objeto ou uma chave ou qualquer
    //outra coisa definida dentro da classe XXXDAO
    public Object read (Object obj);
    
    // obj vai ser o objeto já com as novas informações
    // que serão atualizadas. Desse obj retiramos a chave de 
    // localização se necessário
    public boolean update (Object obj);
    
    // obj pode depois ser definido como o próprio objeto 
    //ou a sua chave de localização
    public boolean delete (Object obj);
    
    
}

