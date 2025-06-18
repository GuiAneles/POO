class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String email, String cpf) {
        super(nome, email);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getIdentificadorDocumento() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Pessoa Física - " + super.toString() + ", CPF: " + cpf;
    }
}