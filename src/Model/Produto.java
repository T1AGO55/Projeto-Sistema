package Model;

public class Produto {




    Produto (int id, String nome, double preco, int QuantidadeEstoque){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.QuantidadeEstoque = QuantidadeEstoque;
    }

    public int getID(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public int QuantidadeEstoque(){
        return QuantidadeEstoque;
    }







}
