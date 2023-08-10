package StreamOperations;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFiltering {

    public static void main(String[] args) {

        //Apply traditional approach using forloop :

        List<Product> list = new ArrayList<Product>();

        for (Product product : getProducts()) {
            if (product.getPrice() > 46000f) {
                list.add(product);
            }
        }

        for (Product product : list) {
            System.out.println(product);
        }

        System.out.println("-------------------------------------");

        //using stream api:
        List<Product> list2 = getProducts()
                .stream().filter(e -> e.getPrice() > 26000f)
                .collect(Collectors.toList());
        list2.forEach(System.out::println);

        System.out.println("************************************");
        //TODO: for example if you want to use for eachloop in above line and make them as a single line statement then use this:

        //getProducts().stream().filter(e -> e.getPrice() > 36000f).forEach(System.out::println);

        getProducts().stream().filter(e-> e.getPrice() %2 !=0).forEach(System.out::println);
        getProducts().stream().filter(e-> e.getPrice()>35000).forEach(System.out::println);
    }

    private static List<Product> getProducts() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1, "Dell", 36000f));
        productList.add(new Product(2, "HP", 56000f));
        productList.add(new Product(3, "Lenovo", 46000f));
        productList.add(new Product(4, "Acer", 26000f));
        productList.add(new Product(5, "Apple", 87f));
        return productList;

    }

    public static class Product {
        private int id;
        private String name;
        private float price;

        public Product(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}

