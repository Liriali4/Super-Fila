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

    public void criarCliente(int idCaixa) {

    }

    public void adicionarCaixa(Caixa c) {
        caixas.add(c);
    }

    public void removerCaixa() {
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
