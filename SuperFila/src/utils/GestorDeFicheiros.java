package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorDeFicheiros {

    private static String FICHEIRO = "relatorio_simulacao.txt";

    private static DateTimeFormatter FORMATO
            = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void registrarSimulacao(String titulo, String conteudo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHEIRO, true))) {

            bw.write("\n====================================================\n");
            bw.write("SIMULAÇÃO: " + titulo + "\n");
            bw.write("Data: " + LocalDateTime.now().format(FORMATO) + "\n");
            bw.write("====================================================\n\n");
            bw.write(conteudo);
            bw.write("\n\n");
        } catch (IOException e) {
            System.out.println("Erro ao gravar simulação: " + e.getMessage());
        }
    }
}
