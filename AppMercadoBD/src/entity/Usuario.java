package entity;

import java.util.Objects;
import util.TipoUsuario;

/**
 *
 * @author andre
 */
public class Usuario {
    
    //login será com o cpf
    private String login;
    //senha terá mais de 8 digitos
    private String senha;
    private Enum tipoUsuario;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
        //já é settado como comun
        tipoUsuario = TipoUsuario.COMUN;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Enum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Enum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.login);
        hash = 37 * hash + Objects.hashCode(this.senha);
        hash = 37 * hash + Objects.hashCode(this.tipoUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return this.tipoUsuario == other.tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "login=" + login + ", senha=" + senha + ", tipoUsuario=" + tipoUsuario + '}';
    }

}
