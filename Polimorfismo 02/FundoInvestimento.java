class FundoInvestimento extends Investimento {
    private String nomeFundo;
    private String cnpjGestora;
    private double taxaAdministracaoAnual;
    private final double rendimentoMensalBruto = 0.01;

    public FundoInvestimento(Cliente cliente, double valorInicial, String nomeFundo, String cnpjGestora, double taxaAdministracaoAnual) {
        super(cliente, valorInicial);
        this.nomeFundo = nomeFundo;
        this.cnpjGestora = cnpjGestora;
        this.taxaAdministracaoAnual = taxaAdministracaoAnual;
    }

    public String getNomeFundo() {
        return nomeFundo;
    }

    public void setNomeFundo(String nomeFundo) {
        this.nomeFundo = nomeFundo;
    }

    public String getCnpjGestora() {
        return cnpjGestora;
    }

    public void setCnpjGestora(String cnpjGestora) {
        this.cnpjGestora = cnpjGestora;
    }

    public double getTaxaAdministracaoAnual() {
        return taxaAdministracaoAnual;
    }

    public void setTaxaAdministracaoAnual(double taxaAdministracaoAnual) {
        this.taxaAdministracaoAnual = taxaAdministracaoAnual;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double saldoProjetado = this.saldo;
        double taxaAdministracaoMensal = taxaAdministracaoAnual / 12.0;

        for (int i = 0; i < numeroMeses; i++) {
            double rendimentoBrutoMes = saldoProjetado * rendimentoMensalBruto;
            double taxaAdmDoMesProjetado = saldoProjetado * taxaAdministracaoMensal;
            saldoProjetado = saldoProjetado + rendimentoBrutoMes - taxaAdmDoMesProjetado;
        }
        return saldoProjetado;
    }

    @Override
    public void simularPassagemDeMes() {
        double rendimentoBrutoMensal = this.getSaldo() * rendimentoMensalBruto;
        double taxaAdmDevida = this.getSaldo() * (this.taxaAdministracaoAnual / 12.0);
        double novoSaldo = this.getSaldo() + rendimentoBrutoMensal - taxaAdmDevida;
        this.setSaldo(Math.max(0, novoSaldo));
        System.out.println("Fundo de Investimento (" + nomeFundo + ") - Saldo após 1 mês: R$" + String.format("%.2f", this.getSaldo()));
    }

    @Override
    public String toString() {
        return "Fundo de Investimento (" + nomeFundo + ") - " + super.toString() +
               ", Gestora: " + cnpjGestora + ", Taxa Administração Anual: " + String.format("%.2f", taxaAdministracaoAnual * 100) + "%";
    }
}