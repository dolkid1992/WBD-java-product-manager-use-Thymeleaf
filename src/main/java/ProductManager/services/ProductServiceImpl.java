package ProductManager.services;

import ProductManager.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone", 24000000, "New"));
        products.put(2, new Product(2, "TV Sony", 15000000, "New"));
        products.put(3, new Product(3, "Quan", 1100000, "New"));
        products.put(4, new Product(4, "Ao", 500000, "New"));
        products.put(5, new Product(5, "LapTop", 17000000, "New"));
        products.put(6, new Product(6, "Noi Com", 1500000, "New"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
