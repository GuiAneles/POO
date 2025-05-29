
class Especialidade {

    private String nome;
    private String crm;

    public Especialidade(String crm, String nome) {
        this.crm = crm;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

}
