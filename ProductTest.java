import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testGetName() {
        Product product = createSampleProduct();
        assertEquals("Laptop", product.getName());
    }

    @Test
    public void testGetQuantity() {
        Product product = createSampleProduct();
        assertEquals(10, product.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        Product product = createSampleProduct();
        product.setQuantity(5);
        assertEquals(5, product.getQuantity());
    }

    @Test
    public void testGetLocation() {
        Location location = new Location("Warehouse A");
        Product product = new Product("Laptop", "Electronics", 1500.0, 10,
                new Supplier("IT Store", "99112233"), location);
        assertEquals(location, product.getLocation());
    }

    @Test
    public void testSetLocation() {
        Product product = createSampleProduct();
        Location newLocation = new Location("Warehouse B");
        product.setLocation(newLocation);
        assertEquals("Warehouse B", product.getLocation().getName());
    }

    @Test
    public void testDisplayInfo() {
        Product product = createSampleProduct();
        // displayInfo() prints output to console, so we assume no exception is thrown.
        // You could use System.setOut(...) to capture output, but that's optional here.
        product.displayInfo();
    }

    // Utility method to create a test Product
    private Product createSampleProduct() {
        Supplier supplier = new Supplier("IT Store", "99112233");
        Location location = new Location("Warehouse A");
        return new Product("Laptop", "Electronics", 1500.0, 10, supplier, location);
    }
}
