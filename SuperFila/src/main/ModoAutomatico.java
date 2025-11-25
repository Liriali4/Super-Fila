package main;

import entidades.Mercado;
import java.util.Random;
import java.util.Scanner;

public class ModoAutomatico {

    public static void automatico() {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        Mercado mercado = new Mercado();

        System.out.println("\n---------------------------------- Modo automático activado!!! ----------------------------------\n");

        // Tempo por produto
        System.out.print("Qual é o tempo de atendimento de um produto? (Enter para 5 segundos): ");
        String respostaTempo = input.nextLine();
        int tempoDeProduto = respostaTempo.isEmpty() ? 5 : Integer.parseInt(respostaTempo);

        // Número de caixas
        System.out.print("Qual é o número de caixas? (Enter para 4 caixas): ");
        String respostaCaixas = input.nextLine();
        int totalDeCaixas = respostaCaixas.isEmpty() ? 4 : Integer.parseInt(respostaCaixas);

        // Tempo entre clientes
        System.out.print("Qual é o intervalo de tempo máximo entre clientes? (Enter para 15 segundos): ");
        String respostaTempoEntreClientes = input.nextLine();
        int tempoEntreClientes = respostaTempoEntreClientes.isEmpty()
                ? 15
                : Integer.parseInt(respostaTempoEntreClientes);

        // Inicializar o mercado
        mercado.iniciarMercado(totalDeCaixas, tempoDeProduto);

        System.out.println("\nSimulação iniciada em modo automático!");
        System.out.println("Pressione ENTER para avançar 1 ciclo, ou '0' para encerrar.\n");

        // Variáveis de controle da simulação
        int contadorTempo = 0;
        int tempoParaNovoCliente = 1 + rand.nextInt(tempoEntreClientes);

        while (true) {

            contadorTempo++;

            // Criar cliente quando chega o momento
            if (contadorTempo >= tempoParaNovoCliente) {
                mercado.criarCliente();
                System.out.println("🟢 Novo cliente chegou ao mercado!");

                // Gera próximo tempo de chegada
                tempoParaNovoCliente = 1 + rand.nextInt(tempoEntreClientes);
                contadorTempo = 0;
            }

            // Cada ciclo simula atendimento de 1 segundo
            mercado.atenderEmTempoT(1);

            // Mostrar estado atual
            System.out.println(mercado);

            System.out.print("\nENTER = próximo passo | 0 = encerrar: ");
            String r = input.nextLine();

            if (r.equals("0")) {
                System.out.println("\nModo automático encerrado.\n");
                break;
            }
        }
    }
}
