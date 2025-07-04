import java.util.List;

public class ShippingService {
    public static void ship(List<CartItem> items) {
        double totalWeight = 0;

        System.out.println("** Shipment notice **");
        for (CartItem item : items) {
            if(item.isShippable()){
                double weight = item.getProduct().getWeight() * item.getQuantity();
                String weightFormatted = (weight < 1000)
                        ? weight + "g"
                        : String.format("%.2fkg", weight / 1000.0);

                totalWeight += weight;
                System.out.println(item.getQuantity() + "X" + "\t" +  item.getProduct().getName() + "\t" + weightFormatted);
            }

        }

        String weightFormatted = (totalWeight < 1000)
                ? totalWeight + "g"
                : String.format("%.2fkg", totalWeight / 1000.0);

        System.out.println("Total package weight: " + weightFormatted);
        System.out.println();
    }
}
