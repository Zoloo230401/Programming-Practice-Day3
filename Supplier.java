
class Supplier {
    private String name;
    private String phone;

    public Supplier(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void displaySupplierInfo() {
        System.out.println("Supplier: " + name + ", Phone: " + phone);
    }
}