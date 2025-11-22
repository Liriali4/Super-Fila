package main;

import java.util.Scanner;

public class ModoManual {

    public static void manual() {
        Scanner input = new Scanner(System.in);
        int op;
        System.out.println("\n\nModo manual activado!!!\n\n");

        System.out.println("Qual é o tempo de atendimento de um produto?");
        int tempoDeProduto = input.nextInt();

        System.out.println("Qual é o número de caixas?");
        int totalDeCaixas = input.nextInt();

        do {
            System.out.println("1. Monstrar fila de caixas.");
            System.out.println("2. Criar clientes.");
            System.out.println("3. Adicionar caixa.");
            System.out.println("4. Retirar Caixa de atendimento.");
            System.out.println("5. Atender T tempo.");
            System.out.println("0. Encerrar modo manual.");            
            System.out.print("R:");
            op = input.nextInt();
            
         
        } while (op != 0);

    }
}
