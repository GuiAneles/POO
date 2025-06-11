import java.util.ArrayList;

class Locadora {
    private String nome, endereco, telefone;
    private ArrayList<Veiculo> veiculos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public Locadora(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void adicionarVeiculo(Veiculo v) {
        veiculos.add(v);
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }

    public Cliente buscarCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getIdentificador().equals(id)) return c;
        }
        return null;
    }

    public Veiculo buscarVeiculo(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)) return v;
        }
        return null;
    }

    public boolean realizarEmprestimo(Cliente cliente, Veiculo veiculo) {
        if (!veiculo.estaDisponivel()) return false;
        if (!cliente.podeAlugarMais(emprestimos)) return false;

        veiculo.setDisponivel(false);
        emprestimos.add(new Emprestimo(cliente, veiculo));
        return true;
    }

    public Emprestimo buscarEmprestimoPorPlaca(String placa) {
        for (Emprestimo e : emprestimos) {
            if (e.getVeiculo().getPlaca().equals(placa)) return e;
        }
        return null;
    }

    public ArrayList<Veiculo> getVeiculosDisponiveis() {
        ArrayList<Veiculo> lista = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v.estaDisponivel()) lista.add(v);
        }
        return lista;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}