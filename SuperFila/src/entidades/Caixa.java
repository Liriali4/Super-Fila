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

    //Métodos
    public void adicionarCliente() {
    }

    public void removerCliente() {

    }

    public void atenderTempo() {

    }

    //----------------------------------- FUNÇÕES AUXILIARES ------------------------------------------
    public static String gerarCodigoDoCliente(int contador) {
        String sugestao = 'C' + String.format("%04d", contador + 1);
        return sugestao;
    }

}
