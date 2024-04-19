import java.util.Objects;
import java.util.Scanner;

public class Caminhao extends Automotor {

    private int cargMax, numEixos;

    public Caminhao(String cod, String cor, String marca, String modelo, String valor, String combustivel, int cargMax, int numEixos) {
        super(cod, cor, marca, modelo, valor, combustivel);
        this.cargMax = cargMax;
        this.numEixos = numEixos;
    }

    public Caminhao() {
    }

    @Override
    public void cadastrar(Scanner scanner) {
        System.out.println("\nInsira as informações do caminhão a ser cadastrado:");
        String cod = getInput(scanner, "Digite a placa do caminhão:");
        String cor = getInput(scanner, "Digite a cor do caminhão:");
        String marca = getInput(scanner, "Digite a marca do caminhão:");
        String modelo = getInput(scanner, "Digite o modelo do caminhão:");
        String valor = getInput(scanner, "Digite o valor do caminhão:");
        String combustivel = listarCombustivel("caminhão", scanner);
        this.cargMax = Integer.parseInt(Objects.requireNonNull(getInput(scanner, "Digite a capacidade máxima de carga do caminhão:")));
        this.numEixos = Integer.parseInt(Objects.requireNonNull(getInput(scanner, "Digite o número de eixos do caminhão:")));

        if (cod == null || cor == null || marca == null || modelo == null || valor == null || combustivel == null) {
            System.out.println("Caminhão não pode ser cadastrado com sucesso.\n");
            return;
        }

        Caminhao caminhao = new Caminhao(cod, cor, marca, modelo, valor, combustivel, cargMax, numEixos);
        addVeiculo(caminhao);
        System.out.println("Caminhão cadastrado com sucesso!\n");
    }

    @Override
    public void editar(Scanner scanner) {
        super.editar(scanner);
        String combustivel = listarCombustivel("caminhão", scanner);
        String cargMax = getInput(scanner, "Digite a nova capacidade máxima de carga do caminhão:");
        String numEixos = getInput(scanner, "Digite o novo número de eixos do caminhão:");

        if (combustivel != null) this.combustivel = combustivel;
        if (cargMax != null) this.cargMax = Integer.parseInt(cargMax);
        if (numEixos != null) this.numEixos = Integer.parseInt(numEixos);


        System.out.println("Caminhão atualizado com sucesso!\n");
    }

    @Override
    public String toString() {
        return super.toString() + "\nCarga Máxima: " + cargMax + "\nNúmero de Eixos: " + numEixos + "\n";
    }

    private String getInput(Scanner scanner, String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        return input.isEmpty() ? null : input;
    }
}
