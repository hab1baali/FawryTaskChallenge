public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        for (CartItem item : cart.getProductitems()) {
            if (item.getProduct().isExpired()) {
                throw new IllegalStateException(item.getProduct().getName() + " is expired.");
            }
            if (item.getQuantity() > item.getProduct().getQuantity()) {
                throw new IllegalStateException(item.getProduct().getName() + " is out of stock.");
            }
        }

        double subtotal = cart.getSubtotal();
        double shippingFee = 30.0;
        double total = subtotal + shippingFee;

        if (customer.canAfford(total) == false) {
            throw new IllegalStateException("Insufficient balance.");
        }

        // Deduct quantities
        for (CartItem item : cart.getProductitems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getProductitems()) {
            if(item.isShippable()){
                System.out.println(item.getQuantity() + "X" + "\t" + item.getProduct().getName() + "\t" +  item.getTotalPrice());
            }

        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t" + subtotal);
        System.out.println("Shipping\t" + shippingFee);
        System.out.println("Amount\t\t" + total);
        double newBalance;
        if (total > customer.getBalance()) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        else {
            newBalance = customer.getBalance() - total;

        }

        System.out.println("Customer Balance\t" + newBalance);
    }
}
