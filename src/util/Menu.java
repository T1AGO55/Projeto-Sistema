package util;

import Model.Cliente;
import Service.ClienteService;
import java.util.Scanner;

public class Menu {


    public static void exibirMenu(){
        System.out.println("===========================");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Clientes");
        System.out.println("3 - Cadastrar Produto");
        System.out.println("4 - Listar Produtos");
        System.out.println("0 - Sair");
        System.out.println("===========================");
    }



    public static int escolha(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();


    }


    public static void exibirCadastroCliente(){
        Scanner scanner = new Scanner(System.in);
        String choose;
        int id;
        String nome;
        String cpf;
        do {

            System.out.println("===========================");
            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nome: ");
            nome = scanner.nextLine();
            do {
                System.out.print("CPF: ");
                cpf = scanner.nextLine();
                if (!ClienteService.verificaCPF(cpf)){
                    System.out.println("CPF Invalido!");
                }
            }while(!ClienteService.verificaCPF(cpf));
            System.out.println("===========================");

            Cliente cliente = new Cliente(id,nome,cpf);
            ClienteService.setList(cliente);

            System.out.println("\nDeseja cadastrar outro cliente?");
            System.out.println("(1 - SIM) (2 - NAO)");
            choose = scanner.nextLine();
        }while(choose.equals("1")||choose.equals("SIM"));
    }






}
