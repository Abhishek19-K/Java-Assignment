import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return productName + " x" + quantity + " = " + format(getTotal());
    }

    private String format(double value) {
        return value == (long) value ? String.valueOf((long) value) : String.valueOf(value);
    }
}

class Order {
    private String orderId;
    private List<Product> products = new ArrayList<>();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) total += p.getTotal();
        return total;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Order ID: " + orderId + "\nProducts:\n");
        for (Product p : products) s.append(p).append("\n");
        s.append("Total: ").append((long) calculateTotal());
        return s.toString();
    }
}

public class Q4_OnlineShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String orderId = sc.nextLine().trim();
        int n = Integer.parseInt(sc.nextLine().trim());
        Order order = new Order(orderId);

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().split(",");
            order.addProduct(new Product(p[0].trim(),
                    Double.parseDouble(p[1].trim()),
                    Integer.parseInt(p[2].trim())));
        }

        System.out.println(order);
        sc.close();
    }
}
