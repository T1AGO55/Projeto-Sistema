package util;

import Model.Cliente;
import Service.ClienteService;
import Service.ProdutoService;
import Model.Produto;

import java.util.Scanner;

public class Menu {


    public static void exibirMenu() {
        System.out.println("===========================");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Clientes");
        System.out.println("3 - Cadastrar Produto");
        System.out.println("4 - Listar Produtos");
        System.out.println("0 - Sair");
        System.out.println("===========================");
    }


    public static int escolha() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();


    }


    public static void exibirCadastroCliente() {
        Scanner scanner = new Scanner(System.in);
        String choose;
        int id;
        String nome;
        String cpf;
        do {

            System.out.println("===========================");
            do {
                System.out.print("ID: ");
                id = scanner.nextInt();
                if (ClienteService.verificarIDDUP(id)) {
                    System.out.println("ID JA FOI USADO");
                }

            } while (ClienteService.verificarIDDUP(id));
            scanner.nextLine();
            System.out.print("Nome: ");
            nome = scanner.nextLine();
            do {
                System.out.print("CPF: ");
                cpf = scanner.nextLine().trim();
                if (ClienteService.verificaCPF(cpf)) {
                    System.out.println("CPF Invalido!");
                }
                if (ClienteService.verificarCPFDUP(cpf)) {
                    System.out.println("CPF JA ESTA SENDO USADO!");
                }
            } while (ClienteService.verificaCPF(cpf) || ClienteService.verificarCPFDUP(cpf));
            System.out.println("===========================");

            Cliente cliente = new Cliente(id, nome, cpf);
            ClienteService.setList(cliente);

            System.out.println("\nDeseja cadastrar outro cliente?");
            System.out.println("(1 - SIM) (2 - NAO)");
            choose = scanner.nextLine();
        } while (choose.equals("1") || choose.equals("SIM"));
    }

    public static void exibirCadastroProduto() {
        Scanner scanner = new Scanner(System.in);
        String choose;
        int id;
        String nome;
        double preco;
        int QuantidadeEstoque;
        int EscolhaTipoProduto;
        do {

            System.out.println("===========================");
            do {
                System.out.println("Selecione o tipo do produto:");
                int i = 1;
                for (Produto.TipoProduto tipoProduto : Produto.TipoProduto.values()) {
                    System.out.println(i + " - " + tipoProduto.getDescricao());
                    i++;
                }
                System.out.print("Escolha: ");
                EscolhaTipoProduto = scanner.nextInt();
                scanner.nextLine();

            } while (EscolhaTipoProduto < 1 || EscolhaTipoProduto > Produto.TipoProduto.values().length);
            Produto.TipoProduto tipoEscolhido = Produto.TipoProduto.values()[EscolhaTipoProduto];//transforma em enum

            do {
                System.out.print("ID: ");
                id = scanner.nextInt();
                if (ProdutoService.verificarIDDUP(id,tipoEscolhido)) {
                    System.out.println("ID JA FOI USADO");
                }

            } while (ProdutoService.verificarIDDUP(id,tipoEscolhido));
            scanner.nextLine();
            System.out.print("Nome do Produto: ");
            nome = scanner.nextLine();
            do {
                System.out.print("Preco: R$");
                preco = scanner.nextDouble();
                scanner.nextLine();
                if (preco <= 0) {
                    System.out.println("Preco Invalido!");
                }
            } while (preco <= 0);
            System.out.print("Quantidade em Estoque: ");
            QuantidadeEstoque = scanner.nextInt();
            scanner.nextLine();

            System.out.println("===========================");

            Produto produto = new Produto(id, nome, preco, QuantidadeEstoque, tipoEscolhido);
            ProdutoService.setList(produto);

            System.out.println("\nDeseja cadastrar outro produto?");
            System.out.println("(1 - SIM) (2 - NAO)");
            choose = scanner.nextLine();
        } while (choose.equals("1") || choose.equals("SIM"));


    }


}
