import java.util.ArrayList;

class PessoaFisica extends Cliente {
    private String cpf;
    public PessoaFisica(String nome, String telefone, String endereco, String cpf) {
        super(nome, telefone, endereco);
        this.cpf = cpf;
    }
    public boolean podeAlugarMais(ArrayList<Emprestimo> emprestimos) {
        for (Emprestimo e : emprestimos) {
            if (e.getCliente().equals(this)) return false;
        }
        return true;
    }
    public String getIdentificador() { return cpf; }
}