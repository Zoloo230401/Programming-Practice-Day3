import java.util.*;
class Inventory {
    private List<Product> products = new ArrayList<>();
    private List<StockMove> stockMoves = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(String productName) {
        products.removeIf(p -> p.getName().equalsIgnoreCase(productName));
    }

    public void updateQuantity(String productName, int newQty) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                p.setQuantity(newQty);
                break;
            }
        }
    }

    public void displayAllProducts() {
        for (Product p : products) {
            p.displayInfo();
            System.out.println("---");
        }
    }

    public void searchProduct(String keyword) {
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                p.displayInfo();
                System.out.println("---");
            }
        }
    }

    public void moveStock(String productName, int amount, Location from, Location to) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                if (p.getLocation().getName().equals(from.getName()) && p.getQuantity() >= amount) {
                    p.setQuantity(p.getQuantity() - amount);
                    p.setLocation(to);
                    stockMoves.add(new StockMove(p, amount, from, to));
                    System.out.println("Stock moved successfully");
                } else {
                    System.out.println("Invalid location or insufficient quantity");
                }
                break;
            }
        }
    }

    public void displayStockMoves() {
        for (StockMove m : stockMoves) {
            m.displayMove();
        }
    }

    public void alertLowStock(int threshold) {
        for (Product p : products) {
            if (p.getQuantity() < threshold) {
                System.out.println("Low stock alert: " + p.getName() + " only has " + p.getQuantity() + " left.");
            }
        }
    }
}