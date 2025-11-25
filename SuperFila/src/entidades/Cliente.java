package entidades;

public class Cliente {

    private String idCliente;
    private int totalProdutos;

    public Cliente(String idCliente, int totalProdutos) {
        this.idCliente = idCliente;
        this.totalProdutos = totalProdutos;
    }

    public int getTotalProdutos() {
        return totalProdutos;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String toCard() {
    return String.format(
        "┌───────────────┐\n" +
        "│ Cliente %s    │\n" +
        "│ %d produtos   │\n" +
        "└───────────────┘",
        idCliente,
        totalProdutos
    );
}


}
