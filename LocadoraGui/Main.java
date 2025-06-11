import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Locadora locadora = new Locadora("Locadora Boa Viagem", "Rua X, 123", "81 99999-9999");

        while (true) {
            String opcao = JOptionPane.showInputDialog("1 - Cadastrar Cliente\n2 - Cadastrar Veículo\n3 - Realizar Empréstimo\n4 - Finalizar Empréstimo\n0 - Sair");
            if (opcao == null || opcao.equals("0")) break;

            switch (opcao) {
                case "1":
                    String tipo = JOptionPane.showInputDialog("1 - Pessoa Física\n2 - Pessoa Jurídica");
                    String nome = JOptionPane.showInputDialog("Nome:");
                    String telefone = JOptionPane.showInputDialog("Telefone:");
                    String endereco = JOptionPane.showInputDialog("Endereço:");
                    if (tipo.equals("1")) {
                        String cpf = JOptionPane.showInputDialog("CPF:");
                        locadora.adicionarCliente(new PessoaFisica(nome, telefone, endereco, cpf));
                    } else {
                        String cnpj = JOptionPane.showInputDialog("CNPJ:");
                        String representante = JOptionPane.showInputDialog("Representante:");
                        locadora.adicionarCliente(new PessoaJuridica(nome, telefone, endereco, cnpj, representante));
                    }
                    break;
                case "2":
                    String cat = JOptionPane.showInputDialog("1 - Popular\n2 - SUV\n3 - Luxo");
                    String marca = JOptionPane.showInputDialog("Marca:");
                    String modelo = JOptionPane.showInputDialog("Modelo:");
                    String placa = JOptionPane.showInputDialog("Placa:");
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));
                    double valorLoc = Double.parseDouble(JOptionPane.showInputDialog("Valor Locação:"));
                    double valorMulta = Double.parseDouble(JOptionPane.showInputDialog("Valor Multa:"));

                    if (cat.equals("1")) {
                        boolean ar = JOptionPane.showInputDialog("Ar-condicionado? (s/n)").equalsIgnoreCase("s");
                        locadora.adicionarVeiculo(new CarroPopular(marca, modelo, placa, ano, valorLoc, valorMulta, ar));
                    } else if (cat.equals("2")) {
                        int portaMalas = Integer.parseInt(JOptionPane.showInputDialog("Tamanho porta-malas:"));
                        String tracao = JOptionPane.showInputDialog("Tipo tração:");
                        String combustivel = JOptionPane.showInputDialog("Tipo combustível:");
                        locadora.adicionarVeiculo(new CarroSUV(marca, modelo, placa, ano, valorLoc, valorMulta, portaMalas, tracao, combustivel));
                    } else {
                        int airBags = Integer.parseInt(JOptionPane.showInputDialog("Quantidade airbags:"));
                        int portaMalas = Integer.parseInt(JOptionPane.showInputDialog("Tamanho porta-malas:"));
                        boolean gps = JOptionPane.showInputDialog("Possui GPS? (s/n)").equalsIgnoreCase("s");
                        locadora.adicionarVeiculo(new CarroLuxo(marca, modelo, placa, ano, valorLoc, valorMulta, airBags, portaMalas, gps));
                    }
                    break;
                case "3":
                    String idCliente = JOptionPane.showInputDialog("Informe CPF/CNPJ do cliente:");
                    String placaEmp = JOptionPane.showInputDialog("Placa do veículo:");
                    Cliente cliente = locadora.buscarCliente(idCliente);
                    Veiculo veiculo = locadora.buscarVeiculo(placaEmp);
                    if (cliente == null || veiculo == null) {
                        JOptionPane.showMessageDialog(null, "Cliente ou veículo não encontrado.");
                    } else {
                        if (locadora.realizarEmprestimo(cliente, veiculo))
                            JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");
                        else
                            JOptionPane.showMessageDialog(null, "Não foi possível realizar o empréstimo.");
                    }
                    break;
                case "4":
                    String placaDevolucao = JOptionPane.showInputDialog("Placa do veículo:");
                    Emprestimo emp = locadora.buscarEmprestimoPorPlaca(placaDevolucao);
                    if (emp == null) {
                        JOptionPane.showMessageDialog(null, "Empréstimo não encontrado.");
                    } else {
                        int renovacoes = Integer.parseInt(JOptionPane.showInputDialog("Número de renovações:"));
                        double total = emp.finalizar(renovacoes);
                        JOptionPane.showMessageDialog(null, "Total a pagar: R$ " + total);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }
}