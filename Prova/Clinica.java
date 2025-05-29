
class Clinica {

    private String nome;
    private String endereco;
    private String crm;
    private String cnpj;
    private String lFuncionarios;

    public Clinica(String nome, String endereco, String crm, String cnpj, String lFuncionarios) {
        this.nome = nome;
        this.endereco = endereco;
        this.crm = crm;
        this.cnpj = cnpj;
        this.lFuncionarios = lFuncionarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getlFuncionarios() {
        return lFuncionarios;
    }

    public void setlFuncionarios(String lFuncionarios) {
        this.lFuncionarios = lFuncionarios;
    }

}
