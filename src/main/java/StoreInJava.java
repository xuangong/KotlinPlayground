import java.util.ArrayList;
import java.util.List;

public class StoreInJava {
    private int id;

    private String name;

    private List<Product> products;

    public StoreInJava(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StoreInJava SetProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder("StoreInJava:name=" + name);
        for (Product product :
                products) {
            outString.append(";");
            outString.append(product.toString());
        }

        return outString.toString();
    }

    class Product {

        private String name;
        private int price;

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + price;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Product product = (Product) obj;

            if (price != product.price) {
                return false;
            }

            return name != null ? name.equals(product.name) : product.name == null;
        }

        @Override
        public String toString() {
            return "Product:name=" + name + ";price=" + price;
        }
    }

    public static void main(String[] args) {
//        List<ProductInKotlin> products = new List<>();
        ArrayList<ProductInKotlin> products = new ArrayList<>();
        products.add(new ProductInKotlin("Surface", 8888));
        products.add(new ProductInKotlin("Windows", 2333));
        StoreInKotlin store = new StoreInKotlin(1, "MS", products);
        System.out.println(store.getName());
        System.out.println(store);
    }
}

