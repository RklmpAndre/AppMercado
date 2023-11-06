package util;

/**
 *
 * @author andre; arthur
 */
public enum StatusCarrinho {
    FINALIZADO,
    ATIVO;
    
    public static StatusCarrinho fromInt(int valor) {
        switch (valor) {
            case 0:
                return StatusCarrinho.FINALIZADO;
            case 1:
                return StatusCarrinho.ATIVO;
            default:
                throw new IllegalArgumentException("Valor inválido: " + valor);
        }
    }
}
