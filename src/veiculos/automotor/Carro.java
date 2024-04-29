package veiculos.automotor;

import java.util.Objects;
import java.util.Scanner;

public class Carro extends Automotor {
    private int qtdPortas;

    public Carro(String cod, String cor, String marca, String modelo, String valor, String combustivel, int qtdPortas) {
        super(cod, cor, marca, modelo, valor, combustivel);
        this.qtdPortas = qtdPortas;
    }

    public Carro() {

    }

    @Override
    public void cadastrar(Scanner scanner) {
        System.out.println("\nInsira as informações do carro a ser cadastrado:");
        String cod = getInput(scanner, "Digite a placa do carro:");
        String cor = getInput(scanner, "Digite a cor do carro:");
        String marca = getInput(scanner, "Digite a marca do carro:");
        String modelo = getInput(scanner, "Digite o modelo do carro:");
        String valor = getInput(scanner, "Digite o valor do carro:");
        String combustivel = listarCombustivel("carro", scanner);
        this.qtdPortas = Integer.parseInt(Objects.requireNonNull(getInput(scanner, "Digite a quantidade de portas do carro:")));

        if (cod == null || cor == null || marca == null || modelo == null || valor == null || combustivel == null) {
            System.out.println("Carro não pode ser cadastrado com sucesso.\n");
            return;
        }

        addVeiculo(new Carro(cod, cor, marca, modelo, valor, combustivel, qtdPortas));
        System.out.println("Carro cadastrado com sucesso!\n");
    }

    @Override
    public void editar(Scanner scanner) {
        super.editar(scanner);
        String combustivel = listarCombustivel("carro", scanner);
        String qtdPortas = getInput(scanner, "Digite a nova quantidade de portas do carro:");

        if (combustivel != null) this.combustivel = combustivel;
        if (qtdPortas != null) this.qtdPortas = Integer.parseInt(qtdPortas);

        System.out.println("Carro atualizado com sucesso!\n");
    }

    @Override
    public String toString() {
        return super.toString() + "\nQuantidade de Portas: " + qtdPortas + "\n";
    }

    private String getInput(Scanner scanner, String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        return input.isEmpty() ? null : input;
    }
}