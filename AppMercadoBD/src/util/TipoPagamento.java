package util;

/**
 *
 * @author andre; arhur
 */
public enum TipoPagamento {
    DEBITO("Débito"),
    CREDITO("Crédito"),
    PIX("Pix");

    private final String tipoPagamento;

    TipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getTipoProduto() {
        return this.tipoPagamento;
    }

    public static TipoPagamento fromInt(int valor) {
        switch (valor) {
            case 0:
                return TipoPagamento.DEBITO;
            case 1:
                return TipoPagamento.CREDITO;
            case 2:
                return TipoPagamento.PIX;
            default:
                throw new IllegalArgumentException("Valor inválido: " + valor);
        }
    }

}
