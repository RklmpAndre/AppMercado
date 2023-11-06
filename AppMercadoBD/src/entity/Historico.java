package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre; arthur
 */

public class Historico {
    private int id;
    private String userId;
    private List<Compra> compras;
    

    public Historico() {
    }

    public Historico(String userId) {
        setUserId(userId);
        compras = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
    
    
    
}