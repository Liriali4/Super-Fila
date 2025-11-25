package main;

import java.util.Scanner;

/**
 *
 * @author Líria Bá
 * @numero 20230237
 * @turma EINF5_M3
 */
public class SuperFila {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int op;
        System.out.println("        Bem vindo ao SuperFila    ");
        System.out.println("De qual modo gostaria de iniciar a simulação?");

        do {
            System.out.println("1. Modo Manual.");
            System.out.println("2. Modo Automático.");
            System.out.println("0. Encerrar programa.");
            System.out.print("R:");
            op =  input.nextInt();

            switch (op){
                case 1:
                    ModoManual.manual();
                    break;
                case 2:
                    ModoAutomatico.automatico();
                    break;
                case 0:
                    System.out.println("\nEncerrando...\n");
                    break;
                default:
                    System.out.println("Digite uma opção válida!!!");
            }
        } while (op != 0);

    }

}
