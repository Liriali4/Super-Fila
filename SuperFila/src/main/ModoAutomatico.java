package main;

import java.util.Scanner;

public class ModoAutomatico {

    public static void automatico() {
        Scanner input = new Scanner(System.in);
        int op;
        System.out.println("\n\nModo automático activado!!!\n\n");

        System.out.println("Qual é o tempo de atendimento de um produto?");
        System.out.print("R: ");
        int tempoDeProduto = input.nextInt();

        System.out.println("Qual é o número de caixas?");
        System.out.print("R: ");
        int totalDeCaixas = input.nextInt();

        System.out.println("Qual é o intervalo de tempo máximo entre clientes?");
        System.out.print("R: ");
        int tempoEntreClientes = input.nextInt();

        System.out.println("1. Monstrar fila de caixas.");
        System.out.println("2. Criar clientes.");
        System.out.println("3. Adicionar caixa.");
        System.out.println("4. Retirar Caixa de atendimento.");
        System.out.println("5. Atender T tempo.");
        System.out.println("0. Encerrar modo automático.");

    }
}
