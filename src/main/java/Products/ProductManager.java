package Products;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManager {
    List<Product> products = new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);
    }
    public void removeProduct(Product p){
        products.removeIf(product -> product.getId() == p.getId());
    }
    List<Product> getExpensiveProducts(){
        return products.stream().filter(p -> p.getPrice()>500).collect(Collectors.toList());

    }
}
