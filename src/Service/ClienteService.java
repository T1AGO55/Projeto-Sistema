package Service;

import Model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteService {

   static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void setList(Cliente c){
        clientes.add(c);
    }


    public static void listarClientes(){

        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes1 = clientes.stream().toList();
        int escolha;
        clientes1.forEach(cliente -> System.out.println("ID: "+ cliente.getId()+" | Nome: "+cliente.getNome()+" | CPF: "+cliente.getCpf()));
        System.out.println("Deseja ordenar a lista?");
        System.out.println("(1 - Ordenar por ID)");
        System.out.println("(2 - Ordenar por Nome em ordem Alfabetica)");
        System.out.println("(3 - ordenar por CPF em ordem Crescente)");
        escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha){
            case 1:

                break;

            case 2:

                break;
            case 3:

                break;
            default:
                System.out.println("Opcao Invalida");
                break;



        }




        System.out.println("Deseja voltar?");
        System.out.println("(1 - SIM) (2 - NAO)");

    }





}
