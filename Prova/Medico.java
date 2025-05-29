
class Medico extends Funcionarios {

    private String crm;
    private String horarioEntrada;
    private String horarioSaida;
    private String listaPlanos;
    private String especialidade;
    private String salario;

    public Medico(String crm, String especialidade, String horarioEntrada, String horarioSaida, String listaPlanos, String nome, String telefone, String endereco, String cpf, String salario) {
        super(nome, telefone, endereco, cpf);
        this.crm = crm;
        this.especialidade = especialidade;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.listaPlanos = listaPlanos;
        this.salario = salario;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getListaPlanos() {
        return listaPlanos;
    }

    public void setListaPlanos(String listaPlanos) {
        this.listaPlanos = listaPlanos;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

}
