package entidades;

public class Cliente {

    String idCliente;
    private int totalProdutos;

    public Cliente(String idCliente, int totalProdutos) {
        this.idCliente = idCliente;
        this.totalProdutos = totalProdutos;
    }

    
    
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", totalProdutos=" + totalProdutos + '}';
    }

    public int getTotalProdutos() {
        return totalProdutos;
    }
}
