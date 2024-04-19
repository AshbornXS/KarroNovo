import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Veiculo {

    protected static List<Veiculo> veiculos = new ArrayList<>();
    private String cod, cor, marca, modelo, valor;

    public Veiculo(String cod, String cor, String marca, String modelo, String valor) {
        this.cod = cod;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
    }

    public Veiculo() {
    }

    public static Veiculo buscarVeiculo(String cod) {
        return veiculos.stream().filter(veiculo -> veiculo.cod.equals(cod)).findFirst().orElse(null);
    }

    public static void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public static void listarVeiculos() {
        System.out.println("\n--------------------------------------------------");
        listarVeiculosPorTipo(Carro.class);
        listarVeiculosPorTipo(Moto.class);
        listarVeiculosPorTipo(Caminhao.class);
        listarVeiculosPorTipo(Bicicleta.class);
    }

    public static void listarVeiculosPorTipo(Class<?> tipo) {
        String tipoNome = tipo.getSimpleName();
        if (tipo.equals(Caminhao.class)) {
            tipoNome = "Caminhõe";
        }

        if (tipo.equals(Bicicleta.class) || tipo.equals(Moto.class)) {
            System.out.println("\n" + tipoNome + "s cadastradas:\n");
        } else {
            System.out.println("\n" + tipoNome + "s cadastrados:\n");
        }

        for (Veiculo veiculo : veiculos) {
            if (tipo.isInstance(veiculo)) {
                System.out.println(veiculo);
                System.out.println("--------------------------------------------------");
            }
        }
    }

    public static void removerVeiculo(String cod) {
        Veiculo veiculo = buscarVeiculo(cod);
        if (veiculo != null) {
            veiculos.remove(veiculo);
            System.out.println("Veículo removido com sucesso!\n");
        } else {
            System.out.println("Veículo não encontrado!\n");
        }
    }

    @Override
    public String toString() {
        return "Placa/Núm. Série: " + cod + "\nCor: " + cor + "\nMarca: " + marca + "\nModelo: " + modelo + "\nValor: R$" + valor;
    }

    public abstract void cadastrar(Scanner scanner);

    public void editar(Scanner scanner) {
        System.out.println("\nInsira as novas informações do veículo (deixe em branco para não alterar):");
        String cod = getInput(scanner, "Digite o novo número de série do veículo:");
        String cor = getInput(scanner, "Digite a nova cor do veículo:");
        String marca = getInput(scanner, "Digite a nova marca do veículo:");
        String modelo = getInput(scanner, "Digite o novo modelo do veículo:");
        String valor = getInput(scanner, "Digite o novo valor do veículo:");

        if (cod != null) this.cod = cod;
        if (cor != null) this.cor = cor;
        if (marca != null) this.marca = marca;
        if (modelo != null) this.modelo = modelo;
        if (valor != null) this.valor = valor;
    }

    private String getInput(Scanner scanner, String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        return input.isEmpty() ? null : input;
    }
}