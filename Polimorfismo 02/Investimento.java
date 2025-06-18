
abstract class Investimento {
    protected Cliente cliente;
    protected double saldo;

    public Investimento(Cliente cliente, double valorInicial) {
        this.cliente = cliente;
        this.saldo = valorInicial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void aplicar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Aplicado R$" + String.format("%.2f", valor) + " ao investimento. Novo saldo: R$" + String.format("%.2f", this.saldo));
        } else {
            System.out.println("Valor de aplicação deve ser positivo.");
        }
    }

    public double resgatar(double valor) {
        if (valor > 0) {
            if (this.saldo - valor >= 0) {
                this.saldo -= valor;
                System.out.println("Resgatado R$" + String.format("%.2f", valor) + " do investimento. Novo saldo: R$" + String.format("%.2f", this.saldo));
                return valor;
            } else {
                System.out.println("Saldo insuficiente para resgatar R$" + String.format("%.2f", valor) + ". Saldo atual: R$" + String.format("%.2f", this.saldo));
                return 0;
            }
        } else {
            System.out.println("Valor de resgate deve ser positivo.");
            return 0;
        }
    }

    public abstract double calcularSaldoProjetado(int numeroMeses);

    public abstract void simularPassagemDeMes();

    public String toString() {
        return "Cliente: " + cliente.getNome() + ", Saldo Atual: R$" + String.format("%.2f", saldo);
    }
}