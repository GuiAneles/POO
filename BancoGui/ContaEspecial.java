
public class ContaEspecial extends Conta {

    private double chequeEspecial;

    public ContaEspecial(Cliente cliente, int numeroConta, double saldoInicial, double chequeEspecial) {
        super(cliente, numeroConta, saldoInicial);
        this.chequeEspecial = chequeEspecial;
        if (!isClienteValido()) {
            throw new IllegalArgumentException("Conta Especial só pode ser criada para Pessoa Física");
        }
    }

    protected boolean isClienteValido() {
        return getCliente() instanceof PessoaFisica;
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > (getSaldo() + chequeEspecial)) {
            return false;
        }

        saldo -= valor;
        return true;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public double getLimiteDisponivel() {
        return getSaldo() + chequeEspecial;
    }
}
