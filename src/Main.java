import util.Menu;


public class Main {
    public static void main(String[] args) {
        int escolha;

        do {
            Menu.exibirMenu();
            escolha = Menu.escolha();
            switch (escolha) {
                case 1:
                    Menu.exibirCadastroCliente();
                    break;
                case 2:
                    System.out.println("Listar Clientes (em desenvolvimento)");
                    break;
                case 3:
                    System.out.println("Cadastrar Produto (em desenvolvimento)");
                    break;
                case 4:
                    System.out.println("Listar Produtos (em desenvolvimento)");
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println();

        } while (escolha != 0);


    }
}