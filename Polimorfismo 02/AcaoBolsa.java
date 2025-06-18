class AcaoBolsa extends Investimento {
    private String codigoAcao;
    private String nomeEmpresa;
    private double taxaCorretagemFixaMensal;
    private final double valorizacaoMensalMedia = 0.008;

    public AcaoBolsa(Cliente cliente, double valorInicial, String codigoAcao, String nomeEmpresa, double taxaCorretagemFixaMensal) {
        super(cliente, valorInicial);
        this.codigoAcao = codigoAcao; 
        this.nomeEmpresa = nomeEmpresa;
        this.taxaCorretagemFixaMensal = taxaCorretagemFixaMensal;
    }

    public String getCodigoAcao() {
        return codigoAcao;
    }

    public void setCodigoAcao(String codigoAcao) {
        this.codigoAcao = codigoAcao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public double getTaxaCorretagemFixaMensal() {
        return taxaCorretagemFixaMensal;
    }

    public void setTaxaCorretagemFixaMensal(double taxaCorretagemFixaMensal) {
        this.taxaCorretagemFixaMensal = taxaCorretagemFixaMensal;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double saldoBrutoProjetado = saldo * Math.pow((1 + valorizacaoMensalMedia), numeroMeses);
        double totalTaxasCorretagem = taxaCorretagemFixaMensal * numeroMeses;
        double saldoFinal = saldoBrutoProjetado - totalTaxasCorretagem;
        return Math.max(0, saldoFinal);
    }

    @Override
    public void simularPassagemDeMes() {
        double saldoAposValorizacao = this.getSaldo() * (1 + valorizacaoMensalMedia);
        double novoSaldo = saldoAposValorizacao - taxaCorretagemFixaMensal;
        this.setSaldo(Math.max(0, novoSaldo));
        System.out.println("Ação (" + codigoAcao + ") - Saldo após 1 mês: R$" + String.format("%.2f", this.getSaldo()));
    }

    @Override
    public String toString() {
        return "Ação na Bolsa (" + codigoAcao + ") - " + super.toString() +
               ", Empresa: " + nomeEmpresa + ", Taxa Corretagem Mensal: R$" + String.format("%.2f", taxaCorretagemFixaMensal);
    }
}
