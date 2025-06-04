class Product {
    private String name;
    private String category;
    private double price;
    private int quantity;
    private Supplier supplier;
    private Location location;

    public Product(String name, String category, double price, int quantity, Supplier supplier, Location location) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.location = location;
    }

    public void displayInfo() {
        System.out.println(name + " | " + category + " | ₮" + price + " | Qty: " + quantity);
        supplier.displaySupplierInfo();
        System.out.println("Location: " + location.getName());
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}