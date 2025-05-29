
public class Anotacoes {

    private String Sintomas;
    private String Pescricao;
    private String Exames;

    public Anotacoes(String Exames, String Pescricao, String Sintomas) {
        this.Exames = Exames;
        this.Pescricao = Pescricao;
        this.Sintomas = Sintomas;
    }

    public String getSintomas() {
        return Sintomas;
    }

    public void setSintomas(String Sintomas) {
        this.Sintomas = Sintomas;
    }

    public String getPescricao() {
        return Pescricao;
    }

    public void setPescricao(String Pescricao) {
        this.Pescricao = Pescricao;
    }

    public String getExames() {
        return Exames;
    }

    public void setExames(String Exames) {
        this.Exames = Exames;
    }

}
