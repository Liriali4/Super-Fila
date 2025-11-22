package entidades;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

    private int tempoPorProduto;
    private List<Caixa> caixas = new ArrayList<>();

    public Mercado() {
    }

    public void iniciarMercado(int numCaixas, int tempoPorProduto) {
        this.tempoPorProduto = tempoPorProduto;

        for (int i = 0; i < numCaixas; i++) {
            Caixa novaCaixa = new Caixa(i + 1);
            caixas.add(novaCaixa);
        }
    }

    public void criarCliente() {
        // produtos entre 2 e 120
        int totalProdutos = 2 + (int) (Math.random() * (120 - 2 + 1));

        // cria o cliente
        Cliente novoCliente = new Cliente("", totalProdutos);

        // encontra a caixa com menor fila
        Caixa destino = getCaixaComMenosClientes();

        // adiciona o cliente na caixa certa
        destino.adicionarCliente(novoCliente);

        System.out.println("\nCliente adicionado na caixa " + destino.getIdCaixa());
    }

    public void adicionarCaixa(Caixa c) {
        caixas.add(c);
    }

    public void removerCaixa() {
    }

    private Caixa getCaixaComMenosClientes() {
        Caixa menor = caixas.get(0);

        for (Caixa c : caixas) {
            if (c.getTotalDeClientesNaFila() < menor.getTotalDeClientesNaFila()) {
                menor = c;
            }
        }

        return menor;
    }

    @Override
    public String toString() {
        if (caixas.isEmpty()) {
            return "Não existem caixas para listar.";
        }
        return """
               Mercado 
               caixas""" + caixas + "";
    }

}
