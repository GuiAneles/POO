
public class ContaPoupanca extends Conta {

    private static final double TAXA_RENDIMENTO = 0.005; // 0,5%

    public ContaPoupanca(Cliente cliente, int numeroConta, double saldoInicial) {
        super(cliente, numeroConta, saldoInicial);
        if (!isClienteValido()) {
            throw new IllegalArgumentException("Conta Poupança só pode ser criada para Pessoa Física");
        }
    }

    protected boolean isClienteValido() {
        return getCliente() instanceof PessoaFisica;
    }

    public double aplicarRendimento() {
        double valorRendimento = saldo * TAXA_RENDIMENTO;
        saldo += valorRendimento;
        return valorRendimento;
    }
}
