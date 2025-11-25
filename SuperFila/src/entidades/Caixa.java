package entidades;

import java.util.ArrayList;
import java.util.List;

public class Caixa {

    private int idCaixa;
    private int totalDeClientesNaFila;
    private int tempoRestanteParaClienteActual;
    private int totalDeClientesAtendidos;
    private int tempoTotalDeAtendimento;
    private int tempoMedioDeAtendimentoPorCliente;

    //OPÇÕES COMO ATRIBUTOS
    private List<Cliente> clientes = new ArrayList<>();

    //construtores
    public Caixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

//-----------------------------------       MÉTODOS      ------------------------------------------
    public void adicionarCliente(Cliente c, int tempoPorProduto) {
        int t = clientes.size();
        c.setIdCliente(gerarCodigoDoCliente(t));
        clientes.add(c);
        this.totalDeClientesNaFila = clientes.size();
        if (t == 0) {
            this.tempoRestanteParaClienteActual = c.getTotalProdutos() * tempoPorProduto;
        }
        System.out.println("\n Cliente adicionado na caixa " + this.idCaixa + "\n");
    }

    public void atenderTempo(int T, int tempoPorProduto) {

        if (clientes.isEmpty()) {
            tempoRestanteParaClienteActual = 0;
            totalDeClientesNaFila = 0;
            return;
        }

        while (T > 0 && !clientes.isEmpty()) {

            Cliente atual = clientes.get(0);

            // CASO 1 – T < tempo restante
            if (T < tempoRestanteParaClienteActual) {

                tempoRestanteParaClienteActual -= T;
                tempoTotalDeAtendimento += T;
                T = 0;
            } // CASO 2 – T == tempo restante
            else if (T == tempoRestanteParaClienteActual) {

                tempoTotalDeAtendimento += T;
                totalDeClientesAtendidos++;

                clientes.remove(0);

                // ATUALIZA A FILA
                totalDeClientesNaFila = clientes.size();

                // Recalcula média
                if (totalDeClientesAtendidos > 0) {
                    tempoMedioDeAtendimentoPorCliente
                            = tempoTotalDeAtendimento / totalDeClientesAtendidos;
                }

                T = 0;

                // Se ainda existe cliente, preparar tempo do próximo
                if (!clientes.isEmpty()) {
                    tempoRestanteParaClienteActual
                            = clientes.get(0).getTotalProdutos() * tempoPorProduto;
                } else {
                    tempoRestanteParaClienteActual = 0;
                }
            } // CASO 3 – T > tempo restante
            else {

                T -= tempoRestanteParaClienteActual;
                tempoTotalDeAtendimento += tempoRestanteParaClienteActual;
                totalDeClientesAtendidos++;

                clientes.remove(0);

                // ATUALIZA A FILA
                totalDeClientesNaFila = clientes.size();

                // Recalcula média
                if (totalDeClientesAtendidos > 0) {
                    tempoMedioDeAtendimentoPorCliente
                            = tempoTotalDeAtendimento / totalDeClientesAtendidos;
                }

                // Novo cliente ou fila acabou
                if (!clientes.isEmpty()) {
                    tempoRestanteParaClienteActual
                            = clientes.get(0).getTotalProdutos() * tempoPorProduto;
                } else {
                    tempoRestanteParaClienteActual = 0;
                }
            }
        }
    }

    //-----------------------------------       GETTERS      ------------------------------------------
    public int getTotalDeClientesNaFila() {
        return totalDeClientesNaFila;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    //----------------------------------- FUNÇÕES AUXILIARES ------------------------------------------
    private Cliente getClienteAtual() {
        if (clientes.isEmpty()) {
            return null;
        }
        return clientes.get(0);
    }

    public static String gerarCodigoDoCliente(int contador) {
        String sugestao = 'C' + String.format("%04d", contador + 1);
        return sugestao;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        // ─────────── DESENHA A CAIXA ──────────────────
        sb.append(String.format("┌─────────────── CAIXA %d ────────────────┐\n", idCaixa));
        sb.append(String.format("│ Clientes na fila: %d\n", clientes.size()));
        sb.append(String.format("│ Tempo restante do topo: %ds\n", tempoRestanteParaClienteActual));
        sb.append(String.format("│ Total atendidos: %d\n", totalDeClientesAtendidos));
        sb.append(String.format("│ Tempo total atendimento: %ds\n", tempoTotalDeAtendimento));
        sb.append(String.format("│ Média: %ds\n", tempoMedioDeAtendimentoPorCliente));
        sb.append("└──────────────────────────────────────────┘");

        // ─────────── DESENHA OS CLIENTES EM LINHA ────────
        if (!clientes.isEmpty()) {

            sb.append("\n");

            // Vamos montar linha a linha dos cartões dos clientes
            // Cada cartão tem 3 linhas
            //  linha 0: topo
            //  linha 1: nome cliente
            //  linha 2: nº produtos
            //  linha 3: base
            // Arrays temporários para cada linha
            List<String> linha0 = new ArrayList<>();
            List<String> linha1 = new ArrayList<>();
            List<String> linha2 = new ArrayList<>();
            List<String> linha3 = new ArrayList<>();

            // Preencher as linhas
            for (Cliente cli : clientes) {
                linha0.add("┌───────────────┐");
                linha1.add(String.format("│ Cliente %s    │", cli.getIdCliente()));
                linha2.add(String.format("│ %d produtos   │", cli.getTotalProdutos()));
                linha3.add("└───────────────┘");
            }

            // Agora imprimir horizontalmente
            sb.append("     ");   // deslocar um pouco para a direita

            // Linha do topo + setas apontando para o caixa
            for (int i = linha0.size() - 1; i >= 0; i--) {
                sb.append("◀ ").append(linha0.get(i)).append(" ");
            }

            sb.append("\n     ");
            for (int i = linha1.size() - 1; i >= 0; i--) {
                sb.append("  ").append(linha1.get(i)).append(" ");
            }

            sb.append("\n     ");
            for (int i = linha2.size() - 1; i >= 0; i--) {
                sb.append("  ").append(linha2.get(i)).append(" ");
            }

            sb.append("\n     ");
            for (int i = linha3.size() - 1; i >= 0; i--) {
                sb.append("  ").append(linha3.get(i)).append(" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }

}
