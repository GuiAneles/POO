
public class PlanoSaude {

    private String nome;
    private String telefone;
    private String cnpj;
    private String endereco;

    public PlanoSaude(String nome, String telefone, String cnpj, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
