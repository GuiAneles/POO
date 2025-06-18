class TesouroPrefixado extends Investimento {
    private String nomeTitulo;
    private double taxaJurosAnual;
    private final double percentualImpostoRenda = 0.15;

    public TesouroPrefixado(Cliente cliente, double valorInicial, String nomeTitulo, double taxaJurosAnual) {
        super(cliente, valorInicial);
        if (!(cliente instanceof PessoaFisica)) {
            throw new IllegalArgumentException("Tesouro Prefixado é exclusivo para clientes Pessoa Física.");
        }
        this.nomeTitulo = nomeTitulo;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public String getNomeTitulo() {
        return nomeTitulo;
    }

    public void setNomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double taxaJurosMensal = taxaJurosAnual / 12.0;
        double saldoBrutoProjetado = saldo * Math.pow((1 + taxaJurosMensal), numeroMeses);
        double rendimentoBruto = saldoBrutoProjetado - saldo;
        double impostoDevido = rendimentoBruto * percentualImpostoRenda;
        double saldoLiquidoProjetado = saldo + rendimentoBruto - impostoDevido;
        return saldoLiquidoProjetado;
    }

    @Override
    public void simularPassagemDeMes() {
        double rendimentoMes = this.getSaldo() * (this.taxaJurosAnual / 12.0);
        this.setSaldo(this.getSaldo() + rendimentoMes);
        System.out.println("Tesouro Prefixado (" + nomeTitulo + ") - Saldo após 1 mês: R$" + String.format("%.2f", this.getSaldo()));
    }

    @Override
    public String toString() {
        return "Tesouro Prefixado (" + nomeTitulo + ") - " + super.toString() +
               ", Taxa Juros Anual: " + String.format("%.2f", taxaJurosAnual * 100) + "%";
    }
}