import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WarehouseTest {
    private Warehouse warehouse;
    private Product product1;
    private Product product2;
    private Supplier supplier;
    private Location loc1;
    private Location loc2;

    @Before
    public void setUp() {
        warehouse = new Warehouse();
        supplier = new Supplier("Test Supplier", "12345678");
        loc1 = new Location("Shelf A");
        loc2 = new Location("Shelf B");
        product1 = new Product("Laptop", "Electronics", 2500000.0, 10, supplier, loc1);
        product2 = new Product("Mouse", "Electronics", 50000.0, 3, supplier, loc1);
        warehouse.addProduct(product1);
        warehouse.addProduct(product2);
    }

    @Test
    public void testAddProduct() {
        Product product3 = new Product("Keyboard", "Electronics", 80000.0, 5, supplier, loc1);
        warehouse.addProduct(product3);
    }

    @Test
    public void testRemoveProduct() {
        warehouse.removeProduct("Laptop");
    }

    @Test
    public void testUpdateQuantity() {
        warehouse.updateQuantity("Laptop", 5);
        assertEquals(5, product1.getQuantity());
    }

    @Test
    public void testMoveStock() {
        warehouse.moveStock("Laptop", 2, loc1, loc2);
        assertEquals(8, product1.getQuantity());
        assertEquals("Shelf B", product1.getLocation().getName());
    }

    @Test
    public void testMoveStock_InvalidLocationOrQuantity() {
        warehouse.moveStock("Mouse", 10, loc1, loc2);
        assertEquals(3, product2.getQuantity());
        assertEquals("Shelf A", product2.getLocation().getName());
    }

    @Test
    public void testAlertLowStock() {
        warehouse.alertLowStock(4);
    }

    @Test
    public void testSearchProduct() {
        warehouse.searchProduct("laptop");
    }

    @Test
    public void testDisplayAllProducts() {
        warehouse.displayAllProducts();
    }

    @Test
    public void testDisplayStockMoves() {
        warehouse.moveStock("Laptop", 2, loc1, loc2);
        warehouse.displayStockMoves();
    }
}
