
public class Consulta {

    private Paciente paciente;
    private Medico medico;
    private Secretarios secretario;
    private PlanoSaude planoSaude;
    private Anotacoes anotacoes;
    private String horario;
    private double valor;

    public Consulta(Anotacoes anotacoes, String horario, Medico medico, Paciente paciente, PlanoSaude planoSaude, Secretarios secretario, double valor) {
        this.anotacoes = anotacoes;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.planoSaude = planoSaude;
        this.secretario = secretario;
        this.valor = valor;
    }

    public Consulta(String horario, Medico medico, Paciente paciente, PlanoSaude planoSaude, Secretarios secretario, double valor) {
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.planoSaude = planoSaude;
        this.secretario = secretario;
        this.valor = valor;
    }

    public Consulta(String horario, Medico medico, Paciente paciente, Secretarios secretario, double valor) {
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.secretario = secretario;
        this.valor = valor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Secretarios getSecretario() {
        return secretario;
    }

    public void setSecretario(Secretarios secretario) {
        this.secretario = secretario;
    }

    public PlanoSaude getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(PlanoSaude planoSaude) {
        this.planoSaude = planoSaude;
    }

    public Anotacoes getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(Anotacoes anotacoes) {
        this.anotacoes = anotacoes;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean AgendarConsulta(Paciente paciente, Medico medico, PlanoSaude planoSaude, Anotacoes anotacoes, String horario, double valor) {
        if (paciente != null && medico != null && horario != null && !horario.isEmpty() && valor > 0) {
            this.paciente = paciente;
            this.medico = medico;
            this.horario = horario;
            if (planoSaude = null) {
                this.valor = 0;
            } else {
                this.valor = valor;
            }
            return true;
        }
        return false;
    }

}
