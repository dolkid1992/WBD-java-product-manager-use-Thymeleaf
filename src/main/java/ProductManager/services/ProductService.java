package ProductManager.services;

import ProductManager.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    int save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
