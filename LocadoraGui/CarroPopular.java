class CarroPopular extends Veiculo {
    private boolean arCondicionado;
    public CarroPopular(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, boolean arCondicionado) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.arCondicionado = arCondicionado;
    }
    public int getRenovacoesGratis() {
        return 1;
    }
}