
abstract public class Conta {

    private Cliente cliente;
    private int numeroConta;
    protected double saldo;

    public Conta(Cliente cliente, int numeroConta, double saldoInicial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    abstract protected boolean isClienteValido();

    public boolean sacar(double valor) {
        if (valor > saldo || valor <= 0) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
