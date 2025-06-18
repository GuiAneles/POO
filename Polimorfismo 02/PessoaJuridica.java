class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, String email, String cnpj) {
        super(nome, email);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getIdentificadorDocumento() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "Pessoa Jurídica - " + super.toString() + ", CNPJ: " + cnpj;
    }
}