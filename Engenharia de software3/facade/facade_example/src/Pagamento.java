class Pagamento {
    public boolean processarPagamento(String metodoPagamento, double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via " + metodoPagamento);
        return true; // Supondo que o pagamento foi bem-sucedido
    }
}
