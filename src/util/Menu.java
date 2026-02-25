package util;

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
        System.out.println("===========================");
        System.out.println("ID: ");
        System.out.println("Nome: ");
        System.out.println("CPF: ");
        System.out.println("===========================");



    }




}
