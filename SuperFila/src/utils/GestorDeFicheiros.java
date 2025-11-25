package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GestorDeFicheiros {

    // Caminho padrão do ficheiro de logs
    private static final String FICHEIRO = "relatorio_simulacao.txt";

    // Salva sobrescrevendo tudo
    public static void salvar(String conteudo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHEIRO))) {
            bw.write(conteudo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar ficheiro: " + e.getMessage());
        }
    }

    // Acrescenta ao final do ficheiro
    public static void append(String conteudo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHEIRO, true))) {
            bw.write(conteudo);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no ficheiro: " + e.getMessage());
        }
    }

    // Ler todo o ficheiro
    public static String lerTudo() {
        try {
            return new String(Files.readAllBytes(Paths.get(FICHEIRO)));
        } catch (IOException e) {
            return "Erro ao ler o ficheiro!";
        }
    }

    // Ler por linhas
    public static List<String> lerLinhas() {
        try {
            return Files.readAllLines(Paths.get(FICHEIRO));
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
            return null;
        }
    }
}
