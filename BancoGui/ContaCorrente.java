
public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente, int numeroConta, double saldoInicial) {
        super(cliente, numeroConta, saldoInicial);
        if (!isClienteValido()) {
            throw new IllegalArgumentException("Conta Corrente só pode ser criada para Pessoa Física");
        }
    }

    protected boolean isClienteValido() {
        return getCliente() instanceof PessoaFisica;
    }

}
