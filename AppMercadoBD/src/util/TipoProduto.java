package util;

/**
 *
 * @author andre; arthur
 */
public enum TipoProduto {
    BENS_DE_CONSUMO("Bens de Consumo"),
    SERVIÇOS("Serviços"),
    BENS_DE_USO_COMUM("Bens de Uso Comum"),
    BENS_DE_EMERGÊNCIA("Bens de Emergência"),
    BENS_DURÁVEIS("Bens Duráveis"),
    PRODUTOS_ESPECIAIS("Produtos Especiais");

    private final String tipoProduto;

    TipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getTipoProduto() {
        return this.tipoProduto;
    }
    
    public static TipoProduto fromString(String tipo) {
        for (TipoProduto produto : values()) {
            if (produto.tipoProduto.equalsIgnoreCase(tipo)) {
                return produto;
            }
        }
        throw new IllegalArgumentException("Tipo de produto inválido: " + tipo);
    }
    
    public static String retornaString(String tipo) {
        for (TipoProduto produto : values()) {
            if (produto.tipoProduto.equalsIgnoreCase(tipo)) {
                return produto.getTipoProduto();
            }
        }
        throw new IllegalArgumentException("Tipo de produto inválido: " + tipo);
    }
    
    public static TipoProduto fromInt(int valor) {
        switch (valor) {
            case 0:
                return TipoProduto.BENS_DE_CONSUMO;
            case 1:
                return TipoProduto.SERVIÇOS;
            case 2:
                return TipoProduto.BENS_DE_USO_COMUM;
            case 3:
                return TipoProduto.BENS_DE_EMERGÊNCIA;
            case 4:
                return TipoProduto.BENS_DURÁVEIS;
            case 5:
                return TipoProduto.PRODUTOS_ESPECIAIS;
            default:
                throw new IllegalArgumentException("Valor inválido: " + valor);
        }
    }

}
