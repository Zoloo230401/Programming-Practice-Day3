import java.util.*;

class StockMove {
    private Product product;
    private int amount;
    private Location fromLocation;
    private Location toLocation;
    private Date date;

    public StockMove(Product product, int amount, Location fromLocation, Location toLocation) {
        this.product = product;
        this.amount = amount;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.date = new Date();
    }

    public void displayMove() {
        System.out.println("[" + date + "] Moved " + amount + " of " + product.getName()
                + " from " + fromLocation.getName() + " to " + toLocation.getName());
    }
}