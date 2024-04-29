package veiculos.automotor;

import veiculos.Veiculo;

import java.util.Scanner;

public abstract class Automotor extends Veiculo {

    String combustivel;

    public Automotor(String cod, String cor, String marca, String modelo, String valor, String combustivel) {
        super(cod, cor, marca, modelo, valor);
        this.combustivel = combustivel;
    }

    public Automotor() {
    }

    public static String listarCombustivel(String tipo, Scanner scanner) {
        System.out.println("Digite o tipo de combustivel do " + tipo + ":");
        System.out.println("G - Gasolina");
        System.out.println("A - Álcool");
        System.out.println("F - Flex");
        System.out.println("E - Elétrico");
        System.out.println("D - Diesel");

        return switch (scanner.nextLine().toUpperCase()) {
            case "G" -> "Gasolina";
            case "A" -> "Álcool";
            case "F" -> "Flex";
            case "E" -> "Elétrico";
            case "D" -> "Diesel";
            default ->
                    throw new IllegalArgumentException("Opção inválida, veículo não pode ser cadastrado com sucesso.");
        };
    }

    @Override
    public String toString() {
        return super.toString() + "\nCombustível: " + combustivel;
    }
}