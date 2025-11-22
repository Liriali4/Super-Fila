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
    public void adicionarCliente(Cliente c) {
        int t = clientes.size();
        c.idCliente = gerarCodigoDoCliente(t);
        clientes.add(c);
        this.totalDeClientesNaFila = clientes.size();
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

    @Override
    public String toString() {
        return """               
               idCaixa=""" + idCaixa + ", \ntotalDeClientesNaFila=" + totalDeClientesNaFila + ", \ntempoRestanteParaClienteActual=" + tempoRestanteParaClienteActual + ", \ntotalDeClientesAtendidos=" + totalDeClientesAtendidos + ", \ntempoTotalDeAtendimento=" + tempoTotalDeAtendimento + ", \ntempoMedioDeAtendimentoPorCliente=" + tempoMedioDeAtendimentoPorCliente + ", \nclientes=" + clientes + "\n";
    }

    public int getTotalDeClientesNaFila() {
        return totalDeClientesNaFila;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

}
