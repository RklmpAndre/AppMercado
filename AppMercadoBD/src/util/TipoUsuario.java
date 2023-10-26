package util;

/**
 *
 * @author andre
 */
public enum TipoUsuario {

    COMUN,
    ADMIN;
    
    public static TipoUsuario tipo(int ordinal) {
        for (TipoUsuario tipo : values()) {
            if (tipo.ordinal() == ordinal) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor de enum inválido: " + ordinal);
    }
}
