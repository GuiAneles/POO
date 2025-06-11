abstract class Veiculo {
    protected String marca, modelo, placa;
    protected int ano;
    protected double valorLocacao, valorMulta;
    protected boolean disponivel = true;

    public Veiculo(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.valorLocacao = valorLocacao;
        this.valorMulta = valorMulta;
    }

    public boolean estaDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean d) {
        this.disponivel = d;
    }

    public String getPlaca() {
        return placa;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public abstract int getRenovacoesGratis();
}