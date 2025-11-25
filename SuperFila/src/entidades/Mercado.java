package entidades;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

    private int tempoPorProduto;
    private int tempoDeAtendimento;
    private List<Caixa> caixas = new ArrayList<>();

    public Mercado() {
    }

    public void iniciarMercado(int numCaixas, int tempoPorProduto) {
        this.tempoPorProduto = tempoPorProduto;
        //inicializar os caixas do mercado
        for (int i = 0; i < numCaixas; i++) {
            Caixa novaCaixa = new Caixa(i + 1);
            caixas.add(novaCaixa);
        }
    }

    public void criarCliente() {
        // produtos entre 2 e 120
        int totalProdutos = 2 + (int) (Math.random() * (10 - 2 + 1));
        
        Cliente novoCliente = new Cliente("", totalProdutos);
        Caixa destino = getCaixaComMenosClientes();
        destino.adicionarCliente(novoCliente, this.tempoPorProduto);

    }

    public void adicionarCaixa() {
        int idCaixa;
        if (caixas.size() != 0) {
            //Pega o id do último caixa na fila
            Caixa ultimaCaixa = caixas.get((caixas.size() - 1));
            idCaixa = ultimaCaixa.getIdCaixa() + 1;
        } else {
            idCaixa = this.caixas.size() + 1;
        }
        Caixa novoCaixa = new Caixa(idCaixa);
        caixas.add(novoCaixa);
    }

    public void removerCaixaDeAtendimento() {
        this.caixas.removeIf(c -> c.getTotalDeClientesNaFila() == 0);
    }

    public void atenderEmTempoT(int tempoDeAtendimento) {
        for (Caixa caixa : caixas) {
            caixa.atenderTempo(tempoDeAtendimento, tempoPorProduto);
        }
    }

    //-----------------------------------       GETTERS      ------------------------------------------
    private Caixa getCaixaComMenosClientes() {
        Caixa menor = caixas.get(0);
        for (Caixa c : caixas) {
            if (c.getTotalDeClientesNaFila() < menor.getTotalDeClientesNaFila()) {
                menor = c;
            }
        }
        return menor;
    }
    //----------------------------------- FUNÇÕES AUXILIARES ------------------------------------------

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("┌────────────────────────────────────────────────────────────────┐\n");
        sb.append("│            PARÂMETROS DA SIMULAÇÃO                    │\n");
        sb.append(String.format(
                "│  Tempo atendimento/produto: %ds                        │\n│  Nº Caixas: %d                                         │\n│  Intervalo máximo entre clientes: %d                   │\n",
                tempoPorProduto, caixas.size(), tempoDeAtendimento
        ));
        sb.append("└────────────────────────────────────────────────────────────────┘\n\n");

        for (Caixa c : caixas) {
            sb.append(c).append("\n");
        }

        return sb.toString();
    }

}
