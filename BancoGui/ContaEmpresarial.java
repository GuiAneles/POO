
public class ContaEmpresarial extends ContaEspecial {

    public ContaEmpresarial(Cliente cliente, int numeroConta, double saldoInicial, double chequeEspecial) {
        super(cliente, numeroConta, saldoInicial, chequeEspecial);
        if (!isClienteValido()) {
            throw new IllegalArgumentException("Conta Empresarial só pode ser criada para Pessoa Jurídica");
        }
    }

    protected boolean isClienteValido() {
        return getCliente() instanceof PessoaJuridica;
    }

    public PessoaJuridica getClientePJ() {
        return (PessoaJuridica) getCliente();
    }

    public String toString() {
        PessoaJuridica pj = getClientePJ();
        return "Conta Empresarial - " + pj.getRazaoSocial()
                + " (CNPJ: " + pj.getCnpj() + ") - Saldo: R$ " + getSaldo()
                + " - Limite: R$ " + getLimiteDisponivel();
    }
}
