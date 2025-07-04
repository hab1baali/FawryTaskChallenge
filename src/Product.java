import java.time.LocalDate;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean shippable;
    private double weight; // in grams
    private LocalDate expiryDate;

    public Product(String name, double price, int quantity, boolean shippable, double weight, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.shippable = shippable;
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        if(expiryDate !=null && expiryDate.isBefore(LocalDate.now())){
            return true;
        }
        else{
            return false;
        }
    }

    // Getters and setters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean isShippable() { return shippable; }
    public double getWeight() { return weight; }
    public LocalDate getExpiryDate() { return expiryDate; }

    public void reduceQuantity(int amount) {
        quantity -= amount;
    }
}
