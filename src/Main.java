import Service.ClienteService;
import Service.ProdutoService;
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
                    ClienteService.listarClientes();
                    break;
                case 3:
                    Menu.exibirCadastroProduto();
                    break;
                case 4:
                    ProdutoService.listarProdutos();
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