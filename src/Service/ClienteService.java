package Service;

import Model.Cliente;

import java.util.*;

public class ClienteService {

    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void setList(Cliente c) {
        clientes.add(c);
    }


    public static boolean verificaCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return true;
        }
        //verifica se o cpf tem numeros repetidos ex:222.222.222-22
        if (cpf.matches("(\\d)\\1{10}")) {
            return true;
        }

        /*
 1) O CPF possui 11 dígitos, sendo os 2 últimos dígitos verificadores.

 2) Para calcular o 1º dígito:
    - Multiplica os 9 primeiros dígitos pelos pesos de 10 até 2.
    - Soma os resultados.
    - Faz (soma × 10) % 11.
    - Se o resultado for 10 ou 11, considera 0.
    - O valor obtido deve ser igual ao 10º dígito.

 3) Para calcular o 2º dígito:
    - Multiplica os 10 primeiros dígitos pelos pesos de 11 até 2.
    - Soma os resultados.
    - Faz (soma × 10) % 11.
    - Se o resultado for 10 ou 11, considera 0.
    - O valor obtido deve ser igual ao 11º dígito.
*/

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int resto = (soma * 10) % 11;
        if (resto == 10) {
            resto = 0;
        }
        if (resto != Character.getNumericValue(cpf.charAt(9))) {
            return true;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = (soma * 10) % 11;
        if (resto == 10) {
            resto = 0;
        }

        return resto != Character.getNumericValue(cpf.charAt(10));
    }

    public static boolean verificarCPFDUP(String cpf) {

        cpf = cpf.replaceAll("[^0-9]", "");

        String finalCpf = cpf;
        Cliente teste = clientes.stream().filter(c -> c.getCpf().replaceAll("[^0-9]", "").equals(finalCpf)).findFirst().orElse(null);
        if (teste != null) {
            return true;
        } else {
            return false;
        }

    }


    public static void listarClientes() {

        Scanner scanner = new Scanner(System.in);
        int escolha;
        String choose;
        do {
            List<Cliente> clientes1 = clientes.stream().toList();

            System.out.println("\n============================================");
            clientes1.forEach(cliente -> System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + " | CPF: " + cliente.getCpfFormatado()));
            System.out.println("\n============================================");
            System.out.println("Deseja ordenar a lista?");
            System.out.println("(1 - Ordenar por ID)");
            System.out.println("(2 - Ordenar por Nome em ordem Alfabetica)");
            System.out.println("(3 - ordenar por CPF em ordem Crescente)");
            System.out.println("(4 - Procurar cliente por CPF)");
            System.out.println("(5 - NAO)");
            escolha = scanner.nextInt();
            scanner.nextLine();


            switch (escolha) {
                case 1:

                    List<Cliente> clientesID = clientes.stream().sorted(Comparator.comparingInt(Cliente::getId)).toList();
                    System.out.println("\n=========================================");
                    clientesID.forEach(cliente -> System.out.println("ID: " + cliente.getId() + "| Nome: " + cliente.getNome() + "| CPF: " + cliente.getCpfFormatado()));
                    break;

                case 2:

                    List<Cliente> clientesNome = clientes.stream().sorted(Comparator.comparing(Cliente::getNome)).toList();
                    System.out.println("\n=========================================");
                    clientesNome.forEach(cliente -> System.out.println("ID: " + cliente.getId() + "| Nome: " + cliente.getNome() + "| CPF: " + cliente.getCpfFormatado()));
                    break;

                case 3:
                    List<Cliente> clientesCPF = clientes.stream().sorted(Comparator.comparing(Cliente::getCpf)).toList();
                    System.out.println("\n=========================================");
                    clientesCPF.forEach(cliente -> System.out.println("ID: " + cliente.getId() + "| Nome: " + cliente.getNome() + "| CPF: " + cliente.getCpfFormatado()));
                    break;


                case 4:
                    String cpfEscolhido;
                    do {

                        do {
                            System.out.println("\n=============================");
                            System.out.print("CPF do cliente: ");
                            cpfEscolhido = scanner.nextLine().trim();
                            ClienteService.verificarCPFDUP(cpfEscolhido);
                            if (cpfEscolhido.replaceAll("[^0-9]", "").length() != 11) {
                                System.out.println("Erro!! CPF deve conter 11 caracteres! Ex: XXX.XXX.XXX-XX");
                            }
                            if (!ClienteService.verificarCPFDUP(cpfEscolhido)) {
                                System.out.println("Cliente nao encontrado");
                            }
                        } while (!ClienteService.verificarCPFDUP(cpfEscolhido));
                        String finalCpfEscolhido = cpfEscolhido;
                        Cliente cliente = clientes.stream().filter(c -> c.getCpf().replaceAll("[^0-9]", "").equals(finalCpfEscolhido.replaceAll("[^0-9]", ""))).findFirst().orElse(null);
                        if (!cpfEscolhido.equals(cliente.getCpf())) {

                        }
                        System.out.println("\n=========================================");
                        System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + " | CPF: " + cliente.getCpfFormatado());
                        System.out.println("\n=========================================");

                        System.out.println("\n=============================");
                        System.out.println("Deseja procurar outro cliente?");
                        System.out.println("(1 - SIM) (2 - NAO)");
                        choose = scanner.nextLine().trim().toUpperCase();
                    } while (choose.equals("1") || choose.equals("SIM"));
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
