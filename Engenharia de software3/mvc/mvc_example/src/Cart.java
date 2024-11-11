import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<CartItem> items = new ArrayList<>();
    private List<CartObserver> observers = new ArrayList<>();
    private DiscountStrategy discountStrategy = new NoDiscount(); // Estratégia padrão

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
        notifyObservers();
    }

    public void addItem(CartItem item) {
        items.add(item);
        notifyObservers();
    }

    public double getTotal() {
        double total = items.stream().mapToDouble(CartItem::getPrice).sum();
        return discountStrategy.applyDiscount(total);
    }

    public void addObserver(CartObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        double total = getTotal();
        for (CartObserver observer : observers) {
            observer.update(total);
        }
    }
}
