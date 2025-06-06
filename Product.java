/**
 * Барааны мэдээллийг хадгалах класс.
 * Энэхүү класс нь барааны нэр, төрөл, үнэ, үлдэгдэл тоо,
 * нийлүүлэгч болон байршлын мэдээллийг агуулна.
 */
public class Product {
    /** Барааны нэр */
    private String name;
    /** Барааны төрөл */
    private String category;
    /** Барааны үнэ */
    private double price;
    /** Барааны үлдэгдэл тоо */
    private int quantity;
    /** Барааг нийлүүлсэн нийлүүлэгч */
    private Supplier supplier;
    /** Барааны хадгалах байршил */
    private Location location;

    /**
     * Product объектийг үүсгэх конструктор.
     * 
     * @param name     Барааны нэр
     * @param category Барааны төрөл
     * @param price    Барааны үнэ
     * @param quantity Үлдэгдэл тоо
     * @param supplier Нийлүүлэгч объек
     * @param location Барааны байршил
     */
    public Product(String name, String category, double price, int quantity, Supplier supplier, Location location) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.location = location;
    }

    /**
     * Барааны мэдээллийг дэлгэцэнд хэвлэх.
     */
    public void displayInfo() {
        System.out.println(name + " | " + category + " | ₮" + price + " | Qty: " + quantity);
        supplier.displaySupplierInfo();
        System.out.println("Location: " + location.getName());
    }

    /**
     * Барааны нэрийг авах.
     * 
     * @return Барааны нэр
     */
    public String getName() {
        return name;
    }

    /**
     * Барааны үлдэгдэл тоог авах.
     * 
     * @return Үлдэгдэл тоо
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Барааны үлдэгдэл тоог шинэчлэх.
     * 
     * @param quantity Шинэ үлдэгдэл тоо
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Барааны хадгалах байршлыг авах.
     * 
     * @return Location объект
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Барааны хадгалах байршлыг шинэчлэх.
     * 
     * @param location Шинэ байршил
     */
    public void setLocation(Location location) {
        this.location = location;
    }
}
