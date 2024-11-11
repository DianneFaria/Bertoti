public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        CartView view = new CartView();

        // Configura o observador
        cart.addObserver(view);

        CartController controller = new CartController(cart);

        // Adiciona itens ao carrinho
        controller.addItemToCart(new Product("Notebook", 2500));
        controller.addItemToCart(new Product("Mouse", 50));

        // Adiciona um pacote de produtos
        Package techBundle = new Package();
        techBundle.addItem(new Product("Teclado", 150));
        techBundle.addItem(new Product("Headset", 200));
        controller.addItemToCart(techBundle);

        // Aplica um desconto de 10%
        controller.applyDiscount(new PercentageDiscount(10));
    }
}
