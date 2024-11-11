import java.util.ArrayList;
import java.util.List;

class Package implements CartItem {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        return items.stream().mapToDouble(CartItem::getPrice).sum();
    }
}
