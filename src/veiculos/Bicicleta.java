package veiculos;

import java.util.Scanner;

public class Bicicleta extends Veiculo {

    private String freio;

    public Bicicleta(String cod, String cor, String marca, String modelo, String valor, String freio) {
        super(cod, cor, marca, modelo, valor);
        this.freio = freio;
    }

    public Bicicleta() {
    }

    public String tipoFreio(Scanner scanner) {
        System.out.println("Digite o tipo de freio da bicicleta: ");
        System.out.println("C - Cantiléver");
        System.out.println("V - V-Brake");
        System.out.println("F - Ferradura");
        System.out.println("M - Disco Mecânico");
        System.out.println("H - Disco Hidráulico");

        return switch (scanner.nextLine().toUpperCase()) {
            case "C" -> "Cantiléver";
            case "V" -> "V-Brake";
            case "F" -> "Ferradura";
            case "M" -> "Disco Mecânico";
            case "H" -> "Disco Hidráulico";
            default ->
                    throw new IllegalArgumentException("Opção inválida, veículo não pode ser cadastrado com sucesso.");
        };
    }

    @Override
    public void cadastrar(Scanner scanner) {
        System.out.println("\nInsira as informações da bicicleta a ser cadastrada:");
        String cod = getInput(scanner, "Digite o número de série da bicicleta:");
        String cor = getInput(scanner, "Digite a cor da bicicleta:");
        String marca = getInput(scanner, "Digite a marca da bicicleta:");
        String modelo = getInput(scanner, "Digite o modelo da bicicleta:");
        String valor = getInput(scanner, "Digite o valor da bicicleta:");
        String freio = tipoFreio(scanner);

        if (cod == null || cor == null || marca == null || modelo == null || valor == null || freio == null) {
            System.out.println("Bicicleta não pode ser cadastrada com sucesso.\n");
            return;
        }

        Bicicleta bicicleta = new Bicicleta(cod, cor, marca, modelo, valor, freio);
        Veiculo.addVeiculo(bicicleta);
        System.out.println("Bicicleta cadastrada com sucesso!\n");
    }

    private String getInput(Scanner scanner, String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        return input.isEmpty() ? null : input;
    }

    @Override
    public void editar(Scanner scanner) {
        super.editar(scanner);
        String freio = tipoFreio(scanner);

        if (freio != null) this.freio = freio;

        System.out.println("Bicicleta atualizada com sucesso!\n");
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de freio: " + freio + "\n";
    }
}
