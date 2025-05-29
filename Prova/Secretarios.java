
class Secretarios extends Funcionarios {

    private String salario;

    public Secretarios(String nome, String telefone, String endereco, String cpf, String salario) {
        super(nome, telefone, endereco, cpf);
        this.salario = salario;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

}
