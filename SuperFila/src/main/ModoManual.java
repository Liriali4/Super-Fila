package main;

import entidades.Mercado;
import java.util.Scanner;
import utils.GestorDeFicheiros;

public class ModoManual {

    public static void manual() {
        Scanner input = new Scanner(System.in);
        Mercado mercado = new Mercado();
        StringBuilder log = new StringBuilder();

        System.out.println("\n----------------------------------Modo manual activado!!!----------------------------------\n");

        System.out.print("Qual é o tempo de atendimento de um produto? (Enter para 5 segundos): ");
        String rT = input.nextLine();
        int tempoDeProduto = rT.isEmpty() ? 5 : Integer.parseInt(rT);

        System.out.print("Qual é o número de caixas? (Enter para 4 caixas): ");
        String rC = input.nextLine();
        int totalDeCaixas = rC.isEmpty() ? 4 : Integer.parseInt(rC);

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
                    System.out.println(mercado);
                    log.append(mercado.toString()).append("\n");
                    break;

                case 2:
                    mercado.criarCliente();
                    log.append("Cliente criado.\n");
                    break;

                case 3:
                    mercado.adicionarCaixa();
                    log.append("Caixa adicionada.\n");
                    break;

                case 4:
                    mercado.removerCaixaDeAtendimento();
                    log.append("Caixa removida.\n");
                    break;

                case 5:
                    System.out.print("Digite o valor de tempo de atendimento: ");
                    int tempoT = input.nextInt();
                    mercado.atenderEmTempoT(tempoT);
                    log.append("Atendido T=").append(tempoT).append("\n");
                    break;

                case 0:
                    System.out.println("Saindo do modo manual...\n");
                    GestorDeFicheiros.registrarSimulacao("Modo Manual", log.toString());
                    break;

                default:
                    System.out.println("Digite uma opção válida!!!");
            }
        } while (op != 0);
    }
}
