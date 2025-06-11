class CarroLuxo extends Veiculo {
    private int airBags, portaMalas;
    private boolean gps;
    public CarroLuxo(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta,
                     int airBags, int portaMalas, boolean gps) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.airBags = airBags;
        this.portaMalas = portaMalas;
        this.gps = gps;
    }
    public int getRenovacoesGratis() {
        return 5;
    }
}