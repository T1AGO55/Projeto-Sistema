package Service;

import Model.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ClienteService {

    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void setList(Cliente c) {
        clientes.add(c);
    }


    public static void listarClientes() {

        Scanner scanner = new Scanner(System.in);
        int escolha;
        String choose;
        do {
            List<Cliente> clientes1 = clientes.stream().toList();

            clientes1.forEach(cliente -> System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + " | CPF: " + cliente.getCpf()));
            System.out.println("\n============================================");
            System.out.println("Deseja ordenar a lista?");
            System.out.println("(1 - Ordenar por ID)");
            System.out.println("(2 - Ordenar por Nome em ordem Alfabetica)");
            System.out.println("(3 - ordenar por CPF em ordem Crescente)");
            System.out.println("(4 - NAO)");
            escolha = scanner.nextInt();
            scanner.nextLine();


            switch (escolha) {
                case 1:

                    List<Cliente> clientesID = clientes.stream().sorted(Comparator.comparingInt(Cliente::getId)).toList();
                    System.out.println("\n=============================");
                    clientesID.forEach(cliente -> System.out.println("ID: " + cliente.getId() + "| Nome: " + cliente.getNome() + "| CPF: " + cliente.getCpf()));
                    break;

                case 2:

                    List<Cliente> clientesNome = clientes.stream().sorted(Comparator.comparing(Cliente::getNome)).toList();
                    System.out.println("\n=============================");
                    clientesNome.forEach(cliente -> System.out.println("ID: " + cliente.getId() + "| Nome: " + cliente.getNome() + "| CPF: " + cliente.getCpf()));
                    break;

                case 3:
                    List<Cliente> clientesCPF = clientes.stream().sorted(Comparator.comparing(Cliente::getCpf)).toList();
                    System.out.println("\n=============================");
                    clientesCPF.forEach(cliente -> System.out.println("ID: " + cliente.getId() + "| Nome: " + cliente.getNome() + "| CPF: " + cliente.getCpf()));
                    break;


                default:
                    System.out.println("Opcao Invalida");
                    break;


            }


            System.out.println("\n===========================");
            System.out.println("Deseja retornar ao menu?");
            System.out.println("(1 - SIM) (2 - NAO)");
            choose = scanner.nextLine().trim().toUpperCase();

        } while (choose.equals("2") || choose.equals("NAO"));

    }


}
