import java.util.*;

/**
 * Агуулахын үйл ажиллагааг удирдах класс.
 * Бараа, нөөцийн хөдөлгөөнүүдийг хадгалж, удирддаг.
 */
class Warehouse {
    /** Барааны жагсаалт */
    private List<Product> products = new ArrayList<>();
    /** Нөөцийн хөдөлгөөний бүртгэл */
    private List<StockMove> stockMoves = new ArrayList<>();

    /**
     * Шинэ барааг агуулахад нэмнэ.
     * 
     * @param p Нэмэх бараа
     */
    public void addProduct(Product p) {
        products.add(p);
    }

    /**
     * Тухайн нэртэй барааг агуулахаас устгана.
     * 
     * @param productName Устгах барааны нэр
     */
    public void removeProduct(String productName) {
        products.removeIf(p -> p.getName().equalsIgnoreCase(productName));
    }

    /**
     * Тухайн нэртэй барааны үлдэгдэл тоог шинэчилнэ.
     * 
     * @param productName Шинэчлэх барааны нэр
     * @param newQty      Шинэ үлдэгдэл тоо
     */
    public void updateQuantity(String productName, int newQty) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                p.setQuantity(newQty);
                break;
            }
        }
    }

    /**
     * Агуулах дахь бүх барааны мэдээллийг дэлгэцэнд хэвлэнэ.
     */
    public void displayAllProducts() {
        for (Product p : products) {
            p.displayInfo();
            System.out.println("---");
        }
    }

    /**
     * Тухайн түлхүүр үгээр барааг хайж, мэдээллийг дэлгэцэнд харуулна.
     * 
     * @param keyword Хайлтын түлхүүр үг
     */
    public void searchProduct(String keyword) {
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                p.displayInfo();
                System.out.println("---");
            }
        }
    }

    /**
     * Барааны нөөцийг нэг байршлаас нөгөө байршил руу шилжүүлнэ.
     * 
     * @param productName Шилжүүлэх барааны нэр
     * @param amount      Шилжүүлэх тоо хэмжээ
     * @param from        Шилжүүлж байгаа эхний байршил
     * @param to          Шилжүүлэх байршил
     */
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

    /**
     * Нөөцийн хөдөлгөөнүүдийн бүртгэлийг дэлгэцэнд харуулна.
     */
    public void displayStockMoves() {
        for (StockMove m : stockMoves) {
            m.displayMove();
        }
    }

    /**
     * Барааны үлдэгдэл тухайн доод хязгаараас бага байвал анхааруулах мессеж
     * гаргана.
     * 
     * @param threshold Доод хязгаар (анхааруулах тоо хэмжээ)
     */
    public void alertLowStock(int threshold) {
        for (Product p : products) {
            if (p.getQuantity() < threshold) {
                System.out.println("Low stock alert: " + p.getName() + " only has " + p.getQuantity() + " left.");
            }
        }
    }
}
