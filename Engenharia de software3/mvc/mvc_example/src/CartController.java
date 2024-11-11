class CartController {
    private Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    public void addItemToCart(CartItem item) {
        cart.addItem(item);
    }

    public void applyDiscount(DiscountStrategy discountStrategy) {
        cart.setDiscountStrategy(discountStrategy);
    }
}
