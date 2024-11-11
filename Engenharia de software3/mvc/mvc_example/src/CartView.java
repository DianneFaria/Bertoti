class CartView implements CartObserver {
    @Override
    public void update(double total) {
        System.out.println("Total atualizado: R$ " + total);
    }
}
