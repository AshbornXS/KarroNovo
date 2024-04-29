import veiculos.Bicicleta;
import veiculos.Veiculo;
import veiculos.automotor.Caminhao;
import veiculos.automotor.Carro;
import veiculos.automotor.Moto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int op;
        Scanner scanner = new Scanner(System.in);

        do {
            exibirMenu();
            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1:
                    cadastrarVeiculo(scanner);
                    break;
                case 2:
                    editarVeiculo(scanner);
                    break;
                case 3:
                    visualizarVeiculo(scanner);
                    break;
                case 4:
                    removerVeiculo(scanner);
                    break;
                case 5:
                    Veiculo.listarVeiculos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 0);
    }

    private static void exibirMenu() {
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Cadastrar um novo veículo");
        System.out.println("2 - Editar um veículo");
        System.out.println("3 - Ver informações de um veículo expecífico");
        System.out.println("4 - Excluir um veículo");
        System.out.println("5 - Listar todos os veículos");
        System.out.println("0 - Sair");
    }

    private static void cadastrarVeiculo(Scanner scanner) {
        System.out.println("\nQual tipo de veículo será cadastrado?");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.println("3 - Caminhão");
        System.out.println("4 - Bicicleta");
        System.out.println("5 - Voltar ao menu principal");
        int opCadastro = Integer.parseInt(scanner.nextLine());

        switch (opCadastro) {
            case 1:
                new Carro().cadastrar(scanner);
                break;
            case 2:
                new Moto().cadastrar(scanner);
                break;
            case 3:
                new Caminhao().cadastrar(scanner);
                break;
            case 4:
                new Bicicleta().cadastrar(scanner);
                break;
            case 5:
                System.out.println();
                break;
            default:
                System.out.println("Opção inválida!\n");
                break;
        }
    }

    private static void editarVeiculo(Scanner scanner) {
        System.out.println("\nDigite a placa/núm. série do veículo que você deseja editar:");
        String codEdit = scanner.nextLine();
        Veiculo veiculoEdit = Veiculo.buscarVeiculo(codEdit);

        if (veiculoEdit != null) {
            veiculoEdit.editar(scanner);
        } else {
            System.out.println("Veículo não encontrado!\n");
        }
    }

    private static void visualizarVeiculo(Scanner scanner) {
        System.out.println("\nDigite a placa/núm. série do veículo que você deseja ver as informações:");
        String codBusca = scanner.nextLine();
        Veiculo veiculoBusca = Veiculo.buscarVeiculo(codBusca);

        if (veiculoBusca != null) {
            System.out.println("\n" + veiculoBusca);
        } else {
            System.out.println("\nVeículo não encontrado!\n");
        }
    }

    private static void removerVeiculo(Scanner scanner) {
        System.out.println("\nDigite a placa/núm. série do veículo que você deseja remover:");
        String codRemove = scanner.nextLine();
        Veiculo.removerVeiculo(codRemove);
    }
}