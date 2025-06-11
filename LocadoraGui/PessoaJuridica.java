import java.util.ArrayList;

class PessoaJuridica extends Cliente {
    private String cnpj, representante;
    public PessoaJuridica(String nome, String telefone, String endereco, String cnpj, String representante) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
        this.representante = representante;
    }
    public boolean podeAlugarMais(ArrayList<Emprestimo> emprestimos) {
        return true;
    }
    public String getIdentificador() { return cnpj; }
}