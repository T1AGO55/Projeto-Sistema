package Service;

import Model.Cliente;
import Model.Produto;

import java.util.ArrayList;

public class ProdutoService {

    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void setList(Produto p) {
        produtos.add(p);
    }

    public static boolean verificarIDDUP(int id) {
        Produto produtoVerificado = produtos.stream().filter(p -> p.getID() == id).findFirst().orElse(null);
        if (produtoVerificado != null) {
            return true;
        } else {
            return false;
        }
    }







}
