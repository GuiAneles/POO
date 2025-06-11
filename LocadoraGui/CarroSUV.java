class CarroSUV extends Veiculo {
    private int portaMalas;
    private String tracao, combustivel;
    public CarroSUV(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta,
                    int portaMalas, String tracao, String combustivel) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.portaMalas = portaMalas;
        this.tracao = tracao;
        this.combustivel = combustivel;
    }
    public int getRenovacoesGratis() {
        return 3;
    }
}