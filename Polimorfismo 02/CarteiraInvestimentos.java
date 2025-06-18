import java.util.ArrayList;
import java.util.List;

class CarteiraInvestimentos {
    private Cliente cliente;
    private List<Investimento> investimentos;

    public CarteiraInvestimentos(Cliente cliente) {
        this.cliente = cliente;
        this.investimentos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void adicionarInvestimento(Investimento investimento) {
        if (investimento.getCliente().equals(this.cliente)) {
            this.investimentos.add(investimento);
            System.out.println("Investimento adicionado à carteira de " + cliente.getNome() + ": " + investimento.getClass().getSimpleName());
        } else {
            System.out.println("Erro: Não foi possível adicionar o investimento. O cliente do investimento não corresponde ao cliente da carteira.");
        }
    }

    public double calcularValorTotalInvestido() {
        double total = 0;
        for (Investimento inv : investimentos) {
            total += inv.getSaldo();
        }
        return total;
    }

    public void simularPassagemDeMesParaTodosInvestimentos() {
        System.out.println("\n--- Simulando passagem de mês para a carteira de " + cliente.getNome() + " ---");
        for (Investimento inv : investimentos) {
            inv.simularPassagemDeMes();
        }
        System.out.println("--- Simulação concluída para a carteira de " + cliente.getNome() + " ---");
    }

    public void exibirSaldosIndividuais() {
        System.out.println("\n--- Saldos Individuais na Carteira de " + cliente.getNome() + " ---");
        for (Investimento inv : investimentos) {
            System.out.println("- " + inv.getClass().getSimpleName() + ": R$" + String.format("%.2f", inv.getSaldo()));
        }
    }
}