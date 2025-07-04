import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 5, true, 200, LocalDate.now().plusDays(5));
        Product biscuits = new Product("Biscuits", 150, 2, true, 700, LocalDate.now().plusDays(10));
        Product scratchCard = new Product("Mobile Scratch Card", 50, 10, false, 0, null);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        Customer customer = new Customer(500);
        ShippingService.ship(cart.getProductitems());
        CheckoutService.checkout(customer, cart);
    }
}
