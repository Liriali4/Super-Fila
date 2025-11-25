package main;

import entidades.Mercado;
import java.util.Random;
import java.util.Scanner;
import utils.GestorDeFicheiros;

public class ModoAutomatico {

    public static void automatico() {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        Mercado mercado = new Mercado();

        StringBuilder log = new StringBuilder();

        System.out.println("\n---------------------------------- Modo automático activado!!! ----------------------------------\n");

        System.out.print("Qual é o tempo de atendimento de um produto? (Enter para 5 segundos): ");
        String respostaTempo = input.nextLine();
        int tempoDeProduto = respostaTempo.isEmpty() ? 5 : Integer.parseInt(respostaTempo);

        System.out.print("Qual é o número de caixas? (Enter para 4 caixas): ");
        String respostaCaixas = input.nextLine();
        int totalDeCaixas = respostaCaixas.isEmpty() ? 4 : Integer.parseInt(respostaCaixas);

        System.out.print("Qual é o intervalo de tempo máximo entre clientes? (Enter para 15 segundos): ");
        String rTEC = input.nextLine();
        int tempoEntreClientes = rTEC.isEmpty() ? 15 : Integer.parseInt(rTEC);

        mercado.iniciarMercado(totalDeCaixas, tempoDeProduto);

        int contadorTempo = 0;
        int tempoParaNovoCliente = 1 + rand.nextInt(tempoEntreClientes);

        System.out.println("\nSimulação iniciada em modo automático!");
        System.out.println("Pressione ENTER para avançar 1 ciclo, ou '0' para encerrar.\n");

        while (true) {

            contadorTempo++;

            if (contadorTempo >= tempoParaNovoCliente) {
                mercado.criarCliente();
                log.append("Novo cliente chegou.\n");
                tempoParaNovoCliente = 1 + rand.nextInt(tempoEntreClientes);
                contadorTempo = 0;
            }

            mercado.atenderEmTempoT(1);

            String estado = mercado.toString();
            System.out.println(estado);
            log.append(estado).append("\n");

            System.out.print("\nENTER = próximo passo | 0 = encerrar: ");
            String r = input.nextLine();

            if (r.equals("0")) {
                System.out.println("\nModo automático encerrado.\n");
                GestorDeFicheiros.registrarSimulacao("Modo Automático", log.toString());
                break;
            }
        }
    }

}
