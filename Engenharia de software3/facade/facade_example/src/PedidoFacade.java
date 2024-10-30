class PedidoFacade {
    private Estoque estoque;
    private Pagamento pagamento;
    private Envio envio;

    public PedidoFacade() {
        this.estoque = new Estoque();
        this.pagamento = new Pagamento();
        this.envio = new Envio();
    }

    public void fazerPedido(String produto, String metodoPagamento, double valor) {
        if (estoque.verificarDisponibilidade(produto)) {
            if (pagamento.processarPagamento(metodoPagamento, valor)) {
                envio.enviarProduto(produto);
                System.out.println("Pedido concluído com sucesso!");
            } else {
                System.out.println("Falha no pagamento.");
            }
        } else {
            System.out.println("Produto não disponível.");
        }
    }
}