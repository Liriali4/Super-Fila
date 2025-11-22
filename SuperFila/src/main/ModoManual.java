package main;

import entidades.Mercado;
import java.util.Scanner;

public class ModoManual {

    public static void manual() {
        Scanner input = new Scanner(System.in);
        Mercado mercado = new Mercado();

        System.out.println("\n\nModo manual activado!!!\n\n");

        // Tempo por produto
        System.out.print("Qual é o tempo de atendimento de um produto? (Enter para 5 segundos): ");
        String respostaTempo = input.nextLine();
        int tempoDeProduto = respostaTempo.isEmpty() ? 5 : Integer.parseInt(respostaTempo);

        // Número de caixas
        System.out.print("Qual é o número de caixas? (Enter para 4 caixas): ");
        String respostaCaixas = input.nextLine();
        int totalDeCaixas = respostaCaixas.isEmpty() ? 4 : Integer.parseInt(respostaCaixas);

        // Inicializa o mercado com esses valores
        mercado.iniciarMercado(totalDeCaixas, tempoDeProduto);
        
        int op;
        do {
            System.out.println("1. Monstrar fila de caixas.");
            System.out.println("2. Criar clientes.");
            System.out.println("3. Adicionar caixa.");
            System.out.println("4. Retirar Caixa de atendimento.");
            System.out.println("5. Atender T tempo.");
            System.out.println("0. Encerrar modo manual.");
            System.out.print("R: ");
            op = input.nextInt();   

            switch (op) {
                case 1:
                    System.out.println(mercado.toString());
                    break;

            }
        } while (op != 0);

    }
}
