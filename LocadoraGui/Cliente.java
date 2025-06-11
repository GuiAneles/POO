import java.util.ArrayList;

abstract class Cliente {
    protected String nome, telefone, endereco;
    public Cliente(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    public abstract boolean podeAlugarMais(ArrayList<Emprestimo> emprestimos);
    public abstract String getIdentificador();
    public String getNome() {
        return nome;
    }
}