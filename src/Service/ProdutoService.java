package Service;

import Model.Cliente;
import Model.Produto;

import java.util.ArrayList;

public class ProdutoService {

    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void setList(Produto p) {
        produtos.add(p);
    }





}
