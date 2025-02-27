package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public Product delete(String productId);
    public Product edit(String id, Product product);
    public List<Product> findAll();
    public Product findById(String id);
}
