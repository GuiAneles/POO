class Emprestimo {
    private Cliente cliente;
    private Veiculo veiculo;

    public Emprestimo(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public double finalizar(int renovacoes) {
        veiculo.setDisponivel(true);
        int gratis = veiculo.getRenovacoesGratis();
        int excedente = Math.max(0, renovacoes - gratis);
        return veiculo.getValorLocacao() + excedente * veiculo.getValorMulta();
    }
}