package Model;

public class Produto {
    protected int id;
    protected String nome;
    protected double preco;
    protected int QuantidadeEstoque;
    protected TipoProduto tipoProduto;

    public enum TipoProduto {

        ALIMENTO_SECO("ALIMENTO SECO"),
        HORTIFRUTI("HORTIFRUTI"),
        CARNES("CARNES"),
        AVES("AVES"),
        PEIXES("PEIXES"),
        FRIOS_E_LATICINIOS("FRIOS E LATICÍNIOS"),
        BEBIDAS("BEBIDAS"),
        PADARIA("PADARIA"),
        CONGELADOS("CONGELADOS"),
        EMBALAGENS("EMBALAGENS"),
        LIMPEZA("LIMPEZA"),
        HIGIENE_PESSOAL("HIGIENE PESSOAL"),
        PET("PET"),
        BEBE("BEBÊ"),
        UTILIDADES_DOMESTICAS("UTILIDADES DOMÉSTICAS");

        private final String descricao;

        TipoProduto(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }


    public Produto(int id, String nome, double preco, int QuantidadeEstoque, TipoProduto tipoProduto) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.QuantidadeEstoque = QuantidadeEstoque;
        this.tipoProduto = tipoProduto;
    }

    public int getID() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return QuantidadeEstoque;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

}
