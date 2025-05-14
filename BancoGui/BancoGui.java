
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BancoGui {

    static ArrayList<Conta> contas = new ArrayList<>();
    static int contadorContas = 1000;

    public static void main(String[] args) {
        while (true) {
            String opcao = JOptionPane.showInputDialog(
                    "BancoGui - Menu\n"
                    + "1. Criar Nova Conta\n"
                    + "2. Exibir Extrato De Uma Conta\n"
                    + "3. Sacar Valor De Uma Conta\n"
                    + "4. Depositar Em Uma Conta\n"
                    + "5. Transferir Valores\n"
                    + "6. Aplicar Rendimento (Conta Poupança)\n"
                    + "7. Sair\n"
                    + "Escolha Uma Opção:");

            if (opcao == null || opcao.equals("7")) {
                break;
            }

            switch (opcao) {
                case "1" ->
                    criarConta();
                case "2" ->
                    exibirExtrato();
                case "3" ->
                    sacar();
                case "4" ->
                    depositar();
                case "5" ->
                    transferir();
                case "6" ->
                    aplicarRendimento();
                default ->
                    JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        }
    }

    static void criarConta() {
        String tipoConta = JOptionPane.showInputDialog(
                "Tipo de Conta:\n"
                + "1. Conta Corrente\n"
                + "2. Conta Especial\n"
                + "3. Conta Poupança\n"
                + "4. Conta Empresarial\n"
                + "Escolha uma opção:");

        Cliente cliente = null;
        Conta conta = null;

        if (tipoConta.equals("4")) {
            String nome = JOptionPane.showInputDialog("Nome:");
            String cnpj = JOptionPane.showInputDialog("CNPJ:");
            String razaoSocial = JOptionPane.showInputDialog("Razão Social:");
            String senha = JOptionPane.showInputDialog("Senha:");
            cliente = new PessoaJuridica(nome, cnpj, razaoSocial, senha);
        } else {
            String nome = JOptionPane.showInputDialog("Nome:");
            String cpf = JOptionPane.showInputDialog("CPF:");
            String senha = JOptionPane.showInputDialog("Senha:");
            cliente = new PessoaFisica(nome, cpf, senha);
        }

        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Depósito Inicial:"));

        try {
            switch (tipoConta) {
                case "1" -> {
                    conta = new ContaCorrente(cliente, contadorContas++, saldo);
                    JOptionPane.showMessageDialog(null, "Conta Corrente Criada! Número: " + conta.getNumeroConta());
                }
                case "2" -> {
                    double chequeEspecial = Double.parseDouble(JOptionPane.showInputDialog("Valor do Cheque Especial:"));
                    conta = new ContaEspecial(cliente, contadorContas++, saldo, chequeEspecial);
                    JOptionPane.showMessageDialog(null, "Conta Especial Criada! Número: " + conta.getNumeroConta());
                }
                case "3" -> {
                    conta = new ContaPoupanca(cliente, contadorContas++, saldo);
                    JOptionPane.showMessageDialog(null, "Conta Poupança Criada! Número: " + conta.getNumeroConta());
                }
                case "4" -> {
                    double chequeEspecial = Double.parseDouble(JOptionPane.showInputDialog("Valor do Cheque Especial:"));
                    conta = new ContaEmpresarial(cliente, contadorContas++, saldo, chequeEspecial);
                    JOptionPane.showMessageDialog(null, "Conta Empresarial Criada! Número: " + conta.getNumeroConta());
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Tipo de conta inválido.");
                    return;
                }
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar conta: " + e.getMessage());
            return;
        }

        if (conta != null) {
            contas.add(conta);
        }
    }

    static void exibirExtrato() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Número Da Conta:"));
        Conta conta = buscarContaPorNumero(numero);

        if (conta != null) {
            Cliente cliente = conta.getCliente();
            String mensagem = "Extrato Da Conta\n"
                    + "Número: " + conta.getNumeroConta() + "\n"
                    + "Titular: " + cliente.getNome() + "\n"
                    + "Tipo: " + cliente.getTipo() + "\n"
                    + "Documento: " + cliente.getDocumento() + "\n"
                    + "Saldo: R$ " + conta.getSaldo();

            if (conta instanceof ContaEspecial) {
                ContaEspecial contaEspecial = (ContaEspecial) conta;
                mensagem += "\nCheque Especial: R$ " + contaEspecial.getChequeEspecial()
                        + "\nLimite Disponível: R$ " + contaEspecial.getLimiteDisponivel();
            }

            if (conta instanceof ContaEmpresarial) {
                ContaEmpresarial contaEmpresarial = (ContaEmpresarial) conta;
                PessoaJuridica pj = contaEmpresarial.getClientePJ();
                mensagem += "\nRazão Social: " + pj.getRazaoSocial();
            }

            JOptionPane.showMessageDialog(null, mensagem);
        } else {
            JOptionPane.showMessageDialog(null, "Conta Não Encontrada.");
        }
    }

    static void sacar() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Número Da Conta:"));
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor A Sacar:"));

        Conta conta = buscarContaPorNumero(numero);

        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Conta Não Encontrada.");
        } else if (conta.sacar(valor)) {
            JOptionPane.showMessageDialog(null, "Saque Efetuado Com Sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Saque Não Efetuado. Verifique O Saldo Ou Valor.");
        }
    }

    static void depositar() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Número Da Conta:"));
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor A Depositar:"));

        Conta conta = buscarContaPorNumero(numero);

        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Conta Não Encontrada.");
        } else if (conta.depositar(valor)) {
            JOptionPane.showMessageDialog(null, "Depósito Efetuado Com Sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Depósito Não Efetuado. Verifique O Valor.");
        }
    }

    static void transferir() {
        int origem = Integer.parseInt(JOptionPane.showInputDialog("Número Da Conta De Origem:"));
        int destino = Integer.parseInt(JOptionPane.showInputDialog("Número Da Conta Destino:"));
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor A Transferir:"));

        Conta cOrigem = buscarContaPorNumero(origem);
        Conta cDestino = buscarContaPorNumero(destino);

        if (cOrigem == null || cDestino == null) {
            JOptionPane.showMessageDialog(null, "Conta(s) Não Encontrada(s).");
        } else if (cOrigem.transferir(cDestino, valor)) {
            JOptionPane.showMessageDialog(null, "Transferência Realizada Com Sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Transferência Não Realizada. Verifique O Saldo Ou Valor.");
        }
    }

    static void aplicarRendimento() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Número Da Conta Poupança:"));
        Conta conta = buscarContaPorNumero(numero);

        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Conta Não Encontrada.");
        } else if (conta instanceof ContaPoupanca) {
            ContaPoupanca contaPoupanca = (ContaPoupanca) conta;
            double rendimento = contaPoupanca.aplicarRendimento();
            JOptionPane.showMessageDialog(null,
                    "Rendimento Aplicado Com Sucesso!\n"
                    + "Valor do Rendimento: R$ " + rendimento + "\n"
                    + "Novo Saldo: R$ " + contaPoupanca.getSaldo());
        } else {
            JOptionPane.showMessageDialog(null, "A conta selecionada não é uma Conta Poupança.");
        }
    }

    static Conta buscarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numero) {
                return conta;
            }
        }
        return null;
    }
}
