
public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica(String nome, String cpf, String senha) {
        super(nome, senha);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDocumento() {
        return getCpf();
    }

    public String getTipo() {
        return "Pessoa Física";
    }
}
