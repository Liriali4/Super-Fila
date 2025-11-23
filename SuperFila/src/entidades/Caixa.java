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

        // Se não tiver clientes, não faz nada
        if (clientes.isEmpty()) {
            return;
        }

        while (T > 0 && !clientes.isEmpty()) {

            Cliente atual = clientes.get(0);

            // Se for a primeira vez, tempoRestante já deve estar calculado no adicionarCliente
            // CASO 1: T < tempoRestante
            if (T < tempoRestanteParaClienteActual) {
                tempoRestanteParaClienteActual -= T;
                tempoTotalDeAtendimento += T;
                T = 0; // acabou o tempo
            } // CASO 2: T == tempoRestante
            else if (T == tempoRestanteParaClienteActual) {
                tempoTotalDeAtendimento += T;
                totalDeClientesAtendidos++;

                // remover cliente
                clientes.remove(0);

                // recalcular média
                tempoMedioDeAtendimentoPorCliente
                        = tempoTotalDeAtendimento / totalDeClientesAtendidos;

                T = 0;

                // se ainda existir cliente depois, calcular tempo dele
                if (!clientes.isEmpty()) {
                    Cliente proximo = clientes.get(0);
                    tempoRestanteParaClienteActual
                            = proximo.getTotalProdutos() * tempoPorProduto;
                }
            } // CASO 3: T > tempoRestante
            else {
                // Tempo restante é consumido completamente
                T -= tempoRestanteParaClienteActual;
                tempoTotalDeAtendimento += tempoRestanteParaClienteActual;
                totalDeClientesAtendidos++;

                // remover o cliente atendido
                clientes.remove(0);

                tempoMedioDeAtendimentoPorCliente
                        = tempoTotalDeAtendimento / totalDeClientesAtendidos;

                // se houver próximo cliente, calcular seu tempo também
                if (!clientes.isEmpty()) {
                    Cliente proximo = clientes.get(0);
                    tempoRestanteParaClienteActual
                            = proximo.getTotalProdutos() * tempoPorProduto;
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

        sb.append("\n---------------------------------------\n");
        sb.append(String.format("Caixa %d:\n", idCaixa));
        sb.append(String.format("Clientes na fila: %d\n", clientes.size()));

        if (!clientes.isEmpty()) {
            sb.append(String.format(
                    "Tempo restante para atender cliente do topo: %d seg\n",
                    tempoRestanteParaClienteActual
            ));
        }

        sb.append(String.format("Clientes atendidos: %d\n", totalDeClientesAtendidos));
        sb.append(String.format("Tempo total de atendimento: %d seg\n", tempoTotalDeAtendimento));

        if (totalDeClientesAtendidos > 0) {
            sb.append(String.format(
                    "Tempo médio atendimento: %d seg\n",
                    tempoMedioDeAtendimentoPorCliente
            ));
        }

        // Agora mostrar os clientes como uma fila
        sb.append("Fila: ");

        if (clientes.isEmpty()) {
            sb.append("(vazia)\n");
        } else {
            for (Cliente c : clientes) {
                sb.append(c.toString()).append(" --> ");
            }
            // remove última seta
            sb.setLength(sb.length() - 5);
            sb.append("\n");
        }

        return sb.toString();
    }

}
