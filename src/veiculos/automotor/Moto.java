package veiculos.automotor;

import java.util.Objects;
import java.util.Scanner;

public class Moto extends Automotor {

    private boolean partEletrica;
    private int cilindradas;

    public Moto(String cod, String cor, String marca, String modelo, String valor, String combustivel, boolean partEletrica, int cilindradas) {
        super(cod, cor, marca, modelo, valor, combustivel);
        this.partEletrica = partEletrica;
        this.cilindradas = cilindradas;
    }

    public Moto() {
    }

    @Override
    public void cadastrar(Scanner scanner) {
        System.out.println("\nInsira as informações da moto a ser cadastrada:");
        String cod = getInput(scanner, "Digite a placa da moto:");
        String cor = getInput(scanner, "Digite a cor da moto:");
        String marca = getInput(scanner, "Digite a marca da moto:");
        String modelo = getInput(scanner, "Digite o modelo da moto:");
        String valor = getInput(scanner, "Digite o valor da moto:");
        String combustivel = listarCombustivel("moto", scanner);
        System.out.println("A moto possui partida elétrica? (s/n)");
        this.partEletrica = scanner.nextLine().equals("s");
        this.cilindradas = Integer.parseInt(Objects.requireNonNull(getInput(scanner, "Digite a quantidade de cilindradas da moto:")));

        if (cod == null || cor == null || marca == null || modelo == null || valor == null || combustivel == null) {
            System.out.println("Moto não pode ser cadastrada com sucesso.\n");
            return;
        }

        Moto moto = new Moto(cod, cor, marca, modelo, valor, combustivel, partEletrica, cilindradas);
        addVeiculo(moto);
        System.out.println("Moto cadastrada com sucesso!\n");
    }

    @Override
    public void editar(Scanner scanner) {
        super.editar(scanner);
        String combustivel = listarCombustivel("moto", scanner);
        System.out.println("A moto possui partida elétrica? (s/n)");
        Boolean partEletrica = scanner.next().equals("s");
        String cilindradas = getInput(scanner, "Digite a nova quantidade de cilindradas da moto:");

        if (combustivel != null) this.combustivel = combustivel;
        if (partEletrica != null) this.partEletrica = partEletrica;
        if (cilindradas != null) this.cilindradas = Integer.parseInt(cilindradas);

        System.out.println("Moto atualizada com sucesso!\n");
    }

    private String getInput(Scanner scanner, String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        return input.isEmpty() ? null : input;
    }

    @Override
    public String toString() {
        String partEletricaStr = partEletrica ? "Sim" : "Não";
        return super.toString() + "\nPartida Elétrica: " + partEletricaStr + "\nCilindradas: " + cilindradas + "\n";
    }
}