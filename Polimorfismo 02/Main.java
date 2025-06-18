
public class Main { // Nome da classe Principal conforme pedido
    public static void main(String[] args) {
        System.out.println("--- Desafio Sistema de Gerenciamento de Investimentos - InvesteMais ---");

        PessoaFisica pf1 = new PessoaFisica("Ana Paula Silva", "ana.silva@example.com", "123.456.789-00");
        PessoaJuridica pj1 = new PessoaJuridica("Empresa ABC Ltda.", "contato@abc.com", "00.111.222/0001-33");
        PessoaFisica pf2 = new PessoaFisica("Carlos Eduardo Costa", "carlos.costa@example.com", "987.654.321-99");

        System.out.println("\n--- Clientes Criados ---");
        System.out.println(pf1);
        System.out.println(pj1);
        System.out.println(pf2);

        CarteiraInvestimentos carteiraPF1 = new CarteiraInvestimentos(pf1);
        CarteiraInvestimentos carteiraPJ1 = new CarteiraInvestimentos(pj1);
        CarteiraInvestimentos carteiraPF2 = new CarteiraInvestimentos(pf2);

        System.out.println("\n--- Carteiras Criadas ---");

        System.out.println("\n--- Adicionando Investimentos ---");

        Investimento tesouroAna = null;
        Investimento acaoAna = null;
        Investimento fundoAna = null;
        Investimento acaoEmpresa = null;
        Investimento fundoEmpresa = null;
        Investimento debentureEmpresa = null;

        try {
            tesouroAna = new TesouroPrefixado(pf1, 10000.00, "Tesouro Prefixado 2029", 0.10);
            carteiraPF1.adicionarInvestimento(tesouroAna);
            System.out.println(tesouroAna);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar Tesouro Prefixado para Ana: " + e.getMessage());
        }

        try {
            Investimento tesouroInvalido = new TesouroPrefixado(pj1, 5000.00, "Tesouro Prefixado 2030", 0.09);
            carteiraPJ1.adicionarInvestimento(tesouroInvalido);
        } catch (IllegalArgumentException e) {
            System.out.println("Teste de Validação (Tesouro): " + e.getMessage());
        }

        acaoAna = new AcaoBolsa(pf1, 5000.00, "VALE3", "Vale S.A.", 15.00);
        carteiraPF1.adicionarInvestimento(acaoAna);
        System.out.println(acaoAna);

        acaoEmpresa = new AcaoBolsa(pj1, 20000.00, "ITSA4", "Itaúsa S.A.", 20.00);
        carteiraPJ1.adicionarInvestimento(acaoEmpresa);
        System.out.println(acaoEmpresa);

        fundoAna = new FundoInvestimento(pf1, 3000.00, "Fundo Renda Fixa DI", "12.345.678/0001-90", 0.015);
        carteiraPF1.adicionarInvestimento(fundoAna);
        System.out.println(fundoAna);

        fundoEmpresa = new FundoInvestimento(pj1, 15000.00, "Fundo Multimercado", "98.765.432/0001-21", 0.02);
        carteiraPJ1.adicionarInvestimento(fundoEmpresa);
        System.out.println(fundoEmpresa);

        try {
            debentureEmpresa = new Debenture(pj1, 8000.00, "Debênture XYZ", 0.12);
            carteiraPJ1.adicionarInvestimento(debentureEmpresa);
            System.out.println(debentureEmpresa);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar Debênture para Empresa: " + e.getMessage());
        }

        try {
            Investimento debentureInvalida = new Debenture(pf1, 2000.00, "Debênture ABC", 0.11);
            carteiraPF1.adicionarInvestimento(debentureInvalida);
        } catch (IllegalArgumentException e) {
            System.out.println("Teste de Validação (Debênture): " + e.getMessage());
        }

        System.out.println("\n--- Teste de adição de investimento com cliente diferente da carteira ---");
        Investimento tesouroCarlos = new TesouroPrefixado(pf2, 2000.00, "Tesouro Prefixado 2028", 0.08);
        carteiraPF1.adicionarInvestimento(tesouroCarlos);

        System.out.println("\n--- Saldo inicial das Carteiras ---");
        System.out.println("Carteira de " + carteiraPF1.getCliente().getNome() + " - Valor Total Investido: R$" + String.format("%.2f", carteiraPF1.calcularValorTotalInvestido()));
        carteiraPF1.exibirSaldosIndividuais();
        System.out.println("Carteira de " + carteiraPJ1.getCliente().getNome() + " - Valor Total Investido: R$" + String.format("%.2f", carteiraPJ1.calcularValorTotalInvestido()));
        carteiraPJ1.exibirSaldosIndividuais();

        System.out.println("\n--- Demonstrando Aplicação e Resgate ---");
        if (acaoAna != null) {
            acaoAna.aplicar(1000.00);
        }
        if (fundoEmpresa != null) {
            fundoEmpresa.resgatar(5000.00);
            fundoEmpresa.resgatar(20000.00); 
        }

        System.out.println("\n--- Saldo das Carteiras após Aplicação/Resgate ---");
        System.out.println("Carteira de " + carteiraPF1.getCliente().getNome() + " - Valor Total Investido: R$" + String.format("%.2f", carteiraPF1.calcularValorTotalInvestido()));
        carteiraPF1.exibirSaldosIndividuais();
        System.out.println("Carteira de " + carteiraPJ1.getCliente().getNome() + " - Valor Total Investido: R$" + String.format("%.2f", carteiraPJ1.calcularValorTotalInvestido()));
        carteiraPJ1.exibirSaldosIndividuais();

        int mesesParaSimular = 3;
        System.out.println("\n--- Simulando " + mesesParaSimular + " meses ---");
        for (int i = 0; i < mesesParaSimular; i++) {
            System.out.println("\n--- Mês " + (i + 1) + " ---");
            carteiraPF1.simularPassagemDeMesParaTodosInvestimentos();
            carteiraPJ1.simularPassagemDeMesParaTodosInvestimentos();

            System.out.println("\n--- Saldo ao final do Mês " + (i + 1) + " ---");
            System.out.println("Carteira de " + carteiraPF1.getCliente().getNome() + " - Valor Total Investido: R$" + String.format("%.2f", carteiraPF1.calcularValorTotalInvestido()));
            carteiraPF1.exibirSaldosIndividuais();
            System.out.println("Carteira de " + carteiraPJ1.getCliente().getNome() + " - Valor Total Investido: R$" + String.format("%.2f", carteiraPJ1.calcularValorTotalInvestido()));
            carteiraPJ1.exibirSaldosIndividuais();
        }

        System.out.println("\n--- Demonstração de Saldo Projetado ---");
        if (tesouroAna != null) {
            System.out.println("Tesouro Prefixado (Ana) - Saldo Projetado em 12 meses: R$" + String.format("%.2f", ((TesouroPrefixado)tesouroAna).calcularSaldoProjetado(12)));
        }
        if (acaoAna != null) {
            System.out.println("Ação (Ana) - Saldo Projetado em 6 meses: R$" + String.format("%.2f", ((AcaoBolsa)acaoAna).calcularSaldoProjetado(6)));
        }
        if (fundoEmpresa != null) {
            System.out.println("Fundo (Empresa) - Saldo Projetado em 24 meses: R$" + String.format("%.2f", ((FundoInvestimento)fundoEmpresa).calcularSaldoProjetado(24)));
        }
        if (debentureEmpresa != null) {
            System.out.println("Debênture (Empresa) - Saldo Projetado em 18 meses: R$" + String.format("%.2f", ((Debenture)debentureEmpresa).calcularSaldoProjetado(18)));
        }

        System.out.println("\n--- Fim da Simulação ---");
    }
}