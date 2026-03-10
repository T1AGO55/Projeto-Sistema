package Service;

import Model.Produto;

import java.util.*;
import java.util.stream.Collectors;

public class ProdutoService {

    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void setList(Produto p) {
        produtos.add(p);
    }

    public static boolean verificarIDDUP(int id, Produto.TipoProduto tipo) {
        Produto produtoVerificado = produtos.stream().filter(p -> p.getID() == id && p.getTipoProduto() == tipo).findFirst().orElse(null);


        if (produtoVerificado != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void listarProdutos(){
        Scanner scanner = new Scanner(System.in);
        int escolha;
        String choose;
        do {
            List<Produto> produtos1 = produtos.stream().toList();

            System.out.println("\n============================================");
            produtos1.forEach(produto -> System.out.println("ID: " + produto.getID() + " | Nome: " + produto.getNome() + " | Preco: R$: " + produto.getPreco()+ " | Quantidade em Estoque: " + produto.getQuantidadeEstoque()));
            System.out.println("\n============================================");
            System.out.println("Deseja ordenar a lista?");
            System.out.println("(1 - Ordenar por ID)");
            System.out.println("(2 - Ordenar por Tipo do Produto)");
            System.out.println("(3 - Ordenar por Preco (Crescente))");
            System.out.println("(4 - Ordenar por Preco (Decrescente))");
            System.out.println("(5 - NAO)");
            escolha = scanner.nextInt();
            scanner.nextLine();


            switch (escolha) {
                case 1:

                    List<Produto> produtosID = produtos.stream().sorted(Comparator.comparingInt(Produto::getID)).toList();
                    System.out.println("\n=========================================");
                    produtosID.forEach(produto -> System.out.println("ID: " + produto.getID() + "| Nome: " + produto.getNome() + "| Preco: R$" + produto.getPreco()+ " | Quantidade em Estoque: "+produto.getQuantidadeEstoque()));
                    break;

               case 2:

                   Map<String , List<Produto>> produtosSeparadosTipo = produtos.stream().collect(Collectors.groupingBy(p-> p.getTipoProduto().getDescricao()));
                    System.out.println("\n=========================================");
                    produtosSeparadosTipo.forEach((tipo,listaproduto)->{
                        System.out.println("Tipo do Produto: "+tipo);
                        listaproduto.forEach(p -> System.out.println("ID: "+p.getID()+" |Nome Produto: "+p.getNome()+ " |Preco: R$"+p.getPreco()));
                    });
                    break;

                case 3:
                    List<Produto> precoProdutoCrescente = produtos.stream().sorted(Comparator.comparing(Produto::getPreco)).toList();
                    System.out.println("\n=========================================");
                    precoProdutoCrescente.forEach(produto -> System.out.println("ID: " + produto.getID() + "| Nome: " + produto.getNome() + "| Preco: R$"+ produto.getPreco()));
                    break;

                case 4:
                    List<Produto> precoDescrescente = produtos.stream().sorted(Comparator.comparing(Produto::getPreco).reversed()).toList();
                    System.out.println("\n=========================================");
                    precoDescrescente.forEach(produto -> System.out.println("ID: " + produto.getID() + "| Nome: " + produto.getNome() + "| Preco: R$"+ produto.getPreco()));
                    break;
                default:
                    break;


            }

            System.out.println("\n=============================");
            System.out.println("Deseja retornar ao menu?");
            System.out.println("(1 - SIM) (2 - NAO)");
            choose = scanner.nextLine().trim().toUpperCase();

        } while (choose.equals("2") || choose.equals("NAO"));






    }





}
