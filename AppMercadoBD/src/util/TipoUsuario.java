package util;

/**
 *
 * @author andre; arthur
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
    
    public static TipoUsuario fromInt(int valor) {
        switch (valor) {
            case 0:
                return COMUN;
            case 1:
                return ADMIN;
            default:
                throw new IllegalArgumentException("Valor inválido: " + valor);
        }
    }
}
