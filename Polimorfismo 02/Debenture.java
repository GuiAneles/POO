class Debenture extends Investimento {
    private String nomeEmpresaEmissora;
    private double taxaJurosAnualDebenture;
    private final double percentualTributacaoPJ = 0.20;

    public Debenture(Cliente cliente, double valorInicial, String nomeEmpresaEmissora, double taxaJurosAnualDebenture) {
        super(cliente, valorInicial);
        if (!(cliente instanceof PessoaJuridica)) {
            throw new IllegalArgumentException("Debênture é exclusivo para clientes Pessoa Jurídica.");
        }
        this.nomeEmpresaEmissora = nomeEmpresaEmissora;
        this.taxaJurosAnualDebenture = taxaJurosAnualDebenture;
    }

    public String getNomeEmpresaEmissora() {
        return nomeEmpresaEmissora;
    }

    public void setNomeEmpresaEmissora(String nomeEmpresaEmissora) {
        this.nomeEmpresaEmissora = nomeEmpresaEmissora;
    }

    public double getTaxaJurosAnualDebenture() {
        return taxaJurosAnualDebenture;
    }

    public void setTaxaJurosAnualDebenture(double taxaJurosAnualDebenture) {
        this.taxaJurosAnualDebenture = taxaJurosAnualDebenture;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double taxaJurosMensal = taxaJurosAnualDebenture / 12.0;
        double saldoBrutoProjetado = saldo * Math.pow((1 + taxaJurosMensal), numeroMeses);
        double rendimentoBruto = saldoBrutoProjetado - saldo;
        double impostoDevido = rendimentoBruto * percentualTributacaoPJ;
        double saldoLiquidoProjetado = saldo + rendimentoBruto - impostoDevido;
        return saldoLiquidoProjetado;
    }

    @Override
    public void simularPassagemDeMes() {
        double rendimentoMes = this.getSaldo() * (this.taxaJurosAnualDebenture / 12.0);
        this.setSaldo(this.getSaldo() + rendimentoMes);
        System.out.println("Debênture (" + nomeEmpresaEmissora + ") - Saldo após 1 mês: R$" + String.format("%.2f", this.getSaldo()));
    }

    @Override
    public String toString() {
        return "Debênture (" + nomeEmpresaEmissora + ") - " + super.toString() +
               ", Taxa Juros Anual: " + String.format("%.2f", taxaJurosAnualDebenture * 100) + "%";
    }
}