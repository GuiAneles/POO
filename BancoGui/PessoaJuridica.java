
public class PessoaJuridica extends Cliente {

    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica(String nome, String cnpj, String razaoSocial, String senha) {
        super(nome, senha);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getDocumento() {
        return getCnpj();
    }

    public String getTipo() {
        return "Pessoa Jurídica";
    }
}
