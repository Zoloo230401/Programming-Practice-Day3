public class Main {
    public static void main(String[] args) {
        Supplier s1 = new Supplier("IT Zone", "99112233");
        Supplier s2 = new Supplier("Mobile Store", "88112233");

        Location warehouse = new Location("Warehouse 1");
        Location branch = new Location("Salbar 2");

        Warehouse inventory = new Warehouse();

        Product laptop = new Product("Notebook", "Electron", 2500000, 10, s1, warehouse);
        Product phone = new Product("Mobile phone", "Electron", 1200000, 4, s2, warehouse);

        inventory.addProduct(laptop);
        inventory.addProduct(phone);

        System.out.println("--List of all products --");
        inventory.displayAllProducts();

        System.out.println("--Search: 'mobile number' --");
        inventory.searchProduct("утас");

        System.out.println("--Stock Movement --");
        inventory.moveStock("Mobile phone", 2, warehouse, branch);

        System.out.println("--All stock movements --");
        inventory.displayStockMoves();

        System.out.println("-- Stock warnings (minimum quantity: 5) --");
        inventory.alertLowStock(5);
    }
}