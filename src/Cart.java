import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> productitems = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock for " + product.getName());
        }
        productitems.add(new CartItem(product, quantity));
    }

    public List<CartItem> getProductitems() {
        return productitems;
    }

    public boolean isEmpty() {
        return productitems.isEmpty();
    }

    public double getSubtotal() {
        double subtotal=0;
        for(CartItem item : productitems){
            if(item.isShippable()){
                subtotal+=item.getTotalPrice();
            }

        }
        return subtotal;
    }

}
